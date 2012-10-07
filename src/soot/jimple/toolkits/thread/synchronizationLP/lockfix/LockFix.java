package soot.jimple.toolkits.thread.synchronizationLP.lockfix;

import java.util.*;

import junit.framework.Assert;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.BiPartitegraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;

import Drivers.Java4Jimple;

import soot.*;
import soot.util.Chain;
import soot.JastAddJ.Frontend;
import soot.coffi.constant_element_value;
import soot.jimple.*;
import soot.jimple.toolkits.pointer.*;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.mhp.MhpTester;
import soot.jimple.toolkits.thread.mhp.SynchObliviousMhpAnalysis;




import soot.jimple.toolkits.thread.synchronizationLP.CriticalSectionInterferenceGraph;
import soot.jimple.toolkits.thread.synchronizationLP.LockableReferenceAnalysis;
import soot.jimple.toolkits.thread.synchronizationLP.NewStaticLock;
import soot.jimple.toolkits.thread.synchronizationLP.Cooccur.Cooccur;
import soot.jimple.toolkits.thread.synchronizationLP.StmtView.StmtGrouping;
import soot.jimple.toolkits.thread.synchronizationLP.StmtView.StmtGroupingViaAnode;
import soot.jimple.toolkits.thread.synchronizationLP.lockorder.LockOrderCollapse;
import soot.jimple.toolkits.thread.synchronizationLP.lockorder.LockOrderRecorder;
import soot.jimple.toolkits.thread.synchronizationLP.lockorder.LockOrderTriple;
import soot.jimple.toolkits.callgraph.*;
import soot.jimple.toolkits.infoflow.*;
import soot.jimple.spark.pag.*;
import soot.jimple.spark.sets.*;
import soot.toolkits.scalar.*;
import soot.toolkits.graph.*;

public class LockFix extends SceneTransformer
{
	



    public static HashMap<Object, Set> dns = new HashMap<Object, Set>();
	private static final String synSeparator = ":";
	//=================control variables :
public static HashMap<Object, Set> base2Group = new HashMap<Object, Set>();
public static BiPartitegraph< Object, DefaultEdge> biG= new BiPartitegraph<Object, DefaultEdge>(DefaultEdge.class);
	public  static StmtGrouping stmtGrouping = new StmtGroupingViaAnode(); 
    public LockFix(){}
    public static ThreadLocalObjectsAnalysis g_tlo =null ;
//    public static LockFix v() 
//	{ 
//		return G.v().instance_soot_jimple_toolkits_thread_LockFix();
//	}
    
    List<CriticalSection> mhpCriticalSections = null;
    public List<CriticalSection> criticalSections = null;
    CriticalSectionInterferenceGraph interferenceGraph = null;
    DirectedGraph deadlockGraph = null;
    
    public Map<List, LockOrderCollapse> component2LockCollapse= new HashMap<List, LockOrderCollapse>();
	
	// Lock options
	boolean optionOneGlobalLock = false;
	boolean optionStaticLocks = false;
	boolean optionUseLocksets = false;
	boolean optionLeaveOriginalLocks = false;
	boolean optionIncludeEmptyPossibleEdges = false;
	
	// Semantic options
	boolean optionAvoidDeadlock = true;
	boolean optionOpenNesting = true;	
	
	// Analysis options
	boolean optionDoMHP = true;
	boolean optionDoTLO = true;
	boolean optionOnFlyTLO = false; // not a CLI option yet // on-fly is more efficient, but harder to measure in time
	
