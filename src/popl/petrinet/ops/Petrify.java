package popl.petrinet.ops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.graph.DefaultEdge;



import popl.petrinet.element.EntryPlace;
import popl.petrinet.element.ExitPlace;
import popl.petrinet.element.Node;
import popl.petrinet.element.Place;
import popl.petrinet.element.Transition;

import soot.Body;
import soot.SootMethod;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ZonedBlockGraph;

public class Petrify {
	static boolean unitgraph =true;
	public static HashMap<SootMethod, PetriNet> cache = new HashMap<SootMethod, PetriNet>();
	public static PetriNet<Node, DefaultEdge> formOrgetPetriNet(SootMethod sm )
    {
		if(!sm.hasActiveBody()) 
			throw new RuntimeException("how to gen a petri net for you? you do not have a concrete body");
		
		
		if(cache.get(sm)!=null) 
			return cache.get(sm);
		
		PetriNet<Node, DefaultEdge> petri = new PetriNet<Node, DefaultEdge>(DefaultEdge.class);
		cache.put(sm, petri);
		Body bb = sm.getActiveBody();	
		DirectedGraph ug= null;
		if(unitgraph)
		{
			 ug = new BriefUnitGraph(bb);	
		}
		else {
			ug = new ZonedBlockGraph(bb);// it is just blockCFG...
		}	

		
		
		
    	
    	List headsList = ug.getHeads();	  
    	List tails = ug.getTails();
    	EntryPlace start = createOrgetEntryPlace( petri);
    	ExitPlace end = createOrgetExitPlace(petri);    	
    	
    	petrifyN2Ns(petri, start, headsList);
    	petrifyNs2N(petri, tails, end);     
    	
    	for(Object unit : headsList)
    	{
    		 formPetriNet0(ug, unit, petri); // form the main part of the petri net
    	}
    	
   	
    	
    	return petri;
    }
	
	
    private static void petrifyNs2N(PetriNet<Node, DefaultEdge> petri,
			List tails, Place end) {
    	for(Object unit : tails)
    	{
    		Place p = createOrgetPlace(unit, petri);
    		Transition t = new Transition();
    		petri.addP2T(p, t);
    		petri.addT2P(t, end);
    	}
	}


	private static void petrifyN2Ns(PetriNet<Node, DefaultEdge> petri,
			Place start, List headsList) {
    	for(Object unit : headsList)// form the single entry part
    	{
    		Place p = createOrgetPlace(unit, petri);
    		Transition t = new Transition();
    		petri.addP2T(start, t);
    		petri.addT2P(t, p);
    	}
		
	}


	public static Stack systemStack = new Stack();
    public static Set visited = new HashSet();
    

    
    private static void formPetriNet0(DirectedGraph ug, Object unit, PetriNet petri) {
        systemStack.clear();
        visited.clear();
		systemStack.push(unit);	
    	if(!visited.contains(unit))
    	{
    	    visited.add(unit);
    	}
	//	Place startPlace = createOrgetPlace(unit);
		
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();	
		
		    
		    List children = ug.getSuccsOf(pop);
		    for(int i = children.size()-1; i>=0; i--)
		    {
		    	Object child = children.get(i);			    	
		    	Place parentnode = createOrgetPlace(pop, petri);
		    	Place childnode = createOrgetPlace(child, petri);
		    	petrifyN2N(petri, parentnode, childnode);
		    	
		    	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}					
	}
    
    private static void petrifyN2N(PetriNet petri, Place parentnode, Place childnode) {
    	Transition t = new Transition();
    	petri.addP2T(parentnode, t);
    	petri.addT2P(t, childnode);
		
	}

	private static Place createOrgetPlace(Object unit, PetriNet petri) {
	    Place o =(Place) petri.getPlace4Unit(unit);// unit2place.get(unit);
	    if(o == null)
	    {
			 o = new Place();
			o.setEntity(unit);
			petri.registerPlace4Unit(unit, o);//unit2place.put(unit, o);
	    }
	    return o;
	    
	}
    
    private static EntryPlace createOrgetEntryPlace( PetriNet petri) {
    	if(petri.getStart()==null)
    	{
    		EntryPlace start = new EntryPlace();
    		petri.setStart(start);
    	}
	    return petri.getStart();
	    
	}
    
    private static ExitPlace createOrgetExitPlace( PetriNet petri) {
    	if(petri.getEnd()==null)
    	{
    		ExitPlace end= new ExitPlace();
    		petri.setEnd(end);
    	}
    	return petri.getEnd();
	}
    
    public static PetriNet<Node, DefaultEdge> wrapAsThreadedPetriNet(List<PetriNet> petris)
    {
    	PetriNet<Node, DefaultEdge> petribig = new PetriNet<Node, DefaultEdge>(DefaultEdge.class);
    	EntryPlace entrybig =createOrgetEntryPlace(petribig);
    	ExitPlace exitbig = createOrgetExitPlace(petribig);
    	Transition entryT = new Transition();
    	Transition exitT = new Transition();
    	
    	for(PetriNet petriTmp : petris)
    	{
    		
    		EntryPlace entryTmp = petriTmp.getStart();
    		ExitPlace exitTmp = petriTmp.getEnd();
    		petribig.addP2T(entrybig, entryT);
    		petribig.addT2P(entryT, entryTmp);
    		
    		petribig.addP2T(exitTmp, exitT);
    		petribig.addT2P(exitT, exitbig); 
    		//merge priocess!
    		mergeTo(petriTmp, petribig);
    		
    	}
    	
    	
    	return petribig;
    	
    }
    
    private static void mergeTo(PetriNet petriTmp,
			PetriNet<Node, DefaultEdge> petribig) {
		// unit2Places. edges.
    	PetriNetTraversal.mergeToByTraversal(petriTmp, petribig);
    	petribig.mergeUnit2Place(petriTmp);
		
	}


	public static PetriNet<Node, DefaultEdge> methods2ThreadedPetrinet(List<SootMethod> sms)
    {
    	List<PetriNet> petris = new ArrayList<PetriNet>();
    	for(SootMethod sm : sms)
    	{
    		PetriNet tmp = formOrgetPetriNet(sm);
    		petris.add(tmp);
    	}
    	return wrapAsThreadedPetriNet(petris);
    }
//    
}
