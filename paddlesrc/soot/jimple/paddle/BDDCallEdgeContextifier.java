package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class BDDCallEdgeContextifier extends AbsCallEdgeContextifier {
    private BDDNodeInfo ni;
    
    public BDDCallEdgeContextifier(BDDNodeInfo ni,
                                   Rsrcm_stmt_kind_tgtm_src_dst parms,
                                   Rsrcm_stmt_kind_tgtm_src_dst rets,
                                   Rsrcc_srcm_stmt_kind_tgtc_tgtm calls,
                                   Qsrcc_src_dstc_dst csimple) {
        super(parms,
              rets,
              calls,
              csimple);
        this.ni =
          ni;
    }
    
    public boolean update() {
        final jedd.internal.RelationContainer simpleOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> simpleOut = jedd." +
                                               "internal.Jedd.v().falseBDD(); at BDDCallEdgeContextifier.jed" +
                                               "d:47,39-48"),
                                              jedd.internal.Jedd.v().falseBDD());
        allParms.eqUnion(parms.get());
        allRets.eqUnion(rets.get());
        final jedd.internal.RelationContainer newCalls =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> newCalls = calls.get(); at BDDCallEdgeContextifier.je" +
                                               "dd:52,57-65"),
                                              calls.get());
        simpleOut.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(newCalls),
                                                         allParms,
                                                         new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() }));
        simpleOut.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(newCalls),
                                                                                        allRets,
                                                                                        new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() }),
                                                         new jedd.PhysicalDomain[] { C2.v(), C1.v() },
                                                         new jedd.PhysicalDomain[] { C1.v(), C2.v() }));
        final jedd.internal.RelationContainer globalDsts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> globalDsts = jedd" +
                                               ".internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOu" +
                                               "t), ni.globalSet(), new jedd.PhysicalDomain[...]); at BDDCal" +
                                               "lEdgeContextifier.jedd:61,39-49"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOut),
                                                                          ni.globalSet(),
                                                                          new jedd.PhysicalDomain[] { V2.v() }));
        simpleOut.eqMinus(globalDsts);
        simpleOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalDsts,
                                                                                                                 new jedd.PhysicalDomain[] { C2.v() })),
                                                      jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                     new jedd.Attribute[] { A_dstc.v() },
                                                                                     new jedd.PhysicalDomain[] { C2.v() }),
                                                      new jedd.PhysicalDomain[] {  }));
        final jedd.internal.RelationContainer globalSrcs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> globalSrcs = jedd" +
                                               ".internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOu" +
                                               "t), jedd.internal.Jedd.v().replace(ni.globalSet(), new jedd." +
                                               "PhysicalDomain[...], new jedd.PhysicalDomain[...]), new jedd" +
                                               ".PhysicalDomain[...]); at BDDCallEdgeContextifier.jedd:64,39" +
                                               "-49"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOut),
                                                                          jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                         new jedd.PhysicalDomain[] { V2.v() },
                                                                                                         new jedd.PhysicalDomain[] { V1.v() }),
                                                                          new jedd.PhysicalDomain[] { V1.v() }));
        simpleOut.eqMinus(globalSrcs);
        simpleOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalSrcs,
                                                                                                                 new jedd.PhysicalDomain[] { C1.v() })),
                                                      jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                     new jedd.Attribute[] { A_srcc.v() },
                                                                                     new jedd.PhysicalDomain[] { C1.v() }),
                                                      new jedd.PhysicalDomain[] {  }));
        csimple.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                        new jedd.PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                        ("csimple.add(simpleOut) at BDDCallEdgeContextifier.jedd:67,8-" +
                                                         "15"),
                                                        simpleOut));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(simpleOut),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    private final jedd.internal.RelationContainer allParms =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_src.v(), A_dst.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v(), V1.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcm, soot.jimple.p" +
                                           "addle.bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_kin" +
                                           "d, soot.jimple.paddle.bdddomains.A_tgtm, soot.jimple.paddle." +
                                           "bdddomains.A_src, soot.jimple.paddle.bdddomains.A_dst> allPa" +
                                           "rms = jedd.internal.Jedd.v().falseBDD() at BDDCallEdgeContex" +
                                           "tifier.jedd:72,12-58"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allRets =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v(), A_src.v(), A_dst.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v(), V1.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcm, soot.jimple.p" +
                                           "addle.bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_kin" +
                                           "d, soot.jimple.paddle.bdddomains.A_tgtm, soot.jimple.paddle." +
                                           "bdddomains.A_src, soot.jimple.paddle.bdddomains.A_dst> allRe" +
                                           "ts = jedd.internal.Jedd.v().falseBDD() at BDDCallEdgeContext" +
                                           "ifier.jedd:73,12-58"),
                                          jedd.internal.Jedd.v().falseBDD());
}
