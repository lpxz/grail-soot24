package soot.jimple.toolkits.thread.synchronizationLP.Jimples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



import soot.ArrayType;
import soot.Body;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.Local;
import soot.LongType;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.SourceLocator;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;

import soot.jbco.jimpleTransformations.CollectConstants;
import soot.jimple.AssignStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.VirtualInvokeExpr;
import soot.options.Options;
import soot.util.Chain;
import soot.util.JasminOutputStream;
import soot.util.NumberedString;

public class JimpleGen { // unless specific stmtType, we use Unit for generality
	// I do not know whether or not we need Type as parameter directly
	// at present, I think We can use typeVar.getName as a parameter for "Type"

	// pattern the first arg is often soot-type, the following are raw-type:
	// string represnetation
	
	
	
	
	// 1 
	// SootFieldRef is not a value, while StaticFieldRef is, so you need another wrap!
//	 SootFieldRef sfr = Scene.v().loadClassAndSupport("java.lang.System").getField("out").makeRef();
//	 b.getUnits().add(Jimple.v().newAssignStmt(local2, Jimple.v().newStaticFieldRef(sfr)));
// BUT expr is of Value type!
	// 2
	// RefType.v() is not validated because it is just a String!, like the reflection, remind yourself 
	// to check it.
	
	
	
	
	protected static final String objectClassName = "java.lang.Object";
	private static final String voidStr = "void";
	private static final String intStr = "int";
	private static final String byteStr = "byte";
	private static final String charStr = "char";
	private static final String doubleStr = "double";
	private static final String shortStr = "short";
	private static final String longStr = "long";
	private static final String initSign = "void <init>()";

	public static SootClass addClass(String className, String superString) {
		// Declare 'public class HelloWorld'
		SootClass sClass = new SootClass(className, Modifier.PUBLIC);

		// 'extends Object'
		sClass.setSuperclass(Scene.v().getSootClass(superString));// "java.lang.Object"
		Scene.v().addClass(sClass);
		return sClass;
	}

	// classtoInsert, fieldinserted, typeOfinsertedField
	// ret: SootField
	public static SootField addFieldToClass(SootClass classToInsert,
			String fieldToAdd, String typeOfField, boolean isStatic) {
		SootField retField = null;

		try {
			retField = classToInsert.getFieldByName(fieldToAdd);
			// field already exists
		} catch (RuntimeException re) {
			// field does not yet exist (or, as a pre-existing error, there is
			// more than one field by this name)
			if (isStatic) {
				retField = new SootField(fieldToAdd, RefType.v(typeOfField),
						Modifier.STATIC | Modifier.PUBLIC);
				classToInsert.addField(retField);
			} else {
				retField = new SootField(fieldToAdd, RefType.v(typeOfField),
						Modifier.PUBLIC);
				classToInsert.addField(retField);
			}

		}
		return retField;
	}

	public static SootField addFieldToClass(String classToInsertStr,
			String fieldToAdd, String typeOfField, boolean isStatic) {
		SootField retField = null;
		SootClass classToInsert = Scene.v().loadClassAndSupport(
				classToInsertStr);

		try {
			retField = classToInsert.getFieldByName(fieldToAdd);
			// field already exists
		} catch (RuntimeException re) {
			// field does not yet exist (or, as a pre-existing error, there is
			// more than one field by this name)
			if (isStatic) {
				retField = new SootField(fieldToAdd, RefType.v(typeOfField),
						Modifier.STATIC | Modifier.PUBLIC);
				classToInsert.addField(retField);
			} else {
				retField = new SootField(fieldToAdd, RefType.v(typeOfField),
						Modifier.PUBLIC);
				classToInsert.addField(retField);
			}

		}
		return retField;
	}

	// classToInsert
	// methodname
	// ArrayList:parameter types
	// ret type
	// isStatic

	public static SootMethod addNormalMethodToClass(SootClass classToInsert,
			String methodName, List<String> paraTypeNames,
			String returnTypeName, boolean isStatic) {
		SootMethod method = null;
		ArrayList<Type> paraTypes = translateFrom(paraTypeNames);
		Type retType = translateFrom(returnTypeName);
		if (isStatic) {
			method = new SootMethod(methodName, paraTypes, retType,
					Modifier.PUBLIC | Modifier.STATIC);
			// Arrays.asList(new Type[]
			// {ArrayType.v(RefType.v("java.lang.String"), 1)}),
			// VoidType.v()
		} else {
			method = new SootMethod(methodName, paraTypes, retType,
					Modifier.PUBLIC);
			// Arrays.asList(new Type[]
			// {ArrayType.v(RefType.v("java.lang.String"), 1)}),
			// VoidType.v()
		}

		classToInsert.addMethod(method);
		JimpleBody body = Jimple.v().newBody(method);
		method.setActiveBody(body);
		return method;

	}

