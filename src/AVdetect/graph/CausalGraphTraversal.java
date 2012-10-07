package AVdetect.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import soot.dava.toolkits.base.finders.CycleFinder;
import soot.jimple.toolkits.thread.synchronizationLP.lockfix.LockFix;

import com.sun.org.apache.bcel.internal.generic.NEW;
import AVdetect.edge.CommunicationCausalEdge;
import AVdetect.edge.LocalCausalEdge;
import AVdetect.edge.LockingCausalEdge;
import AVdetect.edge.SharedAccessCausalEdge;
import AVdetect.edge.abstractclass.CausalEdge;
import AVdetect.eventnode.LockingEvent;
import AVdetect.eventnode.SharedAccessEvent;
import AVdetect.eventnode.UnlockingEvent;
import AVdetect.eventnode.abstractclass.CommunicationEvent;
import AVdetect.eventnode.abstractclass.CriticalEvent;

public class CausalGraphTraversal {

	public static LocalCausalEdge getFollowingLocalEdgeLocally(CausalGraph cg,
			CriticalEvent criticalEvent)
	{
		Iterator<CausalEdge> it =cg.coreG.outgoingEdgesOf(criticalEvent).iterator();
		while (it.hasNext()) {
			CausalEdge causalEdge = (CausalEdge) it.next();
			if(causalEdge instanceof LocalCausalEdge)
			{
				return (LocalCausalEdge)causalEdge;
			}		
		}
		return null;
		
	}
	
	public static List<LocalCausalEdge> getInnerLocalEdges(CausalGraph cg,
			CriticalEvent beginE, CriticalEvent endE) {
		List retList = new ArrayList<CriticalEvent>();
		CriticalEvent tmp = beginE;
		LocalCausalEdge edge  =null;
		while(tmp!=endE)
		{		
			edge= getFollowingLocalEdgeLocally(cg, tmp);			
			retList.add(edge);		
			tmp = (CriticalEvent) edge.getTarget();
		}		
		return retList;
	}
	
	public static CriticalEvent getNextEventLocally(CausalGraph cg,
			CriticalEvent criticalEvent)
	{
		Iterator<CausalEdge> it =cg.coreG.outgoingEdgesOf(criticalEvent).iterator();
		while (it.hasNext()) {
			CausalEdge causalEdge = (CausalEdge) it.next();
			if(causalEdge instanceof LocalCausalEdge)
			{
				return (CriticalEvent)causalEdge.getTarget();
			}		
		}
		return null;
		
	}
	public static CriticalEvent getFirstEventOfTypeLocally(CausalGraph cg,
			CriticalEvent beginEvent, Class class1) {
		CriticalEvent tofind = beginEvent;
		while((tofind!=null) && !class1.isInstance(tofind))
		{
			tofind = getNextEventLocally(cg, tofind);
		}
		if(tofind==null)
		{
			//System.err.println("find no event of such type");
			return null;
		}
		else {
			return tofind;
		}		
	}
	public static List getInnerEventsOfTypeLocally(CausalGraph cg,
			CriticalEvent beginE, CriticalEvent endE, Class class1) {
		List retList = new ArrayList<CriticalEvent>();
		CriticalEvent tmp = beginE;
		while(tmp!=endE)
		{
			if(class1.isInstance(tmp))
			{
				retList.add(tmp);
			}
			tmp = getNextEventLocally(cg, tmp);
		}
		if(class1.isInstance(tmp))// tmp==endE
		{
			retList.add(tmp);
		}
		return retList;
	}
	
	public static List<CriticalEvent> eventsBeforeLocally(CausalGraph cg, CriticalEvent ce)
	{
		List<CriticalEvent> list = new ArrayList<CriticalEvent>();
		CriticalEvent begin =cg.getThreadManager().getBeginningEventOfThread(ce.getTh());
		CriticalEvent tmp = begin;
		while(tmp !=ce)
		{
			list.add(tmp);
			tmp = getNextEventLocally(cg, tmp);			
		}
		return list;		
	}
	public static List<CriticalEvent> eventsBeforeEqualLocally(CausalGraph cg, CriticalEvent ce)
	{
		List<CriticalEvent> list = new ArrayList<CriticalEvent>();
		CriticalEvent begin =cg.getThreadManager().getBeginningEventOfThread(ce.getTh());
		CriticalEvent tmp = begin;
		while(tmp !=ce)
		{
			list.add(tmp);
			tmp = getNextEventLocally(cg, tmp);			
		}
		list.add(ce);
		return list;		
	}
	
