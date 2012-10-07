package pldi.locking.studyConcurrent;

import soot.SootField;


//store information about shared static variables
public class StaVarInfo {
	private SootField sootfield = null;
	private int readaccess;
	private int writeaccess;
	private boolean isShared;
	
	public boolean isShared() {
		return isShared;
	}

	public void setShared(boolean isShared) {
		this.isShared = isShared;
	}

	public SootField getSootfield() {
		return sootfield;
	}

	public void setSootfield(SootField sootfield) {
		this.sootfield = sootfield;
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

	public StaVarInfo(SootField sf) {
		this.sootfield = sf;
		this.readaccess = 0;
		this.writeaccess = 0;
		this.isShared = false;
	}

	public StaVarInfo(SootField sf, int ra, int wa, boolean is) {
		this.sootfield = sf;
		this.readaccess = ra;
		this.writeaccess = wa;
		this.isShared = is;
	}

	public void readplus() {
		this.readaccess++;
	}

	public void writeplus() {
		this.writeaccess++;
	}

	@Override
	public int hashCode() {
		return (sootfield == null) ? 0 : sootfield.hashCode();
	}
	
	@Override
	public String toString() {
		return sootfield.toString() + ", read:" + this.readaccess + ", write:"
				+ this.writeaccess + ", isShared:" + this.isShared + ".";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof StaVarInfo)){
			return false;
		}else{
			return ((StaVarInfo) obj ).sootfield.equals(this.sootfield);
		}
	}

}