	public static Local addLocalToBody(Body b, String localName, String Type) {
		Type repType = translateFrom(Type);
		Local baseLocal = Jimple.v().newLocal(localName, repType);
		b.getLocals().add(baseLocal);
		return baseLocal;
	}
	
	//==========================new Object
	public static AssignStmt assignNew(Value left, String whatType)
	{
		NewExpr newExpr= Jimple.v().newNewExpr(RefType.v(whatType));
		AssignStmt newStmt = Jimple.v().newAssignStmt(left, newExpr);
        return newStmt;
	}
	
	public static Unit initializationStmt(Local caller, String whatType)
	{
		SootClass theClass = Scene.v().loadClassAndSupport(whatType);
		RefType type= RefType.v(theClass);
		SootMethod initMethod= theClass.getMethod(initSign);
		InvokeExpr ie = Jimple.v().newSpecialInvokeExpr(caller, initMethod.makeRef(), Collections.EMPTY_LIST);
		Stmt initStmt = (Stmt) Jimple.v().newInvokeStmt(ie);
		return initStmt;		
	}
	
	public static Unit initializationStmtWithArgs(Local caller, String whatType,List args )
	{
		SootClass theClass = Scene.v().loadClassAndSupport(whatType);
		RefType type= RefType.v(theClass);
		SootMethod initMethod= theClass.getMethod(initSign);
		InvokeExpr ie = Jimple.v().newSpecialInvokeExpr(caller, initMethod.makeRef(),args );// IntConstant.v(1);
		Stmt initStmt = (Stmt) Jimple.v().newInvokeStmt(ie);
		return initStmt;		
	}

	public static void sampleCode(Chain units, Local arg, Local tmpRef) {

		// add "l0 = @parameter0"
		units.add(Jimple.v().newIdentityStmt(
				arg,
				Jimple.v().newParameterRef(
						ArrayType.v(RefType.v("java.lang.String"), 1), 0)));

		// add "tmpRef = java.lang.System.out"
		units.add(Jimple.v().newAssignStmt(
				tmpRef,
				Jimple.v().newStaticFieldRef(
						Scene.v().getField(
								"<java.lang.System: java.io.PrintStream out>")
								.makeRef())));

		// insert "tmpRef.println("Hello world!")"
		{
			SootMethod toCall = Scene.v().getMethod(
					"<java.io.PrintStream: void println(java.lang.String)>");
			units.add(Jimple.v().newInvokeStmt(
					Jimple.v().newVirtualInvokeExpr(tmpRef, toCall.makeRef(),
							StringConstant.v("Hello world!"))));
		}

		// insert "return"
		units.add(Jimple.v().newReturnVoidStmt());
	}
	
	public static void dumpToClass(SootClass sc) throws Exception
	{
	       String fileName = SourceLocator.v().getFileNameFor(sc, Options.output_format_class);
	       OutputStream streamOut = new JasminOutputStream(new FileOutputStream(fileName));
	       PrintWriter writerOut = new PrintWriter(
	                                   new OutputStreamWriter(streamOut));
	       JasminClass jasminClass = new soot.jimple.JasminClass(sc);
	       jasminClass.print(writerOut);
	       writerOut.flush();
	       streamOut.close();
		
	}
	
public static void tellAboutClass(SootClass sc) throws Exception
{
     System.out.println("class:"+ sc.getName());
     System.out.println("=========================");
     Iterator<SootField> fields =sc.getFields().iterator();
     while (fields.hasNext()) {
		SootField sootField = (SootField) fields.next();
		System.out.println(sootField.getSignature());
	}
     Iterator<SootMethod> methods = sc.getMethods().iterator();
     while (methods.hasNext()) {
		SootMethod sootMethod = (SootMethod) methods.next();
		System.out.println(sootMethod.getSignature());
		if(sootMethod.isSynchronized()){System.out.println( "IT is synchronized:"+ sootMethod.getName());}
		if(sootMethod.hasActiveBody())
		{
			Body b = sootMethod.getActiveBody();
			tellAboutBody(b);
		}
		
	}
     System.out.println("=========================");
}

