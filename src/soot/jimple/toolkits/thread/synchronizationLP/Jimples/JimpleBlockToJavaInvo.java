package soot.jimple.toolkits.thread.synchronizationLP.Jimples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import soot.Body;
import soot.FastHierarchy;
import soot.Hierarchy;
import soot.IntType;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.CastExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.StringConstant;
import soot.jimple.VirtualInvokeExpr;

public class JimpleBlockToJavaInvo extends JimpleGen{

private static final String javalist = "java.util.List";
private static final String javaArrayList = "java.util.ArrayList";
private static final String listAddSign  ="<java.util.List: boolean add(java.lang.Object)>";
private static final String listGETSign  ="<java.util.List: java.lang.Object get(int)>";
private static final String javaBlockRepoClass = "soot.jimple.toolkits.thread.synchronizationLP.Jimples.JavaBlockRepo";
// integrity
public static final HashMap<String,String> primitiveMap= new HashMap<String, String>();
private static final String wrapPostFix = "Wrap";
private static final String valueOfMName = "valueOf";
private static final String paraPrefix = "para";
private static final String returnPrefix = "return";
private static final String castForPrim = "castForPrimi";
private static final String ValueMethodName = "Value";


public static  Unit _currPos= null;

static{
	primitiveMap.put("int", "java.lang.Integer");
	primitiveMap.put("short", "java.lang.Short");
	primitiveMap.put("long", "java.lang.Long");
	primitiveMap.put("double", "java.lang.Double");
	primitiveMap.put("float", "java.lang.Float");	
	primitiveMap.put("byte", "java.lang.Byte");	
	primitiveMap.put("char", "java.lang.Character");// char-> Character
}
	public static List<Local> relevantLocals = new ArrayList<Local>();
	public static List<Local> influencedLocals = new ArrayList<Local>();
//	public static int blockID= 0;
	public static Local insertJavaInvoAsJimpleBlock_after(Body b, String blockMethodName, Unit point)
	{
		// I am in charge of parameter processing, but not in charge of return processing, I do not use the return!
		List<Unit> newChunk = new ArrayList<Unit>();
		Local paraListLocal =prepareANewList(b, newChunk, paraPrefix+"ForBlock_"+blockMethodName);
		Local returnListLocal =addLocalToBody(b,returnPrefix + "ForBlock_" + blockMethodName, javalist);
		paraAddActions(b,paraListLocal,newChunk);
		theJavaInvo(blockMethodName,paraListLocal,returnListLocal, newChunk);
		
		insertStmtsAfterPoint(b.getUnits(), point, newChunk);
		if(newChunk.size()!=0) _currPos = newChunk.get(newChunk.size()-1);
		return returnListLocal;		
	}

	public static void theJavaInvo(String blockMethodName,Local paraListLocal, Local returnListLocal,  List<Unit> newChunk) {
		SootClass javaBlockClass = Scene.v().loadClassAndSupport(javaBlockRepoClass);
		SootMethod javaBlockMethod = javaBlockClass.getMethodByName(blockMethodName);
		ArrayList<Value> args = new ArrayList<Value>();
		
		args.add(paraListLocal);// add the parameter. 
		InvokeExpr invokeblockMethodExpr= Jimple.v().newStaticInvokeExpr(javaBlockMethod.makeRef(),
				                          args);
	//	Unit invokeblockMethodStmt = Jimple.v().newInvokeStmt(invokeblockMethodExpr);// we need to return
		Unit invokeblockMethodStmt = Jimple.v().newAssignStmt(returnListLocal, invokeblockMethodExpr);
		newChunk.add(invokeblockMethodStmt);		
	}



	public static void paraAddActions(Body b, Local paraListLocal,
			List<Unit> newChunk) {
	    // list must already be laoded. interfaceInvoke

		SootMethod addMethod =Scene.v().getMethod(listAddSign);
		
		for(int i=0;i<relevantLocals.size();i++)
		{
			// paralist.add(item);
			Value beadded = relevantLocals.get(i);
			ArrayList<Value> args = new ArrayList<Value>();
			
			args.add(beadded);
			Value invokeADDExpr = Jimple.v().newInterfaceInvokeExpr(paraListLocal, addMethod.makeRef(), args);
			Unit invokeADDUnit = Jimple.v().newInvokeStmt(invokeADDExpr);
			newChunk.add(invokeADDUnit);
		}
		
	}


