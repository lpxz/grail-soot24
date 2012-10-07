package Drivers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.util.Chain;

public class PublicIt {
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 public  static  HashSet<SootClass>  publicizedClasses = new HashSet<SootClass>();
	 

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
        String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin Toy"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		// do not use the jar directly,
		// unzip it to a folder, and parse the folder like above.
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfpaddleJar;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		
		Options.v().set_output_format(Options.output_format_c);
		
		List excludesList= new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);
		
		Options.v().set_output_dir("paddle_public.jar");
		Options.v().set_output_jar(true);// same as the name as the outdir (actually substitue it), so must be set.
		
		
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
//		Setup.setPhaseOptionsForSparkWork();



		
		 
		Pack jtp = PackManager.v().getPack("jtp");
		addPublicizePackToJtp(jtp);
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

	private static void addPublicizePackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.publicit", new BodyTransformer() {

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				SootMethod  sm =b.getMethod();
				if(sm.isPrivate())
				{
					int  modifiers =sm.getModifiers();
					modifiers= modifiers ^ Modifier.PRIVATE;
					modifiers =modifiers | Modifier.PUBLIC;
					sm.setModifiers(modifiers);
				}
				
				//====for class's field
				SootClass theclass = sm.getDeclaringClass();
				if(!publicizedClasses.contains(theclass))
				{
	
					if(theclass.getName().contains("PaddleContextSensitiveCallGraph"))
					{
						System.out.println();// for debug
					}
					Iterator<SootField> fieldit =theclass.getFields().iterator();
	                while (fieldit.hasNext()) {
						SootField sootField = (SootField) fieldit.next();
						if(!sootField.isPublic())
						{
							if(sootField.isPrivate())
							{
								int  modifiers =sootField.getModifiers();
								modifiers= modifiers ^ Modifier.PRIVATE;
								modifiers =modifiers | Modifier.PUBLIC;
								sootField.setModifiers(modifiers);
							}
							
							if(sootField.isProtected())
							{
								int  modifiers =sootField.getModifiers();
								modifiers= modifiers ^ Modifier.PROTECTED;
								modifiers =modifiers | Modifier.PUBLIC;
								sootField.setModifiers(modifiers);
							}
							
							{
								int  modifiers =sootField.getModifiers();
								
								modifiers =modifiers | Modifier.PUBLIC;// set anyway
								sootField.setModifiers(modifiers);
							}
							
							
						}
						
						
						
						
					}
					publicizedClasses.add(theclass);
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
