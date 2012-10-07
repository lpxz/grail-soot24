package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_basec extends Attribute {
    public final ContextDomain domain = (ContextDomain) ContextDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_basec();
    
    public A_basec() { super(); }
}
