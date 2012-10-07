package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MEASURE2 extends PhysicalDomain {
    public int bits() { return 17; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MEASURE2();
    
    public MEASURE2() { super(); }
}
