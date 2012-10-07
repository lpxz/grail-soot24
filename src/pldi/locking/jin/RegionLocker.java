package pldi.locking.jin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import pldi.locking.*;
import polyglot.ast.New;
import polyglot.frontend.VisitorPass;

import Drivers.Setup;
import Drivers.Utils;
import soot.Body;
import soot.BodyTransformer;
import soot.EntryPoints;
import soot.G;
import soot.Local;
import soot.Modifier;
import soot.Pack;
import soot.PackManager;
import soot.PatchingChain;
import soot.RefType;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.VoidType;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.Stmt;
import soot.jimple.internal.JimpleLocal;
import soot.jimple.internal.RValueBox;
import soot.jimple.paddle.PaddleContextSensitiveCallGraph;

import soot.jimple.toolkits.thread.synchronization.LockAllocationBodyTransformer;
import soot.jimple.toolkits.visitor.RecursiveVisitor;
import soot.jimple.toolkits.visitor.Visitor;
import soot.jimple.toolkits.visitor.VisitorForActiveTesting;
import soot.jimple.toolkits.visitor.VisitorForPrinting;
import soot.options.Options;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.toolkits.scalar.Pair;
import soot.util.Chain;

public class RegionLocker {
	// phase: function phase, not production level
	// ===========================
	// shared region for parameters, single-lock case, to be robust later,
	// [start,end, bb are already in the methdo parameters. 
	public static SootClass mainClass_lockClass =null;
	public static boolean globalLockPrepared = false;
	public static SootField globalLockObj = null;
	public static Local localFromGlobal = null;
	public static Stmt newPrep = null;
	public static Stmt newEntermonitor = null;
	public static Stmt after = null;
	public static Stmt newGotoExitmonitor=null;
	public static Stmt newGotoStmt= null;
	public static Stmt lastEnd=null;
	public static Stmt newExceptionalExitmonitor=null;
	public static Stmt exceptionalEnd= null;
	
	public static Set<Stmt > earlyEnds = new HashSet<Stmt>();// why does this exist???
	
	
	
	
	//=============================do not need resetting
	public static int throwableNum=0;

	// ===========================

	protected static final boolean optionOpenNesting = false;
	public static HashMap methodToExcUnitGraph = new HashMap();// run only once
	// after all
	public static HashMap methodToFlowSet = new HashMap();// run only once after

	// all

	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
		String argsOfCalfuzzer = "-f J -pp -cp /home/lpxz/eclipse/workspace/calFuzzer/lib/ant-coontrib.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/servlet.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/asm-3.1.jar:/home/lpxz/eclipse/workspace/calFuzzer/bin -process-dir /home/lpxz/eclipse/workspace/calFuzzer/bin"; // java.lang.Math

		//
		String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld";
		// //
		// java.lang.Math
		String argsOfToyW = "-pp -cp /home/lpxz/eclipse/workspace/simple/bin example.Example"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		// do not use the jar directly,
		// unzip it to a folder, and parse the folder like above.
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToyW;
		String[] finalArgs = interString.split(" ");

		soot.Main.v().processCmdLine(finalArgs);

		List excludesList = new ArrayList();
		excludesList.add("jrockit.");
		excludesList.add("com.bea.jrockit");
		excludesList.add("sun.");
		Options.v().set_exclude(excludesList);

		// / Options.v().set_output_dir("paddle_public.jar");
		// Options.v().set_output_jar(true);// same as the name as the outdir
		// (actually substitue it), so must be set.

		Setup.setupPatchOptions();// use teh -w purely for loadClassAndSupport("java.lang.Object") etc.
		Scene.v().loadNecessaryClasses();
		// Setup.setPhaseOptionsForPaddleWork();
		// Setup.setPhaseOptionsForSparkWork();

		Pack wjtp = PackManager.v().getPack("wjtp");
		addgetRegionPackToWJtp(wjtp);// -w mode 1 for loadClass and support, 
		                             //         2 changes the class method's iterator. concurrencymodi..


