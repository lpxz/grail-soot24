package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class InfCFAContextDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getContextNumberer()); }
    
    private final int bits = 60;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new InfCFAContextDomain();
    
    public InfCFAContextDomain() { super(); }
}
