package pldi.locking;

import java.util.*;

import pldi.locking.*;

import soot.toolkits.scalar.FlowSet;
import soot.toolkits.scalar.Pair;
import soot.*;
import soot.util.*;
import soot.jimple.*;
import soot.jimple.internal.JNopStmt;
import soot.jimple.toolkits.pointer.*;
import soot.jimple.toolkits.thread.ThreadLocalObjectsAnalysis;
import soot.jimple.toolkits.thread.synchronization.CriticalSectionAwareSideEffectAnalysis;

import soot.toolkits.scalar.*;
import soot.toolkits.graph.*;
import sun.awt.motif.MPopupMenuPeer;


/**
 * @author Richard L. Halpert
 * Finds Synchronized Regions and creates a set of CriticalSection objects from them.
 */
public class SynchronizedRegionFinder extends ForwardFlowAnalysis<Unit, FlowSet>
{
    FlowSet emptySet = new ArraySparseSet();

    Map unitToGenerateSet;

    Body body;
    Chain units;
	SootMethod method;
	ExceptionalUnitGraph egraph;
	LocalUses slu;
	LocalDefs sld ;
	
//	CriticalSectionAwareSideEffectAnalysis tasea;
//	SideEffectAnalysis sea;
	
	List<Object> prepUnits;

    CriticalSection methodTn;
	
	public boolean optionPrintDebug = false;
	public boolean optionOpenNesting = true;
//	public static SynchronizedRegionFinder getSRFWrapper(UnitGraph eug, Body b,  boolean optionOpenNesting)
//	{
//		boolean pass = true;
//		SynchronizedRegionFinder ta =null;
////		do {
////			System.err.println("one try:");
//			ta = new SynchronizedRegionFinder(
//					eug, b, true);
//
////		} while (pass!=true);
////		ta = new SynchronizedRegionFinder(
////				eug, b, true);
//		return ta;	
//	}
	
//    private static boolean exceptionalExitTest(SynchronizedRegionFinder ta,UnitGraph eug, Body b, boolean c) {
//    	Chain units = b.getUnits();
//		Unit lastUnit = (Unit) units.getLast();
//		FlowSet fs = (FlowSet) ta.getFlowBefore(lastUnit);
//		// all tns are here
//		boolean pass = true;
//		if(fs!=null)
//		{
//			
//		    for (Iterator iterator = fs.iterator(); iterator
//					.hasNext();) {
//		    	SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) iterator.next();
//		    	CriticalSection cSection = (srfp).tn;
//		    	try {
//		    		Set<ExitMonitorStmt> exits =cSection.getExitMonitorsTest();	 
//		    		
//				} catch (Exception e) {
//					pass =false;
//					System.out.println("fail "+ cSection.method.getActiveBody().toString());
//					
//				}
//					
//		    
//		    	
//		    }
//		}
//		return pass;
//		
//	}
    
//    public static SynchronizedRegionFinder getSRFWrapperTest(UnitGraph eug, Body b,  boolean optionOpenNesting)
//	{
//		boolean pass = true;
//		SynchronizedRegionFinder ta =null;
////		do {
////			System.err.println("one try:");
//			ta = new SynchronizedRegionFinder(
//					eug, b, true);
//			pass =exceptionalExitTest(ta,eug, b, true);
//			if(!pass) return null;
////		} while (pass!=true);
////		ta = new SynchronizedRegionFinder(
////				eug, b, true);
//		return ta;	
//	}
	
   
	public SynchronizedRegionFinder(UnitGraph graph, Body b,  boolean optionOpenNesting)
	{
		super(graph);

		this.optionOpenNesting = optionOpenNesting;

		body = b;
		units = b.getUnits();
		method = body.getMethod();

		if(graph instanceof ExceptionalUnitGraph)
			egraph = (ExceptionalUnitGraph) graph;
		else
			egraph = new ExceptionalUnitGraph(b);
				
		sld= new SmartLocalDefs(egraph, new SimpleLiveLocals(egraph));
		slu = new SimpleLocalUses(egraph, sld);
		
		if( G.v().Union_factory == null ) {
		    G.v().Union_factory = new UnionFactory() {
			public Union newUnion() { return FullObjectSet.v(); }
		    };
		}
		

    	    				
    	prepUnits = new ArrayList<Object>();
    	
		methodTn = null;
		if(method.isSynchronized())
		{
			// Entire method is transactional
			methodTn = new CriticalSection(true, method, 1);
			methodTn.beginning = ((JimpleBody) body).getFirstNonIdentityStmt();
		}
        doAnalysis();
		if(method.isSynchronized() && methodTn != null)
		{
			for(Iterator tailIt = graph.getTails().iterator(); tailIt.hasNext(); )
			{
				Stmt tail = (Stmt) tailIt.next();
				Pair<Stmt, Stmt> tmp = new Pair(tail, null);
				methodTn.earlyEnds.add(tmp); // has no exitmonitor stmt yet
			
			}
		}
	}
    	
