package soot.jimple.toolkits.thread.synchronizationLP.lockorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.Visited;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import polyglot.ast.New;

import soot.coffi.class_element_value;
import soot.jimple.toolkits.visitor.jpaul.Constraints.ConstraintSystem;
import soot.jimple.toolkits.visitor.jpaul.Constraints.LtConstraint;
import soot.jimple.toolkits.visitor.jpaul.Constraints.Var;
import soot.jimple.toolkits.visitor.jpaul.Constraints.SetConstraints.SVar;
import soot.jimple.toolkits.visitor.jpaul.Constraints.SetConstraints.SetConstraints;
import soot.jimple.toolkits.visitor.jpaul.Graphs.DiGraph;
import soot.jimple.toolkits.visitor.jpaul.Graphs.ForwardNavigator;
import soot.jimple.toolkits.visitor.jpaul.Graphs.TopSortedCompDiGraph;

public class LockOrderCollapse {
	public Map scc2rep ;
	
	public LockOrderCollapse()
	{
	scc2rep = new HashMap<Set, Object>();
	}
	public Object getRep(Set scc)
	{
		if(!scc2rep.containsKey(scc))
		{
			Assert.assertTrue(1==0);
		}
		else {
			return scc2rep.get(scc);
		}
		return null;
		
	}
	
	public Set getSCC(Object oldNode)
	{
		Set targetSCC =null;
		Set<Set> sccSet = scc2rep.keySet();
	    for(Set scc:sccSet)
	    {
	    	if(scc.contains(oldNode))
	    		{
	    		targetSCC=scc;
	    		return targetSCC;
	    		}
	    }
	    
	    return targetSCC;
	}
	public Object getRep(Object oldNode)
	{
        Set targetSCC = getSCC(oldNode);
        if(targetSCC==null) return oldNode;
	
		if(!scc2rep.containsKey(targetSCC))
		{
			// targetSCC !=null
			Assert.assertTrue(1==0);
			return null;
			
		}
		else {
			return scc2rep.get(targetSCC);
		}
		
		
	}
	// base  on the parameter type!
	public DefaultDirectedGraph<Object, DefaultEdge> encodeAsGraph1(List<LockOrderTriple> lts)
	{
		DefaultDirectedGraph<Object, DefaultEdge> ddg = new DefaultDirectedGraph<Object, DefaultEdge>(DefaultEdge.class);
		
		for(LockOrderTriple lt:lts)
		{
			Object front = lt.getFrontlock();
		    Object behind = lt.getBehindLock();
		    if(!ddg.containsVertex(front)) ddg.addVertex(front);
		    if(!ddg.containsVertex(behind)) ddg.addVertex(behind);
		    
		    if(!ddg.containsEdge(front, behind)) ddg.addEdge(front, behind);
		    
		}
		return ddg;
		
	}
	
	public DefaultDirectedGraph<Object, DefaultEdge> encodeAsGraph2(List<Pair> lts)
	{
		DefaultDirectedGraph<Object, DefaultEdge> ddg = new DefaultDirectedGraph<Object, DefaultEdge>(DefaultEdge.class);
		
		for(Pair lt:lts)
		{
			Object front = lt.getFront();
		    Object behind = lt.getBehind();
		    if(!ddg.containsVertex(front)) ddg.addVertex(front);
		    if(!ddg.containsVertex(behind)) ddg.addVertex(behind);
		    
		    if(!ddg.containsEdge(front, behind)) ddg.addEdge(front, behind);
		    
		}
		return ddg;
		
	}
	
