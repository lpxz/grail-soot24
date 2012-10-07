/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Creator:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
/* ----------------
 * Pseudograph.java
 * ----------------
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   Christian Hammer
 *
 * $Id: Pseudograph.java,v 1.1 2009/10/22 15:10:01 charlesz Exp $
 *
 * Changes
 * -------
 * 05-Aug-2003 : Initial revision (BN);
 * 11-Mar-2004 : Made generic (CH);
 * 28-May-2006 : Moved connectivity info from edge to graph (JVS);
 *
 */
package org.jgrapht.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.*;
import org.jgrapht.alg.ConnectivityInspector;

import soot.RefType;
import soot.Type;
import soot.JastAddJ.ThisAccess;
import soot.jimple.spark.pag.AllocNode;



/**
 * A Bipartitie graph. A Bipartitie is a non-simple undirected graph in which both
 * graph loops and multiple edges are permitted. and also we have X, Y domain, have checkings before the adding of edges
 * have filters after the weakly connected component is built </a>.
 */
public class BiPartitegraph<V, E>
   extends AbstractBaseGraph<V, E>
   implements UndirectedGraph<V, E> 
 
{
    //~ Static fields/initializers ---------------------------------------------
     
	 public HashSet<V> X=null; 
	 public HashSet<V> Y = null;
	 public List<Set<V>> weaklyCompsOnX_cache =null;
	 public List<Set<V>> weaklyCompsOnY_cache =null;
	 public HashSet<V> getX()
	 {
		 return X;
	 }
	 public HashSet<V> getY()
	 {
		 return Y;
	 }
 	 
	 
    private static final long serialVersionUID = 3833183614484755253L;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new pseudograph.
     *
     * @param edgeClass class on which to base factory for edges
     */
    public BiPartitegraph(Class<? extends E> edgeClass)
    {
        this(new ClassBasedEdgeFactory<V, E>(edgeClass));
        X= new HashSet<V>();
        Y= new HashSet<V>();
        
    }

    /**
     * Creates a new pseudograph with the specified edge factory.
     *
     * @param ef the edge factory of the new graph.
     */
    private BiPartitegraph(EdgeFactory<V, E> ef)
    {
        super(ef, true, true);// allow loop, multiple edges between a pair
    }
    
    //self-maintained discipline: left para is in X, right parameter is in Y
    public E addEdge(V sourceVertex, V targetVertex)
    {
    	boolean illegalBipartite = (X.contains(sourceVertex)&&X.contains(targetVertex))
    	                            ||(Y.contains(sourceVertex)&&Y.contains(targetVertex));
    	if(illegalBipartite) 
    	{
    		try {
				throw new IllegalBipartiteException();// ugly because the method declaration compatibility problem
			} catch (IllegalBipartiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    		
    	X.add(sourceVertex);
    	Y.add(targetVertex); // register
    	//to circumstance the stupid but safe adding of vertices.
//    	super.addVertex(sourceVertex); //you need to tell, especially for those single-connected nodes
//    	super.addVertex(targetVertex);
    	return super.addEdge(sourceVertex, targetVertex);
    }
    
    public List<Set<V>> weaklyConnectedComponents()
    {
		ConnectivityInspector cI= new ConnectivityInspector( this);
		List<Set<V>>  WCCs = cI.lazyFindConnectedSets();
		return WCCs;
    }
    public  List<Set<V>> weaklyConnectedComponentsOnX()
    {
    	if(this.weaklyCompsOnX_cache!=null) return weaklyCompsOnX_cache;
    	// compute only for once
    	List<Set<V>>  WCCs = this.weaklyConnectedComponents();
    	List<Set<V>>  projectedWCCs = new ArrayList<Set<V>>();
    	for(int i=0;i<WCCs.size();i++)
    	{
    		Set<V> wcc= WCCs.get(i);
    		Set<V> projectedWCC= setProjection(wcc, X);
    		if(projectedWCC.size()==0) continue;// trivial set
    		projectedWCCs.add(projectedWCC);    		
    	}
    	weaklyCompsOnX_cache= projectedWCCs;
    	return weaklyCompsOnX_cache;
    }
    public  List<Set<V>> weaklyConnectedComponentsOnY()
    {
    	if(weaklyCompsOnY_cache!=null) return weaklyCompsOnY_cache;
    	List<Set<V>>  WCCs = this.weaklyConnectedComponents();
    	List<Set<V>>  projectedWCCs = new ArrayList<Set<V>>();
    	for(int i=0;i<WCCs.size();i++)
    	{
    		Set<V> wcc= WCCs.get(i);
    		Set<V> projectedWCC= setProjection(wcc, Y);
    		if(projectedWCC.size()==0) continue;// do not add it. trivial set
    		projectedWCCs.add(projectedWCC);    		
    	}
    	weaklyCompsOnY_cache= projectedWCCs;
    	return weaklyCompsOnY_cache;
    	
    }
    public Set<V> setProjection(Set<V> origSet, Set<V> projectToSet)
    {
    	Set<V> ret = new HashSet<V>();
    	Iterator<V> it = origSet.iterator();
    	while (it.hasNext()) {
			V v = (V) it.next();
			if(projectToSet.contains(v))
			{
//				if(v instanceof soot.jimple.spark.pag.AllocNode)
//				{
//					Type type = ((AllocNode)v).getType();
//					if(type instanceof RefType)
//					{
//						RefType refType =(RefType)type;
//						if(refType.getSootClass().isApplicationClass())// I am not interested in the lib node
//					    {
//					    	ret.add(v);
//					    }
//					}
//				    
//				}
//				else {
					ret.add(v);
//				}
				
			}
		}
    	return ret;
    }
    
    public static BiPartitegraph toyGraph()
    {
    	BiPartitegraph<Object,DefaultEdge>  biPartite = new BiPartitegraph<Object,DefaultEdge>(DefaultEdge.class);
		// this package is kind of stupid, or safe in another word.
    	// needs my insertion of nodes..
        biPartite.addVertex("a");
        biPartite.addVertex("b");
        biPartite.addVertex("c");
        biPartite.addVertex("d");
        biPartite.addVertex("anode1");
        biPartite.addVertex("anode2");
        biPartite.addVertex("anode3");
        
        
    	biPartite.addEdge("a", "anode1");
		biPartite.addEdge("a", "anode2");
		biPartite.addEdge("b", "anode2");
		biPartite.addEdge("c", "anode2");
		
		biPartite.addEdge("d", "anode3");
		return biPartite;
    }
    public static void main(String[] args)
    {
    	//test drivers
    	BiPartitegraph biPartite = toyGraph();
        List c =biPartite.weaklyConnectedComponents();
			
    }
    
}
class IllegalBipartiteException extends Exception
{

	private static final long serialVersionUID = 1L;
}

// End Pseudograph.java
