package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_base extends Attribute {
    public final ObjDomain domain = (ObjDomain) ObjDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_base();
    
    public A_base() { super(); }
}
