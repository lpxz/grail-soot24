/*
 * Copyright (C) 2007 J�lio Vilmar Gesser.
 * 
 * This file is part of Java 1.5 parser and Abstract Syntax Tree.
 *
 * Java 1.5 parser and Abstract Syntax Tree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Java 1.5 parser and Abstract Syntax Tree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java 1.5 parser and Abstract Syntax Tree.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Created on 05/10/2006
 */
package japa.parser.ast.visitor;

import japa.parser.ast.BlockComment;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.LineComment;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.TypeParameter;
import japa.parser.ast.body.AnnotationDeclaration;
import japa.parser.ast.body.AnnotationMemberDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.EmptyMemberDeclaration;
import japa.parser.ast.body.EmptyTypeDeclaration;
import japa.parser.ast.body.EnumConstantDeclaration;
import japa.parser.ast.body.EnumDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.InitializerDeclaration;
import japa.parser.ast.body.JavadocComment;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.body.VariableDeclaratorId;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.expr.ArrayAccessExpr;
import japa.parser.ast.expr.ArrayCreationExpr;
import japa.parser.ast.expr.ArrayInitializerExpr;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.BooleanLiteralExpr;
import japa.parser.ast.expr.CastExpr;
import japa.parser.ast.expr.CharLiteralExpr;
import japa.parser.ast.expr.ClassExpr;
import japa.parser.ast.expr.ConditionalExpr;
import japa.parser.ast.expr.DoubleLiteralExpr;
import japa.parser.ast.expr.EnclosedExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.InstanceOfExpr;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.expr.IntegerLiteralMinValueExpr;
import japa.parser.ast.expr.LongLiteralExpr;
import japa.parser.ast.expr.LongLiteralMinValueExpr;
import japa.parser.ast.expr.MarkerAnnotationExpr;
import japa.parser.ast.expr.MemberValuePair;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.NormalAnnotationExpr;
import japa.parser.ast.expr.NullLiteralExpr;
import japa.parser.ast.expr.ObjectCreationExpr;
import japa.parser.ast.expr.QualifiedNameExpr;
import japa.parser.ast.expr.SingleMemberAnnotationExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.expr.SuperExpr;
import japa.parser.ast.expr.ThisExpr;
import japa.parser.ast.expr.UnaryExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.stmt.AssertStmt;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.BreakStmt;
import japa.parser.ast.stmt.CatchClause;
import japa.parser.ast.stmt.ContinueStmt;
import japa.parser.ast.stmt.DoStmt;
import japa.parser.ast.stmt.EmptyStmt;
import japa.parser.ast.stmt.ExplicitConstructorInvocationStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ForStmt;
import japa.parser.ast.stmt.ForeachStmt;
import japa.parser.ast.stmt.IfStmt;
import japa.parser.ast.stmt.LabeledStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.stmt.SwitchEntryStmt;
import japa.parser.ast.stmt.SwitchStmt;
import japa.parser.ast.stmt.SynchronizedStmt;
import japa.parser.ast.stmt.ThrowStmt;
import japa.parser.ast.stmt.TryStmt;
import japa.parser.ast.stmt.TypeDeclarationStmt;
import japa.parser.ast.stmt.WhileStmt;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.type.VoidType;
import japa.parser.ast.type.WildcardType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import junit.framework.Assert;

/**
 * @author Julio Vilmar Gesser
 */

//public static class runModes // sample code
//{
//
//public static Object DEFAULT_MODE = new Object() 
//;
//public static Object MULTI_RAMP = new Object() 
//;
//public static Object RAMP_UP = new Object() 
//;
//public static Object RECORDING = new Object() 
//;
//public static Object RAMP_DOWN = new Object() 
//;
//public static Object STOP = new Object() 
//
//}

