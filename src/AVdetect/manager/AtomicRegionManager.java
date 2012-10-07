package AVdetect.manager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import AVdetect.eventnode.LockingEvent;
import AVdetect.eventnode.UnlockingEvent;
import AVdetect.eventnode.abstractclass.CommunicationEvent;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import AVdetect.eventnode.abstractclass.HardCriticalEvent;
import AVdetect.graph.ARPair;
import AVdetect.graph.CausalGraph;
import AVdetect.graph.CausalGraphTraversal;



public class AtomicRegionManager {
	
	public static HashSet<ARPair> ARPairset =null;

	public static Set<ARPair> findARs(CausalGraph cg)
	{   if(ARPairset !=null) return ARPairset; // cache
		HashSet<ARPair> set = new HashSet<ARPair>();
		Iterator<CriticalEvent> bit =cg.getThreadManager().getBeginningEvents().iterator();
		while (bit.hasNext()) {
			CriticalEvent criticalEvent = (CriticalEvent) bit.next();
			set.addAll(findARsFromBeginning(cg,criticalEvent));			
		}
		ARPairset=set;
		return set;
	}


	private static Set<ARPair> findARsFromBeginning(
			CausalGraph cg, CriticalEvent beginEvent) {
		// find first locking, matching unlocking, internal wait/notify, partition, further recursion
		HashSet<ARPair> ars = new HashSet<ARPair>();
		findARsFromBeginning0(cg,beginEvent, ars);
		return ars;
		
	}
	
	private static void findARsFromBeginning0(
			CausalGraph cg, CriticalEvent beginEvent, HashSet<ARPair> ars) {
		// find first locking, matching unlocking, internal wait/notify, partition, further recursion
		
		LockingEvent le = (LockingEvent)CausalGraphTraversal.getFirstEventOfTypeLocally(cg, beginEvent, LockingEvent.class);
		if(le ==null) return;// no followings.
		UnlockingEvent ue = (UnlockingEvent)cg.getThreadManager().queryMatchingInItsThread(le);
		if(ue==null) {throw new RuntimeException("what is up");}
		List<HardCriticalEvent> innerComs =(List<HardCriticalEvent>)CausalGraphTraversal.getInnerEventsOfTypeLocally(cg, le, ue, CommunicationEvent.class);
		innerComs.add(0, le);  innerComs.add(ue);
		for(int i =0; i<= innerComs.size()-2; i++)
		{
			HardCriticalEvent left =innerComs.get(i);
			HardCriticalEvent right =innerComs.get(i+1);
			ARPair ar = new ARPair(left, right);
			ars.add(ar);
		}
		
		findARsFromBeginning0(cg,ue, ars);		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
