package pldi.locking.studyConcurrent;

import soot.SootMethod;
import soot.jimple.toolkits.thread.AbstractRuntimeThread;

public class LockDetail {
	AbstractRuntimeThread abt;
	SootMethod sootMethod;
	int id;
	
	public LockDetail(SootMethod sm, int id){
		abt = null;
		this.sootMethod = sm;
		this.id = id;
	}

	public LockDetail(AbstractRuntimeThread abt, SootMethod sm, int id){
		this.abt = abt;
		this.sootMethod = sm;
		this.id = id;
	}
	
	public SootMethod getSootMethod() {
		return sootMethod;
	}

	public void setSootMethod(SootMethod sootMethod) {
		this.sootMethod = sootMethod;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	@Override
	public String toString(){
		return "LockMethod:" + sootMethod.toString()+", id:"+id; 
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof LockDetail))
			return false;
		else if((((LockDetail) obj).sootMethod.equals(this.sootMethod))&&(((LockDetail) obj).id == this.id))
			return true;
		else
			return false;
	}
}
