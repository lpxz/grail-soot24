package preprocess;

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
import soot.Modifier;
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


public class DeSynchronizationCrawler {
    private static final String ARRAYFIELDNAME = "ARRAYFIELD";
	static HashSet<PointsToSet> cache = new  HashSet<PointsToSet>();
	public static PointsToSet gRootP2S=null;
	static PointsToAnalysis p2a = null;
	
	public static int  syncMethodCount =0;

	private static final String LINENUMBERTAG = "LineNumberTag";
	
	
	
	
	
	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;


	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
		String refClassesDir = "/home/lpxz/eclipse/workspace/avrora/out/avrora-small";
		String[] strs = refClassesDir.split("/");
		String featureStr = strs[strs.length-1];
		
		String jceJar = "/home/lpxz/java_standard/jre/lib/jce.jar";
		String rtJar = "/home/lpxz/java_standard/jre/lib/rt.jar";
		String mainClass = "AvroraMainHarness";
		String argsOfAvrora = 
				"-f J -p cg reflection-log:"+refClassesDir+"/refl.log "
			+"-pp -cp :" +jceJar + ":" + rtJar + ":"+ refClassesDir //+":/home/lpxz/eclipse/workspace/avrora/bin"	// please reference the project	 
		+" -main-class "+ mainClass+" -d sootified/"+ featureStr+" "+mainClass;                              
		                   
		                                             

		 

		String[] finalArgs = argsOfAvrora.split(" ");

		soot.Main.v().processCmdLine(finalArgs);
		Setup.setupPatchOptions();

		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();

		Pack jtp = PackManager.v().getPack("jtp");
		addVisitorPackToJtp(jtp);

        

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		System.out.println(syncMethodCount);
		G.reset();
		
	
	  
	
		
	}


	private static void addVisitorPackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.visitor", new BodyTransformer() {
			// insert chocalate before the returning statements

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				SootMethod sm =b.getMethod();
				SootClass sc = sm.getDeclaringClass();

				if(sm.isSynchronized())
				{
					syncMethodCount++;
					sm.setModifiers(sm.getModifiers()&~Modifier.SYNCHRONIZED);
				}
				
			}
		}));

	}







}
