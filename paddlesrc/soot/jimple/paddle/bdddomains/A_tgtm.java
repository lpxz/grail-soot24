package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_tgtm extends Attribute {
    public final MethodDomain domain = (MethodDomain) MethodDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_tgtm();
    
    public A_tgtm() { super(); }
}
