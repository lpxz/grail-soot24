package soot.jimple.toolkits.thread.synchronizationLP.StmtView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Drivers.RelativeBiPartiteCrawler;

import junit.framework.Assert;

import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.SootClass;
import soot.Unit;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.thread.synchronizationLP.CriticalSection;
import soot.jimple.toolkits.thread.synchronizationLP.LockProducer;


// key: locks4StmtViaGroup



//@ no test, test!!!!!!
// under this scheme, we do not have the LPFakeClassNode, use class simply
//that node is to keep the unity of bipartite!

// lock 4 group may be assigned manually..
//each group will have one lock
//	a list of small groups, each group has only one item
public class StmtGroupingViaAnode implements StmtGrouping{
//	public static PointsToAnalysis p2A = Scene.v().getPointsToAnalysis();
    public Map<Object, Set<Object>> avoidDupMapping = null;
	public Set<Set<Object>> groupDomain = null;// hashSet domain, I do not want to, but have to
	public  Map<Set<Object>, Object> group2Lock= null;//
	public boolean assigned =false; 
    public StmtGroupingViaAnode()
    {
    	avoidDupMapping =new HashMap<Object, Set<Object>>();
    	groupDomain = new HashSet<Set<Object>>();
    	group2Lock = new HashMap<Set<Object>, Object>();
    	assigned =false;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Object lock4Group(Set<Object> group) {
//		if(assigned) return group2Lock.get(group);
//		else {
			assignLock4Group();
		
		 return this.group2Lock.get(group);
//		}
	}

	private void assignLock4Group() {

        Iterator<Set<Object>> groupIT = groupDomain.iterator();// for seen groups
		 while (groupIT.hasNext()) {
			Set<Object> set = (Set<Object>) groupIT.next();
		    Object lock = new Object();
		    if(!group2Lock.containsKey(set))
			group2Lock.put(set, lock);		// else, do nothing to the entry!, only valid for newly added.
		}
		 
		 return;
		
	
		
	}
	
	// key
	// I think the point-to set, even the conflicting point-to set should be the same for 
	// one stmt, no matter what contexts/ transactions it is hosted. 
	public List<Object> locks4StmtViaGroup(CriticalSection itemCurr, Unit stmt) {		
		 List<Object> locks = new ArrayList<Object>();
		 List<Set<Object>> ownerGroup = whichGroups(itemCurr,stmt);
		 Iterator<Set<Object>> groupIterator= ownerGroup.iterator();
		 while (groupIterator.hasNext()) {
			Set<Object> set = (Set<Object>) groupIterator.next();
			Object lock =lock4Group(set);
			locks.add(lock);			
		}	
//		 System.out.println(stmt + "use locks during the mapping:");
//		 for(Object oo:locks)
//		 {
//			 System.out.print(oo+" ");
//		 }
			 
		return locks;
	}
	public Set<Object> getOrMakeGroup(Object obj) {
		if(avoidDupMapping.containsKey(obj))
			return avoidDupMapping.get(obj);
		else {
			 HashSet<Object> ret = new HashSet<Object>();
			 ret.add(obj);
			 avoidDupMapping.put(obj, ret);
			 return avoidDupMapping.get(obj);
		}

	}


	// here We consider the base variable


	public Set<Set<Object>> allGroups_mappedTo() {		
		return groupDomain;
	}

	
	// a list of small groups, each group has only one item
	public List<Set<Object>> whichGroups(CriticalSection itemCurr, Unit csUnit) {
		// consider the read/write point-to set for a unit in a tn!
		PointsToSet unitPointsToSet = itemCurr.unitToPoint2S.get(csUnit);
		Set<SootClass> unitClasses = itemCurr.unitToClasses.get(csUnit);
		
		final List<Set<Object>> retList = new ArrayList<Set<Object>>();
		
       // node type 1
		if(unitPointsToSet!=null)
		{
			 Assert.assertTrue(unitPointsToSet instanceof PointsToSetInternal);
			    ((PointsToSetInternal)unitPointsToSet).forall(new P2SetVisitor() {
					
					@Override
					public void visit(Node n) {
						Set<Object> singleNodeGroup= getOrMakeGroup(n);
						retList.add(singleNodeGroup);
						
					}
				});
		}
	   
	 // node type 2
		if(unitClasses!=null)
		{
			Iterator<SootClass> unitClass = unitClasses.iterator();
		    while (unitClass.hasNext()) {
				SootClass sootClass = (SootClass) unitClass.next();
				retList.add(getOrMakeGroup(sootClass));				
			}
			
		}
	    
	    
	    
	    groupDomain.addAll(retList);
	    return retList;
		
			
		
		
	}
	
	// the side-effect is context-insensitive!, so we can choose any tn of a stmt..
	public CriticalSection anyHoster(Unit stmt)
	{
		List<CriticalSection> csList = LockProducer.v().criticalSections;
		Iterator<CriticalSection> csIT = csList.iterator();
		while (csIT.hasNext()) {
			CriticalSection criticalSection = (CriticalSection) csIT.next();
			if(criticalSection.units.contains(stmt))
			{
				return criticalSection;
			}
			
		}
		return null; 
		
	}
	public List<Object> locks4StmtViaGroup(Unit stmt) {
	    CriticalSection cs = anyHoster(stmt);
	    if(cs==null)  {
	    	System.out.println("stmt is not in any TN, I do not think it is interesting");
	        Assert.assertTrue(1==0);// fail it
	    }
	return     locks4StmtViaGroup(cs, stmt);
		
	}
	
	public List<Set<Object>> whichGroups(Unit data) {
	 CriticalSection cs =anyHoster(data);
	 if(cs==null) {
		 Assert.assertTrue(1==0);
	 }
	 return whichGroups(cs, data);
	
	}
//=======================================lock order:
}

