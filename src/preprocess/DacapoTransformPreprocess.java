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


public class DacapoTransformPreprocess {

	/**
	 * @param args
	 */
	public static HashSet<String> usedJDKOps = new HashSet<String>();
	public static HashSet<String> randomOps = new HashSet<String>();
	public static void main(String[] args) {
	
//		System.out.println("loading the general arguments from leap.transformer.arg:");
//		String arglineFileName = Util.getTransformerArgFile();
//		String argline =Util.getArgLine(arglineFileName);
//		String[] argline_items = argline.split(" ");
//		String outputFormat= argline_items[0];
//		String cpath= argline_items[1];
//		String mainClass = argline_items[2];
		
		// teh arg is in the build.xml!!!

		String outputFormat= args[0];
		String cpath= args[1];
		String mainClass = args[2];		
		String intermediateCP = "/home/lpxz/eclipse/workspace/soot24/preprocessed/" + System.getProperty("current.application");
		String jceJar = "/home/lpxz/java_standard/jre/lib/jce.jar";
		String rtJar = "/home/lpxz/java_standard/jre/lib/rt.jar";
		String argsOfmtrt = "-w -app -f " + outputFormat	
			    +" -p cg.spark enabled -p cg reflection-log:"+cpath+"/refl.log" 
				+ " -cp "
				+ jceJar + ":" + rtJar + ":" +cpath
				+ " -main-class "
				+ mainClass
				+ " "
				+ mainClass
				+ " -d "
				+ intermediateCP
				+" -i org.apache -i org.w3c"
				;
		String interString = argsOfmtrt;
		String[] finalArgs = interString.split(" ");
//		-w -app -f c -p cg reflection-log:/home/lpxz/benchmark/tamiflex/out/tradebeans-small/refl.log 
//		-cp /home/lpxz/java_standard/jre/lib/jce.jar:/home/lpxz/java_standard/jre/lib/rt.jar:
//			/home/lpxz/benchmark/tamiflex/out/tradebeans-small -main-class Harness Harness
//			-d /home/lpxz/eclipse/workspace/soot24/preprocessed/tradebeans -i org.apache -i org.w3c
//			
//			-w -app -p cg.spark enabled -p cg reflection-log:
//				/home/lpxz/benchmark/tamiflex/out/tradebeans-small/refl.log -cp
//				/home/lpxz/java_standard/jre/lib/jce.jar:/home/lpxz/java_standard/jre/lib/rt.jar:
//					/home/lpxz/benchmark/tamiflex/out/tradebeans-small -main-class Harness -include 
//					org.apache. -include org.w3c. 
//			-d /home/lpxz/benchmark/tamiflex/sootified/tradebeans-small/ Harness
		
			
			soot.Main.v().processCmdLine(finalArgs);
		System.out.println(argsOfmtrt);
		soot.Main.v().autoSetOptions();
			
		Scene.v().loadNecessaryClasses();	
		
		
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
	

	}


}
