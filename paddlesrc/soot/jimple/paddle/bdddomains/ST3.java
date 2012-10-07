package soot.jimple.paddle.bdddomains;

import jedd.*;

public class ST3 extends PhysicalDomain {
    public int bits() { return 0; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new ST3();
    
    public ST3() { super(); }
}
