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
import java.util.Stack;

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
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NopStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.ThrowStmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JNopStmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
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

public class addLockCalls {
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
		String argsOfToy2 = "-app -f J -pp -cp . aTest.Dog";// soot.jimple.toolkits.thread.synchronizationLP.Jimples.HelloWorld";
		
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


		Setup.setupPatchOptions();// use teh -w purely for loadClassAndSupport("java.lang.Object") etc.
		Scene.v().loadClassAndSupport("lockMeta");
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
			
			private String observerClass = "lockMeta";;
			@Override
			protected void internalTransform(String phaseName, Map options) {
				for(SootClass appClass : Scene.v().getApplicationClasses())
				{
		    	    for(SootMethod sm : appClass.getMethods())
		    	    {
						if(sm.isConcrete() && sm.hasActiveBody())
						{
							//nextTask EDU.oswego.cs.dl.util.concurrent.ClockDaemon
						//	if(sm.getName().equals("main")) //sm.getDeclaringClass().getName().equals("example.URLParse")
								
							{
								//addlock(sm);
								// change lock
								//changelock(sm);
//								addlock(sm);
//								addlock(sm);
								//change2Locallock(sm);
								Set<List> ctxtListSet = new HashSet<List>();
								List<String > lStrings = new ArrayList<String>();
								lStrings.add("ss");
								lStrings.add("lp");
								ctxtListSet.add(lStrings);
								
								List<String > lStrings2 = new ArrayList<String>();
								lStrings2.add("ss");
								lStrings2.add("lp");
								ctxtListSet.add(lStrings2);
								
								registerCtxtsAsFields(ctxtListSet);
								
								addLockCalls(sm, lStrings, 1);	
								addLockCalls(sm, lStrings2, 1);	
								System.out.println(sm.getActiveBody().toString());
								
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

		    Map<List, SootField > ctxtList2field = new HashMap<List, SootField>();
			private void registerCtxtsAsFields(Set<List> ctxtListSet) {
				for(List ctxtList : ctxtListSet)
				{
//					Object result =loadTheValue_contentBased(ctxtList2field, ctxtList);
//				    if(result ==null )
				    {
				    	registerACtxtAsField(ctxtList2field, ctxtList);
				    }
				}
				
			}

			int serialNo =0;
			private void registerACtxtAsField(
					Map<List, SootField> ctxtList2field2, List ctxtList) {
				SootClass mainClassLockClass = Scene.v().getMainClass();				
				SootField ctxt = null;
				String nameString = "ctxtList_"+(serialNo ++);
				try {
					globalLockObj = mainClassLockClass.getFieldByName(nameString
							);
					// field already exists
				} catch (RuntimeException re) {
					// field does not yet exist (or, as a pre-existing error, there is
					// more than one field by this name)
					globalLockObj = new SootField(nameString, RefType
							.v("java.util.List"), Modifier.STATIC | Modifier.PUBLIC);
					mainClassLockClass.addField(globalLockObj);
				}
				
				SootMethod enforceM = null;
				Body clinitBody =null;
				Unit firstStmt =null;
				boolean addingNewClinit = !mainClassLockClass.declaresMethod("void <clinit>()");
				if (addingNewClinit) {
					enforceM = new SootMethod("<clinit>", new ArrayList(), VoidType
							.v(), Modifier.PUBLIC | Modifier.STATIC);
					clinitBody = Jimple.v().newBody(enforceM);
					enforceM.setActiveBody(clinitBody);
					mainClassLockClass.addMethod(enforceM);
					clinitBody.getUnits().add(Jimple.v().newReturnVoidStmt());
					firstStmt = clinitBody.getFirstNonIdentityStmt();// no non-id stmt
					 if(firstStmt instanceof JReturnStmt || firstStmt instanceof JReturnVoidStmt)
					 {// the empty body incurs problems during the lock injection.
						 Stmt nop=Jimple.v().newNopStmt();
						 clinitBody.getUnits().insertBefore(nop, firstStmt);									 
					 }	
				} else {
					enforceM = mainClassLockClass.getMethod("void <clinit>()");
					if(!enforceM.hasActiveBody())
						enforceM.retrieveActiveBody();
					clinitBody = (JimpleBody) enforceM.getActiveBody();
					firstStmt = clinitBody.getFirstNonIdentityStmt();
				}
				PatchingChain<Unit> clinitUnits = clinitBody.getUnits();

			
				Local ctxtListLocal = Jimple.v().newLocal("ctxtListtmp",
						RefType.v("java.util.List"));
				;

				if(!clinitBody.getLocals().contains(ctxtListLocal))
				{
					clinitBody.getLocals().add(ctxtListLocal);
				}
				
				
				// assign new object to lock obj
				Stmt newStmt = Jimple.v().newAssignStmt(ctxtListLocal,
						Jimple.v().newNewExpr(RefType.v("java.util.ArrayList")));
				clinitUnits.insertBefore(newStmt,firstStmt );
				SootClass objectClass = Scene.v().loadClassAndSupport(
				"java.util.ArrayList");
				RefType type = RefType.v(objectClass);
				SootMethod initMethod = objectClass.getMethod("void <init>()");
				Stmt initStmt = Jimple.v().newInvokeStmt(
						Jimple.v().newSpecialInvokeExpr(ctxtListLocal, initMethod.makeRef(),
								Collections.EMPTY_LIST));
				clinitUnits.insertBefore(initStmt,firstStmt );
				
				Iterator<SootMethod> it =objectClass.getMethods().iterator();
				SootMethod addMethod=null;
				while (it.hasNext()) {
					SootMethod sootMethod = (SootMethod) it.next();
					if(sootMethod.getName().equals("add") && sootMethod.getParameterCount()==1)
					{
						addMethod  = sootMethod;
						break;
					}
					
				}
				
				for(int i=0; i<ctxtList.size(); i++)
				{
					String ctxtinfo = (String) ctxtList.get(i);
					InvokeExpr ie = Jimple.v().newVirtualInvokeExpr(ctxtListLocal, addMethod.makeRef(), StringConstant.v(ctxtinfo));
					InvokeStmt invokeStmt = Jimple.v().newInvokeStmt(ie);
					clinitUnits.insertBefore(invokeStmt,firstStmt);				
				}
				
				Stmt newStmt2 = Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(globalLockObj.makeRef()),
						ctxtListLocal);
				clinitUnits.insertBefore(newStmt2,firstStmt);		
				
				ctxtList2field.put(ctxtList, globalLockObj);
				
			}

			private SootField loadTheValue_contentBased(Map<List, SootField> ctxtList2field2,
					List ctxtList) {
				Iterator<List> it  =ctxtList2field2.keySet().iterator();
				while (it.hasNext()) {
					List list = (List) it.next();
					if(stringfy(list).equals(stringfy(ctxtList)))
					{
				        return ctxtList2field2.get(list);
					}				
				}
				return null;
			}

			private String stringfy(List list) {
				StringBuilder sb = new StringBuilder();
				for(Object o : list)
				{
					sb.append(o.toString());
				}				
				
				return sb.toString();
			}
			private void addLockCalls(SootMethod sm, List ctxtList , int bugID) {
				SootClass sc = sm.getDeclaringClass();
				//if(!Util.shouldInstruThisClass(scname)) 
				//	return;
				if (sm.getName().contains("<clinit>"))			
				{
				return;
				}
				Body b = sm.retrieveActiveBody();
				
		        UnitGraph eug = new ExceptionalUnitGraph(
						b);// yes, this graph is pretty great, no bugs for the syncFinder any more
		        PatchingChain<Unit> units = b.getUnits();
		         
		     
				
				//NO IDEA WHY THIS
				//To enable insert tid
				if(sm.isStatic()&&sm.getParameterCount()==0)
				{					
					Stmt nop=Jimple.v().newNopStmt();				
					units.insertBefore(nop, units.getFirst());
				}
				
		        Iterator stmtIt = units.snapshotIterator();    	       
		        while (stmtIt.hasNext()) 
		        {
		            Stmt s = (Stmt) stmtIt.next();
		            if(s instanceof ThrowStmt)
		            {
		            	visitStmtThrow(sm,units, (ThrowStmt)s, ctxtList, bugID);
		            }
		            else if (s instanceof ReturnStmt)
		            {
		            	visitStmtReturn(sm,units, (ReturnStmt)s, ctxtList, bugID);
		            }else if (s instanceof ReturnVoidStmt)
		            {
		            	visitStmtReturnVoid(sm,units, (ReturnVoidStmt )s, ctxtList, bugID );
		            }             
		        }
		        
		    	

		   
		        addCallMethodEntry(sm,units, ctxtList, bugID);		    	
		    	b.validate();

		        
				
			
				
			}
			
			 public void visitStmtThrow(SootMethod sm, Chain units, ThrowStmt throwStmt, List ctxtList, int bugID) {
    		    boolean instru = doubleExiting_throw_ret(sm, units, throwStmt);
			    	       if(!instru)
			    	       {
			    	    	   return;
			    	       }
			    	       addCallMethodExit(sm,units, throwStmt, ctxtList, bugID);
			    }

			    private boolean doubleExiting_throw_ret(SootMethod sm, Chain units,
						ThrowStmt throwStmt) {

			    	ExceptionalUnitGraph ug = new ExceptionalUnitGraph(sm.getActiveBody());
			    	HashSet<Unit> visited  = new  HashSet<Unit>();
			    	Stack<Unit> stack = new  Stack<Unit>();
			    	stack.push(throwStmt);
			    	visited.add(throwStmt);
			    	while(stack.size()!=0)
			    	{
			    		Unit  top = stack.pop();
			    		List<Unit> childrenChain =ug.getSuccsOf(top);
			    		
			    		for(Unit child : childrenChain)
			    		{
			    			if(!visited.contains(child))
			    			{
			    				visited.add(child);
			    				stack.push(child); 
			    				 if(child instanceof ReturnStmt || child instanceof ReturnVoidStmt)
			    		    	 { 
			    		    		 System.err.println(sm.getDeclaringClass().getName() + " " + sm.getName() + " this one contains double exiting...");
			    		    		 
			    		    		 return false;
			    		    	 
			    		    	 }
			    			}
			    			else {
								// visited node...
							}
			    		}
			    	}

					return true;
				}

				public void visitStmtReturnVoid(SootMethod sm, Chain units, ReturnVoidStmt returnVoidStmt, List ctxtList, int bugID) {
					addCallMethodExit(sm,units, returnVoidStmt, ctxtList, bugID);		    	
			    }/*
			     * ReturnStmt ::= 'return' LocalOrConstant@ReturnContext
			     */

			    public void visitStmtReturn(SootMethod sm, Chain units, ReturnStmt returnStmt, List ctxtList, int bugID) {
			        		addCallMethodExit(sm,units, returnStmt, ctxtList, bugID);
			    }/*
			     * MonitorStmt ::=  EnterMonitorStmt | ExitMonitorStmt
			     */

			 
			public  void addCallMethodEntry(SootMethod sm, Chain units, List<String> ctxtsList, int bugID) {			  	
		    	String methodname = sm.getDeclaringClass().getName()+"."+sm.getName(); 
		        SootField gloab = loadTheValue_contentBased(ctxtList2field, ctxtsList);
		        if(gloab==null)
		        {
		        	throw new RuntimeException("not registered yet?");
		        }
		    	
		    	Local ctxtListLocal = Jimple.v().newLocal("ctxtList"+bugID,
						RefType.v("java.util.List"));
				;

				Body body = sm.getActiveBody();
				body.getLocals().add(ctxtListLocal);
				Unit firstNon = sm.getActiveBody().getFirstNonIdentityStmt();
				// assign new object to lock obj
				Stmt newStmt = Jimple.v().newAssignStmt(ctxtListLocal,
						Jimple.v().newStaticFieldRef(gloab.makeRef()));
				units.insertBefore(newStmt,firstNon );
				
				
				LinkedList args = new LinkedList();
		        args.add(ctxtListLocal);
		        args.add(IntConstant.v(bugID));
		        
		    	
		        SootMethodRef mr_private = Scene.v().getMethod("<" + observerClass + ": void " + "locking" + "(java.util.List,int)>").makeRef();
		         Unit s  = null; 
		        units.insertBefore(Jimple.v().newInvokeStmt(Jimple.v().newStaticInvokeExpr(mr_private, args)),firstNon );
		        
		    }
		    public  void addCallMethodExit(SootMethod sm, Chain units, Stmt s, List<String> ctxtsList, int bugID) {		      	
		    	String methodname = sm.getDeclaringClass().getName()+"."+sm.getName();    	
		    	 SootField gloab = loadTheValue_contentBased(ctxtList2field, ctxtsList);
		    	if(gloab==null)
		        {
		        	throw new RuntimeException("not registered yet?");
		        }
		    	
		    	Local ctxtListLocal = Jimple.v().newLocal("ctxtList"+bugID,
						RefType.v("java.util.List"));
				;

				Body body = sm.getActiveBody();
				body.getLocals().add(ctxtListLocal);
				
				// assign new object to lock obj
				Stmt newStmt = Jimple.v().newAssignStmt(ctxtListLocal,
						Jimple.v().newStaticFieldRef(gloab.makeRef()));
				units.insertBefore(newStmt,s );
				
		    	LinkedList args = new LinkedList();
		        args.add(ctxtListLocal);
		        args.add(IntConstant.v(bugID));
		        
//		        SootClass sc = Scene.v().getSootClass(observerClass);
//		       System.out.println(sc.getMethodByName("unlocking").getSignature());
		       
		       SootMethodRef mr_private = Scene.v().getMethod("<" + observerClass  + ": void " + "unlocking" + "(java.util.List,int)>").makeRef();
		       units.insertBefore(Jimple.v().newInvokeStmt(Jimple.v().newStaticInvokeExpr(mr_private, args)), s);
		    
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
