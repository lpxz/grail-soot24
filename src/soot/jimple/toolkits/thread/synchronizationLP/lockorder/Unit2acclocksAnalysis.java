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


import soot.*;
import soot.jimple.Stmt;
import soot.jimple.toolkits.thread.synchronizationLP.CriticalSection;
import soot.jimple.toolkits.thread.synchronizationLP.LockProducer;
import soot.options.*;
import soot.toolkits.graph.*;
import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.FlowSet;
import soot.toolkits.scalar.ForwardFlowAnalysis;
import soot.toolkits.scalar.Pair;

/**
 * Find all locals guaranteed to be defined at (just before) a given
 * program point.
 *
 * @author Navindra Umanee
 **/


public class Unit2acclocksAnalysis extends ForwardFlowAnalysis
{
    FlowSet emptySet = new ArraySparseSet();

    public Map<Object,FlowSet> unit2accOutLocks  = new HashMap();
    public Map<Object,FlowSet> getHotMap()
    {
    	return unit2accOutLocks;
    }
    public CriticalSection _tn; 
    public Unit2acclocksAnalysis(UnitGraph graph, CriticalSection tn)
    {
        super(graph);
        _tn  =tn; 
       unit2accOutLocks.clear();
       doAnalysis();
        
        //============
   //     System.out.println("after fixpoint, the fresh noodel view of orders is available");
    //    System.out.println("you may want to access it using recorder.getNoodleView()");
    }

    /**
     * All INs are initialized to the empty set.
     **/
    protected Object newInitialFlow()
    {
        return emptySet.clone();
    }

    /**
     * IN(Start) is the empty set
     **/
    protected Object entryInitialFlow()
    {
        return emptySet.clone();
    }

    /**
     * OUT is the same as IN plus the genSet.
     **/
    protected void flowThrough(Object inValue, Object unit, Object outValue)
    {
        FlowSet
            in = (FlowSet) inValue,
            out = (FlowSet) outValue;
        
        
        FlowSet acquireLocks = emptySet.clone();
        
        List<Object> locks = LockProducer.v().stmtGrouping.locks4StmtViaGroup(_tn, (Unit)unit);
        for(Object oo:locks)
        {
        	acquireLocks.add(oo, acquireLocks);
        }
        in.union(acquireLocks, out);//unitToGenerate.get(unit)
        //============if this is the end of the outermost tn, should delete all the locks 
        if(LockProducer.v().outerMostCSList.contains(_tn))
        {
        	// we will meet with the outermost region's end!
        	boolean ret  = isTheEnd((Unit )unit , _tn);
        	if(ret) 
        		{
        		out.clear();// remove all the locks from the list!
        		}
        }
        unit2accOutLocks.put(unit, out);// fixpoint value at last
    }

    private boolean isTheEnd(Unit unit, CriticalSection tn) {
		//1 earlyends
    	boolean ret  =false;
    	Set<Pair<Stmt,Stmt>>  allEnds = new HashSet<Pair<Stmt,Stmt>>();
    	if(tn.earlyEnds!=null)
    	{
    		for(Pair<Stmt,Stmt> pp: tn.earlyEnds)
    		{
    			if(pp!=null)
    			{
    				allEnds.add(pp);
    			}
    			
    		}
    		
    	}
    	
    	if(tn.end!=null)
    	{ allEnds.add(tn.end);}
    	if(tn.exceptionalEnd!=null)
    	{
    		allEnds.add(tn.exceptionalEnd);
    	}
    	
    	Iterator<Pair<Stmt,Stmt>> earlyIT  = allEnds.iterator();
    	while (earlyIT.hasNext()) {
			Pair<Stmt,Stmt> pair = (Pair<Stmt,Stmt>) earlyIT
					.next();
			if(pair.getO1()==unit)
			{
				ret  =true;
			}			
		}  	
		return ret;
	}

	/**
     * All paths == Union, constraints.. .
     **/
    protected void merge(Object in1, Object in2, Object out)
    {
        FlowSet
            inSet1 = (FlowSet) in1,
            inSet2 = (FlowSet) in2,
            outSet = (FlowSet) out;

        inSet1.union(inSet2, outSet);
    }

    protected void copy(Object source, Object dest)
    {
        FlowSet
            sourceSet = (FlowSet) source,
            destSet = (FlowSet) dest;

        sourceSet.copy(destSet);
    }
}