	public static void tellAboutBody(Body b) {
	Iterator<Unit> unitIT =b.getUnits().iterator();
	while (unitIT.hasNext()) {
		Unit unit = (Unit) unitIT.next();
		System.out.println(unit);
	}
	
}

	// ===============================================utils:
	public static Type translateFrom(String typeName) {
		// please use long standard type like java.lang.Object, no assistance
		// here.
		String strRep = (String) typeName;

		int lbracketNum = getLBracketNumber(strRep);

		if (lbracketNum == 0) {
			Type typeForStr = representType(strRep);// directly use it
			return typeForStr;
		} else {
			String strBeforeFirstBrac = strBeforeFirstBrac(strRep);
			Type typeForStr = representType(strBeforeFirstBrac);
			return ArrayType.v(typeForStr, lbracketNum);
		}

	}

	public static Type representType(String strWithOutBrac) {
		if (strWithOutBrac.equalsIgnoreCase(voidStr)) {
			return VoidType.v();
		}
		if (strWithOutBrac.equalsIgnoreCase(intStr)) {
			return IntType.v();
		}
		if (strWithOutBrac.equalsIgnoreCase(byteStr)) {
			return ByteType.v();
		}
		if (strWithOutBrac.equalsIgnoreCase(charStr)) {
			return CharType.v();
		}
		if (strWithOutBrac.equalsIgnoreCase(doubleStr)) {
			return DoubleType.v();
		}
		if (strWithOutBrac.equalsIgnoreCase(shortStr)) {
			return ShortType.v();
		}
		if (strWithOutBrac.equalsIgnoreCase(longStr)) {
			return LongType.v();
		} else {
			return RefType.v(strWithOutBrac);
		}

	}

	public static String strBeforeFirstBrac(String strRep) {

		int mark = strRep.indexOf('[');
		return strRep.substring(0, mark);// mark is not included

	}

