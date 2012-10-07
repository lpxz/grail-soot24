package soot.jimple.paddle.bdddomains;

import jedd.*;

public class M3 extends PhysicalDomain {
    public int bits() { return 16; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new M3();
    
    public M3() { super(); }
}
