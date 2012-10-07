package AVfix.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.graph.DefaultEdge;

import AVfix.edge.CallEdge;
import AVfix.edge.LocalEdge;
import AVfix.edge.ReturnEdge;
import AVfix.edge.abstractclass.ControlEdge;
import AVfix.manager.AVfixUtil;
import AVfix.node.CommonLocalStatement;
import AVfix.node.EntryStatement;
import AVfix.node.ExitStatement;
import AVfix.node.InvokeBeginStatement;
import AVfix.node.InvokeEndStatement;
import AVfix.node.abstractclass.Statement;


import soot.Body;
import soot.SootMethod;
import soot.jimple.Stmt;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ZonedBlockGraph;

public class CSGraphGen {
	static boolean unitgraph =true;
//	public static HashMap<SootMethod, PetriNet> cache = new HashMap<SootMethod, PetriNet>();
	public static HashMap<EntryStatement, ExitStatement> entry2exit = new HashMap<EntryStatement, ExitStatement>();
	
	
	public static EntryStatement formCSMethodLocally(StackTraceElement cur, CSGraph csGraph,
			List<StackTraceElement> ctxtStack) {
		String className = cur.getClassName();
		String mName = cur.getMethodName();
		String filename = cur.getFileName();
		int eleLineNO = cur.getLineNumber();
		
		Body bb= null;
		
		bb =AVfixUtil.search4MethodBodyInClass(mName, className);
		if(bb==null)
		{
			// two or more methods owning the same name exist. They can not be main or run, 
			// so the lastCommonIndex can not be 0
			
			StackTraceElement secondLast = ctxtStack.get(ctxtStack.size() -1);
			String secondClass = secondLast.getClassName();
			String secondMethod = secondLast.getMethodName();
			if(eleLineNO >0)
			{
				Stmt hitCS = AVfixUtil.search4CallSiteStmt(secondClass, secondMethod, className, mName, filename,eleLineNO);	
				if(hitCS!=null)
				{
					//sig= hitCS.getInvokeExpr().getMethod().getSignature();
					SootMethod sm = hitCS.getInvokeExpr().getMethod();
					if(!sm.hasActiveBody()) sm.retrieveActiveBody();
					bb = sm.getActiveBody();
				}
			}			
		}
		if(bb == null)
			throw new RuntimeException();
		EntryStatement entry = formPart4M(bb, csGraph, ctxtStack);		
		return entry;		
	}

	
	
	static HashMap<Stmt, Statement> u2n = new HashMap<Stmt, Statement>();
	public static EntryStatement formPart4M(Body bb, CSGraph csGraph, List<StackTraceElement> ctxtStack )
    {
		SootMethod sm = bb.getMethod();	
		DirectedGraph ug= null;
		if(unitgraph)
		{
			 ug = new BriefUnitGraph(bb);	
		}
		else {
			ug = new ZonedBlockGraph(bb);// it is just blockCFG...
		}		
		
    	
    	List headsList = ug.getHeads();	  
    	List tails = ug.getTails();
    	EntryStatement start = createAndAddEntryPlace( bb, csGraph, ctxtStack);
    	ExitStatement end = createAndAddExitPlace(bb, csGraph, ctxtStack, start);    
    	entry2exit.put(start, end);
    	
    	u2n.clear();
    	for(Object unit : headsList)// form the single entry part
    	{
    		CommonLocalStatement p = createAndAddStmt((Stmt)unit,csGraph, ctxtStack, start);    	
    		u2n.put((Stmt)unit, p);
    		addN2N(csGraph,start, p);
    	}
    	for(Object unit : tails)
    	{
    		CommonLocalStatement p = createAndAddStmt((Stmt)unit,csGraph, ctxtStack, start);  
    		u2n.put((Stmt)unit, p);
    		addN2N(csGraph,p,  end);    		
    	}
    	
    	
    	
    	for(Object unit : headsList)
    	{// u2n help you to get those created nodes...
    		 formPart4M0(ug, unit, csGraph, ctxtStack, start, u2n); // form the main part of the petri net
    	}    	
    	return start;
    }
	

	private static void addN2N(CSGraph csGraph, Statement start, Statement p) {
		if(csGraph.coreG.containsVertex(start) &&  csGraph.coreG.containsVertex(p))
		{
			csGraph.coreG.addEdge_edgetype_lpxz(start, p, LocalEdge.class);
		}
		else {
			throw new RuntimeException("wrong");
		}		
	}

