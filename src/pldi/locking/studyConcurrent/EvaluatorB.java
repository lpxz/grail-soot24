package pldi.locking.studyConcurrent;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import soot.Body;
import soot.Hierarchy;
import soot.PointsToAnalysis;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.infoflow.InfoFlowAnalysis;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.mhp.SynchObliviousMhpAnalysis;
import soot.util.Chain;

public class EvaluatorB extends SceneTransformer {

	private EvaluatorB() {
	}
	
//	private SootField sootf;

	static String oldpath;

	public static EvaluatorB v() {
		return instance;
	}

	private static EvaluatorB instance = new EvaluatorB();

	private boolean threadCountInfo_isDetail = true;
	
	private boolean isQuestion7 = false;
	
	private boolean isForThread = false;
	
	private boolean isBrief = true;

	@Override
	protected void internalTransform(String pn, Map map) {
		
			CallGraph cg = Scene.v().getCallGraph();
			PointsToAnalysis pta = Scene.v().getPointsToAnalysis();

//			InfoFlowAnalysis ifa = new InfoFlowAnalysis(true, true);
//			Process.ifa = ifa;
			
			SynchObliviousMhpAnalysis mhp = new SynchObliviousMhpAnalysis();
			ThreadLocalObjectsAnalysis tlo = new ThreadLocalObjectsAnalysis(mhp);
			
			Hierarchy hierarchy = Scene.v().getActiveHierarchy();
			List<SootClass> runnableList = hierarchy.getImplementersOf(Scene.v().getSootClass("java.lang.Runnable"));
			
			VisitStmt.mhp = mhp;
			VisitStmt.tlo = tlo;
			
			
			
//			tlo.precompute();
			
			
//			//get all the threads
//			Iterator<AbstractRuntimeThread> threadIt = mhp.getThreads().iterator();
//			while(threadIt.hasNext()){
//				AbstractRuntimeThread t = threadIt.next();
//				System.out.println("\n"+t.toString());
//			}
			int  stmtNo = 0;
			for(SootClass sc:Scene.v().getApplicationClasses()){
				String scname = sc.getName();
				
				if(!Process.shouldAnalyzeThisClass(scname)) 
					continue;
				
//				//���type3
//				boolean tag = false;
//				
//				if(scname.equals("threadExample.ExampleThreadType3")){
//					System.out.println("this is type3: "+scname);
//					tag = true;
//				}
				
				for(SootField sf:sc.getFields()){
					Process.addField(sf);
					
//					//for test
//					if((!(sf.isStatic()))&&Process.isPrimType(sf))
//						this.sootf = sf;
				}
				
				for(SootMethod sm : sc.getMethods()){    		        	  		       		        	  
					String smname = sm.getName();
					
					if(sm.isConcrete())
					{
						if(sm.hasActiveBody())
						{
							Body body = sm.getActiveBody();
							stmtNo +=(body.getUnits().size());
						}
						
					}
					
					
					
					
					if(!Process.shouldAnalyzeThisMethod(smname))
						continue;
					
					if(sm.isAbstract() || sm.isNative())
						continue;
					
					SharedVarInfo.methodNum++;
					
				}
			}
			
			System.out.println("total stmt:" + stmtNo);
			if(isQuestion7){
				//for QuestionB7
				for(SootClass sc:Scene.v().getApplicationClasses()){
					String scname = sc.getName();
					
					if(!Process.shouldAnalyzeThisClass(scname)) 
						continue;
					
					boolean isThread = runnableList.contains(sc);
					
					for(SootMethod sm : sc.getMethods()){    		        	  		       		        	  
						String smname = sm.getName();
						if(!Process.shouldAnalyzeThisMethod(smname))
							continue;
						
						if(sm.isAbstract() || sm.isNative())
							continue;
						
						if(((sm.getName().equals("run"))&&isThread)||(sm.getName().equals("main"))){
							SharedVarInfo.threadNum++;
							Process.addThread(sc, sm);
							visitMethod(sc, sm, sm);
						}
	
					}
				}
				
				try {
					Process.printInfo(isForThread, isBrief);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				//for QuestionB1-6
				for(SootClass sc:Scene.v().getApplicationClasses()){
					String scname = sc.getName();
					
					if(!Process.shouldAnalyzeThisClass(scname)) 
						continue;
					
					for(SootMethod sm : sc.getMethods()){    		        	  		       		        	  
						String smname = sm.getName();
						if(!Process.shouldAnalyzeThisMethod(smname))
							continue;
						
						if(sm.isAbstract() || sm.isNative())
							continue;
						
						VisitStmt.isSync = false;
						VisitStmt.isSyncBlock = false;
						VisitStmt.synBlockID = 0;
						VisitStmt.isLock = false;
						VisitStmt.lockID = 0;
						
						if(sm.isSynchronized()){
			        		SharedVarInfo.synMethodNum++;
			        		Process.addSynMethod(sm);
			        		VisitStmt.isSync = true;
			        	}
						
					
			        	Body body = sm.retrieveActiveBody();
			        	Chain units = body.getUnits();
			        	
	//		        	ExceptionalUnitGraph graph = new ExceptionalUnitGraph(body);
			        	
			        	Iterator<Stmt> stmtIt = units.snapshotIterator();
			        	while(stmtIt.hasNext()){
			        		Stmt s = stmtIt.next();
			        		VisitStmt.visitStmt(s, units, sm, sc,isForThread,null, null);
			        	}
			        	
					}
				}
				try {
					Process.printInfo(isForThread, isBrief);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void visitMethod(SootClass threadClass, SootMethod threadMethod, SootMethod sm){
		
		VisitStmt.isSync = false;
		VisitStmt.isSyncBlock = false;
		VisitStmt.synBlockID = 0;
		VisitStmt.isLock = false;
		VisitStmt.lockID = 0;
		
		if(sm.isSynchronized()){
			System.out.println("this is synmethod: "+sm.toString());
    		SharedVarInfo.synMethodNum++;
    		Process.addSynMethod(sm);
    		VisitStmt.isSync = true;
    	}
			
//		System.out.println("visitMethod: "+ sm.getName());
    	Body body = sm.retrieveActiveBody();
    	Chain units = body.getUnits();
    	
    	Iterator<Stmt> stmtIt = units.snapshotIterator();
    	while(stmtIt.hasNext()){
    		Stmt s = stmtIt.next();
    		VisitStmt.visitStmt(s, units, sm, sm.getDeclaringClass(),true, threadClass, threadMethod);
    	}
	}
}