	public static int getLBracketNumber(String strRep) {
		char[] chars = strRep.toCharArray();
		int sum = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '[') {
				sum++;
			}
		}
		return sum;
	}

	public static ArrayList<Type> translateFrom(List<String> paraTypeNames) {
		ArrayList<Type> ret = new ArrayList<Type>();
		for (int i = 0; i < paraTypeNames.size(); i++) {
			String paraTypeName = paraTypeNames.get(i);
			Type tmpType = translateFrom(paraTypeName);
			ret.add(i, tmpType);
		}
		return ret;
	}
      
	
	public static Unit substitute(Chain<Unit> units, Unit from,
			Unit to) {
		// typeCheck
		units.insertBefore(to, from);
		units.remove(from);	
		return to;
	}
	public static void substituteToStmts(Chain<Unit> units, Unit from,
			List<Unit> tolist) {
		// typeCheck
		for(int i=0; i<tolist.size();i++)// A,B, da cong
		{
			Unit toInsert = tolist.get(i);
			units.insertBefore(toInsert, from);
		}		
		units.remove(from);// at last	
		
		
	}
	
	public static void insertStmtsBeforePoint(Chain<Unit> units, Unit point,
			List<Unit> tolist) {
		// typeCheck
		for(int i=0; i<tolist.size();i++)// A,B, da cong
		{
			Unit toInsert = tolist.get(i);
			units.insertBefore(toInsert, point);
		}		
		
	}
	
	public static void insertStmtsAfterPoint(Chain<Unit> units, Unit point,
			List<Unit> tolist) {
		// typeCheck
		
			for(int i=tolist.size()-1; i>=0;i--)// A,B, da cong
		{
			Unit toInsert = tolist.get(i);
			units.insertAfter(toInsert, point);
			
		}	
			
			
	}
	public static void helloWorld() throws Exception
	{
//correct:
// 		visitParameter:r0 := @parameter0: java.lang.String[]
//		 assignStmt: nonNewExpr     r1 = r0[0]

        Scene.v().loadClassAndSupport("java.lang.Object");
        Scene.v().loadClassAndSupport("java.lang.System");
        
		SootClass sc = addClass("HelloWorld", "java.lang.Object");

		List paraTypeNames = new ArrayList();
		paraTypeNames.add("java.lang.String[]");
		SootMethod sm = addNormalMethodToClass(sc, "main", paraTypeNames, "void", true);

		Body b = sm.getActiveBody();

	
		Local argssLocal = addLocalToBody(b, "argss","java.lang.String[]");
		
		Local psLocal = addLocalToBody(b, "ps", "java.lang.PrintStream");
		
		Local arg1Local =addLocalToBody(b, "arg1", "java.lang.String");
 
		Value identityRef = Jimple.v().newParameterRef(translateFrom("java.lang.String"), 0);
		
		
		b.getUnits().add(Jimple.v().newIdentityStmt(argssLocal, identityRef));
		
	    b.getUnits().add(Jimple.v().newAssignStmt(arg1Local, Jimple.v().newArrayRef(argssLocal, IntConstant.v(0))));
		
        SootFieldRef sfr = Scene.v().loadClassAndSupport("java.lang.System").getFieldByName("out").makeRef();
	   
        b.getUnits().add(Jimple.v().newAssignStmt(psLocal, Jimple.v().newStaticFieldRef(sfr)));
	
        SootMethod method =  Scene.v().loadClassAndSupport("java.io.PrintStream").getMethod("println", Arrays.asList(new Type[]{RefType.v("java.lang.String")}));
        
        
        
        VirtualInvokeExpr vie = Jimple.v().newVirtualInvokeExpr(psLocal, method.makeRef(),arg1Local ); //local1 //StringConstant.v("fuck")
        b.getUnits().add(Jimple.v().newInvokeStmt(vie));
        
        b.getUnits().add(Jimple.v().newReturnVoidStmt());
        b.validate();
        

       //===========================
       tellAboutClass(sc);
       dumpToClass(sc);
   
	}
	
	public static void helloWorldFromSoot() throws IOException
	{
		 SootClass sClass;
	        SootMethod method;
	        
	        // Resolve dependencies
	           Scene.v().loadClassAndSupport("java.lang.Object");
	           Scene.v().loadClassAndSupport("java.lang.System");
	           
	        // Declare 'public class HelloWorld'   
	           sClass = new SootClass("HelloWorld", Modifier.PUBLIC);
	        
	        // 'extends Object'
	           sClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
	           Scene.v().addClass(sClass);
	           
	        // Create the method, public static void main(String[])
	           method = new SootMethod("main",
	                Arrays.asList(new Type[] {ArrayType.v(RefType.v("java.lang.String"), 1)}),
	                VoidType.v(), Modifier.PUBLIC | Modifier.STATIC);
	        
	           sClass.addMethod(method);
	           
	        // Create the method body
	        {
	            // create empty body
	            JimpleBody body = Jimple.v().newBody(method);
	            
	            method.setActiveBody(body);
	            Chain units = body.getUnits();
	            Local arg, tmpRef;
	            
	            // Add some locals, java.lang.String l0
	                arg = Jimple.v().newLocal("l0", ArrayType.v(RefType.v("java.lang.String"), 1));
	                body.getLocals().add(arg);
	            
	            // Add locals, java.io.printStream tmpRef
	                tmpRef = Jimple.v().newLocal("tmpRef", RefType.v("java.io.PrintStream"));
	                body.getLocals().add(tmpRef);
	                
	            // add "l0 = @parameter0"
	                units.add(Jimple.v().newIdentityStmt(arg, 
	                     Jimple.v().newParameterRef(ArrayType.v(RefType.v("java.lang.String"), 1), 0)));
	            
	            // add "tmpRef = java.lang.System.out"
	                units.add(Jimple.v().newAssignStmt(tmpRef, Jimple.v().newStaticFieldRef(
	                    Scene.v().getField("<java.lang.System: java.io.PrintStream out>").makeRef())));
	            
	            // insert "tmpRef.println("Hello world!")"
	            {
	                SootMethod toCall = Scene.v().getMethod("<java.io.PrintStream: void println(java.lang.String)>");
	                units.add(Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr(tmpRef, toCall.makeRef(), StringConstant.v("Hello world!"))));//arg does not work here! bad tutorial
	            }                        
	            
	            // insert "return"
	                units.add(Jimple.v().newReturnVoidStmt());
	                     
	        }

	        String fileName = SourceLocator.v().getFileNameFor(sClass, Options.output_format_class);
	        OutputStream streamOut = new JasminOutputStream(
	                                    new FileOutputStream(fileName));
	        PrintWriter writerOut = new PrintWriter(
	                                    new OutputStreamWriter(streamOut));
	        JasminClass jasminClass = new soot.jimple.JasminClass(sClass);
	        jasminClass.print(writerOut);
	        writerOut.flush();
	        streamOut.close();
		
	}
	public static void main(String[] args) throws Exception {
		// Type ref = translateFrom("java.lang.String[]");
		// if(ref instanceof ArrayType)
		// {
		// System.out.println(((ArrayType)ref).numDimensions);
		// }

		
		helloWorld();
		//helloWorldFromSoot();
	}

}
