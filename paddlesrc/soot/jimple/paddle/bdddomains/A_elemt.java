package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_elemt extends Attribute {
    public final TypeDomain domain = (TypeDomain) TypeDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_elemt();
    
    public A_elemt() { super(); }
}
