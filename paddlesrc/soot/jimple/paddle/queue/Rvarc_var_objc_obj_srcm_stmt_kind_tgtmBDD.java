package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD extends Rvarc_var_objc_obj_srcm_stmt_kind_tgtm {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                          new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc:soot.jimple.pa" +
                                           "ddle.bdddomains.C1, soot.jimple.paddle.bdddomains.A_var:soot" +
                                           ".jimple.paddle.bdddomains.V1, soot.jimple.paddle.bdddomains." +
                                           "A_objc:soot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle" +
                                           ".bdddomains.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jim" +
                                           "ple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.M" +
                                           "S, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.b" +
                                           "dddomains.ST, soot.jimple.paddle.bdddomains.A_kind:soot.jimp" +
                                           "le.paddle.bdddomains.KD, soot.jimple.paddle.bdddomains.A_tgt" +
                                           "m:soot.jimple.paddle.bdddomains.MT> bdd at Rvarc_var_objc_ob" +
                                           "j_srcm_stmt_kind_tgtmBDD.jedd:31,12-99"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD(final jedd.internal.RelationContainer bdd,
                                                     String name,
                                                     PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                ("add(bdd) at Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD.jedd:3" +
                                                 "3,193-196"),
                                                bdd));
    }
    
    public Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                ("add(bdd) at Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD.jedd:3" +
                                                 "4,166-169"),
                                                bdd));
    }
    
    Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                          new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rvarc_var_objc_obj_" +
                                                           "srcm_stmt_kind_tgtmBDD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() });
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
                                 (AllocNode)
                                   components[3],
                                 (SootMethod)
                                   components[4],
                                 (Unit)
                                   components[5],
                                 (Kind)
                                   components[6],
                                 (SootMethod)
                                   components[7]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jimple.padd" +
                                               "le.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.MS, soot." +
                                               "jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdddomain" +
                                               "s.ST, soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddl" +
                                               "e.bdddomains.KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.j" +
                                               "imple.paddle.bdddomains.MT> ret = bdd; at Rvarc_var_objc_obj" +
                                               "_srcm_stmt_kind_tgtmBDD.jedd:56,96-99"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                   ("return ret; at Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD.jed" +
                                                    "d:58,8-14"),
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
