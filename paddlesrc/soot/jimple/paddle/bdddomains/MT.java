package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MT extends PhysicalDomain {
    public int bits() { return 16; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MT();
    
    public MT() { super(); }
}
