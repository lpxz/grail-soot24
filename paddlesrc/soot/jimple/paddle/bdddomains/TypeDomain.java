package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class TypeDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getTypeNumberer()); }
    
    private final int bits = 13;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new TypeDomain();
    
    public TypeDomain() { super(); }
}
