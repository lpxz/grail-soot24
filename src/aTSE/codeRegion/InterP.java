package aTSE.codeRegion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import soot.MethodOrMethodContext;
import soot.PatchingChain;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.TransitiveTargets;

public class InterP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Set closure(Set toret) {

	     Set retSet = new HashSet();
	     retSet.addAll(toret);

	     Set<SootMethod> targets  = Mclosure(toret);
	     for(SootMethod target:targets)
	     {
	    	 PatchingChain<Unit> units  = target.getActiveBody().getUnits();
	    	 retSet.addAll(units);
	     }
		return retSet;
	}
    public static Set Mclosure(Set toret) 
    {
  	        CallGraph cg = Scene.v().getCallGraph();
	        TransitiveTargets tt = new TransitiveTargets( cg );
	        Set retSet = new HashSet();
	      for(Object o : toret)
			 {
				        Unit  unit = (Unit) o;
			            Iterator<MethodOrMethodContext> it = tt.iterator( unit );
			            while( it.hasNext() ) {
			                SootMethod target = (SootMethod) it.next();		 // transitive callee               
			                if( target.isNative() ) continue ;
			                if( target.isPhantom() ) continue ;
			                if(!target.getDeclaringClass().isApplicationClass()) continue;
			                if(!target.hasActiveBody()) continue;
			                retSet.add(target);
			                }
				 
				 
				 
			 }
	      return retSet;
    }

}
