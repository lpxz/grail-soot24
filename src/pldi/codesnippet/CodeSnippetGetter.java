package pldi.codesnippet;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.test.Helper;
import japa.parser.ast.visitor.StatisticSynchVisitor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
import sun.awt.windows.ThemeReader;

public class CodeSnippetGetter {
    
	static String sourceDir = "/home/lpxz/eclipse/workspace/soot24/src";
	static String outputDir ="/home/lpxz/eclipse/workspace/soot24/codesnippet";
	
	static List<String> classes = new ArrayList<String>();
	static Set<String> hitClasses = new HashSet<String>();
//	static{
//		classes.add("pldi.locking.CriticalSection");
//		classes.add("pldi.locking.MyPair");
//	}	
	//================================
	
	static List<String> methods = new ArrayList<String>();
	static Set<String> hitMethods = new HashSet<String>();
//	static{
//		methods.add("pldi.locking.CriticalSection.main");
//		methods.add("pldi.locking.MyPair.getO1");
//	}
	//================================
	
	static List<String> lines = new ArrayList<String>();
	static Set<String> hitMethodsOfLines = new HashSet<String>();
//	static{
//		lines.add("pldi.locking.CriticalSection.31");
//		lines.add("pldi.locking.MyPair.15");
//	}
	//================================
	
		
	public static void class2file()
	{
			List container = new ArrayList();
			Helper.listFilesInDirectory(sourceDir, container);
			
			for(Object file:container)
			{
				hitClasses.clear();
				if(!file.toString().contains(".java")) continue;
				try {					
					String source = Helper.readFile((File)(file));
			        CompilationUnit cu = Helper.parserString(source);
//			       EqualsVisitor visitor = new EqualsVisitor();
//			        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//			 
			        StatisticSynchVisitor visitor = new  StatisticSynchVisitor();
			        visitor.visit(cu, null);	
			        boolean goodfile = false;
			        for(String targetclass:classes)
			        {
			        	if(visitor.classesOrInterfaces.contains(targetclass))
			        	{
			        		goodfile=true;
			        		hitClasses.add(targetclass);
			        	}
			        }
			        
			        
			        // check file existence, and warning
			        if(goodfile)
			        {
			        	String filename= "";
			        	for(String name:hitClasses)
			        	{
			        		filename += (name+"_") ;
			        	}
			        	filename = filename.substring(0,   filename.length()-1);
			        	filename+=".java";
			        	System.err.println("writing file:" + filename);
			        	Helper.writeFile(visitor.getSource(), outputDir+"/" +filename);
			        }
			        
				} catch (Exception e) {
					System.out.println(file.toString());
				}
			}
			
			
			
		}
		
	
	public static void method2file()
	{
			List container = new ArrayList();
			Helper.listFilesInDirectory(sourceDir, container);
			
			for(Object file:container)
			{
				hitMethods.clear();
				if(!file.toString().contains(".java")) continue;
				try {					
					String source = Helper.readFile((File)(file));
			        CompilationUnit cu = Helper.parserString(source);
//			       EqualsVisitor visitor = new EqualsVisitor();
//			        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//			 
			        StatisticSynchVisitor visitor = new  StatisticSynchVisitor();
			        visitor.visit(cu, null);	
			        StringBuilder visitorSource = new StringBuilder();
			        boolean hit = false;
			        for(String targetmethod:methods)
			        {
			        	int lastdot =targetmethod.lastIndexOf('.');
			        	String targetclass = targetmethod.substring(0, lastdot);
			        	String puremethod = targetmethod.substring(lastdot+1);
			        	
			        	if(visitor.classesOrInterfaces.contains(targetclass))
			        	{
			        		List<TypeDeclaration> tds =cu.getTypes();
			        		for(TypeDeclaration td:tds)
			        		{
			        			
			        	       List<BodyDeclaration> bds=td.getMembers();
			        	       for(BodyDeclaration bd:bds)
			        	       {
			        	    	  
			        	    	   if(bd instanceof MethodDeclaration)
			        	    	   {
			        	    		  
			        	    		   MethodDeclaration md = (MethodDeclaration) bd;
			        	    		   String thisMethod =md.getName();
			        	    		  
			        	    		   if(thisMethod.equals(puremethod))
			        	    		   {
			        	    			   hit=true;
			        	    			   hitMethods.add(targetmethod);
			        	    			   visitorSource.append(md.toString());			        	    			   
			        	    		   }
			        	    	   }
			        	       }
			        		}
			        		
			        	}
			        }
			        
			        
			        // check file existence, and warning
			        if(hit)
			        {
			        	String filename= "";
			        	for(String name:hitMethods)
			        	{
			        		filename += (name+"_") ;
			        	}
			        	filename = filename.substring(0,   filename.length()-1);
			        	if(filename.length()>=50) 
			        	{
			        		filename = filename.substring(0, 50);
			        		filename+="_fileNameTooLong";
			        	}
			        	filename+=".java";
			        	System.err.println("writing file:" + filename);
			        	Helper.writeFile(visitorSource.toString(), outputDir+"/" +filename);
			        }
			        
				} catch (Exception e) {
					System.out.println(file.toString());
				}
			}
			
			
			
		}

	
	public static void line2file()
	{
			List container = new ArrayList();
			Helper.listFilesInDirectory(sourceDir, container);
			
			for(Object file:container)
			{
				hitMethodsOfLines.clear();
				if(!file.toString().contains(".java")) continue;
				try {					
					String source = Helper.readFile((File)(file));
			        CompilationUnit cu = Helper.parserString(source);
//			       EqualsVisitor visitor = new EqualsVisitor();
//			        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//			 
			        StatisticSynchVisitor visitor = new  StatisticSynchVisitor();
			        visitor.visit(cu, null);	
			        StringBuilder visitorSource = new StringBuilder();
			        boolean hit = false;
			        for(String targetmethod:lines)
			        {
			        	int lastdot =targetmethod.lastIndexOf('.');
			        	String targetclass = targetmethod.substring(0, lastdot);
			        	String pureLine = targetmethod.substring(lastdot+1);
			        	int pureLineInt = Integer.valueOf(pureLine);
			        	
			        	
			        	
			        	if(visitor.classesOrInterfaces.contains(targetclass))
			        	{
			        		List<TypeDeclaration> tds =cu.getTypes();
			        		for(TypeDeclaration td:tds)
			        		{
			        			
			        	       List<BodyDeclaration> bds=td.getMembers();
			        	       for(BodyDeclaration bd:bds)
			        	       {
			        	    	  
			        	    	   if(bd instanceof MethodDeclaration)
			        	    	   {
			        	    		  
			        	    		   MethodDeclaration md = (MethodDeclaration) bd;
			        	    		   String thisMethod =md.getName();
			        	    		  
			        	    		   if(md.getBeginLine() <= pureLineInt && pureLineInt <= md.getEndLine())
			        	    		   {
			        	    			   hit=true;
			        	    			   hitMethodsOfLines.add(targetmethod);
			        	    			   visitorSource.append(md.toString());		
			        	    		   }
			        	    		  
			        	    	   }
			        	       }
			        		}
			        		
			        	}
			        }
			        
			        
			        // check file existence, and warning
			        if(hit)
			        {
			        	String filename= "";
			        	for(String name:hitMethodsOfLines)
			        	{
			        		filename += (name+"_") ;
			        	}
			        	filename = filename.substring(0,   filename.length()-1);
			        	filename+=".java";
			        	System.err.println("writing file:" + filename);
			        	Helper.writeFile(visitorSource.toString(), outputDir+"/" +filename);
			        }
			        
				} catch (Exception e) {
					System.out.println(file.toString());
				}
			}
			
			
			
		}

		 
	
	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
		//  class2file();
		//method2file();
          line2file();
//		String outputFormat= "J";
//		String cpath="/home/lpxz/benchmark/tamiflex/out/xalan-small";
//		String mainClass = "Harness";
//		
//		
//		
//		String excludeOption = "";
//		String includeOption = " -i org.apache -i org.w3c";
//		String reflectionOption = "true";
//		
//		
////		String outputFormat= args[0];
////		String cpath=args[1];
////		String mainClass = args[2];	
////		String excludeOption = System.getProperty("exclude.option");
////		String includeOption = System.getProperty("include.option");
////		String reflectionOption = System.getProperty("dacapo.reflection.option");
//		String reflString = reflectionOption.equals("true")?" -p cg reflection-log:"+cpath+"/refl.log":"";
//		
//		String jceJar = "/home/lpxz/java_standard/jre/lib/jce.jar";
//		String rtJar = "/home/lpxz/java_standard/jre/lib/rt.jar";
//		String argsOfmtrt = "-w -app -p cg.spark enabled -f " + outputFormat	
//			    + reflString
//				+ " -cp "
//				+ jceJar + ":" + rtJar + ":" +cpath
//				+ " -main-class "
//				+ mainClass
//				+ " "
//				+ mainClass
//				+excludeOption
//				+includeOption
//		        ;
////				+ " -d "
////				+ intermediateCP
//				
//		
//		String interString = argsOfmtrt;
//		String[] finalArgs = interString.split(" ");		
//		System.out.println(argsOfmtrt);
//	
//
//		Pack wjtp = PackManager.v().getPack("wjtp");
//		addMethodLocker2wjtp(wjtp);		
//		addMUVIPackToWJtp(wjtp);
//		
//
//      // soot.Main.main(finalArgs);// tune for saving the memory
//		soot.Main.v().processCmdLine(finalArgs);
//		System.out.println(argsOfmtrt);
//		soot.Main.v().autoSetOptions();
//		Setup.setPhaseOptionsForSparkWork();
//		Scene.v().loadNecessaryClasses();	
//		
//		PackManager.v().runPacks();// 1
//		G.v().reset();  // memory
//	//	PackManager.v().writeOutput();
	}



}
