package pldi.locking.studyConcurrent;

import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.ConcreteRef;
import soot.jimple.EnterMonitorStmt;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.Expr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.MonitorStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.mhp.SynchObliviousMhpAnalysis;
import soot.util.Chain;

public class VisitStmt {
	
	public static Stmt stmt;
	
	public static Chain units;
	
	public static SootMethod sootMethod;
	
	public static boolean isSync;
	
	public static boolean isSyncBlock;
	
	public static int synBlockID;
	
	public static Value synBlockOP;
	
	public static boolean isLock;
	
	public static int lockID;
	
	public static boolean isForThread;
	
	public static SootClass sootClass;
	
	public static SootClass threadClass;
	
	public static SootMethod threadMethod;
	
	public static SynchObliviousMhpAnalysis mhp;

	public static ThreadLocalObjectsAnalysis tlo;
	
	public static void visitStmt(Stmt s, Chain u, SootMethod sm, SootClass sc, boolean isFT,SootClass tc, SootMethod tm) {
		stmt = s;
		units = u;
		sootMethod = sm;
		sootClass = sc;
		isForThread = isFT;
		threadClass = tc;
		threadMethod = tm;
		
		
		if(!isForThread){
			if(stmt instanceof AssignStmt){
				visitStmtAssign((AssignStmt) stmt);
			}else if(stmt instanceof ReturnStmt){
	//			visitStmtReturn((ReturnStmt) stmt);
			}else if(stmt instanceof InvokeStmt){
				visitStmtInvoke((InvokeStmt) stmt);
			}else if(stmt instanceof MonitorStmt){
				visitStmtMonitor((MonitorStmt) stmt);
			}
		}else{
			if(stmt instanceof AssignStmt){
				visitStmtAssign((AssignStmt) stmt);
			}else if(stmt instanceof InvokeStmt){
				visitStmtInvoke((InvokeStmt) stmt);
			}else if(stmt instanceof MonitorStmt){
				visitStmtMonitor((MonitorStmt) stmt);
			}
		}
		
	}
	
	public static void visitStmtMonitor(MonitorStmt monitorStmt){
		if(monitorStmt instanceof EnterMonitorStmt){
			SharedVarInfo.synBlockNum++;
			isSyncBlock = true;
			synBlockID++;
			synBlockOP = ((EnterMonitorStmt)monitorStmt).getOp();
			Process.addSynBlock(sootMethod, synBlockID, synBlockOP);
		}
		if(monitorStmt instanceof ExitMonitorStmt){
			isSyncBlock = false;
			synBlockOP = null;
		}
	}
	
	private static void visitStmtInvoke(InvokeStmt invokeStmt){
		visitExpr(invokeStmt.getInvokeExpr());
	}
	
	
	public static void visitExpr(Expr expr){
		if(expr instanceof InvokeExpr){
			SootMethod sm= ((InvokeExpr) expr).getMethod();
			SootClass sc = sm.getDeclaringClass();
			String smname = sm.getName();
			String scname = sc.getName();
			
			if(!isForThread){
				if(sm.getName().equals("lock")&&sc.getName().equals("java.util.concurrent.locks.Lock")){
					System.out.println("lock's class is: " + sc.toString());
					SharedVarInfo.lockNum++;
					isLock = true;
					lockID++;
					Process.addLock(sootMethod, lockID);
				}
				if(sm.getName().equals("unlock")&&sc.getName().equals("java.util.concurrent.locks.Lock")){
					isLock = false;
				}
			}else{
				
				if(sm.getName().equals("lock")&&sc.getName().equals("java.util.concurrent.locks.Lock")){
					SharedVarInfo.lockNum++;
					isLock = true;
					lockID++;
					Process.addLock(sootMethod, lockID);
				}
				if(sm.getName().equals("unlock")&&sc.getName().equals("java.util.concurrent.locks.Lock")){
					isLock = false;
				}
				
				boolean isSync = VisitStmt.isSync;
				boolean isSyncBlock = VisitStmt.isSyncBlock;
				int synBlockID = VisitStmt.synBlockID;
				boolean isLock = VisitStmt.isLock;
				int lockID = VisitStmt.lockID;
				if(Process.shouldAnalyzeThisClass(scname)&&Process.shouldAnalyzeThisMethod(smname)&&(!sm.isAbstract())&&(!sm.isNative()))
					if(Scene.v().getApplicationClasses().contains(sc)&&sc.getMethods().contains(sm)){
						EvaluatorB.visitMethod(threadClass, threadMethod, sm);
					}
				VisitStmt.isSync = isSync;
				VisitStmt.isSyncBlock = isSyncBlock;
				VisitStmt.synBlockID = synBlockID;
				VisitStmt.isLock = isLock ;
				VisitStmt.lockID = lockID;
			}
		}
	}
	
