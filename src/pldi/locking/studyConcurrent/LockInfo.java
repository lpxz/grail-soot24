package pldi.locking.studyConcurrent;

public class LockInfo {
	private LockDetail lockDetail;

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

	public LockInfo(LockDetail lockDetail){
		this.lockDetail = lockDetail;
		this.sharedReadNum = 0;
		this.sharedWriteNum = 0;
	}

	public LockDetail getLockDetail() {
		return this.lockDetail;
	}


	public void setLockDetail(LockDetail lockDetail) {
		this.lockDetail = lockDetail;
	}

	public void addSharedRead() {
		this.sharedReadNum++;
	}

	public void addSharedWrite() {
		this.sharedWriteNum++;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof LockInfo)){
			return false;
		}else{
			return ((LockInfo) obj).getLockDetail().equals(this.lockDetail);
		}
	}

	@Override
	public String toString() {
		return this.lockDetail.toString() + ", R/W: " + sharedReadNum
				+ "/" + sharedWriteNum;
	}
}
