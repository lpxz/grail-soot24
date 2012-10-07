package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import jedd.*;
import java.util.*;

public class BDDKObjSensStaticContextManager extends AbsStaticContextManager {
    BDDKObjSensStaticContextManager(Rsrcc_srcm_stmt_kind_tgtc_tgtm in,
                                    Qsrcc_srcm_stmt_kind_tgtc_tgtm out,
                                    int k) {
        super(in,
              out);
    }
    
    public boolean update() {
        final jedd.internal.RelationContainer newEdges =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> newEdges = jedd.internal.Jedd.v().copy(jedd.internal." +
                                               "Jedd.v().project(in.get(), new jedd.PhysicalDomain[...]), ne" +
                                               "w jedd.PhysicalDomain[...], new jedd.Attribute[...], ...); a" +
                                               "t BDDKObjSensStaticContextManager.jedd:37,57-65"),
                                              jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().project(in.get(),
                                                                                                         new PhysicalDomain[] { C2.v() }),
                                                                          new PhysicalDomain[] { C1.v() },
                                                                          new Attribute[] { A_srcc.v() },
                                                                          new PhysicalDomain[] { C2.v() }));
        out.add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                    new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                    ("out.add(newEdges) at BDDKObjSensStaticContextManager.jedd:39" +
                                                     ",8-11"),
                                                    newEdges));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newEdges),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
