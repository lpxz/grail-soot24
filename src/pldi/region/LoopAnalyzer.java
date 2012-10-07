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
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


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
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;

import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.MHGPostDominatorsFinder;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.pdg.MHGDominatorTree;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.util.Chain;


//new MHGDominatorTree(new MHGPostDominatorsFinder(m_blockCFG));

public class LoopAnalyzer {
	
	protected static final boolean DRAW = true;
	public static Map<DirectedGraph, Set>  g2loops = new HashMap<DirectedGraph, Set>();

	
	public static  Set getGHeads( DirectedGraph g)	
	{
		 Set heads = new HashSet();
		Set lrs =LoopAnalyzer.g2loops.get(g);
		if(lrs ==null)
			return null;
		for (Iterator iterator = lrs.iterator(); iterator.hasNext();) {
			LoopRegion lr = (LoopRegion) iterator.next();
			if(lr.getHead()!=null)
			{
				 heads.add(lr.getHead());
			}
	       	
			
		}
		return heads;	
	}
	
	public static  Set<LoopRegion> getGLoopRegions( DirectedGraph g)	
	{
		
		Set lrs =LoopAnalyzer.g2loops.get(g);
		return lrs;
//		if(lrs ==null)
//			return null;
//
//		return loopbodies;	
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
				    UnitGraph ug = new EnhancedUnitGraph(bb);
				    LoopBodyFinder lbf = LBFgenerator(ug);
				    if(DRAW)
				    {
				    	if(ug.size()>5)
					    {
					    	Utils.drawDirectedGraph(ug, "loop");
					    }
				    }
				    
				    Set<LoopRegion> lrs  = getGLoopRegions(ug);
				    if(lrs==null)
				    {
				    	return; // not containing any loops... null!=empty
				    }
				    for(LoopRegion lr : lrs)
				    {
				    	lr.selfReport();
				    }

				    
				}

				
				
				
			}


		}));

	}
	public static LoopBodyFinder LBFgenerator(UnitGraph ug) {
		Body bb = ug.getBody();
		PatchingChain<Unit> chain = bb.getUnits();
		DfsForBackEdge dfsForBackEdge = new DfsForBackEdge(chain, ug);
		Map<Object, Object> backEdges = dfsForBackEdge.getBackEdges();		
	   // LoopBodyFinderBak lbf = new LoopBodyFinderBak(backEdges, ug);
		
		Map<Object, Set> head2tails = organizeBEs(backEdges);
		
		LoopBodyFinder lbf = new LoopBodyFinder(head2tails, ug);
		return lbf;
	}

	private static Map<Object, Set> organizeBEs(Map<Object, Object> backEdges) {
		Map<Object, Set> toret = new HashMap<Object, Set>();
		Set maps = backEdges.entrySet();
		for(Iterator iter=maps.iterator(); iter.hasNext();){
			Map.Entry entry = (Map.Entry)iter.next();
			Object tail = entry.getKey();
			//Tag tag = (Tag)key.getTags().get(0);
			// System.out.println("---key=  "+tag+" "+key);
			Object  head  = entry.getValue();
			Set tails  = toret.get(head);
			if(tails==null)
			{
				tails = new HashSet();
				toret.put(head, tails);			
			}
			tails.add(tail);
			
			
		}
		
		return toret;
	}



}
