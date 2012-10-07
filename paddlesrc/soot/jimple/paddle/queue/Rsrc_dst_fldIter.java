package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrc_dst_fldIter extends Rsrc_dst_fld {
    protected Iterator r;
    
    public Rsrc_dst_fldIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                      this.r = r; }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { boolean ret = r.hasNext();
                                       return ret; }
            
            public Object next() { return new Tuple((VarNode) r.next(), (VarNode) r.next(), (PaddleField) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
        }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v(), A_fld.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v(), FD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dst:soot.jimple.p" +
                                               "addle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_fld:soo" +
                                               "t.jimple.paddle.bdddomains.FD> ret = jedd.internal.Jedd.v()." +
                                               "falseBDD(); at Rsrc_dst_fldIter.jedd:46,39-42"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_src.v(), A_dst.v(), A_fld.v() },
                                                       new PhysicalDomain[] { V1.v(), V2.v(), FD.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                                   "return ret; at Rsrc_dst_fldIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
