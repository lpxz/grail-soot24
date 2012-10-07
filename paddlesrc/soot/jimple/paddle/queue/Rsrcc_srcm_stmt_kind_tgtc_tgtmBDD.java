package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD extends Rsrcc_srcm_stmt_kind_tgtc_tgtm {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                          new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.pa" +
                                           "ddle.bdddomains.C1, soot.jimple.paddle.bdddomains.A_srcm:soo" +
                                           "t.jimple.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains" +
                                           ".A_stmt:soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle" +
                                           ".bdddomains.A_kind:soot.jimple.paddle.bdddomains.KD, soot.ji" +
                                           "mple.paddle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains." +
                                           "C2, soot.jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle." +
                                           "bdddomains.MT> bdd at Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD.jedd" +
                                           ":31,12-78"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(final jedd.internal.RelationContainer bdd,
                                             String name,
                                             PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                ("add(bdd) at Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD.jedd:33,164-16" +
                                                 "7"),
                                                bdd));
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                ("add(bdd) at Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD.jedd:34,137-14" +
                                                 "0"),
                                                bdd));
    }
    
    Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                          new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rsrcc_srcm_stmt_kin" +
                                                           "d_tgtc_tgtmBDD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((Context)
                                   components[0],
                                 (SootMethod)
                                   components[1],
                                 (Unit)
                                   components[2],
                                 (Kind)
                                   components[3],
                                 (Context)
                                   components[4],
                                 (SootMethod)
                                   components[5]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> ret = bdd; at Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD.jedd:" +
                                               "56,75-78"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                   ("return ret; at Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD.jedd:58,8-1" +
                                                    "4"),
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
