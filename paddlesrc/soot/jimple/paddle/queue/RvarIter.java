package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class RvarIter extends Rvar {
    protected Iterator r;
    
    public RvarIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                              this.r = r; }
    
    public Iterator iterator() { return new Iterator() {
                                     public boolean hasNext() { boolean ret = r.hasNext();
                                                                return ret; }
                                     
                                     public Object next() { return new Tuple((VarNode) r.next()); }
                                     
                                     public void remove() { throw new UnsupportedOperationException(); }
                                 }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                              new PhysicalDomain[] { V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1> ret = jedd.internal.Jedd.v().falseBDD(); at RvarI" +
                                               "ter.jedd:46,19-22"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next() }, new Attribute[] { A_var.v() },
                                                       new PhysicalDomain[] { V1.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v() }, new PhysicalDomain[] { V1.v() },
                                                   "return ret; at RvarIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
