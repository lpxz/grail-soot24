package aTSE.AHG;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;

import soot.PointsToSet;
import soot.jimple.spark.sets.PointsToSetInternal;

public class CopyOfAHGTraverse {

    public  static  HashSet<PointsToSet> visited  =null;
    public static Stack<String> stack = null;
	private static String criteriaString= "aTSE.AHG.AHGCriteria";
	private static String actionString= "aTSE.AHG.AHGAction";
//	private static DirectedPseudograph<String, DefaultEdge> toDrawG;
	static DOTExporter<String, DefaultEdge> dotEx= new DOTExporter<String, DefaultEdge>();
    
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void ahgvisit_root(
			DirectedPseudograph<PointsToSet, DefaultEdge> toBuildG, PointsToSet root) {	
		if(root ==null ) throw new RuntimeException();
		

		visited=new  HashSet<PointsToSet>();
		stack = new  Stack<String>();
		if(!visited.contains(root))
		{
			visited.add(root);// the adding time is here for the root
		}
		stack.push(getNodeName(root));// note the stack is root.field1.field2...
		
		AHGViewDotAnalyzer_setup( toBuildG,  root);
	//	AHGPathSelector_setup(toBuildG,  root);
    //    AHGAtomicSetTosser_setup(toBuildG,  root); // tofix!
		

	
		
		
			
		
		//=============================node-based:
	//	ahgvisit_dfs_nodeselect(toBuildG, root, criteria);//to fix
	}
	
	private static void AHGAtomicSetTosser_setup(
			DirectedPseudograph<PointsToSet, DefaultEdge> toBuildG,
			PointsToSet root) {
		AHGCriteria criteria = new AHGCriteria();// criteria:action pair to implement the AHGAtomicSetTosser
		{
		   /// choose and set the criteria	
			criteria.methodname ="trivial";
			criteria.argList= new  ArrayList();// later on there is the path stack
		}
		 DirectedPseudograph<String, DefaultEdge>  toDrawG=null;
		AHGAction action = new AHGAction();
		{
			action.methodname="drawEdgeInG";
		    action.argList = new  ArrayList();
		    toDrawG=  
		    	new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
		    action.argList.add(toDrawG);// later on there is the edge to processed
		}	
		ahgvisit_dfs_pathselect(toBuildG, root, criteria, action);//root is required
		exportDot(toDrawG);
		
	}

	private static void AHGPathSelector_setup(
			DirectedPseudograph<PointsToSet, DefaultEdge> toBuildG,
			PointsToSet root) {
		AHGCriteria criteria = new AHGCriteria();// criteria:action pair to implement the AHGPathSelector
		{
		   /// choose and set the criteria	
			criteria.methodname ="satisfyPathPatterns";
			
			Set<String> lgroupRegs= new HashSet<String>();
			lgroupRegs.add("teacher.a.[^b]*.f");
			lgroupRegs.add("38.global_maxNumEdgeLearned");
			criteria.argList= new  ArrayList();
			criteria.argList.add(lgroupRegs);//// later on there is the path stack
		}
		Set hitSet = new  HashSet();
		AHGAction action = new AHGAction();
		{
			action.methodname="addTarget2Set";
		    action.argList = new  ArrayList();
		    action.argList.add(hitSet);// later on there is the edge to processed
		}	
		ahgvisit_dfs_pathselect(toBuildG, root, criteria, action);//root is required
		
	}

	private static void AHGViewDotAnalyzer_setup(DirectedPseudograph<PointsToSet,DefaultEdge> toBuildG, PointsToSet root) {
		AHGCriteria criteria = new AHGCriteria();// criteria:action pair to implement the AHGViewdotanalyzer
		{
		   /// choose and set the criteria	
			criteria.methodname ="trivial";
			criteria.argList= new  ArrayList();// later on there is the path stack
		}
		 DirectedPseudograph<String, DefaultEdge>  toDrawG=null;
		AHGAction action = new AHGAction();
		{
			action.methodname="drawEdgeInG";
		    action.argList = new  ArrayList();
		    toDrawG=  
		    	new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
		    action.argList.add(toDrawG);// later on there is the edge to processed
		}	
		ahgvisit_dfs_pathselect(toBuildG, root, criteria, action);//root is required
		exportDot(toDrawG);
		
	}

