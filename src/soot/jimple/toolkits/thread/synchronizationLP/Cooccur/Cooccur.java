package soot.jimple.toolkits.thread.synchronizationLP.Cooccur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;



import soot.jimple.toolkits.visitor.jpaul.DataStructs.Pair;
import soot.jimple.toolkits.visitor.jpaul.Graphs.ArcBasedDiGraph;
import soot.jimple.toolkits.visitor.jpaul.Graphs.DiGraph;

public class Cooccur {
	// jgraphT does not have the getRoot, and transitiveclosure for directedGraph, so using the mit code
	
	
	// the graph should be very formal structure, like lattice..
// simply ignore any null, stmt/anode!
    // if stmt1: anode1 anode 2 anode3
	//    stmt2: anode1 anode2  anode4
	//    stmt3  anode1 anode5
	//=> anode2 is covered by anode1!
	
	// we only support hashmap<object,List<Object>> matrix!
	public static Map  invert(Map<Object, List<Object>> origMatrix)
	{
		Map<Object, List<Object>> invMap = new HashMap<Object, List<Object>>();
		Iterator<Object> stmts= origMatrix.keySet().iterator();
		
		while (stmts.hasNext()) {
			Object stmt = (Object) stmts.next();
			if(stmt==null) continue;
			List<Object> anodeList = origMatrix.get(stmt);
			for(Object anode:anodeList)
			{
				if(anode==null) continue;
				if(!invMap.containsKey(anode))
				{
					invMap.put(anode, new ArrayList<Object>());
				}
				List<Object> stmtList= invMap.get(anode);
				stmtList.add(stmt);				
			}			
		}
		return invMap;
		
	}
	// note this is not the equiv relationship, union find is not proper
	// different impl can bring troubles, some big brother node may not be chosen as the rep of a set, while should be
	public static DiGraph<Object> coverGraph4RowRep(Map<Object, List<Object>> invMatrix)
	{
		Set<Pair<Object, Object>> edgesPairs = new HashSet<Pair<Object,Object>>();
		Set anodeSet = invMatrix.keySet();
		List anodeList = new ArrayList();
		for(Object oo:anodeSet) anodeList.add(oo);

		for(int i=0;i<anodeList.size()-1;i++)// we handle the symmetricity using relation()
		{
			Object anode1 = anodeList.get(i);
			List<Object> stmtList1 = invMatrix.get(anode1);
			
			for(int j=i+1;j<anodeList.size();j++)
			{
				Object anode2 = anodeList.get(j);
				List<Object> stmtList2 = invMatrix.get(anode2);
				int relation= dominateRel(stmtList1,stmtList2);
				if(relation==1|| relation==0) 
				{
					addEdge2Graph(edgesPairs,anode1,anode2);// anode1-> anode2 (gt)
				}
				else if (relation==-1) {
					addEdge2Graph(edgesPairs, anode2, anode1);// anode2=> anode1 , symmetric..
				}
				else {
					// no relation at all...
				}
				
				
			}
		}
		
		for(int i=0;i<anodeList.size();i++)
		{
			Object anode = anodeList.get(i);
			addEdge2Graph(edgesPairs, anode, anode);// do not miss those isolated anode!
		}
		DiGraph<Object> coverG= new ArcBasedDiGraph<Object>(edgesPairs);
		
		return coverG;
	}
	
	
	public static void addVertex2Graph(Object object) {
		
		
		
	}
	public static void addEdge2Graph(
			Set<Pair<Object, Object>> edgesPairs, Object anode1,
			Object anode2) {
          Pair<Object, Object> pair = new Pair<Object, Object>(anode1, anode2);
          edgesPairs.add(pair);
		
	}

	public static int dominateRel(List<Object> stmtList1,
			List<Object> stmtList2) {
        boolean lteq= lteq(stmtList1,stmtList2);
        boolean gteq = gteq(stmtList1,stmtList2);
        if(lteq&&gteq) return 0;// eq
        if(lteq && !gteq) return -1;
        if(!lteq && gteq) return 1; // this is wanted!
        if(!lteq && !gteq) return -2; // ugly
        Assert.assertTrue(1==0);
        return 0;
	}

