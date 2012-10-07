package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.test.Helper;

import java.io.File;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 String testfile="/home/lpxz/eclipse/workspace/Playground/src/Toy.java";
		 String source = Helper.readFile(new File(testfile));
	        CompilationUnit cu = Helper.parserString(source);
//	       EqualsVisitor visitor = new EqualsVisitor();
//	        visitor.visit(cu, null);// EqualsVisitor: compare cu and cu2, assertSmae
//	 
	        RemoveSynchVisitor visitor = new  RemoveSynchVisitor();
	        visitor.visit(cu, null);
	        Helper.writeFile(visitor.getSource(), (testfile));
	     //   System.out.println(visitor.getSource());
	        
	        
	}

}
