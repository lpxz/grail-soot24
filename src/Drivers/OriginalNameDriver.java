package Drivers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Local;
import soot.Pack;
import soot.PackManager;
import soot.PointsToAnalysis;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.Stmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.thread.mhp.MhpTransformer;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;

import soot.options.Options;
import soot.util.Chain;

public class OriginalNameDriver {
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer

		String bootclasspath = System.getProperty("sun.boot.class.path");
		String argsOfEasyLib = "-f J -cp "
				+ bootclasspath
				+ ":/home/lpxz/eclipse/workspace/Playground/bin -process-dir /home/lpxz/eclipse/workspace/Playground/bin"; // java.lang.Math

		// /home/lpxz/eclipse/workspace/Playground/src/HasnextTest.java
		String argsOfJavaLib = "-f J -cp "
				+ bootclasspath
				+ ":/home/lpxz/java_standard/jre/lib/rt.jar -process-dir /home/lpxz/work/soot/subjects/rt"; // java.lang.Math
		String argsOfGoogleLib = "-f J -cp "
				+ bootclasspath
				+ ":/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin:/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/com/google/jsr-305-read-only/ri/build/classes:/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/com/google/jsr-305-read-only/ri/build/jsr305.jar:/home/lpxz/work/soot/subjects/google/google-collect-1.0/google-collect-1.0.jar"
				+ " -process-dir /home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/separateDir";// com.google.common.collect.TreeMultiset";// -process-dir /home/lpxz/work/soot/subjects/google/google-collect-1.0/bin";
																											// //java.lang.Math
		String argsOfToyW = "-f c -pp -cp /home/lpxz/eclipse/workspace/leap/transformer/bin --app anode_opt_example.Example"; // java.lang.Math
		String argsOfToyW2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/sootOutput --app anode_opt_example.Example"; // java.lang.Math
		
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToyW2;// argsOfToyW-> argsOfToyW2, can the name be kept? manually set the arg please!
		// I can not find the solution to keep the original names of variables.
		
		
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();


		Scene.v().loadNecessaryClasses();
	// 	 Setup.setPhaseOptionsForPaddleWork();
	    Setup.setPhaseOptionsForSparkWork();


		
		 
         
		 Pack wjtp = PackManager.v().getPack("wjtp");
		 // I can not remmeber the option for Mhptransformer, so I have to call it 
		 // this way
		 // notice: R.L thinks lin's implementation is kind of bad, so he directly 
		 //discard the original version, and let the MhpTransformer direct to his
		 // implementation where syncoblivousMHP works. and the mhp(method, stmt,method,stmt)
		 // => mhp(method,method)
		 //but I really likes lin's staff:
		 // like the methodinline, ICFG, dataflow analysis. 
		wjtp.add(new Transform("wjtp.clonetest", new SceneTransformer() {
			
			@Override
			protected void internalTransform(String phaseName, Map options) {
			   SootMethod sm = Scene.v().getMainMethod();
               Body b =sm.getActiveBody();
              
               Iterator<Local> lIT =b.getLocals().iterator();
              
              PointsToAnalysis p2a = Scene.v().getPointsToAnalysis();
               while (lIT.hasNext()) {
				Local local = (Local) lIT.next();
				PointsToSetInternal p2sI = (PointsToSetInternal)p2a.reachingObjects(local);
				System.out.println("");
				System.out.println("");
				System.out.println("Local:" + local);
				p2sI.forall(new P2SetVisitor() {
					
					@Override
					public void visit(Node n) {
						System.out.println(n.toString());
						
					}
				});
				
				
			
				
			}
			   
			}
		}));

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

	


	

}
