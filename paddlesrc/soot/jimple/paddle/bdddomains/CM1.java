package soot.jimple.paddle.bdddomains;

import jedd.*;

public class CM1 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new CM1();
    
    public CM1() { super(); }
}
