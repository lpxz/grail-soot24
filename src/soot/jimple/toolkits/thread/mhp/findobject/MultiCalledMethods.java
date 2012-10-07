package soot.jimple.toolkits.thread.mhp.findobject;

import soot.Scene;
import soot.SootMethod;
import soot.toolkits.graph.CompleteUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.FlowSet;
import soot.util.*;
import java.util.*;

import junit.framework.Assert;

import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.thread.mhp.pegcallgraph.PegCallGraph;
/*
 import soot.tagkit.*;
 import soot.toolkits.scalar.*;
 */
// *** USE AT YOUR OWN RISK ***
// May Happen in Parallel (MHP) analysis by Lin Li.
// This code should be treated as beta-quality code.
// It was written in 2003, but not incorporated into Soot until 2006.
// As such, it may contain incorrect assumptions about the usage
// of certain Soot classes.
// Some portions of this MHP analysis have been quality-checked, and are
// now used by the Transactions toolkit.
//
// -Richard L. Halpert, 2006-11-30
// this is problematic!!!
public class MultiCalledMethods{
	
	Set visited = new HashSet();
	Set<Object> multiCalledMethods = new HashSet<Object>();
	
	// MrunS is the final purpose of the AllocNodeFinder
	// MrunS= MrunS0 | McalledM_prop
	
	// McalledM_prop= prop(McalledM);
	// McalledM= MrunS0|Mcalled_on_cg
	// you see the computation flow
	// the original soot misses the MrunS0 in computing McalledM!
	// that is why the specjbb's wthread.start() is not judged as multiple objects...
	MultiCalledMethods(PegCallGraph pcg, Set<Object> mcm){
//		System.out.println("==inside MultiCaleedMethods==");
		//checkScc(pcg);
		multiCalledMethods = mcm;	
		Assert.assertTrue(multiCalledMethods.size()==0);
		byMCalledS0(pcg);
	//	propagate(pcg); 
		finder1(pcg);
		finder2(pcg);
		propagate(pcg); 
//		test();
		
	}
	private void byMCalledS0(PegCallGraph pcg) {
		Iterator it = pcg.iterator();
		while (it.hasNext()){
			// System.out.println("==inside it of AllocNodesFinder===");
			SootMethod sm = (SootMethod)it.next();
			UnitGraph graph = new CompleteUnitGraph(sm.getActiveBody());
			CallGraph callGraph = Scene.v().getCallGraph();
			MultiRunStatementsFinder finder = new MultiRunStatementsFinder(graph, sm, multiCalledMethods, callGraph);
			// the above stmt will automatically update teh multicalledMethod! look atthe code 
			FlowSet fs = finder.getMultiRunStatements();
		}
		
	}
	private void propagate(PegCallGraph pcg){
		/* If a method call inside a loop, this method may be called more than one,
		 * and this is done with MultiRunStatementsFinder.
		 * This information should be propagated through call graph.
		 * This method implements the propagation.
		 */
		Iterator<Object> it = multiCalledMethods.iterator();
	//	Set visited = new ArraySet();
		List<Object> reachable = new  ArrayList<Object>();
		reachable.addAll(multiCalledMethods);
	    while(reachable.size()>=1)
	    {
	    	Object  popped  = reachable.remove(0);
	    	if(visited.contains(popped))  continue;
	    	if (!multiCalledMethods.contains(popped))  multiCalledMethods.add(popped);
	    	visited.add(popped);
	    	Iterator succIt = pcg.getSuccsOf(popped).iterator();
		    while (succIt.hasNext()){
		    	Object succ  = succIt.next();
		    	reachable.add(succ);
			
		    }
	    }
		
		
//		while (it.hasNext()){
//			Object obj = it.next();
//			if (!visited.contains(obj)){
//				dfsVisit(obj, pcg);
//			}
////			Iterator succIt = pcg.getSuccsOf(obj).iterator();
////			while (succIt.hasNext()){
////				if (!visited.contains(obj)){
////					dfsVisit(obj, pcg);
////				}
////			}
//		}
	}
//	private void dfsVisit(Object obj, PegCallGraph pcg){
//		visited.add(obj);
//		if (!multiCalledMethods.contains(obj))  multiCalledMethods.add(obj);
//		Iterator succIt = pcg.getSuccsOf(obj).iterator();
//		while (succIt.hasNext()){
//			Object succ  = succIt.next();
//			if (!visited.contains(succ)){
//			dfsVisit(succ, pcg);
//		}	
//			
////			if (!visited.contains(obj)){
////				dfsVisit(obj, pcg);
////			}
//		}
//	}
	
	//Use breadth first search to find methods are called more than once in call graph
	private void finder1(PegCallGraph pcg){
		Set clinitMethods = pcg.getClinitMethods();    
		Iterator it = pcg.iterator();
		while (it.hasNext()){
			Object head = it.next();
			//breadth first scan
			Set<Object> gray = new HashSet<Object>();
			LinkedList<Object> queue = new LinkedList<Object>();
			queue.add(head);
			
			while (queue.size()>0){
				Object root = queue.getFirst();
				
				Iterator succsIt = pcg.getSuccsOf(root).iterator();
				while (succsIt.hasNext()){
					Object succ = succsIt.next();
					
					if (!gray.contains(succ)){
						gray.add(succ);
						queue.addLast(succ);
					}
					else if(clinitMethods.contains(succ))  continue;
					else{
						multiCalledMethods.add(succ);
					}
				}
				queue.remove(root);
			}
			
		}
		
	}
	
	//Find multi called methods relavant to recusive method invocation
	private void finder2(PegCallGraph pcg){
		
		pcg.trim();
		Set<Object> first = new HashSet<Object>();
		Set<Object> second = new HashSet<Object>();
		// Visit each node
		Iterator it = pcg.iterator();
		while (it.hasNext()){
			Object s =it.next();
			
			if (!second.contains(s)){
				
				visitNode(s, pcg, first, second);
			}
		}
		
		
	}
	
	private void visitNode(Object node, PegCallGraph pcg, Set<Object> first, Set<Object> second){
		if (first.contains(node)){
			second.add(node);
			if (!multiCalledMethods.contains(node)){
				multiCalledMethods.add(node);
			}
		}
		else	first.add(node);
		
		Iterator it = pcg.getTrimSuccsOf(node).iterator();
		while (it.hasNext()){
			Object succ = it.next();
			if (!second.contains(succ)){
				visitNode(succ, pcg, first, second);
			}
		}
	}
	
	public Set<Object> getMultiCalledMethods(){
		return multiCalledMethods;
	}
	
}
