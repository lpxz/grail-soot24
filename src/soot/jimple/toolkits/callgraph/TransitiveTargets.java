/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003, 2004 Ondrej Lhotak
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

package soot.jimple.toolkits.callgraph;
import soot.*;
import soot.jimple.toolkits.pointer.SideEffectAnalysis;

import java.util.*;

/** Extends a TargetsOfMethod or TargetsOfUnit to include edges
 * transitively reachable from any target methods.
 * @author Ondrej Lhotak
 */
public class TransitiveTargets
{ 
    private CallGraph cg;
    private Filter filter;
    public TransitiveTargets( CallGraph cg ) {
        this.cg = cg;
    }
    public TransitiveTargets( CallGraph cg, Filter filter ) {
        this.cg = cg;
        this.filter = filter;
    }
    
    public static boolean isInteresting(SootMethod sm)
    {
    	if(SideEffectAnalysis.shouldInstruThis_ClassFilter(sm.getDeclaringClass().getName()))
    	{
    		if(!(sm.getName().equals(SootMethod.staticInitializerName))) //  || sm.getName().equals(SootMethod.constructorName) important, do not filter out
    		{
    			return true;
    		}
    	}
    	return false;
    	
    }
    public ArrayList<MethodOrMethodContext> methods = new ArrayList<MethodOrMethodContext>();
    public Iterator<MethodOrMethodContext> iterator( Unit u ) {
    	methods.clear();
        Iterator it = cg.edgesOutOf( u );
        if( filter != null ) it = filter.wrap( it );
        while( it.hasNext() ) {
            Edge e = (Edge) it.next();
            MethodOrMethodContext target = e.getTgt();
            if(isInteresting(target.method()))
                  methods.add(target);
        }
        return iterator( methods.iterator() );
    }
    public Iterator<MethodOrMethodContext> iterator( MethodOrMethodContext momc ) {
        ArrayList<MethodOrMethodContext> methods = new ArrayList<MethodOrMethodContext>();
        Iterator it = cg.edgesOutOf( momc );
        if( filter != null ) it = filter.wrap( it );
        while( it.hasNext() ) {
            Edge e = (Edge) it.next();
            MethodOrMethodContext target = e.getTgt();
            if(isInteresting(target.method()))
                  methods.add(target);
        }
        return iterator( methods.iterator() );
    }
    public Iterator<MethodOrMethodContext> iterator( Iterator<MethodOrMethodContext> methods ) {
        Set<MethodOrMethodContext> s = new HashSet<MethodOrMethodContext>();
        ArrayList<MethodOrMethodContext> worklist = new ArrayList<MethodOrMethodContext>();
        while( methods.hasNext() ) {
            MethodOrMethodContext method = methods.next();
            if( s.add( method ) ) worklist.add( method );
        }
        return iterator( s, worklist );
    }
    private Iterator<MethodOrMethodContext> iterator( Set<MethodOrMethodContext> s, ArrayList<MethodOrMethodContext> worklist ) {
//    	System.out.println(s.size() + " " + worklist.size() );
//    	for(MethodOrMethodContext mc : s) {
//    		System.out.println(mc.method().toString());
//    	}
    	
        for( int i = 0; i < worklist.size(); i++ ) {
            MethodOrMethodContext method = worklist.get(i);
            Iterator it = cg.edgesOutOf( method );
            if( filter != null ) it = filter.wrap( it );
            while( it.hasNext() ) {
                Edge e = (Edge) it.next();
                MethodOrMethodContext target = e.getTgt();
                if(!isInteresting(target.method()))
                     continue;
                if( s.add( e.getTgt() ) ) 
                	{
                	//System.out.println("adding .." + e.getTgt().method());
                	worklist.add( e.getTgt() );
                	}
            }
        }
        return worklist.iterator();
    }
}


