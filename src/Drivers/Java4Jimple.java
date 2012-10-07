package Drivers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import junit.framework.Assert;

import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

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
import soot.jimple.Stmt;
import soot.jimple.internal.RValueBox;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceFileTag;
import soot.util.Chain;

public class Java4Jimple {
	public static Map cache4FolderMap = new HashMap();
	
	
	
	public static RecursiveVisitor rv = null;
	 public static Visitor solidVisitor = null; 
	 

	public static String syncKeyWord = "entermonitor";
	public static BufferedWriter bWriter = null;
	private static List<String> srcSpace=new ArrayList<String>();
	static{
		//set src path:
		// if the size==0, set it!
		srcSpace.add("/home/lpxz/eclipse/workspace/specjbb_nolog_nosync_applysoot/src");
		
		
		//srcSpace.add("/home/lpxz/eclipse/workspace/specjbb2005107_runnable/src");
		srcSpace.add("/home/lpxz/eclipse/workspace/Playground/src");
		
	}

	public static void mapFilesInDirectory(String  dirStr, Map container) {
		File dir = new File(dirStr);
		  File[] files = dir.listFiles();
		  if (files != null) {
		    for  (File f : files) {
		      if (f.isDirectory()) {
		        mapFilesInDirectory(f.getAbsolutePath(),container);
		      } else {
		    	  //System.out.println(f.getName());
		    	 //  container.add(f);
		    	  container.put(f.getName(), f.getAbsolutePath());
		      }
		    }
		  }
		}
	
	
	public static void listFilesInDirectory(String  dirStr, List container) {
		File dir = new File(dirStr);
		  File[] files = dir.listFiles();
		  if (files != null) {
		    for  (File f : files) {
		      if (f.isDirectory()) {
		        listFilesInDirectory(f.getAbsolutePath(),container);
		      } else {
		    	  //System.out.println(f.getName());
		    	  container.add(f);
		      }
		    }
		  }
		}
	
	public static void printFilesInDirectory(String  dirStr) {
		File dir = new File(dirStr);
		  File[] files = dir.listFiles();
		  if (files != null) {
		    for  (File f : files) {
		      if (f.isDirectory()) {
		        printFilesInDirectory(f.getAbsolutePath());
		      } else {
		    	  System.out.println(f.getName());
		    	 
		      }
		    }
		  }
		}
	
	
	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
	 String ret= 	searchFileIn("CustomerReportTransaction.java", "/home/lpxz/eclipse/workspace/specjbb2005107_runnable/src");
     if(ret !=null)
     {
    	 System.out.println(ret);
     }
	 
	 
	 
	 
//	List filesList = new ArrayList();
//	printFilesInDirectory("/home/lpxz/eclipse/workspace/specjbb2005107_runnable/src");

	 
	 
	 
	 
//		String bootclasspath = System.getProperty("sun.boot.class.path");
//		String argsOfEasyLib = "-f J -cp "
//				+ bootclasspath
//				+ ":/home/lpxz/eclipse/workspace/Playground/bin -process-dir /home/lpxz/eclipse/workspace/Playground/bin"; // java.lang.Math
//
//		// /home/lpxz/eclipse/workspace/Playground/src/HasnextTest.java
//		String argsOfJavaLib = "-f J -cp "
//				+ bootclasspath
//				+ ":/home/lpxz/java_standard/jre/lib/rt.jar -process-dir /home/lpxz/work/soot/subjects/rt"; // java.lang.Math
//		String argsOfGoogleLib = "-f J -cp "
//				+ bootclasspath
//				+ ":/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin:/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/com/google/jsr-305-read-only/ri/build/classes:/home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/com/google/jsr-305-read-only/ri/build/jsr305.jar:/home/lpxz/work/soot/subjects/google/google-collect-1.0/google-collect-1.0.jar"
//				+ " -process-dir /home/lpxz/work/soot/subjects/google/google-collect-1.0/bin/separateDir";// com.google.common.collect.TreeMultiset";// -process-dir /home/lpxz/work/soot/subjects/google/google-collect-1.0/bin";
//			//		String className = "soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld";																								// //java.lang.Math
//		String argsOfToy = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
//		String argsOfToyW = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin --app Toy"; // java.lang.Math
//		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
//		
//		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar
//
//		String interString = argsOfToy;
//		String[] finalArgs = interString.split(" ");
//
//		soot.Main.v().processCmdLine(finalArgs);
//
//		//Setup.setupPatchOptions();
//		soot.options.Options.v().set_keep_line_number(true); // line tag on 
//		Scene.v().loadNecessaryClasses();
//		// Setup.setPhaseOptionsForPaddleWork();
//
//		
//		 
//		Pack jtp = PackManager.v().getPack("jtp");
//		addVisitorPackToJtp(jtp);
//		// Pack wjtp = PackManager.v().getPack("wjtp");
//		// addVisitorToWjtp(wjtp);
//
//		PackManager.v().runPacks();// 1
//		PackManager.v().writeOutput();
//		G.reset();
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

