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
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

public class AHGAtomicSetTosser {
    private static final String ARRAYFIELDNAME = "ARRAYFIELD";
	static HashMap<String,  PointsToSet> diction = new HashMap< String, PointsToSet>();
    static Stack<String > fpath = new Stack<String>();
	public static PointsToAnalysis p2a = null;
//	static DirectedPseudograph toBuildG=null;
	public static DOTExporter<String, DefaultEdge> dotEx= new DOTExporter<String, DefaultEdge>();
public 	static DirectedPseudograph<String, DefaultEdge> toBuildG = null;// 
public 	static CodeBlockRWSet atomicsetSE =null;

public static HashMap<String, CodeBlockRWSet> region2SE = new  HashMap<String, CodeBlockRWSet>();
	
	
	
	
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

		wjtp.add(new Transform("wjtp.atomicsettosser", new SceneTransformer() {
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
				
		
				
				{ // one iteration 
					Local local =(Local) localS.toArray()[0];
					toBuildG = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
			        atomicsetSE =null; 
					ahg_root(local);
					File file = new File(local.getName()+".dot");
					FileWriter fw;
					try { 
						fw = new  FileWriter(file);
						dotEx.export4AHG(fw, toBuildG);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}

		}));

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}



	public static void ahg_root(Local root) {//String varSig
		fpath.clear();
		diction.clear();// otherwise, the later run will automatically terminates because everything has been visited..
		String varSig= root.getName();
	//	Local root = getit(varSig);
		PointsToSet rootp2s = p2a.reachingObjects(root);
		
        fpath.push(varSig);
        String stringrep = getStringRep4Stack(fpath);
		diction.put( stringrep,rootp2s);
		ahg_dfs(rootp2s);
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
	private static void ahg_dfs(PointsToSet rootp2s) //clean graph, you can
	// further generate regular expression fpath in the clean graph.
	{
		
		//==> rootp2s
	//	Set<PointsToSet> childp2ss =  new HashSet<PointsToSet>();//maybe useless
		Set<Object> fset = getPossibleFields(rootp2s);
		PointsToSet equivRootp2s= getValue_contentbased(diction,rootp2s);
		if(equivRootp2s==null)
		{
			equivRootp2s = rootp2s;
		    System.err.println("root should be visited as others' child, so should have a counterpart in the hashmap!!!");
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
					PointsToSet equivChildp2s= getValue_contentbased(diction,childp2s);
					if(equivChildp2s==null)// white node, content-based is purely ok, because they internally care about only content.!
					//originally using diction.containsvalue(childp2s);
					{
						String parentName = getStringRep4Stack(fpath);
						String fname = sootField.getName();
						fpath.push(fname);
						String currName  = getStringRep4Stack(fpath);
						diction.put(currName,childp2s);
						graphutil_contentbased(equivRootp2s, childp2s, fname);
						
						ahg_dfs(childp2s);// recursive
						fpath.pop();
						
						//childp2ss.add(childp2s);
						//graphUtil();
					}
					else { // has been visited, but still, multiple edge, a->b through c, d
						String parentName = getStringRep4Stack(fpath);
						String fname = sootField.getName();
						fpath.push(fname);
						String currName  = getStringRep4Stack(fpath);
						diction.put(currName,equivChildp2s);
						graphutil_contentbased(equivRootp2s, equivChildp2s, fname);
						
						fpath.pop();
					}

					
				} else if (sootField.isStatic()) {
					PointsToSet childp2s = p2a.reachingObjects(sootField);
					PointsToSet equivChildp2s= getValue_contentbased(diction,childp2s);
					if(equivChildp2s==null)
					{
						
						String parentName = getStringRep4Stack(fpath);
						String fname = sootField.getName();
						fpath.push(fname);
						String currName  = getStringRep4Stack(fpath);
						diction.put(currName,childp2s);
						graphutil_contentbased(equivRootp2s, childp2s, fname);
									
						ahg_dfs(childp2s);// recursive
						fpath.pop();
						//childp2ss.add(childp2s);
					}
					else {
						String parentName = getStringRep4Stack(fpath);
						String fname = sootField.getName();
						fpath.push(fname);
						String currName  = getStringRep4Stack(fpath);
						diction.put(currName,equivChildp2s);
						graphutil_contentbased(equivRootp2s, equivChildp2s, fname);
						
						fpath.pop();
					}
					
				}

			} else if (fieldLike instanceof ArrayElement) {
				PointsToSet childp2s = p2a
						.reachingObjectsOfArrayElement(rootp2s);
				PointsToSet equivChildp2s= getValue_contentbased(diction,childp2s);
				if(equivChildp2s==null)
				{
					
					String parentName = getStringRep4Stack(fpath);
					String fname = ARRAYFIELDNAME;
					fpath.push(fname);
					String currName  = getStringRep4Stack(fpath);
					diction.put(currName,childp2s);
					graphutil_contentbased(equivRootp2s,childp2s, fname);
								
					
				
					ahg_dfs(childp2s);// recursive
					fpath.pop();
					//childp2ss.add(childp2s);
				}
				else {
					String parentName = getStringRep4Stack(fpath);
						String fname = ARRAYFIELDNAME;
					fpath.push(fname);
					String currName  = getStringRep4Stack(fpath);
					diction.put(currName,equivChildp2s);
					graphutil_contentbased(equivRootp2s, equivChildp2s, fname);
					
					fpath.pop();
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
		HashMap<String, PointsToSet> diction2, PointsToSet childp2s) {
		Iterator<PointsToSet> p2sIT = diction2.values().iterator();
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
			String parentName = ""+ ((PointsToSetInternal)parentSet).pointsToSetHashCode();
			String currName =""+ ((PointsToSetInternal)currSet).pointsToSetHashCode();
			
			if(!toBuildG.containsVertex(parentName))
			{
				toBuildG.addVertex(parentName);
				
			}
			if(!toBuildG.containsVertex(currName))
			{
				toBuildG.addVertex(currName);
			}
		//	if(toBuildG.con)
			DefaultEdge labelE = new DefaultEdge();
			if(hit((PointsToSetInternal)parentSet, edgeName))
			{
				labelE.setLabel("XXX"+ edgeName);
			}
			else {
				labelE.setLabel(edgeName);
			}
			
	        toBuildG.addEdge(parentName, currName, labelE);
		}
		else {
			throw new RuntimeException("nto pointtosetInternal impl!");
		}
		
		
	}

	private static boolean hit(PointsToSetInternal parentSet, String edgeName) {
		Set fs  =atomicsetSE.getFields();
		for(Object f : fs)
		{
			if(f instanceof SootField)
			{
				SootField sf = (SootField)f;
				if(sf.getName().equals(edgeName))
				{
					PointsToSet aset = atomicsetSE.getBaseForField(f);
					return aset.hasNonEmptyIntersection(parentSet);// if true, then true
				}
			}
			
		}
		return false;
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
