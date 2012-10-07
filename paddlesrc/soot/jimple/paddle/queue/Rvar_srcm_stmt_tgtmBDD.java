package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvar_srcm_stmt_tgtmBDD extends Rvar_srcm_stmt_tgtm {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                          new PhysicalDomain[] { V1.v(), MS.v(), ST.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot" +
                                           ".jimple.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains." +
                                           "A_stmt:soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle." +
                                           "bdddomains.A_tgtm:soot.jimple.paddle.bdddomains.MT> bdd at R" +
                                           "var_srcm_stmt_tgtmBDD.jedd:31,12-55"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rvar_srcm_stmt_tgtmBDD(final jedd.internal.RelationContainer bdd,
                                  String name,
                                  PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                new PhysicalDomain[] { V1.v(), MS.v(), MT.v(), ST.v() },
                                                "add(bdd) at Rvar_srcm_stmt_tgtmBDD.jedd:33,130-133",
                                                bdd));
    }
    
    public Rvar_srcm_stmt_tgtmBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                new PhysicalDomain[] { V1.v(), MS.v(), MT.v(), ST.v() },
                                                "add(bdd) at Rvar_srcm_stmt_tgtmBDD.jedd:34,103-106",
                                                bdd));
    }
    
    Rvar_srcm_stmt_tgtmBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                          new PhysicalDomain[] { V1.v(), MS.v(), MT.v(), ST.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rvar_srcm_stmt_tgtm" +
                                                           "BDD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0],
                                 (SootMethod)
                                   components[1],
                                 (Unit)
                                   components[2],
                                 (SootMethod)
                                   components[3]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { V1.v(), MS.v(), ST.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple." +
                                               "paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:s" +
                                               "oot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddomai" +
                                               "ns.A_tgtm:soot.jimple.paddle.bdddomains.MT> ret = bdd; at Rv" +
                                               "ar_srcm_stmt_tgtmBDD.jedd:56,52-55"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { V1.v(), MS.v(), MT.v(), ST.v() },
                                                   "return ret; at Rvar_srcm_stmt_tgtmBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
