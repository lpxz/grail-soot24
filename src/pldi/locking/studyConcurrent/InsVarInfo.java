package pldi.locking.studyConcurrent;

import java.util.ArrayList;

import soot.SootField;
import soot.Value;

//store information of shared instance variables
public class InsVarInfo {
	
	private SootField sootfield = null;

	private ArrayList<InsVarDetail> detail = new ArrayList<InsVarDetail>();

	public ArrayList<InsVarDetail> getDetail() {
		return detail;
	}

	public void setDetail(ArrayList<InsVarDetail> detail) {
		this.detail = detail;
	}

	public SootField getSootfield() {
		return sootfield;
	}

	public void setSootfield(SootField sootfield) {
		this.sootfield = sootfield;
	}

	public InsVarInfo(SootField sootfield) {
		this.sootfield = sootfield;
	}

	public void addInsVar(Value base) {
		for (InsVarDetail ivd : detail) {
			if (ivd.getBase().equals(base))
				return;
		}
		detail.add(new InsVarDetail(base));
		return;

	}

	public void readplus(Value base) {
		for (InsVarDetail ivd : detail) {
			if (ivd.getBase().equals(base)) {
				ivd.readplus();
				return;
			}
		}
		detail.add(new InsVarDetail(base, 1, 0));
		return;
	}

	public void writeplus(Value base) {
		for (InsVarDetail ivd : detail) {
			if (ivd.getBase().equals(base)) {
				ivd.writeplus();
				return;
			}
		}
		detail.add(new InsVarDetail(base, 0, 1));
		return;
	}

	public void setShared(Value base, boolean isShared) {
		for (InsVarDetail ivd : detail) {
			if (ivd.getBase().equals(base)) {
				ivd.setShared(isShared);
				return;
			}
		}
		detail.add(new InsVarDetail(base, 0, 0, true));
		return;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof InsVarInfo)) {
			return false;
		} else {
			return ((InsVarInfo) obj).sootfield.equals(this.sootfield);
		}
	}

	@Override
	public String toString() {
		String str = sootfield.toString();
		str = str + "\nDetail:\n";
		for (InsVarDetail ivd : detail)
			str = str + ivd.toString() + "\n";
		return str;
	}
}
