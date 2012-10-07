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
import java.util.Vector;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import soot.Trap;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.util.Chain;

public class InjectChocalateCrawler {
	protected static final String injectedMethodName = "sayHello";
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 
	public static String[] classMethodPair = new String[2];

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
			//		String className = "soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld";																								// //java.lang.Math
		String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f c -pp -cp . java.util.Vector"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfmtrt = "-f J -pp -cp /home/lpxz/eclipse/workspace/mtrt/bin -main-class spec.benchmarks._227_mtrt.Main spec.benchmarks._227_mtrt.Main"; // java.lang.Math
		//String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin -d /home/lpxz/eclipse/workspace/Playground/bin Toy$InnerThread"; // java.lang.Math
		
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");
		classMethodPair[0]= "java.util.Vector";//"aTest.Teacher";
		classMethodPair[1]= "get"; //"callee";
		
		soot.Main.v().processCmdLine(finalArgs);
//		Setup.setupPatchOptions();

		Visitor.setObserverClass("Drivers.Chocalate");
		Scene.v().loadClassAndSupport(Visitor.observerClass);//insert something here
		
		Scene.v().loadNecessaryClasses();



		
		 
		Pack jtp = PackManager.v().getPack("jtp");
		addVisitorPackToJtp(jtp);
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

	private static void addVisitorPackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.visitor", new BodyTransformer() {
			// insert chocalate before the returning statements

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				SootMethod sm =b.getMethod();
				SootClass sc = sm.getDeclaringClass();
				if(sc.getName().equals(classMethodPair[0]) && sm.getName().equals(classMethodPair[1]))
				{
					PatchingChain<Unit> units = b.getUnits();
					Iterator stmtIt = units.snapshotIterator();
					while (stmtIt.hasNext()) {
						Unit unit = (Unit) stmtIt.next();
						Stmt stmt = (Stmt) unit;
						if(unit instanceof JReturnStmt || unit instanceof JReturnVoidStmt)
						{
							SootClass injSC = Scene.v().loadClassAndSupport(Visitor.observerClass);//insert something here
						    SootMethod injSM = injSC.getMethodByName(injectedMethodName);
						    InvokeExpr incExpr= Jimple.v().newStaticInvokeExpr(injSM.makeRef());
						    Stmt incStmt = Jimple.v().newInvokeStmt(incExpr);
						    units.insertBefore(incStmt, stmt);
						}
						
					}
					b.validateLP();

					
				}
				
				
				
				
				
				
				
			}
		}));

	}



	private static SootClass loadClass(String name, boolean main) {
		SootClass c = Scene.v().loadClassAndSupport(name);
		c.setApplicationClass();
		if (main)
			Scene.v().setMainClass(c);
		return c;
	}

	public void testGetShimpleBody() {
		// fail("Not yet implemented"); // TODO
	}

}
