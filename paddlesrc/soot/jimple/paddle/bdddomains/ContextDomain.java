package soot.jimple.paddle.bdddomains;

import soot.jimple.paddle.*;
import jedd.*;
import soot.*;

public class ContextDomain extends Domain {
    public Numberer numberer() { return new soot.util.JeddNumberer(Scene.v().getContextNumberer()); }
    
    private boolean isCallString() { return Scene.v().getContextNumberer() instanceof ContextStringNumberer; }
    
    private ContextStringNumberer csn() { return (ContextStringNumberer) Scene.v().getContextNumberer(); }
    
    public ContextDomain() {
        super();
        if (isCallString()) { usefulBits = csn().usefulBits(); } else {
            usefulBits = PaddleNumberers.v().contextDomain.usefulBits(); }
        numUsefulBits = 0;
        for (int i = 0; i < usefulBits.length; i++) { if (usefulBits[i]) numUsefulBits++; }
    }
    
    private int numUsefulBits = 0;
    
    public int numUsefulBits() { return numUsefulBits; }
    
    private final int bits = 60;
    
    public int maxBits() { return bits; }
    
    public static Domain v() { return instance; }
    
    private static Domain instance = new ContextDomain();
}