public final class RemoveEnumVisitor extends DumpVisitor
{
	// 1 change the declaration
	//2 change the usage: runModes var = runModes.DEFAULT_MODES; 
	//  runModes-> OBject;
	public Stack<CompilationUnit> cus= new Stack<CompilationUnit>();
	public Stack<ClassOrInterfaceDeclaration> cOrIs = new Stack<ClassOrInterfaceDeclaration>(); 
//	public CompilationUnit curCU= null;
//	public TypeDeclaration curCOrI=null;
	public void visit(CompilationUnit n, Object arg) {
		//curCU =n;
		cus.push(n);
        if (n.getPackage() != null) {
            n.getPackage().accept(this, arg);
        }
        if (n.getImports() != null) {
            for (ImportDeclaration i : n.getImports()) {
                i.accept(this, arg);
            }
            printer.printLn();
        }
        if (n.getTypes() != null) {
            for (Iterator<TypeDeclaration> i = n.getTypes().iterator(); i.hasNext();) {
                i.next().accept(this, arg);
                printer.printLn();
                if (i.hasNext()) {
                    printer.printLn();
                }
            }
        }
       
        cus.pop();
        
	}
	
	
	public void visit(ClassOrInterfaceDeclaration n, Object arg) {
		//curCOrI =n;
		cOrIs.push(n);
        printJavadoc(n.getJavaDoc(), arg);
        printMemberAnnotations(n.getAnnotations(), arg);
        printModifiers(n.getModifiers());
      

        if (n.isInterface()) {
            printer.print("interface ");
        } else {
            printer.print("class ");
        }

        printer.print(n.getName());

        printTypeParameters(n.getTypeParameters(), arg);

        if (n.getExtends() != null) {
            printer.print(" extends ");
            for (Iterator<ClassOrInterfaceType> i = n.getExtends().iterator(); i.hasNext();) {
                ClassOrInterfaceType c = i.next();
                c.accept(this, arg);
                if (i.hasNext()) {
                    printer.print(", ");
                }
            }
        }

        if (n.getImplements() != null) {
            printer.print(" implements ");
            for (Iterator<ClassOrInterfaceType> i = n.getImplements().iterator(); i.hasNext();) {
                ClassOrInterfaceType c = i.next();
                c.accept(this, arg);
                if (i.hasNext()) {
                    printer.print(", ");
                }
            }
        }

        printer.printLn(" {");
        printer.indent();
        if (n.getMembers() != null) {
            printMembers(n.getMembers(), arg);
        }
        printer.unindent();
        printer.print("}");
        cOrIs.pop();
    }

	public static  HashMap<Object, HashSet> enumType = new HashMap<Object, HashSet>();// twice using the different visitors!
	// full name based, the selfClass is also tabbed to be complete. selfClas first considered
	 public void visit(EnumDeclaration n, Object arg) {
		 //enumDecalratiin is typeDeclaration
	        printJavadoc(n.getJavaDoc(), arg);
	        printMemberAnnotations(n.getAnnotations(), arg);
	        printModifiers(n.getModifiers());

	        System.out.print("enum ");
	        System.out.println(n.getName());
	        printer.print(" static class " +n.getName());
	        if(enumType.get(n.getName())==null)
	        {
	        	enumType.put(n.getName(), new HashSet());
	        }
	        Set enumS= enumType.get(n.getName());
	        String classname = cus.peek().getPackage().getName() +"."+cOrIs.peek().getName();
	        enumS.add(classname); //spec.jbb.Company
	        //System.out.println(classname);
	        
	       


	        if (n.getImplements() != null) {
	        	if(true ) throw new RuntimeException("not supported");
	            printer.print(" implements ");
	           
	            for (Iterator<ClassOrInterfaceType> i = n.getImplements().iterator(); i.hasNext();) {
	                ClassOrInterfaceType c = i.next();
	                c.accept(this, arg);
	                if (i.hasNext()) {
	                    printer.print(", ");
	                    
	                    
	                }
	            }
	        }

	        System.out.println("{");
	        printer.printLn(" {");
	        
	       
	        printer.indent();
	        if (n.getEntries() != null) {
	            printer.printLn();
	            System.out.println();
	            for (Iterator<EnumConstantDeclaration> i = n.getEntries().iterator(); i.hasNext();) {
	                EnumConstantDeclaration e = i.next();
	                e.accept(this, arg);
	                if (i.hasNext()) {
	                	 System.out.println(",");
	                    printer.print("; ");
	                   
	                   
	                }
	            }
	        }
	        if (n.getMembers() != null) {
	        	if(true)
	        	throw new RuntimeException("not aware of this path yet!");
	            printer.printLn(";");
	            printMembers(n.getMembers(), arg);
	            
	            
	        } else {
	            if (n.getEntries() != null) {
	            	System.out.println("");
	                printer.printLn(" ; ");
	                
	            }
	        }
	        
	        System.out.println("}");
	        printer.unindent();
	        printer.print("}");
	        
	    }

	 
//	    public void visit(ClassOrInterfaceType n, Object arg) {
//	        if (n.getScope() != null) {// parent class.
//	            n.getScope().accept(this, arg);// getScope= ClassOrInterface,recursive
//	            printer.print(".");
//	           
//	        }
//	        printer.print(n.getName());
//	        if(enumType.containsKey(n.getName()))
//	        	System.out.println(n.getName() +"->" + " Object ");
//	        printTypeArgs(n.getTypeArgs(), arg);
//	       // System.out.println("no printing of implements type..for debug");
//	        
//	    }
	    
