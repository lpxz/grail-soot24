package soot.jimple.toolkits.thread.synchronizationLP.DataView;

import java.util.List;
import java.util.Set;

import soot.jimple.toolkits.thread.synchronization.LockableReferenceAnalysis;
import junit.framework.Assert;
import junit.framework.TestCase;

public class AnodeDataGroupingTest extends TestCase {
    public static AnodeDataGrouping anodeG= null;
	protected void setUp() throws Exception {
		super.setUp();
		 anodeG= new AnodeDataGrouping();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

//	public void testLock4Group() {
//		fail("Not yet implemented");
//	}
//
//	public void testLocks4DataViaGroup() {
//		fail("Not yet implemented");
//	}



	public void testWhichGroups() {
	     List<Set<Object>> listH = anodeG.whichGroups("hello");
	     listH = anodeG.whichGroups("hello");
	     
	     List<Set<Object>> listW = anodeG.whichGroups("world");
	     Assert.assertTrue(listH.size()==1);
	     Assert.assertTrue(anodeG.lock4Group(listH.get(0))== anodeG.locks4DataViaGroup("hello").get(0));
	     
	     
	    
	    
	    
	}


}
