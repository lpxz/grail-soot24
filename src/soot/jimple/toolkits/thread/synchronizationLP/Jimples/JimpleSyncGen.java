package soot.jimple.toolkits.thread.synchronizationLP.Jimples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import polyglot.ast.While;

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

import soot.jimple.AssignStmt;
import soot.jimple.EnterMonitorStmt;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IntConstant;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.MonitorStmt;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.VirtualInvokeExpr;
import soot.options.Options;
import soot.util.Chain;
import soot.util.JasminOutputStream;

// serve for the substitution of locks for the synchronized region!
// not test yet!! test!!!!!!!!
public class JimpleSyncGen extends JimpleGen {
	private static final String throwableClassName = "java.lang.Throwable";
	public static int throwableLocalID=0;
	public static void addSyncToMethod(SootMethod  sm)
	{
		// note that the sm's class must be app class!
		boolean isApp= sm.getDeclaringClass().isApplicationClass();
		if(!isApp) {
			sm.getDeclaringClass().setApplicationClass();
		}
		sm.setModifiers(sm.getModifiers() | Modifier.SYNCHRONIZED);
		
	}
	public static void removeSyncToMethod(SootMethod  sm)
	{
		boolean isApp= sm.getDeclaringClass().isApplicationClass();
		if(!isApp) {
			sm.getDeclaringClass().setApplicationClass();
		}
		sm.setModifiers(sm.getModifiers() & ~(Modifier.SYNCHRONIZED));
		
	}
	
	
	public static EnterMonitorStmt diffMonitorInEnter(Chain<Unit> units,Value op, EnterMonitorStmt ems)
	{
		if(ems.getOp()!=op)
		{
			EnterMonitorStmt newEnterMonitor= Jimple.v().newEnterMonitorStmt(op);
			substitute(units, ems, newEnterMonitor);
			return newEnterMonitor;		
		}
		else {
			return null;// no change at all
		}	
	}
	
	public static ExitMonitorStmt diffMonitorInExit(Chain<Unit> units,Value op, ExitMonitorStmt ems)
	{
		if(ems.getOp()!=op)
		{
			ExitMonitorStmt newExitMonitor= Jimple.v().newExitMonitorStmt(op);
			substitute(units, ems, newExitMonitor);
			return newExitMonitor;		
		}
		else {
			return null;// no change at all
		}	
	}

	
	public static  AssignStmt newPrepareStmt(Value leftOP, Value rightOP)
	{
		return Jimple.v().newAssignStmt(leftOP, rightOP);
		
	}
	public static void placePrepBeforeMonitorStmt(Chain<Unit> units, AssignStmt prep, MonitorStmt monitorStmt)
	{
		Value lock = prep.getLeftOp();
		Value lock2 = monitorStmt.getOp();
		if(lock!=lock2) throw new RuntimeException("locks are not matched");
		units.insertBefore(prep, monitorStmt);
	}
	// newBatch: prep, exit
	public static void gotoExitMonitor(Chain<Unit> units, List<Unit> prepNExitMonitor , Unit oldExitMonitor,
			Unit gotoTarget, Unit gotoStmt)// gotoTarget as a landmark
	{ // gotoStmt can be null, then the oldExitMonitor is null
		if(gotoTarget==null) 
			{ throw new RuntimeException("are you a goto block???");}// not a goto chunk at all
		if(gotoStmt!=null)
		{// if there exists goto, then there exists the oldexitmonitor
         substituteToStmts(units, oldExitMonitor, prepNExitMonitor);// newBatch: prep, exit
		}
		else { // no fake end: goto, no exit
			Assert.assertTrue(oldExitMonitor==null);
			gotoStmt= Jimple.v().newGotoStmt(gotoTarget);
			prepNExitMonitor.add(gotoStmt);
			insertStmtsBeforePoint(units, gotoTarget, prepNExitMonitor);			
		}	
	}
	
