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
import soot.options.Options;
import soot.util.Chain;


public class LockProducerDriver {
    
public static String syncKeyWord= "entermonitor";
public static BufferedWriter bWriter=null;
public static void main(String[] args) throws IOException
{ // wjtp.tn

	
	
String bootclasspath=System.getProperty("sun.boot.class.path");
String argsOftoy= "-w -f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/java_standard/jre/lib/rt.jar --app Toy"; //java.lang.Math
String argsOfObjectsens= "-w -f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/java_standard/jre/lib/rt.jar --app Toy"; //java.lang.Math





///home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar
String argsOfSPECJBB= "-f J -pp -cp /home/lpxz/eclipse/workspace/specjbb2005107_runnable/bin --app spec.jbb.JBBmain"; //java.lang.Math
String argsOfSPECJBB_nolog_applysoot= "-f J -pp -cp /home/lpxz/eclipse/workspace/specjbb_nolog_nosync_applysoot/bin --app spec.jbb.JBBmain"; //java.lang.Math
String argsOfSPECJBB_nolog_applyme= "-f J -pp -cp /home/lpxz/eclipse/workspace/specjbb_nolog_nosync_applyme/bin --app spec.jbb.JBBmain"; //java.lang.Math

///home/lpxz/eclipse/workspace/specjbb_nolog_nosync_applyme
String argsOfPurpose= "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app Purpose"; //java.lang.Math
// it is correct for purpose !zs
///home/lpxz/eclipse/workspace/Playground/src/Purpose.java

String argsOfXalan= "-f J -pp -cp /home/lpxz/eclipse/workspace/xalan/bin:/home/lpxz/eclipse/workspace/xalan/lib/commons-cli-1.1.jar -main-class XalanMainHarness XalanMainHarness"; //java.lang.Math

         String interString = argsOftoy;
         // use applysoot as a readonly template, so that manual transformation wont change the info
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
	    
	   //   Setup.setPhaseOptionsForPaddleWork();
		Setup.setPhaseOptionsForSparkWork();
	//		Setup.setPhaseOptionsForTheirTransactionTransformer();
		Setup.setPhaseOptionsForMyTransactionTransformer();
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
