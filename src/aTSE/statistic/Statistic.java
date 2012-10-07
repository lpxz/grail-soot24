package aTSE.statistic;

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

import java_cup.version;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import junit.framework.Assert;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedPseudograph;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import Drivers.Utils;
import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.IntType;
import soot.Local;
import soot.Pack;
import soot.PackManager;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.RefType;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Type;
import soot.Unit;
import soot.JastAddJ.PrimitiveType;
import soot.jimple.Stmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.spark.pag.ArrayElement;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.thread.mhp.MhpTransformer;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;

import soot.options.Options;
import soot.tagkit.LineNumberTag;
import soot.util.Chain;


public class Statistic {
    private static final String ARRAYFIELDNAME = "ARRAYFIELD";
	static HashSet<PointsToSet> cache = new  HashSet<PointsToSet>();
	public static PointsToSet gRootP2S=null;
	static PointsToAnalysis p2a = null;

	private static final String LINENUMBERTAG = "LineNumberTag";
	
	
	
	
	
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
		String argsOfToy = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy"; // java.lang.Math
		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app TestRegular.Freak"; // java.lang.Math
		String argsOfBayes = "-f J -pp -cp /home/lpxz/eclipse/workspace/jstamp/bin --app Bayes.Bayes"; // java.lang.Math
		
		String[] argArray = new String[15];
		String argsOfCompress = "-f J -pp -cp /home/lpxz/eclipse/workspace/SPECJVM_runnable/bin --app spec.benchmarks._201_compress.Main"; // java.lang.Math
		String argsOfjess = "-f J -pp -cp /home/lpxz/eclipse/workspace/SPECJVM_runnable/bin --app spec.benchmarks._202_jess.Main"; // java.lang.Math
		String argsOfjflex= "-f J -pp -cp /home/lpxz/eclipse/workspace/JFlex/bin --app JFlex.Main"; // java.lang.Math
		String argsofjgrapht= "-f J -pp -cp /home/lpxz/eclipse/workspace/jgrapht_coarselock/bin --app InsertionTest"; // java.lang.Math
		String argsofjtar= "-f J -pp -cp /home/lpxz/eclipse/workspace/jtar/bin --app org.xeustechnologies.jtar.JTarTest"; // java.lang.Math
		String argsofmuffine= "-f J -pp -cp /home/lpxz/eclipse/workspace/muffine/bin --app org.doit.muffin.Main"; // java.lang.Math
		String argsOfRT = "-f J -pp -cp /home/lpxz/eclipse/workspace/SPECJVM_runnable/bin --app spec.benchmarks._205_raytrace.Main"; // java.lang.Math
		String argsofsablecc= "-f J -pp -cp /home/lpxz/eclipse/workspace/sablecc/bin --app org.sablecc.sablecc.SableCC"; // java.lang.Math
		String argsofsockproxy= "-f J -pp -cp /home/lpxz/eclipse/workspace/socks/bin --app SOCKS"; // java.lang.Math
		String argsofsockecho= "-f J -pp -cp /home/lpxz/eclipse/workspace/socks/bin --app SocksEcho"; // java.lang.Math
		String argsofsoot= "-f J -pp -cp /home/lpxz/eclipse/workspace/soot224/bin --app soot.Main"; // java.lang.Math
		String argsofspecjbb= "-f J -pp -cp /home/lpxz/eclipse/workspace/specjbb2005107_runnable/bin --app spec.jbb.JBBmain"; // java.lang.Math
		
		
		String argsOfmergesort = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app mergesort.MergeSort"; // java.lang.Math
		String argsOfsb = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app stringbuffer.StringBufferTest"; // java.lang.Math
		
		String argsOfarraylist = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app benchmarks.dstest.MTArrayListTest"; // java.lang.Math
		
		String argsOfLinkedList = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app benchmarks.dstest.MTLinkedListInfiniteLoop"; // java.lang.Math
		
		String argsOfhashset = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app benchmarks.dstest.MTSetTest"; // java.lang.Math
		
		String argsOftreeset = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app benchmarks.dstest.MTTreeSetTest"; // java.lang.Math
		
		String argsOfraytracer = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app benchmarks.JGFRayTracerBenchSizeA"; // java.lang.Math

		String argsOfcache4j = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app net.sf.cache4j.test.Cache4jTester"; // java.lang.Math
		
		String argsOfspecjbb = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app spec.jbb.JBBmain"; // java.lang.Math
		
