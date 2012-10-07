package AVdetect.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import soot.toolkits.scalar.Pair;

import AVdetect.eventnode.abstractclass.CriticalEvent;

public class MemoryManager {
	//transparent
	public static Object nullObject = new Object();
	private  long lastMemId = -1;
	private  HashMap<Pair, Long> internalMap = new HashMap<Pair, Long>();
	public synchronized  long getMemID(Object base,int fieldCode )// array's fieldcode is unique
	{
		Pair p = new Pair(base, fieldCode);//  internal, transparent to outside
		if(!internalMap.containsKey(p))
		{
			internalMap.put(p, ++lastMemId);
			
		}
		return ((Long)internalMap.get(p)).longValue();
	}
	public  long getMemID(int fieldCode)// static
	{
	  return getMemID(nullObject,fieldCode);
	}
	
	public  long getMemID(Object base)// monitor, thread etc, not fields at all, pure objects
	{
	  return getMemID(base, -1);
	}
	
	public Pair getMem(long id)
	{
		Iterator<Pair> pit = internalMap.keySet().iterator();
		while (pit.hasNext()) {
			Pair pair = (Pair) pit.next();
			Long l =internalMap.get(pair);
			if(l.longValue() ==id)
			{
				return pair;
			}
			
		}
		return null;
	}
	public  HashMap<Long, CriticalEvent> memory2lastEvent= new HashMap<Long, CriticalEvent>();
	   public  void updateLastEvent4Memory(long mid , CriticalEvent e)
	   {
		   memory2lastEvent.put(mid, e);
	   }
	   
	   public  CriticalEvent getLastEventOfMemory(long mid)
	   {
		   return memory2lastEvent.get(mid);
	   }
	   
	   
	   
		public static void main(String[] args) {

		}

   
}