	public static Stack systemStack = new Stack();
    public static Set visited = new HashSet();   

    
    private static void formPart4M0(DirectedGraph ug, Object unit, CSGraph csGraph,
    		List<StackTraceElement> ctxtStack,
    		EntryStatement start, HashMap<Stmt, Statement> tmpu2n) {
        systemStack.clear();
        visited.clear();
		systemStack.push(unit);	
    	if(!visited.contains(unit))
    	{
    	    visited.add(unit);
    	}
	//	Place startPlace = createOrgetPlace(unit);
		
		while(!systemStack.isEmpty())
		{
		    Object pop =systemStack.pop();			    
		    List children = ug.getSuccsOf(pop);
		    for(int i = children.size()-1; i>=0; i--)
		    {
		    	Object child = children.get(i);	
		    	Statement parentStmt = null;
		    	Statement childStmt = null;
		        
		    	if(tmpu2n.containsKey(pop))
		    	{
		    		parentStmt = tmpu2n.get(pop);
		    	}else {
					parentStmt = createAndAddStmt((Stmt)pop, csGraph, ctxtStack, start);
				}
		    	
		    	if(tmpu2n.containsKey(child))
		    	{
		    		childStmt = tmpu2n.get(child);
		    	}else {
		    		childStmt = createAndAddStmt((Stmt)child, csGraph, ctxtStack, start);
				}
		    	
		    	addN2N(csGraph,parentStmt, childStmt);
		    	
		    	
		    	
		    	
		    	if(!visited.contains(child))
		    	{
		    	    visited.add(child);
		    		systemStack.push(child);				    		
		    	}
		    }
		    
		}					
	}


	private static EntryStatement createAndAddEntryPlace( Body bb, CSGraph csGraph, List<StackTraceElement> ctxtStack) {
        EntryStatement entry = new EntryStatement();
        entry.setStes(AVfixUtil.snapshot(ctxtStack));
        entry.setMsig(bb.getMethod().getSignature());
        csGraph.coreG.addVertex(entry);        
	    return entry;
	    
	}
    
    private static ExitStatement  createAndAddExitPlace( Body bb, CSGraph csGraph, List<StackTraceElement> ctxtStack, EntryStatement start) {
    	ExitStatement exit = new ExitStatement();
    	exit.setStes(start.getStes());
    	exit.setMsig(bb.getMethod().getSignature());
    	csGraph.coreG.addVertex(exit);
    	return exit;
	}
    
	private static CommonLocalStatement createAndAddStmt(Stmt unit,
			CSGraph csGraph, List<StackTraceElement> ctxtStack,
			EntryStatement start) {
		CommonLocalStatement cls = new CommonLocalStatement();
		cls.setStes(start.getStes());
		cls.setMsig(start.getMsig());
		cls.setJimpleStmt(unit);	
		csGraph.coreG.addVertex(cls);
		return cls;
	}


    public static  void remoteIssues(CSGraph csGraph, CommonLocalStatement invokeNode, EntryStatement entry,
			ExitStatement exit) {
    	InvokeBeginStatement ib = new InvokeBeginStatement();
    	ib.setComplete(invokeNode);
    	InvokeEndStatement ie = new InvokeEndStatement();
    	ie.setComplete(invokeNode);
       
        
		Set<ControlEdge> inEs =csGraph.coreG.incomingEdgesOf(invokeNode);
    	for(ControlEdge edge : inEs)
    	{
    		if(edge instanceof LocalEdge)
    		{
    			Object sourceObject =edge.getSource();
    			csGraph.coreG.addEdge_edgetype_lpxz((Statement)sourceObject, ib, LocalEdge.class);    
    			csGraph.coreG.removeEdge((Statement)sourceObject, invokeNode);
    		}
    	}
    	
    	Set<ControlEdge> outEs = csGraph.coreG.outgoingEdgesOf(invokeNode);
    	for(ControlEdge edge : outEs)
    	{
    		if(edge instanceof LocalEdge)
    		{
    			Object tgt = edge.getTarget();
    			csGraph.coreG.addEdge_edgetype_lpxz( ie, (Statement)tgt, LocalEdge.class);    
    			csGraph.coreG.removeEdge( invokeNode, (Statement)tgt);
    		}
    		
    	}
    	csGraph.coreG.removeVertex(invokeNode);
    	
    	csGraph.coreG.addEdge_edgetype_lpxz(ib, entry, CallEdge.class);
    	csGraph.coreG.addEdge_edgetype_lpxz(exit, ib, ReturnEdge.class);		
	}

}
