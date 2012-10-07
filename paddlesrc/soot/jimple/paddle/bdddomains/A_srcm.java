package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_srcm extends Attribute {
    public final MethodDomain domain = (MethodDomain) MethodDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_srcm();
    
    public A_srcm() { super(); }
}
