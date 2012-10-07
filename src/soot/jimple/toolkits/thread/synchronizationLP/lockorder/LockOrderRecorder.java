/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Navindra Umanee <navindra@cs.mcgill.ca>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.jimple.toolkits.thread.synchronizationLP.lockorder;

import java.util.*;

import org.junit.Assert;

import soot.*;
import soot.jimple.toolkits.thread.synchronizationLP.CriticalSection;
import soot.jimple.toolkits.thread.synchronizationLP.LockProducer;
import soot.options.*;
import soot.toolkits.graph.*;
import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.FlowSet;
import soot.toolkits.scalar.ForwardFlowAnalysis;

/**
 * Find all locals guaranteed to be defined at (just before) a given
 * program point.
 *
 * @author Navindra Umanee
 **/


public class LockOrderRecorder 
{
    FlowSet emptySet = new ArraySparseSet();
    Map<Unit, List> unitToReenterFathers;
    Map<Unit, FlowSet> unitToGenerate ;
     public  Set<LockOrderTriple> noodelView ; 
     public Set<LockOrderTriple> getNoodelView()
     {
    	 Assert.assertTrue(!unitToGenerate.isEmpty());
    	 Iterator<FlowSet> constrainsGen= unitToGenerate.values().iterator();
    	 while (constrainsGen.hasNext()) {
			FlowSet flowSet = (FlowSet) constrainsGen.next();
			Iterator<LockOrderTriple> lotIt = flowSet.iterator();
			while (lotIt.hasNext()) {
				LockOrderTriple lockOrderTriple = (LockOrderTriple) lotIt
						.next();
				noodelView.add(lockOrderTriple);			
			}
		}
    	 return noodelView;
     }

    public CriticalSection _tn; 
    public LockOrderRecorder(UnitGraph graph, CriticalSection tn)
    {
      
        _tn  =tn;
        unitToGenerate = new HashMap<Unit, FlowSet>();
        noodelView = new HashSet<LockOrderTriple>();
        //================
        DominatorsFinder df = new MHGDominatorsFinder(graph);
        unitToReenterFathers =new HashMap<Unit, List>();
        
        // pre-compute generate sets
        for(Iterator unitIt = graph.iterator(); unitIt.hasNext();){
            Unit s = (Unit) unitIt.next();     
            List definedLocks =  new ArrayList();
            for(Iterator domsIt = df.getDominators(s).iterator(); domsIt.hasNext();){
                Unit dom = (Unit) domsIt.next();
                if(dom==s) //the dominate set - itself!
                {
                	continue;
                }
                
                List<Object> locks = LockProducer.v().stmtGrouping.locks4StmtViaGroup(_tn, dom);
                // if dom is not in the tn, it does not have the point-to summary, so no groups, no locks..
                definedLocks.addAll(locks); // no null case..    
            }
            
            unitToReenterFathers.put(s, definedLocks);// put the dominator information for the stmt
        }
    
        //===================accumulate the locks along the data flow framework, have a look at unitToReentrant first!
        Unit2acclocksAnalysis u2acc = new Unit2acclocksAnalysis(graph, _tn);
        //LockOrderRecorder lor = new LockOrderRecorder(csGraph, csInAComp); 
         Map<Object, FlowSet> accOut4unit =  u2acc.getHotMap();
        // compute the lock order constraint without using the data flow framework.
        Iterator<Unit> graphIT= graph.iterator();
        while (graphIT.hasNext()) {
			Unit unit = (Unit) graphIT.next();
			List mylocks = LockProducer.v().stmtGrouping.locks4StmtViaGroup(_tn, unit);
			
		    List<Unit> parents = graph.getPredsOf(unit);	
		 
		    Set<LockOrderTriple> orders_precompute = new HashSet<LockOrderTriple>();
			Iterator<Unit> parentIt = parents.iterator();
			List parentLocks = new ArrayList();
		    while (parentIt.hasNext()) {
				Unit parent = (Unit) parentIt.next();
				FlowSet accOutLocks = accOut4unit.get(parent);			
				Iterator accOUtIt = accOutLocks.iterator();
				while (accOUtIt.hasNext()) {
					Object item = (Object) accOUtIt.next();
					parentLocks.add(item);
				}	
			}
		    
			// it is okay now
			Set<LockOrderTriple> orderConstraints = LockOrderTriple.LockOrdersBetweenLists(parentLocks, mylocks, tn);
			orders_precompute.addAll(orderConstraints);		
		    
		    FlowSet orders_precompute_fs = emptySet.clone();
		    for(LockOrderTriple item : orders_precompute)
		    {
		    	List reentrantLocks = unitToReenterFathers.get(unit);
		    	if(reentrantLocks.contains(item.getBehindLock()))  continue; // renenetrant ignore it
		    	orders_precompute_fs.add(item, orders_precompute_fs);
		    }
		    unitToGenerate.put(unit,orders_precompute_fs );
		    
		}
        //================================now you have the neighbouring order info

   //     System.out.println("after fixpoint, the fresh noodel view of orders is available");
    //    System.out.println("you may want to access it using recorder.getNoodleView()");
    }



  
}
