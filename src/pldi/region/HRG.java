package pldi.region;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pldi.region.HRGnode.HRGnType;


import soot.Body;
import soot.Unit;
import soot.toolkits.graph.*;

public class HRG implements DirectedGraph{

	HRGnode root = null; 
	public HRGnode getRoot() {
		return root;
	}

	public void setRoot(HRGnode root) {
		this.root = root;		
	}

    public Set<HRGnode> HRGnodes =null;
    public Set<HRGnode> getHRGnodes()
    {
    	if(HRGnodes==null)
    	{
    		Set tmp = new HashSet<HRGnode>();
    		tmp.addAll(o2HRGnode.values());
    		HRGnodes =tmp;
    		return HRGnodes;
    	}
    	else {
			return HRGnodes;
		}
    }
	
	public Map<Object, HRGnode>  o2HRGnode = new  HashMap<Object, HRGnode>();
	public HRGnode getHNode(Object o)// cache usage
	{
		if(!o2HRGnode.containsKey(o))
		{
			o2HRGnode.put(o,HRGnodeFactory.makeNode(o));			
		}
		return o2HRGnode.get(o);	
	}

	
	
	
	public Map<HRGnode, Set<HRGnode>> HRGnode2children = new  HashMap<HRGnode, Set<HRGnode>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List getHeads() {
          List heads = new ArrayList<HRGnode>();
          heads.add(root);
          return heads;
		
	}

	public List getPredsOf(Object s) {// only one !!!, disjoint , or nested
		
		if(s instanceof HRGnode)
		{
			List list = new  ArrayList();
			HRGnode tmp = (HRGnode) s;
			list.add(tmp.getParent());
			return list;
			
		}
		else {
			
			return new ArrayList();
		}
		
		 
	}

	public List getSuccsOf(Object s) {
		
		if(s instanceof HRGnode)
		{
			HRGnode tmp = (HRGnode) s;
			return tmp.getChildren();
			 
			
		}
		else {
			System.out.println("s's type is :" + s.getClass());
			return null;
		}
		
	}

	public List getTails() {
		List toret = new  ArrayList();
        Set<HRGnode> nodes  = getHRGnodes();
        for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			HRGnode hrGnode = (HRGnode) iterator.next();
			if(hrGnode.getChildren()!=null && hrGnode.getChildren().size()==0)
			{
				toret.add(hrGnode);
			}			
		}
        return toret;	
	}

	public Iterator iterator() {// hope it is not called
		return getHRGnodes().iterator();		
		
		//return null;
	}

	public int size() {
		return getHRGnodes().size();
		
	}
	
	
	public static class HRGnodeFactory
	{
		public static HRGnode makeNode(Object u)
		{
			HRGnode node  = new  HRGnode();
			if(u instanceof Unit)
			{
				node.setHrgnType(HRGnType.UNIT);
			}
			else if(u instanceof LoopRegion) {
				node.setHrgnType(HRGnType.LOOP);
						
			}
			else if(u instanceof BranchRegion)
			{
				node.setHrgnType(HRGnType.BRANCH);
				
			}
			else if (u instanceof XRegion) {
				node.setHrgnType(HRGnType.XREGION);
			}
			else if (u instanceof Body) {
				node.setHrgnType(HRGnType.ROOT);
			}
			
			node.setContent(u);
			return node;			
		}
		
	}


	public void formParentRel(HRGnode nodel, HRGnode noder) {
		//==================centric management style
		Set children = HRGnode2children.get(nodel);
		if(children==null)
		{
			HRGnode2children.put(nodel, new  HashSet<HRGnode>());
		    children =HRGnode2children.get(nodel);
		}
		children.add(noder);
		//======================p2p style
		nodel.addChild(noder);	
		noder.setParent(nodel);
	}

	public HRGnode lca(HRGnode test1, HRGnode test2) {
		// use stupid, inefficient implementation temporarily, no time...
		if(test1 ==null || test2 ==null)
		{
			throw new RuntimeException("both should be of type HRGnode, and can not be null");
		}
		List test1path = getNodePath(test1);
		List test2path = getNodePath(test2);
		HRGnode really = null;
		for(int i=0; i<test1path.size();i++)
		{
			Object maybe= test1path.get(i);
			if(test2path.contains(maybe))
			{
				really = (HRGnode) maybe;
				break;// find it
			}
		}
	
		
		if(really ==null)
		{
			throw new RuntimeException("at least they should have common ancestor: root");
		}
		return really;
	}

	private List getNodePath(HRGnode test) {
		HRGnode test1 = test;
		List toret = new  ArrayList<HRGnode>();
		
		while(test1!=null )// root's father is null. || test1 != this.getRoot()
		{
			toret.add(test1);
			test1 =test1.getParent();
		}
		return toret;
	}

}
