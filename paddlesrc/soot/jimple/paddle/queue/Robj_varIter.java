package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Robj_varIter extends Robj_var {
    protected Iterator r;
    
    public Robj_varIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                  this.r = r; }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { boolean ret = r.hasNext();
                                       return ret; }
            
            public Object next() { return new Tuple((AllocNode) r.next(), (VarNode) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
        }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_var.v() },
                                              new PhysicalDomain[] { H1.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1, soot.jimple.paddle.bdddomains.A_var:soot.jimple.p" +
                                               "addle.bdddomains.V1> ret = jedd.internal.Jedd.v().falseBDD()" +
                                               "; at Robj_varIter.jedd:46,29-32"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next() },
                                                       new Attribute[] { A_obj.v(), A_var.v() },
                                                       new PhysicalDomain[] { H1.v(), V1.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                   new PhysicalDomain[] { V1.v(), H1.v() },
                                                   "return ret; at Robj_varIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