	private static void exportDot(
			DirectedPseudograph<String, DefaultEdge> toDrawG) {		
		File file = new File("graph"+toDrawG.hashCode()+".dot");
		FileWriter fw;
		try { 
			fw = new  FileWriter(file);
			dotEx.export4AHG(fw, toDrawG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static String getNodeName(PointsToSet root) {
		return  ""+ ((PointsToSetInternal)root).pointsToSetHashCode();		
	}

	private static void ahgvisit_dfs_pathselect(DirectedPseudograph<PointsToSet, DefaultEdge> g, PointsToSet root
			, AHGCriteria criteria, AHGAction action) {
		// for root, stack is empty, no need to check it, we check at adding time. instead of the pop-process time		
		Set<DefaultEdge> edges = g.outgoingEdgesOf(root);
		for (Iterator iterator = edges.iterator(); iterator.hasNext();) {
			DefaultEdge defaultEdge = (DefaultEdge) iterator.next();
			PointsToSet target = (PointsToSet)defaultEdge.getTarget();// already content-based according to the constrcution
			String flabel = defaultEdge.getLabel();
			if(!visited.contains(target))
			{
				visited.add(target);
				stack.push(flabel);	

				if(satisfyPathCriteria(criteria, stack))
				{
					// do sth
					performAction(action, defaultEdge);		// add the edge to the arglist and execute the code	
					
				}
				ahgvisit_dfs_pathselect(g, target,criteria, action);		
				stack.pop();
			}
			else {
				stack.push(flabel);// multiple edges... not go into, but still need to process this edge 
				if(satisfyPathCriteria(criteria, stack))
				{
					// do sth
					performAction(action, defaultEdge);			
					
				}
				stack.pop();
			}			
		}
		
	}

	private static void performAction(AHGAction action, DefaultEdge defaultEdge) {
		Class cls;
        Method torun =null;
		   try {
			cls = Class.forName(actionString);
			String metC  = action.methodname;
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
		
		
		
		List argLC = new ArrayList();
		argLC.addAll(action.argList);
		argLC.add(defaultEdge);// the last argument is the default edge, for the former ones, I am not sure
		
         
		try {					
           torun.invoke(action, argLC.toArray());// method(this, object...)
          
		}  catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	}

	private static boolean satisfyPathCriteria(AHGCriteria criteria,
			Stack<String> stack) {
	     
		Class cls;
        Method torun =null;
		   try {
			cls = Class.forName(criteriaString);
			String metC  = criteria.methodname;
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
		
		
		
		List argLC = new ArrayList();
		argLC.addAll(criteria.argList);
		argLC.add(stack);// the first arg is the stack object
		
         
		try {					
           Boolean  retobj =(Boolean) torun.invoke(criteria, argLC.toArray());// method(this, object...)
           if(retobj.booleanValue())
           {
        	   return true;
           }
		}  catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
	private static void ahgvisit_dfs_nodeselect(DirectedPseudograph<PointsToSet, DefaultEdge> g, PointsToSet root
			, AHGCriteria criteria) {
		// for root, stack is empty, no need to check it, we check at adding time. instead of the pop-process time		
		if(satisfyNodeCriteria(criteria, root))
		{
			//do sth
		}
		
		Set<DefaultEdge> edges = g.outgoingEdgesOf(root);
		for (Iterator iterator = edges.iterator(); iterator.hasNext();) {
			DefaultEdge defaultEdge = (DefaultEdge) iterator.next();
			PointsToSet target = (PointsToSet)defaultEdge.getTarget();
			String flabel = defaultEdge.getLabel();
			if(!visited.contains(target))
			{
				visited.add(target);
				ahgvisit_dfs_nodeselect(g, target,criteria);		
				
			}
				
		}
		
	}

	private static boolean satisfyNodeCriteria(AHGCriteria criteria,
			PointsToSet p2s) {
	     
		Class cls;
        Method torun =null;
		   try {
			cls = Class.forName(criteriaString);
			String metC  = criteria.methodname;
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
		
		
		
		List argLC = new ArrayList();
		argLC.addAll(criteria.argList);
		argLC.add(p2s);// the first arg is the point 2 set object
		
         
		try {					
           Boolean  retobj =(Boolean) torun.invoke(criteria, argLC.toArray());// method(this, object...)
           if(retobj.booleanValue())
           {
        	   return true;
           }
		}  catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	

}
