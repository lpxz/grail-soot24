package pldi.region;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import pldi.locking.CriticalSection;
import pldi.locking.SynchronizedRegionFinder;
import pldi.locking.SynchronizedRegionFlowPair;

import pldi.region.HRGConstructor.Pair;
import pldi.region.HRGnode.HRGnType;
import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import Drivers.Utils;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Modifier;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PhaseOptions;
import soot.PointsToSet;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.coffi.class_element_value;
import soot.coffi.element_value;
import soot.jimple.MonitorStmt;
import soot.jimple.Stmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;

import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.MethodRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.jimple.toolkits.pointer.SideEffectAnalysis;
import soot.jimple.toolkits.pointer.Union;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;

import soot.options.Options;
import soot.tagkit.LineNumberTag;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.DominatorNode;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.MHGDominatorsFinder;
import soot.toolkits.graph.MHGPostDominatorsFinder;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.pdg.MHGDominatorTree;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;


//new MHGDominatorTree(new MHGPostDominatorsFinder(m_blockCFG));
// TODO:
// 1 body.getUnits is not sorted even for sequential units??
// 2 more testing please, like the ToyBlocks.. commented part. 
public class HRGAtomicSetTosser {
	
	//control:
	 public static int nonEmptywhat = 0;//
	 //0 instace//1 static// 2 all
	 public static int rorwControl_CBRW = 0;
	 // 0 pure write // 1 pure read//2 union//3  read &&write//4 write.minus(read)//
	 

	
	//
	
	
	public static HashSet procMethods = new HashSet();
	public  static	HashSet localVisited  = new  HashSet();
	public static MHGDominatorTree  postdom=null;
	private static final boolean DRAW = false;
	public static Map g2HRG=  new  HashMap();
	public static Set<Unit> branchheads = new HashSet<Unit>();
	public static Map<DirectedGraph, Set>  g2Branches = new HashMap<DirectedGraph, Set>();
    public static Set facts  = new  HashSet();
	public static MHGDominatorTree  dom=null;
	
	private static final String LINENUMBERTAG = "LineNumberTag";
    public static HashMap dfsahgStmt2Node = new  HashMap();
    public static HashMap dfsahgStmt2LineNo = new  HashMap();
    public static HashSet dfsahgVisited  = new  HashSet();
	
	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
        String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin ToyBlocks"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		// do not use the jar directly,
		// unzip it to a folder, and parse the folder like above.
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String argsOfBayes = "-f J -pp -cp /home/lpxz/eclipse/workspace/stamp/bin --app Bayes.Bayes"; // java.lang.Math

		String interString = argsOfBayes;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		
	///	Options.v().set_output_dir("paddle_public.jar");
	//	Options.v().set_output_jar(true);// same as the name as the outdir (actually substitue it), so must be set.
		
		Setup.setupPatchOptions();
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();
		PhaseOptions.v().setPhaseOption("jb", "use-original-names:true");// does work
		PhaseOptions.v().setPhaseOption("jb.ulp", "enabled:false");//important 
		



		
		 