	public static List<CriticalEvent> eventsAfterLocally(CausalGraph cg , CriticalEvent ce)
	{
		List<CriticalEvent> list = new ArrayList<CriticalEvent>();
		
		CriticalEvent tmp = ce;
		tmp = getNextEventLocally(cg, tmp);
		while(tmp!=null)
		{
			list.add(tmp);	
			tmp = getNextEventLocally(cg, tmp);
					
		}
		return list;
		
	}
	public static HashMap<CausalGraph,List<CausalEdge>> cg2commEdges = new HashMap<CausalGraph, List<CausalEdge>>();
	public static HashMap<CausalGraph,List<CausalEdge>> cg2lockEdges = new HashMap<CausalGraph, List<CausalEdge>>();
	public static HashMap<CausalGraph,List<CausalEdge>> cg2shacEdges = new HashMap<CausalGraph, List<CausalEdge>>();
	public static HashMap<CausalGraph,List<CausalEdge>> cg2localEdges = new HashMap<CausalGraph, List<CausalEdge>>();
	
	public static void categoryEdges(CausalGraph cg)
	{	
		if(visited.size()!=0)
		{
			return ;// has been categoried
		}
		categoryEdges0(cg, cg.getRoot());
	
		
	}
	static Set visited  = new  HashSet();
	
//	private static void categoryEdges0(CausalGraph g, CriticalEvent root) {
//		Set<CausalEdge> edges = g.coreG.outgoingEdgesOf(root);
//		for (Iterator iterator = edges.iterator(); iterator.hasNext();) {
//			CausalEdge defaultEdge = (CausalEdge) iterator.next();
//			CriticalEvent  target = (CriticalEvent)defaultEdge.getTarget();
//			String flabel = defaultEdge.getLabel();
//			if(!visited.contains(target))
//			{
//				visited.add(target);
//				
//				// visit edge
//				categoryIt(g, defaultEdge);
//				categoryEdges0(g, target);	
//			
//				
//			}
//			else {
//				// multiple edges... not go into, but still need to process this edge 
//				// visit edge
//				categoryIt(g, defaultEdge);
//				
//				
//			}			
//		}		
//	}
	
	static Stack<CriticalEvent> systemStack = new Stack<CriticalEvent>();
	private static void categoryEdges0(CausalGraph g, CriticalEvent root) {
		systemStack.clear();
		
		if(!visited.contains(root))
		{
			visited.add(root);
			systemStack.push(root);
		}	
		while(!systemStack.isEmpty())
		{
			CriticalEvent pop = systemStack.pop();
			
			Set<CausalEdge> edges = g.coreG.outgoingEdgesOf(pop);			
			for (Iterator iterator = edges.iterator(); iterator.hasNext();) {// recursion
				CausalEdge defaultEdge = (CausalEdge) iterator.next();
				categoryIt(g, defaultEdge);
				CriticalEvent  target = (CriticalEvent)defaultEdge.getTarget();
				if(!visited.contains(target))
				{
					visited.add(target);
					systemStack.push(target);
				}			    
			}
		}
	
	}
	private static void categoryIt(CausalGraph g, CausalEdge defaultEdge) {
		if(defaultEdge instanceof CommunicationCausalEdge)
		{
			putto(cg2commEdges, g, (CommunicationCausalEdge)defaultEdge);
		}
		else if (defaultEdge instanceof LockingCausalEdge) {
			putto(cg2lockEdges, g, (LockingCausalEdge)defaultEdge);
		}
		else if (defaultEdge instanceof SharedAccessCausalEdge) {
			putto(cg2shacEdges, g, (SharedAccessCausalEdge)defaultEdge);
		}
		else if (defaultEdge instanceof LocalCausalEdge) {
			putto(cg2localEdges, g, (LocalCausalEdge)defaultEdge);
		}
		
		
	}

	private static void putto(
			HashMap<CausalGraph, List<CausalEdge>> cg2Edges2,
			CausalGraph g, CausalEdge defaultEdge) {
		List<CausalEdge> edges =cg2Edges2.get(g);
		if(edges ==null)
		{
			edges = new ArrayList<CausalEdge>();
			cg2Edges2.put(g, edges);
		}
		edges.add(defaultEdge);		
	}

