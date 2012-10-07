package soot.jimple.paddle.bdddomains;

import jedd.*;

public class CM2 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new CM2();
    
    public CM2() { super(); }
}
