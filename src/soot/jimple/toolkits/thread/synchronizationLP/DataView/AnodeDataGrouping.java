package soot.jimple.toolkits.thread.synchronizationLP.DataView;

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
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;

//@ no test, test!!!!!!
// under this scheme, we do not have the LPFakeClassNode, use class simply
//that node is to keep the unity of bipartite!
public class AnodeDataGrouping implements DataGrouping{
	public static PointsToAnalysis p2A = Scene.v().getPointsToAnalysis();
    public Map<Object, Set<Object>> avoidDupMapping = null;
	public Set<Set<Object>> groupDomain = null;// hashSet domain, I do not want to, but have to
	public  Map<Set<Object>, Object> group2Lock= null;//
	public boolean assigned =false; 
    public AnodeDataGrouping()
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
		if(assigned) return group2Lock.get(group);
		else {
			assignLock4Group();
		 return this.group2Lock.get(group);
		}
	}

	private void assignLock4Group() {

        Iterator<Set<Object>> groupIT = groupDomain.iterator();// for seen groups
		 while (groupIT.hasNext()) {
			Set<Object> set = (Set<Object>) groupIT.next();
		    Object lock = new Object();
			group2Lock.put(set, lock);		
		}
		 assigned=true;
		 return;
		
	
		
	}
	public List<Object> locks4DataViaGroup(Object data) {		
		 List<Object> locks = new ArrayList<Object>();
		 List<Set<Object>> ownerGroup = whichGroups(data);
		 Iterator<Set<Object>> groupIterator= ownerGroup.iterator();
		 while (groupIterator.hasNext()) {
			Set<Object> set = (Set<Object>) groupIterator.next();
			Object lock =lock4Group(set);
			locks.add(lock);			
		}		
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
	public List<Set<Object>> whichGroups(Object data) {
		final List retList = new ArrayList();
		if(data instanceof Local)
		{
			Local l = (Local) data;
			PointsToSet p2S= p2A.reachingObjects(l);
		    Assert.assertTrue(p2S instanceof PointsToSetInternal);
		    ((PointsToSetInternal)p2S).forall(new P2SetVisitor() {
				
				@Override
				public void visit(Node n) {
					Set<Object> singleNodeGroup= getOrMakeGroup(n);
					retList.add(singleNodeGroup);
					
				}
			});
		}
		if(data instanceof SootClass)
		{
			retList.add(getOrMakeGroup(data));
			
		}
//		if(data instanceof Object) // for testing
//		{
//			retList.add(getOrMakeGroup(data));
//		}
		// TODO Auto-generated method stub
		groupDomain.addAll(retList);
		return retList;
	}

	public Set<Set<Object>> allGroups_mappedTo() {		
		return groupDomain;
	}

}
