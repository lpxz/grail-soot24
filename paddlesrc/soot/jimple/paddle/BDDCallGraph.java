package soot.jimple.paddle;

import soot.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;

public class BDDCallGraph extends AbsCallGraph {
    private final jedd.internal.RelationContainer csEdges =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.p" +
                                           "addle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stm" +
                                           "t, soot.jimple.paddle.bdddomains.A_kind, soot.jimple.paddle." +
                                           "bdddomains.A_tgtc, soot.jimple.paddle.bdddomains.A_tgtm> csE" +
                                           "dges at BDDCallGraph.jedd:30,12-60"));
    
    private final jedd.internal.RelationContainer ciEdges =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcm, soot.jimple.p" +
                                           "addle.bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_kin" +
                                           "d, soot.jimple.paddle.bdddomains.A_tgtm> ciEdges at BDDCallG" +
                                           "raph.jedd:31,12-44"));
    
    BDDCallGraph(Rsrcc_srcm_stmt_kind_tgtc_tgtm in,
                 Qsrcm_stmt_kind_tgtm ciout,
                 Qsrcc_srcm_stmt_kind_tgtc_tgtm csout) {
        super(in,
              ciout,
              csout);
    }
    
    public boolean update() {
        if (in ==
              null)
            return false;
        final jedd.internal.RelationContainer newEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> newEdges = in.get(); at BDDCallGraph.jedd:37,57-65"),
                                              in.get());
        newEdges.eqMinus(csEdges);
        csEdges.eqUnion(newEdges);
        if (csout !=
              null)
            csout.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                          new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                          "csout.add(newEdges) at BDDCallGraph.jedd:40,26-31",
                                                          newEdges));
        final jedd.internal.RelationContainer newCiEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                               "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                               ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                               "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                               "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> newCiEdges = je" +
                                               "dd.internal.Jedd.v().project(newEdges, new jedd.PhysicalDoma" +
                                               "in[...]); at BDDCallGraph.jedd:41,41-51"),
                                              jedd.internal.Jedd.v().project(newEdges,
                                                                             new jedd.PhysicalDomain[] { C1.v(), C2.v() }));
        newCiEdges.eqMinus(ciEdges);
        ciEdges.eqUnion(newCiEdges);
        if (ciout !=
              null)
            ciout.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                          new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                          "ciout.add(newCiEdges) at BDDCallGraph.jedd:44,26-31",
                                                          newCiEdges));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newEdges),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm edgesOutOf(Rctxt_method methods) {
        final jedd.internal.RelationContainer methodsBDD =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> methodsBDD = methods.get(); at BDDC" +
                                               "allGraph.jedd:48,27-37"),
                                              methods.get());
        final jedd.internal.RelationContainer result =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> result = jedd.internal.Jedd.v().join(jedd.internal.Je" +
                                               "dd.v().read(csEdges), methodsBDD, new jedd.PhysicalDomain[.." +
                                               ".]); at BDDCallGraph.jedd:49,57-63"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(csEdges),
                                                                          methodsBDD,
                                                                          new jedd.PhysicalDomain[] { MS.v(), C1.v() }));
        return new Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                                         new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                                         ("new soot.jimple.paddle.queue.Rsrcc_srcm_stmt_kind_tgtc_tgtmB" +
                                                                                          "DD(...) at BDDCallGraph.jedd:51,15-18"),
                                                                                         result),
                                                     "edgesOutOf",
                                                     null);
    }
    
    public Rsrcm_stmt_kind_tgtm edgesOutOf(Rmethod methods) {
        return new Rsrcm_stmt_kind_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                                               ("new soot.jimple.paddle.queue.Rsrcm_stmt_kind_tgtmBDD(...) at" +
                                                                                " BDDCallGraph.jedd:55,15-18"),
                                                                               jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(ciEdges),
                                                                                                           methods.get(),
                                                                                                           new jedd.PhysicalDomain[] { MS.v() })),
                                           "edgesOutOf",
                                           null);
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm edgesOutOf(Context c,
                                                     SootMethod m) {
        return new Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                                         new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                                         ("new soot.jimple.paddle.queue.Rsrcc_srcm_stmt_kind_tgtc_tgtmB" +
                                                                                          "DD(...) at BDDCallGraph.jedd:60,15-18"),
                                                                                         jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(csEdges),
                                                                                                                     jedd.internal.Jedd.v().literal(new Object[] { c, m },
                                                                                                                                                    new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                                                                                                                    new jedd.PhysicalDomain[] { C1.v(), MS.v() }),
                                                                                                                     new jedd.PhysicalDomain[] { MS.v(), C1.v() })),
                                                     "edgesOutOf",
                                                     null);
    }
    
    public Rsrcm_stmt_kind_tgtm edgesOutOf(SootMethod m) {
        return new Rsrcm_stmt_kind_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                                               ("new soot.jimple.paddle.queue.Rsrcm_stmt_kind_tgtmBDD(...) at" +
                                                                                " BDDCallGraph.jedd:67,15-18"),
                                                                               jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(ciEdges),
                                                                                                           jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                                          new jedd.Attribute[] { A_method.v() },
                                                                                                                                          new jedd.PhysicalDomain[] { MS.v() }),
                                                                                                           new jedd.PhysicalDomain[] { MS.v() })),
                                           "edgesOutOf",
                                           null);
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm csEdges() {
        return new Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                                         new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                                         ("new soot.jimple.paddle.queue.Rsrcc_srcm_stmt_kind_tgtc_tgtmB" +
                                                                                          "DD(...) at BDDCallGraph.jedd:74,15-18"),
                                                                                         csEdges),
                                                     "edges",
                                                     null);
    }
    
    public Rsrcm_stmt_kind_tgtm ciEdges() {
        return new Rsrcm_stmt_kind_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                                               ("new soot.jimple.paddle.queue.Rsrcm_stmt_kind_tgtmBDD(...) at" +
                                                                                " BDDCallGraph.jedd:77,15-18"),
                                                                               ciEdges),
                                           "edges",
                                           null);
    }
    
    public int ciSize() {
        return (int)
                 new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                     new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                     "ciEdges.size() at BDDCallGraph.jedd:80,21-28",
                                                     ciEdges).size();
    }
    
    public int csSize() {
        return (int)
                 new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                     new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                     "csEdges.size() at BDDCallGraph.jedd:83,21-28",
                                                     csEdges).size();
    }
}
