package pldi.region;

import soot.Unit;
import soot.dava.toolkits.base.AST.transformations.LoopStrengthener;
import soot.toolkits.graph.*;
import soot.toolkits.graph.pdg.MHGDominatorTree;

import java.util.*;

// *** USE AT YOUR OWN RISK ***
// May Happen in Parallel (MHP) analysis by Lin Li.
// This code should be treated as beta-quality code.
// It was written in 2003, but not incorporated into Soot until 2006.
// As such, it may contain incorrect assumptions about the usage
// of certain Soot classes.
// Some portions of this MHP analysis have been quality-checked, and are
// now used by the Transactions toolkit.
//
// -Richard L. Halpert, 2006-11-30

public class LoopBodyFinder{
	// newly added
    // hommock graph, single head-> loopregion
	
//	private final Set<Set<Object>> loops = new HashSet<Set<Object>>();
	public LoopBodyFinder(Map<Object, Set> head2tails, DirectedGraph g){
		findLoopBody(head2tails, g);
	}
	private void findLoopBody(Map<Object, Set> head2tails, DirectedGraph g){
		Set lrs = LoopAnalyzer.g2loops.get(g);
		if(lrs ==null)
		{
		    lrs  = new HashSet();
		    LoopAnalyzer.g2loops.put(g, lrs);
		}
	    Iterator keyIt	=head2tails.keySet().iterator();
		while (keyIt.hasNext()) {
			Object head = (Object) keyIt.next();
			Set tails  = head2tails.get(head);
			LoopRegion lr  = new LoopRegion();
			lr.setHead(head);
			lr.setBacksrcs(tails);
			
			
			 //============
			MHGDominatorTree  pdom=	new MHGDominatorTree(new MHGPostDominatorsFinder(g));
            DominatorNode dode = pdom.getDode(head);
            DominatorNode paredode = dode.getParent();
            Object parebh = null;
            if(paredode!=null && paredode.getGode()!=null)
            {
            	parebh = paredode.getGode();
            }
            
            lr.setOutsideExit(parebh);
			if(parebh==null) 
				{
				System.out.println("xxx");
				throw new  RuntimeException();
				}
				
            
	        //=========
			InexitsBXB(lr,g);
			
			//===========
			
		
			
			lrs.add(lr);
			//====================================
			
		}
		
		
	}
	
	
	private void InexitsBXB(LoopRegion lr, DirectedGraph g) {		
		backReach4LoopBody(lr,g);
		findExits(lr,g);
		fillXB(lr,g);	
	}
	private void fillXB(LoopRegion lr, DirectedGraph g) {
        
		Set  exits = lr.getInternalExits();
		Set  backsrcs = lr.getBacksrcs();
		
		Set loopbody = lr.getLoopBody();
		Object outsideExit = lr.getOutside();
		Object head = lr.getHead();
		
		List hsuccs  = g.getSuccsOf(head);
		Object iterateHead = null;
		if(hsuccs.size() >=3) throw new RuntimeException();
		for(Object hsucc: hsuccs)
		{
			if(loopbody.contains(hsucc))// not the outside exit
			{
			  iterateHead = hsucc;			
			}		
		}
		
		Stack tmpStack = new Stack();
		List iterateBody = new LinkedList();
		tmpStack.push(iterateHead);
		iterateBody.add(iterateHead);
		//for iterateBody, it is necessary hosting only one path of the loop. 
		// this is possible, iterateBody do not contain all the nat-loop
		// but it is important that the basic profile of iterate is contained,
		// those branched backsrcs would be reduced during the HRG construction
		// (substitute, remove). 
		while(!tmpStack.empty())
		{
			Object pop = tmpStack.pop();
			if(exits.contains(pop)|| backsrcs.contains(pop))
			{
				continue;// do not be recursive any more, and it is already added
			}
			List succs = g.getSuccsOf(pop);
			for(Object succ:succs)
			{
				if(!iterateBody.contains(succ))
				{
					iterateBody.add(succ);
					tmpStack.push(succ);				
				}			
			}
			
			
			
		}
		lr.setIterateBody(iterateBody);
		
	}
	private void findExits(LoopRegion lr, DirectedGraph g) {
		Object head = lr.getHead();
		Set units  = lr.getLoopBody();
		Set exits = lr.getInternalExits();
		if(exits==null) 
			{
			exits = new HashSet();
			lr.setInternalExits(exits);
			}
		for(Object unitObj:units)
		{
			Unit unit = (Unit) unitObj;
	        List succs =		g.getSuccsOf(unit);
		    for(Object succ:succs)
		    {
		    	if(!units.contains(succ))
		    	{
		    		exits.add(unit);
		    		//=====caution:
		    		// unit's certain succ is not in the nat-loop!, so it is an exit
                   
		    	}
		    }
		}
		exits.remove(head);
		
	}
	private void backReach4LoopBody(LoopRegion lr, DirectedGraph g) {
		Set body = lr.getLoopBody();
		Object head = lr.getHead();
		Set tails  = lr.getBacksrcs();
		if(body==null) 
			{
			body = new HashSet();
			lr.setLoopbody(body);
			}
	    Stack<Object> tmpStack = new Stack<Object>();   
		for(Object tail:tails)
		{
			tmpStack.empty();// clear for each tail
			body.add(tail);
			tmpStack.push(tail);
			while (!tmpStack.empty()){
				Object p = tmpStack.pop();
				if(p==head)
				{
					// do not be recursive any more, alreaday in the body, push-time adding
					continue;
				}
				Iterator  predsListIt = g.getPredsOf(p).iterator();
				while (predsListIt.hasNext()){
					Object pred = predsListIt.next();
					if (!body.contains(pred)){
						body.add(pred);
						tmpStack.push(pred);
					}
				}
			}
			
		}
	}	

//	public Set<Set<Object>> getLoopBody(){
//		return loops;
//	}
	
}
