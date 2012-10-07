package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MEASURE15 extends PhysicalDomain {
    public int bits() { return 16; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MEASURE15();
    
    public MEASURE15() { super(); }
}
