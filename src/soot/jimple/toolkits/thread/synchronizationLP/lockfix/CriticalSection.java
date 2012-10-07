package soot.jimple.toolkits.thread.synchronizationLP.lockfix;

import java.util.*;

import junit.framework.Assert;

import soot.jimple.Stmt;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.*;

public class CriticalSection extends SynchronizedRegion
{
	//the variable-view, not the block view
//	HashSet<ConflictingData> conflictingDatas= new  HashSet<ConflictingData>();
	// sideeffect, critical section dependency, they do have, the higher quality counterpart
	
	public static int nextIDNum = 1; 
	
	// Information about the transactional region
	public int IDNum;
	public int nestLevel;
	public String name;
	public CriticalSection parent= null;// obviously, the outermost one's enclosingTX = null
	
	public Value origLock;
	public CodeBlockRWSet read, write;
	public HashSet<Unit> invokes;
	public List<Unit> units;

	// it is updated twice,
	// one is intra, in the synchornizedRegino
	// the other is inter, in the lockProducer. soot's strcuture..
	public HashMap<Unit, CodeBlockRWSet> unitToReadSet;// 
	public HashMap<Unit, CodeBlockRWSet> unitToWriteSet;
	public HashMap<Unit, Set> unitToBases; 
	public HashMap<Unit, Set> unitToCSDDs; 
	public HashMap<Unit, PointsToSet> unitToPoint2S ; 
	public HashMap<Unit, Set<SootClass>> unitToClasses ;
	
	
	// always empty, so lp makes use of it
	public HashMap<Unit, CodeBlockRWSet> unitToRWSet;
	// depreciated :
//	public HashMap<Unit, List> unitToUses; // For lockset analysis
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
	
	public CriticalSection(boolean wholeMethod, SootMethod method, int nestLevel)
	{
		
		super();
		this.IDNum = nextIDNum;
		nextIDNum++;
		this.nestLevel = nestLevel;
		this.read = new CodeBlockRWSet();
		this.write = new CodeBlockRWSet();
		this.invokes = new HashSet<Unit>();
		this.units = new ArrayList<Unit>();
		this.unitToRWSet = new HashMap<Unit, CodeBlockRWSet>();
//		this.unitToUses = new HashMap<Unit, List>();
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
	    this.unitToReadSet = new HashMap<Unit, CodeBlockRWSet>();
	    this.unitToWriteSet = new HashMap<Unit, CodeBlockRWSet>();
	    this.unitToBases = new HashMap<Unit, Set>();
	    this.unitToCSDDs = new HashMap<Unit, Set>();
	    this.unitToPoint2S = new HashMap<Unit, PointsToSet>();
	    this.unitToClasses = new HashMap<Unit, Set<SootClass>>();
	    //========
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
	//	this.units = (HashSet<Unit>) tn.units.clone();// shallow copy the reference
		for(int i=0;i< tn.units.size();i++)
		{
			this.units.add(tn.units.get(i));
		}
		
		this.unitToRWSet = (HashMap<Unit, CodeBlockRWSet>) tn.unitToRWSet.clone();
//		this.unitToUses = (HashMap<Unit, List>) tn.unitToUses.clone();
		this.wholeMethod = tn.wholeMethod;
		this.method = tn.method;
		this.setNumber = tn.setNumber;

		this.waits = (HashSet<Unit>) tn.waits.clone();
		this.notifys = (HashSet<Unit>) tn.notifys.clone();
		this.transitiveTargets = (HashSet<MethodOrMethodContext>) (tn.transitiveTargets == null ? null : tn.transitiveTargets.clone());
	    this.lockObject = tn.lockObject;
	    this.lockObjectArrayIndex = tn.lockObjectArrayIndex;
	    this.lockset = tn.lockset;
	    
	    //=========
	    this.unitToReadSet = (HashMap<Unit, CodeBlockRWSet>) tn.unitToReadSet.clone();
	    this.unitToWriteSet = (HashMap<Unit, CodeBlockRWSet>) tn.unitToWriteSet.clone();
	    this.unitToBases = (HashMap<Unit, Set>) tn.unitToBases.clone();
	    this.unitToCSDDs = (HashMap<Unit, Set>) tn.unitToCSDDs.clone();
	    this.unitToPoint2S = (HashMap<Unit, PointsToSet>) tn.unitToPoint2S.clone();
	    this.unitToClasses = (HashMap<Unit, Set<SootClass>>) tn.unitToClasses.clone();
	    //=========
	}

	protected Object clone()
	{
		return new CriticalSection(this);
	}
	
	public String toString()
	{
		return name;
	}

	public void addReadSet4Stmt(Unit stmt, RWSet stmtRead) {
	 // put it into the unitsToReadSets
		if(stmtRead==null) return;
		if(!unitToReadSet.containsKey(stmt))
		{
			CodeBlockRWSet creatIt = new CodeBlockRWSet();
			unitToReadSet.put(stmt, creatIt);
		}
		
		CodeBlockRWSet orig = unitToReadSet.get(stmt);
	    orig.union(stmtRead);			
	}

	public void addWriteSet4Stmt(Unit stmt, RWSet stmtWrite) {
		if(stmtWrite==null) return; 
		if(!unitToWriteSet.containsKey(stmt))
		{
			CodeBlockRWSet creatIt = new CodeBlockRWSet();
			unitToWriteSet.put(stmt, creatIt);
		}
		CodeBlockRWSet orig = unitToWriteSet.get(stmt);
		orig.union(stmtWrite);		
	}

	public void addBase4Stmt(Unit stmt, HashSet uses) {
		if(uses==null) return;
		if(!unitToBases.containsKey(stmt))
		{
		    HashSet bases = new HashSet();
		    unitToBases.put(stmt, bases);
		}
        Set orig = unitToBases.get(stmt);
        orig.addAll(uses); 		
	}

	

	public void addP2SForUnit(Unit csUnit, PointsToSet allAnodesInUnit) {
		if(allAnodesInUnit==null) return ;
		if(!unitToPoint2S.containsKey(csUnit))
		{
			unitToPoint2S.put(csUnit, allAnodesInUnit);
		}
		else {
			if(unitToPoint2S.get(csUnit)==allAnodesInUnit) return; // no need to repeat
			else {
				// should not pass this path, because we only add once for a unit in a tn
				System.out.println("what is up? do you need to add more than once for each unit in a tn?");
				Assert.assertTrue(1==0);
			}
		}		
	}

	public void addClassesForUnit(Unit csUnit, Set<SootClass> allClassesInUnit) {
		if(!unitToClasses.containsKey(csUnit))
		{
			unitToClasses.put(csUnit, allClassesInUnit);
		}
		else {
			if(unitToClasses.get(csUnit)==allClassesInUnit) return;
			else {
				// should not pass this path, because we only add once for a unit in a tn
				System.out.println("what is up? do you need to add more than once for each unit in a tn?");
				Assert.assertTrue(1==0);
			}			
		}		
	}


}
