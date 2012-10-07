package popl.petrinet.element;

import soot.jimple.Stmt;

public class Node {

   public Object entity = null;
	public Object getEntity() {
	return entity;
}
public void setEntity(Object stmt) {
	this.entity = stmt;
}


public String toString() {

	if(entity==null)
	{
		return "" +this.hashCode();
	}
	else {
		return ""+ this.hashCode() + entity.toString();
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
