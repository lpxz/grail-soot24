package aTSE.AHG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import soot.PointsToSet;
import soot.jimple.spark.sets.PointsToSetInternal;

public class AHGAction {

	/**
	 * @param args
	 */
	String methodname  ="";
	List argList  = new  ArrayList();
	//highlightFields
//	public static String nothing_node = "donothing_nodebased";
//	public static String nothing = "donothing";
	// I suggest not to use such summary, people can look at their implementations for detials.
	
	
	public void highlightFields(DirectedPseudograph<String, DefaultEdge>  toDrawG, Stack<DefaultEdge> stack )
	{
		DefaultEdge edge = stack.peek();
		PointsToSet parentSet = (PointsToSet)edge.getSource();
		PointsToSet currSet = (PointsToSet)edge.getTarget();
		String edgeName = edge.getLabel();// already set, do nto worry
		
		if(parentSet instanceof PointsToSetInternal && currSet instanceof PointsToSetInternal)
		{
			String parentName = ""+ ((PointsToSetInternal)parentSet).pointsToSetHashCode();
			String currName =""+ ((PointsToSetInternal)currSet).pointsToSetHashCode();
			
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
			labelE.setLabel(DOTExporter.xxxmarker +edgeName);
			
			toDrawG.addEdge(parentName, currName, labelE);
		}
		else {
			throw new RuntimeException("nto pointtosetInternal impl!");
		}
		
	}
	
	
	
	public void drawEdgeInG(DirectedPseudograph<String, DefaultEdge>  toDrawG, Stack<DefaultEdge> stack )
	{
		DefaultEdge edge = stack.peek();
		PointsToSet parentSet = (PointsToSet)edge.getSource();
		PointsToSet currSet = (PointsToSet)edge.getTarget();
		String edgeName = edge.getLabel();// already set, do nto worry
		
		if(parentSet instanceof PointsToSetInternal && currSet instanceof PointsToSetInternal)
		{
			String parentName = ""+ ((PointsToSetInternal)parentSet).pointsToSetHashCode();
			String currName =""+ ((PointsToSetInternal)currSet).pointsToSetHashCode();
			
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
		else {
			throw new RuntimeException("nto pointtosetInternal impl!");
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void addTarget2Set(Set  hitSet, Stack<DefaultEdge> stack)
	{
		DefaultEdge edge  = stack.peek();
		hitSet.add(edge.getTarget());		
	}
	//donothing
	public void donothing( Stack<DefaultEdge> stack)
	{
		
	}
	
	public void donothing_nodebased( PointsToSet root)
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