	public static List<CausalEdge> emptyList = new ArrayList<CausalEdge>();
	public static List<CausalEdge> getCommunicationEdges(CausalGraph cg)
	{
		List<CausalEdge> list =cg2commEdges.get(cg);
		if(list == null)
		{
			categoryEdges(cg);
		}
		list =cg2commEdges.get(cg);
		if(list == null ) return emptyList;
		return list;		
	}
	public static List<CausalEdge> getLockingEdges(CausalGraph cg)
	{
		List<CausalEdge> list =cg2lockEdges.get(cg);
		if(list == null)
		{
			categoryEdges(cg);
		}
		list =cg2lockEdges.get(cg);
		if(list == null ) return emptyList;
		 return list;		
	}
	public static List<CausalEdge> getSharedAccessEdges(CausalGraph cg)
	{
		List<CausalEdge> list =cg2shacEdges.get(cg);
		if(list == null)
		{
			categoryEdges(cg);
		}
		list =cg2shacEdges.get(cg);
		if(list == null ) return emptyList;
		 return list;	
	}
	
	public static List<CausalEdge> getLocalEdges(CausalGraph cg)
	{
		List<CausalEdge> list =cg2localEdges.get(cg);
		if(list == null)
		{
			categoryEdges(cg);
		}
		list =cg2localEdges.get(cg);
		if(list == null ) return emptyList;
		 return list;
	}
	public static List<SharedAccessCausalEdge> shacEdges_tmp = new ArrayList<SharedAccessCausalEdge>();
	public static List<SharedAccessCausalEdge> getSharedAccessEdges_tmp(CausalGraph cg)
	{
		return shacEdges_tmp;	
	}
	
	private static CausalEdge addSharedEdge_tmp(CausalGraph cg,
			CriticalEvent node, CriticalEvent tgt) {

		SharedAccessCausalEdge sac = (SharedAccessCausalEdge)cg.addEdge_edgetype(node, tgt, SharedAccessCausalEdge.class);
		shacEdges_tmp.add(sac);
		return sac;
	}
	public static void removeSharedEdge_tmp(CausalGraph cg )
	{
		shacEdges_tmp.clear();
	}
	

	public static Set<Long> sharedMems = new HashSet<Long>();
	public static Set<Long> sharedMems(CausalGraph cg)
	{// shared variables		
		   if(sharedMems.size()==0)
		   {
			   List<CausalEdge> edges =CausalGraphTraversal.getSharedAccessEdges(cg);		  
			   for(CausalEdge edge:edges)
			   {
				   CriticalEvent sourcEvent = (CriticalEvent)edge.getSource();
				   sharedMems.add(sourcEvent.getMem());			  
			   }
			   return sharedMems;
		   }
		   else {
			   return sharedMems;
		   }		  		   
	}
	
	//public static HashSet<CriticalEvent > whites = new HashSet<CriticalEvent>();
	public static Stack<CriticalEvent> greys = new Stack<CriticalEvent>();
	public static HashSet<CriticalEvent> blacks = new HashSet<CriticalEvent>();
	public static HashSet<List<CriticalEvent>> detectedCycles = new HashSet<List<CriticalEvent>>();
	public static HashSet<List<CriticalEvent>> naiveCycleDetection(CausalGraph cg, ARPair aPair )
	{
		if(cg.containShAc==false) 
		{
			throw new RuntimeException("did not contain the sac, no way to detect");
		}
		 greys.clear(); blacks.clear(); 
		 detectedCycles.clear();
		 CausalGraphFlipping.reverseInnerEdgesLocally(cg, aPair);
		naiveCycleDetection0(cg, aPair, (CriticalEvent)aPair.getO2());	// O1, lock(), no outgoing edges after the reversing!
	//	cg.exportCausalGraph("/home/lpxz/eclipse/workspace/leap/recorder/test.dot");
		CausalGraphFlipping.reverseInnerEdgesBackLocally(cg, aPair);
		return detectedCycles;
	}