	private static void visitStmtReturn(ReturnStmt returnStmt){
		Value value = returnStmt.getOp();
		if(value instanceof Local){
			Value fRef = Process.getLocalRef((Local) value, sootMethod);
			if(fRef!=null){
				System.out.println(sootMethod.getName()+": local->Ref: " + fRef.toString());
			}
		}
	}

	private static void visitStmtAssign(AssignStmt assignStmt) {
		Value left = assignStmt.getLeftOp();
        Value right = assignStmt.getRightOp();
        
        if(left instanceof ConcreteRef){
        	visitLeftConcreteRef((ConcreteRef) left);
        }
        if(right instanceof ConcreteRef){
        	visitRightConcreteRef((ConcreteRef) right);
        }
        if(right instanceof Expr){
        	visitExpr((Expr) right);
        }
	}
	
	//if left op is ConcreteRef
	public static void visitLeftConcreteRef(ConcreteRef cRef){
		if(cRef instanceof StaticFieldRef){
			if(Scene.v().getApplicationClasses().contains(((StaticFieldRef) cRef).getField().getDeclaringClass())&&Process.shouldAnalyzeThisClass(((StaticFieldRef) cRef).getField().getDeclaringClass().getName()))
				visitLeftStaticFieldRef((StaticFieldRef) cRef);
		}
		if(cRef instanceof InstanceFieldRef){
			if(Scene.v().getApplicationClasses().contains(((InstanceFieldRef) cRef).getField().getDeclaringClass())&&Process.shouldAnalyzeThisClass(((InstanceFieldRef) cRef).getField().getDeclaringClass().getName()))
				visitLeftInstanceFieldRef((InstanceFieldRef) cRef);
		}
	}
	
	//if right op is ConcreteRef
	public static void visitRightConcreteRef(ConcreteRef cRef){
		if(cRef instanceof StaticFieldRef){
			if(Scene.v().getApplicationClasses().contains(((StaticFieldRef) cRef).getField().getDeclaringClass())&&Process.shouldAnalyzeThisClass(((StaticFieldRef) cRef).getField().getDeclaringClass().getName()))
				visitRightStaticFieldRef((StaticFieldRef) cRef);
		}
		if(cRef instanceof InstanceFieldRef){
			if(Scene.v().getApplicationClasses().contains(((InstanceFieldRef) cRef).getField().getDeclaringClass())&&Process.shouldAnalyzeThisClass(((InstanceFieldRef) cRef).getField().getDeclaringClass().getName()))
				visitRightInstanceFieldRef((InstanceFieldRef) cRef);
		}
	}
	