    /**
     * All INs are initialized to the empty set.
     **/
    protected FlowSet newInitialFlow()
    {
		FlowSet ret = emptySet.clone();
		if(method.isSynchronized() && methodTn != null)
		{
			ret.add(new SynchronizedRegionFlowPair(methodTn, true));
		}
        return ret;
    }

    /**
     * IN(Start) is the empty set
     **/
    protected FlowSet entryInitialFlow()
    {
		FlowSet ret = emptySet.clone();
		if(method.isSynchronized() && methodTn != null)
		{
			ret.add(new SynchronizedRegionFlowPair(methodTn, true));
		}
        return ret;
    }

    /**
     * OUT is the same as (IN minus killSet) plus the genSet.
     **/
    protected void flowThrough(FlowSet in, Unit unit, FlowSet out)
    {
		Stmt stmt = (Stmt) unit;

       	copy(in, out);
       	
        // Determine if this statement is a preparatory statement for an
        // upcoming transactional region. Such a statement would be a definition 
        // which contains no invoke statement, and which corresponds only to 
        // EnterMonitorStmt and ExitMonitorStmt uses.  In this case, the read
        // set of this statement should not be considered part of the read set
        // of any containing transaction
        if(unit instanceof AssignStmt)
        {
	        boolean isPrep = true;
        	Iterator uses = slu.getUsesOf((Unit) unit).iterator();
        	if(!uses.hasNext())
        		isPrep = false;
        	while(uses.hasNext())
        	{
        		UnitValueBoxPair use = (UnitValueBoxPair) uses.next();
        		Unit useStmt = use.getUnit();
        		if( !(useStmt instanceof EnterMonitorStmt) && !(useStmt instanceof ExitMonitorStmt) )
        		{// just decide based on the first use!
        			isPrep = false;
        			break;
        		}
        	}
        	if(isPrep)
        	{
        		prepUnits.add(unit);
        		if(optionPrintDebug)
        		{
        			G.v().out.println("prep: " + unit.toString());
        		}
        		return;
        	}
        }
                
        // Determine if this statement is the start of a transaction
        boolean addSelf = (unit instanceof EnterMonitorStmt);
        boolean fillSelfPrepPrep = (unit instanceof ExitMonitorStmt); 
        
		// Determine the level of transaction nesting of this statement
		int nestLevel = 0;
        Iterator outIt0 = out.iterator();
        CriticalSection lastOne  = null;
        while(outIt0.hasNext())
        {
            SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) outIt0.next();
            if(srfp.tn.nestLevel > nestLevel && srfp.inside == true)
            	{
            	   nestLevel = srfp.tn.nestLevel;
            	   lastOne = srfp.tn;
          //  	   System.out.println(unit+ " in tn" + lastOne.IDNum);
            	}
        }
      

