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

import java.util.Iterator;
import java.util.List;

/**
 * @author Julio Vilmar Gesser
 */

public final class RemoveSynchVisitor extends DumpVisitor
{
	 public void visit(MethodDeclaration n, Object arg) {
	        printJavadoc(n.getJavaDoc(), arg);
	        printMemberAnnotations(n.getAnnotations(), arg);
	        printModifiers(n.getModifiers());

	        printTypeParameters(n.getTypeParameters(), arg);
	        if (n.getTypeParameters() != null) {
	            printer.print(" ");
	        }

	        n.getType().accept(this, arg);
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
	
	 
	 protected void printModifiers(int modifiers) {
	        if (ModifierSet.isPrivate(modifiers)) {
	            printer.print("private ");
	        }
	        if (ModifierSet.isProtected(modifiers)) {
	            printer.print("protected ");
	        }
	        if (ModifierSet.isPublic(modifiers)) {
	            printer.print("public ");
	        }
	        if (ModifierSet.isAbstract(modifiers)) {
	            printer.print("abstract ");
	        }
	        if (ModifierSet.isStatic(modifiers)) {
	            printer.print("static ");
	        }
	        if (ModifierSet.isFinal(modifiers)) {
	            printer.print("final ");
	        }
	        if (ModifierSet.isNative(modifiers)) {
	            printer.print("native ");
	        }
	        if (ModifierSet.isStrictfp(modifiers)) {
	            printer.print("strictfp ");
	        }
	        if (ModifierSet.isSynchronized(modifiers)) {
	         //   printer.print("synchronized ");
	        }
	        if (ModifierSet.isTransient(modifiers)) {
	            printer.print("transient ");
	        }
	        if (ModifierSet.isVolatile(modifiers)) {
	            printer.print("volatile ");
	        }
	    }

	    public void visit(SynchronizedStmt n, Object arg) {
	     //   printer.print("synchronized (");
	     //   n.getExpr().accept(this, arg);// do not print the monitor
	     //   printer.print(") ");
	    	String blockString =n.getBlock().toString();
	    	if(blockString.contains(".wait()")||blockString.contains(".notify()")
	    			||blockString.contains(".notifyAll()"))
	    			{
	    		       System.out.println("=====================!!!!");
	    		       System.out.print("synchronized (");
	    		       System.out.print( n.getExpr().toString());
	    			   //  n.getExpr().accept(this, arg);// do not print the monitor
	    			     System.out.println(") ");
	    		       System.out.println(blockString);
	    			}
	        n.getBlock().accept(this, arg);
	    }
	
	
	
	}