	public static Local prepareANewList(Body b, List<Unit> newChunk, String listname) {
		Scene.v().loadClassAndSupport(javalist);
		Local paraListLocal = addLocalToBody(b, listname, javalist);
		Unit assignNewList = assignNew(paraListLocal, javaArrayList);
		Unit listInitialize= initializationStmt(paraListLocal, javaArrayList);
		newChunk.add(assignNewList); 
		newChunk.add(listInitialize);
		return paraListLocal;
	}

	public static void testDriver() throws Exception
	{
        Scene.v().loadClassAndSupport("java.lang.Object");
        Scene.v().loadClassAndSupport("java.lang.System");
        
		SootClass sc = addClass("HelloWorld", "java.lang.Object");

		List paraTypeNames = new ArrayList();
		paraTypeNames.add("java.lang.String[]");
		SootMethod sm = addNormalMethodToClass(sc, "main", paraTypeNames, "void", true);

		Body b = sm.getActiveBody();

	    Local iLocal =addLocalToBody(b, "i", "int");
		Local argssLocal = addLocalToBody(b, "argss","java.lang.String[]");		

		Value identityRef = Jimple.v().newParameterRef(translateFrom("java.lang.String"), 0);		
		b.getUnits().add(Jimple.v().newIdentityStmt(argssLocal, identityRef));		
		
        Unit init = Jimple.v().newAssignStmt(iLocal, IntConstant.v(1));
        b.getUnits().add(init);
        _currPos=init;
        List<Local> locals = new ArrayList<Local>();
        locals.add(iLocal);
        
        
        List<Local> locals2 = new ArrayList<Local>();
        Local ibtLocal =addLocalToBody(b, "ibt", "int");
        locals2.add(ibtLocal);
        
        
        // large method+para to include:..
        blockAsMethod(b, "block1", locals, locals2,_currPos);        
        blockAsMethod(b, "block2", locals2, null,_currPos);
        blockAsMethod(b, "block3", null, null,_currPos);
      
        b.getUnits().add(Jimple.v().newReturnVoidStmt());
        b.validate();
        

       //===========================
       tellAboutClass(sc);
       dumpToClass(sc);
   
	}
	
	public static void blockAsMethod(Body b, String blockMethodString,
			List<Local> inputLocals, List<Local> outputLocals, Unit lastStmt) {
		// for "this", it is not this, but another Local variable thisRep or similar.
		// jsut the same as Local variables..
		// the size of inputLocals can be 0, but itself can not be null
		if(inputLocals==null)
		{   System.out.println("actually you are responsible to provide a non-null list!");
			inputLocals = new ArrayList<Local>();}
		
    	registerInputs(b,inputLocals, _currPos);// notice to update _currPos!
        Local returnListLocal =insertJavaInvoAsJimpleBlock_after(b,blockMethodString,  _currPos);// there are blockName here!!
       if(outputLocals==null) return;
       else {
    	   outputAffect(b, outputLocals, returnListLocal, _currPos);
	    }
        
		
	}

	// two "i","i" corresponds to different locals in Jimple!
	public static void outputAffect(Body b, List<Local> locals, Local returnListLocal,
			Unit lastStmt) {
		if(locals==null ||locals.size()==0) return;// no need to instrument the download value.
		influencedLocals.addAll(locals);
		List<Unit> postProcessChunk = new ArrayList<Unit>();
		for(int i=0;i<locals.size();i++)
		{
			Local clientLocal = locals.get(i);
			Local getTmp=addLocalToBody(b, returnListLocal.getName()+"_getTmp" +i, objectClassName);
			
			//tmp_i= returnlist.get(i);
			ArrayList<Value> args = new ArrayList<Value>();
			args.add(IntConstant.v(i));// (i ~5)
			SootMethod getMethod = Scene.v().getMethod(listGETSign);
			InvokeExpr getInvE= Jimple.v().newInterfaceInvokeExpr(returnListLocal, getMethod.makeRef(), args);
			Unit getTmpStmt = Jimple.v().newAssignStmt(getTmp, getInvE);
			postProcessChunk.add(getTmpStmt);
		
			// tmp = (typeCast) tmp_i;
			
			Type clientType = clientLocal.getType();
			String clientTypeName = clientLocal.getType().toString();
			if(IsPrimitive(clientTypeName))
			{// business logic/patttern is more important
				String intermTypeName = primitiveMap.get(clientTypeName);
				SootClass intermSC = Scene.v().loadClassAndSupport(intermTypeName);
				Type intermType = RefType.v(intermSC);
				Local getTmpCasted = addLocalToBody(b, getTmp+castForPrim, intermTypeName );				
				CastExpr castExpr= Jimple.v().newCastExpr(getTmp, intermType); 
				Unit castStmt = Jimple.v().newAssignStmt(getTmpCasted, castExpr);
				postProcessChunk.add(castStmt);
				
				
				//============= virtualinvoke r3.<java.lang.Integer: int intValue()>();
				SootMethod xxValueMethod = getxxValueMethod(intermSC, clientTypeName);
				Assert.assertTrue(xxValueMethod!=null);
				InvokeExpr xxValueIE = Jimple.v().newVirtualInvokeExpr(getTmpCasted, xxValueMethod.makeRef());
				Unit assignPrimValue = Jimple.v().newAssignStmt(clientLocal, xxValueIE);
				postProcessChunk.add(assignPrimValue);
				
				
			}
			else {
				CastExpr castExpr= Jimple.v().newCastExpr(getTmp, clientType); 
				Unit castStmt = Jimple.v().newAssignStmt(clientLocal, castExpr);
				postProcessChunk.add(castStmt);
				
			}
			
			
			
		}
		// this would automatically update the _currPos!
		insertStmtsAfterPoint(b.getUnits(), lastStmt, postProcessChunk);
	  if(postProcessChunk.size()!=0)	_currPos= postProcessChunk.get(postProcessChunk.size()-1);
		
		
		

		
	}

