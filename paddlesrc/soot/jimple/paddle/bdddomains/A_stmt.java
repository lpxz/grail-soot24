package soot.jimple.paddle.bdddomains;

import jedd.*;
import soot.*;

public class A_stmt extends Attribute {
    public final StmtDomain domain = (StmtDomain) StmtDomain.v();
    
    public Domain domain() { return domain; }
    
    public static Attribute v() { return instance; }
    
    private static Attribute instance = new A_stmt();
    
    public A_stmt() { super(); }
}
