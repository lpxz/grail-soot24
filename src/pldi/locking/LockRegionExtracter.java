package pldi.locking;

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


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import pldi.locking.*;
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
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.Stmt;

import soot.options.Options;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class LockRegionExtracter {

	protected static final boolean optionOpenNesting = false;
	public  static HashMap methodToExcUnitGraph = new HashMap();// run only once after all
	public  static HashMap methodToFlowSet = new HashMap();// run only once after all
	
	

	public static void main(String[] args) throws IOException { // wjtp.tn
		
		String argsOfCalfuzzer = "-f J -pp -cp /home/lpxz/eclipse/workspace/calFuzzer/lib/ant-coontrib.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/servlet.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/asm-3.1.jar:/home/lpxz/eclipse/workspace/calFuzzer/bin -process-dir /home/lpxz/eclipse/workspace/calFuzzer/bin"; // java.lang.Math
		
		//
        String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin Toy$InnerThread"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		

		String argsOfBayes = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Bayes.Bayes"; // java.lang.Math

		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		
	
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		
		
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		//Setup.setPhaseOptionsForSparkWork();



		
		 
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
					
//					SideEffectAnalysis sea = Scene.v().getSideEffectAnalysis();
//					if(sea==null)
//					{
//						sea  = new SideEffectAnalysis(Scene.v().getPointsToAnalysis(), Scene.v().getCallGraph());
//					}
	    	    	ExceptionalUnitGraph eug = new ExceptionalUnitGraph(b);
    		    	methodToExcUnitGraph.put(sm, eug);
    		    	
    	    		// run the intraprocedural analysis
//    		    	if(sm.getDeclaringClass().getName().contains("benchmarks.testcases.Thread2a") && sm.getName().contains("run"))
//    		    	{
//    		    		Utils.drawDirectedGraphNBody(eug, b, "random");
//    		    	}
    				SynchronizedRegionFinder ta = new SynchronizedRegionFinder(eug, b,  optionOpenNesting);
    				Chain units = b.getUnits();
    				Unit lastUnit = (Unit) units.getLast();
    				FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
    				if(fs!=null)
    				{
    					
    				    for (Iterator iterator = fs.iterator(); iterator
								.hasNext();) {
    				    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
    				    	HashSet<Unit> us =srfp.tn.units;
    				    	System.out.println("==============\n tn units (no order)");
							for (Iterator iterator2 = us.iterator(); iterator2
									.hasNext();) {
								Unit unit = (Unit) iterator2.next();
								System.out.println(unit);
								
							}
							System.out.println("==============\n");
    				    	
							
						}
    				}
    			
    				
    				// add the results to the list of results
    				methodToFlowSet.put(sm, fs);
					
					
				}

				
				
				
			}
		}));

	}




	

}
