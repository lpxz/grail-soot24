package pldi.locking.studyConcurrent;

import soot.SootMethod;
import soot.Value;
import soot.jimple.toolkits.thread.AbstractRuntimeThread;

public class SynBlock {
	AbstractRuntimeThread abt;
	SootMethod sootMethod;
	int id;
	Value op;
	
	public SynBlock(SootMethod sm, int id, Value op){
		abt = null;
		this.sootMethod = sm;
		this.id = id;
		this.op = op;
	}

	public SynBlock(AbstractRuntimeThread abt, SootMethod sm, int id){
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
		return "SynBlock:" + sootMethod.toString()+", op:"+ op.toString() +", id:"+id; 
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof SynBlock))
			return false;
		else if((((SynBlock) obj).sootMethod.equals(this.sootMethod))&&(((SynBlock) obj).id == this.id))
			return true;
		else
			return false;
	}
}
