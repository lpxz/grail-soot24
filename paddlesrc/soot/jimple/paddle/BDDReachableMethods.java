package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.*;
import java.util.*;

public class BDDReachableMethods extends AbsReachableMethods {
    private final jedd.internal.RelationContainer reachableCM =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_ctxt, soot.jimple.p" +
                                           "addle.bdddomains.A_method> reachableCM at BDDReachableMethod" +
                                           "s.jedd:31,12-30"));
    
    private final jedd.internal.RelationContainer reachableM =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                          new jedd.PhysicalDomain[] { MS.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method> reachableM " +
                                           "at BDDReachableMethods.jedd:32,12-22"));
    
    private AbsCallGraph cg;
    
    private Rctxt_method newMethods;
    
    BDDReachableMethods(Rsrcc_srcm_stmt_kind_tgtc_tgtm edgesIn,
                        Rctxt_method methodsIn,
                        Qmethod mout,
                        Qctxt_method cmout,
                        AbsCallGraph cg) {
        super(edgesIn,
              methodsIn,
              mout,
              cmout ==
                null ? new Qctxt_methodBDD("cmout") : cmout);
        this.cg =
          cg;
        newMethods =
          this.cmout.reader("bddrm");
    }
    
    public boolean update() {
        boolean change =
          false;
        if (methodsIn !=
              null) {
            final jedd.internal.RelationContainer newMethodsIn =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                  new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                                   "domains.C2, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                                   "le.paddle.bdddomains.MT> newMethodsIn = jedd.internal.Jedd.v" +
                                                   "().replace(methodsIn.get(), new jedd.PhysicalDomain[...], ne" +
                                                   "w jedd.PhysicalDomain[...]); at BDDReachableMethods.jedd:44," +
                                                   "31-43"),
                                                  jedd.internal.Jedd.v().replace(methodsIn.get(),
                                                                                 new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                                                 new jedd.PhysicalDomain[] { C2.v(), MT.v() }));
            if (add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                        new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                        "add(newMethodsIn) at BDDReachableMethods.jedd:45,15-18",
                                                        newMethodsIn)))
                change =
                  true;
        }
        if (edgesIn !=
              null) {
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
                                                   "ns.MT> newEdges = jedd.internal.Jedd.v().join(jedd.internal." +
                                                   "Jedd.v().read(edgesIn.get()), jedd.internal.Jedd.v().replace" +
                                                   "(reachableCM, new jedd.PhysicalDomain[...], new jedd.Physica" +
                                                   "lDomain[...]), new jedd.PhysicalDomain[...]); at BDDReachabl" +
                                                   "eMethods.jedd:49,61-69"),
                                                  jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(edgesIn.get()),
                                                                              jedd.internal.Jedd.v().replace(reachableCM,
                                                                                                             new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                                                                             new jedd.PhysicalDomain[] { C1.v(), MS.v() }),
                                                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() }));
            newEdges.eqUnion(cg.edgesOutOf(newMethods).get());
            while (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newEdges),
                                                  jedd.internal.Jedd.v().falseBDD())) {
                final jedd.internal.RelationContainer newTargets =
                  new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                      new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                      ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                                       "domains.C2, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                                       "le.paddle.bdddomains.MT> newTargets = jedd.internal.Jedd.v()" +
                                                       ".project(newEdges, new jedd.PhysicalDomain[...]); at BDDReac" +
                                                       "hableMethods.jedd:55,35-45"),
                                                      jedd.internal.Jedd.v().project(newEdges,
                                                                                     new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), ST.v() }));
                if (add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                            new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                            "add(newTargets) at BDDReachableMethods.jedd:57,19-22",
                                                            newTargets)))
                    change =
                      true;
                newEdges.eq(cg.edgesOutOf(newMethods).get());
            }
        }
        return change;
    }
    
    boolean add(Context c,
                SootMethod m) {
        return add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                       new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                       ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                        ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                        " BDDReachableMethods.jedd:64,15-18"),
                                                       jedd.internal.Jedd.v().literal(new Object[] { c, m },
                                                                                      new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                                                      new jedd.PhysicalDomain[] { C2.v(), MT.v() })));
    }
    
    private boolean add(final jedd.internal.RelationContainer methodContexts) {
        boolean ret =
          false;
        final jedd.internal.RelationContainer newCM =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MT> newCM = jedd.internal.Jedd.v().minu" +
                                               "s(jedd.internal.Jedd.v().read(methodContexts), reachableCM);" +
                                               " at BDDReachableMethods.jedd:68,27-32"),
                                              jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(methodContexts),
                                                                           reachableCM));
        reachableCM.eqUnion(newCM);
        if (cmout !=
              null)
            cmout.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                          new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                          ("cmout.add(jedd.internal.Jedd.v().replace(newCM, new jedd.Phy" +
                                                           "sicalDomain[...], new jedd.PhysicalDomain[...])) at BDDReach" +
                                                           "ableMethods.jedd:70,26-31"),
                                                          jedd.internal.Jedd.v().replace(newCM,
                                                                                         new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                                                         new jedd.PhysicalDomain[] { C1.v(), MS.v() })));
        final jedd.internal.RelationContainer newM =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                              new jedd.PhysicalDomain[] { MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MS> newM = jedd.internal.Jedd.v().replace(jedd.int" +
                                               "ernal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.intern" +
                                               "al.Jedd.v().project(methodContexts, new jedd.PhysicalDomain[" +
                                               "...])), jedd.internal.Jedd.v().replace(reachableM, new jedd." +
                                               "PhysicalDomain[...], new jedd.PhysicalDomain[...])), new jed" +
                                               "d.PhysicalDomain[...], new jedd.PhysicalDomain[...]); at BDD" +
                                               "ReachableMethods.jedd:71,19-23"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(methodContexts,
                                                                                                                                                                     new jedd.PhysicalDomain[] { C2.v() })),
                                                                                                          jedd.internal.Jedd.v().replace(reachableM,
                                                                                                                                         new jedd.PhysicalDomain[] { MS.v() },
                                                                                                                                         new jedd.PhysicalDomain[] { MT.v() })),
                                                                             new jedd.PhysicalDomain[] { MT.v() },
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        reachableM.eqUnion(newM);
        if (mout !=
              null)
            mout.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                         new jedd.PhysicalDomain[] { MS.v() },
                                                         "mout.add(newM) at BDDReachableMethods.jedd:73,25-29",
                                                         newM));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newCM),
                                              jedd.internal.Jedd.v().falseBDD()) ||
          !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newM),
                                         jedd.internal.Jedd.v().falseBDD());
    }
    
    public int sizeM() {
        return (int)
                 new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                     new jedd.PhysicalDomain[] { MS.v() },
                                                     "reachableM.size() at BDDReachableMethods.jedd:77,21-31",
                                                     reachableM).size();
    }
    
    public int sizeCM() {
        return (int)
                 new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                     new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                     "reachableCM.size() at BDDReachableMethods.jedd:80,21-32",
                                                     reachableCM).size();
    }
    
    public boolean contains(SootMethod m) {
        final jedd.internal.RelationContainer newM =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                              new jedd.PhysicalDomain[] { MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MS> newM = jedd.internal.Jedd.v().literal(new java" +
                                               ".lang.Object[...], new jedd.Attribute[...], new jedd.Physica" +
                                               "lDomain[...]); at BDDReachableMethods.jedd:83,19-23"),
                                              jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                             new jedd.Attribute[] { A_method.v() },
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(reachableM),
                                                                                                           newM)),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    public boolean contains(Context c,
                            SootMethod m) {
        final jedd.internal.RelationContainer newM =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MT> newM = jedd.internal.Jedd.v().liter" +
                                               "al(new java.lang.Object[...], new jedd.Attribute[...], new j" +
                                               "edd.PhysicalDomain[...]); at BDDReachableMethods.jedd:87,27-" +
                                               "31"),
                                              jedd.internal.Jedd.v().literal(new Object[] { c, m },
                                                                             new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                                             new jedd.PhysicalDomain[] { C2.v(), MT.v() }));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(reachableCM),
                                                                                                           newM)),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    public Rmethod methods() {
        return new RmethodBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                                  new jedd.PhysicalDomain[] { MS.v() },
                                                                  ("new soot.jimple.paddle.queue.RmethodBDD(...) at BDDReachable" +
                                                                   "Methods.jedd:91,15-18"),
                                                                  reachableM),
                              "methods",
                              null);
    }
    
    public Rctxt_method contextMethods() {
        return new Rctxt_methodBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                                       new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                                       ("new soot.jimple.paddle.queue.Rctxt_methodBDD(...) at BDDReac" +
                                                                        "hableMethods.jedd:94,15-18"),
                                                                       jedd.internal.Jedd.v().replace(reachableCM,
                                                                                                      new jedd.PhysicalDomain[] { C2.v(), MT.v() },
                                                                                                      new jedd.PhysicalDomain[] { C1.v(), MS.v() })),
                                   "methods",
                                   null);
    }
    
    public Iterator methodIterator() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MS.v() },
                                                   "reachableM.iterator() at BDDReachableMethods.jedd:97,15-25",
                                                   reachableM).iterator();
    }
    
    public long countContexts(SootMethod m) {
        final jedd.internal.RelationContainer contexts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v() },
                                              new jedd.PhysicalDomain[] { C2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C2> contexts = jedd.internal.Jedd.v().compose(jedd.i" +
                                               "nternal.Jedd.v().read(reachableCM), jedd.internal.Jedd.v().l" +
                                               "iteral(new java.lang.Object[...], new jedd.Attribute[...], n" +
                                               "ew jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...]);" +
                                               " at BDDReachableMethods.jedd:100,17-25"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(reachableCM),
                                                                             jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                            new jedd.Attribute[] { A_method.v() },
                                                                                                            new jedd.PhysicalDomain[] { MT.v() }),
                                                                             new jedd.PhysicalDomain[] { MT.v() }));
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v() },
                                                   new jedd.PhysicalDomain[] { C2.v() },
                                                   "contexts.size() at BDDReachableMethods.jedd:101,15-23",
                                                   contexts).size();
    }
}
