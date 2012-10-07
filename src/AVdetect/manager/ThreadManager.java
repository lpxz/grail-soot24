package AVdetect.manager;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import java_cup.internal_error;

import AVdetect.eventnode.LockingEvent;
import AVdetect.eventnode.UnlockingEvent;
import AVdetect.eventnode.abstractclass.CriticalEvent;
import AVdetect.eventnode.abstractclass.LockReleEvent;
import AVdetect.graph.CausalGraph;
import AVdetect.graph.CausalGraphTraversal;

public class ThreadManager {

	public  HashMap<Long, CriticalEvent> thread2BeginningEvent= new HashMap<Long, CriticalEvent>();
	   public  void setBeginningEvent4ItsThread( CriticalEvent e)
	   {
		   long tid = e.getTh();
		   thread2BeginningEvent.put(tid, e);
	   }
	   
	   public  CriticalEvent getBeginningEventOfThread(long tid)
	   {
		   return thread2BeginningEvent.get(tid);
	   }
	   public  Set<Long> getThreadIDs()
	   {
		   return thread2BeginningEvent.keySet();
	   }
	   public  Collection<CriticalEvent> getBeginningEvents()
	   {
		   return thread2BeginningEvent.values();
	   }
	   
	   
	public  HashMap<Long, CriticalEvent> thread2lastEvent= new HashMap<Long, CriticalEvent>();
	   public  void updateLastEvent4ItsThread( CriticalEvent e)
	   {
		   long tid = e.getTh();
		   thread2lastEvent.put(tid, e);
	   }
	   
	   public  CriticalEvent getLastEventOfThread(long tid)
	   {
		   return thread2lastEvent.get(tid);
	   }
	   
	   
	   public  HashMap< Long, Stack<LockingEvent>> thread2UnmatchedLockingStack = new HashMap<Long, Stack<LockingEvent>>();
	   
		public  void updateLastUnmatchedLocking4ItsThread(LockingEvent le)
		{
			long tid = le.getTh();
			Stack<LockingEvent> stack =thread2UnmatchedLockingStack.get(tid);
			if(stack==null)
				{
				   stack = new Stack<LockingEvent>();
				   thread2UnmatchedLockingStack.put(tid, stack);
				}
			stack.push(le);
		}
	   
//		public static LockingEvent getLastUnmatchedLocking4Thread(int tid)
//		{
//			Stack<LockingEvent> stack =thread2UnmatchedLockingStack.get(tid);
//			if(stack==null)
//				{
//				  throw new RuntimeException();// how can an unlocking have no locking?
//				 
//				}
//			return stack.peek();
//			
//		}
	    public  void matchLastUnmatchedLocking4ItsThread( UnlockingEvent ue)
	    {
	    	
	    	long tid  = ue.getTh();
			Stack<LockingEvent> stack =thread2UnmatchedLockingStack.get(tid);
			if(stack==null)
				{
				  throw new RuntimeException("how can an unlocking have no locking");// how can an unlocking have no locking?
				 
				}
			LockingEvent top = stack.pop();
			if(verifyMatch(top, ue))
			{
				//update
				registerMatching4ItsThread(top, ue);
			}
			else {
				throw new RuntimeException("how can an unlocking have a wrong locking");// how can an unlocking have no locking?
			}
			
	    }
	   
	    
	    
	    
	   private  boolean verifyMatch(LockingEvent top, UnlockingEvent le) {
			if(top.getTh() == le.getTh() && top.getMem()==le.getMem())
			{
				return true;
			}
			else {
				return false;
			}
			
		}
	   
	   public  HashMap< Long, HashMap<LockingEvent, UnlockingEvent>> thread2LockMatching = new HashMap< Long, HashMap<LockingEvent, UnlockingEvent>>();
	   public  void registerMatching4ItsThread(LockingEvent le, UnlockingEvent ue)
	   {
		   long tid =le.getTh();
		   HashMap<LockingEvent, UnlockingEvent> map =thread2LockMatching.get(tid);
			if(map==null)
			{
				map = new HashMap<LockingEvent, UnlockingEvent>();
				thread2LockMatching.put(tid, map);
			}
			map.put(le, ue);
		   
	   }
	   
	   public  LockReleEvent queryMatchingInItsThread(LockReleEvent e)
	   {
		   long tid = e.getTh();
		   HashMap<LockingEvent, UnlockingEvent> map =thread2LockMatching.get(tid);
			if(map==null)
			{
				throw new RuntimeException("the map does not exist yet, register first");
			}
			if(e instanceof LockingEvent)
			{
				UnlockingEvent tofind = map.get(e);
			   if(tofind!=null)
			    {
			    	return tofind;
			    }
			    else {
					throw new RuntimeException("seems the matching unlocking is not registered.");
				}
			}
			else if(e instanceof UnlockingEvent){
				LockingEvent tofind =null;
				Iterator it =map.keySet().iterator();				
			    while (it.hasNext()) {
			    	LockingEvent tmpkey = (LockingEvent) it.next();
			    	UnlockingEvent tmpvalue =map.get(tmpkey);
			    	if(tmpvalue == e)
			    	{
			    		tofind= tmpkey;
			    	}					
				}
			    if(tofind!=null)
			    {
			    	return tofind;
			    }
			    else {
					throw new RuntimeException("seems the matching locking is not registered.");
				}
			}
			else {
				throw new RuntimeException("what type is this event in the query?");
			}
		
		   
	   }
	   
	    static boolean assigned =false; 
		public static void assignSerialNo(CausalGraph cg )// after that, it is easier to judge the order between two events
		{ 
			if(assigned) return;// cache
			Iterator<CriticalEvent> it =cg.getThreadManager().getBeginningEvents().iterator();
			
			while (it.hasNext()) {
				CriticalEvent begin = (CriticalEvent) it.next();
				assignSerialNoPerTh(cg, begin);		
			}
			assigned =true;
			
		}

		private static void assignSerialNoPerTh(CausalGraph cg, CriticalEvent begin) {
			int count =0;
			CriticalEvent tmp = begin;
			while(tmp!=null)
			{
				tmp.setSerialNO(count);
				count++;
				tmp = CausalGraphTraversal.getNextEventLocally(cg, tmp);
			}
			
		}

	public static void main(String[] args) {
			// TODO Auto-generated method stub

		}


}
