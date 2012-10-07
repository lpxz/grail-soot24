package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.jimple.paddle.*;
import soot.*;

public class ObjDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(PaddleNumberers.v().allocNodeNumberer()); }
    
    private final int bits = 14;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new ObjDomain();
    
    public ObjDomain() { super(); }
}
