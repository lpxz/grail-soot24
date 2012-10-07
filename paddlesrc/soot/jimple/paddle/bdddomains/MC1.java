package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MC1 extends PhysicalDomain {
    public int bits() { return 16; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MC1();
    
    public MC1() { super(); }
}
