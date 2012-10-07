package aTSE.AHG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.graph.DefaultEdge;

import soot.PointsToSet;
import soot.SootField;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;

public class AHGCriteria {

    String methodname  = "";
    List  argList = new  ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean  trivial(Stack<DefaultEdge> stack)
	{
		
		return true;
	}
	public boolean  trivial_nodebased(PointsToSet root)
	{
		
		return true;
	}
	//accessfield
	public boolean  accessfieldsIn(CodeBlockRWSet atomicsetSE ,Stack<DefaultEdge> stack)
	{
		DefaultEdge curEdge = stack.peek();
		String edgeName  = curEdge.getLabel();		
		PointsToSet parentSet  = (PointsToSet)curEdge.getSource();
		if(hit(atomicsetSE,parentSet,edgeName))
			return true;
		 
		return false;	
	}
	
	private static boolean hit(CodeBlockRWSet atomicsetSE,PointsToSet parentSet, String edgeName) {
		Set fs  =atomicsetSE.getFields();
		for(Object f : fs)
		{
			if(f instanceof SootField)
			{
				SootField sf = (SootField)f;
				if(sf.getName().equals(edgeName))
				{
					PointsToSet aset = atomicsetSE.getBaseForField(f);
					return aset.hasNonEmptyIntersection(parentSet);// if true, then true
				}
			}
			
		}
		return false;
	}

	public boolean  satisfyPathPatterns(Set<String> lgroupRegs,Stack<DefaultEdge> stack)
	{
	    Stack<String > stringStack  = defaultEdge2string(stack);
		String  curfpath = getStringRep4Stack(stringStack);
		if(satisfy(curfpath, lgroupRegs))
		{
			return true;
		}	
		return false;
	}
	
	private Stack<String> defaultEdge2string(Stack<DefaultEdge> stack) {
		Stack<String >  toret  = new  Stack<String>();
		for(int i=0; i< stack.size(); i++)
		{
			DefaultEdge edge  = stack.get(i);
			if(i ==0)
			{
				PointsToSet root  = (PointsToSet)edge.getSource();
				toret.add(getNodeName(root));// the first edge's source-> root node
			}
			toret.add(edge.getLabel());
		}
		
		return toret;
	}
	

	private static String getNodeName(PointsToSet root) {
		return  ""+ ((PointsToSetInternal)root).pointsToSetHashCode();		
	}
	public static String getStringRep4Stack(Stack<String> fpath2) {
		StringBuilder  sb = new StringBuilder("");
        for (String string : fpath2) {
			sb.append(string+".");        	
		}
        String tr = sb.toString();
		return tr.substring(0,tr.length()-1 );// not include the last one
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
	


}
