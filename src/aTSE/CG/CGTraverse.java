package aTSE.CG;

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

import beaver.Action;

import soot.MethodOrMethodContext;
import soot.PointsToSet;
import soot.SootMethod;
import soot.jimple.spark.sets.PointsToSetInternal;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pointer.CodeBlockRWSet;

public class CGTraverse {

    public  static  HashSet<SootMethod> visited  =null;
    public static Stack<Edge> stack = null;
	private static String criteriaString= "aTSE.CG.CGCriteria";
	private static String actionString= "aTSE.CG.CGAction";
//	private static DirectedPseudograph<String, DefaultEdge> toDrawG;
	static DOTExporter<String, DefaultEdge> dotEx= new DOTExporter<String, DefaultEdge>();
    
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void cgvisit_root(CallGraph cg, SootMethod root  ) {	
		if(root ==null ) throw new RuntimeException();
		

		visited=new  HashSet<SootMethod>();
		stack = new  Stack<Edge>();
		if(!visited.contains(root))
		{
			visited.add(root);// the adding time is here for the root
		}
	
		
	//	CGViewDotAnalyzer_setup( cg,  root);
	//	CGPathSelector_setup(cg,  root);
		
    //    CGNestedSync_setup(cg,  root); // 
		

	
		
		
			
		
		//=============================node-based:
       CG_nodebased_setup(cg,  root); // 
		
	}
	
	private static void CG_nodebased_setup(CallGraph toBuildG,
			SootMethod root) {
		CGCriteria criteria = new CGCriteria();// criteria:action pair to implement the AHGAtomicSetTosser
		{
		   /// choose and set the criteria	
			criteria.methodname ="sync_nodebased";
			criteria.argList= new  ArrayList();// later on there is the path stack
			//CodeBlockRWSet cbSet = new  CodeBlockRWSet();
			
		}
		
		CGAction action = new CGAction();
		{
			action.methodname="collect_syncBM_nodebased";
		    action.argList = new  ArrayList();
		    action.argList.add(new HashSet());
		  
		}	
		CGAction action2 = new CGAction();// no highlight, but still drawing
		{
			action2.methodname="donothing_nodebased";
		    action2.argList = new  ArrayList();
		 
		}	
		cgvisit_dfs_nodeselect(toBuildG, root, criteria, action, action2);//to fix
		System.out.println("");
		
	}
	
	
	private static void cgvisit_dfs_nodeselect(CallGraph g, SootMethod root
			, CGCriteria criteria, CGAction action, CGAction action2) {
		// for root, stack is empty, no need to check it, we check at adding time. instead of the pop-process time		
		if(satisfyNodeCriteria(criteria, root))
		{
			performNodeAction(action, root);
			
			//do sth
		}
		else {
			performNodeAction(action2, root);
		}
		
	Iterator<Edge> edgeIT= g.edgesOutOf(root);
	while (edgeIT.hasNext()) {
		Edge edge = (Edge) edgeIT.next();

		SootMethod target = (SootMethod)edge.getTgt();
		
		if(!visited.contains(target))
		{
			visited.add(target);
			cgvisit_dfs_nodeselect(g, target,criteria, action, action2);		
			
		}
			
	
		
	}
	
		
	}
	

	private static boolean satisfyNodeCriteria(CGCriteria criteria,
			SootMethod root) {
	     
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
		argLC.add(root);// the first arg is the point 2 set object
		
         
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

	
	private static void performNodeAction(CGAction action, SootMethod root) {

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
	argLC.add(root);// the last argument is the default edge, for the former ones, I am not sure
	
     
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
	private static void CGNestedSync_setup(CallGraph toBuildG,
			SootMethod root) {
		CGCriteria criteria = new CGCriteria();// criteria:action pair to implement the AHGAtomicSetTosser
		{
		   /// choose and set the criteria	
			criteria.methodname ="nestedSync";
			criteria.argList= new  ArrayList();// later on there is the path stack
			//CodeBlockRWSet cbSet = new  CodeBlockRWSet();
			
		}
        
		CGAction action = new CGAction();
		{
			action.methodname="storeNestedSync";
		    action.argList = new  ArrayList();
		    Set set = new HashSet();
		    action.argList.add(set);// later on there is the edge to processed
		}	
		CGAction action2 = new CGAction();// no highlight, but still drawing
		{
			action2.methodname="donothing";
		    action2.argList = new  ArrayList();
		   
		}	
		
		cgvisit_dfs_pathselect(toBuildG, root, criteria, action,action2);//root is required
	     System.out.println("debug");		
	}

	private static void CGPathSelector_setup(
			CallGraph toBuildG,
			SootMethod root) {
		CGCriteria criteria = new CGCriteria();// criteria:action pair to implement the AHGPathSelector
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
		CGAction action = new CGAction();
		{
			action.methodname="addTarget2Set";
		    action.argList = new  ArrayList();
		    action.argList.add(hitSet);// later on there is the edge to processed
		}	
		CGAction action2 = new CGAction();
		{
			action2.methodname="donothing";
		    action2.argList = new  ArrayList();
		}
		cgvisit_dfs_pathselect(toBuildG, root, criteria, action,action2);//root is required
		
	}

	private static void CGViewDotAnalyzer_setup(CallGraph toBuildG, SootMethod root) {
		CGCriteria criteria = new CGCriteria();// criteria:action pair to implement the AHGViewdotanalyzer
		{
		   /// choose and set the criteria	
			criteria.methodname ="interestingOnly";//trivial
			criteria.argList= new  ArrayList();// later on there is the path stack
		}
		 DirectedPseudograph<String, DefaultEdge>  toDrawG=null;
		CGAction action = new CGAction();
		{
			action.methodname="drawEdgeInG";
		    action.argList = new  ArrayList();
		    toDrawG=  
		    	new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
		    action.argList.add(toDrawG);// later on there is the edge to processed
		}	
		CGAction action2 = new CGAction();
		{
			action2.methodname="donothing";
		    action2.argList = new  ArrayList();
		}
		cgvisit_dfs_pathselect(toBuildG, root, criteria, action, action2);//root is required
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


	private static void cgvisit_dfs_pathselect(CallGraph g, SootMethod root
			, CGCriteria criteria, CGAction action, CGAction action2) {
		// for root, stack is empty, no need to check it, we check at adding time. instead of the pop-process time
		Iterator<Edge> edgeIt  = g.edgesOutOf(root);
		while (edgeIt.hasNext()) {
			Edge edge = (Edge) edgeIt.next();
			SootMethod target = (SootMethod)edge.getTgt();// already content-based according to the constrcution
		
			
			if(!visited.contains(target))
			{
				visited.add(target);
				stack.push(edge);	

				if(satisfyPathCriteria(criteria, stack))
				{
					// do sth
					performAction(action, stack);		// add the edge to the arglist and execute the code	
					
				}
				else {
					performAction(action2, stack);
				}
				cgvisit_dfs_pathselect(g, target,criteria, action, action2);		
				stack.pop();
			}
			else {
				stack.push(edge);// multiple edges... not go into, but still need to process this edge 
				if(satisfyPathCriteria(criteria, stack))
				{
					// do sth
					performAction(action, stack);		
					
				}
				else {
					performAction(action2, stack);
				}
				stack.pop();
			}			
		
		}
		
		
	}

	private static void performAction(CGAction action, Stack<Edge> stack) {
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
		argLC.add(stack);// the last argument is the default edge, for the former ones, I am not sure
		
         
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

	private static boolean satisfyPathCriteria(CGCriteria criteria,
			Stack<Edge> stack) {
	     
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
	
	


	

}
