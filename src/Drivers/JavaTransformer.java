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

public class JavaTransformer {
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;

	public static void main(String[] args) throws IOException { // wjtp.tn
    //    String argsOfToy = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app Toy"; // java.lang.Math
		String argsOfToy_dava = "-f dava -pp -cp /home/lpxz/eclipse/workspace/Playground/bin Toy$InnerThread"; // java.lang.Math
		// -app: exceptions for synch in innerthread
		// no app: innerthread is taken as a symbol, no translation of innerthread itself.
		// no app, and decompile Toy$InnerThread: still the exceptions
		// anway, once you decompile the innerthread, the synch can not pass..
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToy_dava;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
	//	Setup.setupPatchOptions();
		
		Scene.v().loadNecessaryClasses();
	//    Setup.setPhaseOptionsForSparkWork();


	    
	 
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