	    public void visit(EnumConstantDeclaration n, Object arg) {
	        printJavadoc(n.getJavaDoc(), arg);
	        printMemberAnnotations(n.getAnnotations(), arg);
	        System.out.println(n.getName() );
	        printer.print("public static Object "+ n.getName() +" = new Object() ");
	        

	        if (n.getArgs() != null) {
	        	if(true)
	        		 throw new RuntimeException("not supported yet");
	            printArguments(n.getArgs(), arg);
	           
	        }

	        if (n.getClassBody() != null) {
	        	if(true)
	        		 throw new RuntimeException("not supported yet");
	            printer.printLn(" {");
	            printer.indent();
	            printMembers(n.getClassBody(), arg);
	            printer.unindent();
	            printer.printLn("}");
	         //    System.out.println("no printing of classbody enum for an Itme");
	        }
	    }
	    
	    
	    
	    public void visit(VariableDeclarationExpr n, Object arg) {
	        printAnnotations(n.getAnnotations(), arg);
	        printModifiers(n.getModifiers());

	        boolean avoidable= avoidVisit(n.getType());
	        if(!avoidable)// avoidable means I have already handle all for you.
	        {
	        	 n.getType().accept(this, arg);
	        }
	        printer.print(" ");

	        for (Iterator<VariableDeclarator> i = n.getVars().iterator(); i.hasNext();) {
	            VariableDeclarator v = i.next();
	            v.accept(this, arg);
	            if (i.hasNext()) {
	                printer.print(", ");
	            }
	        }
	    }

	
	 //private volatile runModes mode = runModes.DEFAULT_MODE;
	    public void visit(FieldDeclaration n, Object arg) {
	        printJavadoc(n.getJavaDoc(), arg);
	        printMemberAnnotations(n.getAnnotations(), arg);
	        printModifiers(n.getModifiers());
	       
	        boolean avoidable= avoidVisit(n.getType());
	        if(!avoidable)// avoidable means I have already handle all for you.
	        {
	        	 n.getType().accept(this, arg);
	        }
	        
//	        if(n.toString().contains("runModes"))
//	        	System.out.println(n);

	        printer.print(" ");
	        for (Iterator<VariableDeclarator> i = n.getVariables().iterator(); i.hasNext();) {
	            VariableDeclarator var = i.next();
	            var.accept(this, arg);
	            if (i.hasNext()) {
	                printer.print(", ");
	            }
	        }

	        printer.print(";");
	    }
	    
	    



