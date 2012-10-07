package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;

public class BDD1CFAStaticContextManager extends AbsStaticContextManager {
    BDD1CFAStaticContextManager(Rsrcc_srcm_stmt_kind_tgtc_tgtm in,
                                Qsrcc_srcm_stmt_kind_tgtc_tgtm out) {
        super(in,
              out);
    }
    
    public boolean update() {
        final jedd.internal.RelationContainer newOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> newOut = jedd.internal.Jedd.v().copy(jedd.internal.Je" +
                                               "dd.v().replace(jedd.internal.Jedd.v().project(in.get(), new " +
                                               "jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...], new" +
                                               " jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...], ne" +
                                               "w jedd.Attribute[...], ...); at BDD1CFAStaticContextManager." +
                                               "jedd:35,57-63"),
                                              jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(in.get(),
                                                                                                                                        new jedd.PhysicalDomain[] { C2.v() }),
                                                                                                         new jedd.PhysicalDomain[] { ST.v() },
                                                                                                         new jedd.PhysicalDomain[] { C2.v() }),
                                                                          new jedd.PhysicalDomain[] { C2.v() },
                                                                          new jedd.Attribute[] { A_stmt.v() },
                                                                          new jedd.PhysicalDomain[] { ST.v() }));
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                    "out.add(newOut) at BDD1CFAStaticContextManager.jedd:37,8-11",
                                                    newOut));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newOut),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
