package aTSE;

import java.util.Set;

import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.NewExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;
import soot.jimple.toolkits.pointer.RWSet;
import soot.jimple.toolkits.pointer.StmtRWSet;

public class Code2Data {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static CodeBlockRWSet code2dataREAD(Set postSet) {
		CodeBlockRWSet ret = new CodeBlockRWSet();
	  for(Object o : postSet)
	  {
		  Unit unit = (Unit )o;
		  ret.union(ntReadSet(unit));	  
	  }
	  return ret;
		
		
	}
	
	public static CodeBlockRWSet code2dataWRITE(Set postSet) {
		CodeBlockRWSet ret = new CodeBlockRWSet();
	  for(Object o : postSet)
	  {
		  Unit unit = (Unit )o;
		  ret.union(ntWriteSet(unit));
		  
		  
	  }
	  return ret;
		
		
	}
	
	private static RWSet ntReadSet(  Unit stmt )
	{
		if( stmt instanceof AssignStmt ) {
			AssignStmt a = (AssignStmt) stmt;
			Value r = a.getRightOp();
			if(r instanceof NewExpr) // IGNORE NEW STATEMENTS
				return null;
			return addValue( r,  stmt );
		}
		return null;
	}
	
	private static RWSet ntWriteSet(Unit stmt ) {
		if( stmt instanceof AssignStmt ) {
			AssignStmt a = (AssignStmt) stmt;
			Value l = a.getLeftOp();
			return addValue( l,  stmt );
		}
		return null;
	}
	
	protected static RWSet addValue( Value v,  Unit s )
	{
		RWSet ret = null;
		
       PointsToAnalysis pa = Scene.v().getPointsToAnalysis();
		if( v instanceof InstanceFieldRef ) {
			InstanceFieldRef ifr = (InstanceFieldRef) v;
			Local baseLocal = (Local) ifr.getBase();
			PointsToSet base = pa.reachingObjects( baseLocal );
			if(baseLocal.getType() instanceof RefType)
			{
				SootClass baseClass = ((RefType) baseLocal.getType()).getSootClass();
				if(Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(
					baseClass, RefType.v("java.lang.Exception").getSootClass()))
					return null;
			}
			ret = new StmtRWSet();
			ret.addFieldRef( base, ifr.getField() );
		}
		else if( v instanceof StaticFieldRef )
		{
			StaticFieldRef sfr = (StaticFieldRef) v;
			ret = new StmtRWSet();
			ret.addGlobal( sfr.getField() );
		} 
		else if( v instanceof ArrayRef )
		{
			ArrayRef ar = (ArrayRef) v;
			PointsToSet base = pa.reachingObjects( (Local) ar.getBase() );
			ret = new StmtRWSet();
			ret.addFieldRef( base, PointsToAnalysis.ARRAY_ELEMENTS_NODE );
		}
		return ret;
	}
	
	

}
