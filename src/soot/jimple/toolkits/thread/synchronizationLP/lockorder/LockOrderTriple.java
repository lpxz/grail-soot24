package soot.jimple.toolkits.thread.synchronizationLP.lockorder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import soot.jimple.toolkits.thread.synchronizationLP.CriticalSection;

public class LockOrderTriple {
    Object frontlock;
    Object behindLock ;
    CriticalSection _tn; // necessary?
    
    public LockOrderTriple(Object frontPara , Object behindPara)
    {
    	frontlock= frontPara;
    	behindLock= behindPara;
        _tn =null;
    	
    }
    public LockOrderTriple(Object frontPara , Object behindPara, CriticalSection tnPara)
    {
    	frontlock= frontPara;
    	behindLock= behindPara;

    	_tn = tnPara;
    }
    
    public static Set<LockOrderTriple>  LockOrdersBetweenLists(List front, List behind, CriticalSection tn)
    {
    	Set<LockOrderTriple> set = new HashSet<LockOrderTriple>();
    	for(int i=0;i<front.size();i++)
    	{
    		Object frontlock  = front.get(i);
    		for(int j=0;j<behind.size();j++)
    		{
    			Object behindlock = behind.get(j);
    			LockOrderTriple order = new LockOrderTriple(frontlock, behindlock, tn);// may be repetitive
    			set.add(order);
    		}
    	}
    	return set;
    	
    }
    
    public Object getFrontlock() {
		return frontlock;
	}
	public Object getBehindLock() {
		return behindLock;
	}
	public CriticalSection get_tn() {
		return _tn;
	}
	public static Set<LockOrderTriple>  LockOrdersBetweenLists(List front, List behind)
    {
          return LockOrdersBetweenLists(front, behind, null);
    	
    }
    
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
