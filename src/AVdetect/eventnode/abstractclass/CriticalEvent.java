package AVdetect.eventnode.abstractclass;

public abstract class CriticalEvent {

    long th= -1;
    long mem  = -1;
    long serialNO = -1;
    
    String classname = null;
    int lineNO = -1;
    
    public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getLineNO() {
		return lineNO;
	}
	public void setLineNO(int lineNO) {
		this.lineNO = lineNO;
	}
	public CriticalEvent(long thpara, long mempara)
    {
    	th= thpara;
    	mem = mempara;
    }
    public long getTh() {
		return th;
	}

	public void setTh(int th) {
		this.th = th;
	}

	public long getMem() {
		return mem;
	}

	public void setMem(int mem) {
		this.mem = mem;
	}
	
	

	
    
	public long getSerialNO() {
		return serialNO;
	}
	public void setSerialNO(long serialNO) {
		this.serialNO = serialNO;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