	private static void naiveCycleDetection0(CausalGraph cg, ARPair aPair, CriticalEvent node) {
		greys.push(node);
		
		Set<CausalEdge> edges =cg.coreG.outgoingEdgesOf(node);
		for(CausalEdge edge : edges)
		{
			CriticalEvent tgt = (CriticalEvent)edge.getTarget();
			if(!greys.contains(tgt) && !blacks.contains(tgt))
			{
				naiveCycleDetection0(cg, aPair, tgt);
			}
			else if (greys.contains(tgt) && !blacks.contains(tgt)) {
				List<CriticalEvent> list = reportCycle(cg,greys, tgt);	// reportCycle				
				detectedCycles.add(list);			
			}
			else if( !greys.contains(tgt) && blacks.contains(tgt)){
			//	System.out.println("pointless");				
			}
			else {
				throw new RuntimeException("impossible: both contain");
			}
			
		}
		
		
		greys.pop();
		blacks.add(node);
	}

//	private static List<CriticalEvent> reportCycle(CausalGraph cg, Stack<CriticalEvent> greys2,
//			CriticalEvent tgt) {
//		List<CriticalEvent> list = new ArrayList<CriticalEvent>();
//		int i =greys2.indexOf(tgt);
//		System.err.println("\ncycle:");
//		for(int j=i; j< greys2.size(); j++)
//		{
//			CriticalEvent ce =greys2.get(j);
//			list.add(ce);
//			System.err.print(" " + ce.hashCode()+ ":"+ ce.getTh() + ":" + ce.getMem() + ":" + ce.getSerialNO());
//		}
//		list.add(tgt);// the tgt of the final backedge
//		System.err.print(" " + tgt.hashCode()+ ":"+ tgt.getTh() + ":" + tgt.getMem() + ":" + tgt.getSerialNO());
//		System.err.println();
//		return list;
//	}
	
	private static List<CriticalEvent> reportCycle(CausalGraph cg, Stack<CriticalEvent> greys2,
			CriticalEvent tgt) { // tgt should be shared 
		Set<Long> sharedMems =sharedMems(cg);
		List<CriticalEvent> list = new ArrayList<CriticalEvent>();
		int i =greys2.indexOf(tgt);
		System.err.println("\ncycle:");
		for(int j=i; j< greys2.size(); j++)
		{
			CriticalEvent ce =greys2.get(j);
			if(sharedMems.contains(ce.getMem()))
			{
				list.add(ce);
				System.err.println(" " + ce.hashCode()+ " ("+ ce.getTh() + ":" + ce.getClassname() + ":" + ce.getLineNO() + ") ");
			}			
		}
		if(sharedMems.contains(tgt.getMem()))
		{
			list.add(tgt);// the tgt of the final backedge
			System.err.println(" " + tgt.hashCode()+ " ("+ tgt.getTh() + ":" + tgt.getClassname() + ":" + tgt.getLineNO() + " )");
		}
		
		System.err.println();
		return list;
	}
	
	private static List<CriticalEvent> reportAVform(CausalGraph cg, Stack<CriticalEvent> greys2,
			CriticalEvent tgt) { // tgt should be shared 
		Set<Long> sharedMems =sharedMems(cg);
		List<CriticalEvent> list = new ArrayList<CriticalEvent>();
		int i =greys2.indexOf(tgt);
		System.err.println("\nAV:");
		int localFarest2tgt_index = -1;
		for(int j=i; j< greys2.size(); j++)
		{
			CriticalEvent ce =greys2.get(j);
			if(ce.getTh()== tgt.getTh())
			{
				localFarest2tgt_index = j;
			}			
		}
		
		
		for(int j=localFarest2tgt_index; j< greys2.size(); j++)
		{
			CriticalEvent ce =greys2.get(j);
			if(sharedMems.contains(ce.getMem()))
			{
				list.add(ce);
				System.err.println(" " + ce.hashCode()+ " ("+ ce.getTh() + ":" + ce.getClassname() + ":" + ce.getLineNO() + ") ");
			}			
		}
		if(sharedMems.contains(tgt.getMem()))
		{
			list.add(tgt);// the tgt of the final backedge
			System.err.println(" " + tgt.hashCode()+ " ("+ tgt.getTh() + ":" + tgt.getClassname() + ":" + tgt.getLineNO() + " )");
		}
		
		System.err.println();
		return list;
	}
	
	

