package aTSE.AHG;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;



import soot.PointsToSet;
import soot.jimple.toolkits.thread.mhp.DfsForBackEdge;


/*
 * the rule of group specification:
 * groups are seperated by caret
 * each group has several rule/filters, those filters are just java regular expression for field sequences. 
 * for example: teacher.a.[^b]*.f 
 * 
 * */

public class AHGPathSelector {

	
	//static String fpathreg = "teacher.a.[^b]*.f";// regular expression please
    static Set visited  = new  HashSet();
    static Stack  stack = new  Stack();
    
    static Set   hitSet = null;
	public static void main(String[] args) {
		//===================
	    readGroupRule("groups.spec");
		
		//==================
		DirectedPseudograph<String, DefaultEdge>  g = aGraph();
		String root = "teacher";
		Set<String> lgroupRegs= new HashSet<String>();
		lgroupRegs.add("teacher.a.[^b]*.f");
		Set lhits= getHitNodes(g, root, lgroupRegs);
	}

	//
	public static  List<Set<String>>  readGroupRule(String filename)
	{
		List<Set<String>> setL= new  ArrayList<Set<String>>();
		Set<String > firstgroup = new  HashSet<String>();
		setL.add(firstgroup);
		
		FileInputStream fStream;
		try {
			fStream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fStream);
			BufferedReader br = new  BufferedReader(new InputStreamReader(in));
			String strLine ;
			while((strLine=br.readLine())!=null)
			{
				int leng= strLine.length();
//				System.out.println(strLine);
//				System.out.println(leng);
				if(leng==0)// huan hang
				{
					Set<String > newgroup = new  HashSet<String>();
					setL.add(newgroup);				   
				}
				else {
					Set<String > newestGroup = setL.get(setL.size()-1);
				    newestGroup.add(strLine);
				}
				// System.out.println(strLine);
				
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return setL;
	}
	

	private static Set getHitNodes(DirectedPseudograph<String, DefaultEdge> g,
			String root, Set<String> groupRegs) {
		hitSet = new  HashSet();
		
		stack.push(root);
		dfs(g, root, groupRegs);//root is required
		for (Iterator iterator = hitSet.iterator(); iterator.hasNext();) {
			Object  hit =  iterator.next();
			System.out.println(hit);			
		}
		return hitSet;
	}



	private static void dfs(DirectedPseudograph<String, DefaultEdge> g, String root, Set<String> groupRegs) {
		Set<DefaultEdge> edges = g.outgoingEdgesOf(root);
		for (Iterator iterator = edges.iterator(); iterator.hasNext();) {
			DefaultEdge defaultEdge = (DefaultEdge) iterator.next();
			String target = (String)defaultEdge.getTarget();
			String flabel = defaultEdge.getLabel();
			if(!visited.contains(target))
			{
				visited.add(target);
				stack.push(flabel);		
				// current path satisfy fpath?
				String  curfpath = getStringRep4Stack(stack);
				if(satisfy(curfpath, groupRegs))
				{
					hitSet.add(target);
				}
				dfs(g, target,groupRegs);		
				stack.pop();
			}
			else {
				stack.push(flabel);// multiple edges... not go into, but still need to process this edge 
				String  curfpath = getStringRep4Stack(stack);
				if(satisfy(curfpath, groupRegs))
				{
					hitSet.add(target);
				}
				stack.pop();
			}			
		}
		
	}
	private static boolean satisfy(String curfpath, Set<String> groupRegs) {
		//System.out.println("now:  "+curfpath);
		boolean ret= false;
		for (Iterator iterator = groupRegs.iterator(); iterator.hasNext();) {
			String fpathreg2 = (String) iterator.next();
			Pattern p = Pattern.compile(fpathreg2);
			Matcher m = p.matcher(curfpath);
			boolean b =m.matches();
			ret=ret|| b;
			
		}

		
		return ret;
	}
	
	




	public static String getStringRep4Stack(Stack<String> fpath2) {
		StringBuilder  sb = new StringBuilder("");
        for (String string : fpath2) {
			sb.append(string+".");        	
		}
        String tr = sb.toString();
		return tr.substring(0,tr.length()-1 );// not include the last one
	}



	private static DirectedPseudograph<String, DefaultEdge>  aGraph() {
		DirectedPseudograph<String, DefaultEdge> g =
			 new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);// 
		 g.addVertex("teacher");
		 g.addVertex("a");
		 DefaultEdge e1= new DefaultEdge();
		 e1.setLabel("a");
		 g.addEdge("teacher", "a", e1);
		 
		 g.addVertex("b");
		 DefaultEdge e2= new DefaultEdge();
		 e2.setLabel("b");
		 g.addEdge("a", "b", e2);
		 
		 g.addVertex("c");
		 DefaultEdge e3= new DefaultEdge();
		 e3.setLabel("c");
		 g.addEdge("b", "c", e3);
		 
		 
		 g.addVertex("d");
		 DefaultEdge e4= new DefaultEdge();
		 e4.setLabel("d");
		 g.addEdge("c", "d", e4);
		 
		 g.addVertex("e");
		 DefaultEdge e5= new DefaultEdge();
		 e5.setLabel("e");
		 g.addEdge("a", "e", e5);
		 
		 g.addVertex("fuck");
		 DefaultEdge e6= new DefaultEdge();
		 e6.setLabel("f");
		 g.addEdge("e", "fuck", e6);
		 
		return g;
	}

}