	private static void addVisitorPackToJtp(Pack jtp) {

		jtp.add(new Transform("jtp.java4jimple", new BodyTransformer() {

			@Override
			protected void internalTransform(Body b, String phaseName,
					Map options) {
				// MethodVisitor visitor = new MethodVisitor();

				 SootMethod sootMethod = b.getMethod();
				 SootClass sc = sootMethod.getDeclaringClass();
				 String fileName = getFileName(sc);
				 String fileAbsPath = getAbsPath(sc);// set the srcSpace first
			// 	 System.out.println(fileAbsPath);// totally work!
				 
	
				Body body = sootMethod.getActiveBody();
				
				Chain units = body.getUnits();

				
				Iterator stmtIt = units.snapshotIterator();
				while (stmtIt.hasNext()) {
					Stmt s = (Stmt) stmtIt.next();
					int lineNo= getLineNo(s);
			
					
					String javaline= getJavaLine(fileAbsPath,lineNo);
					System.out.println("\n"+s+":\n"+ javaline);
								
				}
				

			}
		}));

	}

	public static int getLineNo(Unit s) {
		LineNumberTag tag = (LineNumberTag) s.getTag("LineNumberTag");
		if(tag==null) return 0;// bad ..
		
		int lineNO = tag.getLineNumber();
		return lineNO;
	}

	public static String getJavaLine(String fileAbsPath, int lineNO) {
		
		File file = null;
	    FileReader freader = null;
	    LineNumberReader lnreader = null;
	    try{
	      file = new File(fileAbsPath);
	      freader = new FileReader(file);
	      lnreader = new LineNumberReader(freader);
	      String line = "";

	      while ((line = lnreader.readLine()) != null){
	      //   System.out.println("Line:  " + + ": " + line);
	        if(lnreader.getLineNumber() ==lineNO) 
	        	{
	        	freader.close();
	        	lnreader.close();
	        	return line;}
	        else {
				//System.out.println(line);
			}
	      }
	
	      freader.close();
	      lnreader.close();
	    }
	    catch (Exception e) {
			System.out.println("I can not read it..sorry");
			
		}
	    return null;

	}

