package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MEASURE4 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MEASURE4();
    
    public MEASURE4() { super(); }
}