	public DefaultDirectedGraph<Object, DefaultEdge> encodeAsGraph3(Set<LockOrderTriple> lts)
	{
		DefaultDirectedGraph<Object, DefaultEdge> ddg = new DefaultDirectedGraph<Object, DefaultEdge>(DefaultEdge.class);
		
		for(LockOrderTriple lt:lts)
		{
			Object front = lt.getFrontlock();
		    Object behind = lt.getBehindLock();
		    if(!ddg.containsVertex(front)) ddg.addVertex(front);
		    if(!ddg.containsVertex(behind)) ddg.addVertex(behind);
		    
		    if(!ddg.containsEdge(front, behind)) ddg.addEdge(front, behind);
		    
		}
		return ddg;
		
	}
	public DefaultDirectedGraph mergeSCC(DefaultDirectedGraph ddg)// vertex, edges
	{
		StrongConnectivityInspector sci = new StrongConnectivityInspector(ddg);
		List<Set> sccList= sci.stronglyConnectedSets();
		for(Set scc:sccList)
		{
			Object getOne = null;
			Iterator it = scc.iterator();
			if(it.hasNext())  getOne = it.next();
			if(getOne==null) {
				Assert.assertTrue(1==0);
			}
			scc2rep.put(scc, getOne);
		}
		//========================
		DefaultDirectedGraph mergedGraph = new DefaultDirectedGraph<Object, DefaultEdge>(DefaultEdge.class);
		Iterator<DefaultEdge> edgeit = ddg.edgeSet().iterator();
		while (edgeit.hasNext()) {
			DefaultEdge edge = (DefaultEdge) edgeit.next();
	        Object src = edge.getSource();
			Object end =edge.getTarget();
			
			Object src_rep = getRep(src);
			Object end_rep =getRep(end);
			
			if(!mergedGraph.containsVertex(src_rep)) mergedGraph.addVertex(src_rep);
			if(!mergedGraph.containsVertex(end_rep)) mergedGraph.addVertex(end_rep);
			if(!mergedGraph.containsEdge(src_rep, end_rep))
				mergedGraph.addEdge(src_rep, end_rep);			
		}
		
		return mergedGraph;
	}
	
	
	public static void main(String[] args)
	{
          List lts = new ArrayList();
          lts.add(new Pair("A", "B"));
          lts.add(new Pair("B", "C"));
          lts.add(new Pair("C", "D"));
          lts.add(new Pair("D", "B"));
          lts.add(new Pair("C", "F"));
          lts.add(new Pair("D", "G"));
          
          
          lts.add(new Pair("H", "I"));
          lts.add(new Pair("I", "J"));
          lts.add(new Pair("J", "I"));
          lts.add(new Pair("J", "K"));
          LockOrderCollapse los= new LockOrderCollapse();
          

         DefaultDirectedGraph ddg =  los.encodeAsGraph2(lts);
          los.mergeSCC(ddg);
          System.out.println(los.getRep("D"));;
          System.out.println(los.getRep("B"));;
          System.out.println(los.getRep("C"));;
          
          
          System.out.println(los.getRep("I"));;
          System.out.println(los.getRep("J"));;
        
          
          
          
          
		
	}
	
