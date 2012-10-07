package soot.jimple.toolkits.thread.synchronizationLP;

import java.util.HashSet;

import soot.Value;


public class ConflictingData {
    // for LockProducer, inspect the conflicting field accessed in each tn.
	public CriticalSection mytn=null;
	public Object data=null;
	public HashSet<TxAndOverlap> conflictingTXandOverlaps= new HashSet<TxAndOverlap>();
	public boolean iamRead= false;
//	public boolean isThreadLocal = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	public boolean sameRepAs(ConflictingData smallbrother) {
	    boolean ret =false;
		boolean and = (mytn == smallbrother.mytn) && (data == smallbrother.data) && (iamRead ==smallbrother.iamRead);
		return ret|and;
	}

}
