package AVfix.node;

import AVfix.node.abstractclass.ConcreteStatement;
import AVfix.node.abstractclass.Statement;

public class InvokeBeginStatement extends ConcreteStatement{

	public void setComplete(CommonLocalStatement invokeNode) {
		this.setJimpleStmt(invokeNode.getJimpleStmt());
		this.setMsig(invokeNode.getMsig());
		this.setStes(invokeNode.getStes());
		
	}

	

}
