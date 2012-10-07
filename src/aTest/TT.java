package aTest;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pldi.AHG.AHGAnalyzer;


public class TT {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStringRep4Stack() {
		Stack<String > ss= new Stack<String>();
		ss.push("teacher");
		ss.push("student");
		String res =AHGAnalyzer.getStringRep4Stack(ss);
		assertTrue(res.equals("teacher.student"));
	}

}