		// Process this unit's effect on each txn
		RWSet stmtRead = null;
		RWSet stmtWrite = null;
        Iterator outIt = out.iterator();
        boolean printed = false;
        while(outIt.hasNext())
        {
            SynchronizedRegionFlowPair srfp = (SynchronizedRegionFlowPair) outIt.next();
            CriticalSection tn = srfp.tn;
            
            // Check if we are revisting the start of this existing transaction
            if(tn.entermonitor == stmt)
            {
            //	System.out.println(tn.IDNum + " , level" + tn.nestLevel);
            	srfp.inside = true;
            	addSelf = false; // this transaction already exists...
            //	System.out.println(tn.hashCode() + " is to enter again, level" + tn.nestLevel);
            }
            
            // if this is the immediately enclosing transaction
        	if(srfp.inside == true && (tn.nestLevel == nestLevel || optionOpenNesting == false))
        	{
        		printed = true; // for debugging purposes, indicated that we'll print a debug output for this statement
        		
            	// Add this unit to the current transactional region
            	if(!tn.units.contains(unit))
	            	tn.units.add(unit);
        		
        		// Check what kind of statement this is
        		// If it contains an invoke, save it for later processing as part of this transaction
        		// If it is a monitorexit, mark that it's the end of the transaction
        		// Otherwise, add it's read/write sets to the transaction's read/write sets
            	if(stmt.containsInvokeExpr())
            	{
            		// Note if this unit is a call to wait() or notify()/notifyAll()
            		String InvokeSig = stmt.getInvokeExpr().getMethod().getSubSignature();
            		if((InvokeSig.equals("void notify()") || InvokeSig.equals("void notifyAll()")) && tn.nestLevel == nestLevel) // only applies to outermost txn
            		{
				        if(!tn.notifys.contains(unit))
		            		tn.notifys.add(unit);
	            		if(optionPrintDebug)
	            			G.v().out.print("{x,x} ");
	            	}
	            	else if((InvokeSig.equals("void wait()") || InvokeSig.equals("void wait(long)") || InvokeSig.equals("void wait(long,int)")) && tn.nestLevel == nestLevel) // only applies to outermost txn
            		{
				        if(!tn.waits.contains(unit))
		            		tn.waits.add(unit);
	            		if(optionPrintDebug)
	            			G.v().out.print("{x,x} ");
	            	}
	            	
	            	if(!tn.invokes.contains(unit))
	            	{
	            		// Mark this unit for later read/write set calculation (must be deferred until all tns have been found)
		            	tn.invokes.add(unit);		            	
		            	// Debug Output

		            }
            	}
            	else if(unit instanceof ExitMonitorStmt && tn.nestLevel == nestLevel) // only applies to outermost txn
            	{
            	//	System.out.println(tn.IDNum + " is to exit, level" + tn.nestLevel);
            		// added by lp
            		// fill in the prep and prepprep. r3=r1, enterg r1, but  exit r3, the enter does not use r3 at all
                	Iterator<Object> prepUnitsIt = prepUnits.iterator();
        			while(prepUnitsIt.hasNext())
        			{
        				Unit prepUnit = (Unit) prepUnitsIt.next();
        				
        				Iterator uses = slu.getUsesOf(prepUnit).iterator();
        	        	while(uses.hasNext())
        	        	{
        	        		UnitValueBoxPair use = (UnitValueBoxPair) uses.next();
        	        		if(use.getUnit() == (Unit) unit)
        	        		{// if this transaction's monitorenter statement is one of the uses of this preparatory unit
        	        			tn.prepStmt = (Stmt) prepUnit;
//        	        			if(prepUnit instanceof AssignStmt)
//        	        			{
//        	        				Local right = (Local)((AssignStmt) prepUnit).getRightOp();
//        	        				List<Unit> defs =sld.getDefsOfAt(right, tn.prepStmt);
//        	        				//System.out.println(defs.size() + " " + defs.get(0).toString());
//        	        				if(defs.size()==1)
//        	        				{
//        	        					tn.prepOfprep = (Stmt)defs.get(0);
//        	        				}
//        	        				else {
//										throw new RuntimeException("how can you expect to see multiple defs?");
//									}
//        	        				
//        	        				
//        	        			}else {
//									throw new RuntimeException("how od you prepare without an assignmetn statement");
//								}
        	        			
        	        		}
        	        	}
        			}
        			//===================end
        			
                	
        		   
        			
            		// Mark this as end of this tn
            		srfp.inside = false;
            		nestLevel --;//!!!important, missed in soot
            		
            		
            		
            		
            		// Check if this is an early end or fallthrough end
            		Stmt nextUnit = stmt;
            		do
            		{
            			nextUnit = (Stmt) units.getSuccOf(nextUnit);
            		} while (nextUnit instanceof JNopStmt);
            		if( nextUnit instanceof ReturnStmt ||
            			nextUnit instanceof ReturnVoidStmt ||
            			nextUnit instanceof ExitMonitorStmt )
            		{
            			Pair<Stmt, Stmt> tmp= new Pair<Stmt,Stmt>(nextUnit, stmt);
            			tn.earlyEnds.add(tmp); // <early end stmt, exitmonitor stmt>
            		}
            		else if( nextUnit instanceof GotoStmt )
            		{
            			tn.end = new Pair(nextUnit, stmt); // <end stmt, exitmonitor stmt>
            			tn.after = (Stmt) ((GotoStmt) nextUnit).getTarget();
            		}
            		else if( nextUnit instanceof ThrowStmt )
            		{
            		//	System.out.println(tn.hashCode() + " has end" + stmt);
            			tn.exceptionalEnd = new Pair(nextUnit, stmt);
            		}
            		else
            		{// directly success, like bao song sheng
            			Pair<Stmt , Stmt> tmp =new Pair(nextUnit, stmt);
            			tn.earlyEnds.add(tmp); // <early end stmt, exitmonitor stmt>
            			
            		}
            		//	throw new RuntimeException("Unknown bytecode pattern: exitmonitor not followed by return, exitmonitor, goto, or throw");


            	}
				else
            	{
					// not interesting, common stmt
            		// Add this unit's read and write sets to this transactional region
 //           		HashSet uses = new HashSet();
//	               	stmtRead = tasea.readSet( method, stmt, tn, uses );
//		           	stmtWrite = tasea.writeSet( method, stmt, tn, uses );
//    		   		tn.read.union(stmtRead);
 //       			tn.write.union(stmtWrite);

        		}
			}
        }
        

		
		// If this statement was a monitorenter, and no transaction object yet exists for it,
		// create one.
        if(addSelf)
        {
        	CriticalSection newTn = new CriticalSection(false, method, nestLevel + 1);
      //  	System.out.println(newTn.hashCode() + " is created, level" + newTn.nestLevel);
        	if(lastOne!=null)
        	{
        		lastOne.childSections.add(newTn);
        	}
			
        	newTn.entermonitor = stmt;
        	EnterMonitorStmt tmp=(EnterMonitorStmt) stmt;
        
			newTn.units.add(newTn.entermonitor);// it should be contained!
			newTn.beginning = (Stmt) units.getSuccOf(stmt);
			if(stmt instanceof EnterMonitorStmt)
				newTn.origLock = ((EnterMonitorStmt) stmt).getOp();
				
        	
			out.add(new SynchronizedRegionFlowPair(newTn, true));
			
			// This is a really stupid way to find out which prep applies to this txn.
			Iterator<Object> prepUnitsIt = prepUnits.iterator();
			while(prepUnitsIt.hasNext())
			{
				Unit prepUnit = (Unit) prepUnitsIt.next();
				
				Iterator uses = slu.getUsesOf(prepUnit).iterator();
	        	while(uses.hasNext())
	        	{
	        		UnitValueBoxPair use = (UnitValueBoxPair) uses.next();
	        		if(use.getUnit() == (Unit) unit)
	        		{// if this transaction's monitorenter statement is one of the uses of this preparatory unit
	        			newTn.prepStmt = (Stmt) prepUnit;
	        		}
	        	}

			}
		}
    
    }

    /**
     * union
     **/
    protected void merge(FlowSet inSet1, FlowSet inSet2, FlowSet outSet)
    {
		inSet1.union(inSet2, outSet);
    }

    protected void copy(FlowSet sourceSet, FlowSet destSet)
    {
		destSet.clear();

		Iterator it = sourceSet.iterator();
		while(it.hasNext())
		{
			SynchronizedRegionFlowPair tfp = (SynchronizedRegionFlowPair) it.next();
			destSet.add(tfp.clone());
		}
    }
}
