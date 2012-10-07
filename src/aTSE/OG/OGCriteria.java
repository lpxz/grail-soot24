package aTSE.OG;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;

import pldi.locking.SynchronizedRegionFinder;
import pldi.locking.SynchronizedRegionFlowPair;

//import org.jgrapht.graph.DefaultEdge;

import soot.Body;
import soot.PatchingChain;
import soot.PointsToSet;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;

import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class OGCriteria {

	private static final boolean optionOpenNesting = false;
	String methodname = "";
	
	List argList = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	private boolean isInteresting(Object root) {

		return true;
	}
	
	//donothing
	public boolean trivial( Stack stack, Object source, Object target)
	{
		return true;	
	}
	//donothing
	public boolean interestingOnly( HashMap<Object, HashSet> setmap,Stack stack, Object source, Object target)
	{
		Object oedge = stack.peek();
		String edgeName = getEdgeLabel(oedge) ;// already set, do nto worry	
		HashSet modFields = setmap.get(source);
		if(modFields==null) return false;
		if(modFields.contains(edgeName))// note that, the field format in setmap= the field format in OG reflection. short form
		{
			return true;
		}
		else {
			return false;
		} 
	
	}
	//interestingOnly4path
	
	
	
		public boolean interestingOnly4path( Set<String> exps,Stack stack, Object source, Object target)
	{
		if(stack==null || stack.size() ==0) return false;
		String ret =stack2String(stack);
        Iterator it = exps.iterator();
        boolean subOfAny=false;
        while (it.hasNext()) {
			String exp = (String) it.next();
			if(exp.contains(ret))
			{
				subOfAny=true;
		        return subOfAny;
			}			
		}
        return subOfAny;
        }
	

	private String stack2String(Stack stack22) {
		StringBuilder sb = new StringBuilder();		 
		
		 for(int i=0;i < stack22.size();i++)
		 {
			 Object obj  = stack22.get(i);
			 String str =getEdgeLabel(obj);
			 sb.append("."+str);
		 }
		 return sb.toString();
	}



	private String getOName(Object source) {
		
		return OGAction.getOName(source);
	}

	public boolean trivial_nodebased(Object root) {

		return true;
	}

	public boolean satisfyPathPatterns(Set<String> lgroupRegs, Stack stack) {
		Stack<String> stringStack = defaultEdge2string(stack);
		String curfpath = getStringRep4Stack(stringStack);
		if (satisfy(curfpath, lgroupRegs)) {
			return true;
		}
		return false;
	}

	private Stack<String> defaultEdge2string(Stack stack) {
		Stack<String> toret = new Stack<String>();
		for (int i = 0; i < stack.size(); i++) {
			Object  oedge = stack.get(i);
			String elabel ="";
			elabel = getEdgeLabel(oedge);
			toret.add(elabel);// the first edge's source-> root node

		}

		return toret;
	}

	public static String getStringRep4Stack(Stack<String> fpath2) {
		StringBuilder sb = new StringBuilder("");
		for (String string : fpath2) {
			sb.append(string + ".");
		}
		String tr = sb.toString();
		return tr.substring(0, tr.length() - 1);// not include the last one
	}

	private static boolean satisfy(String curfpath, Set<String> groupRegs) {
		// System.out.println("now:  "+curfpath);
		boolean ret = false;
		for (Iterator iterator = groupRegs.iterator(); iterator.hasNext();) {
			String fpathreg2 = (String) iterator.next();
			Pattern p = Pattern.compile(fpathreg2);
			Matcher m = p.matcher(curfpath);
			boolean b = m.matches();
			ret = ret || b;

		}

		return ret;
	}

	private static String getEdgeLabel(Object oedge) {

		return OGAction.getEdgeLabel(oedge);

	}
	
//	

}
