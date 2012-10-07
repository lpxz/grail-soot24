package aTSE.AHG;

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
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.thread.mhp.MhpTransformer;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;

import soot.options.Options;
import soot.util.Chain;


public class AHGBuildAnalyzer {
    private static final String ARRAYFIELDNAME = "ARRAYFIELD";
	static HashSet<PointsToSet> cache = new  HashSet<PointsToSet>();
	public static PointsToSet gRootP2S=null;
	static PointsToAnalysis p2a = null;

	public static DirectedPseudograph<PointsToSet, DefaultEdge> toBuildG = null;// 
	
	
	
	
	
	
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

		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfBayes;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();

		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();

		Pack wjtp = PackManager.v().getPack("wjtp");

		wjtp.add(new Transform("wjtp.ahganalyer", new SceneTransformer() {
			// Scene.v().getPointsToAnalysis();
			@Override
			protected void internalTransform(String phaseName, Map options) {
				//======bookkeep
				p2a = Scene.v().getPointsToAnalysis();
			   
				//=======
				String varName  = "learnerPtr";
				String methName  ="main";
				Set<Local> localS= Utils.getLocals(null, methName, varName);// seems there are 6 locals in the set.. so I limit to the main scope!
				//for(Local local =localS.toArray()[0])
				{
					Local local =(Local) localS.toArray()[0];
					toBuildG = new DirectedPseudograph<PointsToSet, DefaultEdge>(DefaultEdge.class);			
					ahgconstruct_root(local);
					CodeBlockRWSet cbSet = new CodeBlockRWSet();
					AHGTraverse.ahgvisit_root(cbSet,toBuildG, gRootP2S);// please go inside and set the proper analysis
					// can be used as a library separately, 
					// cbSet may not be used and can be null
				}				
			}
		}));

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}

	public static void ahgconstruct_root(Local root) {//String varSig
		String varSig= root.getName();
	//	Local root = getit(varSig);
		if(p2a==null )  p2a = Scene.v().getPointsToAnalysis();
		PointsToSet rootp2s = p2a.reachingObjects(root);   
		gRootP2S = rootp2s;
		cache.add(rootp2s);
		ahgconstruct_dfs(rootp2s);//toBuildG
		
	}

	public static String getStringRep4Stack(Stack<String> fpath2) {
		StringBuilder  sb = new StringBuilder("");
        for (String string : fpath2) {
			sb.append(string+".");        	
		}
        String tr = sb.toString();
		return tr.substring(0,tr.length()-1 );// not include the last one
	}

	
	/*
	 * For the same point2set from content view, they are  always represented by the first point2set in the hashmap
	 * 
	 * */
	private static void ahgconstruct_dfs(PointsToSet rootp2s) //clean graph, you can
	// further generate regular expression fpath in the clean graph.
	{
		
		//==> rootp2s
	//	Set<PointsToSet> childp2ss =  new HashSet<PointsToSet>();//maybe useless
		Set<Object> fset = getPossibleFields(rootp2s);
		PointsToSet equivRootp2s= getValue_contentbased(cache,rootp2s);
		if(equivRootp2s==null)
		{
			equivRootp2s = rootp2s;// the root may not have a counterpart
		//    System.err.println("root should be visited as others' child, so should have a counterpart in the hashmap!!!");
		}
		for (Iterator iterator = fset.iterator(); iterator.hasNext();) {
			Object fieldLike = iterator.next();
			if (fieldLike instanceof SootField) {
				SootField sootField = (SootField) fieldLike;
				if(!isInteresting(sootField))
				{
					continue;
				}
			//	if(sootField.getType())
			//	{
			//		continue;// 
			//	}
				if (!sootField.isStatic()) {
					PointsToSet childp2s = p2a.reachingObjects(rootp2s,
							sootField);
					//Object  value = diction.get(childp2s);
					PointsToSet equivChildp2s= getValue_contentbased(cache,childp2s);
					if(equivChildp2s==null)// white node, content-based is purely ok, because they internally care about only content.!
					//originally using diction.containsvalue(childp2s);
					{
						cache.add(childp2s);
						graphutil_contentbased(equivRootp2s, childp2s, sootField.getName());
						
						ahgconstruct_dfs(childp2s);// recursive
						
						
						//childp2ss.add(childp2s);
						//graphUtil();
					}
					else { // has been visited, but still, multiple edge, a->b through c, d
						
						
						cache.add(equivChildp2s);
						graphutil_contentbased(equivRootp2s, equivChildp2s, sootField.getName());						
						
					}

					
				} else if (sootField.isStatic()) {
					PointsToSet childp2s = p2a.reachingObjects(sootField);
					PointsToSet equivChildp2s= getValue_contentbased(cache,childp2s);
					if(equivChildp2s==null)
					{						
						cache.add(childp2s);
						graphutil_contentbased(equivRootp2s, childp2s, sootField.getName());
									
						ahgconstruct_dfs(childp2s);// recursive
						
						//childp2ss.add(childp2s);
					}
					else {				
						cache.add(equivChildp2s);
						graphutil_contentbased(equivRootp2s, equivChildp2s, sootField.getName());

					}
					
				}

			} else if (fieldLike instanceof ArrayElement) {
				PointsToSet childp2s = p2a
						.reachingObjectsOfArrayElement(rootp2s);
				PointsToSet equivChildp2s= getValue_contentbased(cache,childp2s);
				if(equivChildp2s==null)
				{					
					cache.add(equivChildp2s);
					graphutil_contentbased(equivRootp2s,childp2s, ARRAYFIELDNAME);				
				
					ahgconstruct_dfs(childp2s);// recursive
					
					//childp2ss.add(childp2s);
				}
				else {

					cache.add(equivChildp2s);
					graphutil_contentbased(equivRootp2s, equivChildp2s, ARRAYFIELDNAME);
					
					
				}

			}
		}
		//<==== childp2ss
		

	}



	

	private static boolean isInteresting(SootField sootField) {
		boolean judge =false;
		judge=  !sootField.isStatic();
		return judge;
	}

	private static PointsToSet getValue_contentbased(
		HashSet<PointsToSet> cache, PointsToSet childp2s) {
		Iterator<PointsToSet> p2sIT = cache.iterator();
		while (p2sIT.hasNext()) {
			PointsToSet pointsToSet = (PointsToSet) p2sIT.next();
			if(equals_contentbased(pointsToSet,childp2s))
			{
				return pointsToSet;
			}
			
		}
		
		return null;// no-match!
	}

	private static boolean equals_contentbased(PointsToSet pointsToSet,
			PointsToSet childp2s) {
		if(pointsToSet==null || childp2s==null)
			 return false;
		if(pointsToSet instanceof PointsToSetInternal && childp2s instanceof PointsToSetInternal)
		{
			final PointsToSetInternal p1 = (PointsToSetInternal) pointsToSet;
			final PointsToSetInternal c1 = (PointsToSetInternal) childp2s;
            if(p1.pointsToSetEquals(c1))
            	return true;
		}
		else {
			throw new RuntimeException("can not decide whether two point to sets are equal, choose other impl!");
		}
		
		
		return false;
	}

	private static void graphutil_contentbased(PointsToSet parentSet, PointsToSet currSet ,String edgeName ) {
		if(parentSet instanceof PointsToSetInternal && currSet instanceof PointsToSetInternal)
		{

			
			if(!toBuildG.containsVertex(parentSet))
			{
				toBuildG.addVertex(parentSet);
				
			}
			if(!toBuildG.containsVertex(currSet))
			{
				toBuildG.addVertex(currSet);
			}
		//	if(toBuildG.con)
			DefaultEdge labelE = new DefaultEdge();
			labelE.setLabel(edgeName);
	        toBuildG.addEdge(parentSet, currSet, labelE);
		}
		else {
			throw new RuntimeException("nto pointtosetInternal impl!");
		}
		
		
	}

	private static Set<Object> getPossibleFields(PointsToSet rootp2s) {
		Set<Object> fset = new HashSet<Object>();
		Set<Type> types = rootp2s.possibleTypes();
		for (Iterator iterator = types.iterator(); iterator.hasNext();) {
			Type type = (Type) iterator.next();
			if (type instanceof RefType) {
				RefType refT = (RefType) type;
				SootClass sc = refT.getSootClass();
				Chain<SootField> fs = sc.getFields();
				for (Iterator iterator2 = fs.iterator(); iterator2.hasNext();) {
					SootField sootField = (SootField) iterator2.next();
					fset.add(sootField);
				}
			} else if (type instanceof ArrayType) {
				fset.add(ArrayElement.v());
			} else {
				// it is a primitive type node. not interesting

			}

		}
		return fset;

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