	public static SootMethod getxxValueMethod(SootClass intermSC,
			String clientTypeName) {
          Iterator<SootMethod> smIT =  intermSC.getMethods().iterator();
	      while (smIT.hasNext()) {
			SootMethod sootMethod = (SootMethod) smIT.next();
			if(sootMethod.getName().equals(clientTypeName+ValueMethodName))
			{
				Assert.assertTrue(sootMethod.getReturnType().toString().equals(clientTypeName));
				Assert.assertTrue(sootMethod.getParameterCount()==0);
				return sootMethod;
			}
			
			
		}
	      return null;
	}

	public static void registerInputs(Body b, List<Local> locals, Unit lastStmt) {
	    relevantLocals.clear();
	    ArrayList<Unit> wrapChunk = new ArrayList<Unit>();
	    for(int i=0;i<locals.size();i++)
	    {
	    	Local localTmp = locals.get(i);
	    	String  oldTypeName  =localTmp.getType().toString();
	    	if(IsPrimitive(oldTypeName))
	    	{ // temporarily change guy!
	    		String origName = localTmp.getName();
	    		String newName = origName+wrapPostFix;
	    		String newTypeName = primitiveMap.get(oldTypeName);
	    		
	    		Assert.assertTrue(newTypeName!=null);
	    		Local newLocal= addLocalToBody(b, newName, newTypeName);
	    	
	    		
	    		SootClass primTypeClass = Scene.v().loadClassAndSupport(newTypeName);
	    //		SootMethod valueOfM= primTypeClass.getMethodByName(valueOfMName);// ambiguous method!
	    	    SootMethod valueOfM = getValueOfMethod(primTypeClass,valueOfMName, oldTypeName);
	    	    if(valueOfM ==null) throw new RuntimeException("are you really a Primitive Type??");
	    		ArrayList args = new ArrayList();
	    		args.add(localTmp);
	    		InvokeExpr valueOfInvokeE = Jimple.v().newStaticInvokeExpr(valueOfM.makeRef(), args);
	    		Unit valueOfInvokeS= Jimple.v().newAssignStmt(newLocal, valueOfInvokeE);
	    		wrapChunk.add(valueOfInvokeS);	    		
	    		localTmp = newLocal;// forget about the old one!
	    	}
	    	relevantLocals.add(localTmp);
	    }
	    insertStmtsAfterPoint(b.getUnits(), lastStmt, wrapChunk);
	    if(wrapChunk.size()!=0) _currPos = wrapChunk.get(wrapChunk.size()-1);
	    
         
		
	}



	public static SootMethod getValueOfMethod(SootClass primTypeClass,
			String valueofmname2, String oldTypeName) {
		Iterator<SootMethod> smIT =  primTypeClass.getMethods().iterator();
	    while (smIT.hasNext()) {
			SootMethod sootMethod = (SootMethod) smIT.next();
			if(sootMethod.getName().equals(valueofmname2))
			{
				Type firstParaType = (Type)sootMethod.getParameterTypes().get(0);
				if(firstParaType.toString().equals(oldTypeName))
				{
					Assert.assertTrue(sootMethod.getParameterCount()==1);
					return sootMethod;
				}
			}
			
		}
		return null;
	}

	public static boolean IsPrimitive(String string) {
		Object  value = primitiveMap.get(string);
		if(value ==null) return false; // not contained
		else {
		   return true;	
		}
	}

	public static void main(String[] args) throws Exception {
		testDriver();

	}

}