	public static boolean gteq(List<Object> stmtList1, List<Object> stmtList2) {
	   return lteq(stmtList2, stmtList1);
	}

	public static boolean lteq(List<Object> stmtList1, List<Object> stmtList2) {
		boolean ret =true;
		for(Object item:stmtList1) // <=
		{
			if(!stmtList2.contains(item))
			{
				ret=false;
			}
		}
		return ret;
	}

	
	
	
	public static Map<Object, List<Object>> reduceOrigMatByCoverGOfInvMat(Map<Object, List<Object>> origMatrix, DiGraph<Object> coverGOfInvMat)
	{
		Map<Object, List<Object>> redOrigMap = new HashMap<Object, List<Object>>();
		
		Iterator<Object> stmts= origMatrix.keySet().iterator();
		
		while (stmts.hasNext()) {
			Object stmt = (Object) stmts.next();
			if(stmt==null) continue;
			List<Object> anodeList = origMatrix.get(stmt);
			List<Object> redAnodeList = new ArrayList<Object>();
			redOrigMap.put(stmt, redAnodeList);
			for(Object anode:anodeList)
			{
				if(anode==null) continue;
				Object oo = getCoverRoot(coverGOfInvMat,anode);
				if(oo==anode)
				{
					if(!redAnodeList.contains(oo))// avoid the repeat...
					redAnodeList.add(oo);// it is worth, or else it can be covered by some other anode for sure.
				}
			}
		}
		return redOrigMap;	
	}

	public static Object getCoverRoot(DiGraph<Object> coverGOfInvMat,
			Object anode) {
		Collection<Object> roots = coverGOfInvMat.getRoots();
		Set<Object> realRoots = realRoots(coverGOfInvMat,roots);
		for(Object root:realRoots)
		{
			boolean cont= coverGOfInvMat.transitiveSucc(root).contains(anode);
			if(cont) return root; 
		}
		Assert.assertTrue(1==0);
		return null;
	}
	
	
	public static Set<Object> realRoots(DiGraph<Object> coverGOfInvMat, Collection<Object> roots) {
		Set<Object> realRoots = new HashSet<Object>();
		for(Object root:roots)
		{
			int pre_size= coverGOfInvMat.transitivePred(root).size();
			if(pre_size==1)// himself!
			{
				realRoots.add(root);
			}
			
			
		}
		return realRoots;
	}
	public static Map  completeStory(Map<Object, List<Object>> origMatrix)
	{
		Map inv =invert(origMatrix);
		DiGraph<Object> coverGOfInvMat= coverGraph4RowRep(inv);
		return reduceOrigMatByCoverGOfInvMat(origMatrix, coverGOfInvMat);
	}
	public static Map exampleMap()
	{
		Map  orig= new HashMap<Object, List<Object>>();
		List list4stmt1 = new ArrayList<Object>(); //
		list4stmt1.add("anode2"); list4stmt1.add("anode1"); list4stmt1.add("anode3");
		orig.put("stmt1", list4stmt1);
		
		//=========
		List list4stmt2 = new ArrayList<Object>();//"anode2"
		list4stmt2.add("anode2"); list4stmt2.add("anode1"); list4stmt2.add("anode4");
		orig.put("stmt2", list4stmt2);
		
		//=========
		
		List list4stmt3 = new ArrayList<Object>();
		list4stmt3.add("anode1"); list4stmt3.add("anode5");//
		orig.put("stmt3", list4stmt3);
		return orig;
	}
	
	public static void printIt(Map<Object, List<Object>> origMatrix)
	{
		
		Iterator<Object> stmts= origMatrix.keySet().iterator();
		
		while (stmts.hasNext()) {
			Object stmt = (Object) stmts.next();
			if(stmt==null) System.out.println("curr stmt is null!, next...");
			System.out.print(stmt+ ": ");
			List<Object> anodeList = origMatrix.get(stmt);
			for(Object anode:anodeList)
			{
				System.out.print(anode+ " ");
			}			
			System.out.println("");
		}
		return;
	}
	
	
	public static void main(String[] args) {
		Map< Object, List<Object>> example  = exampleMap();
	//	Map inv = invert(example);
		Map red = completeStory(example);
		printIt(red);
	}

}
