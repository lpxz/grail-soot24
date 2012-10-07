package aTSE.codeRegion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import aTSE.CallSite;

import soot.Body;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;

public class IntraP {
    public static String criteriaString ="aTSE.selectcode.Criteria";
    
    public static Unit getFirst(SootMethod sm, Criteria criteria ) 
    {
    	if(!sm.hasActiveBody()) return null;
    	else {
			Body b  = sm.getActiveBody();
			Iterator<Unit> uIT  = b.getUnits().iterator();
			
			   Class cls;
	           Method torun =null;
			   try {
				cls = Class.forName(criteriaString);
				String metC  = criteria.methodName;
		           Method[] methodsR= cls.getMethods();
		           for(int i=0;i<methodsR.length;i++)
		           {
		        	   Method  mR = methodsR[i];
		        	   if(mR.getName().equals(metC))
		        	   {
		        		   torun =mR;
		        		   break;
		        	   }
		           }
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	           
	           
			while (uIT.hasNext()) {
				Unit unit = (Unit) uIT.next();
				List argLC = new ArrayList();
				argLC.addAll(criteria.argList);
				argLC.add(unit);// the arg, should not be added accumutively	
				
		         
				try {					
		           Boolean  retobj =(Boolean) torun.invoke(criteria, argLC.toArray());// method(this, object...)
		           if(retobj.booleanValue())
		           {
		        	   return unit;
		           }
				}  catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		}
    	return null;
    	
    }
    

 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	public static Set pre(CallSite cs) {
		List worklist = new ArrayList();
		worklist.add(cs.rep);
	 Set toret = new  HashSet();
	 Body b =  cs.sm.getActiveBody();
	 UnitGraph ug = new BriefUnitGraph(b);
	 while(worklist.size()>=1)
	 {
		 Unit pop  = (Unit)worklist.remove(0);
		 List<Unit > precs =  ug.getPredsOf(pop);
		 for(Unit prec : precs)//add succ, the first one is not added as it is not anyone's succ!
		 {
			 if(!toret.contains(prec))
			 {
				 toret.add(prec);
				 worklist.add(prec);
			 }
		 }
	 }
     
		return toret;
	}




	public static Set post(CallSite cs) {
		List worklist = new ArrayList();
		worklist.add(cs.rep);
	 Set toret = new  HashSet();
	 Body b =  cs.sm.getActiveBody();
	 UnitGraph ug = new BriefUnitGraph(b);
	 while(worklist.size()>=1)
	 {
		 Unit pop  = (Unit)worklist.remove(0);
		 List<Unit > succs =  ug.getSuccsOf(pop);
		 for(Unit succ : succs)//add succ, the first one is not added as it is not anyone's succ!
		 {
			 if(!toret.contains(succ))
			 {
				 toret.add(succ);
				 worklist.add(succ);
			 }
		 }
	 }
     
		return toret;
	}




	public static Set betweenSites(CallSite callSite1, CallSite callSite2) {
		if(!callSite1.classname.equals(callSite2.classname) || !callSite1.methodname.equals(callSite2.methodname))
		{
			throw new  RuntimeException();
		}// intra-procedurrally

		Set toret = new HashSet();
		Set post1 = post(callSite1);
		Set pre2 = pre(callSite2);
		for(Object o: post1)
		{
			if(pre2.contains(o))
			{
				toret.add(o);// intersection
			}
		}
		
		//==============transitive closure
		return toret;
		
	}

}
