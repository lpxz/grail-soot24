package soot.jimple.paddle;

import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.queue.*;
import java.util.*;
import soot.*;
import soot.jimple.toolkits.callgraph.*;

public class ContextCountPrinter {
    public static void printContextCounts() {
        G.v().out.println("Begin method context counts");
        final jedd.internal.RelationContainer contextMethods =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> contextMethods = soot.jimple.paddle" +
                                               ".Results.v().reachableMethods().contextMethods().get(); at C" +
                                               "ontextCountPrinter.jedd:35,27-41"),
                                              Results.v().reachableMethods().contextMethods().get());
        for (Iterator mIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MS.v() },
                                                   ("jedd.internal.Jedd.v().project(contextMethods, new jedd.Phys" +
                                                    "icalDomain[...]).iterator() at ContextCountPrinter.jedd:37,5" +
                                                    "6-64"),
                                                   jedd.internal.Jedd.v().project(contextMethods,
                                                                                  new jedd.PhysicalDomain[] { C1.v() })).iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            final jedd.internal.RelationContainer contexts =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v() },
                                                  new jedd.PhysicalDomain[] { C1.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                                   "domains.C1> contexts = jedd.internal.Jedd.v().compose(jedd.i" +
                                                   "nternal.Jedd.v().read(jedd.internal.Jedd.v().literal(new jav" +
                                                   "a.lang.Object[...], new jedd.Attribute[...], new jedd.Physic" +
                                                   "alDomain[...])), contextMethods, new jedd.PhysicalDomain[..." +
                                                   "]); at ContextCountPrinter.jedd:39,21-29"),
                                                  jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                                            new jedd.Attribute[] { A_method.v() },
                                                                                                                                            new jedd.PhysicalDomain[] { MS.v() })),
                                                                                 contextMethods,
                                                                                 new jedd.PhysicalDomain[] { MS.v() }));
            G.v().out.println(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v() },
                                                                  new jedd.PhysicalDomain[] { C1.v() },
                                                                  "contexts.size() at ContextCountPrinter.jedd:40,31-39",
                                                                  contexts).size() +
                              ": " +
                              m);
        }
        G.v().out.println("End method context counts");
        G.v().out.println("Begin edge context counts");
        AbsCallGraph cg =
          Results.v().callGraph();
        final jedd.internal.RelationContainer csEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> csEdges = cg.csEdges().get(); at ContextCountPrinter." +
                                               "jedd:46,57-64"),
                                              cg.csEdges().get());
        for (Iterator tIt =
               cg.ciEdges().iterator();
             tIt.hasNext();
             ) {
            final Rsrcm_stmt_kind_tgtm.Tuple t =
              (Rsrcm_stmt_kind_tgtm.Tuple)
                tIt.next();
            final jedd.internal.RelationContainer contexts =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                  new jedd.PhysicalDomain[] { C1.v(), C2.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                                   "domains.C1, soot.jimple.paddle.bdddomains.A_tgtc:soot.jimple" +
                                                   ".paddle.bdddomains.C2> contexts = jedd.internal.Jedd.v().com" +
                                                   "pose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().lite" +
                                                   "ral(new java.lang.Object[...], new jedd.Attribute[...], new " +
                                                   "jedd.PhysicalDomain[...])), csEdges, new jedd.PhysicalDomain" +
                                                   "[...]); at ContextCountPrinter.jedd:49,29-37"),
                                                  jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { t.srcm(), t.stmt(), t.kind(), t.tgtm() },
                                                                                                                                            new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                                                                                                            new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() })),
                                                                                 csEdges,
                                                                                 new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() }));
            G.v().out.println(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                                  new jedd.PhysicalDomain[] { C1.v(), C2.v() },
                                                                  "contexts.size() at ContextCountPrinter.jedd:54,16-24",
                                                                  contexts).size() +
                              ": " +
                              new Edge(t.srcm(),
                                       t.stmt(),
                                       t.tgtm(),
                                       t.kind()));
        }
        G.v().out.println("End edge context counts");
        AbsP2Sets p2sets =
          Results.v().p2sets();
        if (p2sets !=
              null) {
            G.v().out.println("Begin variable context counts");
            for (Iterator vnIt =
                   PaddleNumberers.v().varNodeNumberer().iterator();
                 vnIt.hasNext();
                 ) {
                final VarNode vn =
                  (VarNode)
                    vnIt.next();
                final jedd.internal.RelationContainer p2set =
                  new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                                      new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE2.v(), MEASURE4.v(), MEASURE3.v() },
                                                      ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                                       "domains.MEASURE1, soot.jimple.paddle.bdddomains.A_var:soot.j" +
                                                       "imple.paddle.bdddomains.MEASURE2, soot.jimple.paddle.bdddoma" +
                                                       "ins.A_objc:soot.jimple.paddle.bdddomains.MEASURE4, soot.jimp" +
                                                       "le.paddle.bdddomains.A_obj:soot.jimple.paddle.bdddomains.MEA" +
                                                       "SURE3> p2set = jedd.internal.Jedd.v().replace(p2sets.getRead" +
                                                       "er(vn).get(), new jedd.PhysicalDomain[...], new jedd.Physica" +
                                                       "lDomain[...]); at ContextCountPrinter.jedd:65,20-25"),
                                                      jedd.internal.Jedd.v().replace(p2sets.getReader(vn).get(),
                                                                                     new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                                                                     new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE2.v(), MEASURE4.v(), MEASURE3.v() }));
                G.v().out.println(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_varc.v() },
                                                                      new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE1.v() },
                                                                      ("jedd.internal.Jedd.v().project(p2set, new jedd.PhysicalDomai" +
                                                                       "n[...]).size() at ContextCountPrinter.jedd:67,47-51"),
                                                                      jedd.internal.Jedd.v().project(p2set,
                                                                                                     new jedd.PhysicalDomain[] { MEASURE3.v(), MEASURE4.v() })).size() +
                                  ":" +
                                  new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_varc.v() },
                                                                      new jedd.PhysicalDomain[] { MEASURE3.v(), MEASURE1.v() },
                                                                      ("jedd.internal.Jedd.v().project(p2set, new jedd.PhysicalDomai" +
                                                                       "n[...]).width(soot.jimple.paddle.bdddomains.MEASURE1.v()) at" +
                                                                       " ContextCountPrinter.jedd:68,47-52"),
                                                                      jedd.internal.Jedd.v().project(p2set,
                                                                                                     new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE4.v() })).width(MEASURE1.v()) +
                                  ":" +
                                  vn);
            }
            G.v().out.println("End variable context counts");
        }
    }
    
    public static void printTotalContextCounts() {
        AbsReachableMethods rm =
          Results.v().reachableMethods();
        G.v().out.println("Total number of methodcontexts reachable : " +
                          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                              ("rm.contextMethods().get().size() at ContextCountPrinter.jedd" +
                                                               ":76,99-103"),
                                                              rm.contextMethods().get()).size());
        AbsP2Sets p2sets =
          Results.v().p2sets();
        if (p2sets !=
              null) {
            final jedd.internal.RelationContainer p2relation =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                                  new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE2.v(), MEASURE4.v(), MEASURE3.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                                   "domains.MEASURE1, soot.jimple.paddle.bdddomains.A_var:soot.j" +
                                                   "imple.paddle.bdddomains.MEASURE2, soot.jimple.paddle.bdddoma" +
                                                   "ins.A_objc:soot.jimple.paddle.bdddomains.MEASURE4, soot.jimp" +
                                                   "le.paddle.bdddomains.A_obj:soot.jimple.paddle.bdddomains.MEA" +
                                                   "SURE3> p2relation = jedd.internal.Jedd.v().replace(p2sets.ge" +
                                                   "tReader().get(), new jedd.PhysicalDomain[...], new jedd.Phys" +
                                                   "icalDomain[...]); at ContextCountPrinter.jedd:80,16-26"),
                                                  jedd.internal.Jedd.v().replace(p2sets.getReader().get(),
                                                                                 new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                                                                 new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE2.v(), MEASURE4.v(), MEASURE3.v() }));
            G.v().out.println("Total number of contexts in points-to relation: " +
                              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v() },
                                                                  new jedd.PhysicalDomain[] { MEASURE1.v() },
                                                                  ("jedd.internal.Jedd.v().project(p2relation, new jedd.Physical" +
                                                                   "Domain[...]).size() at ContextCountPrinter.jedd:82,58-62"),
                                                                  jedd.internal.Jedd.v().project(p2relation,
                                                                                                 new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v() })).size());
            G.v().out.println(("Total equivalence classes of contexts in points-to relation:" +
                               " ") +
                              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                  new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v(), MEASURE1.v() },
                                                                  ("p2relation.width(soot.jimple.paddle.bdddomains.MEASURE1.v())" +
                                                                   " at ContextCountPrinter.jedd:83,95-105"),
                                                                  p2relation).width(MEASURE1.v()));
            G.v().out.println("Total distinct points-to sets: " +
                              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                  new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v(), MEASURE1.v() },
                                                                  ("p2relation.width(soot.jimple.paddle.bdddomains.MEASURE2.v())" +
                                                                   " at ContextCountPrinter.jedd:84,65-75"),
                                                                  p2relation).width(MEASURE2.v()));
            BDDNodeInfo ni =
              (BDDNodeInfo)
                PaddleScene.v().ni;
            final jedd.internal.RelationContainer p2relationWithMethod =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_method.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                                  new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE15.v(), MEASURE2.v(), MEASURE4.v(), MEASURE3.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                                   "domains.MEASURE1, soot.jimple.paddle.bdddomains.A_method:soo" +
                                                   "t.jimple.paddle.bdddomains.MEASURE15, soot.jimple.paddle.bdd" +
                                                   "domains.A_var:soot.jimple.paddle.bdddomains.MEASURE2, soot.j" +
                                                   "imple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdddomains" +
                                                   ".MEASURE4, soot.jimple.paddle.bdddomains.A_obj:soot.jimple.p" +
                                                   "addle.bdddomains.MEASURE3> p2relationWithMethod = jedd.inter" +
                                                   "nal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.intern" +
                                                   "al.Jedd.v().read(p2relation), jedd.internal.Jedd.v().replace" +
                                                   "(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(ni" +
                                                   ".localMap()), jedd.internal.Jedd.v().join(jedd.internal.Jedd" +
                                                   ".v().read(jedd.internal.Jedd.v().replace(ni.globalSet(), new" +
                                                   " jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...])), j" +
                                                   "edd.internal.Jedd.v().literal(new java.lang.Object[...], new" +
                                                   " jedd.Attribute[...], new jedd.PhysicalDomain[...]), new jed" +
                                                   "d.PhysicalDomain[...])), new jedd.PhysicalDomain[...], new j" +
                                                   "edd.PhysicalDomain[...]), new jedd.PhysicalDomain[...]), new" +
                                                   " jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...]); at" +
                                                   " ContextCountPrinter.jedd:87,16-36"),
                                                  jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(p2relation),
                                                                                                             jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(ni.localMap()),
                                                                                                                                                                         jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                                                                                                                                                                                new jedd.PhysicalDomain[] { V2.v() },
                                                                                                                                                                                                                                                                new jedd.PhysicalDomain[] { V1.v() })),
                                                                                                                                                                                                     jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                                                                                                                                                                    new jedd.Attribute[] { A_method.v() },
                                                                                                                                                                                                                                    new jedd.PhysicalDomain[] { MS.v() }),
                                                                                                                                                                                                     new jedd.PhysicalDomain[] {  })),
                                                                                                                                            new jedd.PhysicalDomain[] { V1.v() },
                                                                                                                                            new jedd.PhysicalDomain[] { MEASURE2.v() }),
                                                                                                             new jedd.PhysicalDomain[] { MEASURE2.v() }),
                                                                                 new jedd.PhysicalDomain[] { MS.v() },
                                                                                 new jedd.PhysicalDomain[] { MEASURE15.v() }));
            final jedd.internal.RelationContainer methodContexts =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_method.v() },
                                                  new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE15.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                                   "domains.MEASURE1, soot.jimple.paddle.bdddomains.A_method:soo" +
                                                   "t.jimple.paddle.bdddomains.MEASURE15> methodContexts = jedd." +
                                                   "internal.Jedd.v().project(p2relationWithMethod, new jedd.Phy" +
                                                   "sicalDomain[...]); at ContextCountPrinter.jedd:92,31-45"),
                                                  jedd.internal.Jedd.v().project(p2relationWithMethod,
                                                                                 new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v() }));
            G.v().out.println("Total number of methodcontexts in points-to relation: " +
                              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_method.v() },
                                                                  new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE15.v() },
                                                                  "methodContexts.size() at ContextCountPrinter.jedd:94,16-30",
                                                                  methodContexts).size());
            G.v().out.println(("Total equivalence classes of methodcontexts in points-to rel" +
                               "ation: ") +
                              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_method.v() },
                                                                  new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v(), MEASURE1.v(), MEASURE15.v() },
                                                                  ("p2relationWithMethod.width(soot.jimple.paddle.bdddomains.MEA" +
                                                                   "SURE15.v()) at ContextCountPrinter.jedd:95,101-121"),
                                                                  p2relationWithMethod).width(MEASURE15.v()));
            G.v().out.println("Total distinct MC points-to sets: " +
                              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_method.v() },
                                                                  new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v(), MEASURE1.v(), MEASURE15.v() },
                                                                  ("p2relationWithMethod.width(soot.jimple.paddle.bdddomains.MEA" +
                                                                   "SURE2.v()) at ContextCountPrinter.jedd:96,68-88"),
                                                                  p2relationWithMethod).width(MEASURE2.v()));
            if (PaddleScene.v().options().method_context_counts()) {
                for (Iterator mIt =
                       Results.v().reachableMethods().methodIterator();
                     mIt.hasNext();
                     ) {
                    final SootMethod m =
                      (SootMethod)
                        mIt.next();
                    final jedd.internal.RelationContainer p2formethod =
                      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                                          new jedd.PhysicalDomain[] { MEASURE1.v(), MEASURE2.v(), MEASURE4.v(), MEASURE3.v() },
                                                          ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                                           "domains.MEASURE1, soot.jimple.paddle.bdddomains.A_var:soot.j" +
                                                           "imple.paddle.bdddomains.MEASURE2, soot.jimple.paddle.bdddoma" +
                                                           "ins.A_objc:soot.jimple.paddle.bdddomains.MEASURE4, soot.jimp" +
                                                           "le.paddle.bdddomains.A_obj:soot.jimple.paddle.bdddomains.MEA" +
                                                           "SURE3> p2formethod = jedd.internal.Jedd.v().compose(jedd.int" +
                                                           "ernal.Jedd.v().read(p2relationWithMethod), jedd.internal.Jed" +
                                                           "d.v().literal(new java.lang.Object[...], new jedd.Attribute[" +
                                                           "...], new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain" +
                                                           "[...]); at ContextCountPrinter.jedd:102,24-35"),
                                                          jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(p2relationWithMethod),
                                                                                         jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                        new jedd.Attribute[] { A_method.v() },
                                                                                                                        new jedd.PhysicalDomain[] { MEASURE15.v() }),
                                                                                         new jedd.PhysicalDomain[] { MEASURE15.v() }));
                    System.out.println("MC: " +
                                       new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v() },
                                                                           new jedd.PhysicalDomain[] { MEASURE1.v() },
                                                                           ("jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(m" +
                                                                            "ethodContexts), jedd.internal.Jedd.v().literal(new java.lang" +
                                                                            ".Object[...], new jedd.Attribute[...], new jedd.PhysicalDoma" +
                                                                            "in[...]), new jedd.PhysicalDomain[...]).size() at ContextCou" +
                                                                            "ntPrinter.jedd:105,81-85"),
                                                                           jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(methodContexts),
                                                                                                          jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                                         new jedd.Attribute[] { A_method.v() },
                                                                                                                                         new jedd.PhysicalDomain[] { MEASURE15.v() }),
                                                                                                          new jedd.PhysicalDomain[] { MEASURE15.v() })).size() +
                                       " " +
                                       new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                           new jedd.PhysicalDomain[] { MEASURE2.v(), MEASURE3.v(), MEASURE4.v(), MEASURE1.v() },
                                                                           ("p2formethod.width(soot.jimple.paddle.bdddomains.MEASURE1.v()" +
                                                                            ") at ContextCountPrinter.jedd:106,24-35"),
                                                                           p2formethod).width(MEASURE1.v()) +
                                       " " +
                                       m);
                    if (m.getName().equals("implies")) {
                        System.out.println(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v() },
                                                                               new jedd.PhysicalDomain[] { MEASURE1.v() },
                                                                               ("jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(m" +
                                                                                "ethodContexts), jedd.internal.Jedd.v().literal(new java.lang" +
                                                                                ".Object[...], new jedd.Attribute[...], new jedd.PhysicalDoma" +
                                                                                "in[...]), new jedd.PhysicalDomain[...]).toString() at Contex" +
                                                                                "tCountPrinter.jedd:109,100-108"),
                                                                               jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(methodContexts),
                                                                                                              jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                                             new jedd.Attribute[] { A_method.v() },
                                                                                                                                             new jedd.PhysicalDomain[] { MEASURE15.v() }),
                                                                                                              new jedd.PhysicalDomain[] { MEASURE15.v() })).toString());
                    }
                }
            }
        }
    }
    
    public ContextCountPrinter() {
        super();
    }
}
