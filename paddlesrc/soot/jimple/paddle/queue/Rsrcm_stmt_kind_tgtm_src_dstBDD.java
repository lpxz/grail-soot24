package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrcm_stmt_kind_tgtm_src_dstBDD extends Rsrcm_stmt_kind_tgtm_src_dst {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_src.v(), A_dst.v() },
                                          new PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v(), V1.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.pa" +
                                           "ddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:soo" +
                                           "t.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddomains" +
                                           ".A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle" +
                                           ".bdddomains.A_tgtm:soot.jimple.paddle.bdddomains.MT, soot.ji" +
                                           "mple.paddle.bdddomains.A_src:soot.jimple.paddle.bdddomains.V" +
                                           "1, soot.jimple.paddle.bdddomains.A_dst:soot.jimple.paddle.bd" +
                                           "ddomains.V2> bdd at Rsrcm_stmt_kind_tgtm_src_dstBDD.jedd:31," +
                                           "12-76"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rsrcm_stmt_kind_tgtm_src_dstBDD(final jedd.internal.RelationContainer bdd,
                                           String name,
                                           PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_src.v(), A_dst.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), V1.v(), V2.v(), ST.v() },
                                                "add(bdd) at Rsrcm_stmt_kind_tgtm_src_dstBDD.jedd:33,160-163",
                                                bdd));
    }
    
    public Rsrcm_stmt_kind_tgtm_src_dstBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_src.v(), A_dst.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), V1.v(), V2.v(), ST.v() },
                                                "add(bdd) at Rsrcm_stmt_kind_tgtm_src_dstBDD.jedd:34,133-136",
                                                bdd));
    }
    
    Rsrcm_stmt_kind_tgtm_src_dstBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_src.v(), A_dst.v(), A_stmt.v() },
                                                          new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), V1.v(), V2.v(), ST.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rsrcm_stmt_kind_tgt" +
                                                           "m_src_dstBDD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_src.v(), A_dst.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((SootMethod)
                                   components[0],
                                 (Unit)
                                   components[1],
                                 (Kind)
                                   components[2],
                                 (SootMethod)
                                   components[3],
                                 (VarNode)
                                   components[4],
                                 (VarNode)
                                   components[5]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v(), V1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                               "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                               ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                               "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                               "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT, soot.jimple.pad" +
                                               "dle.bdddomains.A_src:soot.jimple.paddle.bdddomains.V1, soot." +
                                               "jimple.paddle.bdddomains.A_dst:soot.jimple.paddle.bdddomains" +
                                               ".V2> ret = bdd; at Rsrcm_stmt_kind_tgtm_src_dstBDD.jedd:56,7" +
                                               "3-76"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_src.v(), A_dst.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), V1.v(), V2.v(), ST.v() },
                                                   "return ret; at Rsrcm_stmt_kind_tgtm_src_dstBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
