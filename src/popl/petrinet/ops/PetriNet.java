package popl.petrinet.ops;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


import org.jgrapht.EdgeFactory;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import popl.petrinet.element.EntryPlace;
import popl.petrinet.element.ExitPlace;
import popl.petrinet.element.Place;
import popl.petrinet.element.Transition;

import com.sun.org.apache.bcel.internal.generic.NEW;

import AVdetect.edge.abstractclass.CausalEdge;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import Jama.Matrix;

import soot.SootMethod;
import soot.Unit;
import soot.JastAddJ.ThisAccess;
import soot.toolkits.graph.UnitGraph;

public class PetriNet<V, E> extends DirectedPseudograph<V, E>{
// unit2place, start/end, edges
    private  HashMap<Object, Place> unit2place = new HashMap<Object, Place>();
    public Place getPlace4Unit(Object unit) {
		// TODO Auto-generated method stub
		return unit2place.get(unit);
	}
    public void registerPlace4Unit(Object unit, Place o)
    {
    	unit2place.put(unit, o);	
    }
    public void mergeUnit2Place(PetriNet petriPara)
    {
    	unit2place.putAll(petriPara.unit2place);
    }
    
    public EntryPlace start = null;
    public ExitPlace end = null;
	public EntryPlace getStart() {
		return start;
	}

	public void setStart(EntryPlace start) {
		this.start = start;
	}

	public ExitPlace getEnd() {
		return end;
	}

	public void setEnd(ExitPlace end) {
		this.end = end;
	}

	public PetriNet(Class edgeClass) {
		super(edgeClass);
		// TODO Auto-generated constructor stub
	}

	public PetriNet(EdgeFactory ef) {
		super(ef);
		// TODO Auto-generated constructor stub
	}
    public List places = new ArrayList();
    public List transitions = new ArrayList();
    
    public void addN2N(V x, V y)
    {
    	if(x instanceof Place && y instanceof Transition)
    	{
    		addP2T(x, y);
    		return;
    	}
    	if(x instanceof Transition && y instanceof Place)
    	{
    		addT2P(x, y);
    		return;
    	}
    	throw new RuntimeException("what else?");
//    	/System.err.println(x.getClass().toString() + y.getClass().toString());
    	
    }
    public void addP2T(V p, V t)
    {
    	if(p ==null || t ==null) throw new RuntimeException("null?");
    	if(!this.containsVertex(p))
    	{
    	  this.addVertex(p);
    	  places.add(p);
    	}
    	if(!this.containsVertex(t))
    	{
    		this.addVertex(t);
    		transitions.add(t);
    	}
    	if(!this.containsEdge(p, t))
    	{
    		
    		DefaultEdge  e =(DefaultEdge) this.addEdge_edgetype_lpxz(p, t, DefaultEdge.class);  	
    		
    	}    	
    }
    
    public void addT2P(V t, V p)
    {
    	if(p ==null || t ==null) throw new RuntimeException("null?");
    	if(!this.containsVertex(t))
    	{
    		this.addVertex(t);
    		transitions.add(t);
    	}
    	if(!this.containsVertex(p))
    	{
    	  this.addVertex(p);
    	  places.add(p);
    	}
    	if(!this.containsEdge(t, p))
    	{
    		
    		DefaultEdge e = (DefaultEdge)this.addEdge_edgetype_lpxz(t, p, DefaultEdge.class);  	
    		
    		
    	}     	
    }
    
    
	DOTExporter<V, PetriNet> dotEx = new DOTExporter<V, PetriNet>();
    public void export4PetriNet(String filename) {

		File file = new File(filename);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			DirectedPseudograph graph  = this;
			dotEx.export4PetriNet(fw, graph);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public Matrix toMatrix()
    {
    	Matrix toret = new Matrix(places.size(), transitions.size());
    	for(int i=0; i< transitions.size(); i++)
    	{
    		V t = (V) transitions.get(i);
    		Set<V> inputs =inputNodes(t);
    		Set<V> outputs = outputNodes(t);
    		for(V input : inputs)
    		{
    			int inputIndex =places.indexOf(input);
    		    toret.set(inputIndex, i, -1);
    		}
    		for(V output : outputs)
    		{
    			int outputIndex =places.indexOf(output);
    		    toret.set(outputIndex, i, 1);
    		}
    		
    	}  
    	return toret;
    }
    
    
    public Set<V> inputNodes(V node)
    {
    	Set<V> inputs = new HashSet<V>();
    	Set<DefaultEdge> edges = (Set<DefaultEdge>) this.incomingEdgesOf(node);
    	for(DefaultEdge e : edges)
    	{
    		inputs.add((V)e.getSource());
    	}
    	return inputs;
    	
    }
    public Set<V> outputNodes(V node)
    {
    	Set<V> outputs = new HashSet<V>();
    	Set<DefaultEdge> edges = (Set<DefaultEdge>) this.outgoingEdgesOf(node);
    	for(DefaultEdge e : edges)
    	{
    		//System.out.println(e.toString());
    		outputs.add((V)e.getTarget());
    	}
    	return outputs;    	
    }
    
    
    
    
	public static void main(String[] args) {
		
		
		
		
		
		

	}

	

}
