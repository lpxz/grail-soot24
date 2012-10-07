package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_supt extends Attribute {
    public final TypeDomain domain = (TypeDomain) TypeDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_supt();
    
    public A_supt() { super(); }
}
