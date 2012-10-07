package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MC2 extends PhysicalDomain {
    public int bits() { return 16; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MC2();
    
    public MC2() { super(); }
}
