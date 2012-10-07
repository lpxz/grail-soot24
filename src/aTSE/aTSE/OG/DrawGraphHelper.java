package aTSE.aTSE.OG;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

public class DrawGraphHelper {
	private static HashSet  cache1 = null;
	private static Stack<DefaultEdge>  stack1 = null;
	
	private static HashSet  cache2 = null;
	private static Stack<DefaultEdge>  stack2 = null;
	


	public static void expandXXXMark(String root,
			DirectedPseudograph<String, DefaultEdge> toDrawG) {
		cache1 = new HashSet();
		stack1= new Stack<DefaultEdge>();		
		expandXXXMark0(root, toDrawG);		
	}
	private static void expandXXXMark0(String root,
			DirectedPseudograph<String, DefaultEdge> toDrawG) {
		cache1.add(root);
		Set<DefaultEdge> edges =toDrawG.outgoingEdgesOf(root);
		for(DefaultEdge edge:edges)
		{
			String child = (String)edge.getTarget();
			if(!cache1.contains(child))
			{
				stack1.push(edge);// the leading edges in the stack
			
				colorParentsIfNec(stack1);
				expandXXXMark0(child, toDrawG);
				DefaultEdge edgep = stack1.pop();
			
			}
			else {
				stack1.push(edge);// the leading edges in the stack, note that the node is visited, but the edge is not
			
				colorParentsIfNec(stack1);
				DefaultEdge edgep = stack1.pop();
			
			}
		    
		}
		
	}

	private static void colorParentsIfNec(Stack<DefaultEdge> stack12) {		
	DefaultEdge top=	stack12.peek();
	
	if(top.getLabel().contains(DOTExporter.xxxmarker))
	{
		for(int i=0; i< stack12.size(); i++)// all processed
		{
			DefaultEdge edge = stack12.get(i);
			if(!edge.getLabel().contains(DOTExporter.xxxmarker))
			{
				//System.err.println("xxx");
				edge.setLabel(DOTExporter.xxxmarker+edge.getLabel());
			}
			
		}
	}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Set<String> collectXXXExpr(
			DirectedPseudograph<String, DefaultEdge> drawG, String root) {
		// only path please.
		// the longest xxx path, the short one is simply the subsequence of it.
		cache2 = new HashSet();
		stack2= new Stack<DefaultEdge>();	
		Set<String> exps = new HashSet<String>();
		collectXXXExpr0(root, drawG,exps);	
		return exps;
		
		
		
	}
	private static Set<String> collectXXXExpr0(String root,
			DirectedPseudograph<String, DefaultEdge> toDrawG, Set<String> exps) {
		
		cache2.add(root);
		Set<DefaultEdge> edges =toDrawG.outgoingEdgesOf(root);
		if(edges.size()==0)
		{
			// to stop
			addPath2(stack2, exps);
		}
		for(DefaultEdge edge:edges)
		{
			if(!edge.getLabel().contains(DOTExporter.xxxmarker))
			{
				//  to stop, edge is not currently in the stack
				addPath2(stack2, exps);
				continue;// no recursive inspection.
			}
			String child = (String)edge.getTarget();
			if(!cache2.contains(child))
			{
				stack2.push(edge);// the leading edges in the stack				
				collectXXXExpr0(child, toDrawG, exps);
				stack2.pop();
			}
			else {
				// to stop, edge contains xxx
				stack2.push(edge);
				addPath2(stack2, exps);
				stack2.pop();
			}
		    
		}
		return exps;		
	}
	public static void addPath2(Stack<DefaultEdge> stack22, Set<String> exps) {
		 if (stack22==null|| stack22.size() ==0)
			 return ;
		 String ret = stack2String(stack22);		 
		 exps.add(ret);
		
	}
	public static String stack2String(Stack<DefaultEdge> stack22) {
		StringBuilder sb = new StringBuilder();
		 
		 for(int i=0;i < stack22.size();i++)
		 {
			 String str =( (DefaultEdge)stack22.get(i)).getLabel();		
			 if(str.contains(DOTExporter.xxxmarker))
			 {
				 str = str.substring(DOTExporter.xxxmarker.length());// from 3
			 }
			 sb.append("."+str);
		 }
		 return sb.toString();
	}

}
