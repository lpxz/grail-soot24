/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Ondrej Lhotak
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

package soot.jimple.toolkits.pointer;
import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.*;
import java.util.*;

/** Generates side-effect information from a PointsToAnalysis. */
public class SideEffectAnalysis {
    PointsToAnalysis pa;
    CallGraph cg;
    Map<SootMethod, MethodRWSet> methodToNTReadSet = new HashMap<SootMethod, MethodRWSet>();
    Map<SootMethod, MethodRWSet> methodToNTWriteSet = new HashMap<SootMethod, MethodRWSet>();
    int rwsetcount = 0;
    public TransitiveTargets tt;

    public void findNTRWSets( SootMethod method ) {
	if( methodToNTReadSet.containsKey( method )
	    && methodToNTWriteSet.containsKey( method ) ) return;
	
	CodeBlockRWSet read = null;
	CodeBlockRWSet write = null;
	for( Iterator sIt = method.retrieveActiveBody().getUnits().iterator(); sIt.hasNext(); ) {
	    final Stmt s = (Stmt) sIt.next();
            RWSet ntr = ntReadSet( method, s );
            if( ntr != null ) {
                if( read == null ) read = new CodeBlockRWSet();
                read.union( ntr );
            }
            RWSet ntw = ntWriteSet( method, s );
            if( ntw != null ) {
                if( write == null ) write = new CodeBlockRWSet();
                write.union( ntw );
            }
	}
	methodToNTReadSet.put( method, read );
	methodToNTWriteSet.put( method, write );
	SootClass c = method.getDeclaringClass();
    }

    public RWSet nonTransitiveReadSet( SootMethod method ) {
	findNTRWSets( method );
	return methodToNTReadSet.get( method );
    }

    public RWSet nonTransitiveWriteSet( SootMethod method ) {
	findNTRWSets( method );
	return methodToNTWriteSet.get( method );
    }

    public SideEffectAnalysis( PointsToAnalysis pa, CallGraph cg ) {
	this.pa = pa;
	this.cg = cg;
        this.tt = new TransitiveTargets( cg );
    }

    public SideEffectAnalysis( PointsToAnalysis pa, CallGraph cg, Filter filter ) {
    // This constructor allows customization of call graph edges to
    // consider via the use of a transitive targets filter.
    // For example, using the NonClinitEdgesPred, you can create a 
    // SideEffectAnalysis that will ignore static initializers
    // - R. Halpert 2006-12-02
	this.pa = pa;
	this.cg = cg;
        this.tt = new TransitiveTargets( cg, filter );
    }

    private RWSet ntReadSet( SootMethod method, Stmt stmt ) {
	if( stmt instanceof AssignStmt ) {
	    AssignStmt a = (AssignStmt) stmt;
	    Value r = a.getRightOp();
	    return addValue( r, method, stmt );
	}
        return null;
    }
    public RWSet readSet( SootMethod method, Stmt stmt ) {
	RWSet ret = null;
        Iterator<MethodOrMethodContext> targets = tt.iterator( stmt );
        while( targets.hasNext() ) {
            SootMethod target = (SootMethod) targets.next();
            if( target.isNative() ) {
                if( ret == null ) ret = new SiteRWSet();
                ret.setCallsNative();
            } else if( target.isConcrete() ) {
                RWSet ntr = nonTransitiveReadSet(target);
                if( ntr != null ) {
                    if( ret == null ) ret = new SiteRWSet();
                    ret.union( ntr );
                }
            }
        }
        if( ret == null ) return ntReadSet( method, stmt );
        ret.union( ntReadSet( method, stmt ) );
        return ret;
    }
    
    public static  String[] unInstruClasses = {
	    "org.apache.log4j.",
		"jrockit.",
		"java.",
		"javax.",
		"xjava.",
		"COM.",
		"com.",
		"cryptix.",
		"sun.",
		"sunw.",
		"junit.",
		"org.junit.",
		"org.xmlpull.",
		"edu.hkust.clap.",
		// the following are copied frpm the transforming options. (commandLine)
		"org.apache.commons.logging.",// annoying, ban it
		"org.apache.xalan.",
		"org.apache.xpath.",
		"org.springframework.",
		"org.jboss.",
		"jrockit.",
		"edu.",				
		"checkers.",
		"org.codehaus.spice.jndikit.",
		"EDU.oswego.cs.dl.util.concurrent.WaiterPreferenceSemaphore",
		"soot.",
		"aTSE.",
		"pldi.",
		"popl.", 
		"beaver.",
		"org.jgrapht",
		"ca.pfv.spmf.","japa.parser.", "polyglot."
		
		// org.w3c. is the including option			
	};
	public static boolean shouldInstruThis_ClassFilter(String scname)
	{
		for(int k=0;k<unInstruClasses.length;k++)
		{
			if(scname.startsWith(unInstruClasses[k]))
			{
				return false;
			}
		}
		
		return true;
	}
	
