package pldi.locking;

import java.io.BufferedWriter;
import java.io.File;
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
import java.util.Stack;



import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import pldi.AHG.AHGAtomicSetTosser;



import AA.SootUtil;
import Drivers.Setup;
import Drivers.Utils;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Local;
import soot.Modifier;
import soot.Pack;
import soot.PackManager;
import soot.PointsToAnalysis;
import soot.PointsToSet;
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
import soot.tagkit.Host;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceFileTag;
import soot.tagkit.SourceLineNumberTag;
import soot.tagkit.SourceLnPosTag;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class LockRegionDumpAtomicAHG {

	protected static final boolean optionOpenNesting = false;
	public  static HashMap methodToExcUnitGraph = new HashMap();// run only once after all
	public  static HashMap methodToFlowSet = new HashMap();// run only once after all
	public  static HashMap tn2SE = new HashMap();// run only once after all
	public static Local cache =null;
	
	public static String projName = "";
	public static String varName = "";
	public static  String methName = "";
	public static int getLineNum(Host h) {
        if (h.hasTag("LineNumberTag")) {
            return ((LineNumberTag) h.getTag("LineNumberTag")).getLineNumber();
        }
        if (h.hasTag("SourceLineNumberTag")) {
            return ((SourceLineNumberTag) h.getTag("SourceLineNumberTag")).getLineNumber();
        }
        if (h.hasTag("SourceLnPosTag")) {
            return ((SourceLnPosTag) h.getTag("SourceLnPosTag")).startLn();
        }
        return -1;
    }
	
	public static String getFileName(Host h) {
        if (h.hasTag("SourceFileTag")) {
            return ((SourceFileTag) h.getTag("SourceFileTag")).getSourceFile();
        }
        
        return "";
    }

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
		int benchmark =1;
		String interString = "";
		switch (benchmark) {
        case 1:  
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Bayes.Bayes"; // java.lang.Math
		     {varName  = "learnerPtr";  methName  ="main"; projName = "Bayes";}
		     break;
        case 2:	     
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Genome.Genome"; // java.lang.Math
		    {varName  = "g";  methName  ="main"; projName = "Genome";}
		    break;
        case 3:
        	interString =  "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Intruder.Intruder"; // java.lang.Math
		    {varName  = "argPtr";  methName  ="processPackets";  projName = "Intruder";}
		    break;
        case 4:
        	interString ="-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app KMeans.KMeans"; // java.lang.Math
	         { varName  = "args";  methName  ="work"; projName = "Kmeans";}
	         break;
        case 5: 
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Labyrinth3D.Labyrinth"; // java.lang.Math
	     	{ varName  = "argPtr";  methName  ="solve";  projName = "Laby";}
	     	break ;
        case 6:
        	interString = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app MatrixMultiply.MatrixMultiply"; // java.lang.Math
		    { varName  = "matrix";  methName  ="main";  projName = "Matrix";}
		    break;
        case 7:
			 interString ="-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app SSCA2.SSCA2"; // java.lang.Math
	    	{ varName  = "tmp3";  methName  ="run";  projName = "ssca";} // tmp1, tmp2, tmp3
	    	break; 
        case 8:
        	 interString= "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Vacation.Vacation"; // java.lang.Math
			{ varName  = "managerPtr";  methName  ="run";  projName = "vacation";} // tmp1, tmp2, tmp3
			break;
        case 9:
        	 interString="-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Yada.java.yada"; // java.lang.Math
			{ varName  = "workHeapPtr";  methName  ="process";  projName = "yada";} // meshPtr,workHeapPtr
			break;
	    default:
	    	System.out.println("what benchmarks to process?");
		}
			
			
		
		
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



		Pack wjtp = PackManager.v().getPack("wjtp");


		
		 
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
    				    //	System.out.println("==============\n scenarios in  tn "+SootUtil.getMark(srfp.tn)+ ", units (no order)");// per tn
    				    	CodeBlockRWSet tnInterSet = null;
    				    	CodeBlockRWSet tnRSet = new CodeBlockRWSet();
    				    	CodeBlockRWSet tnWSet = new CodeBlockRWSet();
    				    	
							for (Iterator iterator2 = us.iterator(); iterator2
									.hasNext();) {
								Unit unit = (Unit) iterator2.next();
							//	System.out.println(unit);
								RWSet readset  = sea.readSet(sm, (Stmt)unit);
								RWSet writeset  = sea.writeSet(sm, (Stmt)unit);
								tnRSet.union(readset);
								tnWSet.union(writeset);
							}
							tnInterSet =tnRSet;//.intersection(tnWSet);
							storeRWSet(srfp.tn,tnInterSet);
						  
//							boolean fieldExist = printRWSet(tnInterSet, "read&write");
//                            if(!fieldExist)
//                            	continue;
							
							
							//start to coloring the AHG. toss
							
							   
							//=======

							{
								AHGAtomicSetTosser.p2a = Scene.v().getPointsToAnalysis();
								
								if(cache ==null)
								{

									Set<Local> localS= Utils.getLocals(null, methName, varName);// seems there are 6 locals in the set.. so I limit to the main scope!
									cache =(Local) localS.toArray()[0];
									
								}
								
						        AHGAtomicSetTosser.atomicsetSE =tnInterSet;
								AHGAtomicSetTosser.toBuildG  = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);			       
								AHGAtomicSetTosser.ahg_root(cache);// I wnat the graph now, graph and color at the same time
								
								Stmt begin =srfp.tn.beginning;
								int line =getLineNum(begin);
								SootClass sc = srfp.tn.method.getDeclaringClass();
								String filename = getFileName(sc);
								
								
								File file = new File("./dot/" + projName + "/"+ filename + "_" + line +".dot");
								if(!file.exists())
									try {
										file.getParentFile().mkdirs();
										file.createNewFile();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								System.out.println("./dot/"+  projName + "/"+filename + "_" + line +".dot" );
								
								FileWriter fw;
								try { 
									fw = new  FileWriter(file);
									AHGAtomicSetTosser.dotEx.export4AHG(fw, AHGAtomicSetTosser.toBuildG);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							

							
							
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
			    tn2SE.put(tn, toret);
			   // System.err.println(somewords + " side effect (nonempty, nonjava fields)#"+nonemptyf);
               //  return nonemptyf>0;
				
			}

			private boolean  printRWSet(CodeBlockRWSet tnRSet, String somewords) {
			
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
							System.out.println(g.toString());
						}
					}
					else {
						System.out.println(g.getClass());
					}
					
					
					
				}
				System.out.println(somewords + "  side effect (nonjava G)#:"+gnum+"\n");	
			       
				
				
				
				
				
				
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
							System.out.println(f.toString());
						}
					}
					else {
						System.out.println(f.getClass());
					}
					
					
				}
			    System.out.println(somewords + " side effect (nonempty, nonjava fields)#"+nonemptyf);
                 return nonemptyf>0;
				
			}
		}));

	}




	

}
