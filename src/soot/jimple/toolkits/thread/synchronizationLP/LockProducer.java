package soot.jimple.toolkits.thread.synchronizationLP;

import java.util.*;

import junit.framework.Assert;

import org.jgrapht.graph.BiPartitegraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;

import Drivers.Java4Jimple;

import soot.*;
import soot.util.Chain;
import soot.coffi.constant_element_value;
import soot.jimple.*;
import soot.jimple.toolkits.pointer.*;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.mhp.MhpTester;
import soot.jimple.toolkits.thread.mhp.SynchObliviousMhpAnalysis;
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

public class LockProducer extends SceneTransformer
{

	private boolean specjbb= true;
	private static final String processname = "transform";
	private static final String  transactionname = "TransformerImpl";

	public List<CriticalSection> outerMostCSList = new ArrayList<CriticalSection>();

	private static final String synSeparator = ":";

	//=================control variables :
	public static  boolean option_cooccur = true;
	public static  boolean option_javabased_reduction = true;
	
	
	
	
	//=======================
	public  static StmtGrouping stmtGrouping = new StmtGroupingViaAnode(); 
    public LockProducer(Singletons.Global g){}
    public static ThreadLocalObjectsAnalysis g_tlo =null ;
    public static LockProducer v() 
	{ 
		return G.v().soot_jimple_toolkits_thread_synchronizationLP_LockAllocator();
	}
    
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
	public boolean optionOpenNesting = true;	
	
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
    	    if(appClass.getName().contains("Transform"))
    	    	System.out.println(appClass);
    	    System.out.println();
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
    				SynchronizedRegionFinder ta = new SynchronizedRegionFinder(eug, b, optionPrintDebug, optionOpenNesting, tlo);
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
    			criticalSections.add(((SynchronizedRegionFlowPair) fList.get(i)).tn);
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


    	
//====================================================================  
//=========================== outermost css
    	
