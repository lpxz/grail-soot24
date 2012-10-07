package Drivers;


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
import soot.Main;
import soot.Pack;
import soot.PackManager;
import soot.PhaseOptions;
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


public class EvaluationItself {
    private static final String ARRAYFIELDNAME = "ARRAYFIELD";
	static HashSet<PointsToSet> cache = new  HashSet<PointsToSet>();
	public static PointsToSet gRootP2S=null;
	static PointsToAnalysis p2a = null;

	private static final String LINENUMBERTAG = "LineNumberTag";
	protected static final String InterfaceName = "java.io.Serializable";
	
	
	
	
	
	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;


	public static void main(String[] args) throws IOException {
    	String argsofsoot= "-w -d serialized -p cg.spark enabled:true -p wjop.si enabled:true -p wjap.uft enabled:true -p jop.cp enabled:true " +
		"-p jtp enabled:true " +
		"-f c -pp -cp /home/lpxz/eclipse/workspace/soot224/bin --app soot.Main"; // java.lang.Math
    	String[] finalArgs = argsofsoot.split(" ");
    	Pack wjtp =PackManager.v().getPack("wjtp");
        wjtp.add(new Transform("wjtp.serialize", new SceneTransformer() {
			
			@Override
			protected void internalTransform(String phaseName, Map options) {
				Iterator<SootClass> scIT = Scene.v().getApplicationClasses().iterator();
				
				while (scIT.hasNext()) {
					SootClass sootClass = (SootClass) scIT.next();
					SootClass serializableC = Scene.v().loadClassAndSupport(InterfaceName);
					if(sootClass.getName().startsWith("soot."))
					{
						if(!sootClass.implementsInterface(InterfaceName))
						{
							sootClass.addInterface(serializableC);
							System.err.println("done");
						}	
					}

//					for(SootMethod sm : sootClass.getMethods())
//					{
//						if(sm.hasActiveBody())
//						{
//							sm.getActiveBody().validateLP();
//						}
//						
//					}
				}
				
				
			}
		}));
        Main.main(finalArgs);
		
		
	}


	





}