    public static HashMap<Long,  CriticalEvent> frontiers(CausalGraph cg,CriticalEvent ce)
    {
    	// remove all shared access remote edges initially!
    	
    	HashMap<Long,  CriticalEvent> map = new HashMap<Long, CriticalEvent>();
    	cg.getThreadManager().assignSerialNo(cg);
    	List<CriticalEvent> befores =eventsBeforeEqualLocally(cg, ce);
    	//befores.add(ce);// to avoid the scenario : x-> y, y-> x (considering y, x is not banned if this statement is not added)
    	
    	List<CausalEdge> remoteEdges = new ArrayList<CausalEdge>();
    	List comms = getCommunicationEdges(cg);
    	List lockedges = getLockingEdges(cg);
    	List shacedges = getSharedAccessEdges_tmp(cg);// this is problematic, as the shared access edges are not updated at all.
    	
    	if(comms!=null) remoteEdges.addAll(comms);
    	if(lockedges !=null ) remoteEdges.addAll(lockedges);
    	if(shacedges!=null) remoteEdges.addAll(shacedges);
    	
    	for(CausalEdge edge : remoteEdges)
    	{
    		if(befores.contains(edge.getTarget()))
			{
		       CriticalEvent source = (CriticalEvent)edge.getSource();
		       long th =source.getTh();
			   CriticalEvent value =map.get(th);
			   if(value ==null)
			   {
				   map.put(th, source);
			   }
			   else {
				  if(value.getSerialNO() < source.getSerialNO())// source is more recent
				  {
					  map.put(th, source);
				  }
			   }
			}
    	}
    	return map;    	
    }

//    public static List<CriticalEvent> postfrontiers(CausalGraph cg, HashMap<Long, CriticalEvent> map)
//    {
//    	List<CriticalEvent> list = new ArrayList<CriticalEvent>();
//    	Iterator<Long> it =map.keySet().iterator();
//    	while (it.hasNext()) {
//			Long long1 = (Long) it.next();
//			CriticalEvent value =map.get(long1);
//			list.addAll(eventsAfterLocally(cg, value));			
//		}
//    	Set<Long> ids =cg.getThreadManager().getThreadIDs();
//    	for(Long id : ids)
//    	{
//    		if(!map.keySet().contains(id))// not in the map, the whole thread is possible as the target
//    		{
//    			list.add(cg.getThreadManager().getBeginningEventOfThread(id));
//    			list.addAll(eventsAfterLocally(cg, cg.getThreadManager().getBeginningEventOfThread(id)));    			
//    		}
//    	}
//    	return list;    	
//    }
    
    
    public static List<SharedAccessEvent> MatchShAC_postfrontiers(CausalGraph cg, HashMap<Long, CriticalEvent> map, SharedAccessEvent sac)
    {
    	List<SharedAccessEvent> list = new ArrayList<SharedAccessEvent>();
    	long mem = sac.getMem();
    	Iterator<Long> it =map.keySet().iterator();
    	while (it.hasNext()) {
			Long long1 = (Long) it.next();
			CriticalEvent value =map.get(long1);
			List<CriticalEvent> events = eventsAfterLocally(cg, value);
			for(CriticalEvent ce : events)
			{
				
				if(ce.getMem() == mem && ce instanceof SharedAccessEvent)
				{
					list.add((SharedAccessEvent)ce);
				}
			}					
		}
    	Set<Long> ids =cg.getThreadManager().getThreadIDs();
    	for(Long id : ids)
    	{
    		if(id==sac.getTh()) continue; // do not include the events in the same thread, just remoe ones
    		if(!map.keySet().contains(id))// not in the map, the whole thread is possible as the target
    		{
    			CriticalEvent begin = cg.getThreadManager().getBeginningEventOfThread(id);
    			if(begin.getMem() == mem && begin instanceof SharedAccessEvent)
    			{
    				list.add((SharedAccessEvent)begin);
    			}
    			List<CriticalEvent> events = eventsAfterLocally(cg, begin);
    			for(CriticalEvent ce : events)
    			{
    				if(ce.getMem() == mem && ce instanceof SharedAccessEvent)
    				{
    					list.add((SharedAccessEvent)ce);
    				}
    			}
    			 			
    		}
    	}
    	return list;    	
    }
    
