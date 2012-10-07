package org.jgrapht.graph;

import java.util.List;

import junit.framework.TestCase;

public class BiPartitegraphTest extends TestCase {

    public static BiPartitegraph biPartitegraph=null;
	protected void setUp() throws Exception {
		super.setUp();
		biPartitegraph=BiPartitegraph.toyGraph();
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	



	public void testWeaklyConnectedComponents() {
	//	fail("Not yet implemented");
		List list =biPartitegraph.weaklyConnectedComponents();
	  System.out.println();
	}

	public void testWeaklyConnectedComponentsOnX() {
		//fail("Not yet implemented");
		List list = biPartitegraph.weaklyConnectedComponentsOnX();
		System.out.println();
	}

	public void testWeaklyConnectedComponentsOnY() {
		List list = biPartitegraph.weaklyConnectedComponentsOnY();
		System.out.println();
	}






}
