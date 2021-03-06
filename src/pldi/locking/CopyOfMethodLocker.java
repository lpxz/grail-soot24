package pldi.locking;

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
import java.util.LinkedList;
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
import soot.LongType;
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
import soot.SootMethodRef;
import soot.Transform;
import soot.Trap;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.ClassConstant;
import soot.jimple.EnterMonitorStmt;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.GotoStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IfStmt;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NopStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.jimple.ThrowStmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JNopStmt;
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
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.pdg.RegionAnalysis;
import soot.toolkits.scalar.FlowSet;
import soot.toolkits.scalar.Pair;
import soot.util.Chain;

public class CopyOfMethodLocker {
	// phase: production level, haha
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
	public static Stmt theStmtAfterEnterMonitor= null;
	
	public static Set<Stmt > earlyEnds = new HashSet<Stmt>();// why does this exist???
	
	
	
	
	//=============================do not need resetting
	public static int throwableNum=0;

	// ===========================

	protected static final boolean optionOpenNesting = false;
	private static final String LOCALLOCK = "locallock";
	private static final String LOCALTHISLOCK = "localthislock";
	public static HashMap methodToExcUnitGraph = new HashMap();// run only once
	// after all
	public static HashMap methodToFlowSet = new HashMap();// run only once after

	// all
	//!!!!!!!!!!!!
	// needs to insert newPrep.clone() in front of exitmonitor in the 
	//exception branch!, or else if the exception direct control to the throw, maybe the 
	// localSharedS is not yet initialized!!!
	public static void main(String[] args) throws IOException { // wjtp.tn
		// @link LockProducer
		String argsOfCalfuzzer = "-f J -pp -cp /home/lpxz/eclipse/workspace/calFuzzer/lib/ant-coontrib.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/servlet.jar:/home/lpxz/eclipse/workspace/calFuzzer/lib/asm-3.1.jar:/home/lpxz/eclipse/workspace/calFuzzer/bin -process-dir /home/lpxz/eclipse/workspace/calFuzzer/bin"; // java.lang.Math

		//
	//	String argsOfToy2 = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin Toy2";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld";
		String argsOfToy2 = "-f J -pp -cp .:/home/lpxz/eclipse/workspace/pecan/pecan-monitor/sootOutput EDU.oswego.cs.dl.util.concurrent.ClockDaemon";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld";
		
		// java.lang.Math
		//org.exolab.jms.net.multiplexer.Multiplexer
		String argsOfToyW = "-f J -pp -cp .:/home/lpxz/java_standard/jre/lib/jsse.jar:/home/lpxz/java_standard/jre/lib/rt.jar -main-class driver.OpenJMSDriver driver.OpenJMSDriver"; // java.lang.Math
		String argsOfJimpleHelloWorld = "-f J -pp -cp /home/lpxz/eclipse/workspace/Playground/bin:/home/lpxz/eclipse/workspace/soot24/bin soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld"; // java.lang.Math
		String argsOfpaddleJar = "-f J -pp -cp /home/lpxz/eclipse/workspace/soot24/paddlePublic/ -process-dir /home/lpxz/eclipse/workspace/soot24/paddlePublic/"; // java.lang.Math
		// do not use the jar directly,
		// unzip it to a folder, and parse the folder like above.
		// /home/lpxz/javapool/jdk1.3.1_20/jre/lib/rt.jar

		String interString = argsOfToy2;
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
		Scene.v().loadClassAndSupport("Drivers.Chocalate");
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
        
		 wjtp.add(new Transform("wjtp.methodlocker", new SceneTransformer() {
			
			@Override
			protected void internalTransform(String phaseName, Map options) {
				for(SootClass appClass : Scene.v().getApplicationClasses())
				{
		    	    for(SootMethod sm : appClass.getMethods())
		    	    {
						if(sm.isConcrete() && sm.hasActiveBody())
						{
							//nextTask EDU.oswego.cs.dl.util.concurrent.ClockDaemon
							if(sm.getDeclaringClass().getName().equals("EDU.oswego.cs.dl.util.concurrent.ClockDaemon")
									&& sm.getName().equals("nextTask"))
							{
								//addlock(sm);
								// change lock
								//changelock(sm);
								addLockReport(sm);							
								
							}
//							if(sm.isSynchronized())
//							{
//								sm.setModifiers(sm.getModifiers()&~Modifier.SYNCHRONIZED);
//					    		addlock(sm);
//							}
							
						}
		    	    }
		    	}
				
				
				
			}

			private void addLockReport(SootMethod sm) {
				
				Body b = sm.retrieveActiveBody();
				UnitGraph eug0 = new EnhancedUnitGraph(
						b);// yes, this graph is pretty great, no bugs for the syncFinder any more

				
				Chain units = b.getUnits();
//				 Iterator<Unit> it = units.iterator();
//		        Set nops = new HashSet();
//		        while (it.hasNext()) {
//					Unit unit = (Unit) it.next();
//					if(unit instanceof NopStmt)
//					{
//						nops.add(unit);
//					
//						Iterator<Unit> itt =eug0.getPredsOf(unit).iterator();
//					    while (itt.hasNext()) {
//							Unit unit2 = (Unit) itt.next();
//							if(unit2 instanceof GotoStmt)
//							{
//						        ((GotoStmt) unit2).setTarget((Unit)units.getSuccOf(unit));
//							}	
//							else  if(unit2 instanceof IfStmt) {
//								((IfStmt) unit2).setTarget((Unit)units.getSuccOf(unit));
//							}
//						}
//					}					
//				}
//		        units.removeAll(nops);
//		        System.out.println(b.toString());
				
		      
		        
		        UnitGraph eug = new ExceptionalUnitGraph(
						b);// yes, this graph is pretty great, no bugs for the syncFinder any more

		        // nop removal does not work.

		        
				SynchronizedRegionFinder ta = new SynchronizedRegionFinder(
						eug, b, true);

		        
		        
				Unit lastUnit = (Unit) units.getLast();
				FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
				// all tns are here
				
				if(fs!=null)
				{
					
				    for (Iterator iterator = fs.iterator(); iterator
							.hasNext();) {
				    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
				    	CriticalSection cSection = (srfp).tn;
				    		
				    	
				    	
				    	System.out.println("lock:" + cSection.origLock + " "+cSection.prepStmt + " " + cSection.entermonitor);
				    try {
				    	EnterMonitorStmt enter = (EnterMonitorStmt)cSection.entermonitor;
						addCall4EnterMonitorStmt(sm,enter);
						Set<ExitMonitorStmt> exits =cSection.getExitMonitors();
						for(ExitMonitorStmt exit : exits)
						{
							addCall4ExitMonitorStmt(sm,exit);							
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println(cSection.method.getActiveBody().toString());
						
					}
										
				    	
				    	
				    	
				    }
				}
				System.exit(1);
				
				
				
			
				
			}

			private void addCall4EnterMonitorStmt(SootMethod sm, EnterMonitorStmt enter) {	
				String observerClass = "Drivers.Chocalate";
				// laod it at the begining
				String toinsertM = "";
				LinkedList args = new LinkedList();		        
		        args.addLast(getMethodThreadId(sm));
		        args.addLast(enter.getOp());
		        PatchingChain<Unit> units = sm.getActiveBody().getUnits();
		       
		        toinsertM = "beforeLocking";
		        SootMethodRef mr = Scene.v().getMethod("<" + observerClass + ": void " + toinsertM + "(long,java.lang.Object)>").makeRef();
	            units.insertBefore(Jimple.v().newInvokeStmt(Jimple.v().newStaticInvokeExpr(mr, args)), enter);
	            toinsertM = "afterLocking";
	            SootMethodRef mr2 = Scene.v().getMethod("<" + observerClass + ": void " + toinsertM + "(long,java.lang.Object)>").makeRef();
		        units.insertAfter(Jimple.v().newInvokeStmt(Jimple.v().newStaticInvokeExpr(mr2, args)), enter);
		       
			}
			
			private void addCall4ExitMonitorStmt(SootMethod sm, ExitMonitorStmt enter) {
				// TODO Auto-generated method stub
				
				String observerClass = "Drivers.Chocalate";
				// laod it at the begining
				String toinsertM = "";
				LinkedList args = new LinkedList();		        
		        args.addLast(getMethodThreadId(sm));
		        args.addLast(enter.getOp());
		        PatchingChain<Unit> units = sm.getActiveBody().getUnits();
		       
		        toinsertM = "beforeUnlocking";
		        SootMethodRef mr = Scene.v().getMethod("<" + observerClass + ": void " + toinsertM + "(long,java.lang.Object)>").makeRef();
	            units.insertBefore(Jimple.v().newInvokeStmt(Jimple.v().newStaticInvokeExpr(mr, args)), enter);
	            toinsertM = "afterUnlocking";
	            SootMethodRef mr2 = Scene.v().getMethod("<" + observerClass + ": void " + toinsertM + "(long,java.lang.Object)>").makeRef();
		        units.insertAfter(Jimple.v().newInvokeStmt(Jimple.v().newStaticInvokeExpr(mr2, args)), enter);
		       
			
			}
			
			public  Local getMethodThreadId(SootMethod sm)
		    {
		    	Body bb = sm.retrieveActiveBody();
		    	//$r0 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>() :-1
		    	//l3 = virtualinvoke $r0.<java.lang.Thread: long getId()>() :-1
		    	// Visitor.methodToThreadIdMap.get(sm)==null can not locate in time the threadId when crossing different runs 
		    	
		    	Local tid  =locateLocalThreadId(bb);
		    	if(tid==null)
		    	{
		    		tid =addLocalThreadId(bb);
		    	}
		    	

		    	return tid;
		    }
		    
			private  Local locateLocalThreadId(Body bb) {
				//the format of the existing added one:
				//$r0 = staticinvoke <java.lang.Thread: java.lang.Thread currentThread()>() :-1
		    	//l3 = virtualinvoke $r0.<java.lang.Thread: long getId()>() :-1
		    	PatchingChain<Unit> units = bb.getUnits();
				Iterator<Unit> it =units.iterator();
				while (it.hasNext()) {
					Stmt unit = (Stmt) it.next();
					if(unit.containsInvokeExpr()&& unit.toString().contains("<java.lang.Thread: java.lang.Thread currentThread()>"))
					{	// find possible
						Stmt nextOne =(Stmt) units.getSuccOf(unit);
						if(nextOne.containsInvokeExpr() && nextOne.toString().contains("<java.lang.Thread: long getId()>"))
						{
							// got it
							if(nextOne instanceof AssignStmt)
							{
								Local tid = (Local)((AssignStmt) nextOne).getLeftOp();
								if(tid.getType() instanceof LongType)
								{
									return tid;
								}
								else {
									throw new RuntimeException("how can you fail at this place, even" + tid.getType());
								}
							}
						}
							

					}
				}
				
				return null;
			}

			public  Local addLocalThreadId(Body body) {

				Chain units = body.getUnits();
				
				Local tid = Jimple.v().newLocal("tid_"+body.getMethod().getName(), LongType.v());
				Local thread_ = Jimple.v().newLocal("thread_"+body.getMethod().getName(),RefType.v("java.lang.Thread"));
				
				body.getLocals().add(tid);
				//methodToThreadIdMap.put(body.getMethod(),tid);
				// no need any more, it is not useful crossing different runs
				// I design an intelligent method to auto-find the tid
				
				body.getLocals().add(thread_);
				
		        String methodSig1 ="<" + "java.lang.Thread" +": java.lang.Thread currentThread()>";
				
		        SootMethodRef mr1 = Scene.v().getMethod(methodSig1).makeRef();
		       
		        Value staticInvoke = Jimple.v().newStaticInvokeExpr(mr1);
		        
		       	AssignStmt newAssignStmt1 = Jimple.v().newAssignStmt(thread_, staticInvoke);
		        
		        String methodSig2 ="<" + "java.lang.Thread" +": long getId()>";
				
		        SootMethodRef mr2 = Scene.v().getMethod(methodSig2).makeRef();
		       
		        Value virtualInvoke = Jimple.v().newVirtualInvokeExpr(thread_,mr2);
		        
		       	AssignStmt newAssignStmt2 = Jimple.v().newAssignStmt(tid, virtualInvoke);
		       
		       	
		       	Stmt insertStmt = getLastIdentityStmt(units);
		        if(insertStmt !=null)
		            units.insertAfter(newAssignStmt2,insertStmt);
		        else
		        	units.insertBefore(newAssignStmt2, getFirstNonIdentityStmt(units));

		        units.insertBefore(newAssignStmt1, newAssignStmt2); 
		        return tid;
			}
			
			private  Stmt getFirstNonIdentityStmt(Chain units)
			{
				Stmt s = (Stmt)units.getFirst();
				while(s instanceof IdentityStmt)
					s = (Stmt) units.getSuccOf(s);
				return s;
				
			}
			private  Stmt getLastIdentityStmt(Chain units)
			{
				Stmt s = getFirstNonIdentityStmt(units);
				return (Stmt)units.getPredOf(s);
				
			}
			
			
			//=========================
			private void changelock(SootMethod method) {				
				Body b = method.retrieveActiveBody();
				UnitGraph  eug = new EnhancedUnitGraph(
						b);

				SynchronizedRegionFinder ta = new SynchronizedRegionFinder(
						eug, b, true);
				
				Chain units = b.getUnits();
				Unit lastUnit = (Unit) units.getLast();
				FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
				// all tns are here
				
				if(fs!=null)
				{
					
				    for (Iterator iterator = fs.iterator(); iterator
							.hasNext();) {
				    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
				    	CriticalSection cSection = (srfp).tn;
				    	Stmt prep = cSection.prepStmt;
				    	
				    	Local thislocal = b.getThisLocal();
				    	Local newMonitor = Jimple.v().newLocal(LOCALTHISLOCK+b.getMethod().getName(), RefType.v("java.lang.Object"));//!!problematic!!
						if(!b.getLocals().contains(newMonitor))
						{
							b.getLocals().add(newMonitor);
						}					
						
						Stmt newprepare  = Jimple.v().newAssignStmt(newMonitor, thislocal);
						units.insertAfter(newprepare, prep);
						
						EnterMonitorStmt enter = (EnterMonitorStmt)cSection.entermonitor;
						enter.setOp(newMonitor);
						Set<ExitMonitorStmt> exits =cSection.getExitMonitors();
						for(ExitMonitorStmt exit : exits)
						{
							exit.setOp(newMonitor);
						}
						
					
					
				    	
				    	//System.out.println("lock:" + cSection.origLock + " "+cSection.prepStmt);
				    	
				    }
				}
				System.out.println(b.toString());
				
				
				
			}
		}));
		
		

	}

	public static void addlock(SootMethod sm) {

		 PatchingChain<Unit>units = sm.getActiveBody().getUnits();

		
		
		resetFlags();
		
		
//if(sm.isStatic()) return;// debugging
		monitorenter(sm);
		monitorexit(sm);
//		
		Body result = sm.getActiveBody();
		
		if(true)  
		{
			
			result.validateLocals();
			result.validateTraps();
			result.validateUnitBoxes();
			//result.validateUses();
	        

			
	            result.validateValueBoxes();
	            try {
	            	 result.checkInit();
				} catch (Exception e) {
					 result.checkInit();
				}
	           
	            result.checkTypes();
	            result.checkLocals();
		}
		
		
		
		
		
		
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
		theStmtAfterEnterMonitor=null;

	}





	// ========================================
	private static void monitorenter(SootMethod sm) {
		
		// Monitorexit needs the newPrep! should not be null
		
		JimpleBody body = (JimpleBody)sm.getActiveBody();
		PatchingChain<Unit> units  = body.getUnits();
		Local  left = null;
		if(sm.isStatic())
		{
			

			
			String classname = sm.getDeclaringClass().getName();
			String constclas = classname.replace('.', '/');
			Value right = ClassConstant.v(constclas);
			  left = Jimple.v().newLocal(LOCALLOCK+sm.getName(), RefType.v("java.lang.Class"));//!!problematic!!
			if(!body.getLocals().contains(left))
			{
				body.getLocals().add(left);
			}
			
			
			Stmt prepare  = Jimple.v().newAssignStmt(left, right);
			newPrep = prepare;//!!!!!!!!!
			newEntermonitor = Jimple.v().newEnterMonitorStmt(left);

//			if(sm.isStatic()&&sm.getParameterCount()==0)// ???, I do nto this is necessary, 
			// maybe their implementation calls for this to pass the locallock not intialization problem
//			{
//				Stmt nop=Jimple.v().newNopStmt();
//				//insert the nop just before the return stmt
//				units.insertBefore(nop, units.getFirst());
////				units.insertAfter(newEntermonitor, nop);
////				units.insertAfter(prepare, nop);
//			}
			 theStmtAfterEnterMonitor = body.getFirstNonIdentityStmt();
			units.insertBeforeNoRedirect(newPrep, theStmtAfterEnterMonitor);
			units.insertBeforeNoRedirect(newEntermonitor, theStmtAfterEnterMonitor);
//			else {
//				
//			}

			
			
			
		}
		else {
			 Local thislocal = body.getThisLocal();		 

				Local thisLocalProxy = Jimple.v().newLocal(LOCALTHISLOCK+sm.getName(), RefType.v("java.lang.Object"));//!!problematic!!
				if(!body.getLocals().contains(thisLocalProxy))
				{
					body.getLocals().add(thisLocalProxy);
				}
				
				
				Stmt prepare  = Jimple.v().newAssignStmt(thisLocalProxy, thislocal);
				newPrep = prepare;//!!!!!!!!!
							
				
				newEntermonitor = Jimple.v().newEnterMonitorStmt(thisLocalProxy);
              theStmtAfterEnterMonitor = body.getFirstNonIdentityStmt();
				units.insertBeforeNoRedirect(newPrep, theStmtAfterEnterMonitor);
				units.insertBeforeNoRedirect(newEntermonitor, theStmtAfterEnterMonitor);
			
		}
	
	    if(newPrep == null || theStmtAfterEnterMonitor==null)
	    {
	    	throw new RuntimeException();
	    }
	    localFromGlobal =  (Local)((JAssignStmt)newPrep).getLeftOp();	
	
	}

	// ===========================================
	private static void monitorexit(SootMethod sm ) {
		// inject after end, I do not know about the early ends... It is usually
		// useless
		// only for the case: exit is immediately following enter, succeed for
		// sure.
		//earlyendExit();// not implemented
		
		JimpleBody bb =(JimpleBody) sm.getActiveBody();
		PatchingChain<Unit> units = bb.getUnits();
		Set<Stmt> rets  = new HashSet<Stmt>();
		Iterator<Unit> it = bb.getUnits().iterator();
		while (it.hasNext()) {
			Unit unit = (Unit) it.next();
			if(unit instanceof ReturnVoidStmt || unit instanceof ReturnStmt)
			{
				rets.add((Stmt) unit );
			}
		}
		for(Stmt ret: rets)
		{
			standardGoToExit(ret , bb);
			exceptionalExit(ret, bb);
		}
		//=====================================original throw stmt:::

		// remmeber no need for throws!!!
		// I have seen the jimple for real world applcations
		// exceptions are special at "tianwailaiwu or dynamic if"
		// but its processing is quite normal, like if-branch!!!.return is the phi node
		// just process return is enough
		// when inserting before return, the goto [retrun] changes to goto [newly inserted]
		// this is because of the label reason.
		
//		Set<Stmt> throwset  = new HashSet<Stmt>();
//		Iterator<Unit> it2 = bb.getUnits().iterator();
//		while (it2.hasNext()) {
//			Unit unit = (Unit) it2.next();
//			if(unit instanceof ThrowStmt)
//			{
//				rets.add((Stmt) unit );
//			}
//		}
//		for(Stmt throwstmt : throwset)
//		{
//			//units.getPredOf(throwstmt);
//
//			Unit frontStmt = units.getPredOf(throwstmt);
//			while(! ((frontStmt instanceof IdentityStmt) && frontStmt.toString().contains("@caughtexception")))
//			{
//				frontStmt = units.getPredOf(frontStmt);
//			}
//			if(! ((frontStmt instanceof IdentityStmt) && frontStmt.toString().contains("@caughtexception")))
//			{
//				throw new RuntimeException();
//			}
//
//			Unit catchStmt  = frontStmt;
//			
//			
//			
//			Stmt newExceptionalExitmonitor = Jimple.v().newExitMonitorStmt(localFromGlobal);
//			units.insertBeforeNoRedirect(newExceptionalExitmonitor, throwstmt);
//			ThrowStmt throwStmt2 = (ThrowStmt) throwstmt;
//			
//			Type exceptionType = throwStmt2.getOp().getType();
//			SootClass throwableClass = null;
//			if(exceptionType instanceof RefType)
//			{
//				RefType refType = (RefType) exceptionType;
//				throwableClass =refType.getSootClass();
//			}
//			else {
//				throw new RuntimeException();
//			}
//			
//			bb.getTraps().addLast(Jimple.v().newTrap(throwableClass,newExceptionalExitmonitor, throwstmt, catchStmt));
//			
//			
//		}
		
		

	}

	private static void earlyendExit() {
		// TODO Auto-generated method stub

	}

	private static void standardGoToExit( Stmt end, JimpleBody bb) {
		PatchingChain<Unit> units = bb.getUnits();
		

//		Stmt tmp = (Stmt) newPrep.clone();
//		units.insertBefore(tmp, after);
		//=========================================================
		newGotoExitmonitor = Jimple.v().newExitMonitorStmt(localFromGlobal);
		units.insertBefore(newGotoExitmonitor, end);
//if(newPrep!=null)
//{
//	units.insertBefore((Unit)newPrep.clone(), end);
//	//!!!!!!!!!!!!
//	// needs this, or else if the exception direct control to the throw, maybe the 
//	// localSharedS is not yet initialized!!!
//}
//else {
//	throw new RuntimeException();
//}
//       Value monitorLocal = ((JAssignStmt)newPrep).getLeftOp();		
//		newGotoExitmonitor = Jimple.v().newExitMonitorStmt((Local) monitorLocal);
//		units.insertBefore(newGotoExitmonitor, end); // steal jumps to end, send
//													// them to monitorexit
		//=========================================================
		 newGotoStmt = Jimple.v().newGotoStmt(end);
		units.insertBeforeNoRedirect(newGotoStmt, end);
		//!!!
		// if you use insertBefore, all goto-> end will redirect to newlyadded
		// but newlyadded also goto-> end, then, 
		// newlyadded goto-> end, redirect to newlyadded. 
		// newlyadded goto-> newlyadded
		after = end;

	}

	private static void exceptionalExit( Stmt end, JimpleBody bb) {
		// get the lastEnd
		PatchingChain<Unit> units = bb.getUnits();
		if(newGotoStmt!=null)
		{
			lastEnd = newGotoStmt;
		}
		else {
            // no use
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
	
		
		
		
		
		
		
		
		// catch, newprep, exit, throw
		Stmt newThrow = Jimple.v().newThrowStmt(throwableLocal);
		units.insertAfter(newThrow, lastEnd);
		
		//============================
		newExceptionalExitmonitor = Jimple.v().newExitMonitorStmt(localFromGlobal);
		units.insertAfter(newExceptionalExitmonitor, lastEnd);
//		Unit tmpPrep=null;
//		if(newPrep!=null)  {
//			tmpPrep  = (Unit)newPrep.clone();
//			
//		}
//		else {
//			
//			throw new RuntimeException();
//		}
//		
//	       Value monitorLocal = ((JAssignStmt)newPrep).getLeftOp();		
//		   newExceptionalExitmonitor = Jimple.v().newExitMonitorStmt((Local) monitorLocal);
//
//		units.insertAfter(newExceptionalExitmonitor, lastEnd);// do not reuse the last exit monitor!, patchingchain will complain
//		units.insertAfter(tmpPrep, lastEnd);// do not reuse the last exit monitor!, patchingchain will complain
		//=============================
		
		Stmt newCatch = Jimple.v().newIdentityStmt(throwableLocal, Jimple.v().newCaughtExceptionRef());
		units.insertAfter(newCatch, lastEnd);
		SootClass throwableClass = Scene.v().loadClassAndSupport("java.lang.Throwable");
		bb.getTraps().addFirst(Jimple.v().newTrap(throwableClass, newExceptionalExitmonitor, newThrow, newCatch));
		bb.getTraps().addFirst(Jimple.v().newTrap(throwableClass,theStmtAfterEnterMonitor  , lastEnd, newCatch));// bb.getFirstNonIdentityStmt()
		// do not start from the identitystmt, because the localthislocal initialized after it may not be initialized due to the exceptional jumping.
		// newEntermonitor is not so precise as theStmtAfterEnterMonitor (refer to the original one genereated by soot)
		exceptionalEnd =newThrow;

	}

}
