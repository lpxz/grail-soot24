package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.*;

public class BDD1CFAVirtualContextManager extends BDDVirtualContextManager {
    BDD1CFAVirtualContextManager(Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in,
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
                                               "imple.paddle.bdddomains.MT> newIn = in.get(); at BDD1CFAVirt" +
                                               "ualContextManager.jedd:35,71-76"),
                                              in.get());
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_srcc.v(), A_stmt.v(), A_tgtc.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), C1.v(), ST.v(), C2.v() },
                                                    ("out.add(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().p" +
                                                     "roject(jedd.internal.Jedd.v().replace(newIn, new jedd.Physic" +
                                                     "alDomain[...], new jedd.PhysicalDomain[...]), new jedd.Physi" +
                                                     "calDomain[...]), new jedd.PhysicalDomain[...], new jedd.Attr" +
                                                     "ibute[...], ...)) at BDD1CFAVirtualContextManager.jedd:37,8-" +
                                                     "11"),
                                                    jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().replace(newIn,
                                                                                                                                              new jedd.PhysicalDomain[] { ST.v() },
                                                                                                                                              new jedd.PhysicalDomain[] { C2.v() }),
                                                                                                               new jedd.PhysicalDomain[] { V1.v(), H1.v(), CH1.v() }),
                                                                                new jedd.PhysicalDomain[] { C2.v() },
                                                                                new jedd.Attribute[] { A_stmt.v() },
                                                                                new jedd.PhysicalDomain[] { ST.v() })));
        if (thisOut !=
              null) {
            newMethods(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_tgtm.v() },
                                                           new jedd.PhysicalDomain[] { MT.v() },
                                                           ("newMethods(jedd.internal.Jedd.v().project(newIn, new jedd.Ph" +
                                                            "ysicalDomain[...])) at BDD1CFAVirtualContextManager.jedd:41," +
                                                            "12-22"),
                                                           jedd.internal.Jedd.v().project(newIn,
                                                                                          new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), H1.v(), C1.v(), CH1.v(), ST.v() })));
            thisOut.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_varc.v(), A_objc.v(), A_var.v() },
                                                            new jedd.PhysicalDomain[] { H1.v(), C1.v(), CH1.v(), V1.v() },
                                                            ("thisOut.add(jedd.internal.Jedd.v().compose(jedd.internal.Jed" +
                                                             "d.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd" +
                                                             ".v().project(newIn, new jedd.PhysicalDomain[...]), new jedd." +
                                                             "PhysicalDomain[...], new jedd.PhysicalDomain[...])), thisVar" +
                                                             "(), new jedd.PhysicalDomain[...])) at BDD1CFAVirtualContextM" +
                                                             "anager.jedd:43,12-19"),
                                                            jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(newIn,
                                                                                                                                                                                     new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), C1.v() }),
                                                                                                                                                      new jedd.PhysicalDomain[] { ST.v() },
                                                                                                                                                      new jedd.PhysicalDomain[] { C1.v() })),
                                                                                           thisVar(),
                                                                                           new jedd.PhysicalDomain[] { MT.v() })));
        }
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newIn),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