    public static List<SharedAccessEvent> MatchShAC_postfrontiers(CausalGraph cg, SharedAccessEvent ce)
    {    	// guarantee there is no mutant edges, i.e., the reversed edges
    	return MatchShAC_postfrontiers(cg, frontiers(cg, ce), ce);
    }
    
    
    public static Stack<CriticalEvent> greys_smart = new Stack<CriticalEvent>();
	public static HashSet<CriticalEvent> blacks_smart = new HashSet<CriticalEvent>();
	public static HashSet<List<CriticalEvent>> detectedCycles_smart = new HashSet<List<CriticalEvent>>();
	public static HashSet<List<CriticalEvent>> smartCycleDetection(CausalGraph cg, ARPair aPair )
	{
		 greys_smart.clear(); blacks_smart.clear(); 
		 detectedCycles_smart.clear();
		 removeSharedEdge_tmp(cg);// important
		 cg.exportCausalGraph("/home/lpxz/eclipse/workspace/leap/recorder/test_bef.dot");
		 cg.removeSharedAccessEdges();// newly added. 
		 
		 CausalGraphFlipping.reverseInnerEdgesLocally(cg, aPair);
		 cg.exportCausalGraph("/home/lpxz/eclipse/workspace/leap/recorder/test.dot");
		smartCycleDetection0(cg, aPair, (CriticalEvent)aPair.getO2());	// O1, lock(), no outgoing edges after the reversing!
		 
		CausalGraphFlipping.reverseInnerEdgesBackLocally(cg, aPair);
		return detectedCycles_smart;
	}
    // Note:
	// I essentially add  the potential outgoing shared access edges,
	// After the edge (a->b) is added, the potential outgoing nodes of b also change! re-calculate on-demand.
	private static void smartCycleDetection0(CausalGraph cg, ARPair aPair, CriticalEvent node) {
		greys_smart.push(node);
		List<SharedAccessEvent> possibleTargets= null;
		List<CriticalEvent> tgts = new ArrayList<CriticalEvent>();// yes, list, I do not like set.
		
		
		//Set<CriticalEvent> targets =cg.outgoingNodesOf(cg,node);// all edges are invovled

		Set<CausalEdge> edges = cg.coreG.outgoingEdgesOf(node);
		for(CausalEdge ce : edges)
		{
			if(ce instanceof LocalCausalEdge)// the cycles due ot the locks are not interesting, although atomfuzzer does not think so.
			{
				tgts.add((CriticalEvent)ce.getTarget());
			}
		}

		
		
		if(node instanceof SharedAccessEvent)
		{
			CausalGraphFlipping.reverseInnerEdgesBackLocally(cg, aPair);// keep the eventsafter working.
			possibleTargets =MatchShAC_postfrontiers(cg, (SharedAccessEvent)node);// affected by the newly added sharedaccessedge/constraints
			tgts.addAll(possibleTargets);
			CausalGraphFlipping.reverseInnerEdgesLocally(cg, aPair);
		}
//		System.err.println(node.hashCode() + " 's targets:");
//		for(CriticalEvent tar :tgts)
//		{			
//			if(possibleTargets!=null && possibleTargets.contains(tar))// added shared access edge
//			{
//				System.err.println(tar.hashCode() +"_remote");
//			}
//			else {
//				System.err.println(tar.hashCode() );
//			}
//		}
//		System.err.println();
//		if(tgts.size() ==0)
//		{
//			System.err.println("what is up");
//		}
		for(CriticalEvent tgt : tgts)
		{			
			//when meeting with the black nodes, you need to continue. different from the common cases, the future edges are not sure and may not be explored at all. 
			// Considering that our graph chages every time based on the historical visiting. We can not make sure the scenarios under the black node do not change!
			// if you set the black edge and do not visit them any more, you will end up finding no cycles.
			// you may have a try
			// the reason is that, the first node thinks it has led to the black nodes whose subgraphs are totally visited
			// but it is not true! the first node, the second node, then black nodes still form the cycle.
			if(!greys_smart.contains(tgt) ) //&& !blacks_smart.contains(tgt)
			{
				if(possibleTargets!=null && possibleTargets.contains(tgt))// added shared access edge
				{					
					CausalEdge newlyadded = addSharedEdge_tmp(cg,node, tgt);
					//System.err.println(node.hashCode() + "--> " + tgt.hashCode());
					smartCycleDetection0(cg, aPair, tgt);
					cg.coreG.removeEdge(newlyadded);
				}
				else {// simple version
					//System.err.println(node.hashCode() + "-> " + tgt.hashCode());
					smartCycleDetection0(cg, aPair, tgt);
				}				
			}
			else if (greys_smart.contains(tgt) ) { //&& !blacks_smart.contains(tgt)
				List<CriticalEvent> list = reportAVform(cg,greys_smart, tgt);					
				detectedCycles_smart.add(list);	// the cycles are not the same, considering the visiting diversity		
			}
//			else if( !greys_smart.contains(tgt) && blacks_smart.contains(tgt)){
//			//	System.out.println("pointless");				
//			}
			else {
				throw new RuntimeException("impossible: both contain");
			}			
		}				
		greys_smart.pop();
		blacks_smart.add(node);
	}


    
	

}
