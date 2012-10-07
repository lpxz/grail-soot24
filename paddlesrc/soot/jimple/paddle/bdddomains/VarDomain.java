package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.jimple.paddle.*;
import soot.*;

public class VarDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(PaddleNumberers.v().varNodeNumberer()); }
    
    private final int bits = 17;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new VarDomain();
    
    public VarDomain() { super(); }
}
