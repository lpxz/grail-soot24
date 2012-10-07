package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_kind extends Attribute {
    public final KindDomain domain = (KindDomain) KindDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_kind();
    
    public A_kind() { super(); }
}