	//if left op is StaticFieldRef
	public static void visitLeftStaticFieldRef(StaticFieldRef sfRef){
		
		Process.addStaWritesNum();
		
		if(!tlo.isObjectThreadLocal(sfRef, sootMethod)){
			Process.setStaFieldShared(sfRef.getField());
			Process.addStaFieldWrite(sfRef.getField());
			
			Process.addSharedStaWritesNum();
			if(isSync||isSyncBlock||isLock)
				Process.addSharedProStaWritesNum();
			
			if(isSync){
				Process.addSynMethodWrite(sootMethod);
			}
			if(isSyncBlock){
				Process.addSynBlockWrite(sootMethod, synBlockID, synBlockOP);
			}
			if(isLock){
				Process.addLockWrite(sootMethod, lockID);
			}
			if(isForThread){
				Process.addThreadWrite(threadClass, threadMethod);
			}
		}
	}
	
	//if left op is InstanceFieldRef
	public static void visitLeftInstanceFieldRef(InstanceFieldRef ifRef){
		
		Process.addInsWritesNum();
		
		if(!tlo.isObjectThreadLocal(ifRef, sootMethod)){
			Process.addInsFieldWrite(ifRef.getField(), ifRef.getBase());
			Process.setInsFieldShared(ifRef.getField(), ifRef.getBase());
			
			Process.addSharedInsWritesNum();
			if(isSync||isSyncBlock||isLock)
				Process.addSharedProInsWritesNum();
			
			if(isSync){
				Process.addSynMethodWrite(sootMethod);
			}
			if(isSyncBlock){
				Process.addSynBlockWrite(sootMethod, synBlockID, synBlockOP);
			}
			if(isLock){
				Process.addLockWrite(sootMethod, lockID);
			}
			if(isForThread){
				Process.addThreadWrite(threadClass, threadMethod);
			}
		}
	}
	
	//if right op is StaticFieldRef
	public static void visitRightStaticFieldRef(StaticFieldRef sfRef){
		
		Process.addStaReadsNum();
		
		if(!tlo.isObjectThreadLocal(sfRef, sootMethod)){
			Process.setStaFieldShared(sfRef.getField());
			Process.addStaFieldRead(sfRef.getField());
			
			Process.addSharedStaReadsNum();
			if(isSync||isSyncBlock||isLock)
				Process.addSharedProStaReadsNum();
			
			if(isSync){
				Process.addSynMethodRead(sootMethod);
			}
			if(isSyncBlock){
				Process.addSynBlockRead(sootMethod, synBlockID, synBlockOP);
			}
			if(isLock){
				Process.addLockRead(sootMethod, lockID);
			}
			if(isForThread){
				Process.addThreadRead(threadClass, threadMethod);
			}
		}
	}
	
