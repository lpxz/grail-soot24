package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rctxt_methodIter extends Rctxt_method {
    protected Iterator r;
    
    public Rctxt_methodIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                      this.r = r; }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { boolean ret = r.hasNext();
                                       return ret; }
            
            public Object next() { return new Tuple((Context) r.next(), (SootMethod) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
        }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> ret = jedd.internal.Jedd.v().falseB" +
                                               "DD(); at Rctxt_methodIter.jedd:46,33-36"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next() },
                                                       new Attribute[] { A_ctxt.v(), A_method.v() },
                                                       new PhysicalDomain[] { C1.v(), MS.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                                   new PhysicalDomain[] { C1.v(), MS.v() },
                                                   "return ret; at Rctxt_methodIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
