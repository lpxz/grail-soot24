package aTSE.aTSE.OG;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
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

public class OGTraverse {
	//========protocol region
	 // sb.append("."+str);  e.g.,   .f.f2.f3
	//========
	public static String ARRAYFIELD= "ARRAYFIELD" ;
	private static final int threshold = 100;
	public static final boolean FullArray = false;// expand all the cells? or use one representative?
	private static final boolean interSuperOnly = true;
	public static boolean interOnly=true;
	private static  Class objectClass =null;
	private static boolean specialAllowUtil= true;
	private static boolean noFinal = true;
	public static boolean expandXXX= true;
	
	
	static{
		try {
			objectClass=Class.forName("java.lang.Object");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static HashSet<Object> visited = null;
	public static Stack<Object> stack = null;// Field or Integer
	private static String criteriaString = "aTSE.OG.OGCriteria";
	private static String actionString = "aTSE.OG.OGAction";
	// private static DirectedPseudograph<String, DefaultEdge> toDrawG;
	static DOTExporter<String, DefaultEdge> dotEx = new DOTExporter<String, DefaultEdge>();
	public static boolean childset2null=false;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
// entry:
	//run aTest.Teacher to see how the invocations happen.
	public static void ogvisit_root(HashMap<Object, HashSet> setmap,Object root)  {
		if (root == null)
			throw new RuntimeException();
		try {
			
			 setupCacheStack(root);
				//	OGViewDotAnalyzer_setup(  root);			
					DirectedPseudograph<String, DefaultEdge> drawG = 
						OGViewDotAnalyzerColorSE_approximate_setup(setmap, root);
					Set<String> exps = DrawGraphHelper.collectXXXExpr(drawG, OGAction.getOName(root));
					
					setupCacheStack(root);
					OGTailor_approximate_setup(exps,root);
					System.err.println(root);
					
					
		} catch (Exception e) {
			// TODO: handle exception
		}

		   
		


		// =============================node-based:
		//OG_nodebased_setup(root); // 

	}



	private static void setupCacheStack(Object root) {
		visited = new HashSet<Object>();
		stack = new Stack<Object>();
		if (!visited.contains(root)) {
			visited.add(root);// the adding time is here for the root
		}
	}



	/*
	 * node based:
	 */
	private static void OG_nodebased_setup(Object root) {
		OGCriteria criteria = new OGCriteria();// criteria:action pair to
												// implement the
												// AHGAtomicSetTosser
		{
			// / choose and set the criteria
			criteria.methodname = "trivial_nodebased";
			criteria.argList = new ArrayList();// later on there is the path
												// stack
			// CodeBlockRWSet cbSet = new CodeBlockRWSet();

		}

		OGAction action = new OGAction();
		{
			action.methodname = "donothing_nodebased";
			action.argList = new ArrayList();
			

		}
		OGAction action2 = new OGAction();// no highlight, but still drawing
		{
			action2.methodname = "donothing_nodebased";
			action2.argList = new ArrayList();

		}
		ogvisit_dfs_nodeselect(root, criteria, action, action2);// to fix
		System.out.println("");

	}

	private static void ogvisit_dfs_nodeselect(Object root,
			OGCriteria criteria, OGAction action, OGAction action2) {
		// for root, stack is empty, no need to check it, we check at adding
		// time. instead of the pop-process time
		if (satisfyNodeCriteria(criteria, root)) {
			performNodeAction(action, root);

			// do sth
		} else {
			performNodeAction(action2, root);
		}
        if(root==null) return;
		Set childSet = children(root);
		if(childSet==null){ return ; }
		
		Iterator<Object> childs = childSet.iterator();
		while (childs.hasNext()) {
			Object child = (Object) childs.next();
			if (!visited.contains(child)) {
				visited.add(child);
				ogvisit_dfs_nodeselect(child, criteria, action, action2);

			}

		}

	}

	public static Set<Object> children(Object root) {
		Set<Object> os = new HashSet<Object>();
		try {
			Class c = root.getClass();
			if(c.isArray())
			{
				int length = Array.getLength(root);
				for(int i=0;i< length; i++)
				{
					Object elem = Array.get(root, i);
				    os.add(elem);
				}
				
			}else {
				Set<Class> supers= getSuperClasses(c);
				for(Class superClass:supers)
				{
					Field[] fs=superClass.getDeclaredFields();
					for (Field f : fs) {
						
						if(noFinal)
				    	{
				    		if((f.getModifiers() & Modifier.FINAL )==0)
				    		{  
				    		f.setAccessible(true);
							Object child = f.get(root);
							os.add(child); 
							}
				    	}
				    	else {
				    		f.setAccessible(true);
							Object child = f.get(root);
							os.add(child);
						}
						
						
					}
				}
				
			}
			
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return os;
	}
	
	// include itself!
	private static Set<Class> getSuperClasses(Class c){
		Set<Class> ret = new HashSet<Class>();
		
		if(interSuperOnly)
		{
			if(!islibraryCode(c))
			{
				ret.add(c);
			}
			
		}
		else {
			ret.add(c);
		}
		Class tmpClass = c;
		while((tmpClass= tmpClass.getSuperclass())!= objectClass)
		{
			if(interSuperOnly)
			{
				if(!islibraryCode(tmpClass))
				{
					ret.add(tmpClass);
				}
				
			}
			else {
				ret.add(tmpClass);
			}
		}		
		return ret;
	}

	public static Set<Field> childrenFields_nonArrayEle(Object root) {		
		Set<Field> fset = new HashSet<Field>();
		if(root==null) return fset;
		try {
			Class c = root.getClass();
			Set<Class> supers= getSuperClasses(c);
			for(Class superClass:supers)
			{			
				Field[] fs = superClass.getDeclaredFields();		
				for(Field f : fs)
				{
				    	if(noFinal)
				    	{
				    		if((f.getModifiers() & Modifier.FINAL )==0)// good, not final
				    		{
				    			fset.add(f); 
				    		}
				    	}
				    	else {
				    		fset.add(f);
						}
					
				}
			}			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fset;
	}
	

	private static boolean satisfyNodeCriteria(OGCriteria criteria, Object root) {

		Class cls;
		Method torun = null;
		try {
			cls = Class.forName(criteriaString);
			String metC = criteria.methodname;
			Method[] methodsR = cls.getMethods();
			for (int i = 0; i < methodsR.length; i++) {
				Method mR = methodsR[i];
				if (mR.getName().equals(metC)) {
					torun = mR;
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
			Boolean retobj = (Boolean) torun.invoke(criteria, argLC.toArray());// method(this,
																				// object...)
			if (retobj.booleanValue()) {
				return true;
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private static void performNodeAction(OGAction action, Object root) {

		Class cls;
		Method torun = null;
		try {
			cls = Class.forName(actionString);
			String metC = action.methodname;
			Method[] methodsR = cls.getMethods();
			for (int i = 0; i < methodsR.length; i++) {
				Method mR = methodsR[i];
				if (mR.getName().equals(metC)) {
					torun = mR;
					break;
				}
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List argLC = new ArrayList();
		argLC.addAll(action.argList);
		argLC.add(root);// the last argument is the default edge, for the former
						// ones, I am not sure

		try {
			torun.invoke(action, argLC.toArray());// method(this, object...)

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * =======================================================PATH based: **
	 */
	private static void OGTailor_approximate_setup(Set<String> exps, Object root) throws IllegalArgumentException, IllegalAccessException {	


		OGCriteria criteria = new OGCriteria();// criteria:action pair to
		{
			// / choose and set the criteria
			criteria.methodname = "interestingOnly4path";// trivial
			criteria.argList = new ArrayList();// later on there is the path
			criteria.argList.add(exps);								
			
		}
		DirectedPseudograph<String, DefaultEdge> toDrawG = null;
		OGAction action = new OGAction();
		{
			action.methodname = "donothing";
			action.argList = new ArrayList();										
		}
		OGAction action2 = new OGAction();
		{
			action2.methodname = "set2null";
			action2.argList = new ArrayList();

		}
		int depth =0;
		ogvisit_dfs_pathselect( root, depth, criteria, action, action2);// root

	
	}
	

	private static DirectedPseudograph<String, DefaultEdge> OGViewDotAnalyzerColorSE_approximate_setup(HashMap<Object, HashSet> setmap,Object root
			 ) throws IllegalArgumentException, IllegalAccessException {
		OGCriteria criteria = new OGCriteria();// criteria:action pair to
		{
			// / choose and set the criteria
			criteria.methodname = "interestingOnly";// trivial
			criteria.argList = new ArrayList();// later on there is the path
			criteria.argList.add(setmap);								
			
		}
		DirectedPseudograph<String, DefaultEdge> toDrawG = null;
		OGAction action = new OGAction();
		{
			action.methodname = "highlightEdgeInG";
			action.argList = new ArrayList();
			toDrawG = new DirectedPseudograph<String, DefaultEdge>(
					DefaultEdge.class);
			action.argList.add(toDrawG);// later on there is the edge to
										
		}
		OGAction action2 = new OGAction();
		{
			action2.methodname = "drawEdgeInG";
			action2.argList = new ArrayList();
            // reuse the toDrawG, on the same canvas
			action2.argList.add(toDrawG);// later on there is the edge to
		}
		int depth =0;
		ogvisit_dfs_pathselect( root, depth, criteria, action, action2);// root
		if(expandXXX)
		{
		DrawGraphHelper.expandXXXMark(OGAction.getOName(root),toDrawG);// all are string-based
		}
		
		
		exportDot(toDrawG);
		return toDrawG;
		}
	



	private static void OGViewDotAnalyzer_setup(Object root) throws IllegalArgumentException, IllegalAccessException {
		OGCriteria criteria = new OGCriteria();// criteria:action pair to
												// implement the
												// AHGViewdotanalyzer
		{
			// / choose and set the criteria
			criteria.methodname = "trivial";// trivial
			criteria.argList = new ArrayList();// later on there is the path
												// stack
		}
		DirectedPseudograph<String, DefaultEdge> toDrawG = null;
		OGAction action = new OGAction();
		{
			action.methodname = "drawEdgeInG";
			action.argList = new ArrayList();
			toDrawG = new DirectedPseudograph<String, DefaultEdge>(
					DefaultEdge.class);
			action.argList.add(toDrawG);// later on there is the edge to
										// processed
		}
		OGAction action2 = new OGAction();
		{
			action2.methodname = "donothing";
			action2.argList = new ArrayList();
		}
		int depth =0;
		ogvisit_dfs_pathselect( root, depth, criteria, action, action2);// root
		exportDot(toDrawG);
		}

	private static void exportDot(
			DirectedPseudograph<String, DefaultEdge> toDrawG) {
		File file = new File("graph" + toDrawG.hashCode() + ".dot");
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			dotEx.export4AHG(fw, toDrawG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// this function decides whether to stop traversal
	// while the satisfypathcriteria decides whether to draw or not.
	private static void ogvisit_dfs_pathselect( Object root, int depth,
			OGCriteria criteria, OGAction action, OGAction action2) throws IllegalArgumentException, IllegalAccessException {
		// for root, stack is empty, no need to check it, we check at adding
		// time. instead of the pop-process time
		if(!isInterServer(root)) return; // null is not interesting.
		if(depth>= threshold) return; // stop the recursive inspection.
		//System.err.println("" + depth+ "-> "+ root.toString() );
		Class c =root.getClass();
		if(c.isArray())
		{
			int length =Array.getLength(root);
			if(!FullArray) length =1;
			for(int i=0;i<length; i++)// IT IS TOO LONG
			{
				
				Object target = Array.get(root, i);
           
				Integer iObject = new Integer(i);
				if (!visited.contains(target)) {
					visited.add(target);
					stack.push(iObject);
					if (satisfyPathCriteria(criteria, stack, root, target)) {
						// do sth
						performAction(action, stack, root,target); // add the edge to the arglist
														
					} else {
						performAction(action2, stack, root,target);
					}
					if(!childset2null)//specially serve for OGTailor...
					{
						ogvisit_dfs_pathselect( target, ++depth, criteria, action, action2);
					}
					childset2null=false;//recover to normal after the functional code
					stack.pop();
				} else {
					stack.push(iObject);// multiple edges... not go into, but still
										// need to process this edge
					if (satisfyPathCriteria(criteria, stack, root, target)) {
						// do sth
						performAction(action, stack, root,target);

					} else {
						performAction(action2, stack, root,target);
					}
					stack.pop();
				}					
			}			
		}
		else {
			Set<Field> fSet =childrenFields_nonArrayEle(root);
			Iterator<Field> fit = fSet.iterator();		
			while (fit.hasNext()) {
				Field edge = (Field) fit.next();
				edge.setAccessible(true);
				Object target = edge.get(root);
			
				
				if (!visited.contains(target)) {
					visited.add(target);
					stack.push(edge);
					if (satisfyPathCriteria(criteria, stack, root, target)) {
						// do sth
						performAction(action, stack, root,target); // add the edge to the arglist
														
					} else {
						performAction(action2, stack, root,target);
					}
					if(!childset2null)//specially serve for OGTailor...
					{
						ogvisit_dfs_pathselect( target, ++depth, criteria, action, action2);
					}
					childset2null=false;//recover to normal after the functional code
					stack.pop();
				} else {
					stack.push(edge);// multiple edges... not go into, but still
										// need to process this edge
					if (satisfyPathCriteria(criteria, stack, root, target)) {
						// do sth
						performAction(action, stack, root,target);

					} else {
						performAction(action2, stack, root,target);
					}
					stack.pop();
				}				
			}
		}
		
		
		

	}

	private static boolean isInterServer(Object target) {
		if(!interOnly) throw new RuntimeException();// inspect the callers.
		if(target==null) return false;
		Class targetClass = target.getClass();
		if(islibraryCode(targetClass)) return false;
		return true;
	}

	private static boolean islibraryCode(Class targetclass) {
		String classname =targetclass.getName();
		if (targetclass.isPrimitive()) {// treeeat as lib
			return true;			
		}
		if(specialAllowUtil)
		{// special treatment.
			if(classname.startsWith("java.util."))// speciall
			{
				return false;
			}
		}
		
		if(classname.startsWith("java.") || classname.startsWith("javax.")
				||classname.startsWith("sun.")||
				classname.startsWith("javax.")||
				classname.startsWith("com.sun.")||
				classname.startsWith("com.ibm.")||
				classname.startsWith("org.xml.")||
				classname.startsWith("org.w3c.")||
				classname.startsWith("com.apple."))
       
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	private static void performAction(OGAction action, Stack stack, Object root, Object target) {
		Class cls;
		Method torun = null;
		try {
			cls = Class.forName(actionString);
			String metC = action.methodname;
			Method[] methodsR = cls.getMethods();
			for (int i = 0; i < methodsR.length; i++) {
				Method mR = methodsR[i];
				if (mR.getName().equals(metC)) {
					torun = mR;
					break;
				}
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List argLC = new ArrayList();
		argLC.addAll(action.argList);
		argLC.add(stack);// the last argument is the default edge, for the
							// former ones, I am not sure
		argLC.add(root);
		argLC.add(target);

		try {
			torun.invoke(action, argLC.toArray());// method(this, object...)

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean satisfyPathCriteria(OGCriteria criteria,
			Stack stack, Object root,  Object target) {

		Class cls;
		Method torun = null;
		try {
			cls = Class.forName(criteriaString);
			String metC = criteria.methodname;
			Method[] methodsR = cls.getMethods();
			for (int i = 0; i < methodsR.length; i++) {
				Method mR = methodsR[i];
				if (mR.getName().equals(metC)) {
					torun = mR;
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
		argLC.add(root);
		argLC.add(target);

		try {
			Boolean retobj = (Boolean) torun.invoke(criteria, argLC.toArray());// method(this,
																				// object...)
			if (retobj.booleanValue()) {
				return true;
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
