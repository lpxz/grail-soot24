package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_fld extends Attribute {
    public final FieldDomain domain = (FieldDomain) FieldDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_fld();
    
    public A_fld() { super(); }
}
