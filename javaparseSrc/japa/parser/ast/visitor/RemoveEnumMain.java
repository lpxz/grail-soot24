package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.test.Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveEnumMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		 String testfile="/home/lpxz/eclipse/workspace/Playground/src/Toy.java";
//		 removeSynch4File(testfile);   
		///home/lpxz/eclipse/workspace/specjbb_nolog
		 removeEnumInDir(Config.testdir);  
		 removeEnumInDir(Config.testdir);  // second chance, because the first time, the enum decalration may not be analyzed before the referencing class. 
	        
	}
    
	public static void removeEnumInDir(String dir)
	{
		List container = new ArrayList();
		Helper.listFilesInDirectory(dir, container);
		for(Object file:container)
		{
			removeEnum4File((File)file);			
		}
		
		
		
	}
	public static void removeSynch4File(String testfile) {
		try {
			String source = Helper.readFile(new File(testfile));
	        CompilationUnit cu = Helper.parserString(source);
//	       EqualsVisitor visitor = new EqualsVisitor();
//	        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//	 
	        RemoveEnumVisitor visitor = new  RemoveEnumVisitor();
	        visitor.visit(cu, null);
	        Helper.writeFile(visitor.getSource(), (testfile));
	     //   System.out.println(visitor.getSource());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		 
		
	}
	public static void removeEnum4File(File testfile) {
		try {
			String source = Helper.readFile((testfile));
	        CompilationUnit cu = Helper.parserString(source);
//	       EqualsVisitor visitor = new EqualsVisitor();
//	        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//	 
	        RemoveEnumVisitor visitor = new  RemoveEnumVisitor();
	        visitor.visit(cu, null);
	        Helper.writeFile(visitor.getSource(), (testfile.toString()));
	     //   System.out.println(visitor.getSource());
		} catch (Exception e) {
		//	throw new RuntimeException();
			e.printStackTrace();
		}
		 
		
	}

}