    	for(int i= 0; i<criticalSections.size();i++)
    	{
    		CriticalSection item = criticalSections.get(i);
    		Local ll = (Local)item.origLock;
    		PointsToAnalysis p2a =Scene.v().getPointsToAnalysis();
    		PointsToSet p2s= p2a.reachingObjects(ll);
    		Set<Type> types =p2s.possibleTypes();
    		boolean areUIn = false;
    		for(Type tt:types)
    		{
    			if(tt.toString().contains("DaShaBi"))
    				areUIn=true;
    				
    		}
    	//	outerMostCSList.add(item);
    		if(areUIn)
    		{
    			outerMostCSList.add(item);
    		}
    	}
//=========================== cs components
    //	criticalSections =null; // for safety, wait for the nullexception 
    //	BiPartitegraph<V, E>
    	Pseudograph< CriticalSection, DefaultEdge> graph = new Pseudograph<CriticalSection, DefaultEdge>(DefaultEdge.class);
    	Iterator<CriticalSection> csIT  = outerMostCSList.iterator();
    	while (csIT.hasNext()) {
			CriticalSection criticalSection = (CriticalSection) csIT.next();		   
			graph.addVertex(criticalSection);			
		}
    	for(int i=0;i<outerMostCSList.size()-1;i++)// max_index= size-2 
    	{
    		CriticalSection outer = outerMostCSList.get(i);
    		for(int j=i+1;j<outerMostCSList.size();j++)
    		{
    			CriticalSection inner = outerMostCSList.get(j);
    			if(mhp.mayHappenInParallel(outer.method, inner.method))
    			{
    				graph.addEdge(outer, inner);
    			}
    			
    		}
    	}
    	List<Set<CriticalSection>> comps  =  graph.weaklyConnectedComponents();

    	
//===========================inter-component make up for self-conflicting, input: comps    	
       	List<List<CriticalSection>> comps_variant = new ArrayList<List<CriticalSection>>();
    	for(int i=0;i<comps.size();i++)
       	{
       		Set<CriticalSection> comp = comps.get(i);
       		List<CriticalSection> upgradedComp = new ArrayList<CriticalSection>();
       		Iterator<CriticalSection> itemIT = comp.iterator();
       		while (itemIT.hasNext()) {
				CriticalSection item = (CriticalSection) itemIT
						.next();
				upgradedComp.add(item);
				if(mhp.mayHappenInParallel(item.method, item.method))
				{
					upgradedComp.add(item);// add it again!
				}
       		}
       	// 	comp.addAll(toAddForComp);// no point for hashset at all 
       		comps_variant.add(upgradedComp);       		
       	}
       	System.out.println("postdebug");
    	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!until nowm 
    	//we have the correct cs, and the component hosting conflicting css.
       	// List<List<Critical Section>>.
//=========================== inter-component conflicting detection
       	for(int i=0;i< comps_variant.size(); i++)
       	{
       		List<CriticalSection> compAndSelf = comps_variant.get(i);
       		detectConflictsForEachCS(compAndSelf);// put it into  each tn's unitToCSDDs
       	}
    	
//============================store the unitToPointToSet, unitToClassses
       	//===========================
       	//!!!!!!!!!!!!!!!!!!!no need for statemetn granularity now!
       	//it turns to be extremely easy.
       	for(int i=0;i< comps_variant.size(); i++)
       	{
       		List<CriticalSection> compAndSelf = comps_variant.get(i);
       		storeSummaryForEachUnitInCS(compAndSelf);// put it into  each tn's unitToCSDDs
       	}
    	
//============================map to the group, and then to locks
       	for(int i=0;i< comps_variant.size(); i++)
       	{
       		List<CriticalSection> compAndSelf = comps_variant.get(i);
       		map2Groups2Locks(compAndSelf);// 
       	}      	
//============================decide an order, and merge the groups.
       	for(int i=0;i< comps_variant.size(); i++)
       	{
       		System.out.println();
       		Set<LockOrderTriple> comp_orders = new HashSet<LockOrderTriple>();
       		
       		List<CriticalSection> compAndSelf = comps_variant.get(i);
       		for(int j=0;j<compAndSelf.size();j++)
       		{
       			CriticalSection csInAComp = compAndSelf.get(j);
       			SootMethod hostMethod = csInAComp.method;
       			UnitGraph csGraph = null;
       			if(hostMethod.hasActiveBody())
       			{
       				 csGraph = new ExceptionalUnitGraph(hostMethod.getActiveBody());       				
       			}
       			else {
					Assert.assertTrue(1==0);
				}
       			
       			LockOrderRecorder lor = new LockOrderRecorder(csGraph, csInAComp);   
       			comp_orders.addAll(lor.getNoodelView());//   lor.noodelView			
       		}
       		// for this component:
       		// each lock should be got through getRep();!!!
       		LockOrderCollapse loc = new LockOrderCollapse();
       		
       		DefaultDirectedGraph ddgTmp = loc.encodeAsGraph3(comp_orders);
       		DefaultDirectedGraph merged = loc.mergeSCC(ddgTmp);
       		
       		if(!component2LockCollapse.containsKey(compAndSelf))
       		component2LockCollapse.put(compAndSelf, loc);
       		// avoid teh second time..  
       	} 
       	
       	
       	
       	
       	
//============================print out the jimple and groups together    	
    	//unit2locks unit2classes
       	Map unit2LockList = new HashMap();
       	Map unit2SootClass = new HashMap();
       	for(int i=0;i<comps_variant.size();i++)
       	{
       		List<CriticalSection> compAndSelf = comps_variant.get(i);
       		LockOrderCollapse loc = (LockOrderCollapse) component2LockCollapse.get(compAndSelf);
       		for(int j=0;j<compAndSelf.size();j++)
       		{
       			CriticalSection cs = compAndSelf.get(j);
       			SootClass csClass= cs.method.getDeclaringClass();
       			Iterator<Unit> unitIT= cs.units.iterator();
       			while (unitIT.hasNext()) {
					Unit unit = (Unit) unitIT.next();
					List<Object> locks=stmtGrouping.locks4StmtViaGroup(cs, unit);
					List<Object> repLocks = getRepLocks_accessSCC(loc,locks);	
				//	reportUnitAndLocks(csClass,unit, repLocks);
					if(unit2LockList.containsKey(unit))
					{// for safety only:
						int rel= Cooccur.dominateRel((List)unit2LockList.get(unit), repLocks);
					    if(rel!=0)
					    {Assert.assertTrue(1==0);
					    // have a look, different locks for the same unit, should be context-insensitive
					    }
					}
					unit2LockList.put(unit, repLocks);
					unit2SootClass.put(unit, csClass);
					// System.out.println();
				}
       			
       			
       		
       		}
       	}
 //===========================================jimplebased co-occur reduction.       	
       	Map<Object, List<Object>> unit2Redlocks_cooccur=null;
       	if(option_cooccur)
       	{
       		Cooccur.printIt(unit2LockList);
       		System.out.println("=================================");
       		unit2Redlocks_cooccur=  Cooccur.completeStory(unit2LockList);
       		Iterator it =unit2Redlocks_cooccur.keySet().iterator();
        	while (it.hasNext()) {
        	
    			Object key = (Object) it.next();
    			Assert.assertTrue(key instanceof Unit);
    			
    			List<Object> redLocks= unit2Redlocks_cooccur.get(key);
    			SootClass sc =(SootClass) unit2SootClass.get(key);
    			Assert.assertTrue(sc!=null);
    			reportUnitAndLocks(sc, (Unit)key, redLocks);
    			
    		}
       	}
       	else {
			unit2Redlocks_cooccur=unit2LockList;
			Iterator it =unit2Redlocks_cooccur.keySet().iterator();
	    	while (it.hasNext()) {
	    	
				Object key = (Object) it.next();
				Assert.assertTrue(key instanceof Unit);
				
				List<Object> redLocks= unit2Redlocks_cooccur.get(key);
				SootClass sc =(SootClass) unit2SootClass.get(key);
				Assert.assertTrue(sc!=null);
				reportUnitAndLocks(sc, (Unit)key, redLocks);
				
			}
		}
    	
    	
    	
//=============================java-based co-occur reduction!
       	//============second-level reduction, based on java
    	if(option_javabased_reduction)
    	{
    		
    		System.out.println("============javaversion:================");
    		Map java2Locks= getJavaline2Locks(unit2Redlocks_cooccur,unit2SootClass);
    		Map java2RedLocks = Cooccur.completeStory(java2Locks);
    		Iterator javaIT= java2RedLocks.keySet().iterator();
    		while (javaIT.hasNext()) {
				Object object = (Object) javaIT.next();
				List redLockList=(List) java2RedLocks.get(object);
				reportJavaAndLocks((String)object, redLockList);
				
			}
    		
    	}
    	
       	
       	
       	
//===============================stop!
    	
    	//stop here:
    	System.exit(1);

       
        // one-line missing checking..
		


