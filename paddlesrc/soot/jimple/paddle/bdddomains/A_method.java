package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_method extends Attribute {
    public final MethodDomain domain = (MethodDomain) MethodDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_method();
    
    public A_method() { super(); }
}
