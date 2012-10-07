package soot.jimple.toolkits.thread.synchronizationLP.DataView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.Test;

import org.jgrapht.graph.BiPartitegraph;
import org.jgrapht.graph.DefaultEdge;

import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.SootClass;
import soot.JastAddJ.ThisAccess;
import soot.jbco.jimpleTransformations.CollectConstants;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.thread.synchronization.LockableReferenceAnalysis;
import soot.jimple.toolkits.visitor.dataview.VisitorForRelativeGroup;
import soot.jimple.toolkits.visitor.dataview.VisitorForRelativeGroup.LPFakeClassNode;

import Drivers.RelativeBiPartiteCrawler;
// totally no test, test!!!!!!!!!!!!
//issues: 1 avoid repetition for ClassNode-> Group mapping
// 2 on-the-demand collection of group Domain!
public class RelativeDataGrouping implements DataGrouping {
	public static PointsToAnalysis p2A= Scene.v().getPointsToAnalysis();
	
	
	public Set<Set<Object>> groupDomain = null;// hashSet domain, I do not want to, but have to
	public  Map<Set<Object>, Object> group2Lock= null;//
	public boolean assigned =false; 
	public Map<LPFakeClassNode, Set<Object>> avoidDupMapping = new HashMap<LPFakeClassNode, Set<Object>>();
	public RelativeDataGrouping()
	{
		this.group2Lock = new HashMap<Set<Object>, Object>();
		assigned=false;
		groupDomain = new HashSet<Set<Object>>();// on-the-demand collection of information!
	 
	}
	
	

   // precondition, the gBipartite has been collected!
	public static void main(String[] args) {
		assert 2!=2;// -ea  explicitly open this option! 
		// if is the logic, assert is for debug, do not mess them up
		Assert.assertTrue(2!=2);

	}

	public Object lock4Group(Set<Object> group) {
		if(RelativeBiPartiteCrawler.gBiPartite==null)
			throw new RuntimeException();
		if(assigned) return group2Lock.get(group);
		else {
			assignLock4Group();
		 return this.group2Lock.get(group);
		}
	}

	private void assignLock4Group() {
         Iterator<Set<Object>> groupIT = groupDomain.iterator();// for seen groups
		 while (groupIT.hasNext()) {
			Set<Object> set = (Set<Object>) groupIT.next();
		    Object lock = new Object();
			group2Lock.put(set, lock);		
		}
		 assigned=true;
		 return;
		
	}



	public List<Object> locks4DataViaGroup(Object data) {

		if(RelativeBiPartiteCrawler.gBiPartite==null)
			throw new RuntimeException();
		 List<Object> locks = new ArrayList<Object>();
		 List<Set<Object>> ownerGroup = whichGroups(data);
		 if(ownerGroup.size()!=1) throw new RuntimeException();
		 locks.add(this.lock4Group(ownerGroup.get(0)));
		   
		return locks;
	}
    // here we consider only the base, btu the bipartite consider the base.field in merging!
	public List<Set<Object>> whichGroups(Object data) {
		// the input should be the local/arraybase/staticClass which is already separated
		// from the instanceref/arrayref/staticref/
		if(RelativeBiPartiteCrawler.gBiPartite==null)
			throw new RuntimeException();
		final BiPartitegraph<Object, DefaultEdge> lBipartite= RelativeBiPartiteCrawler.gBiPartite;
		final List retList = new ArrayList<Set<Object>>();
		if(data instanceof Local)
		{   // instanceref arrayref => this type
			//@VisitorForRelativeGroup
			Local  l = (Local )data;
			// get l's component/group: 
			PointsToSet p2S= p2A.reachingObjects(l);// which district am i living in ?
			if(!(p2S instanceof PointsToSetInternal))
				throw new RuntimeException();
			PointsToSetInternal p2SInternal = (PointsToSetInternal)p2S;
			p2SInternal.forall(new P2SetVisitor() {
				boolean anyNodeVisited =false;
				
				@Override
				public void visit(Node n) {
					if(anyNodeVisited) return;
					else {
						anyNodeVisited=true;
					}
					
					List<Set<Object>> yComponents = lBipartite.weaklyConnectedComponentsOnY();	
					// on anode, it is guaranteed, not like a, a, b: alias variables
					for(int i=0;i<yComponents.size();i++)
					{
						Set<Object> yComponent= yComponents.get(i);
						if(yComponent.contains(n))
						{
							retList.add(yComponent);
						}
					}
					
				}
			});
			
		}
		
		if(data instanceof SootClass)
		{
		  	Set<DefaultEdge> edges= RelativeBiPartiteCrawler.gBiPartite.outgoingEdgesOf(data);
		    if(edges.size()!=1) throw new RuntimeException();// only one LPFAKECLASSNODE
		    DefaultEdge theOnlyEdge =(DefaultEdge)  (edges.toArray())[0];
		    if(!(RelativeBiPartiteCrawler.gBiPartite.getEdgeTarget(theOnlyEdge) instanceof VisitorForRelativeGroup.LPFakeClassNode))
		    	throw new RuntimeException();// should be of this type
		    LPFakeClassNode lpClassNode=(LPFakeClassNode) RelativeBiPartiteCrawler.gBiPartite.getEdgeTarget(theOnlyEdge);
		    Set singlenodeSet = getOrMakeGroup(lpClassNode); // singleton 
		    retList.add(singlenodeSet);
		}
		
		if(retList.size()!=1) throw new RuntimeException();// connected-component
		// each local should belong to a relative group, remind how the relative groups
		// are construncted using bipartite!
		groupDomain.addAll(retList); // on-the-demand collection
		return retList;
	}

	public Set<Object> getOrMakeGroup(Object obj) {
		Assert.assertTrue(obj instanceof LPFakeClassNode);
		LPFakeClassNode lpfake = (LPFakeClassNode) obj;
		if(avoidDupMapping.containsKey(lpfake))
			return avoidDupMapping.get(lpfake);
		else {
			Set<Object> ret = new HashSet<Object>();
			 ret.add(lpfake);
			 avoidDupMapping.put(lpfake, ret);
			 return avoidDupMapping.get(lpfake);
		}
		
		 
	}



	public Set<Set<Object>> allGroups_mappedTo() {
		// TODO Auto-generated method stub
		return groupDomain;
	}




}
