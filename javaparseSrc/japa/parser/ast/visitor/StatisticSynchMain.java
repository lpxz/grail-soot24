package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.test.Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticSynchMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	
	public static void main(String[] args) throws Exception {
//		 String testfile="/home/lpxz/eclipse/workspace/Playground/src/Toy.java";
//		 removeSynch4File(testfile);   
		///home/lpxz/eclipse/workspace/specjbb_nolog
		// String testdir="/home/lpxz/eclipse/workspace/specjbb_nolog_bak/src";
		
		 Config.testdir="/home/lpxz/eclipse/workspace/jstamp/src/Bayes";
		 statSynchInDir(Config.testdir);   			//Config.testdir     
          System.out.println("classnum:"+ StatisticSynchVisitor.classNum);	        
          System.out.println("methodnum:"+ StatisticSynchVisitor.methodNum);	        
          System.out.println("fieldnum:"+ StatisticSynchVisitor.fieldNum);	  
          System.out.println("syncmethod:" + StatisticSynchVisitor.syncMethodNum);
          System.out.println("syncblock:"+ StatisticSynchVisitor.syncBlocks.size());
          
         
	}
    
	public static void statSynchInDir(String dir)
	{
		List container = new ArrayList();
		Helper.listFilesInDirectory(dir, container);
		for(Object file:container)
		{
			statSynch4File((File)file);			
		}
		
		
		
	}

	public static void statSynch4File(File testfile) {
		try {
			if(!testfile.toString().contains(".java")) return;
			String source = Helper.readFile((testfile));
	        CompilationUnit cu = Helper.parserString(source);
//	       EqualsVisitor visitor = new EqualsVisitor();
//	        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//	 
	        StatisticSynchVisitor visitor = new  StatisticSynchVisitor();
	        visitor.visit(cu, null);
	       
	     //   System.out.println(visitor.getSource());
		} catch (Exception e) {
			System.out.println(testfile.toString());
	//		throw new RuntimeException();
		}
		 
		
	}

}
