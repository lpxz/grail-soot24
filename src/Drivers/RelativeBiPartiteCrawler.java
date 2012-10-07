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
import java.util.Set;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import org.jboss.serial.io.JBossObjectOutputStream;
import org.jgrapht.graph.BiPartitegraph;
import org.jgrapht.graph.DefaultEdge;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Pack;
import soot.PackManager;
import soot.PointsToAnalysis;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.jimple.toolkits.visitor.dataview.VisitorForRelativeGroup;
import soot.options.Options;
import soot.util.Chain;

public class RelativeBiPartiteCrawler {
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 public static PointsToAnalysis pToAnalysis=null;
	public static  BiPartitegraph<Object, DefaultEdge> gBiPartite=null;

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;
    // @VisitorForRelativeGroup
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
		String argsOfToy = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app Toy"; // java.lang.Math
		
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();

		Visitor.setObserverClass("soot.jimple.toolkits.visitor.ObserverForActiveTesting");
		Scene.v().loadClassAndSupport(Visitor.observerClass);//insert something here
		
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();

		// remmeber to close the spart and w option!
	   rv = new RecursiveVisitor(null);
	   solidVisitor = new VisitorForRelativeGroup(rv);//new VisitorForActiveTesting(rv);
		rv.setNextVisitor(solidVisitor);
		//observer is some sample code

		
		 

		 Pack wjtp = PackManager.v().getPack("wjtp");
		 addCrawlerPackToWjtp(wjtp);

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

	
	private static void addCrawlerPackToWjtp(Pack wjtp) {
		wjtp.add(new Transform("wjtp.visitor", new SceneTransformer() {
        
			@Override
			protected void internalTransform(String phaseName, Map options) {
				// MethodVisitor visitor = new MethodVisitor();
				pToAnalysis= Scene.v().getPointsToAnalysis();
				gBiPartite= new BiPartitegraph<Object, DefaultEdge>(DefaultEdge.class);

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
				
				//===============we can persist the bipartite graph here. and do not run spark anymore..
                 // never trust any tool in persisting soot objects, the objects are so ...
				  List<Set<Object>>    varComps  = gBiPartite.weaklyConnectedComponentsOnX();
				List<Set<Object>>	anodeComps= gBiPartite.weaklyConnectedComponentsOnY();

				   System.out.println("zxxx");
				//retraverse using another visitor to test assign which component a variable belongs to 
				

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



}
