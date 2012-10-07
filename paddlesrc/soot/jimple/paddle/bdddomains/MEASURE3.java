package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MEASURE3 extends PhysicalDomain {
    public int bits() { return 14; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MEASURE3();
    
    public MEASURE3() { super(); }
}
