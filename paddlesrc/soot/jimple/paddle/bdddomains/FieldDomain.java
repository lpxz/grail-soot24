package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class FieldDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getFieldNumberer()); }
    
    private final int bits = 14;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new FieldDomain();
    
    public FieldDomain() { super(); }
}
