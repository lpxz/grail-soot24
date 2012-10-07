package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;

public class BDDObjSensStaticContextManager extends AbsStaticContextManager {
    BDDObjSensStaticContextManager(Rsrcc_srcm_stmt_kind_tgtc_tgtm in,
                                   Qsrcc_srcm_stmt_kind_tgtc_tgtm out) {
        super(in,
              out);
    }
    
    public boolean update() {
        final jedd.internal.RelationContainer newIn =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_tgtc.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), MT.v(), C2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomains.MT, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomai" +
                                               "ns.C2> newIn = in.get(); at BDDObjSensStaticContextManager.j" +
                                               "edd:35,57-62"),
                                              in.get());
        final jedd.internal.RelationContainer newOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_tgtc.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), MT.v(), C2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomains.MT, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomai" +
                                               "ns.C2> newOut = jedd.internal.Jedd.v().copy(jedd.internal.Je" +
                                               "dd.v().project(newIn, new jedd.PhysicalDomain[...]), new jed" +
                                               "d.PhysicalDomain[...], new jedd.Attribute[...], ...); at BDD" +
                                               "ObjSensStaticContextManager.jedd:36,57-63"),
                                              jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().project(newIn,
                                                                                                         new jedd.PhysicalDomain[] { C2.v() }),
                                                                          new jedd.PhysicalDomain[] { C1.v() },
                                                                          new jedd.Attribute[] { A_srcc.v() },
                                                                          new jedd.PhysicalDomain[] { C2.v() }));
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                    ("out.add(newOut) at BDDObjSensStaticContextManager.jedd:38,8-" +
                                                     "11"),
                                                    newOut));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newOut),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
