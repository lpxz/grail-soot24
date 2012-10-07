package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.*;
import java.util.*;

public class BDDReachableMethodsAdapter extends AbsReachableMethodsAdapter {
    BDDReachableMethodsAdapter(Rsrcc_srcm_stmt_kind_tgtc_tgtm edgesIn,
                               Qctxt_method cmout) {
        super(edgesIn,
              cmout);
    }
    
    public boolean update() {
        boolean ret =
          false;
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
                                               "ns.MT> newEdges = edgesIn.get(); at BDDReachableMethodsAdapt" +
                                               "er.jedd:36,57-65"),
                                              edgesIn.get());
        final jedd.internal.RelationContainer out =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MT> out = jedd.internal.Jedd.v().replac" +
                                               "e(jedd.internal.Jedd.v().project(newEdges, new jedd.Physical" +
                                               "Domain[...]), new jedd.PhysicalDomain[...], new jedd.Physica" +
                                               "lDomain[...]); at BDDReachableMethodsAdapter.jedd:37,27-30"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(newEdges,
                                                                                                            new jedd.PhysicalDomain[] { KD.v(), C2.v(), MT.v(), ST.v() }),
                                                                             new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                                             new jedd.PhysicalDomain[] { C2.v(), MT.v() }));
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(out),
                                           jedd.internal.Jedd.v().falseBDD())) {
            ret =
              true;
            cmout.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                          new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                          ("cmout.add(jedd.internal.Jedd.v().replace(out, new jedd.Physi" +
                                                           "calDomain[...], new jedd.PhysicalDomain[...])) at BDDReachab" +
                                                           "leMethodsAdapter.jedd:42,12-17"),
                                                          jedd.internal.Jedd.v().replace(out,
                                                                                         new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                                                         new jedd.PhysicalDomain[] { C1.v(), MS.v() })));
        }
        out.eq(jedd.internal.Jedd.v().project(newEdges,
                                              new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), ST.v() }));
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(out),
                                           jedd.internal.Jedd.v().falseBDD())) {
            ret =
              true;
            cmout.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                          new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                          ("cmout.add(jedd.internal.Jedd.v().replace(out, new jedd.Physi" +
                                                           "calDomain[...], new jedd.PhysicalDomain[...])) at BDDReachab" +
                                                           "leMethodsAdapter.jedd:49,12-17"),
                                                          jedd.internal.Jedd.v().replace(out,
                                                                                         new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                                                         new jedd.PhysicalDomain[] { C1.v(), MS.v() })));
        }
        return ret;
    }
}
