package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrcc_src_dstc_dstBDD extends Rsrcc_src_dstc_dst {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                          new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.pa" +
                                           "ddle.bdddomains.C1, soot.jimple.paddle.bdddomains.A_src:soot" +
                                           ".jimple.paddle.bdddomains.V1, soot.jimple.paddle.bdddomains." +
                                           "A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddle." +
                                           "bdddomains.A_dst:soot.jimple.paddle.bdddomains.V2> bdd at Rs" +
                                           "rcc_src_dstc_dstBDD.jedd:31,12-54"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rsrcc_src_dstc_dstBDD(final jedd.internal.RelationContainer bdd,
                                 String name,
                                 PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                "add(bdd) at Rsrcc_src_dstc_dstBDD.jedd:33,128-131",
                                                bdd));
    }
    
    public Rsrcc_src_dstc_dstBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                "add(bdd) at Rsrcc_src_dstc_dstBDD.jedd:34,101-104",
                                                bdd));
    }
    
    Rsrcc_src_dstc_dstBDD(String name,
                          PaddleQueue q) {
        super(name,
              q);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
    }
    
    public Iterator iterator() {
        ;
        return new Iterator() {
            private Iterator it;
            
            public boolean hasNext() {
                if (it !=
                      null &&
                      it.hasNext())
                    return true;
                if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                                   jedd.internal.Jedd.v().falseBDD()))
                    return true;
                return false;
            }
            
            public Object next() {
                if (it ==
                      null ||
                      !it.hasNext()) {
                    it =
                      new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                          new PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rsrcc_src_dstc_dstB" +
                                                           "DD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((Context)
                                   components[0],
                                 (VarNode)
                                   components[1],
                                 (Context)
                                   components[2],
                                 (VarNode)
                                   components[3]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> ret = bdd; at Rsr" +
                                               "cc_src_dstc_dstBDD.jedd:56,51-54"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                   "return ret; at Rsrcc_src_dstc_dstBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