		Pack jtp = PackManager.v().getPack("jtp");
		addgetRegionPackToWJtp(jtp);
		// Pack wjtp = PackManager.v().getPack("wjtp");
		// addVisitorToWjtp(wjtp);

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}

	// List entryPoints=EntryPoints.v().methodsOfApplicationClasses();
	// List mainEntries = new ArrayList();
	// for(int i=0;i< entryPoints.size(); i++)
	// {
	// if(entryPoints.get(i).toString().contains("main"))
	// {
	// mainEntries.add(entryPoints.get(i));
	// }
	// }
	//
	// soot.Scene.v().setEntryPoints(mainEntries); // process : app and its
	// reachable methods.



	private static void addgetRegionPackToWJtp(Pack jtp) {

	//	rOrw: control what to use, r&&w, or pure w, or w.minus(r)
		//seems the bodytransformer uses iterative algorithm
		//so, sometimes, the same method are run for several times with several copies/instances
		jtp.add(new Transform("jtp.ahgAtomicsetTosser", new BodyTransformer() {
			
			@Override
			protected void internalTransform(Body b, String phaseName, Map options) {
				// TODO Auto-generated method stub

				SootMethod  sm =b.getMethod();
				if(!sm.hasActiveBody())
				{
					return;
				}
				else {
					String[] interString = {"Bayes.Learner.<Bayes.Learner: void learnStructure(int,int,Bayes.Learner)>"
							, "Bayes.Learner.<Bayes.Learner: void createTaskList(int,int,Bayes.Learner)>"
					};
					if(!isInter(sm, interString))
					{
						 return;
					}
					
					
					String fullname = sm.getDeclaringClass().getName() + "."+sm.getSignature();
					if(!procMethods.contains(fullname))// only once for each method!
					{
						procMethods.add(fullname);
					}
					else {
						throw new RuntimeException();

					}
					
					Body bb =sm.getActiveBody();
				  //  UnitGraph ug = new ExceptionalUnitGraph(bb);
					UnitGraph ug = new BriefUnitGraph(bb);
				    PatchingChain<Unit> chain = bb.getUnits();

				    HashMap tn2se = new  HashMap();
				    getTN2SEinBody(ug,b,tn2se);
				    reprintSERele(tn2se, ug, b);
					
				    
		//===========================the following is about auto region, not yet, just for code analysis effective 		    
				
//				    	HRG hrg = weakStructure(ug);// here, HRGnode's content can be of Body, or LoopOrBranch..
//				    	HRG hrg2 = strongfy_fixdanger(ug, hrg);
				    	//dfsgetStmt2Node(hrg2);
				    	
				  //  	testLCA(hrg2);
//				    	if(DRAW)
//						{
//							if(hrg2.size() >10)
//							Utils.drawDirectedGraph4HRG(hrg2, "hrg");
//						}
				    
				}				
			
			}
		}));
		
		

	}



	protected static boolean isInter(SootMethod sm, String[] interString) {
		
	    if(interString.length!=0)
	    {
	    	String methodname = sm.getSignature();
	    	String classname  = sm.getDeclaringClass().getName();
	    	String fullname = classname + "."+ methodname;
	    	for(String str : interString)
	    	{
	    		if(fullname.contains(str))// str mya be of more filtering power
	    		{
	    		    return true ;	
	    		}
	    	}
	    	// non true is returned..
	    	return false;
	    }
	    else
	    	return true;
		
	}

	protected static void reprintSERele(HashMap tn2se, UnitGraph ug, Body b) {
		Iterator keyIt =tn2se.keySet().iterator();
		
		while (keyIt.hasNext()) {
			CriticalSection key= (CriticalSection) keyIt.next();
			CodeBlockRWSet SE=(CodeBlockRWSet)tn2se.get(key);
			if(SE==null)
				 throw new RuntimeException();
			//System.err.println(key.method.getDeclaringClass().getName() + "."+key.method.getName());
			reprintSERele_singleAS(key,SE, ug,b);
			
			
			
		}
		
		
	}

	private static void reprintSERele_singleAS(CriticalSection key, CodeBlockRWSet sE, UnitGraph ug,
			Body b) {
		 SideEffectAnalysis sea = Scene.v().getSideEffectAnalysis();
			if(sea==null)
			{
				sea  = new SideEffectAnalysis(Scene.v().getPointsToAnalysis(), Scene.v().getCallGraph());
			}
			SootMethod sm = b.getMethod();
			
			System.err.println("============tnID_method:====================");
			System.err.println("tn"+key.IDNum+ " in method:"+ sm.getDeclaringClass().getName() + "."+sm.getSignature());
			System.err.println("~~~~~~~~~~~~SE in it:~~~~~~~~~~~~~~~~~");
			printRWSet(sE, "");
			System.err.println("~~~~~~~~~~~~original:~~~~~~~~~~~~~~~~~");
			Iterator<Unit> unitIt2 =key.units.iterator();
		    while (unitIt2.hasNext()) {
					Unit unit = (Unit) unitIt2.next();
					if(!(unit instanceof MonitorStmt))
					{
						System.err.println( " < " +getLineNo(unit)+ " :" + unit );
					}
		    }
			System.err.println("~~~~~~~~~~~~Reprint:~~~~~~~~~~~~~~~~~");
			Iterator<Unit> unitIt =b.getUnits().iterator();
		    while (unitIt.hasNext()) {
					Unit unit = (Unit) unitIt.next();
					RWSet readset  = sea.readSet(sm, (Stmt)unit);
					RWSet writeset  = sea.writeSet(sm, (Stmt)unit);
					CodeBlockRWSet rorw  = rOrwCodeBlockRWSet(readset,writeset);
					if(rorw!=null && hasNonEmptyWrapper(rorw, sE))//rorw.hasNonEmptyIntersection(sE)
					{
						System.err.println( " < " +getLineNo(unit)+ " :" + unit );
					}
		    }
		    System.err.println("================================\n\n");
		
		
	}

	
	private static boolean hasNonEmptyWrapper(CodeBlockRWSet rorw, CodeBlockRWSet sE) {
		if(nonEmptywhat==0)
		{
			return hasNonEmptyInterSect_instancefields(rorw, sE);
		}
		else if (nonEmptywhat==1) {
		
			return hasNonEmptyInterSect_staticfields(rorw, sE);
		}
		else if(nonEmptywhat ==2) {
			return rorw.hasNonEmptyIntersection(sE);
		}
		else {
			throw new RuntimeException("no such option!!");
		}
		
	}

	private static boolean hasNonEmptyInterSect_instancefields(RWSet rorw,
			CodeBlockRWSet other) {
		if( rorw.getFields() != null && other.fields != null
			&& !rorw.getFields().isEmpty() && !other.fields.isEmpty() ) {
		    for (Object element : other.fields.keySet()) {
		        final Object field = element;
			if( rorw.getFields().contains( field ) ) {
			    if( Union.hasNonEmptyIntersection(
	                                rorw.getBaseForField( field ),
					other.getBaseForField( field ) ) ) {
				return true;
			    }
			}
		    }
		}
		return false;
	    
	}
	
	private static boolean hasNonEmptyInterSect_staticfields(RWSet rorw,
			CodeBlockRWSet other) {

		if( rorw.getGlobals() != null && other.globals != null
			&& !rorw.getGlobals().isEmpty() && !other.globals.isEmpty() ) {
		    for( Iterator it = other.globals.iterator(); it.hasNext(); ) {
			if( rorw.getGlobals().contains( it.next() ) ) return true;
		    }
		}
		return false;
	}

	
	private static CodeBlockRWSet rOrwCodeBlockRWSet(RWSet readset, RWSet writeset) {
		CodeBlockRWSet mockRead = new CodeBlockRWSet();
		CodeBlockRWSet mockWrite = new CodeBlockRWSet();
		mockRead.union(readset);
		mockWrite.union(writeset);
		CodeBlockRWSet toret = new CodeBlockRWSet();
		if(rorwControl_CBRW ==0)
		{
			return mockWrite;
		}else if (rorwControl_CBRW==1) {
			return mockRead;
		}
		else if (rorwControl_CBRW==2) {
			
			toret.union(mockRead);
			toret.union(mockWrite);
			return toret;
		}
		else if (rorwControl_CBRW==3) {
			toret.union(mockRead);
			toret.intersection(mockWrite);
			return toret;
		}
		else if ( rorwControl_CBRW ==4) {
			
			toret.union(mockWrite);
			toret.minus(mockRead);
			return toret;
		}
		else
		{
			throw new RuntimeException();
		}
	
		//return null;
	}

	private static boolean  printRWSet(CodeBlockRWSet tnRSet, String somewords) {
		
		Set gs = tnRSet.getGlobals();
		int gnum =0;
		for(Object g : gs)
		{
			String containingClass = "";
			if(g instanceof SootField)
			{
				SootField gfield = (SootField)g;
				containingClass= gfield.getDeclaringClass().toString();
				if(!containingClass.equals("")&&!containingClass.contains("java.lang"))
				{
					gnum++;
					System.err.println(g.toString());
				}
			}
			else {
				System.err.println(g.getClass());
			}
			
			
			
		}
		System.err.println(somewords + "  side effect (nonjava G)#:"+gnum);	
	       
		
		
		
		
		
		
	    Set fset= tnRSet.getFields();
	   
	    int nonemptyf =0;
	  	for(Object f : fset)
		{
			if(tnRSet.getBaseForField(f).isEmpty())
				continue;
			String containingClass = "";
			if(f instanceof SootField)
			{
				SootField gfield = (SootField)f;
				containingClass= gfield.getDeclaringClass().toString();
				if(!containingClass.equals("")&&!containingClass.contains("java.lang"))
				{
					nonemptyf++;
					System.err.println(f.toString());
				}
			}
			else {
				System.err.println(f.getClass());
			}
			
			
		}
	    System.err.println(somewords + " side effect (nonempty, nonjava fields)#"+nonemptyf);
         return nonemptyf>0;
		
	}
	
	protected static void getTN2SEinBody(UnitGraph ug, Body b, HashMap tn2se) {
		
		SootMethod sm = b.getMethod();
		 SideEffectAnalysis sea = Scene.v().getSideEffectAnalysis();
			if(sea==null)
			{
				sea  = new SideEffectAnalysis(Scene.v().getPointsToAnalysis(), Scene.v().getCallGraph());
			}
			SynchronizedRegionFinder ta = new SynchronizedRegionFinder(ug, b,  false);
			Chain units = b.getUnits();
			Unit lastUnit = (Unit) units.getLast();
			FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
			if(fs!=null)
			{
				
			    for (Iterator iterator = fs.iterator(); iterator
						.hasNext();) {
			    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
			    	HashSet<Unit> us =srfp.tn.units;
			    	System.out.println("==============\n tn units (no order)");// per tn
			    	CodeBlockRWSet tnInterSet = null;
			    	CodeBlockRWSet tnRSet = new CodeBlockRWSet();
			    	CodeBlockRWSet tnWSet = new CodeBlockRWSet();
			    	
					for (Iterator iterator2 = us.iterator(); iterator2
							.hasNext();) {
						Unit unit = (Unit) iterator2.next();
						RWSet readset  = sea.readSet(sm, (Stmt)unit);
						RWSet writeset  = sea.writeSet(sm, (Stmt)unit);
						tnRSet.union(readset);
						tnWSet.union(writeset);
					}

					tnInterSet = rOrwCodeBlockRWSet(tnRSet, tnWSet);
					tnInterSet= purifyRWSet( tnInterSet);
					tn2se.put(srfp.tn, tnInterSet);
					
				}
			}
		
	}

	private static CodeBlockRWSet purifyRWSet(CodeBlockRWSet tnRSet) {
		//	System.err.println("\n\n");
			CodeBlockRWSet toret = new  CodeBlockRWSet();
			Set gs = tnRSet.getGlobals();
			int gnum =0;
			for(Object g : gs)
			{
				String containingClass = "";
				if(g instanceof SootField)
				{
					SootField gfield = (SootField)g;
					containingClass= gfield.getDeclaringClass().toString();
					if(!containingClass.equals("")&&!containingClass.contains("java.lang"))
					{
						gnum++;
						toret.addGlobal(gfield);
						
						//System.err.println(g.toString());
					}
				}
				else {
					toret.globals.add(g);
				//	throw new RuntimeException();
				//	toret.addGlobal((SootField)g);// there is no static array_element_node!
				//	System.err.println(g.getClass());
				}
				
				
				
			}
			//System.err.println(somewords + "  side effect (nonjava G)#:"+gnum+"\n");	
		       
			
			
			
			
			
			
		    Set fset= tnRSet.getFields();
		   
		    int nonemptyf =0;
		  	for(Object f : fset)
			{
				if(tnRSet.getBaseForField(f).isEmpty())
					continue;
				String containingClass = "";
				if(f instanceof SootField)
				{
					SootField gfield = (SootField)f;
					containingClass= gfield.getDeclaringClass().toString();
					if(!containingClass.equals("")&&!containingClass.contains("java.lang"))
					{
						nonemptyf++;
						toret.addFieldRef(tnRSet.getBaseForField(f), f);
					//	System.err.println(f.toString());
					}
				}
				else {
					toret.addFieldRef(tnRSet.getBaseForField(f), f);
					//System.err.println(f.getClass());
				}
				
				
			}
		    return toret;
		   // System.err.println(somewords + " side effect (nonempty, nonjava fields)#"+nonemptyf);
           //  return nonemptyf>0;
			
		}
	
	protected static void dfsgetStmt2Node(HRG hrg2) {
		HRGnode root = hrg2.getRoot();
		dfs0getStmt2Node(hrg2,root);
		
		
	}

	private static void dfs0getStmt2Node(HRG hrg2, HRGnode root) {
		Object content =root.getContent();
		if(content instanceof LoopOrBranchRegion)
	     {
	    	 LoopOrBranchRegion tmp  = (LoopOrBranchRegion) content;
	    	 if(tmp instanceof LoopRegion || tmp instanceof BranchRegion)
	    	 {
	    		 Object  head = tmp.getHead();
	    		 putwrapper((Stmt)head, root);
	    	 }
	    	 // note head of XRegion also acts as a common stmt in the 3rd branch, 
	    	 // be processed there, pretty sure, both for XRegion of branch/loop
	    	 
	     }
	     else if(content instanceof Body){
	    	 // nothing happens here, no body directly belong to Body's node..
		
	    	 
		}

	     else if (content instanceof Stmt) {
	    	 Stmt tmp = (Stmt) content;
	    	 putwrapper((Stmt)tmp, root);
			
		}
	     else {
	    	throw new RuntimeException();
			
		}
		List<HRGnode> children  = hrg2.getSuccsOf(root);
		for (HRGnode child : children)
		{
			if(!dfsahgVisited.contains(child))
			{
				dfsahgVisited.add(child);
				dfs0getStmt2Node(hrg2, child);
			}
		}
		
		
		
	}

	private static int getLineNo(Unit head)
	{
		LineNumberTag lt = (LineNumberTag)head.getTag(LINENUMBERTAG);
		int lineNo=-1;
		if(lt!=null)
		{
		  lineNo=	lt.getLineNumber();
		}
		return lineNo;
	}
	private static void putwrapper(Stmt head, HRGnode root) {
		if(dfsahgStmt2Node.get(head)!=null && dfsahgStmt2Node.get(head)!=root)
		{
			HRGnode headn = (HRGnode)dfsahgStmt2Node.get(head);
			System.err.println(headn.getContent().getClass());
			System.err.println(root.getContent().getClass());
			throw new  RuntimeException("one stmt should belong to a node determinisitically");
		}
	
		LineNumberTag lt = (LineNumberTag)head.getTag(LINENUMBERTAG);
		int lineNo=-1;
		if(lt!=null)
		{
		  lineNo=	lt.getLineNumber();
		}
		dfsahgStmt2Node.put(head, root);
		dfsahgStmt2LineNo.put(head, lineNo);
	}

	
	protected static void testLCA(HRG hrg2) {
		if(hrg2.size() > 10)
		{
			HRGnode root = hrg2.getRoot();
			HRGnode test1 = root.getChildren().get(0);
			HRGnode test2 =  root.getChildren().get(1);;				    	
	    	HRGnode lca = hrg2.lca(test1, test2 );
	    	
	    	System.out.println("xxxtest:"+ lca.toString());
		}
	

		
	}

	protected static HRG strongfy_fixdanger(UnitGraph ug, HRG hrg) {				
		Body bb = ug.getBody();
		List ll = putintoList(bb);
		HRGnode bbnode =hrg.getHNode(bb);
		
		if(hrg.getRoot()==null)
		{
			hrg.setRoot(bbnode);
		}
		localVisited.clear();
		Set<HRGnode> origweakChildren = new HashSet<HRGnode>();
		origweakChildren.addAll(bbnode.getChildren());

		List<HRGnode> strongChildren  = weakChildren2StrongChildren(ll, origweakChildren, ug,hrg);
		bbnode.setChildren(strongChildren);
	    for(HRGnode strongChild:strongChildren)
	    {
	    	strongChild.setParent(bbnode);
	    }

		worklistStrongfy(origweakChildren, ug, hrg);// later weakchild2strong should use the same localvisited !!!
		
		return hrg;
	}

	private static List<HRGnode> weakChildren2StrongChildren(List ll,
			Set<HRGnode> weakChildren, UnitGraph ug, HRG hrg) {

		Set loops  = LoopAnalyzer.g2loops.get(ug);
		Set branches  = BranchAnalyzer.g2Branches.get(ug);
		List<HRGnode> strongChildren = new  LinkedList<HRGnode>();
		for(int i=0;i<ll.size();i++)
		{
			Object stmt = ll.get(i);
			
			boolean  head4weakCh = false;
			LoopOrBranchRegion tmplb = null;
			HRGnode  tmplbnode = null;
			if(stmt instanceof JIfStmt)
			{
				tmplb = getRegion((Unit)stmt, loops, branches);
				tmplbnode= hrg.getHNode(tmplb);
				head4weakCh = weakChildren.contains(tmplbnode);
			}
			
			boolean  alsoInweakCh= alsoInweakCh(stmt, weakChildren);
			if(!alsoInweakCh && ! head4weakCh)
			{
				HRGnode tmp = null;
				if(stmt instanceof JIfStmt)
				{
					//suppose that if is directly following for. and one branch of the if
					// directs to the exits!
					// because if is pd the for, so it is not contained as a region 
					// but according to the nat-loop calculation,
					// if is again inside, mistakenly/ unfortunately in it
				}
				else {
					tmp = hrg.getHNode(stmt);
					if(!strongChildren.contains(tmp))
					{
						strongChildren.add(tmp);
					}else {
				//		throw new RuntimeException("looklook");
					}
				}
				


				
			}
			else if (alsoInweakCh && ! head4weakCh) {
				// do not add
				
			}
			else if (alsoInweakCh && head4weakCh) {
				if(!strongChildren.contains(tmplbnode))
				{
					strongChildren.add(tmplbnode);		
				}
				else {
				//	throw new RuntimeException("looklook");
				}
						
			}
			
		}
		
		
		return strongChildren;
	}

	private static void worklistStrongfy(Set<HRGnode> toprocs, UnitGraph ug, HRG hrg) {
		List<HRGnode> worklist = new  ArrayList<HRGnode>();
		
		HashSet<HRGnode> set = new HashSet<HRGnode>();
		set.addAll(toprocs);
		for(HRGnode toadd : set)// no duplication of reference !!!fuck you!
		{
			wlputwrapper(worklist, toadd);
		}
		
// ok,. no xregion now 
		
		while(!worklist.isEmpty())
		{
			HRGnode toproc = worklist.remove(0);
			localVisited.add(toproc);
//             for(HRGnode xxx:toproc.getChildren())//duplicated reference may reference a XRegion
//             {
//            	
//						if(xxx.content instanceof XRegion)
//						{
//							throw new RuntimeException("what is up");
//						}
//					
//             }
			
		
			if(toproc.getHrgnType() == HRGnType.BRANCH)
			{ // 1 level turns to be 2 level
			
				Set<HRGnode> origweakChildren = new HashSet<HRGnode>();
				origweakChildren.addAll(toproc.getChildren());
				toproc.children = new LinkedList<HRGnode>();// put into two XRegion HRGnode
				BranchRegion br = (BranchRegion)toproc.getContent();
				
				
				Iterator keyIt =br.eachh2b.keySet().iterator();
				while (keyIt.hasNext()) {
					Object head = (Object) keyIt.next();
					List xList= br.eachh2b.get(head);
					// ==========================level1, toproc-> child(xregion)
					XRegion xregion_2procChild = new XRegion();
					xregion_2procChild.head= head;
					if(head==null)
						throw new RuntimeException("impossible");
					xregion_2procChild.xBody= xList;
					xregion_2procChild.outsideExit = br.outsideExit;
					HRGnode toprocChild = hrg.getHNode(xregion_2procChild);
					toproc.children.add(toprocChild);
					toprocChild.setParent(toproc);
					
					//===================== level2 child(xregion)-> stmts...
					List<HRGnode> strongChildren= weakChildren2StrongChildren(xregion_2procChild.xBody, origweakChildren, ug, hrg);
					toprocChild.setChildren(strongChildren);
					for(HRGnode strong:strongChildren)
					{
						strong.setParent(toprocChild);
					}
					localVisited.add(toprocChild);// directly set this !!! as it is intermediately handled
					//=======================
				}
				for(HRGnode orig: origweakChildren)// original children of loop, now be the part of all children of xregion!
				{
					if(!localVisited.contains(orig))
					{
						wlputwrapper(worklist, orig);//worklist.add(orig);
					}
				}
				
			}
			else if (toproc.getHrgnType() == HRGnType.LOOP) {
				 // 1 level turns to be 2 level
				Set<HRGnode> origweakChildren = new HashSet<HRGnode>();
				

				origweakChildren.addAll(toproc.getChildren());
			
					for(HRGnode xxx:origweakChildren)
					{
						if(xxx.content instanceof XRegion)
						{
							throw new RuntimeException("what is up");
						}
					}
				

				
				toproc.children = new LinkedList<HRGnode>();// put into two XRegion HRGnode
				LoopRegion lr = (LoopRegion)toproc.getContent();
				

					List xList= lr.iterateBody;
					// ==========================level1, toproc-> child(xregion)
					XRegion xregion_2procChild = new XRegion();
					xregion_2procChild.head= xList.get(0);
					if(xregion_2procChild.head ==null)
					{
						throw new RuntimeException("look at here, iterate body is empty??");
					}
					xregion_2procChild.xBody= xList;
					xregion_2procChild.outsideExit = lr.outsideExit;
					HRGnode toprocChild = hrg.getHNode(xregion_2procChild);
					toproc.children.add(toprocChild);
					toprocChild.setParent(toproc);
					
					//===================== level2 child(xregion)-> stmts...
					
					for(HRGnode xx:origweakChildren)
					{
						if(xx.content instanceof XRegion)
						{
							throw new RuntimeException("what is up");
						}
					}
					List<HRGnode> strongChildren= weakChildren2StrongChildren(xregion_2procChild.xBody, origweakChildren, ug, hrg);
					toprocChild.setChildren(strongChildren);
					for(HRGnode strong : strongChildren)
					{
						strong.setParent(toprocChild);
					}
					localVisited.add(toprocChild);// directly set this !!! as it is intermediately handled
					//=======================
					for(HRGnode orig: origweakChildren)// original children of loop, now be the part of all children of xregion!
					{
						if(!localVisited.contains(orig))
						{ 
							
							wlputwrapper(worklist, orig);// worklist.add(orig);\
							}
					}
				//worklist.addAll(origweakChildren);
			
			}
			else if (toproc.getHrgnType() == HRGnType.XREGION) {
				throw new RuntimeException("it is impossible to get an XRegion from queue, xregion is immediate state, never been put itno queue");
			}
			else if (toproc.getHrgnType() == HRGnType.ROOT) {
				throw new RuntimeException("root is specially handled, not in this func");
			}
			else if (toproc.getHrgnType() == HRGnType.UNIT) {
				throw new RuntimeException("unit is never handled by worklist.. only LB can ");
				
			}
		}

		
		
	}

	private static void wlputwrapper(List<HRGnode> worklist, HRGnode orig) {
//		for(HRGnode xx:orig.getChildren())
//		{
//			if(xx.content instanceof XRegion)
//			{
//				throw new RuntimeException("what is up");
//			}
//		}
		localVisited.add(orig);
		worklist.add(orig);
		
	}

	private static boolean alsoInweakCh(Object stmt, Set<HRGnode> weakChildren) {
		for (Iterator iterator = weakChildren.iterator(); iterator.hasNext();) {
			HRGnode hrGnode = (HRGnode) iterator.next();
			Object cont =hrGnode.content;
			if(cont instanceof LoopRegion)
			{
				LoopRegion lr = (LoopRegion)cont;
				if(lr.getLoopBody().contains(stmt)) // in loop weakchidlrenm
					return true;
			}
			else if(cont instanceof  BranchRegion) {
				BranchRegion br = (BranchRegion) cont;
				if(br.getWholeBranchBody().contains(stmt))
				{
					return true;
				}
				
			}
			else if(cont instanceof XRegion)
			{
				throw new RuntimeException("still judging the stmt, children XRegion is not created yet.");
				
			}
			else {
				throw new RuntimeException("what is this content type of children weak region??");
			}
			
			
		}
		
		return false;
	}

	private static List putintoList(Body bb) {
		Iterator it = bb.getUnits().iterator();
		List ll = new  LinkedList();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			if(!ll.contains(object))
			{
				ll.add(object);	
			}
			else {
				throw new RuntimeException();
			}
			
		}
		return ll;
	}

	public static  HRG  weakStructure(UnitGraph ug) {
		//	
		//	MHGDominatorTree  dom=	new MHGDominatorTree(new MHGDominatorsFinder(ug));
			
			LoopBodyFinder lbf = LoopAnalyzer.LBFgenerator(ug);
			BranchAnalyzer.findBranch(ug);// loop and branch 
			
			
			Set loops  = LoopAnalyzer.g2loops.get(ug);
			Set branches  = BranchAnalyzer.g2Branches.get(ug);
//			if(loops ==null || branches ==null)// totally possible, e.g., there is no any loops in g!.
//			{
//				throw new RuntimeException("what is up");
//			}
		   dom=	new MHGDominatorTree(new MHGDominatorsFinder(ug));
		   postdom=	new MHGDominatorTree(new MHGPostDominatorsFinder(ug));
            
			
			collectDomFact(loops, branches, ug);
			HRG hrg  = fact2WeakGraph_danger(facts);
			

			return hrg;
			
			
			// g2HRG.put(g, hrg);// finally...
		}

	private static HRG fact2WeakGraph_danger(Set facts2) {
		HRG hrg = new HRG();
		
		for (Iterator iterator = facts2.iterator(); iterator.hasNext();) {
			 Pair pair = (Pair) iterator.next();
			 if(pair.left instanceof LoopOrBranchRegion )// ignore the root, now ..
			 {// l dom r
				 LoopOrBranchRegion tmpl  = (LoopOrBranchRegion) pair.left;
				 LoopOrBranchRegion tmpr  = (LoopOrBranchRegion) pair.right;	
				// System.out.println("order:" + tmpl.getHead() +"---->" + tmpr.getHead());
				 HRGnode nodel = hrg.getHNode(tmpl);
				 HRGnode noder = hrg.getHNode(tmpr);
				 hrg.formParentRel(nodel, noder);			 
			 }
			 else if(pair.left instanceof Body) {
				 Body tmpl = (Body) pair.left;
				 LoopOrBranchRegion tmpr = (LoopOrBranchRegion) pair.right;
				 HRGnode nodel = hrg.getHNode(tmpl);
				 HRGnode noder = hrg.getHNode(tmpr);
				 hrg.formParentRel(nodel, noder);
				 hrg.setRoot(nodel);		
				 nodel.setParent(null);
			}
			
			
		}
		return hrg;
		
		
		
		
	}

	private static void collectDomFact(Set loops, Set branches, UnitGraph ug) {
		  List<Unit> heads = ug.getHeads();
//		  if(heads.size()>1)
//		  {
//			  throw new RuntimeException();
//		  }
		  visited.clear();
		  onstack.clear();
		  for(Unit head:heads)
		  {
			  collectDomFact41Head(loops,branches,ug,head);//dfs
		  }
		  
		
	}

	public static Set visited = new HashSet();
	public static Stack onstack = new Stack();
	private static void collectDomFact41Head(Set loops, Set branches,
			UnitGraph ug, Unit head) {
		//Utils.drawDirectedGraphNBody(ug, ug.getBody(), "debug");
		
		onstack.push(head);

		    List<Unit>  succs = ug.getSuccsOf(head);
	        	for(Unit succ:succs)
	        	{
	        		if(!visited.contains(succ))
	        		{
	        			visited.add(succ);
	        			//=============predecessors in the stack?
	        			if(succ instanceof JIfStmt)
	        			{
//	    					if(succ.toString().contains("if $i26 != 0 goto return"))
//	    					{
//	    						System.err.println(succ);
//	    					}
	        				LoopOrBranchRegion lorbR=getRegion(succ,loops, branches);        				
	        				// only the latest one!
	        				Unit  latestu = searchLatestRegion(succ,onstack,loops,branches);
	        				// suppose x pd latestu (branch/loop head), and succ pd x,
	        				// it is obvious that succ pd latestu, succ does not belong to branch/loop region
	        				// because if belongs to, the internal element can not pd the head!
	        				LoopOrBranchRegion latestr = getRegion(latestu, loops, branches);
	        				
	        				if(lorbR == null) throw new RuntimeException();
	        				if(latestr !=null)
	        				{
	        					if(dom.isDominatorOf(dom.getDode(latestu), dom.getDode(succ)))
	        					{
	        						formFact(latestr, lorbR);
	        					}
	        					
	        				}
	        				else
	        				{
	        				    formFact(ug.getBody(), lorbR);	
	        				}        				
	        			}
	        			//========================================
	        			
	        			collectDomFact41Head(loops, branches, ug, succ);
	        			
	        		}
	        		else {
	        			//=============predecessors in the stack?
	        			// node is viisted , but the orderedge is not ...
	        			if(succ.branches())
	        			{
	        				LoopOrBranchRegion lorbR =getRegion(succ,loops, branches);
	        				Unit  latestu = searchLatestRegion(succ,onstack,loops,branches);
	        				LoopOrBranchRegion latestr = getRegion(latestu, loops, branches);
	        				
	        				if(lorbR == null) throw new RuntimeException();
	        				if(latestr !=null)
	        				{
	        					if(dom.isDominatorOf(dom.getDode(latestu), dom.getDode(succ)))
	        					{
	        						formFact(latestr, lorbR);
	        					}
	        					
	        				}
	        				else
	        				{
	        				    formFact(ug.getBody(), lorbR);	
	        				}        		      				
	        			}
	        			//========================================
					}
	        	}
	    onstack.pop();
	        	
  
		
	}

	private static void formFact(Object latest,
			LoopOrBranchRegion lorbR) {
		Pair p  = new Pair(latest, lorbR);
		facts.add(p);// scan and construct later...
		
		
		
		
//	        if(latest instanceof Body)
//	        {
//	        	
//	        	
//	        }else if(latest instanceof LoopOrBranchRegion){
//	        	
//				
//			}
//			
		
	}

	private static Unit searchLatestRegion(Unit succ, Stack onstack2,
			Set loops, Set branches) {
           Stack  tmpStack = (Stack)onstack2.clone();
           Object top =null;
		   while(!tmpStack.isEmpty() && (top=tmpStack.pop()) !=null)
		   {
			   Unit unit = (Unit )top;
			   if(unit instanceof JIfStmt)
			   {// if branch, must be in some region
				   //
				   if(postdom.isDominatorOf(postdom.getDode(succ), postdom.getDode(unit)))
				   {
					   // this is not the one, continue;;;
				   }
				   else {
					   return unit;
				   }
				   
				 
			   }
			   
		   }
		   return null;// no head at all in the stack, so return the null.
		
		
	}
    /////need fixing ,head can not determine the region, not bi-directional
	//fix , can now, hommock graph
	
	// @ needs JIFStmt
	private static LoopOrBranchRegion getRegion(Unit head, Set loops, Set branches) {
	      if(head ==null) return null; // searchLatest * getRegion: certain x-> null (x-> null, null-> null)
		  for (Iterator iterator = branches.iterator(); iterator.hasNext();) {
			BranchRegion branchR = (BranchRegion) iterator.next();
			if(branchR.getHead()==head)
			{return  (LoopOrBranchRegion)branchR;}			
		}
		  for (Iterator iterator = loops.iterator(); iterator.hasNext();) {
			  LoopRegion lr = (LoopRegion) iterator.next();
			  if(lr.getHead()==head)
			  {
				  return (LoopOrBranchRegion)lr;
			  }
		}
		
          throw new RuntimeException();
	}

	static class Pair
	{
		public Object left ;
		public Object right;
		public Pair(Object pl, Object pr)
		{
			left =pl;
			right =pr;
		}
		
	}

}