    	// *** Calculate Locking Groups ***
    	// Search for data dependencies between transactions, and split them into disjoint sets
    	G.v().out.println("[wjtp.tn] *** Calculate Locking Groups *** " + (new Date()));
    	CriticalSectionInterferenceGraph ig = 
    		new CriticalSectionInterferenceGraph(
    				criticalSections, mhp, optionOneGlobalLock,
    				optionLeaveOriginalLocks, optionIncludeEmptyPossibleEdges);
    	interferenceGraph = ig; // save in field for later retrieval
    	
    	
    	
		// *** Detect the Possibility of Deadlock ***
		G.v().out.println("[wjtp.tn] *** Detect the Possibility of Deadlock *** " + (new Date()));
		DeadlockDetector dd = new DeadlockDetector(optionPrintDebug, optionAvoidDeadlock, true, criticalSections);
		if(!optionUseLocksets) // deadlock detection for all single-lock-per-region allocations
			deadlockGraph = dd.detectComponentBasedDeadlock();

		

		// *** Calculate Locking Objects ***
    	// Get a list of all dependencies for each group
    	G.v().out.println("[wjtp.tn] *** Calculate Locking Objects *** " + (new Date()));
		if(!optionStaticLocks)
		{
			// Calculate per-group contributing RWSet
			// (Might be preferable to use per-transaction contributing RWSet)
			for(CriticalSection tn : criticalSections)
	    	{
	    		if(tn.setNumber <= 0)
	    			continue;
	    		for(CriticalSectionDataDependency tdd : tn.edges)
	    			tn.group.rwSet.union(tdd.rw);
	    	}
	    }

		// Inspect each group's RW dependencies to determine if there's a possibility
		// of a shared lock object (if all dependencies are fields/localobjs of the same object)
		Map<Value, Integer> lockToLockNum = null;
		List<PointsToSetInternal> lockPTSets = null;
		if(optionLeaveOriginalLocks)
		{
			analyzeExistingLocks(criticalSections, ig);
		}
		else if(optionStaticLocks)
		{
			setFlagsForStaticAllocations(ig);
		}
		else // for locksets and dynamic locks
		{
			setFlagsForDynamicAllocations(ig);

			// Data structures for determining lock numbers
			lockPTSets = new ArrayList<PointsToSetInternal>();
			lockToLockNum = new HashMap<Value, Integer>();

			findLockableReferences(criticalSections, pta, tasea, lockToLockNum,lockPTSets);

			// print out locksets
			if(optionUseLocksets)
			{
				for( CriticalSection tn : criticalSections )
				{
					if( tn.group != null )
					{
						G.v().out.println("[wjtp.tn] " + tn.name + " lockset: " + locksetToLockNumString(tn.lockset, lockToLockNum) + (tn.group.useLocksets ? "" : " (placeholder)"));
					}
				}
			}
		}

		
		
		// *** Detect the Possibility of Deadlock for Locksets ***
		if(optionUseLocksets) // deadlock detection and lock ordering for lockset allocations
		{
			G.v().out.println("[wjtp.tn] *** Detect " + (optionAvoidDeadlock ? "and Correct " : "") + "the Possibility of Deadlock for Locksets *** " + (new Date()));
			deadlockGraph = dd.detectLocksetDeadlock(lockToLockNum, lockPTSets);
			if(optionPrintDebug)
				((HashMutableEdgeLabelledDirectedGraph) deadlockGraph).printGraph();
		
			G.v().out.println("[wjtp.tn] *** Reorder Locksets to Avoid Deadlock *** " + (new Date()));
			dd.reorderLocksets(lockToLockNum, (HashMutableEdgeLabelledDirectedGraph) deadlockGraph);
		}
		
		// *** Print Output and Transform Program ***
    	G.v().out.println("[wjtp.tn] *** Print Output and Transform Program *** " + (new Date()));

		// Print topological graph in graphviz format
		if(optionPrintGraph)
			printGraph(criticalSections, ig, lockToLockNum);

		// Print table of transaction information
		if(optionPrintTable)
		{
			printTable(criticalSections, mhp);
			printGroups(criticalSections, ig);
		}

