package aTSE.CG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import pldi.locking.SynchronizedRegionFinder;
import pldi.locking.SynchronizedRegionFlowPair;

import soot.Body;
import soot.PatchingChain;
import soot.PointsToSet;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.callgraph.Edge;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class CGAction {

	private static final boolean optionOpenNesting = false;
	/**
	 * @param args
	 */
	String methodname  ="";
	List argList  = new  ArrayList();
	//highlightFields
//	public static String nothing_node = "donothing_nodebased";
//	public static String nothing = "donothing";
	// I suggest not to use such summary, people can look at their implementations for detials.
	
	
	public void highlightFields(DirectedPseudograph<String, DefaultEdge>  toDrawG, Stack<Edge> stack )
	{
		Edge edge = stack.peek();
		SootMethod parentMethod = (SootMethod)edge.getSrc();
		SootMethod currMethod = (SootMethod)edge.getTgt();
		String edgeName = getEdgeLabel(edge) ;// already set, do nto worry
		
		
			String parentName = parentMethod.getName();
			String currName =currMethod.getName();
			
			if(!toDrawG.containsVertex(parentName))
			{
				toDrawG.addVertex(parentName);
				
			}
			if(!toDrawG.containsVertex(currName))
			{
				toDrawG.addVertex(currName);
			}
		//	if(toBuildG.con)
			DefaultEdge labelE = new DefaultEdge();
			labelE.setLabel(DOTExporter.xxxmarker+edgeName);
			toDrawG.addEdge(parentName, currName, labelE);
		
		
		
	}
	
	
	
	public void drawEdgeInG(DirectedPseudograph<String, DefaultEdge>  toDrawG, Stack<Edge> stack )
	{
		Edge edge = stack.peek();
		SootMethod parentMethod = (SootMethod)edge.getSrc();
		SootMethod currMethod = (SootMethod)edge.getTgt();
		
			
		String edgeName = getEdgeLabel(edge) ;// already set, do nto worry
		
		
			String parentName = parentMethod.getName();
			String currName =currMethod.getName();
			
			if(!toDrawG.containsVertex(parentName))
			{
				toDrawG.addVertex(parentName);
				
			}
			if(!toDrawG.containsVertex(currName))
			{
				toDrawG.addVertex(currName);
			}
		//	if(toBuildG.con)
			DefaultEdge labelE = new DefaultEdge();
			labelE.setLabel(edgeName);
			toDrawG.addEdge(parentName, currName, labelE);
		
		
		
	}
	
	
	private static String getEdgeLabel(Edge edge) {// you can change
		return edge.kind().name();
//		String toret  = "";
//		try {
//			toret= edge.srcStmt().toString();
//		} catch (Exception e) {
//			toret = edge.kind().name();
//		}
//		return toret;
	}
	
	public void collect_syncBM_nodebased( Set set , SootMethod root )
	{
		if(!isInteresting(root)) return;
		if(root.isSynchronized())
		{
			set.add(root);
		}
		set.addAll(getSyncB_TNs(root));	
		
	}
	public void storeNestedSync( Set set , Stack<Edge> stack )
	{
//		 Stack<Edge> copyStack = (Stack<Edge>) stack.clone();// it is too long.
//		 set.add(copyStack);
		// re-compute the criteria and collect the partial information based on it.
         int  nested =0;
         Stack shortStack = new Stack();// may contains method or edge
		
		for(int i=0;i< stack.size();i++)
		{
		   Edge e=	stack.get(i);
		   SootMethod srcM = (SootMethod)e.getSrc();
		   SootMethod tgtM = (SootMethod)e.getTgt();
		   if(!isInteresting(tgtM)) 
		   {continue;}
		   
		   
		   Unit srcU = e.srcUnit();
		   
		   Set syncBM =  getSynBM_units(srcM);// if the method is syncrhonzied,  returns the whole body
		   if(syncBM.contains(srcU))
		   {
			   nested ++;
			   shortStack.push(e);
		   }
		   
		}
		
		//============= the last callee
		Edge elast = stack.peek();
		SootMethod mlast = (SootMethod)elast.getTgt();
		
		if(isInteresting(mlast) && getSynBM_units(mlast).size()!=0) 
		{
			nested++;
			shortStack.push(mlast);
		}
		
		//===============
		if(nested >= 2)
		{
			set.add(shortStack);
		}
		

		
		
		
	}
	
	private Set getSynBM_units(SootMethod srcM) {
		//throw new RuntimeException();
	Set toret = new HashSet<Unit>();
	if(srcM.isSynchronized())
	{
		 try {
			 PatchingChain<Unit> units =srcM.getActiveBody().getUnits();
			 toret.addAll(units);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	else { // may be SB
		Set toret0= getSyncB_units(srcM);
		toret.addAll(toret0);
		
		
	}
	return toret;
	
	
	}
	private Set getSyncB_units(SootMethod sm) {
		Set toret = new HashSet<Unit>();
		if(!sm.hasActiveBody())
		{
			return toret;
		}
		else {
            Body b = sm.getActiveBody();            
	    	ExceptionalUnitGraph eug = new ExceptionalUnitGraph(b);
			SynchronizedRegionFinder ta = new SynchronizedRegionFinder(eug, b,  optionOpenNesting);			
			Chain units = b.getUnits();
			Unit lastUnit = (Unit) units.getLast();
			FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
			if(fs!=null)
			{
				
			    for (Iterator iterator = fs.iterator(); iterator
						.hasNext();) {
			    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
			    	HashSet<Unit> us =srfp.tn.units;
			    	toret.addAll(us);
//			    	System.out.println("==============\n tn units (no order)");
//					for (Iterator iterator2 = us.iterator(); iterator2
//							.hasNext();) {
//						Unit unit = (Unit) iterator2.next();
//						System.out.println(unit);
//						
//					}
//					System.out.println("==============\n");
			    	
					
				}
			}

			
		}

		
		
	return toret;
}
	
	private Set getSyncB_TNs(SootMethod sm) {
		Set toret = new HashSet();
		if(!sm.hasActiveBody())
		{
			return toret;
		}
		else {
            Body b = sm.getActiveBody();            
	    	ExceptionalUnitGraph eug = new ExceptionalUnitGraph(b);
			SynchronizedRegionFinder ta = new SynchronizedRegionFinder(eug, b,  optionOpenNesting);			
			Chain units = b.getUnits();
			Unit lastUnit = (Unit) units.getLast();
			FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
			if(fs!=null)
			{
				
			    for (Iterator iterator = fs.iterator(); iterator
						.hasNext();) {
			    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
			    	toret.add(srfp.tn);
//			    	System.out.println("==============\n tn units (no order)");
//					for (Iterator iterator2 = us.iterator(); iterator2
//							.hasNext();) {
//						Unit unit = (Unit) iterator2.next();
//						System.out.println(unit);
//						
//					}
//					System.out.println("==============\n");
			    	
					
				}
			}

			
		}

		
		
	return toret;
}
	private boolean isInteresting(SootMethod currMethod) {
		if(!currMethod.getDeclaringClass().isApplicationClass())  return false;
		if(currMethod.isAbstract()) return  false;
		if(currMethod.isNative()) return false;
		if(currMethod.getName().equals(SootMethod.constructorName)) 
			{
			return false;
			}

			
		if(currMethod.getName().equals(SootMethod.staticInitializerName)) return false;
		
		
		return true;
	}
	

	@SuppressWarnings("unchecked")
	public void addTarget2Set(Set  hitSet, Stack<Edge> stack)
	{
		Edge edge  = stack.peek();
		hitSet.add((SootMethod)edge.getTgt());		
	}
	//donothing
	public void donothing( Stack<Edge> stack)
	{
		
	}
	
	public void donothing_nodebased( SootMethod root)
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
