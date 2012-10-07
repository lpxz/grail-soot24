package AVfix.node.abstractclass;

import soot.jimple.Stmt;

public abstract class ConcreteStatement extends Statement{
	Stmt jimpleStmt  ;

	public Stmt getJimpleStmt() {
		return jimpleStmt;
	}

	public void setJimpleStmt(Stmt jimpleStmt) {
		this.jimpleStmt = jimpleStmt;
	}
}
