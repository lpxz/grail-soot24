package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_signature extends Attribute {
    public final SigDomain domain = (SigDomain) SigDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_signature();
    
    public A_signature() { super(); }
}
