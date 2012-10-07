package soot.jimple.paddle.bdddomains;

import jedd.*;

public class CH1 extends PhysicalDomain {
    public int bits() { return 60; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new CH1();
    
    public CH1() { super(); }
}
