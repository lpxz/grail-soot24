package pldi.locking.studyConcurrent;

import soot.SootMethod;

//store shared reads&writes in each synchronized method(sootMethod)
public class SynMethodInfo {
	private SynMethod synMethod;

	private int sharedReadNum;

	private int sharedWriteNum;
	
	public int getSharedReadNum() {
		return sharedReadNum;
	}

	public void setSharedReadNum(int sharedReadNum) {
		this.sharedReadNum = sharedReadNum;
	}

	public int getSharedWriteNum() {
		return sharedWriteNum;
	}

	public void setSharedWriteNum(int sharedWriteNum) {
		this.sharedWriteNum = sharedWriteNum;
	}

	public SynMethodInfo(SynMethod synMethod){
		this.synMethod = synMethod;
		this.sharedReadNum = 0;
		this.sharedWriteNum = 0;
	}

	public SynMethod getSynMethod() {
		return synMethod;
	}


	public void setSynMethod(SynMethod synMethod) {
		this.synMethod = synMethod;
	}

	public void addSharedRead() {
		this.sharedReadNum++;
	}

	public void addSharedWrite() {
		this.sharedWriteNum++;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof SynMethodInfo)){
			return false;
		}else{
			return ((SynMethodInfo) obj).getSynMethod().equals(this.synMethod);
		}
	}

	@Override
	public String toString() {
		return this.synMethod.toString() + ", R/W: " + sharedReadNum
				+ "/" + sharedWriteNum;
	}
}
