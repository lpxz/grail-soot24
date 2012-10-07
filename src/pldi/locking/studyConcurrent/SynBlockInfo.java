package pldi.locking.studyConcurrent;

public class SynBlockInfo {
	private SynBlock synBlock;

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

	public SynBlockInfo(SynBlock synBlock){
		this.synBlock = synBlock;
		this.sharedReadNum = 0;
		this.sharedWriteNum = 0;
	}

	public SynBlock getSynBlock() {
		return this.synBlock;
	}


	public void setSynBlock(SynBlock synBlock) {
		this.synBlock = synBlock;
	}

	public void addSharedRead() {
		this.sharedReadNum++;
	}

	public void addSharedWrite() {
		this.sharedWriteNum++;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof SynBlockInfo)){
			return false;
		}else{
			return ((SynBlockInfo) obj).getSynBlock().equals(this.synBlock);
		}
	}

	@Override
	public String toString() {
		return this.synBlock.toString() + ", R/W: " + sharedReadNum
				+ "/" + sharedWriteNum;
	}
}
