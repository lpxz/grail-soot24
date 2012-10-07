package pldi.AHG;

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

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import junit.framework.Assert;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedPseudograph;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Hierarchy;
import soot.IntType;
import soot.Local;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.PrimType;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.JastAddJ.PrimitiveType;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.spark.pag.ArrayElement;
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



public class EscapePortalAnalyzer {
	protected static final String ThreadName = "java.lang.Thread";
	protected static final Object ObjectTypeName = "java.lang.Object";
	static Set  eportals = new  HashSet();

	

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
		String argsOfBayes = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Bayes.Bayes"; // java.lang.Math

		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfBayes;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();

		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();

		Pack wjtp = PackManager.v().getPack("wjtp");

		wjtp.add(new Transform("wjtp.eportal", new SceneTransformer() {
			// Scene.v().getPointsToAnalysis();
			@Override
			protected void internalTransform(String phaseName, Map options) {
				// phase1 
				Chain<SootClass> apClasses = Scene.v().getApplicationClasses();
				for (Iterator iterator = apClasses.iterator(); iterator
						.hasNext();) {
					SootClass sootClass = (SootClass) iterator.next();
					Chain<SootField> fs = sootClass.getFields();
					for (Iterator iterator2 = fs.iterator(); iterator2
							.hasNext();) {
						SootField sootField = (SootField) iterator2.next();
						if(sootField.isStatic() && sootField.getType() instanceof RefLikeType)
						{
							if(!sootField.getType().toString().equals(ObjectTypeName))
							{ 
								eportals.add(sootField);
							}
						}
					}
					
				}
				
				//phase2
				Chain<SootClass> apClasses2 = Scene.v().getApplicationClasses();
				for (Iterator iterator = apClasses2.iterator(); iterator
						.hasNext();) {
					SootClass sootClass = (SootClass) iterator.next();
					Iterator<SootMethod> ms =sootClass.getMethods().iterator();
					while (ms.hasNext()) {
						SootMethod sootMethod = (SootMethod) ms.next();
						if(sootMethod.isAbstract()|| sootMethod.isNative()||!sootMethod.hasActiveBody())
						{
							continue;
						}
						Body  body = sootMethod.getActiveBody();
						PatchingChain<Unit> unitChain = body.getUnits();
						Iterator<Unit> unitIt =unitChain.iterator();
						while (unitIt.hasNext()) {
							Unit unit = (Unit) unitIt.next();
							Stmt stmt  = (Stmt )unit;
							if(stmt instanceof AssignStmt)
							{
								AssignStmt ass  =(AssignStmt)stmt;
							    Value  rhs= ass.getRightOp();
							    if(rhs instanceof NewExpr)
							    {
							    	NewExpr ne = (NewExpr) rhs;
							    	SootClass newType  = ne.getBaseType().getSootClass();
							    	Hierarchy hier = Scene.v().getActiveHierarchy();
							    	SootClass threadC  = Scene.v().loadClassAndSupport(ThreadName);
							    	if(hier.isClassSubclassOf(newType, threadC))// threads' family
							    	{
							    		// wrong, use the follow-up specialInvoke!
							    		// do not use object!
							    		Stmt followup= (Stmt)unitChain.getSuccOf(ass);
							    		while(!followup.containsInvokeExpr()
							    				|| !(followup.getInvokeExpr() instanceof SpecialInvokeExpr))
							    		{
							    			followup = (Stmt) unitChain.getSuccOf(followup);
							    		}
							    		if(!followup.containsInvokeExpr()
							    				|| !(followup.getInvokeExpr() instanceof SpecialInvokeExpr))
							    		{
							    			throw new RuntimeException("whether on earth do you have the speical invoke??");
							    		}
							    		
							    		SpecialInvokeExpr sie = (SpecialInvokeExpr)followup.getInvokeExpr();
							    		Iterator argIt =sie.getArgs().iterator();
							            while (argIt.hasNext()) {
											Object arg = (Object) argIt
													.next();
											Local larg = (Local)arg;
											if(larg.getType() instanceof RefLikeType)
											{
												if(!larg.getType().toString().equals(ObjectTypeName))
												{ 
													eportals.add(larg);
												}
											}
											
											
										}
							    	}
							    }
							}
							
							
						}
					}
					
					
				}
				
				//====finally:
				for (Iterator iterator = eportals.iterator(); iterator
						.hasNext();) {
				    Object eportal = iterator.next();
					System.err.println(eportal.toString());
				}
				
				
				
			}
		}));

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}

}