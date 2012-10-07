package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class RmethodIter extends Rmethod {
    protected Iterator r;
    
    public RmethodIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                 this.r = r; }
    
    public Iterator iterator() { return new Iterator() {
                                     public boolean hasNext() { boolean ret = r.hasNext();
                                                                return ret; }
                                     
                                     public Object next() { return new Tuple((SootMethod) r.next()); }
                                     
                                     public void remove() { throw new UnsupportedOperationException(); }
                                 }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                              new PhysicalDomain[] { MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MS> ret = jedd.internal.Jedd.v().falseBDD(); at Rm" +
                                               "ethodIter.jedd:46,22-25"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next() }, new Attribute[] { A_method.v() },
                                                       new PhysicalDomain[] { MS.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_method.v() }, new PhysicalDomain[] { MS.v() },
                                                   "return ret; at RmethodIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
