package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_shadow extends Attribute {
    public final ShadowDomain domain = (ShadowDomain) ShadowDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_shadow();
    
    public A_shadow() { super(); }
}
