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


public class DacapoTransformPreprocess_fullarg {

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
		

		
		





//		soot.Main.v().processCmdLine(args);
//		
//	
//		Scene.v().loadNecessaryClasses();
		
//		Setup.setPhaseOptionsForSparkWork();
//		PhaseOptions.v().setPhaseOption("cg.spark", "on-fly-cg:false");
		
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
		
		soot.Main.main(args);

//		PackManager.v().runPacks();// 1
//		PackManager.v().writeOutput();


	}


}
