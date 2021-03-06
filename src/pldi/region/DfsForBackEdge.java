package pldi.region;

import soot.toolkits.scalar.*;
import soot.toolkits.graph.*;
import soot.toolkits.graph.pdg.MHGDominatorTree;
import soot.jimple.toolkits.thread.mhp.stmt.JPegStmt;
import soot.tagkit.*;
import soot.util.*;

import java.io.File;
import java.util.*;
// richard's imple is really ....ai...
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

public class DfsForBackEdge{
	
	private final Map<Object, Object> backEdges = new HashMap<Object, Object>();    
	private final Set<Object> gray = new HashSet<Object>();
	private final Set<Object> black = new HashSet<Object>();
	private final MHGDominatorsFinder domFinder;
	
	public DfsForBackEdge(Chain chain, DirectedGraph peg){
		//MHGDominatorTree  dom=	new MHGDominatorTree);
		domFinder = new MHGDominatorsFinder(peg);//new DominatorsFinder(chain,peg);
		Iterator it = chain.iterator();
		dfs(it, peg);
		//testBackEdge();
	}
	private void dfs(Iterator it, DirectedGraph g){	
		// Visit each node
		{
			
			while (it.hasNext()){
				Object s =it.next();
				if (!gray.contains(s)){
					
					visitNode(g, s);
				}
			}
			
		}
		
	}
	
	private void visitNode(DirectedGraph g, Object s ){
		//	System.out.println("s is: "+ s);
		gray.add(s);
		Iterator it = g.getSuccsOf(s).iterator();
		
		if (g.getSuccsOf(s).size()>0){
			while (it.hasNext()){
				Object succ = it.next();
				if (!gray.contains(succ)){					
					visitNode(g, succ);
				}
				else{
					//if the color of the node is gray, then we found a retreating edge
					if (gray.contains(succ) && !black.contains(succ)){
						/* If succ is in s's dominator list, 
						 * then this retreating edge is a back edge.
						 */
						List dominators = domFinder.getDominators(s);

						if (dominators.contains(succ)){
							System.out.println("s is "+s);
							System.out.println("succ is "+succ);
							backEdges.put(s, succ);
							
						}
						else {
							System.out.println();
							throw new RuntimeException();
						}
					}
					
				}
			}
		}
		black.add(s);
		
	}
	
	public Map<Object, Object> getBackEdges(){
		return backEdges;
	}
	
	
}
