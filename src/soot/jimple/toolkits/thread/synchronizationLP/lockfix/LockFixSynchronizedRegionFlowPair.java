package soot.jimple.toolkits.thread.synchronizationLP.lockfix;



class LockFixSynchronizedRegionFlowPair
{
	// Information about the transactional region
	public CriticalSection tn;
	public boolean inside;

	LockFixSynchronizedRegionFlowPair(CriticalSection tn, boolean inside)
	{
		this.tn = tn;
		this.inside = inside;
	}
	
	LockFixSynchronizedRegionFlowPair(LockFixSynchronizedRegionFlowPair tfp)
	{
		this.tn = tfp.tn;
		this.inside = tfp.inside;
	}
	
	public void copy(LockFixSynchronizedRegionFlowPair tfp)
	{
		tfp.tn = this.tn;
		tfp.inside = this.inside;
	}

	public Object clone()
	{
		return new LockFixSynchronizedRegionFlowPair(tn, inside);
	}
	
    public boolean equals( Object other )
	{
//		G.v().out.print(".");
		if(other instanceof LockFixSynchronizedRegionFlowPair)
		{
			LockFixSynchronizedRegionFlowPair tfp = (LockFixSynchronizedRegionFlowPair) other;
			if(this.tn.IDNum == tfp.tn.IDNum) // && this.inside == tfp.inside)
				return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "[" + (inside ? "in," : "out,") + tn.toString() + "]";
	}
}
