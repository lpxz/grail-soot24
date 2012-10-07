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

public class LoopBodyFinderBak{
	// newly added

	private final Stack<Object> stack = new Stack<Object>();   
	private final Set<Set<Object>> loops = new HashSet<Set<Object>>();
	public LoopBodyFinderBak(Map<Object, Object> backEdges, DirectedGraph g){
		findLoopBody(backEdges, g);
	}
	private void findLoopBody(Map<Object, Object> backEdges, DirectedGraph g){
		Set maps = backEdges.entrySet();
		for(Iterator iter=maps.iterator(); iter.hasNext();){
			Map.Entry entry = (Map.Entry)iter.next();
			Object tail = entry.getKey();
			//Tag tag = (Tag)key.getTags().get(0);
			// System.out.println("---key=  "+tag+" "+key);
			Object  head  = entry.getValue();
			Set<Object> loopBody = finder(tail, head, g); 
			
			
			
			 //============
				MHGDominatorTree  pdom=	new MHGDominatorTree(new MHGPostDominatorsFinder(g));
	            DominatorNode dode = pdom.getDode(head);
	            DominatorNode paredode = dode.getParent();
	            Object parebh = null;
	            if(paredode.getGode()!=null)
	            {
	            	parebh = paredode.getGode();
	            }
	            
		     //=========
			//===================================, set lr & its children
			LoopRegion lr  = new LoopRegion();
			lr.setHead(head);
			//lr.setBacksrc(tail);// once there is a field called backsrc, as: per packsrc a loop.
			lr.setOutsideExit(parebh);
			if(parebh==null) throw new  RuntimeException();
			lr.setLoopbody(loopBody);
//			List iterateBody = new LinkedList();
//			TOFIX
//			lr.setIterateBody(iterateBody);
			//=====================================
			
			Set lrs = LoopAnalyzer.g2loops.get(g);
			if(lrs ==null)
			{
			    lrs  = new HashSet();
			    LoopAnalyzer.g2loops.put(g, lrs);
			}
			
			lrs.add(lr);
			//====================================
			
			
			
			loops.add(loopBody);
		}
		
	}
	
	
	private Set<Object> finder(Object tail, Object head, DirectedGraph g){
		Set<Object> loop = new HashSet<Object>();
		stack.empty();
		loop.add(head);
		insert(tail, loop);
		while (!stack.empty()){
			Object p = stack.pop();
			Iterator  predsListIt = g.getPredsOf(p).iterator();
			while (predsListIt.hasNext()){
				Object pred = predsListIt.next();
				insert(pred, loop);
			}
		}
		return loop;
	}
	
	private void insert(Object m, Set<Object> loop){
		if (!loop.contains(m)){
			loop.add(m);
			stack.push(m);
		}
	}
	public Set<Set<Object>> getLoopBody(){
		return loops;
	}
	
}
