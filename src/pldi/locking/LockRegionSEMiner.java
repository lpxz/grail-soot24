package pldi.locking;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


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
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.jimple.toolkits.pointer.SideEffectAnalysis;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class LockRegionSEMiner {

	protected static final boolean optionOpenNesting = false;
	public  static HashMap methodToExcUnitGraph = new HashMap();// run only once after all
	public  static HashMap methodToFlowSet = new HashMap();// run only once after all
	
	

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
		String argsOfCalfuzzer = "-f J -pp -cp /home/lpxz/eclipse/workspace/calFuzzer/lib/ant-coontrib.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/servlet.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/asm-3.1.jar:/home/lpxz/eclipse/workspace/calFuzzer/bin -process-dir /home/lpxz/eclipse/workspace/calFuzzer/bin"; // java.lang.Math
		
		//
        String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin Toy$InnerThread"; // java.lang.Math
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
		
	///	Options.v().set_output_dir("paddle_public.jar");
	//	Options.v().set_output_jar(true);// same as the name as the outdir (actually substitue it), so must be set.

		 Setup.setupPatchOptions();
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();



		
		 
		Pack jtp = PackManager.v().getPack("jtp");
		addregionSEPackToJtp(jtp);
		// Pack wjtp = PackManager.v().getPack("wjtp");
		// addVisitorToWjtp(wjtp);

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}

	protected static  HashMap tn2SE = new HashMap();

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

	public static void addregionSEPackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.regionSE", new BodyTransformer() {

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				SootMethod  sm =b.getMethod();
				if(!sm.hasActiveBody())
				{
					return;
				}
				else {
					//@goto LockRegionMUVIMiner for more robust and sound implementation of side effects analysis (tlo)
					SideEffectAnalysis sea = Scene.v().getSideEffectAnalysis();  
					if(sea==null)
					{
						sea  = new SideEffectAnalysis(Scene.v().getPointsToAnalysis(), Scene.v().getCallGraph());
					}
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
    				    	System.out.println("==============\n tn units (no order)");// per tn
    				    	CodeBlockRWSet tnInterSet = null;
    				    	CodeBlockRWSet tnRSet = new CodeBlockRWSet();
    				    	CodeBlockRWSet tnWSet = new CodeBlockRWSet();
    				    	
							for (Iterator iterator2 = us.iterator(); iterator2
									.hasNext();) {
								Unit unit = (Unit) iterator2.next();
								System.out.println(unit);
								RWSet readset  = sea.readSet(sm, (Stmt)unit);
								RWSet writeset  = sea.writeSet(sm, (Stmt)unit);
								tnRSet.union(readset);
								tnWSet.union(writeset);
							}
							tnInterSet =tnRSet.intersection(tnWSet);
						    
							printRWSet(tnInterSet, "read&write");
							tnInterSet =tnWSet;
							storeRWSet(srfp.tn, tnInterSet);
						//	printRWSet(tnInterSet, "purewrite");
//							tnInterSet =tnRSet.minus(tnWSet);
//							printRWSet(tnInterSet, "read-write");
//							tnInterSet =tnWSet.minus(tnRSet);
//							printRWSet(tnInterSet, "write-read");
							
//							tnInterSet =tnWSet.minus(tnWSet);
//							printRWSet(tnInterSet, "write-write");
							
							
							System.out.println("==============\n");
    				    	
							
						}
    				}
    			
    				
    				// add the results to the list of results
    				methodToFlowSet.put(sm, fs);
					
					
				}

				
				
				
			}
			private void storeRWSet(CriticalSection tn, CodeBlockRWSet tnRSet) {
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
							throw new RuntimeException();
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
								tnRSet.addFieldRef(tnRSet.getBaseForField(f), f);
							//	System.err.println(f.toString());
							}
						}
						else {
							tnRSet.addFieldRef(tnRSet.getBaseForField(f), f);
							//System.err.println(f.getClass());
						}
						
						
					}
				    tn2SE .put(tn, toret);
				   // System.err.println(somewords + " side effect (nonempty, nonjava fields)#"+nonemptyf);
	               //  return nonemptyf>0;
					
				}
			private boolean  printRWSet(CodeBlockRWSet tnRSet, String somewords) {
				System.err.println("\n\n");
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
				System.err.println(somewords + "  side effect (nonjava G)#:"+gnum+"\n");	
			       
				
				
				
				
				
				
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
			
		}));

	}




	

}
