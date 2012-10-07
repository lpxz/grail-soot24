package aTSE_leap;

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
import soot.jimple.LongConstant;
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

public class De_Random_transformer {
	protected static final String injectedMethodName = "sayHello";
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 
	public static String[] classMethodPair = new String[2];

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
String argsOfToyW = "-f c -pp -cp . java.util.Random"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfmtrt = "-f c -pp -cp /home/lpxz/eclipse/workspace/mtrt/bin -main-class spec.benchmarks._227_mtrt.Main spec.benchmarks._227_mtrt.Main"; // java.lang.Math
		//String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin -d /home/lpxz/eclipse/workspace/Playground/bin Toy$InnerThread"; // java.lang.Math
		
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");
		classMethodPair[0]= "java.util.Random";//"aTest.Teacher";
		classMethodPair[1]= "setSeed"; //"callee";
		
		soot.Main.v().processCmdLine(finalArgs);
//		Setup.setupPatchOptions();

		
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
					Iterator<Unit> stmtIt = units.snapshotIterator();
					while (stmtIt.hasNext()) {
/*				templatecode:
						synchronized public void setSeed(long seed) {
					        seed = (seed ^ multiplier) & mask;
					        this.seed.set(seed);
					    	haveNextNextGaussian = false;
					    } */
						Unit unit = stmtIt.next();
						Stmt  stmt = (Stmt)unit;
						if(stmt.containsInvokeExpr())
						{
							InvokeExpr ie =stmt.getInvokeExpr();
							if(ie.getMethod().getName().equals("set"))
							{
								ie.setArg(0, LongConstant.v(0));// cool, fixed
							}
						}
						
						
						
					}
					b.validateLP();

					
				}
				
				
				
				
				
				
				
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
