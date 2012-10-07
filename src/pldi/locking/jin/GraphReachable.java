package pldi.locking.jin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import soot.toolkits.graph.DirectedGraph;


public class GraphReachable {

	public static Stack systemStack = new Stack();
    public static Set visited = new HashSet();   

	private static Set reachable(DirectedGraph ug, Object unit) {
    	Set toretSet = new HashSet();
        systemStack.clear();
        visited.clear();
		systemStack.push(unit);	
    	if(!visited.contains(unit))
    	{
    	    visited.add(unit);
    	}
	
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();			    
		    List children = ug.getSuccsOf(pop);
		    for(int i = children.size()-1; i>=0; i--)
		    {
		    	Object child = children.get(i);	
  	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}
		toretSet.addAll(visited);
		return toretSet;
	}
    
    private static Set back_reachable(DirectedGraph ug, Object unit) {
    	Set toretSet = new HashSet();
        systemStack.clear();
        visited.clear();
		systemStack.push(unit);	
    	if(!visited.contains(unit))
    	{
    	    visited.add(unit);
    	}
	
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();			    
		    List children = getSuccsOnReversedGraph(ug,pop);//ug.getSuccsOf(pop);
		    for(int i = children.size()-1; i>=0; i--)
		    {
		    	Object child = children.get(i);	
		    	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}
		toretSet.addAll(visited);
		return toretSet;
	}
    
	private static List getSuccsOnReversedGraph(DirectedGraph ug, Object pop) {		
		return ug.getPredsOf(pop);
	}
	
	
	private static Set reachable_no_cross(DirectedGraph ug, Object unit, Object bound) {
    	Set toretSet = new HashSet();
        systemStack.clear();
        visited.clear();
		systemStack.push(unit);	
    	if(!visited.contains(unit))
    	{
    	    visited.add(unit);
    	}
	
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();			    
		    List children = getSuccs_awareof_bound(ug, pop, bound);//ug.getSuccsOf(pop);
		    for(int i = children.size()-1; i>=0; i--)
		    {
		    	Object child = children.get(i);	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}
		toretSet.addAll(visited);
		return toretSet;
	}
	

	public static List emptyList = new ArrayList();
	private static List getSuccs_awareof_bound(DirectedGraph ug, Object pop,
			Object bound) {
		if(pop!=bound)
			return ug.getSuccsOf(pop);
		else
			return emptyList;
	}

	
	private static Set back_reachable_no_cross(DirectedGraph ug, Object unit, Object bound) {
    	Set toretSet = new HashSet();
        systemStack.clear();
        visited.clear();
		systemStack.push(unit);	
    	if(!visited.contains(unit))
    	{
    	    visited.add(unit);
    	}
	
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();			    
		    List children = getSuccs_onReversedGraph_awareof_bound(ug, pop, bound);//ug.getSuccsOf(pop);
		    for(int i = children.size()-1; i>=0; i--)
		    {
		    	Object child = children.get(i);	
		    	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}
		toretSet.addAll(visited);
		return toretSet;
	}
	
	private static List getSuccs_onReversedGraph_awareof_bound(
			DirectedGraph ug, Object pop, Object bound) {
		if(pop!=bound)
			return ug.getPredsOf(pop);
		else
			return emptyList;
	}
	
	
	public static Set  intersect(List list1, List list2)
	{
		Set ret= new HashSet();
		for(Object o  : list1)
		{
			if (list2.contains(o))
			{
				ret.add(o);
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
