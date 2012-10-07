package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;

public class BDDContextCallGraphBuilder extends AbsContextCallGraphBuilder {
    BDDContextCallGraphBuilder(Rctxt_method methodsIn,
                               Rsrcm_stmt_kind_tgtm edgesIn,
                               Qsrcc_srcm_stmt_kind_tgtc_tgtm out) {
        super(methodsIn,
              edgesIn,
              out);
    }
    
    private final jedd.internal.RelationContainer m2c =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_ctxt, soot.jimple.p" +
                                           "addle.bdddomains.A_method> m2c = jedd.internal.Jedd.v().fals" +
                                           "eBDD() at BDDContextCallGraphBuilder.jedd:36,12-30"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer cicg =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcm, soot.jimple.p" +
                                           "addle.bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_kin" +
                                           "d, soot.jimple.paddle.bdddomains.A_tgtm> cicg = jedd.interna" +
                                           "l.Jedd.v().falseBDD() at BDDContextCallGraphBuilder.jedd:37," +
                                           "12-44"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public boolean update() {
        final jedd.internal.RelationContainer newEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                               "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                               ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                               "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                               "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> newEdges = edge" +
                                               "sIn.get(); at BDDContextCallGraphBuilder.jedd:39,41-49"),
                                              edgesIn.get());
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
                                               "ns.MT> newOut = jedd.internal.Jedd.v().join(jedd.internal.Je" +
                                               "dd.v().read(jedd.internal.Jedd.v().literal(new java.lang.Obj" +
                                               "ect[...], new jedd.Attribute[...], new jedd.PhysicalDomain[." +
                                               "..])), jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().re" +
                                               "ad(newEdges), m2c, new jedd.PhysicalDomain[...]), new jedd.P" +
                                               "hysicalDomain[...]); at BDDContextCallGraphBuilder.jedd:40,5" +
                                               "7-63"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                                                                     new jedd.Attribute[] { A_tgtc.v() },
                                                                                                                                     new jedd.PhysicalDomain[] { C2.v() })),
                                                                          jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newEdges),
                                                                                                      m2c,
                                                                                                      new jedd.PhysicalDomain[] { MS.v() }),
                                                                          new jedd.PhysicalDomain[] {  }));
        cicg.eqUnion(newEdges);
        final jedd.internal.RelationContainer methods =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> methods = methodsIn.get(); at BDDCo" +
                                               "ntextCallGraphBuilder.jedd:45,27-34"),
                                              methodsIn.get());
        newOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                                              new jedd.Attribute[] { A_tgtc.v() },
                                                                                                              new jedd.PhysicalDomain[] { C2.v() })),
                                                   jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(cicg),
                                                                               methods,
                                                                               new jedd.PhysicalDomain[] { MS.v() }),
                                                   new jedd.PhysicalDomain[] {  }));
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                    "out.add(newOut) at BDDContextCallGraphBuilder.jedd:48,8-11",
                                                    newOut));
        m2c.eqUnion(methods);
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newOut),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
