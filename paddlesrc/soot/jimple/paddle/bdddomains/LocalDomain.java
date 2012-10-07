package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.jimple.paddle.*;
import soot.*;

public class LocalDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getLocalNumberer()); }
    
    private final int bits = 17;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new LocalDomain();
    
    public LocalDomain() { super(); }
}
