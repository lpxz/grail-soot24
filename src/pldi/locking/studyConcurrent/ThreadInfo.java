package pldi.locking.studyConcurrent;

public class ThreadInfo {
	private ThreadDetail threadDetail;

	private int sharedReadNum;

	private int sharedWriteNum;
	
	public ThreadInfo(ThreadDetail threadDetail){
		this.threadDetail = threadDetail;
		this.sharedReadNum = 0;
		this.sharedWriteNum = 0;
	}

	public ThreadDetail getThreadDetail() {
		return this.threadDetail;
	}


	public void setThreadDetail(ThreadDetail threadDetail) {
		this.threadDetail = threadDetail;
	}

	public void addSharedRead() {
		this.sharedReadNum++;
	}

	public void addSharedWrite() {
		this.sharedWriteNum++;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof ThreadInfo)){
			return false;
		}else{
			return ((ThreadInfo) obj).getThreadDetail().equals(this.threadDetail);
		}
	}

	@Override
	public String toString() {
		return this.threadDetail.toString() + ", R/W: " + sharedReadNum
				+ "/" + sharedWriteNum;
	}
}
