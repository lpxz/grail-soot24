package pldi.locking.studyConcurrent;

import soot.SootClass;
import soot.SootMethod;

public class ThreadDetail {
	SootClass sootClass;
	SootMethod sootMethod;

	public ThreadDetail(SootClass sc, SootMethod sm) {
		this.sootClass = sc;
		this.sootMethod = sm;
	}

	public SootClass getSootClass() {
		return sootClass;
	}

	public void setSootClass(SootClass sootClass) {
		this.sootClass = sootClass;
	}

	public SootMethod getSootMethod() {
		return sootMethod;
	}

	public void setSootMethod(SootMethod sootMethod) {
		this.sootMethod = sootMethod;
	}

	@Override
	public String toString() {
		return "ThreadClass:" + sootClass.toString() + ", ThreadMethod: "
				+ sootMethod.getName();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ThreadDetail))
			return false;
		else if ((((ThreadDetail) obj).sootClass.equals(this.sootClass))
				&& (((ThreadDetail) obj).sootMethod.equals(this.sootMethod)))
			return true;
		else
			return false;
	}
}
