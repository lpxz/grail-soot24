package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_anyst extends Attribute {
    public final TypeDomain domain = (TypeDomain) TypeDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_anyst();
    
    public A_anyst() { super(); }
}
