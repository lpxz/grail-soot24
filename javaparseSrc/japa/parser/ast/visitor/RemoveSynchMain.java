package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.test.Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveSynchMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		 String testfile="/home/lpxz/eclipse/workspace/Playground/src/Toy.java";
//		 removeSynch4File(testfile);   
		///home/lpxz/eclipse/workspace/specjbb_nolog
		// String testdir="/home/lpxz/eclipse/workspace/specjbb_nolog_bak/src";
		 removeSynchInDir(Config.testdir);   
	        
	}
    
	public static void removeSynchInDir(String dir)
	{
		List container = new ArrayList();
		Helper.listFilesInDirectory(dir, container);
		for(Object file:container)
		{
			removeSynch4File((File)file);			
		}
		
		
		
	}
	public static void removeSynch4File(String testfile) {
		try {
			String source = Helper.readFile(new File(testfile));
	        CompilationUnit cu = Helper.parserString(source);
//	       EqualsVisitor visitor = new EqualsVisitor();
//	        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//	 
	        RemoveSynchVisitor visitor = new  RemoveSynchVisitor();
	        visitor.visit(cu, null);
	        Helper.writeFile(visitor.getSource(), (testfile));
	     //   System.out.println(visitor.getSource());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		 
		
	}
	public static void removeSynch4File(File testfile) {
		try {
			String source = Helper.readFile((testfile));
	        CompilationUnit cu = Helper.parserString(source);
//	       EqualsVisitor visitor = new EqualsVisitor();
//	        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//	 
	        RemoveSynchVisitor visitor = new  RemoveSynchVisitor();
	        visitor.visit(cu, null);
	        Helper.writeFile(visitor.getSource(), (testfile.toString()));
	     //   System.out.println(visitor.getSource());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		 
		
	}

}
