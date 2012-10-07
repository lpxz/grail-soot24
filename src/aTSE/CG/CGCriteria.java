package aTSE.CG;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pldi.locking.SynchronizedRegionFinder;
import pldi.locking.SynchronizedRegionFlowPair;

//import org.jgrapht.graph.DefaultEdge;

import soot.Body;
import soot.PatchingChain;
import soot.PointsToSet;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
//import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.scalar.FlowSet;
import soot.util.Chain;

public class CGCriteria {

    private static final boolean optionOpenNesting = false;
	String methodname  = "";
    List  argList = new  ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean  trivial(Stack<Edge> stack)
	{
		
		return true;
	}
	//interestingOnly
	public boolean  interestingOnly(Stack<Edge> stack)
	{
		Edge edge = stack.peek();
		SootMethod parentMethod = (SootMethod)edge.getSrc();
		SootMethod currMethod = (SootMethod)edge.getTgt();
		 
		if(isInteresting(currMethod))
			return true;
   
		
		
		return true;
	}
	private boolean isInteresting(SootMethod currMethod) {
		if(!currMethod.getDeclaringClass().isApplicationClass())  return false;
		if(currMethod.isAbstract()) return  false;
		if(currMethod.isNative()) return false;
		if(currMethod.getName().equals(SootMethod.constructorName)) 
			{
			return false;
			}

			
		if(currMethod.getName().equals(SootMethod.staticInitializerName)) return false;
		
		
		return true;
	}
	public boolean  trivial_nodebased(SootMethod root)
	{
		
		return true;
	}
	
	//sync_nodebased
	public boolean  sync_nodebased(SootMethod root)
	{
		if(!isInteresting(root)) return false;
		if(getSynBM(root).size()>0) // must be some sync		
		return true;
		return false;
	}
	
	
//	//accessfield
//	public boolean  accessfieldsIn(CodeBlockRWSet atomicsetSE ,Stack<DefaultEdge> stack)
//	{
//		DefaultEdge curEdge = stack.peek();
//		String edgeName  = curEdge.getLabel();		
//		PointsToSet parentSet  = (PointsToSet)curEdge.getSource();
//		if(hit(atomicsetSE,parentSet,edgeName))
//			return true;
//		 
//		return false;
//		
//		
//		
//	}
//	
//	private static boolean hit(CodeBlockRWSet atomicsetSE,PointsToSet parentSet, String edgeName) {
//		Set fs  =atomicsetSE.getFields();
//		for(Object f : fs)
//		{
//			if(f instanceof SootField)
//			{
//				SootField sf = (SootField)f;
//				if(sf.getName().equals(edgeName))
//				{
//					PointsToSet aset = atomicsetSE.getBaseForField(f);
//					return aset.hasNonEmptyIntersection(parentSet);// if true, then true
//				}
//			}
//			
//		}
//		return false;
//	}
	
	public boolean  nestedSync(Stack<Edge> stack)
	{  // judge the edges are in the source method's  synchronization blocks. lock allocation approach.
		// and the last callee contains synchornization block (no matter whether there are any invocations)
		// it is very simple, so that i do not want to write it..
		
		// note that I did not consider the intra-procedural nesting!, you can easily get it with one extra pass
		// using syncregionFinder.
		int  nested =0;

		
		for(int i=0;i< stack.size();i++)
		{
		   Edge e=	stack.get(i);
		   SootMethod srcM = (SootMethod)e.getSrc();
		   SootMethod tgtM = (SootMethod)e.getTgt();
		   if(!isInteresting(tgtM)) 
		   {continue;}
		   
		   
		   Unit srcU = e.srcUnit();
		   
		   Set syncBM =  getSynBM(srcM);// if the method is syncrhonzied,  returns the whole body
		   if(syncBM.contains(srcU))
		   {
			   nested ++;
		   }
		   
		}
		
		//============= the last callee
		Edge elast = stack.peek();
		SootMethod mlast = (SootMethod)elast.getTgt();
		
		if(isInteresting(mlast) && getSynBM(mlast).size()!=0) 
		{
			nested++;
		}
		
		//===============
		if(nested >= 2)
		{
			return true;
		}
		return false;

		
		
		
	}
	
private Set getSynBM(SootMethod srcM) {
		//throw new RuntimeException();
	Set toret = new HashSet<Unit>();
	if(srcM.isSynchronized())
	{
		 try {
			 PatchingChain<Unit> units =srcM.getActiveBody().getUnits();
			 toret.addAll(units);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	else { // may be SB
		Set toret0= getSyncBM0(srcM);
		toret.addAll(toret0);
		
		
	}
	return toret;
	
	
	}
	private Set getSyncBM0(SootMethod sm) {
		Set toret = new HashSet<Unit>();
		if(!sm.hasActiveBody())
		{
			return toret;
		}
		else {
            Body b = sm.getActiveBody();            
	    	ExceptionalUnitGraph eug = new ExceptionalUnitGraph(b);
			SynchronizedRegionFinder ta = new SynchronizedRegionFinder(eug, b,  optionOpenNesting);			
			Chain units = b.getUnits();
			Unit lastUnit = (Unit) units.getLast();
			FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
			if(fs!=null)
			{
				
			    for (Iterator iterator = fs.iterator(); iterator
						.hasNext();) {
			    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
			    	HashSet<Unit> us =srfp.tn.units;
			    	toret.addAll(us);
//			    	System.out.println("==============\n tn units (no order)");
//					for (Iterator iterator2 = us.iterator(); iterator2
//							.hasNext();) {
//						Unit unit = (Unit) iterator2.next();
//						System.out.println(unit);
//						
//					}
//					System.out.println("==============\n");
			    	
					
				}
			}

			
		}

		
		
	return toret;
}
	//	private Stack<SootMethod> edge2Method(Stack<Edge> stack) {
//		Stack<SootMethod > toret = new Stack<SootMethod>();
//		for(int i=0;i<stack.size(); i++)		
//		{
//		  Edge e =   stack.get(i);
//		  if(i==0)
//		  {
//			 SootMethod root = (SootMethod)  e.getSrc();
//			 toret.push(root);
//		  }
//		  SootMethod sm = (SootMethod)e.getTgt();
//		  toret.push(sm);
//		}
//	// TODO Auto-generated method stub
//	return toret;
//}
	public boolean  satisfyPathPatterns(Set<String> lgroupRegs,Stack<Edge> stack)
	{
	    Stack<String > stringStack  = defaultEdge2string(stack);
		String  curfpath = getStringRep4Stack(stringStack);
		if(satisfy(curfpath, lgroupRegs))
		{
			return true;
		}	
		return false;
	}
	
	private Stack<String> defaultEdge2string(Stack<Edge> stack) {
		Stack<String >  toret  = new  Stack<String>();
		for(int i=0; i< stack.size(); i++)
		{
			Edge edge  = stack.get(i);
			if(i ==0)
			{
				SootMethod root  = (SootMethod)edge.getSrc();
				toret.add(getNodeName(root));// the first edge's source-> root node
			}
			toret.add(getEdgeLabel(edge));
		}
		
		return toret;
	}


	private static String getNodeName(SootMethod root) {
		return  root.getName();		
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
	
	private static String getEdgeLabel(Edge edge) {
		
		String toret  = "";
		try {
			toret= edge.srcStmt().toString();
		} catch (Exception e) {
			toret = edge.kind().name();
		}
		return toret;
	}

}
