package pldi.region;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import soot.Unit;

public class LoopRegion extends LoopOrBranchRegion{


	public Object head =null;
	//public Object backsrc = null;
	public Set<Object> wholeloopbody = null;
	public Object outsideExit = null;
	public Set backsrcs = null;
	public Set getBacksrcs() {
		return backsrcs;
	}
	public void setBacksrcs(Set backsrcs) {
		this.backsrcs = backsrcs;
	}
	public Set getInternalExits() {
		return internalexits;
	}
	public void setInternalExits(Set exits) {
		this.internalexits = exits;
	}
	public Set internalexits = null;
	
	
	//================pureBody, for children born...
	public List  iterateBody = null;
	
	
	public List getIterateBody() {
		return iterateBody;
	}
	public void setIterateBody(List iterateBody) {
		this.iterateBody = iterateBody;
	}
	//============================
//	public void setLoop(Object ph, Object pback, Object poutside,  Set<Object> ploopbody)
//	{
//		head = ph;
//		backsrc = pback;
//		loopbody = ploopbody;
//		outsideExit =poutside;
//	}
	public Object getHead()
	{
		return head;
	}
	public void setHead(Object head) {
		this.head = head;
	}

	public void setLoopbody(Set<Object> loopbody) {
		this.wholeloopbody = loopbody;
	}
	public void setOutsideExit(Object outsideExit) {
		this.outsideExit = outsideExit;
	}

	public Set<Object> getLoopBody()
	{
		return wholeloopbody;
	}
	public Object getOutside()
	{
		return outsideExit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void selfReport()
	{
		System.out.println("\n=============================");
		System.out.println("head:" +head);
		System.out.println("outsideExit "+ outsideExit);
		// backsrc is already tracked. and it is done before nat-loop, internalexits.
		System.out.println("internal exits:");
		Set exits1 = internalexits;
		for (Iterator iterator = exits1.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
        System.out.println(" body:");
//		Set body = wholebranchBody;
//		for (Iterator iterator = body.iterator(); iterator.hasNext();) {
//			Object object = (Object) iterator.next();
//			System.out.println(object);		
//		}
        Set itbody = wholeloopbody;
        for (Iterator iterator = itbody.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			
			System.out.println(object);
			
		}
        
        System.out.println("=============================\n");
	}

}