    public RWSet readSet_onlyAPPclasses( SootMethod method, Stmt stmt ) {
    	    RWSet ret = null;
            Iterator<MethodOrMethodContext> targets = tt.iterator( stmt );// really stupid!
            while( targets.hasNext() ) {
                SootMethod target = (SootMethod) targets.next();
                if(!shouldInstruThis_ClassFilter(target.getDeclaringClass().getName()))
                	continue;
                if( target.isNative() ) {
                    continue;
                } else if( target.isConcrete() ) {
                    RWSet ntr = nonTransitiveReadSet(target);
                    if( ntr != null ) {
                        if( ret == null ) ret = new SiteRWSet();
                        ret.union( ntr );
                    }
                }
            }
            if( ret == null ) return ntReadSet( method, stmt );
            ret.union( ntReadSet( method, stmt ) );
            return ret;
        }

    private RWSet ntWriteSet( SootMethod method, Stmt stmt ) {
        if( stmt instanceof AssignStmt ) {
	    AssignStmt a = (AssignStmt) stmt;
	    Value l = a.getLeftOp();
	    return addValue( l, method, stmt );
	}
        return null;
    }
    public RWSet writeSet( SootMethod method, Stmt stmt ) {
	RWSet ret = null;
        Iterator<MethodOrMethodContext> targets = tt.iterator( stmt );
        while( targets.hasNext() ) {
            SootMethod target = (SootMethod) targets.next();
            if( target.isNative() ) {
                if( ret == null ) ret = new SiteRWSet();
                ret.setCallsNative();
            } else if( target.isConcrete() ) {
                RWSet ntw = nonTransitiveWriteSet(target);
                if( ntw != null ) {
                    if( ret == null ) ret = new SiteRWSet();
                    ret.union( ntw );
                }
            }
	}
        if( ret == null ) return ntWriteSet( method, stmt );
        ret.union( ntWriteSet( method, stmt ) );
	return ret;
    }
    
    public RWSet writeSet_onlyAPPclasses( SootMethod method, Stmt stmt ) {
    	RWSet ret = null;
            Iterator<MethodOrMethodContext> targets = tt.iterator( stmt );
            while( targets.hasNext() ) {
                SootMethod target = (SootMethod) targets.next();
                if(!shouldInstruThis_ClassFilter(target.getDeclaringClass().getName()))
                	continue;
                
                if( target.isNative() ) {
                  continue;
                } else if( target.isConcrete() ) {
                    RWSet ntw = nonTransitiveWriteSet(target);
                    if( ntw != null ) {
                        if( ret == null ) ret = new SiteRWSet();
                        ret.union( ntw );
                    }
                }
    	}
            if( ret == null ) return ntWriteSet( method, stmt );
            ret.union( ntWriteSet( method, stmt ) );
    	return ret;
        }

    protected RWSet addValue( Value v, SootMethod m, Stmt s ) {
	RWSet ret = null;
	if( v instanceof InstanceFieldRef ) {
	    InstanceFieldRef ifr = (InstanceFieldRef) v;
	    PointsToSet base = pa.reachingObjects( (Local) ifr.getBase() );
	    ret = new StmtRWSet();
	    ret.addFieldRef( base, ifr.getField() );
	} else if( v instanceof StaticFieldRef ) {
	    StaticFieldRef sfr = (StaticFieldRef) v;
	    ret = new StmtRWSet();
	    ret.addGlobal( sfr.getField() );
	} else if( v instanceof ArrayRef ) {
	    ArrayRef ar = (ArrayRef) v;
	    PointsToSet base = pa.reachingObjects( (Local) ar.getBase() );
	    ret = new StmtRWSet();
	    ret.addFieldRef( base, PointsToAnalysis.ARRAY_ELEMENTS_NODE );
	}
	return ret;
    }

    public String toString() {
        return "SideEffectAnalysis: PA="+pa+" CG="+cg;
    }
}

