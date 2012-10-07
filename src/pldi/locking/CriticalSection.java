package pldi.locking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;



import soot.JastAddJ.ThisAccess;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.Stmt;
import soot.jimple.ThrowStmt;
import soot.jimple.internal.JNopStmt;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;

import soot.jimple.toolkits.thread.synchronization.SynchronizedRegion;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.LocalDefs;
import soot.toolkits.scalar.LocalUses;
import soot.toolkits.scalar.Pair;
import soot.toolkits.scalar.SimpleLiveLocals;
import soot.toolkits.scalar.SimpleLocalUses;
import soot.toolkits.scalar.SmartLocalDefs;
import soot.*;

public class CriticalSection extends SynchronizedRegion
{
	public static int nextIDNum = 1; 
	
	// Information about the transactional region
	public int IDNum;
	public int nestLevel;
	public String name;
	public Set<CriticalSection> childSections = new HashSet<CriticalSection>();
	//public Set<ExitMonitorStmt> exitMonitorStmts = new HashSet<ExitMonitorStmt>();
	public Set<ExitMonitorStmt> getExitMonitors()
	{
		Set<ExitMonitorStmt> exitMonitorStmts = new HashSet<ExitMonitorStmt>(); 
		Iterator iterator =this.earlyEnds.iterator();
		while (iterator.hasNext()) {
			Pair<Stmt, Stmt> pair = (Pair<Stmt, Stmt>) iterator.next();
			ExitMonitorStmt exit  = (ExitMonitorStmt)pair.getO2();
			exitMonitorStmts.add(exit);
		}
		// it is possible that there is no end!
		// just the early ends
		if(this.end !=null)
		{
			ExitMonitorStmt exit2 = (ExitMonitorStmt)this.end.getO2();
			exitMonitorStmts.add(exit2);
		}
		
	
		// sometimes exceptionalEnd is null, the data flow framework does not reach the fixpoint?
		// fix the soot bug after icse submission.
		// the problem is due to the prep.clone in front of the exceptional exitmonitor???
		Pair<Stmt, Stmt> exceptionPair = this.exceptionalEnd;
		if(exceptionPair==null)
		{
		  // throw new RuntimeException();// throw to the outside, adn regenerate the finder if necessary
			

			

		}
		else {
			//System.err.println(this.IDNum + "exceptional:" + exceptionPair.getO1());
			ExitMonitorStmt exit3 = (ExitMonitorStmt)exceptionPair.getO2();
			exitMonitorStmts.add(exit3);
		}
			
	
			
		
		
		return exitMonitorStmts;
	}
	
	
	public Set<ExitMonitorStmt> getExitMonitorsTest()
	{
		Set<ExitMonitorStmt> exitMonitorStmts = new HashSet<ExitMonitorStmt>(); 
		Iterator iterator =this.earlyEnds.iterator();
		while (iterator.hasNext()) {
			Pair<Stmt, Stmt> pair = (Pair<Stmt, Stmt>) iterator.next();
			ExitMonitorStmt exit  = (ExitMonitorStmt)pair.getO2();
			exitMonitorStmts.add(exit);
		}
		
		ExitMonitorStmt exit2 = (ExitMonitorStmt)this.end.getO2();
		exitMonitorStmts.add(exit2);
	
		// sometimes exceptionalEnd is null, the data flow framework does not reach the fixpoint?
		// fix the soot bug after icse submission.
		// the problem is due to the prep.clone in front of the exceptional exitmonitor???
		Pair<Stmt, Stmt> exceptionPair = this.exceptionalEnd;
		if(exceptionPair==null)
		{
		  throw new RuntimeException();// throw to the outside, adn regenerate the finder if necessary
			

			

		}
		else {
			System.err.println(this.IDNum + "exceptional:" + exceptionPair.getO1());
			ExitMonitorStmt exit3 = (ExitMonitorStmt)exceptionPair.getO2();
			exitMonitorStmts.add(exit3);
		}
			
	
			
		
		
		return exitMonitorStmts;
	}
	
//	public HashMap<Unit, CodeBlockRWSet> unitToReadSet;// 
//	public HashMap<Unit, CodeBlockRWSet> unitToWriteSet;
//	public HashMap<Unit, Set> unitToBases; 
	public static void main(String[] args) throws IOException { // wjtp.tn
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter("smpf/xx");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write("xx");
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	
	public Value origLock;
	public CodeBlockRWSet read, write;
	public HashSet<Unit> invokes;
	public HashSet<Unit> units;
	public HashMap<Unit, CodeBlockRWSet> unitToRWSet;
	public HashMap<Unit, List> unitToUses; // For lockset analysis
	public boolean wholeMethod;
	
	// Information for analyzing conflicts with other transactions
	public SootMethod method;
	public int setNumber; // used for breaking the list of transactions into sets

	public HashSet<Unit> waits;
	public HashSet<Unit> notifys;
	public HashSet<MethodOrMethodContext> transitiveTargets;
	
	// Locking Information
	public Value lockObject;
	public Value lockObjectArrayIndex;
	public List<EquivalentValue> lockset;
	
	CriticalSection(boolean wholeMethod, SootMethod method, int nestLevel)
	{
		super();
		this.IDNum = nextIDNum;
		nextIDNum++;
		this.nestLevel = nestLevel;
		this.read = new CodeBlockRWSet();
		this.write = new CodeBlockRWSet();
		this.invokes = new HashSet<Unit>();
		this.units = new HashSet<Unit>();
		this.unitToRWSet = new HashMap<Unit, CodeBlockRWSet>();
		this.unitToUses = new HashMap<Unit, List>();
		this.wholeMethod = wholeMethod;
		this.method = method;
		this.setNumber = 0; // 0 = no group, -1 = DELETE

		this.waits = new HashSet<Unit>();
		this.notifys = new HashSet<Unit>();
		this.transitiveTargets = null;
	    this.lockObject = null;
	    this.lockObjectArrayIndex = null;
	    this.lockset = null;
	    
	    //========
//	    this.unitToReadSet = new HashMap<Unit, CodeBlockRWSet>();
//	    this.unitToWriteSet = new HashMap<Unit, CodeBlockRWSet>();
//	    this.unitToBases = new HashMap<Unit, Set>();
	}
	
	CriticalSection(CriticalSection tn)
	{
		super(tn);
		this.IDNum = tn.IDNum;
		this.nestLevel = tn.nestLevel;
		this.origLock = tn.origLock;
		this.read = new CodeBlockRWSet(); this.read.union(tn.read);
		this.write = new CodeBlockRWSet(); this.write.union(tn.write);
		this.invokes = (HashSet<Unit>) tn.invokes.clone();
		this.units = (HashSet<Unit>) tn.units.clone();
		this.unitToRWSet = (HashMap<Unit, CodeBlockRWSet>) tn.unitToRWSet.clone();
		this.unitToUses = (HashMap<Unit, List>) tn.unitToUses.clone();
		this.wholeMethod = tn.wholeMethod;
		this.method = tn.method;
		this.setNumber = tn.setNumber;

//		 this.unitToReadSet = (HashMap<Unit, CodeBlockRWSet>) tn.unitToReadSet.clone();
//		 this.unitToWriteSet = (HashMap<Unit, CodeBlockRWSet>) tn.unitToWriteSet.clone();
//		 this.unitToBases = (HashMap<Unit, Set>) tn.unitToBases.clone();
		    
		this.waits = (HashSet<Unit>) tn.waits.clone();
		this.notifys = (HashSet<Unit>) tn.notifys.clone();
		this.transitiveTargets = (HashSet<MethodOrMethodContext>) (tn.transitiveTargets == null ? null : tn.transitiveTargets.clone());
	    this.lockObject = tn.lockObject;
	    this.lockObjectArrayIndex = tn.lockObjectArrayIndex;
	    this.lockset = tn.lockset;
	}

	protected Object clone()
	{
		return new CriticalSection(this);
	}
	
	public String toString()
	{
		return name;
	}
	
//	public void addReadSet4Stmt(Unit stmt, RWSet stmtRead) {
//		 // put it into the unitsToReadSets
//			if(stmtRead==null) return;
//			if(!unitToReadSet.containsKey(stmt))
//			{
//				CodeBlockRWSet creatIt = new CodeBlockRWSet();
//				unitToReadSet.put(stmt, creatIt);
//			}
//			
//			CodeBlockRWSet orig = unitToReadSet.get(stmt);
//		    orig.union(stmtRead);			
//		}
//
//		public void addWriteSet4Stmt(Unit stmt, RWSet stmtWrite) {
//			if(stmtWrite==null) return; 
//			if(!unitToWriteSet.containsKey(stmt))
//			{
//				CodeBlockRWSet creatIt = new CodeBlockRWSet();
//				unitToWriteSet.put(stmt, creatIt);
//			}
//			CodeBlockRWSet orig = unitToWriteSet.get(stmt);
//			orig.union(stmtWrite);		
//		}
//
//		public void addBase4Stmt(Unit stmt, HashSet uses) {
//			if(uses==null) return;
//			if(!unitToBases.containsKey(stmt))
//			{
//			    HashSet bases = new HashSet();
//			    unitToBases.put(stmt, bases);
//			}
//	        Set orig = unitToBases.get(stmt);
//	        orig.addAll(uses); 		
//		}
}