	public static class Pair
	{
		public Pair(Object frontPara , Object behindPara)
		{
			front = frontPara;
			behind= behindPara;
		}
		public Object front;
		public Object getFront() {
			return front;
		}
		public void setFront(Object front) {
			this.front = front;
		}
		public Object getBehind() {
			return behind;
		}
		public void setBehind(Object behind) {
			this.behind = behind;
		}
		public Object behind;
		
		
	}
	
	
	
	
	
	
	
	
	
//	public HashMap<Object, SVar<Object>> lock2Wrapped ;// = new HashMap<Object, SVar<Object>>();
//	public LockOrderSolver()
//	{
//		lock2Wrapped = new HashMap<Object, SVar<Object>>();
//	}
//	
//	
//	public  void  justForTest(List lts)// it is easy to change the para type
//	{
//		SetConstraints<Object> constraintSet = new  SetConstraints<Object>();
//		
//	     Iterator lt= lts.iterator();
//		while (lt.hasNext()) {
//			Pair constraintEntry = (Pair) lt.next();
//			Object front= constraintEntry.getFront();
//			Object behind = constraintEntry.getBehind();
//			
//			SVar<Object> wrapFront = new SVar<Object>();
//			
//			SVar<Object> wrapBehind = new SVar<Object>();// 
//			//default: Var<HashSet<T>>
//			
//			this.lock2Wrapped.put(front, wrapFront);
//			this.lock2Wrapped.put(behind, wrapBehind);
//			// you can look up...
//			//actually the value is not useful for me. Var<Set<T>>
//			// just for the sake of reuse code
//			constraintSet.addInclusion(wrapFront, wrapBehind);// LTConstraint.
//			// I reuse the fore-part, scc collapser and union-find's mapping
//		}
//		//ConstraintSystem<V extends Var<Info>, Info>, just type parameters...
//		// If info= Set<T>, Var<Info>= var<set<T>>= svar<T>, we set T as OBject here
//		// same type parameter as the constraint: Constraint<V extends Var<Info>, Info> 
//		ConstraintSystem<SVar<Object>,Set<Object>> constraintSystem= new ConstraintSystem<SVar<Object>, Set<Object>>(constraintSet);
//		DiGraph<SVar<Object>> reducedGraph = constraintSystem.reducedGraph;
//		//===========================
//		Iterator<SVar<Object>> redIterator=reducedGraph.getRoots().iterator();
//		while (redIterator.hasNext()) {
//			SVar<Object> sVar = (SVar<Object>) redIterator.next();
//			visit(reducedGraph,sVar);
////		     TopSortedCompDiGraph<SVar<Object>> topo_root =reducedGraph.getComponentDiGraph();// topo order Graph
////			 topo_root.decrOrder();		
//		}
//		
//		
//	}
//	// does not work, no idea.. 
//	private void visit(DiGraph<SVar<Object>> reducedGraph, SVar<Object> sVar) {
//		System.out.println(getBackOrigLock(sVar).toString()+"'s children are:");
//		
//		ForwardNavigator<SVar<Object>> fnav = reducedGraph.getForwardNavigator();
//		 List<SVar<Object>> nexts = fnav.next(sVar);
//		 for(SVar<Object> nextItem : nexts)
//		 {
//			 System.out.print(getBackOrigLock(sVar).toString()+"   ");
//			 visit(reducedGraph, nextItem);
//		 }
//		 System.out.println();
//	}
//	public Object getBackOrigLock(SVar<Object> para)
//	{
//		System.out.println(para);
//		Iterator<Entry<Object, SVar<Object>>> it = this.lock2Wrapped.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry<Object,SVar<Object>> entry = (Map.Entry<Object,SVar<Object>>) it
//					.next();
//			if(entry.getValue()==para)
//				return entry.getKey();
//			
//			
//		}
//		return null;
//		
//	}
//
//    // does not work, seems, look again in future... fuck
//	
//	public  void  callMitSolver(Set<LockOrderTriple> lts)
//	{
//		SetConstraints<Object> constraintSet = new  SetConstraints<Object>();
//		
//	     Iterator<LockOrderTriple> lt= lts.iterator();
//		while (lt.hasNext()) {
//			LockOrderTriple lockOrderTriple = (LockOrderTriple) lt.next();
//			Object front= lockOrderTriple.getFrontlock();
//			Object behind = lockOrderTriple.getBehindLock();
//			
//			SVar<Object> wrapFront = new SVar<Object>();
//			
//			SVar<Object> wrapBehind = new SVar<Object>();// 
//			//default: Var<HashSet<T>>
//			
//			this.lock2Wrapped.put(front, wrapFront);
//			this.lock2Wrapped.put(behind, wrapBehind);
//			// you can look up...
//			//actually the value is not useful for me. Var<Set<T>>
//			// just for the sake of reuse code
//			constraintSet.addInclusion(wrapFront, wrapBehind);// LTConstraint.
//			// I reuse the fore-part, scc collapser and union-find's mapping
//		}
//		//ConstraintSystem<V extends Var<Info>, Info>, just type parameters...
//		// If info= Set<T>, Var<Info>= var<set<T>>= svar<T>, we set T as OBject here
//		// same type parameter as the constraint: Constraint<V extends Var<Info>, Info> 
//		ConstraintSystem<SVar<Object>,Set<Object>> constraintSystem= new ConstraintSystem<SVar<Object>, Set<Object>>(constraintSet);
//		DiGraph<SVar<Object>> reducedGraph = constraintSystem.reducedGraph;
//		//===========================
//		Iterator<SVar<Object>> redIterator=reducedGraph.getRoots().iterator();
//		while (redIterator.hasNext()) {
//			SVar<Object> sVar = (SVar<Object>) redIterator.next();
//			// you can also call this eariler..
////		     TopSortedCompDiGraph<SVar<Object>> topo_root =reducedGraph.getComponentDiGraph();// topo order Graph
////			 topo_root.decrOrder();		
//		}
//		
//		
//	}
//	
//	public static void main(String[] args)
//	{
//          List lts = new ArrayList();
//          lts.add(new Pair("A", "B"));
//          lts.add(new Pair("B", "C"));
//          lts.add(new Pair("C", "D"));
//          lts.add(new Pair("D", "B"));
//          lts.add(new Pair("C", "F"));
//          lts.add(new Pair("D", "G"));
//          
//          
//          lts.add(new Pair("H", "I"));
//          lts.add(new Pair("I", "J"));
//          lts.add(new Pair("J", "I"));
//          lts.add(new Pair("J", "K"));
//          LockOrderSolver los= new LockOrderSolver();
//          los.justForTest(lts);
//          
//          
//          
//		
//	}
//	public static class Pair
//	{
//		public Pair(Object frontPara , Object behindPara)
//		{
//			frontPara = frontPara;
//			behind= behindPara;
//		}
//		public Object front;
//		public Object getFront() {
//			return front;
//		}
//		public void setFront(Object front) {
//			this.front = front;
//		}
//		public Object getBehind() {
//			return behind;
//		}
//		public void setBehind(Object behind) {
//			this.behind = behind;
//		}
//		public Object behind;
//		
//		
//	}
//	

}
