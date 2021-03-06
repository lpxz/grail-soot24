package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class StmtDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getUnitNumberer()); }
    
    private final int bits = 18;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new StmtDomain();
    
    public StmtDomain() { super(); }
}
