package preprocess;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Drivers.Setup;



import pldi.locking.MethodLocker;

import soot.Body;
import soot.BodyTransformer;
import soot.FastHierarchy;
import soot.Modifier;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.PhaseOptions;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.internal.JRetStmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.util.Chain;


public class TransformPreprocess {

	/**
	 * @param args
	 */
	public static HashSet<String> usedJDKOps = new HashSet<String>();
	public static HashSet<String> randomOps = new HashSet<String>();
	public static void main(String[] args) {

		String outputFormat= args[0];
		String cpath= args[1];
		String mainClass = args[2];			
		String intermediateCP = "/home/lpxz/eclipse/workspace/soot24/preprocessed/" +
		System.getProperty("current.application");
		String jceJar = "/home/lpxz/java_standard/jre/lib/jce.jar";
		String rtJar = "/home/lpxz/java_standard/jre/lib/rt.jar";
		String argsOfmtrt = "-f " + outputFormat			  
				+ " -cp "
				+ jceJar + ":" + rtJar + ":" +cpath
				+ " -main-class "
				+ mainClass
				+ " "
				+ mainClass
				+ " -d "
				+ intermediateCP
				;
		String interString = argsOfmtrt;		
		String[] finalArgs = interString.split(" ");
		soot.Main.v().processCmdLine(finalArgs);
		soot.Main.v().autoSetOptions();
		Setup.setupPatchOptions();		
		Scene.v().loadNecessaryClasses();	
		Setup.setPhaseOptionsForSparkWork();
	
		Pack wjtp = PackManager.v().getPack("wjtp");
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
		

		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
//		System.err.println("CONTAINS RANDOM INPUT, SUBSTITUTE MANUALLY IT TO FIXED VALUE FOR EVAL (no need anymore. I fixed the seed, heihei):");
//		for(String ritem  :randomOps)
//		{
//			System.err.println(ritem);
//		}
//		  
//		System.err.println("===================================");
//		System.err.println("used JDK classes, add them   to the class: edu.hkust.leap.utils.Parameters!");
//		for(String item : usedJDKOps)
//		{
//			System.err.println(item);
//		}
//		
//		
//		String string = "# SPENO  mainclass args (to added manually)\r\n" +
//		outputFormat  + " " + intermediateCP + " " +mainClass;
//        String transformargfileName = Util.getTransformerArgFile();
//        Util.writeArgLine(transformargfileName, string);
//		

	}

	
}
