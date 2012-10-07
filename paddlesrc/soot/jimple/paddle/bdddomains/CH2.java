package soot.jimple.paddle.bdddomains;

import jedd.*;

public class CH2 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new CH2();
    
    public CH2() { super(); }
}
