package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class SigDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getSubSigNumberer()); }
    
    private final int bits = 14;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new SigDomain();
    
    public SigDomain() { super(); }
}
