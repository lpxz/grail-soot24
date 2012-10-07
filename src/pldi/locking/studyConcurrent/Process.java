package pldi.locking.studyConcurrent;

import java.util.Iterator;
import java.util.List;

import soot.EquivalentValue;
import soot.Local;
import soot.PrimType;
import soot.RefLikeType;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.FieldRef;
import soot.jimple.toolkits.infoflow.CachedEquivalentValue;
import soot.jimple.toolkits.infoflow.InfoFlowAnalysis;
import soot.jimple.toolkits.infoflow.SmartMethodInfoFlowAnalysis;

public class Process {
	
	public static InfoFlowAnalysis ifa;
	
	static String[] unAnaClasses = {
		"jrockit.",
			"java.",
			"javax.",
			"xjava.",
			"COM.",
			"com.",
			"cryptix.",
			"sun.",
			"sunw.",
			"junit.",
			"org.junit.",
			"org.xmlpull.",
			"edu.hkust.leap.",
			"studyConcurrentB."
	};
	
	public static boolean isPrimType(SootField sf){
		if(sf.getType() instanceof PrimType)
			return true;
		else
			return false;
	}
	
	public static boolean isRefType(SootField sf){
		if(sf.getType() instanceof RefLikeType)
			return true;
		else
			return false;
	}
	
	public static void addField(SootField sf){
		if(sf.isStatic()){
			if(Process.isPrimType(sf)){
				SharedVarInfo.staPrimVarSet.add(new StaVarInfo(sf));
			}else if(Process.isRefType(sf)){
				SharedVarInfo.staRefVarSet.add(new StaVarInfo(sf));
			}
		}else{
			if(Process.isPrimType(sf)){
				SharedVarInfo.insPrimVarSet.add(new InsVarInfo(sf));
			}else if(Process.isRefType(sf)){
				SharedVarInfo.insRefVarSet.add(new InsVarInfo(sf));
			}
			
		}
	}
	
	public static void addStaFieldRead(SootField sf){
		if(Process.isPrimType(sf)){
			SharedVarInfo.addStaPrimVarRead(sf);
		}else if(Process.isRefType(sf)){
			SharedVarInfo.addStaRefVarRead(sf);
		}
	}
	
	public static void addStaFieldWrite(SootField sf){
		if(Process.isPrimType(sf)){
			SharedVarInfo.addStaPrimVarWrite(sf);
		}else if(Process.isRefType(sf)){
			SharedVarInfo.addStaRefVarWrite(sf);
		}
	}
	
	public static void setStaFieldShared(SootField sf){
		if(Process.isPrimType(sf)){
			SharedVarInfo.setStaPrimVarShared(sf);
		}else if(Process.isRefType(sf)){
			SharedVarInfo.setStaRefVarShared(sf);
		}
	}
	
	public static void addInsFieldRead(SootField sf, Value base){
		if(Process.isPrimType(sf)){
			SharedVarInfo.addInsPrimVarRead(sf, base);
		}else if(Process.isRefType(sf)){
			SharedVarInfo.addInsRefVarRead(sf, base);
		}
	}
	
	public static void addInsFieldWrite(SootField sf, Value base){
		if(Process.isPrimType(sf)){
			SharedVarInfo.addInsPrimVarWrite(sf, base);
		}else if(Process.isRefType(sf)){
			SharedVarInfo.addInsRefVarWrite(sf, base);
		}
	}
	
	public static void setInsFieldShared(SootField sf, Value base){
		if(Process.isPrimType(sf)){
			SharedVarInfo.setInsPrimVarShared(sf, base);
		}else if(Process.isRefType(sf)){
			SharedVarInfo.setInsRefVarShared(sf, base);
		}
	}
	
	public static void addSynMethod(SootMethod sm){
		SharedVarInfo.addSynMethod(new SynMethod(sm));
	}
	

	public static void addSynMethodRead(SootMethod sm) {
		SharedVarInfo.addSynMethodRead(new SynMethod(sm));
	}

	public static void addSynMethodWrite(SootMethod sm) {
		SharedVarInfo.addSynMethodWrite(new SynMethod(sm));
	}
	
	public static void addSynBlock(SootMethod sm, int id, Value op){
		SharedVarInfo.addSynBlock(new SynBlock(sm,id,op));
	}
	
	public static void addSynBlockRead(SootMethod sm, int id, Value op){
		SharedVarInfo.addSynBlockRead(new SynBlock(sm,id,op));
	}
	
