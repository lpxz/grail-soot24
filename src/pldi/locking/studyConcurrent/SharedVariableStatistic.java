package pldi.locking.studyConcurrent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import ca.pfv.spmf.tests.MainTestDCI_Closed_Optimized;

import pldi.locking.*;
import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import Drivers.Utils;
import soot.AnySubType;
import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Modifier;
import soot.NullType;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PointsToAnalysis;
import soot.PointsToSet;
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
import soot.jimple.ArrayRef;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.jimple.toolkits.pointer.SideEffectAnalysis;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.mhp.MhpTester;
import soot.jimple.toolkits.thread.mhp.SynchObliviousMhpAnalysis;

import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class SharedVariableStatistic {
	public static boolean typebased= false; //;System.getProperty("typebased.option").equals("true");
	static String curApp = System.getProperty("current.application");
	static String curMinSupport = System.getProperty("current.min.support");
	 static  int curMS =2; // Integer.valueOf(curMinSupport);
	
	   public static String currentBM  = null;
	
	

	protected static boolean optionOpenNesting = false;
	protected static boolean RWtogether = true;
	public static HashMap methodToExcUnitGraph = new HashMap();// run only once
																// after all
	public static HashMap methodToFlowSet = new HashMap();// run only once after
															// all

	public static HashMap field2Id = new HashMap();
	public static HashMap id2field =null;
	public static int curId = 0;

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer

//		String outputFormat= "J";
//		String cpath="/home/lpxz/benchmark/tamiflex/out/xalan-small";
//		String mainClass = "Harness";
		
		
		System.out.println("xx");
		String excludeOption = "";
		String includeOption = " -i org.apache -i org.w3c";
		String reflectionOption = "true";
		
		
		String outputFormat= args[0];
		String cpath=args[1];
		String mainClass = args[2];	
		int index =cpath.lastIndexOf('/');
		currentBM=cpath.substring(index+1);
//		String excludeOption = System.getProperty("exclude.option");
//		String includeOption = System.getProperty("include.option");
//		String reflectionOption = System.getProperty("dacapo.reflection.option");
		String reflString = reflectionOption.equals("true")?" -p cg reflection-log:"+cpath+"/refl.log":"";
		
		String jceJar = "/home/lpxz/java_standard/jre/lib/jce.jar";
		String rtJar = "/home/lpxz/java_standard/jre/lib/rt.jar";
		String argsOfmtrt = "-w -app -p cg.spark enabled -f " + outputFormat	
			    + reflString
				+ " -cp "
				+ jceJar + ":" + rtJar + ":" +cpath
				+ " -main-class "
				+ mainClass
				+ " "
				+ mainClass
				+excludeOption
				+includeOption
		        ;
//				+ " -d "
//				+ intermediateCP
				
		
		String interString = argsOfmtrt;
		String[] finalArgs = interString.split(" ");		
		System.out.println(argsOfmtrt);
	

		Pack wjtp = PackManager.v().getPack("wjtp");
	//	addMethodLocker2wjtp(wjtp);		
		addMUVIPackToWJtp(wjtp);
		

      // soot.Main.main(finalArgs);// tune for saving the memory
		soot.Main.v().processCmdLine(finalArgs);
		System.out.println(argsOfmtrt);
		soot.Main.v().autoSetOptions();
		Setup.setPhaseOptionsForSparkWork();
		Scene.v().loadNecessaryClasses();	
		
		PackManager.v().runPacks();// 1
		G.v().reset();  // memory
	//	PackManager.v().writeOutput();
	}

	private static void addMethodLocker2wjtp(Pack wjtp) {
		wjtp.add(new Transform("wjtp.SM2SB",
				new SceneTransformer() {
					
					@Override
					protected void internalTransform(String phaseName, Map options) {

						 
						
					Chain<SootClass> scs =Scene.v().getApplicationClasses();
					for(SootClass sc : scs)
					{
					    List<SootMethod> sms =sc.getMethods();
					    for(SootMethod sm:sms)
					    {
					    	  if(sm.isSynchronized())
							  {
								  
								  {
									  sm.setModifiers(sm.getModifiers() & ~Modifier.SYNCHRONIZED);
									  if(sm.hasActiveBody())
									  {
										 Body body = sm.getActiveBody();
										 PatchingChain<Unit> units = body.getUnits();
										 Stmt firstNon =body.getFirstNonIdentityStmt();
										 if(firstNon instanceof JReturnStmt || firstNon instanceof JReturnVoidStmt)
										 {// the empty body incurs problems during the lock injection.
											 Stmt nop=Jimple.v().newNopStmt();
											 units.insertBefore(nop, firstNon);									 
										 }	
										 MethodLocker.addlock(sm);
									  }							  
									 
								  }
								
							  }
					    }
					}
						
						
					}
				}));
		
	}

	protected static HashMap tn2SE = new HashMap();

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

	public static void addMUVIPackToWJtp(Pack wjtp) {

		wjtp.add(new Transform("wjtp.muvi", EvaluatorB.v()));

	}

}
