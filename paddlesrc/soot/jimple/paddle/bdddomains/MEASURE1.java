package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MEASURE1 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MEASURE1();
    
    public MEASURE1() { super(); }
}