	// add throwableLocal
	// matching enter monitor for the trap table!
	public static void exceptionExitMonitor(Body body, List<Unit> prepNExitMonitor, Unit oldExitMonitor,
		Unit lastEnd, Unit throwStmt, Unit matchingEnterMonitorStmt)
	{
		if(lastEnd==null)  throw new RuntimeException("tell me where to insert the try-catch block!");
		Chain<Unit> units= body.getUnits();
		if(throwStmt!=null)
	    {
	    	 substituteToStmts(units, oldExitMonitor, prepNExitMonitor);// newBatch: prep, exit
	 		
	    }
	    else {// no throw, no oldExitmonitor:// actually I do not know whetehr this branch is really visited!
	    	Assert.assertTrue(oldExitMonitor==null);
	    	    //=====prepare  catch
	    		Local throwableLocal = Jimple.v().newLocal("throwableLocal"+ (throwableLocalID++), RefType.v(throwableClassName));
	    	  	body.getLocals().add(throwableLocal);
	    	    Stmt newCatch = Jimple.v().newIdentityStmt(throwableLocal, Jimple.v().newCaughtExceptionRef());
	    	
	    	    //prepare throw
	    	    Stmt newThrow=  Jimple.v().newThrowStmt(throwableLocal);
	    	    //=========prepare the newBatch code to insert after lastEnd
	    	    List<Unit> catchExitThrow = new ArrayList<Unit>();
	    	    catchExitThrow.add(newCatch);
	    	    catchExitThrow.addAll(prepNExitMonitor);
	    	    catchExitThrow.add(newThrow);
	    	    
	    	    insertStmtsAfterPoint(units, lastEnd, catchExitThrow);
	    	    //================add Traps: the mapping of the enclosing range to each try block 
	    	    Unit newExitMonitor = getExitMonitorFromList(prepNExitMonitor);
	    	    Unit firstStmtAfterEnter= getFirstAfterEnter(units, matchingEnterMonitorStmt);
	    	    SootClass throwableClass = Scene.v().loadClassAndSupport(throwableClassName);
			    body.getTraps().addFirst(Jimple.v().newTrap(throwableClass,newExitMonitor , newThrow, newCatch));
			    body.getTraps().addFirst(Jimple.v().newTrap(throwableClass, firstStmtAfterEnter, lastEnd, newCatch));
			    // the second shows up as the first in the trap!
		}
	}
	public static Unit getFirstAfterEnter(Chain<Unit> units,
			Unit matchingEnterMonitorStmt) {
		Unit ret=  units.getSuccOf(matchingEnterMonitorStmt);
		if(!(ret instanceof AssignStmt)) {
			System.out.println("seems problematic! the first stmt after the eneter is not an assignment");
		}
		return ret;
	}
	public static Unit getExitMonitorFromList(List<Unit> prepNExitMonitor) {
		for(int i=0;i<prepNExitMonitor.size();i++)
		{
			Unit unit =prepNExitMonitor.get(i);
			if(unit instanceof ExitMonitorStmt)
				return unit;
		}
		throw new RuntimeException("what is wrong with your preNExitMOnitor List?");
	}
	public static Unit getLastEnd(Chain<Unit> units, Unit gotoEnd, List<Unit> retEnd_earlyEnds)
	{
		if(gotoEnd !=null)
		{
			return gotoEnd;// use the gotodirectly, it is more close to the end
		}
		Unit lastEnd = null;
		for(int i=0;i<retEnd_earlyEnds.size();i++)
		{
			Unit tmpUnit= retEnd_earlyEnds.get(i);
			if(lastEnd==null) lastEnd=tmpUnit;
			if(units.contains(tmpUnit)&&units.contains(lastEnd)&&units.follows(tmpUnit, lastEnd))
				lastEnd =tmpUnit;
		}
		if(lastEnd==null) throw new RuntimeException("Lock region should have ends! so that we can place the exception handling");
		return lastEnd;
		
		
	}
	//================================about the end processing:
	 
	public static void helloWorld() throws Exception
	{
//correct:
// 		visitParameter:r0 := @parameter0: java.lang.String[]
//		 assignStmt: nonNewExpr     r1 = r0[0]

        Scene.v().loadClassAndSupport("java.lang.Object");
        Scene.v().loadClassAndSupport("java.lang.System");
        
		SootClass sc = addClass("HelloWorld", "java.lang.Object");
		sc.setApplicationClass();

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

          addSyncToMethod(sm);//
       //===========================
	       tellAboutClass(sc);
	       dumpToClass(sc);
   
	}
	public static void main(String[] args) throws Exception {
        
		helloWorld();

	}
	
}