		String argsOfhedc = "-f J -pp -cp /home/lpxz/eclipse/workspace/calFuzzer/bin --app benchmarks.hedc.Tester"; // java.lang.Math
		
		String argsOfopenjms = "-f J -pp -cp /home/lpxz/java_standard/jre/lib/jsse.jar:/home/lpxz/eclipse/workspace/openjms/bin --app driver.OpenJMSDriver"; // java.lang.Math
		
		String argsOfderby = "-f J -app -pp -cp /home/lpxz/java_standard/jre/lib/jsse.jar:/home/lpxz/eclipse/workspace/derby-10.3.2.1/build -process-dir /home/lpxz/eclipse/workspace/derby-10.3.2.1/build"; // java.lang.Math
		
		//String argsOfjigsaw = "-f J -pp -cp /home/lpxz/eclipse/workspace/app/bin --app spec.jbb.JBBmain"; // java.lang.Math
		
		
     //  int first = Integer.parseInt(args[0]);
	    
	   {
		   argArray[0]= argsOfmergesort;
		   argArray[1] = argsOfsb;
		   argArray[2] = argsOfarraylist;
		   argArray[3] = argsOfLinkedList;
		   argArray[4] = argsOfhashset;
		   argArray[5] = argsOftreeset;
		   argArray[6] = argsOfraytracer;
		   argArray[7] = argsOfcache4j;
		   argArray[8]= argsOfspecjbb;
		   argArray[9]= argsOfhedc;
		   argArray[10]= argsOfopenjms;
		   argArray[11]= argsOfderby;
		  
	   }
       
        for(int i=11; i<=11; i++)
        {
        	  String interString = argArray[i];
        	  System.out.println(interString);
   		   try {
   			   processIteration(interString);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
        }
//		 
	   
		 
		
	  
	
		
	}


	
	private static void processIteration(String interString) {
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();

		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();

		Pack wjtp = PackManager.v().getPack("wjtp");

		wjtp.add(new Transform("wjtp.statistic", new SceneTransformer() {
			// Scene.v().getPointsToAnalysis();
			@Override
			protected void internalTransform(String phaseName, Map options) {
	           int  classNo =0;
	           int methodNo  =0;
	           int stmtNo =0;
	           int lineNo=0;
	           int staticFieldNo =0;
	           int instanceFieldNo =0;
	           
	          Chain<SootClass> scs = Scene.v().getApplicationClasses();
	          classNo = scs.size();
			  Iterator<SootClass > it  = scs.iterator();
			  while (it.hasNext()) {
				SootClass sootClass = (SootClass) it.next();
				methodNo+=sootClass.getMethodCount();
				Iterator<SootField>  fit = sootClass.getFields().iterator();
				while (fit.hasNext()) {
					SootField sootField = (SootField) fit.next();
					if(sootField.isStatic()) {
						staticFieldNo ++;
					}
					else {
						instanceFieldNo++;
					}
					
				}
				Iterator<SootMethod> mit = sootClass.getMethods().iterator();
			    while (mit.hasNext()) {
					SootMethod sootMethod = (SootMethod) mit.next();
					System.out.println(sootMethod.toString());
					
					Set locs = new HashSet();
					int badStmtAsLine =0;
					if(sootMethod.hasActiveBody())
					{
					   Iterator<Unit> uit =sootMethod.getActiveBody().getUnits().iterator();
					   while (uit.hasNext()) {
						Unit unit = (Unit) uit.next();
						stmtNo ++;
						Stmt stmt = (Stmt ) unit;
						LineNumberTag lt = (LineNumberTag)unit.getTag(LINENUMBERTAG);
						
						if(lt!=null)
						{
						  lineNo=	lt.getLineNumber();
						  locs.add(lineNo);
						}
						else {
							badStmtAsLine++;
						//	System.err.println("warning: bad lines");
						}

							
						}
					   lineNo+= locs.size();
					   lineNo +=badStmtAsLine;
					}
					   
					   
				}
					
	
			  } 

			 
	           System.out.println("class:" + classNo);
	           System.out.println("method:" + methodNo);
	           System.out.println("stmt:" + stmtNo);
	           System.out.println("line:" + lineNo);
	           System.out.println("static fields" + staticFieldNo);
	           System.out.println("instance fields" + instanceFieldNo);

	          
			}
		}));

		PackManager.v().runPacks();// 1
	//	PackManager.v().writeOutput();
		G.reset();
		
	}





}
