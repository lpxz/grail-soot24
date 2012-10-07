package popl.petrinet.ops;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.graph.DefaultEdge;

import popl.petrinet.element.EntryPlace;
import popl.petrinet.element.Node;
import popl.petrinet.element.Place;
import soot.toolkits.graph.DirectedGraph;

public class PetriNetTraversal {

	public static Stack systemStack = new Stack();
    public static Set visited = new HashSet();
    

    
    public static void traverseNode(PetriNet petri) {
    	systemStack.clear();
    	visited.clear();
    	EntryPlace start= petri.getStart();
		systemStack.push(start);	
		if(!visited.contains(start))
    	{
    	    visited.add(start);
    	}
	//	Place startPlace = createOrgetPlace(unit);
		
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();	
		
		    
		    Set children = petri.outputNodes(pop);//.getSuccsOf(pop);
		    for(Object child:children)
		    {	    		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}					
	}
    public static int edgecount =0;
    public static void traverseEdge(PetriNet petri) {
    	systemStack.clear();
    	visited.clear();
    	EntryPlace start= petri.getStart();
		systemStack.push(start);	
		if(!visited.contains(start))
    	{
    	    visited.add(start);
    	}
	//	Place startPlace = createOrgetPlace(unit);
		
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();	
		
		    
		    Set children = petri.outputNodes(pop);//.getSuccsOf(pop);
		    for(Object child:children)
		    {	    	
		    	edgecount++;
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}					
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void mergeToByTraversal(PetriNet petriTmp,
			PetriNet<Node, DefaultEdge> petribig) {

    	systemStack.clear();
    	visited.clear();
    	EntryPlace start= petriTmp.getStart();
		systemStack.push(start);	
		if(!visited.contains(start))
    	{
    	    visited.add(start);
    	}
	//	Place startPlace = createOrgetPlace(unit);
		
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();	
		
		    
		    Set children = petriTmp.outputNodes(pop);//.getSuccsOf(pop);
		    for(Object child:children)
		    {	    	
		    	petribig.addN2N((Node)pop, (Node) child);  	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}					
	
		
		
		
	}

}
