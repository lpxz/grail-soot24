package soot.jimple.paddle.bdddomains;

import jedd.*;

public class MC3 extends PhysicalDomain {
    public int bits() { return 16; }
    
    public static PhysicalDomain v() { return instance; }
    
    private static PhysicalDomain instance = new MC3();
    
    public MC3() { super(); }
}