	//if right op is InstanceFieldRef
	public static void visitRightInstanceFieldRef(InstanceFieldRef ifRef){
		
		Process.addInsReadsNum();
		
		if(!tlo.isObjectThreadLocal(ifRef, sootMethod)){
			Process.addInsFieldRead(ifRef.getField(), ifRef.getBase());
			Process.setInsFieldShared(ifRef.getField(), ifRef.getBase());
			
			Process.addSharedInsReadsNum();
			if(isSync||isSyncBlock||isLock)
				Process.addSharedProInsReadsNum();
			
			if(isSync){
				Process.addSynMethodRead(sootMethod);
			}
			if(isSyncBlock){
				Process.addSynBlockRead(sootMethod, synBlockID, synBlockOP);
			}
			if(isLock){
				Process.addLockRead(sootMethod, lockID);
			}
			if(isForThread){
				Process.addThreadRead(threadClass, threadMethod);
			}
		}
	}
	
//	public boolean isObjectThreadLocal(Value localOrRef, SootMethod sm){
//		List<AbstractRuntimeThread> threads = mhp.getThreads();
//		if(threads.size() <= 1)
//			return true;
//		for(AbstractRuntimeThread thread : mhp.getThreads())
//	    {
//	        for(Object meth : thread.getRunMethods())
//	        {
//	        	
//	            SootMethod runMethod = (SootMethod) meth;
//	            
//				if( runMethod.getDeclaringClass().isApplicationClass() &&
//					!isObjectLocalToContext(localOrRef, sm, runMethod))
//				{
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	public boolean isObjectLocalToContext(Value localOrRef, SootMethod sm, SootMethod context)
//	{		
//		// Handle special case������localOrRef��context�е�����
//		if(sm == context)
//		{
//			//�ж�localOrRef�ǲ���local to ��ǰ��method
//			boolean isLocal = isObjectLocalToParent(localOrRef, sm);
//			return isLocal;
//		}
//	
//		// Handle obvious case,���localOrRefӦ��static field
//		if( localOrRef instanceof StaticFieldRef )
//		{
//			return false;
//		}
//
//		// Handle uncheckable case
//		if(!sm.isConcrete())
//		{
//			
//			// no way to tell... and how do we have access to a Local anyways???
//			throw new RuntimeException("Attempted to check if a local variable in a non-concrete method is shared/local.");
//		}
//
//		// For Resulting Merged Context, check if localOrRef is local
//		Body b = sm.retrieveActiveBody(); // sm is guaranteed concrete (see above)
//		// Check if localOrRef is Local in smContext
//
//		CallLocalityContext mergedContext = getClassLocalObjectsAnalysis(context.getDeclaringClass()).getMergedContext(sm);
//		if(mergedContext == null)
//		{   
//			//localOrRef����context���ɴ�
//			return true; // it's not non-local...
//		}
//
//		// with the completed mergedContext...
//		// localOrRef can actually be a field ref
//		if( localOrRef instanceof InstanceFieldRef )
//		{
//			InstanceFieldRef ifr = (InstanceFieldRef) localOrRef;
//			
//			Local thisLocal = null;
//			try{ thisLocal = b.getThisLocal(); }
//			catch(RuntimeException re) { /* Couldn't get thisLocal */ }
//			
//			//���localOrRef���õ�ǰclass�е�instance field
//			if(ifr.getBase() == thisLocal)
//			{
//				//�ж�localOrRef���õ�instance field��context���Ƿ���local��
//				boolean isLocal = mergedContext.isFieldLocal(InfoFlowAnalysis.getNodeForFieldRef(sm, ifr.getField()));
//				return isLocal;
//			}
//			else
//			{
//				boolean isLocal = SmartMethodLocalObjectsAnalysis.isObjectLocal(dfa, sm, mergedContext, ifr.getBase());
//				if(isLocal)
//				{
//					//���localOrRef.getBase��context����ObjectLocal
//					ClassLocalObjectsAnalysis cloa = getClassLocalObjectsAnalysis(context.getDeclaringClass());
//					isLocal = !cloa.getInnerSharedFields().contains(ifr.getField());
//					//����localOrRef���õ�field��context���Ƿ���LocalField
//					return isLocal;
//				}
//				else
//				{
//					return isLocal;
//				}
//			}
//		}
//
//		boolean isLocal = SmartMethodLocalObjectsAnalysis.isObjectLocal(dfa, sm, mergedContext, localOrRef);
//		return isLocal;
//	}
//	
//	public boolean isObjectLocalToParent(Value localOrRef, SootMethod sm)
//	{
//		// Handle obvious case
//		if( localOrRef instanceof StaticFieldRef )
//			return false;
//
//		ClassLocalObjectsAnalysis cloa = getClassLocalObjectsAnalysis(sm.getDeclaringClass());
//		return cloa.isObjectLocal(localOrRef, sm);
//	}
//	
//	public ClassLocalObjectsAnalysis getClassLocalObjectsAnalysis(SootClass sc)
//	{
//		if(!classToClassLocalObjectsAnalysis.containsKey(sc))
//		{
//			ClassLocalObjectsAnalysis cloa = newClassLocalObjectsAnalysis(this, dfa, uf, sc);
//			classToClassLocalObjectsAnalysis.put(sc, cloa);
//		}
//		return classToClassLocalObjectsAnalysis.get(sc);
//	}
}
