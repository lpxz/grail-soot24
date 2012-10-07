package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_obj extends Attribute {
    public final ObjDomain domain = (ObjDomain) ObjDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_obj();
    
    public A_obj() { super(); }
}