	public static void addSynBlockWrite(SootMethod sm, int id, Value op){
		SharedVarInfo.addSynBlockWrite(new SynBlock(sm,id, op));
	}
	
	public static void addLock(SootMethod sm, int id){
		SharedVarInfo.addLock(new LockDetail(sm,id));
	}
	
	public static void addLockRead(SootMethod sm, int id){
		SharedVarInfo.addLockRead(new LockDetail(sm,id));
	}
	
	public static void addLockWrite(SootMethod sm, int id){
		SharedVarInfo.addLockWrite(new LockDetail(sm,id));
	}
	
	public static void addThread(SootClass sc, SootMethod sm){
		SharedVarInfo.addThread(new ThreadDetail(sc, sm));
	}
	
	public static void addThreadRead(SootClass sc, SootMethod sm){
		SharedVarInfo.addThreadRead(new ThreadDetail(sc, sm));
	}
	
	public static void addThreadWrite(SootClass sc, SootMethod sm){
		SharedVarInfo.addThreadWrite(new ThreadDetail(sc, sm));
	}
	
	public static void addStaReadsNum(){
		SharedVarInfo.addStaReadsNum();
	}
	
	public static void addInsReadsNum(){
		SharedVarInfo.addInsReadsNum();
	}
	
	public static void addStaWritesNum(){
		SharedVarInfo.addStaWritesNum();
	}
	
	public static void addInsWritesNum(){
		SharedVarInfo.addInsWritesNum();
	}
	
	public static void addSharedStaReadsNum(){
		SharedVarInfo.addSharedStaReadsNum();
	}
	
	public static void addSharedInsReadsNum(){
		SharedVarInfo.addSharedInsReadsNum();
	}
	
	public static void addSharedProStaReadsNum(){
		SharedVarInfo.addSharedProStaReadsNum();
	}
	
	public static void addSharedProInsReadsNum(){
		SharedVarInfo.addSharedProInsReadsNum();
	}
	
	public static void addSharedStaWritesNum(){
		SharedVarInfo.addSharedStaWritesNum();
	}
	
	public static void addSharedInsWritesNum(){
		SharedVarInfo.addSharedInsWritesNum();
	}
	
	public static void addSharedProStaWritesNum(){
		SharedVarInfo.addSharedProStaWritesNum();
	}
	
	public static void addSharedProInsWritesNum(){
		SharedVarInfo.addSharedProInsWritesNum();
	}
	
	
	
	public static Value getLocalRef(Local local, SootMethod sootMethod){
		SmartMethodInfoFlowAnalysis smdfa = ifa.getMethodInfoFlowAnalysis(sootMethod);
		EquivalentValue localEqVal = new CachedEquivalentValue(local);
		List<EquivalentValue> sources = smdfa.sourcesOf(localEqVal);
		Iterator<EquivalentValue> sourcesIt = sources.iterator();
		Value value;
		while(sourcesIt.hasNext())
		{
			EquivalentValue source = sourcesIt.next();
			value = source.getValue();
			if(value instanceof FieldRef)
				return value;
		}
		return null;
	}
	
	public static boolean shouldAnalyzeThisClass(String scname){
		for(int k=0;k<unAnaClasses.length;k++)
		{
			if(scname.startsWith(unAnaClasses[k]))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean shouldAnalyzeThisMethod(String smname){
		if (smname.contains("<clinit>")
				|| smname.contains("<init>"))
	    	{
	    		return false;
	    	}
	   		
			return true;
	}
	
	public static void printInfo (boolean isForThread, boolean isBrief) throws Exception{
		if(!isForThread)
			if(!isBrief)
				SharedVarInfo.printQ16Info();
			else
				SharedVarInfo.printQ16BriefInfo();
		else
			SharedVarInfo.printQ7Info();
	}
	
//	public static void visitMethod(ExceptionalUnitGraph graph){
//		List units = graph.getHeads();
//		Iterator<Stmt> stmtIt = units.iterator();
//		while(stmtIt.hasNext()){
//			Stmt s = stmtIt.next();
//		}
//	}
	
//	public static void visitCFG(Stmt s, ExceptionalUnitGraph graph){
//		List units = graph.getSuccsOf(s);
//		Iterator<Stmt> stmtIt = units.iterator();
//		while(stmtIt.hasNext()){
//			Stmt stmt = stmtIt.next();
//			System.out.println(stmt.toString());
//			visitCFG(stmt,graph);
//		}
//	}
}
