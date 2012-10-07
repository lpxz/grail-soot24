
package AVdetect.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java_cup.internal_error;



import AVdetect.edge.LocalCausalEdge;
import AVdetect.edge.LockingCausalEdge;
import AVdetect.edge.abstractclass.CausalEdge;
import AVdetect.eventnode.LockingEvent;
import AVdetect.eventnode.UnlockingEvent;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import AVdetect.manager.AtomicRegionManager;
import AVdetect.manager.ThreadManager;

public class CausalGraphFlipping {
	// one atomic region at a time, the reversed causal graph is mutant, not linear... limit the drawback to the maximal extent
	//public static HashSet<LocalCausalEdge> reversedEdges = new HashSet<LocalCausalEdge>();
	public static HashMap<LocalCausalEdge, LocalCausalEdge> reversed2orig = new HashMap<LocalCausalEdge, LocalCausalEdge>();
	// its keyset is the reversed edges.
	public static CriticalEvent startEvent =null;
	public static CriticalEvent endEvent  = null;
	
	public static void reverseInnerEdgesLocally(CausalGraph cg , ARPair ap)
	{
		reverseInnerEdgesLocally(cg, ap.getO1(), ap.getO2());
	}
	public static void reverseInnerEdgesBackLocally(CausalGraph cg , ARPair ap)
	{
		reverseInnerEdgesBackLocally(cg, ap.getO1(), ap.getO2());
	}
	public static void reverseInnerEdgesLocally(CausalGraph cg , CriticalEvent start, CriticalEvent end)
	{
		reversed2orig.clear();
		startEvent= start;
		endEvent = end;
		List<LocalCausalEdge> innerEs=CausalGraphTraversal.getInnerLocalEdges(cg, start, end);
		for (LocalCausalEdge localCausalEdge : innerEs) {			
			//System.out.println(localCausalEdge.getSource().hashCode() + "->" + localCausalEdge.getTarget().hashCode());
			LocalCausalEdge reversed = (LocalCausalEdge)cg.addEdge_edgetype((CriticalEvent)localCausalEdge.getTarget(), (CriticalEvent)localCausalEdge.getSource(), LocalCausalEdge.class);
			cg.coreG.removeEdge(localCausalEdge);
			reversed2orig.put(reversed, localCausalEdge);			
		}	
		//System.out.println("");
	}
	public static void reverseInnerEdgesBackLocally(CausalGraph cg , CriticalEvent start, CriticalEvent end)
	{
	   if(startEvent == start && endEvent == end)
	   {
		   // pass signature checking, it is your area
		   Iterator<LocalCausalEdge> it = reversed2orig.keySet().iterator();
	       while (it.hasNext()) {
			LocalCausalEdge reversed = (LocalCausalEdge) it.next();
			LocalCausalEdge orig = reversed2orig.get(reversed);
			cg.addEdge_edgetype((CriticalEvent)orig.getSource(), (CriticalEvent)orig.getTarget(), LocalCausalEdge.class);
		       
			cg.coreG.removeEdge(reversed);
			}
	       reversed2orig.clear();// game over
	       startEvent = null;
	       endEvent =null;
	   }
	   else {
		throw new RuntimeException("do not use in this way, reverse it and back in an atomic way");
	}
	}
	
	public static HashMap<LockingCausalEdge,  LockingCausalEdge> flipped2orig = new HashMap<LockingCausalEdge, LockingCausalEdge>();
	public static LockingCausalEdge flipLockEdge(CausalGraph cg, LockingCausalEdge edge)
	{
    	CriticalEvent source = (CriticalEvent) edge.getSource();
    	CriticalEvent tgt = (CriticalEvent) edge.getTarget();
        ThreadManager tm = cg.getThreadManager();
        LockingEvent source_o = (LockingEvent)tm.queryMatchingInItsThread((UnlockingEvent)source);
        UnlockingEvent tgt_o  = (UnlockingEvent)tm.queryMatchingInItsThread((LockingEvent)tgt);
     
        LockingCausalEdge flipped = (LockingCausalEdge)cg.addEdge_edgetype(tgt_o, source_o, LockingCausalEdge.class);
        cg.coreG.removeEdge(edge);
        flipped2orig.put(flipped, edge);  
        return flipped;
	}
	
