package soot.jimple.paddle.bdddomains;

import jedd.*;

public class ST2 extends PhysicalDomain {
    public int bits() { return 0; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new ST2();
    
    public ST2() { super(); }
}
