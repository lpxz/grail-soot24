package pldi.region;

import java.util.List;

public class XRegion extends LoopOrBranchRegion{

	public Object head = null;
	public Object outsideExit = null;
	public List   xBody = null;
	public Object getHead()
	{
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
