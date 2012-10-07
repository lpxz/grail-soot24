package pldi.locking.studyConcurrent;

import soot.SootMethod;
import soot.jimple.toolkits.thread.AbstractRuntimeThread;

//store detail information of each synchronized method
public class SynMethod {
	AbstractRuntimeThread abt;
	SootMethod sootMethod;
	
	public SynMethod(SootMethod sm){
		abt = null;
		this.sootMethod = sm;
	}

	public SynMethod(AbstractRuntimeThread abt, SootMethod sm){
		this.abt = abt;
		this.sootMethod = sm;
	}
	
	public SootMethod getSootMethod() {
		return sootMethod;
	}

	public void setSootMethod(SootMethod sootMethod) {
		this.sootMethod = sootMethod;
	}
	
//	@Override
//	public String toString() {
//		return "Thread:" + abt.toString() + "\nSynMethod: " + sm.toString();
//	}

	@Override
	public String toString(){
		return "SynMethod:" + sootMethod.toString(); 
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof SynMethod))
			return false;
		else if(((SynMethod) obj).sootMethod.equals(this.sootMethod))
			return true;
		else
			return false;
	}
}
