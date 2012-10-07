package aTSE.aTSE.OG;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import com.touchgraph.graphlayout.interaction.RotateScroll;

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


public class OGAction {

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
	
	

	
	public void highlightEdgeInG(DirectedPseudograph<String, DefaultEdge>  toDrawG, Stack  stack, Object src, Object tgt )
	{
		Object oedge = stack.peek();
		String edgeName = getEdgeLabel(oedge) ;// already set, do nto worry		
			String parentName = getOName(src);  
			String currName =  getOName(tgt);
			
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
			labelE.setLabel(DOTExporter.xxxmarker + edgeName);
			toDrawG.addEdge(parentName, currName, labelE);		
	}
	
	
	public void drawEdgeInG(DirectedPseudograph<String, DefaultEdge>  toDrawG, Stack  stack, Object src, Object tgt )
	{
		Object oedge = stack.peek();
		String edgeName = getEdgeLabel(oedge) ;// already set, do nto worry		
			String parentName = getOName(src);  
			String currName =  getOName(tgt);
			
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
	public static String getOName(Object root)
	{
		if(root==null) return "null";		
		return root.getClass().getSimpleName()+ root.hashCode();
		
	}
	
	public static String getEdgeLabel(Object edge) {// you can change
		if(edge instanceof Field)
		{
			return ((Field) edge).getName();
		}
		else {
			if(!OGTraverse.FullArray)
			{
				return OGTraverse.ARRAYFIELD;
			}
			else {
				return ((Integer) edge).toString();
			}
			
		}
		
//		String toret  = "";
//		try {
//			toret= edge.srcStmt().toString();
//		} catch (Exception e) {
//			toret = edge.kind().name();
//		}
//		return toret;
	}
	




	public boolean isInteresting(Object root) {
		return true;
	}
	


	//donothing
	public void donothing( Stack stack, Object source, Object target)
	{
		
	}
	//set2null
	public void set2null( Stack stack, Object source, Object target) throws IllegalArgumentException, IllegalAccessException
	{
		Object top = stack.peek();
		if(top instanceof Field)
		{
			Field edge = (Field) top;
			edge.setAccessible(true);
			edge.set(source, null);
		}
		else {
			Integer i = (Integer) top;// if FullArray=false, all elements obey the pattern of the element at the first index
			Array.set(source, i.intValue(), null);
		}
		OGTraverse.childset2null=true;
	}
	public void donothing_nodebased( Object root)
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
