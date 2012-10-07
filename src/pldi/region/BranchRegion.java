package pldi.region;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.Unit;

public class BranchRegion  extends LoopOrBranchRegion{


	public Object head =null;
	public Object outsideExit = null;
	public Set<Object> wholebranchBody = new HashSet<Object>();
	
	//===================for children born
     public Map<Object, List>  eachh2b  = new HashMap<Object, List>();
	//====================
//	public void setBranch(Object ph, Object pexit, Set<Object> pwholebody)
//	{
//		head = ph;
//		outsideExit = pexit;
//		wholebranchBody = pwholebody;
//		
//	}
     public void setHead(Object ph)
     {
    	 head =ph;
    	 
     }
     public void setOutsideExit(Object pexit)
     {
    	 outsideExit = pexit;
     }
     
     
     public void setWholeBody(Set pwholeBody)
     {
    	 wholebranchBody =pwholeBody;
    	 
     }
	public Object getHead()
	{
		return head;
	}
	public Object getOutsideExit()
	{
		return outsideExit;
	}
	public Set<Object> getWholeBranchBody()
	{
		return wholebranchBody;
	}
	
	
	public void selfReport()
	{
		System.out.println("\n=============================");
		System.out.println("head:" +head);
		System.out.println("outsideExit "+ outsideExit);
        System.out.println("body:");
//		Set body = wholebranchBody;
//		for (Iterator iterator = body.iterator(); iterator.hasNext();) {
//			Object object = (Object) iterator.next();
//			System.out.println(object);		
//		}
        Iterator it = eachh2b.keySet().iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			System.out.println("under this branch:" + object);
			List branchBody = eachh2b.get(object);
			for (Iterator iterator = branchBody.iterator(); iterator.hasNext();) {
				Object bstmt = (Object) iterator.next();
				System.out.println(bstmt);			
			}
		}
        System.out.println("=============================\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
