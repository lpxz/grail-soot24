package pldi.locking.studyConcurrent;

import soot.Value;
import soot.jimple.toolkits.thread.AbstractRuntimeThread;

//store detail information of each shared instance variable
public class InsVarDetail {
	
	private Value base;

	private int readaccess;

	private int writeaccess;

	private boolean isShared;
	
	public InsVarDetail(Value base){
		this.base = base;
		this.readaccess = 0;
		this.writeaccess = 0;
		this.isShared = false;
	}
	
	public InsVarDetail(Value base, int readaccess, int writeaccess){
		this.base = base;
		this.readaccess = readaccess;
		this.writeaccess = writeaccess;
	}
	
	public InsVarDetail(Value base, int readaccess, int writeaccess, boolean isShared){
		this.base = base;
		this.readaccess = readaccess;
		this.writeaccess = writeaccess;
		this.isShared = isShared;
	}

	public Value getBase() {
		return base;
	}

	public void setBase(Value base) {
		this.base = base;
	}

	public int getReadaccess() {
		return readaccess;
	}

	public void setReadaccess(int readaccess) {
		this.readaccess = readaccess;
	}

	public int getWriteaccess() {
		return writeaccess;
	}

	public void setWriteaccess(int writeaccess) {
		this.writeaccess = writeaccess;
	}

	public boolean isShared() {
		return isShared;
	}

	public void setShared(boolean isShared) {
		this.isShared = isShared;
	}

	public void readplus() {
		this.readaccess++;
	}

	public void writeplus() {
		this.writeaccess++;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof InsVarDetail)) {
			return false;
		} else {
			return ((InsVarDetail) obj).base.equals(this.base);
		}
	}

	@Override
	public String toString() {
		return "base: " + this.base.toString() + ", R/W: " + this.readaccess
				+ "/" + this.writeaccess + ", isShared: " + this.isShared;
	}

}
