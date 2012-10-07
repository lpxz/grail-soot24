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
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.Stmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;

import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
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
import soot.util.Chain;


//new MHGDominatorTree(new MHGPostDominatorsFinder(m_blockCFG));

public class BranchAnalyzer {
	
	private static final boolean DRAW = false;
	// equivalent two..
//	public static Set<Unit> branchheads = new HashSet<Unit>();
	public static Map<DirectedGraph, Set>  g2Branches = new HashMap<DirectedGraph, Set>();

	
	public static  Set getGHeads( DirectedGraph g)	
	{
		 Set heads = new HashSet();
		Set lrs =g2Branches.get(g);
		if(lrs ==null)
			return null;
		for (Iterator iterator = lrs.iterator(); iterator.hasNext();) {
			BranchRegion lr = (BranchRegion) iterator.next();
			if(lr.getHead()!=null)
			{
				 heads.add(lr.getHead());
			}
	       	
			
		}
		return heads;	
	}
	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
        String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin ToyBlocks"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		// do not use the jar directly,
		// unzip it to a folder, and parse the folder like above.
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String argsOfBayes = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Bayes.Bayes"; // java.lang.Math

		String interString = argsOfBayes;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		PhaseOptions.v().setPhaseOption("jb", "use-original-names:true");// does work
		PhaseOptions.v().setPhaseOption("jb.ulp", "enabled:false");//important 
		

		
	///	Options.v().set_output_dir("paddle_public.jar");
	//	Options.v().set_output_jar(true);// same as the name as the outdir (actually substitue it), so must be set.
		
		
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
//		Setup.setPhaseOptionsForSparkWork();



		
		 
		Pack jtp = PackManager.v().getPack("jtp");
		addgetRegionPackToJtp(jtp);
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

	private static void addgetRegionPackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.getRegion", new BodyTransformer() {

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				SootMethod  sm =b.getMethod();
				if(!sm.hasActiveBody())
				{
					return;
				}
				else {
					Body bb =sm.getActiveBody();
				  //  UnitGraph ug = new ExceptionalUnitGraph(bb);
					UnitGraph ug = new EnhancedUnitGraph(bb);
				    PatchingChain<Unit> chain = bb.getUnits();

				    //Set branchStructure =
				    	findBranch(ug);
				    
				}

				
				
				
			}

			
		}));

	}

	
	public static  void findBranch(UnitGraph ug) {
		Set brSet= g2Branches.get(ug);
        if(brSet==null)
        {
        	brSet = new HashSet();
        	g2Branches.put(ug, brSet);
        }
		//	MHGDominatorTree  dom=	new MHGDominatorTree(new MHGDominatorsFinder(ug));
		    HashSet<Unit> branchheads = new HashSet<Unit>(); 
			LoopBodyFinder lbf = LoopAnalyzer.LBFgenerator(ug);
			Set<Object> loopheads = LoopAnalyzer.getGHeads(ug);
			PatchingChain<Unit> units = ug.getBody().getUnits();
			Iterator<Unit> uIt = units.iterator();
			while (uIt.hasNext()) {
				Unit unit = (Unit) uIt.next();
			   
				if(unit instanceof JIfStmt)// ug.getSuccsOf(unit).size()>1, branch is not okay, as goto is included
				{
					branchheads.add(unit);
//					if(unit.toString().contains("if $i26 != 0 goto return"))
//					{
//						System.err.println(unit);
//					}
				}			
			}
			if(loopheads!=null)
			{
				branchheads.removeAll(loopheads);
			}
			if(DRAW)
			{
				if(ug.size()>10) { Utils.drawDirectedGraph(ug, "newone"); }
			}
			
			
			MHGDominatorTree  pdom=	new MHGDominatorTree(new MHGPostDominatorsFinder(ug));
            for(Unit bh:branchheads)
            {
            	DominatorNode dode = pdom.getDode(bh);
            	DominatorNode paredode = dode.getParent();
            	Object parebh = paredode.getGode();
//            	if(bh.toString().contains("if $i26 != 0 goto return"))
//            	{
//            		System.out.println("");
//            	}
            	System.out.println("branch head:" + bh);
            	System.out.println("branch head's pdom:"+ parebh);
//            	if(parebh.toString().contains("$l39 = $l35 ^ $l38"))
//            	{
//            		System.out.println("now");
//            	}
            	BranchRegion br  = new BranchRegion();
                graspBrXBrBody(bh,parebh, ug,br);

            	//br.selfReport();
            	//===========================equip:
            	
                brSet.add(br);
            }		
		}

	private static Set graspBrXBrBody(Object bh, Object parebh,
			UnitGraph ug, BranchRegion br) {
		
		br.setHead(bh);
		br.setOutsideExit(parebh);
		// following set wholeBody, and also eachh2b
		
		Set body = br.wholebranchBody;
		Stack stack = new  Stack();
		Map<Object, List> eachh2bMap = br.eachh2b;
		//head case... his several children, general for switch...
		body.add(bh);
		stack.push(bh);
		Object first  = stack.pop();		
		List<Unit> succs=ug.getSuccsOf((Unit)first);
		for(Unit succ:succs)
		{
			if(succ!=null)
			{
				if(succ==parebh)
				{
					continue;// no need to recursion for it any more.
				}
				List tmp = new LinkedList();
				eachh2bMap.put(succ, tmp);
			//	tmp.add(succ);// do not add, later will add, duplication
				if(!body.contains(succ))// still white! body acting as grey set
				{
					body.add(succ);
					stack.push(succ);// for recursion...					
				}
			}
			
		}
		//=======================
		
		
		List currOrderedSet = null;
		while(true)
		{ // dfs, preorder
			
			if(stack.size()==0)
			{
			     break;	
			}
			first  = stack.pop();
			if(first==null)
			{
				continue;// next non-null element
			}
			else {
				
				if(eachh2bMap.keySet().contains(first))
				{
					currOrderedSet= eachh2bMap.get(first);

					currOrderedSet.add(first);// push-time, but the flag item is special
				
				
				}
				
			}
			succs=ug.getSuccsOf((Unit)first);
			for(Unit succ:succs)
			{
				if(succ==parebh)
				{
					continue;// no need to recursion for it any more.
				}
				if(!body.contains(succ))// still white! body acting as grey set
				{
						currOrderedSet.add(first);
				
					
					body.add(succ);
					stack.push(succ);// for recursion...					
				}
				
			}
			
			
		}
		return body;
	}


}