	// Output options
	boolean optionPrintMhpSummary = true; // not a CLI option yet
	boolean optionPrintGraph = true;
	boolean optionPrintTable = true;
	boolean optionPrintDebug = true;
	String lockingScheme= "medium-grained";
//set directly please, for research purpose
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "locking-scheme:medium-grained");
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "avoid-deadlock:true");
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "open-nesting:true");
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "do-mhp:true");
//	 
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "do-tlo:true"); 
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "print-graph:true");
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "print-table:true");
//	 PhaseOptions.v().setPhaseOption("wjtp.tnlp", "print-debug:true");
	
    protected void internalTransform(String phaseName, Map options)
	{
		// Get phase options
		if(lockingScheme.equals("fine-grained"))
		{
			optionOneGlobalLock = false;
			optionStaticLocks = false;
			optionUseLocksets = true;
			optionLeaveOriginalLocks = false;
		}
//		if(lockingScheme.equals("fine-static"))
//		{
//			optionOneGlobalLock = false;
//			optionStaticLocks = true;
//			optionUseLocksets = true;
//			optionLeaveOriginalLocks = false;
//		}
		if(lockingScheme.equals("medium-grained")) // rename to coarse-grained
		{
			optionOneGlobalLock = false;
			optionStaticLocks = false;
			optionUseLocksets = false;
			optionLeaveOriginalLocks = false;
		}
		if(lockingScheme.equals("coarse-grained")) // rename to coarse-static
		{
			optionOneGlobalLock = false;
			optionStaticLocks = true;
			optionUseLocksets = false;
			optionLeaveOriginalLocks = false;
		}
		if(lockingScheme.equals("single-static"))
		{
			optionOneGlobalLock = true;
			optionStaticLocks = true;
			optionUseLocksets = false;
			optionLeaveOriginalLocks = false;
		}
		if(lockingScheme.equals("leave-original"))
		{
			optionOneGlobalLock = false;
			optionStaticLocks = false;
			optionUseLocksets = false;
			optionLeaveOriginalLocks = true;
		}
		
	
		// *** Build May Happen In Parallel Info ***
		MhpTester mhp = null;
		if(optionDoMHP && Scene.v().getPointsToAnalysis() instanceof PAG)
		{
	    	G.v().out.println("[wjtp.tn] *** Build May-Happen-in-Parallel Info *** " + (new Date()));
			mhp = new SynchObliviousMhpAnalysis();
			if(optionPrintMhpSummary)
			{
				mhp.printMhpSummary();
			}
		}
		


		// *** Find Thread-Local Objects ***
		ThreadLocalObjectsAnalysis tlo = null;
    	if(optionDoTLO)
    	{
	    	G.v().out.println("[wjtp.tn] *** Find Thread-Local Objects *** " + (new Date()));
	    	if(mhp != null)
	    		tlo = new ThreadLocalObjectsAnalysis(mhp);
			else
	    		tlo = new ThreadLocalObjectsAnalysis(new SynchObliviousMhpAnalysis());
	    	if(!optionOnFlyTLO)
	    	{
		    	tlo.precompute();
	    		G.v().out.println("[wjtp.tn] TLO totals (#analyzed/#encountered): " + SmartMethodInfoFlowAnalysis.counter + "/" + ClassInfoFlowAnalysis.methodCount);
		    }
	    	else
	    		G.v().out.println("[wjtp.tn] TLO so far (#analyzed/#encountered): " + SmartMethodInfoFlowAnalysis.counter + "/" + ClassInfoFlowAnalysis.methodCount);
    	}



    	// *** Find and Name Transactions ***
    	// The transaction finder finds the start, end, and preparatory statements
    	// for each transaction. It also calculates the non-transitive read/write 
    	// sets for each transaction.
    	// For all methods, run the intraprocedural analysis (TransactionAnalysis)
		Date start = new Date();
    	G.v().out.println("[wjtp.tn] *** Find and Name Transactions *** " + start);
    	Map<SootMethod, FlowSet> methodToFlowSet = new HashMap<SootMethod, FlowSet>();
    	Map<SootMethod, ExceptionalUnitGraph> methodToExcUnitGraph = new HashMap<SootMethod, ExceptionalUnitGraph>();
    	Iterator runAnalysisClassesIt = Scene.v().getApplicationClasses().iterator();
    	while (runAnalysisClassesIt.hasNext()) 
    	{
    		
    	    SootClass appClass = (SootClass) runAnalysisClassesIt.next();
//    	    if(appClass.toString().contains("jrockit.")||appClass.toString().contains("com.bea.jrockit."))
//    	    {
//    	    	System.out.println("!!!!!!!!!!!!!!!!!!");
//    	    	continue;
//    	    }
    	    Iterator methodsIt = appClass.getMethods().iterator();
    	    while (methodsIt.hasNext())
    	    {
    	    	SootMethod method = (SootMethod) methodsIt.next();
				if(method.isConcrete())
				{
	    	    	Body b = method.retrieveActiveBody();
	    	    	ExceptionalUnitGraph eug = new ExceptionalUnitGraph(b);
    		    	methodToExcUnitGraph.put(method, eug);
    		    	
    	    		// run the intraprocedural analysis  I want to know here!
    				LockFixSynchronizedRegionFinder ta = new LockFixSynchronizedRegionFinder(eug, b, optionPrintDebug, optionOpenNesting, tlo);
    				Chain units = b.getUnits();
    				Unit lastUnit = (Unit) units.getLast();
    				FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
    			
    				// add the results to the list of results
    				methodToFlowSet.put(method, fs);
				}
    	    }
    	}    	
    	
    	// Create a composite list of all transactions
    	criticalSections = new Vector<CriticalSection>();
    	for(FlowSet fs : methodToFlowSet.values())
    	{
    		List fList = fs.toList();
    		for(int i = 0; i < fList.size(); i++)
    			criticalSections.add(((LockFixSynchronizedRegionFlowPair) fList.get(i)).tn);
    	}

    	
    	// Assign Names To Transactions
		assignNamesToTransactions(criticalSections);

    	if(optionOnFlyTLO)
    	{
    		G.v().out.println("[wjtp.tn] TLO so far (#analyzed/#encountered): " + SmartMethodInfoFlowAnalysis.counter + "/" + ClassInfoFlowAnalysis.methodCount);
    	}

    	

    	// *** Find Transitive Read/Write Sets ***
    	// Finds the transitive read/write set for each transaction using a given
    	// nesting model.
    	G.v().out.println("[wjtp.tn] *** Find Transitive Read/Write Sets *** " + (new Date()));
    	PointsToAnalysis pta = Scene.v().getPointsToAnalysis();
    	CriticalSectionAwareSideEffectAnalysis tasea = null;
		tasea = new CriticalSectionAwareSideEffectAnalysis(
					pta, 
					Scene.v().getCallGraph(), (optionOpenNesting ? criticalSections : null), tlo);
    	Iterator<CriticalSection> tnIt = criticalSections.iterator();
    	while(tnIt.hasNext())
    	{   // foreach transaction
    		// tn.read,stmtRead: CodeBlockRWSet: fields: field-> pointtoset
    		
    		CriticalSection tn = tnIt.next();
    		for(Unit unit : tn.invokes)
    		{
    			Stmt stmt = (Stmt) unit;
    			HashSet uses = new HashSet();
    			

    			RWSet stmtRead = tasea.readSet(tn.method, stmt, tn, uses);
    			//========
    			tn.addReadSet4Stmt(stmt, stmtRead);
    			//========
    			
    			// for each target, nonTTRead(target)
    			// for the stmt itself, directly update the stmtRead easily.
    			if(stmtRead != null)
	    			tn.read.union(stmtRead);
    		//	while(true) // for debug
    			
    			RWSet stmtWrite = tasea.writeSet(tn.method, stmt, tn, uses);
				if(stmtWrite != null)
					tn.write.union(stmtWrite);			
    			
    			//========
    			tn.addWriteSet4Stmt(stmt, stmtWrite);
    			//========
    			tn.addBase4Stmt(stmt, uses);
    			//========
    		}
    	}
    	long longTime = ((new Date()).getTime() - start.getTime()) / 100;
    	float time = ((float) longTime) / 10.0f;
    	if(optionOnFlyTLO)
    	{
    		G.v().out.println("[wjtp.tn] tTLO totals (#analyzed/#encountered): " + SmartMethodInfoFlowAnalysis.counter + "/" + ClassInfoFlowAnalysis.methodCount);
			G.v().out.println("[wjtp.tn] Time for stages utilizing on-fly TLO: " + time + "s");
    	}

    	
    	//================now ,we can collect the who-protect-who information:
    	Iterator<CriticalSection> css =criticalSections.iterator();
    	while (css.hasNext()) {
			CriticalSection criticalSection = (CriticalSection) css.next();
			List origLockStack = new ArrayList();// 0-> expand...  lou!			
			Object origLock=  criticalSection.origLock;
			Assert.assertTrue(origLock!=null);			
			origLockStack.add(origLock);
			while(criticalSection.parent!=null)
			{
				CriticalSection parent = criticalSection.parent;
				Object parentLock =parent.origLock;
				Assert.assertTrue(parentLock!=null);				
				origLockStack.add(parentLock);				
			}
			
			Iterator<Unit> unitIT= criticalSection.units.iterator();
			while (unitIT.hasNext()) {
				Unit unit = (Unit) unitIT.next();
				Set basesSet=criticalSection.unitToBases.get(unit);
				if(basesSet==null) continue;
				for(Object o:basesSet)
				{
					quickAddEdge(biG,o,origLockStack);// the front is X
				}
				
			}
		}
    	//=============================the bipartite graph is built now...
    	// partition into alias group, for each alias pair, the lock is must alias!
    	// that is also the connection of an alias group!
    	 HashSet<Object> X= biG.getX();
    	 List Xlist = new ArrayList();
    	 for(Object o:X)
    	 {
    		 Xlist.add(o);
    	 }
    	 
    	 PointsToAnalysis pAnalysis= Scene.v().getPointsToAnalysis();
    	 //multiple edges are permitted.
    	 Pseudograph<Object, DefaultEdge> connectG= new Pseudograph<Object, DefaultEdge>(DefaultEdge.class);
    	 for(int i=0;i<Xlist.size()-1;i++)
    	 {
    		 Object base1= Xlist.get(i);
//    		 Assert.assertTrue(base1 instanceof Local);// wrong assumption!
    		 PointsToSet base1_P2S =  getPointToSet(base1);
    		//  PointsToSet base1_P2S=  pAnalysis.reachingObjects((Local)base1); 
    		 for(int j=i+1; j<Xlist.size();j++)
    		 {
    			 Object base2= Xlist.get(j);
//    			 PointsToSet base2_P2S=  pAnalysis.reachingObjects(base2); 
    			 PointsToSet base2_P2S =  getPointToSet(base2);
        		if(base1_P2S.hasNonEmptyIntersection(base2_P2S))
        		{
        			quickAddEdge(connectG, base1, base2);
        		}   			 
    		 }
    	 }
    	 //get the alias group
 		ConnectivityInspector cI= new ConnectivityInspector( connectG);
 		List<Set> connecteds = cI.connectedSets();
 		for(Set connected:connecteds)
 		{
 			for(Object base:connected)
 			{
 				base2Group.put(base, connected);
 			}
 		}
 		
 		//=====================================
 		
 		for(Set connected:connecteds)
 		{
 			nationalAffair(connected);// election-style: the biggest ,with lock frequent > 50%,win. 
 		}
    	 //============================finishes....
 		//do a little test, then leave this toy!!!!!!!!!
 		
           
        


    	
	}
    
    private PointsToSet getPointToSet(Object base1) {
    	PointsToAnalysis p2Analysis = Scene.v().getPointsToAnalysis();
    	// I think base1 must be value: local, staticfieldref, instancefieldref
		if(base1 instanceof Local)
		{
			Local ll = (Local)base1;
			return p2Analysis.reachingObjects(ll);		
		}
		else if(base1 instanceof StaticFieldRef)
		{
			StaticFieldRef sfr=(StaticFieldRef)base1;
			SootField sf = sfr.getField();
			return p2Analysis.reachingObjects(sf);
			
		}
		else if(base1 instanceof InstanceFieldRef)
		{
			InstanceFieldRef ifr = (InstanceFieldRef)base1;
			Value base= ifr.getBase();
			SootField ifield = ifr.getField();
	      return p2Analysis.reachingObjects((Local)base, ifield);
		}
		else  if(base1 instanceof  ArrayRef)// arrayref means it is the ref if an array! no relationship with the elements
		{
			ArrayRef arrayRef= (ArrayRef)base1;
		    Value arraybase =	arrayRef.getBase();
		    return p2Analysis.reachingObjects((Local)arraybase);
		}
		else {
			Assert.assertTrue(1==0);
		}
		return null;
	}

	private void nationalAffair(Set connected) {
    	// suppose the lock is all static-lock at present, we may extend the locks by the abstraction, this..
    	boolean solved= false;
    	int level=0;// stack level to consider
    	boolean expandable= true;
        Map lastMap = null;
    	while(!solved&&expandable)
    	{
    		level++;
    		Map lockReleInLevel_2_freq= statistic(connected, level);
    		Object winnerLock = whoIsOverHalf(lockReleInLevel_2_freq);
    		if(winnerLock!=null)
    		{
    			solved=true;
    			System.out.println("the district:  "+ connected + "\n select "+ winnerLock +"\nas a must-lock!(commander)");
// you can traverse the static field to search the one correpsonds to this anode! simple
    			// not useful: $r1, $r2
//    		    System.out.println("for convenient: (pick any one from the below, they only has one anode, but the anode has many such variables)");
//    		    Set originalLocals = dns.get(winnerLock);
//    		    for(Object o:originalLocals)
//    		    {
//    		    	System.out.print(" "+o);
//    		    }
    		}
    		if(expandable(lastMap, lockReleInLevel_2_freq))
    			expandable=true;
    		lastMap=lockReleInLevel_2_freq;   		
    	}
    	if(!solved)
    	{
    		System.out.println("the set is not expandable, but still no result of the election comes out, change a strategy???");
    		System.exit(1);
    		
    		
    	}
	
    	
	
}

	private boolean expandable(Map lastMap, Map lockReleInLevel_2Freq) {
		if(lastMap==null) return true;
		int lastKeysize = lastMap.keySet().size();
		int lastSumCount = 0;
	    for(Object ii: lastMap.values())
	    {
	    	lastSumCount+=(Integer)ii;
	    }
	    
	    int  thisKeysize = lockReleInLevel_2Freq.keySet().size();
	    int thisSumCount =0;
	    for(Object ii: lockReleInLevel_2Freq.values())
	    {
	    	thisSumCount+=(Integer)ii;
	    }
	    
	    if(lastKeysize<thisKeysize || lastSumCount< thisSumCount)
	    	return true;
	    else {
	    	Assert.assertTrue(lastKeysize<=thisKeysize && lastSumCount<=thisSumCount);// increase only. or remains the same
	    	return false;
		}
		
	}

	private Object whoIsOverHalf(Map lockReleInLevel_2Freq) {
		// you can change to different political strategy: the most is more than 30% than the second most..
		
		Iterator<Object> key = lockReleInLevel_2Freq.keySet().iterator();
		int maxCount=0;
		Object maxLock = null;
		
		int sum=0;
		while (key.hasNext()) {
			Object object = (Object) key.next();
			Integer count =(Integer) lockReleInLevel_2Freq.get(object);
			sum+=count;
			if(count > maxCount)
				{maxCount = count;
				  maxLock = object;				
				}
				
		}
		if(2*maxCount >=sum)
		{return maxLock;}
		else {
			return null;
		}
	}

	private Map statistic(Set connected, int level) {
		final Map lock2Freq = new HashMap();
	    Iterator it = connected.iterator();
	    while (it.hasNext()) {
			Object object = (Object) it.next();
			Set<DefaultEdge> edges = biG.edgesOf(object);// stacks relevatn
			for(DefaultEdge edge :edges)// multiple edges are allowed! so correct.
			{
				Object oneEnd= biG.getEdgeSource(edge);
				Object otherEnd= biG.getEdgeTarget(edge);// get the lock stack
				List lockStack =null;
				if(oneEnd instanceof List)
				{
					lockStack=(List) oneEnd;
				}
				else {
					Assert.assertTrue(otherEnd instanceof List);
					lockStack = (List) otherEnd;
				}
				//=================
				for(int i=1;i<=level;i++)// level =1...
				{
					if(i-1>=lockStack.size()) break;// break the internal loop, no need to conitnue...
					final Object origLock =lockStack.get(i-1);// index from 0

					Assert.assertTrue(origLock instanceof Local);// ???
					PointsToAnalysis p2Analysis = Scene.v().getPointsToAnalysis();
					PointsToSetInternal p2Internal = (PointsToSetInternal)p2Analysis.reachingObjects((Local)origLock);
					Assert.assertTrue(p2Internal.size()==1);
					p2Internal.forall(new P2SetVisitor() {
						
						@Override
						public void visit(Node n) {
							// TODO Auto-generated method stub
							registerOnce(lock2Freq,n);// must-alias, so one anode, no matter what name is it.
						    // for name serach! lock, lock2 may be the smae anode!
							if(!dns.containsKey(n))
							{
								dns.put(n, new HashSet());
							}
							dns.get(n).add(origLock);// the origlock has only this one anode!(verified!)
						}
					});
					
					
				}			
				
			}
			
		}
	    
	    return lock2Freq;
	    // after the election, let us decide who is over half:
	    
		
	}

	private void registerOnce(Map lock2Freq, Object lockWithinLevel) {
	  if(!lock2Freq.containsKey(lockWithinLevel))
	  {
		  lock2Freq.put(lockWithinLevel, 0);
	  }
	  Integer value = (Integer) lock2Freq.get(lockWithinLevel);
	  lock2Freq.put(lockWithinLevel, ++value);
	  // 3->4
	  // 0-> 1
		
	}

	// yes, connect the use to the list of prepstmt(the priority is naturally encoded in the list!)
	public void quickAddEdge(AbstractGraph<Object, DefaultEdge> biG2, Object o,
		Object prepStack) {
	      if(!biG2.containsVertex(o)) biG2.addVertex(o);
	      if(!biG2.containsVertex(prepStack)) biG2.addVertex(prepStack);
	      if(!biG2.containsEdge(o, prepStack)) biG2.addEdge(o, prepStack);
	      
	
}

	private void reportJavaAndLocks(String javaline, List redLockList) {
		int sep= javaline.indexOf(synSeparator);
		String abspath = javaline.substring(0, sep);
		String lineNO= javaline.substring(sep+1, javaline.length());
		int lineNO_int= Integer.valueOf(lineNO);// Integer.getInteger(lineNO);
		String corrLine= Java4Jimple.getJavaLine(abspath, lineNO_int);
		
		
		 System.out.print( corrLine+" | ");
		 for(Object oo:redLockList)
		 {
			 if(oo==null) 
			 {
				 Assert.assertTrue(1==0);
			 }
			 System.out.print(oo.toString()+", ");
		 }
		 System.out.println();
	
}

	private Map getJavaline2Locks(Map<Object, List<Object>> unit2RedlocksCooccur,
		Map unit2SootClass) {
		   Map java2Locks= new HashMap();
	       Iterator units=   unit2RedlocksCooccur.keySet().iterator();
		   while (units.hasNext()) {
				Object object = (Object) units.next();
				Assert.assertTrue(object instanceof Unit);
				Unit unit = (Unit)object;
				List unitLockList = unit2RedlocksCooccur.get(unit);
				SootClass unitClass = (SootClass) unit2SootClass.get(unit);
		         String abspath= Java4Jimple.getAbsPath(unitClass);
		         int lineNO= Java4Jimple.getLineNo(unit);
		         String javaline = abspath+synSeparator+lineNO;// use this, not the content!
		         if(!java2Locks.containsKey(javaline))
		         {
		        	 java2Locks.put(javaline, new ArrayList());
		         }
		        List javaLockList= (List) java2Locks.get(javaline);
		        javaLockList.addAll(unitLockList);		
		}
		   return java2Locks;
}

	public void reportUnitAndLocks(SootClass csClass, Unit unit, List<Object> repLocks) {
         String abspath= Java4Jimple.getAbsPath(csClass);
         int lineNO= Java4Jimple.getLineNo(unit);
		 String corrLine = Java4Jimple.getJavaLine(abspath, lineNO);
		 System.out.print(unit + " | "+ corrLine+" | ");
		 for(Object oo:repLocks)
		 {
			 if(oo==null) 
			 {
				 Assert.assertTrue(1==0);
			 }
			 System.out.print(oo.toString()+", ");
		 }
		 System.out.println();
		 
	
    }

	public List<Object> getRepLocks_accessSCC(LockOrderCollapse loc, List<Object> locks) {
	   List<Object> ret = new ArrayList<Object>();
	   for(Object lock:locks)
	   {
		   Object rep = loc.getRep(lock);
		   ret.add(rep);
	   }
		
	return ret;
}




	public HashSet<SootClass> allClassesRelated(CodeBlockRWSet withAllOtherTNs) {
		Set<SootField> sf = withAllOtherTNs.getGlobals();
		HashSet<SootClass> rele = new HashSet<SootClass>();
		Iterator<SootField> sfIT = sf.iterator();
		while (sfIT.hasNext()) {
			SootField sootField = (SootField) sfIT.next();
			Assert.assertTrue(sootField.isStatic());
			rele.add(sootField.getDeclaringClass());		
		}
		
		return rele;
	}

	public PointsToSet allAnodesRelated(CodeBlockRWSet withAllOtherTNs) {
		   Set<SootField> fields = withAllOtherTNs.getFields();
	       Iterator<SootField> fieldIT = fields.iterator();
	       int  iterate =0; 
	       PointsToSet firstOne  = null;
	       while (fieldIT.hasNext()) {
			SootField sootField = (SootField) fieldIT.next();
		
			PointsToSet  fPointsToSet = withAllOtherTNs.getBaseForField(sootField);
		    if(iterate==0) firstOne =fPointsToSet;
		    else {
		    	Assert.assertTrue(firstOne instanceof PointsToSetInternal);
		    	Assert.assertTrue(fPointsToSet instanceof PointsToSetInternal);
				((PointsToSetInternal)firstOne).mergeWith((PointsToSetInternal)fPointsToSet);
			}
		    iterate++;
		    
		   }
	       return  firstOne;
	}











	public static String locksetToLockNumString(List<EquivalentValue> lockset, Map<Value, Integer> lockToLockNum)
	{
		if( lockset == null ) return "null";
		String ret = "[";
		boolean first = true;
		for( EquivalentValue lockEqVal : lockset )
		{
			if(!first) 
				ret = ret + " ";
			first = false;
			ret = ret + lockToLockNum.get(lockEqVal.getValue());
		}
		return ret + "]";
	}
    
    public void assignNamesToTransactions(List<CriticalSection> AllTransactions)
    {
       	// Give each method a unique, deterministic identifier
       	// Sort transactions into bins... one for each method name
       	
       	// Get list of method names
    	List<String> methodNamesTemp = new ArrayList<String>();
    	Iterator<CriticalSection> tnIt5 = AllTransactions.iterator();
    	while (tnIt5.hasNext()) 
    	{
    	    CriticalSection tn1 = tnIt5.next();
    	    String mname = tn1.method.getSignature(); //tn1.method.getSignature() + "." + tn1.method.getName();
    	    if(!methodNamesTemp.contains(mname))
    	    	methodNamesTemp.add(mname);
		}
		String methodNames[] = new String[1];
		methodNames = methodNamesTemp.toArray(methodNames);
		Arrays.sort(methodNames);

		// Initialize method-named bins
		// this matrix is <# method names> wide and <max txns possible in one method> + 1 tall
		int identMatrix[][] = new int[methodNames.length][CriticalSection.nextIDNum - methodNames.length + 2];
		for(int i = 0; i < methodNames.length; i++)
		{
			identMatrix[i][0] = 0;
			for(int j = 1; j < CriticalSection.nextIDNum - methodNames.length + 1; j++)
			{
				identMatrix[i][j] = 50000;
			}
		}
		
		// Put transactions into bins
    	Iterator<CriticalSection> tnIt0 = AllTransactions.iterator();
    	while(tnIt0.hasNext())
    	{
    		CriticalSection tn1 = tnIt0.next();
			int methodNum = Arrays.binarySearch(methodNames, tn1.method.getSignature());
			identMatrix[methodNum][0]++;
			identMatrix[methodNum][identMatrix[methodNum][0]] = tn1.IDNum;
    	}
    	
    	// Sort bins by transaction IDNum
    	// IDNums vary, but always increase in code-order within a method
    	for(int j = 0; j < methodNames.length; j++)
    	{
    		identMatrix[j][0] = 0; // set the counter to 0 so it sorts out (into slot 0).
    		Arrays.sort(identMatrix[j]); // sort this subarray
		}
		
		// Generate a name based on the bin number and location within the bin
    	Iterator<CriticalSection> tnIt4 = AllTransactions.iterator();
    	while(tnIt4.hasNext())
    	{
    		CriticalSection tn1 = tnIt4.next();
			int methodNum = Arrays.binarySearch(methodNames, tn1.method.getSignature());
			int tnNum = Arrays.binarySearch(identMatrix[methodNum], tn1.IDNum) - 1;
    		tn1.name = "m" + (methodNum < 10? "00" : (methodNum < 100? "0" : "")) + methodNum + "n" + (tnNum < 10? "0" : "") + tnNum;
    	}
	}	



	public List<CriticalSection> getCriticalSections() {
		return criticalSections;
	}
	
	public static void main(String[] args)
	{
		String javaline = "hel:3"; 
		int sep= javaline.indexOf(synSeparator);
		String abspath = javaline.substring(0, sep);
		String lineNO= javaline.substring(sep+1, javaline.length());
		int lineNO_int= Integer.valueOf(lineNO);// Integer.getInteger(lineNO);
		String corrLine= Java4Jimple.getJavaLine(abspath, lineNO_int);
		System.out.println(corrLine);
		
	}
}
