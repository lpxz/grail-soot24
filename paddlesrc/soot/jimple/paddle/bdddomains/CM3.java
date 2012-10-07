package soot.jimple.paddle.bdddomains;

import jedd.*;

public class CM3 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new CM3();
    
    public CM3() { super(); }
}
