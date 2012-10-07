package AVfix.node.abstractclass;

import java.util.List;

public abstract class Statement {

    List<StackTraceElement> stes ;
    public List<StackTraceElement> getStes() {
		return stes;
	}

	public void setStes(List<StackTraceElement> stes) {
		this.stes = stes;
	}

	public String getMsig() {
		return msig;
	}

	public void setMsig(String msig) {
		this.msig = msig;
	}

	String msig ;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
