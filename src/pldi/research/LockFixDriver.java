package pldi.research;



import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import polyglot.ast.New;

import Drivers.Setup;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Pack;
import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.jimple.toolkits.thread.synchronizationLP.lockfix.LockFix;
import soot.options.Options;
import soot.util.Chain;


public class LockFixDriver {
    
public static String syncKeyWord= "entermonitor";
public static BufferedWriter bWriter=null;
public static void main(String[] args) throws IOException
{ // wjtp.tn
	
	//@link LockProducer
	
    String bootclasspath=System.getProperty("sun.boot.class.path");
    String argsOfEasyLib= "-f J -cp "+bootclasspath+":/home/lpxz/eclipse/workspace/Playground/bin -process-dir /home/lpxz/eclipse/workspace/Playground/bin"; //java.lang.Math
 
	//	/home/lpxz/eclipse/workspace/Playground/src/HasnextTest.java
String argsOfJavaLib= "-f J -cp "+bootclasspath+":/home/lpxz/java_standard/jre/lib/rt.jar -process-dir /home/lpxz/work/soot/subjects/rt"; //java.lang.Math
String argsOfGoogleLib= "-f J -cp "+bootclasspath+
         ":/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin:/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/com/google/jsr-305-read-only/ri/build/classes:/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/com/google/jsr-305-read-only/ri/build/jsr305.jar:/home/lpxz/work/soot/subjects/google/google-collect-1.0/google-collect-1.0.jar"+ 
         " -process-dir /home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/separateDir";//com.google.common.collect.TreeMultiset";// -process-dir /home/lpxz/work/soot/subjects/google/google-collect-1.0/bin"; //java.lang.Math
String argsOfToy2= "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app Toy2"; //java.lang.Math
///home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar
String argsOfSPECJBB= "-f J -pp -cp /home/lpxz/eclipse/workspace/specjbb2005107_runnable/bin --app spec.jbb.JBBmain"; //java.lang.Math


         String interString = argsOfToy2;
         String[] finalArgs =interString.split(" "); 
 		
         soot.Main.v().processCmdLine(finalArgs);
 		Setup.setupPatchOptions();
 	

 //        Options.v().set_include_all(true);// include_all() ; not acceptable

		//  Pack jtp = PackManager.v().getPack("jtp");
		//  addReflectBodyToJTP(jtp);
	    //	Pack wjtp = PackManager.v().getPack("wjtp");
        //	addReflectionToWJTP(wjtp);
		
 		
 		  Scene.v().loadNecessaryClasses();

 	     
 	     
 	     
	  List entryPoints=EntryPoints.v().methodsOfApplicationClasses();
	  List mainEntries = new ArrayList();
	  for(int i=0;i< entryPoints.size(); i++)
	  {
		  if(entryPoints.get(i).toString().contains("main"))
		  {
			  mainEntries.add(entryPoints.get(i));
		  }
	  }
	  
	      soot.Scene.v().setEntryPoints(mainEntries);  // process : app and its reachable methods.
	    //TODO: helloworld
	    
	//	Setup.setPhaseOptionsForPaddleWork();
	 	Setup.setPhaseOptionsForSparkWork();
	//		Setup.setPhaseOptionsForTheirTransactionTransformer();
		PackManager.v().getPack("wjtp").add(new Transform(
				"wjtp.lockfix", new LockFix()));
	//	Setup.setPhaseOptionsForMyTransactionTransformer();
		PackManager.v().runPacks();//1
		PackManager.v().writeOutput();
	    G.reset();		
	}


	
	private static void addReflectionToWJTP(Pack wjtp) {
	 Setup.setupPatchOptions();
     Setup.setPhaseOptionsForSparkWork();// equals sparkwork()spark -->
     wjtp.add(new Transform("wjtp.viewBody", new SceneTransformer() {
		
		@Override
		protected void internalTransform(String phaseName, Map options) {
			Iterator  classIt = Scene.v().getApplicationClasses().iterator();
			while (classIt.hasNext()) {
				SootClass sootclass = (SootClass) classIt.next();
				Iterator<SootMethod> methodIt= sootclass.getMethods().iterator();
			    while (methodIt.hasNext()) {
					SootMethod sootMethod = (SootMethod) methodIt.next();
					if(!sootMethod.hasActiveBody())  continue;
					Iterator<Unit> units =sootMethod.getActiveBody().getUnits().iterator();
                    while (units.hasNext()) {
						Unit unit = (Unit) units.next();
						if(unit.toString().contains(syncKeyWord))
						{
							 System.out.println("the method: " + sootMethod.getName() +" contains synch ops");
						}
					}				
			    }
			}
		}
	}));
	
}



	private static void addReflectBodyToJTP(Pack pp) throws IOException {
        FileWriter fWriter = new FileWriter("syncCommon", true);    
		bWriter= new BufferedWriter(fWriter);
		

         
		pp.add(new Transform("jtp.viewBody", new BodyTransformer(){

			protected void internalTransform(Body b, String phaseName, Map options) {

				SootMethod  sMethod= b.getMethod();
				boolean syncMethod= sMethod.isSynchronized();
				if(syncMethod)
				{
					String output = "the method: " + b.getMethod().getDeclaringClass().getName()
					 +":"+ b.getMethod().getName() +" contains synch ops";
					 try {
					    System.out.println(output);
						 bWriter.write(output);
						 bWriter.newLine();
						 bWriter.flush();
					} catch (IOException e) {
						System.out.println("write error");
						
					}
					
				}
				
				Iterator unitsIterator = b.getUnits().iterator();
	            while (unitsIterator.hasNext()) {
					Unit unit = (Unit) unitsIterator.next();
                  
					if(unit.toString().contains(syncKeyWord))
					{
						String output = "the method: " + b.getMethod().getDeclaringClass().getName()
						 +":"+ b.getMethod().getName() +" contains synch ops";
						 try {
						
							bWriter.write(output);
							 bWriter.newLine();
							 bWriter.flush();
						} catch (IOException e) {
							System.out.println("write error");
							
						}
						
					}
				}		
			}
			
      }));
	
    }



	private static SootClass loadClass(String name, boolean main) {
		SootClass c = Scene.v().loadClassAndSupport(name);
		c.setApplicationClass();
		if (main)
			Scene.v().setMainClass(c);
		return c;
	}

	public void testGetShimpleBody() {
	//	fail("Not yet implemented"); // TODO
	}


	

}
