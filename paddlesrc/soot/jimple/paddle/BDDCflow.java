package soot.jimple.paddle;

import soot.*;
import soot.jimple.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;
import soot.jimple.toolkits.callgraph.*;

public class BDDCflow {
    public static final boolean DEBUG =
      false;
    
    public BDDCflow() {
        super();
        stmtMethod.eq(jedd.internal.Jedd.v().falseBDD());
        if (DEBUG)
            G.v().out.println("Getting call graph");
        Date startCG =
          new Date();
        final jedd.internal.RelationContainer wantedKinds =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v() },
                                              new jedd.PhysicalDomain[] { KD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdd" +
                                               "domains.KD> wantedKinds = jedd.internal.Jedd.v().union(jedd." +
                                               "internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.int" +
                                               "ernal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.intern" +
                                               "al.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal." +
                                               "Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jed" +
                                               "d.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v" +
                                               "().read(jedd.internal.Jedd.v().literal(new java.lang.Object[" +
                                               "...], new jedd.Attribute[...], new jedd.PhysicalDomain[...])" +
                                               "), jedd.internal.Jedd.v().literal(new java.lang.Object[...]," +
                                               " new jedd.Attribute[...], new jedd.PhysicalDomain[...]))), j" +
                                               "edd.internal.Jedd.v().literal(new java.lang.Object[...], new" +
                                               " jedd.Attribute[...], new jedd.PhysicalDomain[...]))), jedd." +
                                               "internal.Jedd.v().literal(new java.lang.Object[...], new jed" +
                                               "d.Attribute[...], new jedd.PhysicalDomain[...]))), jedd.inte" +
                                               "rnal.Jedd.v().literal(new java.lang.Object[...], new jedd.At" +
                                               "tribute[...], new jedd.PhysicalDomain[...]))), jedd.internal" +
                                               ".Jedd.v().literal(new java.lang.Object[...], new jedd.Attrib" +
                                               "ute[...], new jedd.PhysicalDomain[...]))), jedd.internal.Jed" +
                                               "d.v().literal(new java.lang.Object[...], new jedd.Attribute[" +
                                               "...], new jedd.PhysicalDomain[...])); at BDDCflow.jedd:38,17" +
                                               "-28"),
                                              jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { Kind.STATIC },
                                                                                                                                                                                                                                                                                                                                                                                                                                   new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                                                                                                                                                                                                                                   new jedd.PhysicalDomain[] { KD.v() })),
                                                                                                                                                                                                                                                                                                                                                                        jedd.internal.Jedd.v().literal(new Object[] { Kind.VIRTUAL },
                                                                                                                                                                                                                                                                                                                                                                                                       new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                                                                                                                                                                                                       new jedd.PhysicalDomain[] { KD.v() }))),
                                                                                                                                                                                                                                                                                                               jedd.internal.Jedd.v().literal(new Object[] { Kind.INTERFACE },
                                                                                                                                                                                                                                                                                                                                              new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                                                                                                                                              new jedd.PhysicalDomain[] { KD.v() }))),
                                                                                                                                                                                                                                                      jedd.internal.Jedd.v().literal(new Object[] { Kind.SPECIAL },
                                                                                                                                                                                                                                                                                     new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                                                                                     new jedd.PhysicalDomain[] { KD.v() }))),
                                                                                                                                                                                             jedd.internal.Jedd.v().literal(new Object[] { Kind.CLINIT },
                                                                                                                                                                                                                            new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                            new jedd.PhysicalDomain[] { KD.v() }))),
                                                                                                                                    jedd.internal.Jedd.v().literal(new Object[] { Kind.PRIVILEGED },
                                                                                                                                                                   new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                   new jedd.PhysicalDomain[] { KD.v() }))),
                                                                           jedd.internal.Jedd.v().literal(new Object[] { Kind.NEWINSTANCE },
                                                                                                          new jedd.Attribute[] { A_kind.v() },
                                                                                                          new jedd.PhysicalDomain[] { KD.v() })));
        final jedd.internal.RelationContainer callEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                               "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                               ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                               "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                               "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> callEdges = jed" +
                                               "d.internal.Jedd.v().falseBDD(); at BDDCflow.jedd:47,53-62"),
                                              jedd.internal.Jedd.v().falseBDD());
        AbsCallGraph cg =
          Results.v().callGraph();
        if (cg ==
              null) {
            if (DEBUG)
                G.v().out.println("No Paddle call graph -- using Soot one.");
            for (Iterator eIt =
                   Scene.v().getCallGraph().listener();
                 eIt.hasNext();
                 ) {
                final Edge e =
                  (Edge)
                    eIt.next();
                Scene.v().getUnitNumberer().add(e.srcStmt());
                callEdges.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { e.src(), e.srcStmt(), e.kind(), e.tgt() },
                                                                 new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                                 new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() }));
            }
        } else {
            if (DEBUG)
                G.v().out.println("Using Paddle call graph.");
            callEdges.eq(cg.ciEdges().get());
        }
        final jedd.internal.RelationContainer methods =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                              new jedd.PhysicalDomain[] { MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MT> methods = jedd.internal.Jedd.v().replace(jedd." +
                                               "internal.Jedd.v().project(callEdges, new jedd.PhysicalDomain" +
                                               "[...]), new jedd.PhysicalDomain[...], new jedd.PhysicalDomai" +
                                               "n[...]); at BDDCflow.jedd:62,19-26"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(callEdges,
                                                                                                            new jedd.PhysicalDomain[] { KD.v(), MT.v(), ST.v() }),
                                                                             new jedd.PhysicalDomain[] { MS.v() },
                                                                             new jedd.PhysicalDomain[] { MT.v() }));
        methods.eqUnion(jedd.internal.Jedd.v().project(callEdges,
                                                       new jedd.PhysicalDomain[] { KD.v(), MS.v(), ST.v() }));
        for (Iterator mIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MT.v() },
                                                   "methods.iterator() at BDDCflow.jedd:64,28-35",
                                                   methods).iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            if (m.hasActiveBody()) {
                for (Iterator sIt =
                       m.getActiveBody().getUnits().iterator();
                     sIt.hasNext();
                     ) {
                    final Stmt s =
                      (Stmt)
                        sIt.next();
                    Scene.v().getUnitNumberer().add(s);
                    stmtMethod.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { s, m },
                                                                      new jedd.Attribute[] { A_stmt.v(), A_method.v() },
                                                                      new jedd.PhysicalDomain[] { ST.v(), MT.v() }));
                }
            }
        }
        callGraph.eq(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(callEdges),
                                                    wantedKinds,
                                                    new jedd.PhysicalDomain[] { KD.v() }));
        threadEntries.eq(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(callEdges,
                                                                                                                   new jedd.PhysicalDomain[] { MS.v(), ST.v() })),
                                                        jedd.internal.Jedd.v().literal(new Object[] { Kind.THREAD },
                                                                                       new jedd.Attribute[] { A_kind.v() },
                                                                                       new jedd.PhysicalDomain[] { KD.v() }),
                                                        new jedd.PhysicalDomain[] { KD.v() }));
        Date doneCG =
          new Date();
        if (DEBUG)
            G.v().out.println("Getting call graph took " +
                              (doneCG.getTime() -
                                 startCG.getTime()) +
                              " ms");
        if (DEBUG)
            G.v().out.println("Done getting call graph");
    }
    
    private final jedd.internal.RelationContainer stmtMethod =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { ST.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_stmt, soot.jimple.p" +
                                           "addle.bdddomains.A_method> stmtMethod at BDDCflow.jedd:82,12" +
                                           "-30"));
    
    jedd.internal.RelationContainer stmtMethod() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { MT.v(), ST.v() },
                                                   "return stmtMethod; at BDDCflow.jedd:83,38-44",
                                                   stmtMethod);
    }
    
    private final jedd.internal.RelationContainer callGraph =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), ST.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcm, soot.jimple.p" +
                                           "addle.bdddomains.A_stmt, soot.jimple.paddle.bdddomains.A_tgt" +
                                           "m> callGraph at BDDCflow.jedd:84,12-36"));
    
    jedd.internal.RelationContainer callGraph() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { MS.v(), MT.v(), ST.v() },
                                                   "return callGraph; at BDDCflow.jedd:85,43-49",
                                                   callGraph);
    }
    
    private final jedd.internal.RelationContainer threadEntries =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                          new jedd.PhysicalDomain[] { MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method> threadEntri" +
                                           "es at BDDCflow.jedd:86,12-22"));
    
    jedd.internal.RelationContainer threadEntries() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MT.v() },
                                                   "return threadEntries; at BDDCflow.jedd:87,33-39",
                                                   threadEntries);
    }
}
