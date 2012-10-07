package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrcc_src_fld_dstc_dstIter extends Rsrcc_src_fld_dstc_dst {
    protected Iterator r;
    
    public Rsrcc_src_fld_dstc_dstIter(Iterator r,
                                      String name,
                                      PaddleQueue q) {
        super(name,
              q);
        this.r =
          r;
    }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                boolean ret =
                  r.hasNext();
                return ret;
            }
            
            public Object next() {
                return new Tuple((Context)
                                   r.next(),
                                 (VarNode)
                                   r.next(),
                                 (PaddleField)
                                   r.next(),
                                 (Context)
                                   r.next(),
                                 (VarNode)
                                   r.next());
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V2> ret = j" +
                                               "edd.internal.Jedd.v().falseBDD(); at Rsrcc_src_fld_dstc_dstI" +
                                               "ter.jedd:46,61-64"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                                       new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                   "return ret; at Rsrcc_src_fld_dstc_dstIter.jedd:50,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return r.hasNext();
    }
}