	    // insert this into the server's place,
	    // do not use the visitor pattern here, it is hard to recursive control
		private boolean avoidVisit(Type ntype) {
			if(ntype instanceof ReferenceType)
	        {
	        	if(((ReferenceType)ntype).getType() instanceof ClassOrInterfaceType)
	        	{
	        		ClassOrInterfaceType cit =(ClassOrInterfaceType) ((ReferenceType)ntype).getType() ;
	                String mayEnumName = cit.getName();
	                if(enumType.containsKey(mayEnumName))
	                {
	                	Set enumSet= enumType.get(mayEnumName);
	                    if(enumSet==null) return false; // donothing
	                    else if (enumSet.size()==0) {
							// do nothing, ~null
	                    	return false;
						}
//	                    else if(enumSet.size()==1)// 1 maybe because 2nd is not analyzed
//	                    {
//	                    	// exactly the one
//	                    	// enum can not have type parameters.
//	                    	System.out.println(mayEnumName+"-> Object ");
//	                    	
//	                    	
//	                    }
	                    else {
	                    	String curFullClassName=cus.peek().getPackage().getName()+"."+cOrIs.peek().getName();
	                    	if(enumSet.contains(curFullClassName))// zi ji ren.., no scope is okay.
	                    	{
	                    		printer.print(" Object ");
	                    		return true;
	                    	}else {
	                    		String whichClass= "";
	                    		ClassOrInterfaceType citTmp =cit;
		    	        	    while(citTmp.getScope()!=null)
		    	        	    {	        	    	
		    	        	    	citTmp=citTmp.getScope();
		    	        	    	String scope= citTmp.getName();
		    	        	    	whichClass= scope+whichClass;	    	        	    	
		    	        	    }
		    	        	   if(whichClass=="")
		    	        	   {		    	        		  
		    	        		   throw new RuntimeException();
		    	        	   }
		    	        	    // help extend using the package (implicit)
		    	        	    if(enumSet.contains(whichClass)||enumSet.contains(cus.peek().getPackage().getName()+"."+whichClass))// Address.java uses Company.runmodes
		    	        	    {
		    	        	    	printer.print(" Object ");
		    	        	        return true;
		    	        	    }
		    	        	    else {
									System.err.println("wait for the second chance, the enum is not cached yet, maybe the class is not analyzed yet");
								     return false;
		    	        	    }
							}
	                    	
						}
	                    	
	                }
	        	    
	        	    
	        	    
	        	}
	        }
			return false;
		}


		//runModes inmode
	    public void visit(Parameter n, Object arg) {
	        printAnnotations(n.getAnnotations(), arg);
	        printModifiers(n.getModifiers());

	        boolean avoidable= avoidVisit(n.getType());
	        if(!avoidable)// avoidable means I have already handle all for you.
	        {
	        	 n.getType().accept(this, arg);
	        }
	       
	        if (n.isVarArgs()) {
	            printer.print("...");
	        }
	        printer.print(" ");
	        n.getId().accept(this, arg);
	    }


	
	//==============================return type issue
	    public void visit(MethodDeclaration n, Object arg) {
	        printJavadoc(n.getJavaDoc(), arg);
	        printMemberAnnotations(n.getAnnotations(), arg);
	        printModifiers(n.getModifiers());

	        printTypeParameters(n.getTypeParameters(), arg);
	        if (n.getTypeParameters() != null) {
	            printer.print(" ");
	        }
            if(!avoidVisit(n.getType()))
	        { n.getType().accept(this, arg);} 
	        printer.print(" ");
	        printer.print(n.getName());

	        printer.print("(");
	        if (n.getParameters() != null) {
	            for (Iterator<Parameter> i = n.getParameters().iterator(); i.hasNext();) {
	                Parameter p = i.next();
	                p.accept(this, arg);
	                if (i.hasNext()) {
	                    printer.print(", ");
	                }
	            }
	        }
	        printer.print(")");

	        for (int i = 0; i < n.getArrayCount(); i++) {
	            printer.print("[]");
	        }

	        if (n.getThrows() != null) {
	            printer.print(" throws ");
	            for (Iterator<NameExpr> i = n.getThrows().iterator(); i.hasNext();) {
	                NameExpr name = i.next();
	                name.accept(this, arg);
	                if (i.hasNext()) {
	                    printer.print(", ");
	                }
	            }
	        }
	        if (n.getBody() == null) {
	            printer.print(";");
	        } else {
	            printer.print(" ");
	            n.getBody().accept(this, arg);
	        }
	    }
	
	}
