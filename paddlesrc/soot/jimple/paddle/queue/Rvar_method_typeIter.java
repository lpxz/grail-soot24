package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rvar_method_typeIter extends Rvar_method_type {
    protected Iterator r;
    
    public Rvar_method_typeIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                          this.r = r; }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { boolean ret = r.hasNext();
                                       return ret; }
            
            public Object next() { return new Tuple((VarNode) r.next(), (SootMethod) r.next(), (Type) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
        }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_method.v(), A_type.v() },
                                              new PhysicalDomain[] { V1.v(), MS.v(), T1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_method:soot.jimpl" +
                                               "e.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_type" +
                                               ":soot.jimple.paddle.bdddomains.T1> ret = jedd.internal.Jedd." +
                                               "v().falseBDD(); at Rvar_method_typeIter.jedd:46,43-46"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_var.v(), A_method.v(), A_type.v() },
                                                       new PhysicalDomain[] { V1.v(), MS.v(), T1.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v(), A_method.v() },
                                                   new PhysicalDomain[] { T1.v(), V1.v(), MS.v() },
                                                   "return ret; at Rvar_method_typeIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