	public static void flipLockEdgeBack(CausalGraph cg, LockingCausalEdge flipped)
	{
    	CriticalEvent source = (CriticalEvent) flipped.getSource();
    	CriticalEvent tgt = (CriticalEvent) flipped.getTarget();
        ThreadManager tm = cg.getThreadManager();
        LockingEvent source_o = (LockingEvent)tm.queryMatchingInItsThread((UnlockingEvent)source);
        UnlockingEvent tgt_o  = (UnlockingEvent)tm.queryMatchingInItsThread((LockingEvent)tgt);
     
        LockingCausalEdge edge = (LockingCausalEdge)cg.addEdge_edgetype(tgt_o, source_o, LockingCausalEdge.class);
        cg.coreG.removeEdge(flipped);
        flipped2orig.remove(flipped);// no this edge any more..
      
	}
	
	public static void flippable(CausalGraph cg)
	{
		cg.getThreadManager().assignSerialNo(cg);
		List<CausalEdge> comms =CausalGraphTraversal.getCommunicationEdges(cg);
		List<CausalEdge> lockedges = CausalGraphTraversal.getLockingEdges(cg);		
		List<CausalEdge> flippable1 =flippable_comms(cg,lockedges, comms);
		
		List<CausalEdge> stack = new  ArrayList<CausalEdge>();
		flipping_locks(cg, flippable1, 0, stack);
		
		// apply lock flipping!!!!! + internal checking of flipping	
	}
	private static void flipping_locks(CausalGraph cg, List<CausalEdge> flippable1, int currIndex, List<CausalEdge> stack) {
		if(currIndex>= flippable1.size())
            {
			    Set<ARPair> arps = AtomicRegionManager.findARs(cg);
				   boolean mark = true;
				    for (ARPair arPair : arps) 	
				    {
				    //	if(mark)
				    	{
				    		CausalGraphTraversal.smartCycleDetection(cg,arPair );// the locks are present on the graph now, detect
				    		mark = false;
				    	}
				    	
				    }
			return;//ending condition
            
            }
		LockingCausalEdge ce = (LockingCausalEdge)flippable1.get(currIndex);
		// note that, the stack containing the locks represent the constraints.
		// applyflippting case1
		if(flippable_ce_locks(cg, ce, stack))// checking the capability
		{
		//	System.err.println("flipping.. " + currIndex);
			LockingCausalEdge flipped = flipLockEdge(cg, ce);
			stack.add(flipped);		
			flipping_locks(cg, flippable1, currIndex+1, stack);
			CausalEdge pop =stack.remove(stack.size()-1); // pop()
			if(pop!=flipped)
			{
				throw new RuntimeException();
			}		
		//	System.err.println("flipping back.. " + currIndex);
			flipLockEdgeBack(cg, flipped);
			// cancel the flipping
		}

		
		// no flipping-  case2 
		stack.add(ce);		
		flipping_locks(cg, flippable1, currIndex+1, stack);
		CausalEdge pop =stack.remove(stack.size()-1); // pop()
		if(pop!=ce)
		{
			throw new RuntimeException();
		}	
		
	}
	private static boolean flippable_ce_locks(CausalGraph cg,
			LockingCausalEdge ce, List<CausalEdge> stack) {
		boolean flippable = true;
		for(CausalEdge lEdge: stack)
		{
			if(notHarmonyAfterFlipping(cg, ce, lEdge))
			{
				flippable =false;
				
			}
		}
		return flippable;
	}
	private static List<CausalEdge> flippable_comms(CausalGraph cg, List<CausalEdge> lockedges,
			List<CausalEdge> comms) {
		List<CausalEdge> list = new ArrayList<CausalEdge>();
		for(CausalEdge ce : lockedges)
		{
			boolean flippable = true;
			for(CausalEdge comm: comms)
			{
				if(notHarmonyAfterFlipping(cg, ce, comm))
				{
					flippable =false;
					
				}
			}
			if(flippable)
			{
				list.add(ce);
			}
		}
		
		return list;
	}
	private static boolean notHarmonyAfterFlipping(CausalGraph cg, CausalEdge edge, CausalEdge comm) {
		CriticalEvent source = (CriticalEvent) edge.getSource();
    	CriticalEvent tgt = (CriticalEvent) edge.getTarget();
        ThreadManager tm = cg.getThreadManager();
        LockingEvent newtgt = (LockingEvent)tm.queryMatchingInItsThread((UnlockingEvent)source);
        UnlockingEvent newsrc  = (UnlockingEvent)tm.queryMatchingInItsThread((LockingEvent)tgt);
        
        CriticalEvent source_c = (CriticalEvent) comm.getSource();
		CriticalEvent tgt_C = (CriticalEvent) comm.getTarget();
		if(tgt_C.getTh() == newsrc.getTh() && newsrc.getSerialNO() > tgt_C.getSerialNO())
		{
			if(newtgt.getTh()== source_c.getTh() && newtgt.getSerialNO() < source_c.getSerialNO())
			{
				return true; //really not harmony
			}
		}
		
		return false;
	}
	
	
	

}
