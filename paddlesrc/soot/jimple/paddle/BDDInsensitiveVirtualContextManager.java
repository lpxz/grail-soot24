package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.*;

public class BDDInsensitiveVirtualContextManager extends BDDVirtualContextManager {
    BDDInsensitiveVirtualContextManager(Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in,
                                        Qsrcc_srcm_stmt_kind_tgtc_tgtm out,
                                        Qobjc_obj_varc_var thisOut,
                                        NodeFactory gnf) {
        super(in,
              out,
              thisOut,
              gnf);
    }
    
    public boolean update() {
        final jedd.internal.RelationContainer newIn =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jimple.padd" +
                                               "le.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.MS, soot." +
                                               "jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdddomain" +
                                               "s.ST, soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddl" +
                                               "e.bdddomains.KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.j" +
                                               "imple.paddle.bdddomains.MT> newIn = in.get(); at BDDInsensit" +
                                               "iveVirtualContextManager.jedd:35,71-76"),
                                              in.get());
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v(), A_srcc.v(), A_tgtc.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v(), C1.v(), C2.v() },
                                                    ("out.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().r" +
                                                     "ead(jedd.internal.Jedd.v().project(newIn, new jedd.PhysicalD" +
                                                     "omain[...])), jedd.internal.Jedd.v().literal(new java.lang.O" +
                                                     "bject[...], new jedd.Attribute[...], new jedd.PhysicalDomain" +
                                                     "[...]), new jedd.PhysicalDomain[...])) at BDDInsensitiveVirt" +
                                                     "ualContextManager.jedd:37,8-11"),
                                                    jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newIn,
                                                                                                                                           new jedd.PhysicalDomain[] { V1.v(), H1.v(), C1.v(), CH1.v() })),
                                                                                jedd.internal.Jedd.v().literal(new Object[] { null, null },
                                                                                                               new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                                                                               new jedd.PhysicalDomain[] { C1.v(), C2.v() }),
                                                                                new jedd.PhysicalDomain[] {  })));
        if (thisOut !=
              null) {
            newMethods(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_tgtm.v() },
                                                           new jedd.PhysicalDomain[] { MT.v() },
                                                           ("newMethods(jedd.internal.Jedd.v().project(newIn, new jedd.Ph" +
                                                            "ysicalDomain[...])) at BDDInsensitiveVirtualContextManager.j" +
                                                            "edd:41,12-22"),
                                                           jedd.internal.Jedd.v().project(newIn,
                                                                                          new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), H1.v(), C1.v(), CH1.v(), ST.v() })));
            thisOut.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                            new jedd.PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                            ("thisOut.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v" +
                                                             "().read(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v(" +
                                                             ").read(jedd.internal.Jedd.v().project(newIn, new jedd.Physic" +
                                                             "alDomain[...])), thisVar(), new jedd.PhysicalDomain[...])), " +
                                                             "jedd.internal.Jedd.v().literal(new java.lang.Object[...], ne" +
                                                             "w jedd.Attribute[...], new jedd.PhysicalDomain[...]), new je" +
                                                             "dd.PhysicalDomain[...])) at BDDInsensitiveVirtualContextMana" +
                                                             "ger.jedd:43,12-19"),
                                                            jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newIn,
                                                                                                                                                                                                              new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), C1.v(), ST.v() })),
                                                                                                                                                   thisVar(),
                                                                                                                                                   new jedd.PhysicalDomain[] { MT.v() })),
                                                                                        jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                                                       new jedd.Attribute[] { A_varc.v() },
                                                                                                                       new jedd.PhysicalDomain[] { C1.v() }),
                                                                                        new jedd.PhysicalDomain[] {  })));
        }
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newIn),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
