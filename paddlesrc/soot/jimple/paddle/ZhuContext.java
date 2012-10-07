package soot.jimple.paddle;

import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.queue.*;
import soot.*;
import soot.util.*;
import soot.options.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import java.util.*;
import soot.toolkits.graph.*;

public class ZhuContext {
    private static final boolean VERBOSE =
      false;
    
    Numberer numb =
      Scene.v().getMethodNumberer();
    
    StronglyConnectedComponents scc;
    
    AbsCallGraph cicg;
    
    Qsrcc_srcm_stmt_kind_tgtc_tgtm out;
    
    public ZhuContext(AbsCallGraph cicg,
                      Qsrcc_srcm_stmt_kind_tgtc_tgtm out) {
        super();
        this.cicg =
          cicg;
        this.out =
          out;
    }
    
    public void solve() {
        for (int i =
               1;
             i <
               5000;
             i++) {
            Scene.v().getContextNumberer().add(new Integer(i));
        }
        if (VERBOSE)
            System.out.println("Running AOTCG");
        final jedd.internal.RelationContainer methodContexts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> methodContexts = jedd.internal.Jedd" +
                                               ".v().falseBDD(); at ZhuContext.jedd:56,33-47"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer edges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> edges = jedd.internal.Jedd.v().falseBDD(); at ZhuCont" +
                                               "ext.jedd:57,75-80"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer allContextEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), C2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_tgtc:soot.jimple" +
                                               ".paddle.bdddomains.C2> allContextEdges = jedd.internal.Jedd." +
                                               "v().falseBDD(); at ZhuContext.jedd:58,25-40"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer cicgEdges =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                               "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                               ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                               "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                               "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> cicgEdges = cic" +
                                               "g.ciEdges().get(); at ZhuContext.jedd:60,41-50"),
                                              cicg.ciEdges().get());
        final jedd.internal.RelationContainer methods =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                              new jedd.PhysicalDomain[] { MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MT> methods = jedd.internal.Jedd.v().union(jedd.in" +
                                               "ternal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.int" +
                                               "ernal.Jedd.v().project(cicgEdges, new jedd.PhysicalDomain[.." +
                                               ".]), new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[." +
                                               "..])), jedd.internal.Jedd.v().project(cicgEdges, new jedd.Ph" +
                                               "ysicalDomain[...])); at ZhuContext.jedd:62,19-26"),
                                              jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(cicgEdges,
                                                                                                                                                                     new jedd.PhysicalDomain[] { KD.v(), MT.v(), ST.v() }),
                                                                                                                                      new jedd.PhysicalDomain[] { MS.v() },
                                                                                                                                      new jedd.PhysicalDomain[] { MT.v() })),
                                                                           jedd.internal.Jedd.v().project(cicgEdges,
                                                                                                          new jedd.PhysicalDomain[] { KD.v(), MS.v(), ST.v() })));
        for (Iterator mIt =
               Scene.v().getEntryPoints().iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            methods.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m },
                                                           new jedd.Attribute[] { A_method.v() },
                                                           new jedd.PhysicalDomain[] { MT.v() }));
        }
        MutableDirectedGraph el =
          new HashMutableDirectedGraph();
        for (Iterator mIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MT.v() },
                                                   "methods.iterator() at ZhuContext.jedd:72,28-35",
                                                   methods).iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            el.addNode(m);
        }
        for (Iterator eIt =
               new Rsrcm_stmt_kind_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                                               ("new soot.jimple.paddle.queue.Rsrcm_stmt_kind_tgtmBDD(...) at" +
                                                                                " ZhuContext.jedd:77,28-31"),
                                                                               cicgEdges)).iterator();
             eIt.hasNext();
             ) {
            final Rsrcm_stmt_kind_tgtm.Tuple e =
              (Rsrcm_stmt_kind_tgtm.Tuple)
                eIt.next();
            if (!el.containsEdge(e.srcm(),
                                 e.tgtm()))
                el.addEdge(e.srcm(),
                           e.tgtm());
        }
        if (VERBOSE)
            System.out.println("Computing SCC");
        scc =
          new StronglyConnectedComponents(el);
        if (VERBOSE)
            System.out.println("Done computing SCC");
        for (Iterator mIt =
               Scene.v().getEntryPoints().iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            methodContexts.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { getKey(m), null },
                                                                  new jedd.Attribute[] { A_method.v(), A_ctxt.v() },
                                                                  new jedd.PhysicalDomain[] { MS.v(), C1.v() }));
        }
        DirectedGraph sccel =
          scc.getSuperGraph();
        if (VERBOSE)
            System.out.println("Doing topological sort");
        PseudoTopologicalOrderer topo =
          new PseudoTopologicalOrderer();
        List orderedComponents =
          topo.newList(sccel);
        if (VERBOSE)
            System.out.println("Constructing CS call graph");
        if (VERBOSE)
            System.out.println("There are " +
                               scc.getComponents().size() +
                               " scc\'s.");
        if (false) {
            int maxk =
              0;
            Map kValues =
              new HashMap();
            for (Iterator componentIt =
                   orderedComponents.iterator();
                 componentIt.hasNext();
                 ) {
                final List component =
                  (List)
                    componentIt.next();
                int k =
                  0;
                for (Iterator predIt =
                       sccel.getPredsOf(component).iterator();
                     predIt.hasNext();
                     ) {
                    final List pred =
                      (List)
                        predIt.next();
                    int newK =
                      1;
                    Integer i =
                      (Integer)
                        kValues.get(pred);
                    if (i !=
                          null)
                        newK =
                          i.intValue() +
                            1;
                    if (newK >
                          k)
                        k =
                          newK;
                }
                kValues.put(component,
                            new Integer(k));
                if (k >
                      maxk)
                    maxk =
                      k;
            }
            System.out.println("Maximum k is " +
                               maxk);
            System.exit(1);
        }
        for (Iterator componentIt =
               orderedComponents.iterator();
             componentIt.hasNext();
             ) {
            final List component =
              (List)
                componentIt.next();
            long c =
              0;
            if (VERBOSE)
                System.out.println("Processing connected component: " +
                                   component);
            for (Iterator dstIt =
                   component.iterator();
                 dstIt.hasNext();
                 ) {
                final SootMethod dst =
                  (SootMethod)
                    dstIt.next();
                if (VERBOSE)
                    System.out.println("Processing destination method " +
                                       dst);
                final jedd.internal.RelationContainer callers =
                  new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                      new jedd.PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                                      ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                                       "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                                       ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                                       "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                                       "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> callers = jedd." +
                                                       "internal.Jedd.v().join(jedd.internal.Jedd.v().read(cicgEdges" +
                                                       "), jedd.internal.Jedd.v().literal(new java.lang.Object[...]," +
                                                       " new jedd.Attribute[...], new jedd.PhysicalDomain[...]), new" +
                                                       " jedd.PhysicalDomain[...]); at ZhuContext.jedd:125,49-56"),
                                                      jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(cicgEdges),
                                                                                  jedd.internal.Jedd.v().literal(new Object[] { dst },
                                                                                                                 new jedd.Attribute[] { A_tgtm.v() },
                                                                                                                 new jedd.PhysicalDomain[] { MT.v() }),
                                                                                  new jedd.PhysicalDomain[] { MT.v() }));
                for (Iterator eIt =
                       new Rsrcm_stmt_kind_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                                                       new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                                                       ("new soot.jimple.paddle.queue.Rsrcm_stmt_kind_tgtmBDD(...) at" +
                                                                                        " ZhuContext.jedd:127,36-39"),
                                                                                       callers)).iterator();
                     eIt.hasNext();
                     ) {
                    final Rsrcm_stmt_kind_tgtm.Tuple e =
                      (Rsrcm_stmt_kind_tgtm.Tuple)
                        eIt.next();
                    SootMethod src =
                      e.srcm();
                    if (getKey(src) ==
                          getKey(dst))
                        continue;
                    final jedd.internal.RelationContainer contexts =
                      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v() },
                                                          new jedd.PhysicalDomain[] { C1.v() },
                                                          ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                                           "domains.C1> contexts = jedd.internal.Jedd.v().compose(jedd.i" +
                                                           "nternal.Jedd.v().read(methodContexts), jedd.internal.Jedd.v(" +
                                                           ").literal(new java.lang.Object[...], new jedd.Attribute[...]" +
                                                           ", new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[..." +
                                                           "]); at ZhuContext.jedd:131,32-40"),
                                                          jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(methodContexts),
                                                                                         jedd.internal.Jedd.v().literal(new Object[] { getKey(src) },
                                                                                                                        new jedd.Attribute[] { A_method.v() },
                                                                                                                        new jedd.PhysicalDomain[] { MS.v() }),
                                                                                         new jedd.PhysicalDomain[] { MS.v() }));
                    long k =
                      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v() },
                                                          new jedd.PhysicalDomain[] { C1.v() },
                                                          "contexts.size() at ZhuContext.jedd:133,29-37",
                                                          contexts).size();
                    if (k ==
                          0)
                        continue;
                    if (VERBOSE)
                        System.out.println("k is " +
                                           k +
                                           "; c is " +
                                           c);
                    final jedd.internal.RelationContainer contextEdge =
                      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                          new jedd.PhysicalDomain[] { C1.v(), C2.v() },
                                                          ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                                           "domains.C1, soot.jimple.paddle.bdddomains.A_tgtc:soot.jimple" +
                                                           ".paddle.bdddomains.C2> contextEdge = jedd.internal.Jedd.v()." +
                                                           "cast((<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.padd" +
                                                           "le.bdddomains.C1, soot.jimple.paddle.bdddomains.A_tgtc:soot." +
                                                           "jimple.paddle.bdddomains.C2>) new jedd.internal.RelationCont" +
                                                           "ainer(...).add(soot.jimple.paddle.bdddomains.A_srcc.v(), soo" +
                                                           "t.jimple.paddle.bdddomains.C1.v(), soot.jimple.paddle.bdddom" +
                                                           "ains.A_tgtc.v(), ...), new jedd.Attribute[...], new jedd.Phy" +
                                                           "sicalDomain[...]); at ZhuContext.jedd:136,43-54"),
                                                          jedd.internal.Jedd.v().cast((jedd.internal.RelationContainer)
                                                                                        new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v() },
                                                                                                                            new jedd.PhysicalDomain[] { C1.v() },
                                                                                                                            ("contexts.add(soot.jimple.paddle.bdddomains.A_srcc.v(), soot." +
                                                                                                                             "jimple.paddle.bdddomains.C1.v(), soot.jimple.paddle.bdddomai" +
                                                                                                                             "ns.A_tgtc.v(), ...) at ZhuContext.jedd:137,24-32"),
                                                                                                                            contexts).add(A_srcc.v(),
                                                                                                                                          C1.v(),
                                                                                                                                          A_tgtc.v(),
                                                                                                                                          C2.v(),
                                                                                                                                          c),
                                                                                      new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                                                      new jedd.PhysicalDomain[] { C1.v(), C2.v() }));
                    allContextEdges.eqUnion(contextEdge);
                    if (VERBOSE)
                        System.out.println("contextEdge.size is " +
                                           new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                                               new jedd.PhysicalDomain[] { C1.v(), C2.v() },
                                                                               "contextEdge.size() at ZhuContext.jedd:139,74-85",
                                                                               contextEdge).size());
                    if (VERBOSE)
                        System.out.println("allContextEdges.size is " +
                                           new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                                               new jedd.PhysicalDomain[] { C1.v(), C2.v() },
                                                                               "allContextEdges.size() at ZhuContext.jedd:140,78-93",
                                                                               allContextEdges).size());
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
                                                           "Jedd.v().read(contextEdge), jedd.internal.Jedd.v().literal(n" +
                                                           "ew java.lang.Object[...], new jedd.Attribute[...], new jedd." +
                                                           "PhysicalDomain[...]), new jedd.PhysicalDomain[...]); at ZhuC" +
                                                           "ontext.jedd:141,69-77"),
                                                          jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(contextEdge),
                                                                                      jedd.internal.Jedd.v().literal(new Object[] { src, dst, e.stmt(), e.kind() },
                                                                                                                     new jedd.Attribute[] { A_srcm.v(), A_tgtm.v(), A_stmt.v(), A_kind.v() },
                                                                                                                     new jedd.PhysicalDomain[] { MS.v(), MT.v(), ST.v(), KD.v() }),
                                                                                      new jedd.PhysicalDomain[] {  }));
                    if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(edges),
                                                                                                                    newEdges)),
                                                       jedd.internal.Jedd.v().falseBDD())) {
                        System.out.println("ALREADY THERE: " +
                                           new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                               ("jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read" +
                                                                                "(edges), newEdges).toString() at ZhuContext.jedd:145,79-87"),
                                                                               jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(edges),
                                                                                                                newEdges)).toString());
                    }
                    edges.eqUnion(newEdges);
                    if (VERBOSE)
                        System.out.println("edges: " +
                                           new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                               "edges.size() at ZhuContext.jedd:148,61-66",
                                                                               edges).size());
                    methodContexts.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { getKey(dst) },
                                                                                                                                                                 new jedd.Attribute[] { A_method.v() },
                                                                                                                                                                 new jedd.PhysicalDomain[] { MS.v() })),
                                                                                                      jedd.internal.Jedd.v().project(contextEdge,
                                                                                                                                     new jedd.PhysicalDomain[] { C1.v() }),
                                                                                                      new jedd.PhysicalDomain[] {  }),
                                                                          new jedd.PhysicalDomain[] { C2.v() },
                                                                          new jedd.PhysicalDomain[] { C1.v() }));
                    if (VERBOSE)
                        System.out.println(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                                               new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                                               "methodContexts.size() at ZhuContext.jedd:151,52-66",
                                                                               methodContexts).size());
                    c +=
                      k;
                }
            }
        }
        if (VERBOSE)
            System.out.println("Adding intra-SCC edges");
        for (Iterator eIt =
               new Rsrcm_stmt_kind_tgtmBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                                               new jedd.PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                                               ("new soot.jimple.paddle.queue.Rsrcm_stmt_kind_tgtmBDD(...) at" +
                                                                                " ZhuContext.jedd:157,28-31"),
                                                                               cicgEdges)).iterator();
             eIt.hasNext();
             ) {
            final Rsrcm_stmt_kind_tgtm.Tuple e =
              (Rsrcm_stmt_kind_tgtm.Tuple)
                eIt.next();
            SootMethod src =
              e.srcm();
            SootMethod dst =
              e.tgtm();
            if (getKey(src) !=
                  getKey(dst))
                continue;
            if (VERBOSE)
                System.out.println("" +
                                   src +
                                   " -> " +
                                   dst);
            final jedd.internal.RelationContainer context =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v() },
                                                  new jedd.PhysicalDomain[] { C1.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                                   "domains.C1> context = jedd.internal.Jedd.v().compose(jedd.in" +
                                                   "ternal.Jedd.v().read(methodContexts), jedd.internal.Jedd.v()" +
                                                   ".literal(new java.lang.Object[...], new jedd.Attribute[...]," +
                                                   " new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...]" +
                                                   "); at ZhuContext.jedd:163,21-28"),
                                                  jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(methodContexts),
                                                                                 jedd.internal.Jedd.v().literal(new Object[] { getKey(src) },
                                                                                                                new jedd.Attribute[] { A_method.v() },
                                                                                                                new jedd.PhysicalDomain[] { MS.v() }),
                                                                                 new jedd.PhysicalDomain[] { MS.v() }));
            edges.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().copy(context,
                                                                                                              new jedd.PhysicalDomain[] { C1.v() },
                                                                                                              new jedd.Attribute[] { A_ctxt.v() },
                                                                                                              new jedd.PhysicalDomain[] { C2.v() })),
                                                      jedd.internal.Jedd.v().literal(new Object[] { src, dst, e.stmt(), e.kind() },
                                                                                     new jedd.Attribute[] { A_srcm.v(), A_tgtm.v(), A_stmt.v(), A_kind.v() },
                                                                                     new jedd.PhysicalDomain[] { MS.v(), MT.v(), ST.v(), KD.v() }),
                                                      new jedd.PhysicalDomain[] {  }));
        }
        for (Iterator mIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MT.v() },
                                                   "methods.iterator() at ZhuContext.jedd:168,28-35",
                                                   methods).iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            methodContexts.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                          new jedd.Attribute[] { A_method.v() },
                                                                                                                          new jedd.PhysicalDomain[] { MS.v() })),
                                                               jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { getKey(m) },
                                                                                                                                                         new jedd.Attribute[] { A_method.v() },
                                                                                                                                                         new jedd.PhysicalDomain[] { MS.v() })),
                                                                                              methodContexts,
                                                                                              new jedd.PhysicalDomain[] { MS.v() }),
                                                               new jedd.PhysicalDomain[] {  }));
        }
        System.out.println("Number of edges: " +
                           new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                               new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                               "edges.fsize() at ZhuContext.jedd:175,47-52",
                                                               edges).fsize());
        System.out.println("Number of contexts: " +
                           new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                               new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                                               "methodContexts.fsize() at ZhuContext.jedd:176,50-64",
                                                               methodContexts).fsize());
        if (VERBOSE)
            System.out.println("Done AOTCG");
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                    "out.add(edges) at ZhuContext.jedd:178,8-11",
                                                    edges));
        cicg =
          null;
    }
    
    protected SootMethod getKey(SootMethod m) {
        return (SootMethod)
                 scc.getComponentOf(m).get(0);
    }
}
