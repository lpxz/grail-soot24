package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class KindDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().kindNumberer()); }
    
    private final int bits = 4;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new KindDomain();
    
    public KindDomain() { super(); }
}
