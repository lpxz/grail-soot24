package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.*;

public class BDDObjSensVirtualContextManager extends BDDVirtualContextManager {
    BDDObjSensVirtualContextManager(Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in,
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
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), C2.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.C2, soot.jimple.padd" +
                                               "le.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.MS, soot." +
                                               "jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdddomain" +
                                               "s.ST, soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddl" +
                                               "e.bdddomains.KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.j" +
                                               "imple.paddle.bdddomains.MT> newIn = jedd.internal.Jedd.v().r" +
                                               "eplace(in.get(), new jedd.PhysicalDomain[...], new jedd.Phys" +
                                               "icalDomain[...]); at BDDObjSensVirtualContextManager.jedd:35" +
                                               ",71-76"),
                                              jedd.internal.Jedd.v().replace(in.get(),
                                                                             new jedd.PhysicalDomain[] { H1.v() },
                                                                             new jedd.PhysicalDomain[] { C2.v() }));
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_tgtc.v(), A_srcc.v(), A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), C2.v(), C1.v(), ST.v() },
                                                    ("out.add(jedd.internal.Jedd.v().project(newIn, new jedd.Physi" +
                                                     "calDomain[...])) at BDDObjSensVirtualContextManager.jedd:37," +
                                                     "8-11"),
                                                    jedd.internal.Jedd.v().project(newIn,
                                                                                   new jedd.PhysicalDomain[] { V1.v(), CH1.v() })));
        if (thisOut !=
              null) {
            newMethods(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_tgtm.v() },
                                                           new jedd.PhysicalDomain[] { MT.v() },
                                                           ("newMethods(jedd.internal.Jedd.v().project(newIn, new jedd.Ph" +
                                                            "ysicalDomain[...])) at BDDObjSensVirtualContextManager.jedd:" +
                                                            "41,12-22"),
                                                           jedd.internal.Jedd.v().project(newIn,
                                                                                          new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), C2.v(), C1.v(), CH1.v(), ST.v() })));
            thisOut.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_varc.v(), A_objc.v(), A_var.v() },
                                                            new jedd.PhysicalDomain[] { H1.v(), C1.v(), CH1.v(), V1.v() },
                                                            ("thisOut.add(jedd.internal.Jedd.v().replace(jedd.internal.Jed" +
                                                             "d.v().copy(jedd.internal.Jedd.v().replace(jedd.internal.Jedd" +
                                                             ".v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Je" +
                                                             "dd.v().read(jedd.internal.Jedd.v().project(newIn, new jedd.P" +
                                                             "hysicalDomain[...])), thisVar(), new jedd.PhysicalDomain[..." +
                                                             "]), new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[.." +
                                                             ".]), new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[." +
                                                             "..]), new jedd.PhysicalDomain[...], new jedd.Attribute[...]," +
                                                             " ...), new jedd.PhysicalDomain[...], new jedd.PhysicalDomain" +
                                                             "[...])) at BDDObjSensVirtualContextManager.jedd:43,12-19"),
                                                            jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newIn,
                                                                                                                                                                                                                                                                               new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), C1.v(), ST.v() })),
                                                                                                                                                                                                                    thisVar(),
                                                                                                                                                                                                                    new jedd.PhysicalDomain[] { MT.v() }),
                                                                                                                                                                                     new jedd.PhysicalDomain[] { C2.v() },
                                                                                                                                                                                     new jedd.PhysicalDomain[] { H1.v() }),
                                                                                                                                                      new jedd.PhysicalDomain[] { H1.v() },
                                                                                                                                                      new jedd.PhysicalDomain[] { H2.v() }),
                                                                                                                       new jedd.PhysicalDomain[] { H2.v() },
                                                                                                                       new jedd.Attribute[] { A_obj.v() },
                                                                                                                       new jedd.PhysicalDomain[] { H1.v() }),
                                                                                           new jedd.PhysicalDomain[] { H2.v() },
                                                                                           new jedd.PhysicalDomain[] { C1.v() })));
        }
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newIn),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
