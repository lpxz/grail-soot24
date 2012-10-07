package pldi.region;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import soot.Body;
import soot.Unit;
import soot.jimple.Stmt;

//import soot.toolkits.scalar.Pair;

public class HRGnode {
	//public static List emptyList = new  ArrayList();
	public enum HRGnType {
		UNIT, LOOP, BRANCH, ROOT,XREGION
	}
	
	public HRGnType hrgnType =null; 
	public HRGnType getHrgnType() {
		return hrgnType;
	}
	public void setHrgnType(HRGnType hrgnType) {
		this.hrgnType = hrgnType;
	}


	//=====================content:
	public Object content = null;
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	//=====================chain
	


    public HRGnode parent = null;
	public List<HRGnode> children = null;//new ArrayList();
	public void setChildren(List<HRGnode> children) {
		this.children = children;
	}


//	public HRGnode next = null;
//	public HRGnode previous =null;
//	public HRGnode getNext() {
//		return next;
//	}
//	public void setNext(HRGnode next) {
//		this.next = next;
//	}
	public void addChild(HRGnode e)
	{
		if(children ==null)
		{
			children = new  ArrayList<HRGnode>();
		}
		children.add(e);
	}
	public List<HRGnode> getChildren()
	{
		if(children==null)
		{
			children=  new  LinkedList<HRGnode>();
		}
		return children;
	}
	
	public HRGnode getParent() {
		return parent;
	}
	public void setParent(HRGnode parent) {
		this.parent = parent;
	}
//	public HRGnode getPrevious() {
//		return previous;
//	}
//	public void setPrevious(HRGnode previous) {
//		this.previous = previous;
//	}
	
	
	public String toString()
	{
		
	     if(content instanceof LoopOrBranchRegion)
	     {
	    	 LoopOrBranchRegion tmp  = (LoopOrBranchRegion) content;
	    	 if(tmp.getHead()==null)
	    	 {
	    		 System.err.println("type has no null head?: " + tmp.getClass());
	    		 return "null";
	    	 }
	    	 return tmp.getHead().toString();
	     }
	     else if(content instanceof Body){
			return ((Body) content).getMethod().getName()+" 's body";
	    	 
		}

	     else if (content instanceof Stmt) {
	    	 Stmt tmp = (Stmt) content;
	    	 return tmp.toString();
	    
			
		}
	     else {
	    	 return "neither LoopOrBranch, nor Body";
			
		}
	}

	

}