		PackManager.v().runPacks();// 1
		PackManager.v().writeOutput();
		G.reset();
	}

	// List entryPoints=EntryPoints.v().methodsOfApplicationClasses();
	// List mainEntries = new ArrayList();
	// for(int i=0;i< entryPoints.size(); i++)
	// {
	// if(entryPoints.get(i).toString().contains("main"))
	// {
	// mainEntries.add(entryPoints.get(i));
	// }
	// }
	//
	// soot.Scene.v().setEntryPoints(mainEntries); // process : app and its
	// reachable methods.

	private static void addgetRegionPackToWJtp(Pack wjtp) {
        
		 wjtp.add(new Transform("wjtp.regionlocker", new SceneTransformer() {
			
			@Override
			protected void internalTransform(String phaseName, Map options) {
				for(SootClass appClass : Scene.v().getApplicationClasses())
				{
		    	    for(SootMethod sm : appClass.getMethods())
		    	    {
						if(sm.isConcrete() && sm.hasActiveBody())
						{
							Body  b = sm.getActiveBody();


							ExceptionalUnitGraph eug = new ExceptionalUnitGraph(b);
							methodToExcUnitGraph.put(sm, eug);

							// run the intraprocedural analysis
							if (sm.getName().contains("main"))// test bed env
							{
								DirectedGraph dg = new BriefUnitGraph(b);
								Iterator it = dg.iterator();
								Stmt start = null;
								Stmt end = null;
								JimpleBody bb = (JimpleBody)b;
								while (it.hasNext()) {// to be robust soon, get two ends
									Stmt object = (Stmt) it.next();
									// System.out.println(object.toString());
								
									// System.out.println(bb.getClass());
//									start = bb.getFirstNonIdentityStmt();
//									end = Utils.getStmtBeforeRet(bb);
//									System.out.println(start + " -> " + end);
									if(object.toString().contains("pp1"))
									{
										start = (Stmt) object;
									}
									if(object.toString().contains("pp2"))
									{
										end  = (Stmt)object;
									}

								}

								addLock(start, end, bb);

							}

						
							
		    		    	
						}
		    	    }
		    	}
				
				
				
			}
		}));
		
		

	}

	protected static void addLock(Stmt start, Stmt end, JimpleBody bb) {
		resetFlags();
		mainClass_lockClass = bb.getMethod().getDeclaringClass();
		prepare(start, end, bb);
		monitorenter(start, end, bb);
		monitorexit(start, end, bb);
		bb.validateLP();

	}

	private static void resetFlags() {
		mainClass_lockClass =null;
		globalLockPrepared = false;
		globalLockObj = null;
		localFromGlobal = null;
		newPrep = null;
		newEntermonitor = null;
		after = null;
		newGotoExitmonitor = null;
		newGotoStmt= null;
		lastEnd=null;
		earlyEnds = new HashSet<Stmt>();
		newExceptionalExitmonitor=null;
		exceptionalEnd=null;

	}

	private static void prepare(Stmt start, Stmt end, JimpleBody bb) {
		if (!globalLockPrepared) {
			addGlobalLock();
			initializeGlobalLock();
			getGlobalLockInMethod(start, end, bb);// localFromGlobal, newPrep

			globalLockPrepared = true;
		}

	}

	private static void addGlobalLock() {

		globalLockObj = null;
		try {
			globalLockObj = mainClass_lockClass.getFieldByName(
					"globalLockObj");
			// field already exists
		} catch (RuntimeException re) {
			// field does not yet exist (or, as a pre-existing error, there is
			// more than one field by this name)
			globalLockObj = new SootField("globalLockObj", RefType
					.v("java.lang.Object"), Modifier.STATIC | Modifier.PUBLIC);
			mainClass_lockClass.addField(globalLockObj);
		}

	}

	private static void initializeGlobalLock() {
		// Either get or add the <clinit> method to the main class
		SootClass mainClass = mainClass_lockClass;
		SootMethod clinitMethod = null;
		JimpleBody clinitBody = null;
		Stmt firstStmt = null;
		boolean addingNewClinit = !mainClass.declaresMethod("void <clinit>()");
		if (addingNewClinit) {
			clinitMethod = new SootMethod("<clinit>", new ArrayList(), VoidType
					.v(), Modifier.PUBLIC | Modifier.STATIC);
			clinitBody = Jimple.v().newBody(clinitMethod);
			clinitMethod.setActiveBody(clinitBody);
			mainClass.addMethod(clinitMethod);
		} else {
			clinitMethod = mainClass.getMethod("void <clinit>()");
			clinitBody = (JimpleBody) clinitMethod.getActiveBody();
			firstStmt = clinitBody.getFirstNonIdentityStmt();
		}
		PatchingChain<Unit> clinitUnits = clinitBody.getUnits();
		Local lockObj = Jimple.v().newLocal("localToGlobal_clinit",
				RefType.v("java.lang.Object"));
		;

		// add local lock obj
		// addedLocalLockObj[i] = true;
		clinitBody.getLocals().add(lockObj);

		// assign new object to lock obj
		Stmt newStmt = Jimple.v().newAssignStmt(lockObj,
				Jimple.v().newNewExpr(RefType.v("java.lang.Object")));
		if (addingNewClinit)
			clinitUnits.add(newStmt);
		else
			clinitUnits.insertBeforeNoRedirect(newStmt, firstStmt);

		// initialize new object
		
		SootClass objectClass = Scene.v().loadClassAndSupport(
				"java.lang.Object");
		RefType type = RefType.v(objectClass);
		SootMethod initMethod = objectClass.getMethod("void <init>()");
		Stmt initStmt = Jimple.v().newInvokeStmt(
				Jimple.v().newSpecialInvokeExpr(lockObj, initMethod.makeRef(),
						Collections.EMPTY_LIST));
		if (addingNewClinit)
			clinitUnits.add(initStmt);
		else
			clinitUnits.insertBeforeNoRedirect(initStmt, firstStmt);

		// copy new object to global static lock object (for use by other fns)
		Stmt assignStmt = Jimple.v().newAssignStmt(
				Jimple.v().newStaticFieldRef(globalLockObj.makeRef()), lockObj);
		if (addingNewClinit)
			clinitUnits.add(assignStmt);
		else
			clinitUnits.insertBeforeNoRedirect(assignStmt, firstStmt);

		if (addingNewClinit) // finally
			clinitUnits.add(Jimple.v().newReturnVoidStmt());

	}

	private static void getGlobalLockInMethod(Stmt start, Stmt end,
			JimpleBody bb) {
		localFromGlobal = Jimple.v().newLocal("localFromGlobal_method",
				RefType.v("java.lang.Object"));
		;

		bb.getLocals().add(localFromGlobal);

		newPrep = Jimple.v().newAssignStmt(localFromGlobal,
				Jimple.v().newStaticFieldRef(globalLockObj.makeRef()));
		PatchingChain<Unit> us = bb.getUnits();
		us.insertBeforeNoRedirect(newPrep, start);// ? insertBefore <- this is
													// the original version

	}

	// ========================================
	private static void monitorenter(Stmt start, Stmt end, JimpleBody bb) {
		newEntermonitor = Jimple.v().newEnterMonitorStmt(localFromGlobal);
		PatchingChain<Unit> units = bb.getUnits();
		units.insertBeforeNoRedirect(newEntermonitor, start);
	}

	// ===========================================
	private static void monitorexit(Stmt start, Stmt end, JimpleBody bb) {
		// inject after end, I do not know about the early ends... It is usually
		// useless
		// only for the case: exit is immediately following enter, succeed for
		// sure.
		earlyendExit();// not implemented
		standardGoToExit(start, end, bb);
		exceptionalExit(start, end, bb);

	}

	private static void earlyendExit() {
		// TODO Auto-generated method stub

	}

	private static void standardGoToExit(Stmt start, Stmt end, JimpleBody bb) {
		PatchingChain<Unit> units = bb.getUnits();
		after = (Stmt) units.getSuccOf(end);

		Stmt tmp = (Stmt) newPrep.clone();
		units.insertBefore(tmp, after);

		newGotoExitmonitor = Jimple.v().newExitMonitorStmt(localFromGlobal);
		units.insertBefore(newGotoExitmonitor, after); // steal jumps to end, send
													// them to monitorexit
		 newGotoStmt = Jimple.v().newGotoStmt(after);
		units.insertBeforeNoRedirect(newGotoStmt, after);

	}

	private static void exceptionalExit(Stmt start, Stmt end, JimpleBody bb) {
		// get the lastEnd
		PatchingChain<Unit> units = bb.getUnits();
		if(newGotoStmt!=null)
		{
			lastEnd = newGotoStmt;
		}
		else {

			for (Stmt earlyEnd : earlyEnds) {				
				if( lastEnd == null || (units.contains(lastEnd) && units.contains(earlyEnd) && units.follows(earlyEnd, lastEnd)) )
					lastEnd = end;// the latest early end! follow decides
			}
		
		}
		if( lastEnd == null )
			throw new RuntimeException("Lock Region has no ends!  Where should we put the exception handling???");

		//=====================
		// Add throwable
		Local throwableLocal = Jimple.v().newLocal("throwableLocal" + (throwableNum++), RefType.v("java.lang.Throwable"));
		bb.getLocals().add(throwableLocal);
		// Add stmts
		Stmt newCatch = Jimple.v().newIdentityStmt(throwableLocal, Jimple.v().newCaughtExceptionRef());
		
		newExceptionalExitmonitor = Jimple.v().newExitMonitorStmt(localFromGlobal);
		units.insertAfter(newCatch, lastEnd);
		units.insertAfter(newExceptionalExitmonitor, newCatch);// do not reuse the last exit monitor!, patchingchain will complain
		Stmt newThrow = Jimple.v().newThrowStmt(throwableLocal);
		units.insertAfter(newThrow, newExceptionalExitmonitor);
		// Add traps
		SootClass throwableClass = Scene.v().loadClassAndSupport("java.lang.Throwable");
		bb.getTraps().addFirst(Jimple.v().newTrap(throwableClass, newExceptionalExitmonitor, newThrow, newCatch));
		bb.getTraps().addFirst(Jimple.v().newTrap(throwableClass, start, lastEnd, newCatch));
		exceptionalEnd =newThrow;

	}

}