	public static String getAbsPath(SootClass sc) {
	   String filename = getFileName(sc);
	   if(srcSpace.size()==0) 
		   {
		   System.out.println("set the src Space first!");
		   
		   }
	   String found = null;	   
	   for(String srcFolder:srcSpace)
	   {
		   // return at the first hit!
		   found=   searchFileIn(filename, srcFolder);// not found-> still null
		   if(found!=null) 
			   return found;
	   }
	   return null;// not found!
	

	   
	}
	//cache4FolderMap
	public static String searchFileIn(String filename, String srcFolder) {
		// the original version seems to traverse a lot of files .. I do not know why in stress test, it fails.
          if(!cache4FolderMap.containsKey(srcFolder))
          {
        	  // fill in the entry
        	  Map  shortToAbsName = new HashMap();
        	  // fill the maP
        	  mapFilesInDirectory(srcFolder, shortToAbsName);
        	  cache4FolderMap.put(srcFolder, shortToAbsName);
        	  
          }
          Map dict= (Map) cache4FolderMap.get(srcFolder);
          String toret  = (String) dict.get(filename);
          return  toret;// can be null
         
	}

//	public static String searchFileIn(String filename, String srcFolder) {
//		//CustomerReportTransaction.java
//		  File dir = new File(srcFolder);
//		  File[] files = dir.listFiles();
//		  String  toret= null;
//		  if (files != null) {
//		
//		    for  (File f : files) {
//		      if (f.isDirectory()) {
//		        // listFilesInDirectory(f.getAbsolutePath(),container);
//		    	String  retTmp=   searchFileIn(filename, f.getAbsolutePath());
//		    	if(retTmp !=null)
//		    	{
//		    		toret= retTmp;
//		    	}
//		      } else {
//		    	  //System.out.println(f.getName());
////		    	  container.add(f);
//		    	  if(f.getName().equals(filename))
//		    	  {	    		
//		    		  toret= f.getAbsolutePath();
//		    	  }
//		      }
//		    }
//		    
//		  }	
//		  return toret;
////		File dir = new File(srcFolder);
////		File[] files = dir.listFiles(new SimpleFileFilter(filename));
////		if(files.length>1)
////		{ Assert.assertTrue(1==0);}
////		if(files.length==0) return null;
////		
////		return files[0].getAbsolutePath();
//	}

	public static String getFileName(SootClass sc) {
	     if (!sc.hasTag("SourceFileTag"))
	            System.out.println("unknown.java"); ;			          
		 SourceFileTag sourceFileTag = (SourceFileTag)sc.getTag("SourceFileTag");	
	//	 String filename = sourceFileTag.getSourceFile();
		 return sourceFileTag.getSourceFile();

	     
	}

	private static void addVisitorToWjtp(Pack wjtp) {
		wjtp.add(new Transform("wjtp.visitor", new SceneTransformer() {

			@Override
			protected void internalTransform(String phaseName, Map options) {
				// MethodVisitor visitor = new MethodVisitor();


				Chain<SootClass> classes = Scene.v().getApplicationClasses();
				Iterator<SootClass> classesIt = classes.iterator();
				while (classesIt.hasNext()) {
					SootClass sootClass = (SootClass) classesIt.next();
				      
					List<SootMethod> methods = sootClass.getMethods();
					Iterator<SootMethod> methodIt = methods.iterator();
					while (methodIt.hasNext()) {
						SootMethod sootMethod = (SootMethod) methodIt.next();
						if (sootMethod.isAbstract())
							continue;
						if (sootMethod.isNative())
							continue;
						
					    Visitor.thisClass = sootMethod.getDeclaringClass();
					    if(!sootMethod.hasActiveBody()) continue;
						Body body = sootMethod.getActiveBody();
						Chain units = body.getUnits();

						solidVisitor.visitMethodBegin(sootMethod, units);
						Iterator stmtIt = units.snapshotIterator();
						while (stmtIt.hasNext()) {
							Stmt s = (Stmt) stmtIt.next();
							solidVisitor.thisStmt = s;
							solidVisitor.visitStmt(sootMethod, units, s);
						}
						solidVisitor.visitMethodEnd(sootMethod, units);
						body.validate();

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
		// fail("Not yet implemented"); // TODO
	}
	
	public static class SimpleFileFilter implements FileFilter
	{
	    private String _pattern;
	 
	    public SimpleFileFilter(String pattern)
	    {
		_pattern = pattern;
	    }
	 
	    public boolean accept(File file)
	    {
		return file.getName().equals(_pattern);
	    }
	}

}
