package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrc_dstIter extends Rsrc_dst {
    protected Iterator r;
    
    public Rsrc_dstIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                  this.r = r; }
    
    public Iterator iterator() { return new Iterator() {
                                     public boolean hasNext() { boolean ret = r.hasNext();
                                                                return ret; }
                                     
                                     public Object next() { return new Tuple((VarNode) r.next(), (VarNode) r.next()); }
                                     
                                     public void remove() { throw new UnsupportedOperationException(); }
                                 }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dst:soot.jimple.p" +
                                               "addle.bdddomains.V2> ret = jedd.internal.Jedd.v().falseBDD()" +
                                               "; at Rsrc_dstIter.jedd:46,29-32"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next() },
                                                       new Attribute[] { A_src.v(), A_dst.v() },
                                                       new PhysicalDomain[] { V1.v(), V2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { V1.v(), V2.v() },
                                                   "return ret; at Rsrc_dstIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