    	// For all methods, run the lock transformer
		if(!optionLeaveOriginalLocks)
		{
	    	// Create an array of booleans to keep track of which global locks have been inserted into the program
			boolean[] insertedGlobalLock = new boolean[ig.groupCount()];
			insertedGlobalLock[0] = false;
			for(int i = 1; i < ig.groupCount(); i++)
			{
				CriticalSectionGroup tnGroup = ig.groups().get(i);
				insertedGlobalLock[i] = (!optionOneGlobalLock) && (tnGroup.useDynamicLock || tnGroup.useLocksets);
			}
			
			for(SootClass appClass : Scene.v().getApplicationClasses())
			{
	    	    for(SootMethod method : appClass.getMethods())
	    	    {
					if(method.isConcrete())
					{
	    		    	FlowSet fs = methodToFlowSet.get(method);
	    	    		if(fs != null) // (newly added methods need not be transformed)
	    	    			LockAllocationBodyTransformer.v().internalTransform(method.getActiveBody(), fs, ig.groups(), insertedGlobalLock); 
					}
	    	    }
	    	}
	    }
	}
    
	private void reportJavaAndLocks(String javaline, List redLockList) {
		int sep= javaline.indexOf(synSeparator);
		String abspath = javaline.substring(0, sep);
		String lineNO= javaline.substring(sep+1, javaline.length());
		int lineNO_int= Integer.valueOf(lineNO);// Integer.getInteger(lineNO);
		String corrLine= Java4Jimple.getJavaLine(abspath, lineNO_int);
		
		
		 String  fileName = abspath.substring(abspath.lastIndexOf("/"));
		 // ugly code , ban it
//		if(!fileName.contains("Transaction"))  return;
		if(redLockList==null) return ;
		if(redLockList.size()==0) return;
		 System.out.print( fileName+" "+lineNO_int +":"+ corrLine+" | ");
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

	public void map2Groups2Locks(List<CriticalSection> compAndSelf) {
		for(int i=0;i<compAndSelf.size();i++)
		{
			CriticalSection itemCurr = compAndSelf.get(i);
			List<Unit> csUnits = itemCurr.units;
			for(int j=0;j<csUnits.size();j++)
			{
				Unit csUnit = csUnits.get(j);
				stmtGrouping.locks4StmtViaGroup(itemCurr, csUnit);	// assign group, and assign locks for groups.			
			}

		}	
}

	public void storeSummaryForEachUnitInCS(List<CriticalSection> compAndSelf) {
	for(int i=0;i<compAndSelf.size();i++)
	{
		CriticalSection itemCurr = compAndSelf.get(i);
		if((itemCurr.unitToPoint2S.keySet().size()!=0)&& (itemCurr.unitToClasses.keySet().size()!=0))
		{
			// obviously, this tn has been visited
			 continue;
		}
		List<Unit> csUnits = itemCurr.units;
	    for(int j=0;j<csUnits.size(); j++)
	    {
	    	Unit csUnit = csUnits.get(j);
	    	RWSet withAllOtherTNs  = mergeConflicts4EachUnit(itemCurr,csUnit);
	    	Assert.assertTrue(withAllOtherTNs instanceof CodeBlockRWSet);
	    	Map fields = ((CodeBlockRWSet)withAllOtherTNs).fields;
	    	Set  globals =  ((CodeBlockRWSet)withAllOtherTNs).globals;
	    	
	        PointsToSet allAnodesInUnit = allAnodesRelated((CodeBlockRWSet)withAllOtherTNs);
	    	itemCurr.addP2SForUnit(csUnit, allAnodesInUnit);
	    	Set<SootClass> allClassesInUnit = allClassesRelated((CodeBlockRWSet)withAllOtherTNs);
	    	itemCurr.addClassesForUnit(csUnit,allClassesInUnit);	    	
	    }
	}
	
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
			Object sootField =  fieldIT.next();// no need to transform to the sootField type ,\
			// the getBaseForFields can work smoothly!
		
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

	public RWSet mergeConflicts4EachUnit(CriticalSection itemCurr, Unit csUnit) {
	     Set<CriticalSectionDataDependency> csdds = itemCurr.unitToCSDDs.get(csUnit);
	     RWSet withAllOtherTNs  = new CodeBlockRWSet();
	     if(csdds==null) return withAllOtherTNs;
	     Iterator<CriticalSectionDataDependency> csddIT = csdds.iterator();
	     while (csddIT.hasNext()) {
			CriticalSectionDataDependency csddTmp = (CriticalSectionDataDependency) csddIT
					.next();
			withAllOtherTNs.union(csddTmp.rw);			
		}
		return  withAllOtherTNs;
		
	}

	public void detectConflictsForEachCS(List<CriticalSection> compAndSelf) {

	 for(int i= 0;i<compAndSelf.size() -1; i++)
	 {
		 CriticalSection itemCurr = compAndSelf.get(i);
		 List<Unit> csUnits = itemCurr.units;// I change the set-> list, the insertion order is kept.
         for(int j=0;j<csUnits.size();j++)
         {
        	Unit csUnit =  csUnits.get(j);
        	CodeBlockRWSet unitReadSet = itemCurr.unitToReadSet.get(csUnit); 
        	CodeBlockRWSet unitWriteSet = itemCurr.unitToWriteSet.get(csUnit); 
        	if(unitReadSet==null) unitReadSet = new CodeBlockRWSet();
        	if(unitWriteSet==null) unitWriteSet = new CodeBlockRWSet(); // non-null then..
	        	for(int k=i+1; k<compAndSelf.size();k++)
	  		 {
	   			 CriticalSection csAnother = compAndSelf.get(k);// (i,k)
                 RWSet ww = unitWriteSet.intersection(csAnother.write);
                 RWSet wr = unitWriteSet.intersection(csAnother.read);
                 RWSet rw  = unitReadSet.intersection(csAnother.write);
                 ww.union(wr); ww.union(rw);
                 RWSet  ww_wr_rw = ww;
                 CriticalSectionDataDependency csdd = new CriticalSectionDataDependency(csAnother, -1, ww_wr_rw);// I do not need the size
                 itemCurr.addCSDDSet4Stmt(csUnit, csdd);  			 
	   		 }
            	
         }
         

	 }
	  
	  
	  
	  
	  
}




	protected void findLockableReferences(List<CriticalSection> AllTransactions,
			PointsToAnalysis pta, CriticalSectionAwareSideEffectAnalysis tasea,
			Map<Value, Integer> lockToLockNum,
			List<PointsToSetInternal> lockPTSets) {
		// For each transaction, if the group's R/Ws may be fields of the same object, 
		// then check for the transaction if they must be fields of the same RUNTIME OBJECT
		Iterator<CriticalSection> tnIt9 = AllTransactions.iterator();
		while(tnIt9.hasNext())
		{
			CriticalSection tn = tnIt9.next();
			
			int group = tn.setNumber - 1;
			if(group < 0)
				continue;
					
			if(tn.group.useDynamicLock || tn.group.useLocksets) // if attempting to use a dynamic lock or locksets
			{
				
				// Get list of objects (FieldRef or Local) to be locked (lockset analysis)
				G.v().out.println("[wjtp.tn] * " + tn.name + " *");
				LockableReferenceAnalysis la = new LockableReferenceAnalysis(new BriefUnitGraph(tn.method.retrieveActiveBody()));
				tn.lockset = la.getLocksetOf(tasea, tn.group.rwSet, tn);
				
				// Determine if list is suitable for the selected locking scheme
				// TODO check for nullness
				if(optionUseLocksets)
				{
					// Post-process the locksets
					if(tn.lockset == null || tn.lockset.size() <= 0)
					{
						// If the lockset is invalid, revert the entire group to static locks:
						tn.group.useLocksets = false;
						
						// Create a lockset containing a single placeholder static lock for each tn in the group
						Value newStaticLock = new NewStaticLock(tn.method.getDeclaringClass());
						EquivalentValue newStaticLockEqVal = new EquivalentValue(newStaticLock);
						for(CriticalSection groupTn : tn.group)
						{
							groupTn.lockset = new ArrayList<EquivalentValue>();
							groupTn.lockset.add(newStaticLockEqVal);
						}

						// Assign a lock number to the placeholder
						Integer lockNum = new Integer(-lockPTSets.size()); // negative indicates a static lock
						G.v().out.println("[wjtp.tn] Lock: num " + lockNum + " type " + newStaticLock.getType() + " obj " + newStaticLock);
						lockToLockNum.put(newStaticLockEqVal, lockNum);
						lockToLockNum.put(newStaticLock, lockNum);
						PointsToSetInternal dummyLockPT = new HashPointsToSet(newStaticLock.getType(), (PAG) pta); // KILLS CHA-BASED ANALYSIS (pointer exception)
						lockPTSets.add(dummyLockPT);
					}
					else
					{
						// If the lockset is valid
						// Assign a lock number for each lock in the lockset
						for( EquivalentValue lockEqVal : tn.lockset )
						{
							Value lock = lockEqVal.getValue();
							
							// Get reaching objects for this lock
							PointsToSetInternal lockPT;
							if(lock instanceof Local)
								lockPT = (PointsToSetInternal) pta.reachingObjects((Local) lock);
							else if(lock instanceof StaticFieldRef) // needs special treatment: could be primitive
								lockPT = null;
							else if(lock instanceof InstanceFieldRef)
							{
								Local base = (Local) ((InstanceFieldRef) lock).getBase();
								if(base instanceof FakeJimpleLocal)
									lockPT = (PointsToSetInternal) pta.reachingObjects(((FakeJimpleLocal)base).getRealLocal(), ((FieldRef) lock).getField());
								else
									lockPT = (PointsToSetInternal) pta.reachingObjects(base, ((FieldRef) lock).getField());
							}
							else if(lock instanceof NewStaticLock) // placeholder for anything that needs a static lock
								lockPT = null;
							else
								lockPT = null;
								
							if( lockPT != null )
							{
								// Assign an existing lock number if possible
								boolean foundLock = false;
								for(int i = 0; i < lockPTSets.size(); i++)
								{
									PointsToSetInternal otherLockPT = lockPTSets.get(i);
									if(lockPT.hasNonEmptyIntersection(otherLockPT)) // will never happen for empty, negative numbered sets
									{
										G.v().out.println("[wjtp.tn] Lock: num " + i + " type " + lock.getType() + " obj " + lock);
										lockToLockNum.put(lock, new Integer(i));
										otherLockPT.addAll(lockPT, null);
										foundLock = true;
										break;
									}
								}
								
								// Assign a brand new lock number otherwise
								if(!foundLock)
								{
									G.v().out.println("[wjtp.tn] Lock: num " + lockPTSets.size() + " type " + lock.getType() + " obj " + lock);
									lockToLockNum.put(lock, new Integer(lockPTSets.size()));
									PointsToSetInternal otherLockPT = new HashPointsToSet(lockPT.getType(), (PAG) pta);
									lockPTSets.add(otherLockPT);
									otherLockPT.addAll(lockPT, null);
								}
							}
							else // static field locks and pathological cases...
							{
								// Assign an existing lock number if possible
								if( lockToLockNum.get(lockEqVal) != null )
								{
									Integer lockNum = lockToLockNum.get(lockEqVal);
									G.v().out.println("[wjtp.tn] Lock: num " + lockNum + " type " + lock.getType() + " obj " + lock);
									lockToLockNum.put(lock, lockNum);
								}
								else
								{
									Integer lockNum = new Integer(-lockPTSets.size()); // negative indicates a static lock
									G.v().out.println("[wjtp.tn] Lock: num " + lockNum + " type " + lock.getType() + " obj " + lock);
									lockToLockNum.put(lockEqVal, lockNum);
									lockToLockNum.put(lock, lockNum);
									PointsToSetInternal dummyLockPT = new HashPointsToSet(lock.getType(), (PAG) pta);
									lockPTSets.add(dummyLockPT);
								}
							}
						}

					}
				}
				else
				{
					if(tn.lockset == null || tn.lockset.size() != 1)
					{// Found too few or too many locks
						// So use a static lock instead
						tn.lockObject = null;
						tn.group.useDynamicLock = false;
						tn.group.lockObject = null;
					}
					else
					{// Found exactly one lock
						// Use it!
						tn.lockObject = (Value) tn.lockset.get(0);
						
						// If it's the best lock we've found in the group yet, use it for display
						if(tn.group.lockObject == null || tn.lockObject instanceof Ref)
							tn.group.lockObject = tn.lockObject;
					}
				}
			}
		}
		if(optionUseLocksets)
		{
			// If any lock has only a singleton reaching object, treat it like a static lock
			for(int i = 0; i < lockPTSets.size(); i++)
			{
				PointsToSetInternal pts = lockPTSets.get(i);
				if(pts.size() == 1 && false) // isSingleton(pts)) // It's NOT easy to find a singleton: single alloc node must be run just once
				{
					for(Object e : lockToLockNum.entrySet())
					{
						Map.Entry entry = (Map.Entry) e;
						Integer value = (Integer) entry.getValue();
						if(value == i)
						{
							entry.setValue(new Integer(-i));
						}
					}
				}
			}
		}
	}
	public void setFlagsForDynamicAllocations(CriticalSectionInterferenceGraph ig) {
		for(int group = 0; group < ig.groupCount() - 1; group++)
		{
			CriticalSectionGroup tnGroup = ig.groups().get(group + 1);

			if(optionUseLocksets)
			{
				tnGroup.useLocksets = true; // initially, guess that this is true
			}
			else
			{
				tnGroup.isDynamicLock = (tnGroup.rwSet.getGlobals().size() == 0);
				tnGroup.useDynamicLock = true;
				tnGroup.lockObject = null;
			}

			// empty groups don't get locks
			if(tnGroup.rwSet.size() <= 0) // There are no edges in this group
			{
				if(optionUseLocksets)
				{
					tnGroup.useLocksets = false;
				}
				else
				{
					tnGroup.isDynamicLock = false;
					tnGroup.useDynamicLock = false;
				}
				continue;
			}
		}
	}
	public void setFlagsForStaticAllocations(CriticalSectionInterferenceGraph ig) {
		// Allocate one new static lock for each group.
		for(int group = 0; group < ig.groupCount() - 1; group++)
		{
			CriticalSectionGroup tnGroup = ig.groups().get(group + 1);
			tnGroup.isDynamicLock = false;
			tnGroup.useDynamicLock = false; 
			tnGroup.lockObject = null;
		}
	}

    private void analyzeExistingLocks(List<CriticalSection> AllTransactions,
			CriticalSectionInterferenceGraph ig) {
		setFlagsForStaticAllocations(ig);
		
		// if for any lock there is any def to anything other than a static field, then it's a local lock.			
		// for each transaction, check every def of the lock
		Iterator<CriticalSection> tnAIt = AllTransactions.iterator();
		while(tnAIt.hasNext())
		{
			CriticalSection tn = tnAIt.next();
			if(tn.setNumber <= 0)
				continue;
			ExceptionalUnitGraph egraph = new ExceptionalUnitGraph(tn.method.retrieveActiveBody());
			SmartLocalDefs sld = new SmartLocalDefs(egraph, new SimpleLiveLocals(egraph));
			if(tn.origLock == null || !(tn.origLock instanceof Local)) // || tn.begin == null)
				continue;
			List<Unit> rDefs = sld.getDefsOfAt( (Local) tn.origLock , tn.entermonitor );
			if(rDefs == null)
				continue;
			Iterator<Unit> rDefsIt = rDefs.iterator();
			while (rDefsIt.hasNext())
			{
				Stmt next = (Stmt) rDefsIt.next();
				if(next instanceof DefinitionStmt)
				{
					Value rightOp = ((DefinitionStmt) next).getRightOp();
					if(rightOp instanceof FieldRef)
					{
						if(((FieldRef) rightOp).getField().isStatic())
						{
							// lock may be static
							tn.group.lockObject = rightOp;
						}
						else
						{
							// this lock must be dynamic
							tn.group.isDynamicLock = true;
							tn.group.useDynamicLock = true;
							tn.group.lockObject = tn.origLock;
						}
					}
					else
					{
						// this lock is probably dynamic (but it's hard to tell for sure)
						tn.group.isDynamicLock = true;
						tn.group.useDynamicLock = true;
						tn.group.lockObject = tn.origLock;
					}
				}
				else
				{
					// this lock is probably dynamic (but it's hard to tell for sure)
					tn.group.isDynamicLock = true;
					tn.group.useDynamicLock = true;
					tn.group.lockObject = tn.origLock;
				}
			}
		}
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

	public void printGraph(Collection<CriticalSection> AllTransactions, CriticalSectionInterferenceGraph ig, Map<Value, Integer> lockToLockNum)
	{
		final String[] colors = {"black", "blue", "blueviolet", "chartreuse", "crimson", "darkgoldenrod1", "darkseagreen", "darkslategray", "deeppink",
			"deepskyblue1", "firebrick1", "forestgreen", "gold", "gray80", "navy", "pink", "red", "sienna", "turquoise1", "yellow"};
		Map<Integer, String> lockColors = new HashMap<Integer, String>();
		int colorNum = 0;
		HashSet<CriticalSection> visited = new HashSet<CriticalSection>();
		
		G.v().out.println("[transaction-graph]" + (optionUseLocksets ? "" : " strict") + " graph transactions {"); // "\n[transaction-graph] start=1;");

		for(int group = 0; group < ig.groups().size(); group++)
		{
			boolean printedHeading = false;
			Iterator<CriticalSection> tnIt = AllTransactions.iterator();
			while(tnIt.hasNext())
			{
				CriticalSection tn = tnIt.next();
				if(tn.setNumber == group + 1)
				{
					if(!printedHeading)
					{
//						if(localLock[group] && lockObject[group] != null)
						if(tn.group.useDynamicLock && tn.group.lockObject != null)
						{
							String typeString = "";
//							if(lockObject[group].getType() instanceof RefType)
//								typeString = ((RefType) lockObject[group].getType()).getSootClass().getShortName();
//							else
//								typeString = lockObject[group].getType().toString();
							if(tn.group.lockObject.getType() instanceof RefType)
								typeString = ((RefType) tn.group.lockObject.getType()).getSootClass().getShortName();
							else
								typeString = tn.group.lockObject.getType().toString();
							G.v().out.println("[transaction-graph] subgraph cluster_" + (group + 1) + " {\n[transaction-graph] color=blue;\n[transaction-graph] label=\"Lock: a \\n" + typeString + " object\";");
						}
						else if(tn.group.useLocksets)
						{
							G.v().out.println("[transaction-graph] subgraph cluster_" + (group + 1) + " {\n[transaction-graph] color=blue;\n[transaction-graph] label=\"Locksets\";");
						}
						else
						{
							String objString = "";
//							if(lockObject[group] == null)
							if(tn.group.lockObject == null)
							{
								objString = "lockObj" + (group + 1);
							}
//							else if(lockObject[group] instanceof FieldRef)
							else if(tn.group.lockObject instanceof FieldRef)
							{
//								SootField field = ((FieldRef) lockObject[group]).getField();
								SootField field = ((FieldRef) tn.group.lockObject).getField();
								objString = field.getDeclaringClass().getShortName() + "." + field.getName();
							}
							else
								objString = tn.group.lockObject.toString();
//								objString = lockObject[group].toString();
							G.v().out.println("[transaction-graph] subgraph cluster_" + (group + 1) + " {\n[transaction-graph] color=blue;\n[transaction-graph] label=\"Lock: \\n" + objString + "\";");
						}
						printedHeading = true;
					}
					if(Scene.v().getReachableMethods().contains(tn.method))
						G.v().out.println("[transaction-graph] " + tn.name + " [name=\"" + tn.method.toString() + "\" style=\"setlinewidth(3)\"];");
					else
						G.v().out.println("[transaction-graph] " + tn.name + " [name=\"" + tn.method.toString() + "\" color=cadetblue1 style=\"setlinewidth(1)\"];");

					if(tn.group.useLocksets) // print locks instead of dependence edges
					{
						for(EquivalentValue lockEqVal : tn.lockset)
						{
							Integer lockNum = lockToLockNum.get(lockEqVal.getValue());
							for(CriticalSection tn2 : tn.group)
							{
								if(!visited.contains(tn2) && ig.mayHappenInParallel(tn, tn2))
								{
									for(EquivalentValue lock2EqVal : tn2.lockset)
									{
										Integer lock2Num = lockToLockNum.get(lock2EqVal.getValue());
										if(lockNum.intValue() == lock2Num.intValue())
										{
											// Get the color for this lock
											if(!lockColors.containsKey(lockNum))
											{
												lockColors.put(lockNum, colors[colorNum % colors.length]);
												colorNum++;
											}
											String color = lockColors.get(lockNum);

											// Draw an edge for this lock
											G.v().out.println("[transaction-graph] " + tn.name + " -- " + tn2.name + " [color=" + color + " style=" + (lockNum >= 0 ? "dashed" : "solid") + " exactsize=1 style=\"setlinewidth(3)\"];");
										}
									}
								}
							}
							visited.add(tn);
						}
					}
					else
					{
						Iterator<CriticalSectionDataDependency> tnedgeit = tn.edges.iterator();
						while(tnedgeit.hasNext())
						{
							CriticalSectionDataDependency edge = tnedgeit.next();
							CriticalSection tnedge = edge.other;
							if(tnedge.setNumber == group + 1)
								G.v().out.println("[transaction-graph] " + tn.name + " -- " + tnedge.name + " [color=" + (edge.size > 0 ? "black" : "cadetblue1") + " style=" + (tn.setNumber > 0 && tn.group.useDynamicLock ? "dashed" : "solid") + " exactsize=" + edge.size + " style=\"setlinewidth(3)\"];");
						}
					}
				}
				
			}
			if(printedHeading)
				G.v().out.println("[transaction-graph] }");
		}
		
		// Print nodes with no group
		{
			boolean printedHeading = false;
			Iterator<CriticalSection> tnIt = AllTransactions.iterator();
			while(tnIt.hasNext())
			{
				CriticalSection tn = tnIt.next();
				if(tn.setNumber == -1)
				{
					if(!printedHeading)
					{
						// putting these nodes in a "source" ranked subgraph makes them appear above all the clusters
						G.v().out.println("[transaction-graph] subgraph lone {\n[transaction-graph] rank=source;");
						printedHeading = true;
					}
					if(Scene.v().getReachableMethods().contains(tn.method))
						G.v().out.println("[transaction-graph] " + tn.name + " [name=\"" + tn.method.toString() + "\" style=\"setlinewidth(3)\"];");
					else
						G.v().out.println("[transaction-graph] " + tn.name + " [name=\"" + tn.method.toString() + "\" color=cadetblue1 style=\"setlinewidth(1)\"];");

					Iterator<CriticalSectionDataDependency> tnedgeit = tn.edges.iterator();
					while(tnedgeit.hasNext())
					{
						CriticalSectionDataDependency edge = tnedgeit.next();
						CriticalSection tnedge = edge.other;
						if(tnedge.setNumber != tn.setNumber || tnedge.setNumber == -1)
							G.v().out.println("[transaction-graph] " + tn.name + " -- " + tnedge.name + " [color=" + (edge.size > 0 ? "black" : "cadetblue1") + " style=" + (tn.setNumber > 0 && tn.group.useDynamicLock ? "dashed" : "solid") + " exactsize=" + edge.size + " style=\"setlinewidth(1)\"];");
					}
				}
			}
			if(printedHeading)
				G.v().out.println("[transaction-graph] }");
		}

		G.v().out.println("[transaction-graph] }");
	}	

	public void printTable(Collection<CriticalSection> AllTransactions, MhpTester mhp)
	{
		G.v().out.println("[transaction-table] ");
		Iterator<CriticalSection> tnIt7 = AllTransactions.iterator();
		while(tnIt7.hasNext())
		{
			CriticalSection tn = tnIt7.next();
			
			// Figure out if it's reachable, and if it MHP itself
			boolean reachable = false;
			boolean mhpself = false;
			{
	    		ReachableMethods rm = Scene.v().getReachableMethods();
	    		reachable = rm.contains(tn.method);
		    	if(mhp != null)
		    		mhpself = mhp.mayHappenInParallel(tn.method, tn.method);
		    }
			G.v().out.println("[transaction-table] Transaction " + tn.name + (reachable ? " reachable" : " dead") + (mhpself ? " [called from >= 2 threads]" : " [called from <= 1 thread]"));
			G.v().out.println("[transaction-table] Where: " + tn.method.getDeclaringClass().toString() + ":" + tn.method.toString() + ":  ");
			G.v().out.println("[transaction-table] Orig : " + tn.origLock);
			G.v().out.println("[transaction-table] Prep : " + tn.prepStmt);
			G.v().out.println("[transaction-table] Begin: " + tn.entermonitor);
			G.v().out.print("[transaction-table] End  : early:" + tn.earlyEnds.toString() + " exc:" + tn.exceptionalEnd + " through:" + tn.end + " \n");
			G.v().out.println("[transaction-table] Size : " + tn.units.size());
			if(tn.read.size() < 100)
				G.v().out.print("[transaction-table] Read : " + tn.read.size() + "\n[transaction-table] " + 
					tn.read.toString().replaceAll("\\[", "     : [").replaceAll("\n", "\n[transaction-table] "));
			else
				G.v().out.print("[transaction-table] Read : " + tn.read.size() + "  \n[transaction-table] ");
			if(tn.write.size() < 100)
				G.v().out.print("Write: " + tn.write.size() + "\n[transaction-table] " + 
					tn.write.toString().replaceAll("\\[", "     : [").replaceAll("\n", "\n[transaction-table] ")); // label provided by previous print statement
			else
				G.v().out.print("Write: " + tn.write.size() + "\n[transaction-table] "); // label provided by previous print statement
			G.v().out.print("Edges: (" + tn.edges.size() + ") "); // label provided by previous print statement
			Iterator<CriticalSectionDataDependency> tnedgeit = tn.edges.iterator();
			while(tnedgeit.hasNext())
				G.v().out.print(tnedgeit.next().other.name + " ");
			if(tn.group != null && tn.group.useLocksets)
			{
				G.v().out.println("\n[transaction-table] Locks: " + tn.lockset);
				
			}
			else
				G.v().out.println("\n[transaction-table] Lock : " + (tn.setNumber == -1 ? "-" : (tn.lockObject == null ? "Global" : (tn.lockObject.toString() + (tn.lockObjectArrayIndex == null ? "" : "[" + tn.lockObjectArrayIndex + "]")) )));
			G.v().out.println("[transaction-table] Group: " + tn.setNumber + "\n[transaction-table] ");
		}
	}
	
	public void printGroups(Collection<CriticalSection> AllTransactions, CriticalSectionInterferenceGraph ig)
	{
			G.v().out.print("[transaction-groups] Group Summaries\n[transaction-groups] ");
			for(int group = 0; group < ig.groupCount() - 1; group++)
    		{
    			CriticalSectionGroup tnGroup = ig.groups().get(group + 1);
    			if(tnGroup.size() > 0)
    			{
	    			G.v().out.print("Group " + (group + 1) + " ");
					G.v().out.print("Locking: " + (tnGroup.useLocksets ? "using " : (tnGroup.isDynamicLock && tnGroup.useDynamicLock ? "Dynamic on " : "Static on ")) + (tnGroup.useLocksets ? "locksets" : (tnGroup.lockObject == null ? "null" : tnGroup.lockObject.toString())) );
					G.v().out.print("\n[transaction-groups]      : ");
					Iterator<CriticalSection> tnIt = AllTransactions.iterator();
					while(tnIt.hasNext())
					{
						CriticalSection tn = tnIt.next();
						if(tn.setNumber == group + 1)
							G.v().out.print(tn.name + " ");
					}
					G.v().out.print("\n[transaction-groups] " + 
	    							tnGroup.rwSet.toString().replaceAll("\\[", "     : [").replaceAll("\n", "\n[transaction-groups] "));
	    		}
	    	}
			G.v().out.print("Erasing \n[transaction-groups]      : ");
			Iterator<CriticalSection> tnIt = AllTransactions.iterator();
			while(tnIt.hasNext())
			{
				CriticalSection tn = tnIt.next();
				if(tn.setNumber == -1)
					G.v().out.print(tn.name + " ");
			}
			G.v().out.println("\n[transaction-groups] ");
	}
	public CriticalSectionInterferenceGraph getInterferenceGraph() {
		return interferenceGraph;
	}
	public DirectedGraph getDeadlockGraph() {
		return deadlockGraph;
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
