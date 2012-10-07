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
import soot.Pack;
import soot.PackManager;
import soot.PhaseOptions;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.Stmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.toolkits.invoke.LPInliner;
import soot.jimple.toolkits.invoke.LPInlinerErr;
import soot.jimple.toolkits.thread.mhp.MhpTransformer;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.util.Chain;

public class InlineCrawler {
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link JimpleGen, JimpleBlockToJavaInvo  => efficiency
		// StaticMethodBinder StaticInliner
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
		String argsOfToy = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app Toy"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();
		
		Scene.v().loadNecessaryClasses();
	    Setup.setPhaseOptionsForSparkWork();

	    boolean usingDefault= false;
	    if(usingDefault)
	    {
	     PhaseOptions.v().setPhaseOption("wjop","enabled:true");
	     // StaticMethodBinder: change the virtual invoke to the static method invo, 
	     // and the method is changed correspondingly
	     // three preconditions: type checker, nullchecker, synchron on the this object 
         PhaseOptions.v().setPhaseOption("wjop.smb","enabled:true");
         // StaticInliner: merge the body of the callee into the parent body
         // flow is: clone units, clone locals, new traps, and identityStmt swaps to assign, return swaps to goto
         // also three preconditions as above
         // they do the work in reversed topo order to avoid messy. 
         // also theycontrol factors to decide whether or not 
         // to do the inliner (if inlinee size is too large, refuse..)
         PhaseOptions.v().setPhaseOption("wjop.si","enabled:true");
	    }
	    else {
	    	 Pack wjtp = PackManager.v().getPack("wjtp");

	   		wjtp.add(new Transform("wjtp.LPinliner", new LPInliner()));
	    		// you need to tell :
	    		// tgt, invokeStmt, containerMethod
	    		// to LPinliner.tgt_Invo_Container_Lists which is of type LIst<List>.
		        // just go to the LPinliner's internalTransformer \
	    		// and tell the info just there at the beginning. 
	    }

	 
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

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				// MethodVisitor visitor = new MethodVisitor();

				 SootMethod sootMethod = b.getMethod();
			      Visitor.thisClass = sootMethod.getDeclaringClass();
				Body body = sootMethod.getActiveBody();
				
				Chain units = body.getUnits();

				solidVisitor.visitMethodBegin(sootMethod, units);
				Iterator stmtIt = units.snapshotIterator();
				while (stmtIt.hasNext()) {
					Stmt s = (Stmt) stmtIt.next();
					solidVisitor.thisStmt = s;
					solidVisitor.visitStmt(sootMethod, units, s);
				}
				solidVisitor.visitMethodEnd(sootMethod, units);
				body.validate();

			}
		}));

	}

	private static void addVisitorToWjtp(Pack wjtp) {
		wjtp.add(new Transform("wjtp.visitor", new SceneTransformer() {

			@Override
			protected void internalTransform(String phaseName, Map options) {
				// MethodVisitor visitor = new MethodVisitor();


				Chain<SootClass> classes = Scene.v().getApplicationClasses();
				Iterator<SootClass> classesIt = classes.iterator();
				while (classesIt.hasNext()) {
					SootClass sootClass = (SootClass) classesIt.next();
				      
					List<SootMethod> methods = sootClass.getMethods();
					Iterator<SootMethod> methodIt = methods.iterator();
					while (methodIt.hasNext()) {
						SootMethod sootMethod = (SootMethod) methodIt.next();
						if (sootMethod.isAbstract())
							continue;
						if (sootMethod.isNative())
							continue;
						
					    Visitor.thisClass = sootMethod.getDeclaringClass();
					    if(!sootMethod.hasActiveBody()) continue;
						Body body = sootMethod.getActiveBody();
						Chain units = body.getUnits();

						solidVisitor.visitMethodBegin(sootMethod, units);
						Iterator stmtIt = units.snapshotIterator();
						while (stmtIt.hasNext()) {
							Stmt s = (Stmt) stmtIt.next();
							solidVisitor.thisStmt = s;
							solidVisitor.visitStmt(sootMethod, units, s);
						}
						solidVisitor.visitMethodEnd(sootMethod, units);
						body.validate();

					}
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
