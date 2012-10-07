package soot.jimple.paddle;

import soot.*;
import soot.jimple.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.options.*;
import java.util.*;
import java.util.zip.*;
import java.io.*;
import jedd.*;
import soot.jimple.toolkits.callgraph.ContextSensitiveCallGraph;
import soot.jimple.toolkits.callgraph.ContextSensitiveEdge;

public class PaddleContextSensitiveCallGraph implements ContextSensitiveCallGraph {
    public PaddleContextSensitiveCallGraph(AbsCallGraph acg) {
        super();
        this.acg =
          acg;
    }
    
  public  AbsCallGraph acg;
    
    class EdgesWrapper {
        final jedd.internal.RelationContainer edges =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.paddle.bd" +
                                               "ddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt, soot." +
                                               "jimple.paddle.bdddomains.A_kind, soot.jimple.paddle.bdddomai" +
                                               "ns.A_tgtc, soot.jimple.paddle.bdddomains.A_tgtm> edges = jed" +
                                               "d.internal.Jedd.v().trueBDD() at PaddleContextSensitiveCallG" +
                                               "raph.jedd:45,8-56"),
                                              jedd.internal.Jedd.v().trueBDD());
        
        public EdgesWrapper() {
            super();
        }
    }
    
    
    private EdgesWrapper edgesWrapper;
    
    private jedd.internal.RelationContainer edges() {
        if (edgesWrapper ==
              null) {
            edgesWrapper =
              new EdgesWrapper();
            edgesWrapper.edges.eq(acg.csEdges().get());
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                   ("return edgesWrapper.edges; at PaddleContextSensitiveCallGrap" +
                                                    "h.jedd:54,8-14"),
                                                   edgesWrapper.edges);
    }
    
    public Iterator edgeSources() {
        return new Iterator() {
            Iterator it =
              new Rctxt_methodBDD(new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                                                      new PhysicalDomain[] { C1.v(), MS.v() },
                                                                      ("new soot.jimple.paddle.queue.Rctxt_methodBDD(...) at PaddleC" +
                                                                       "ontextSensitiveCallGraph.jedd:59,26-29"),
                                                                      jedd.internal.Jedd.v().project(edges(),
                                                                                                     new PhysicalDomain[] { KD.v(), C2.v(), MT.v(), ST.v() }))).iterator();
            
            public boolean hasNext() {
                return it.hasNext();
            }
            
            public Object next() {
                Rctxt_method.Tuple t =
                  (Rctxt_method.Tuple)
                    it.next();
                return MethodContext.v(t.method(),
                                       t.ctxt());
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public Iterator allEdges() {
        return edgeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                                                new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                                                ("edgeIterator(edges()) at PaddleContextSensitiveCallGraph.jed" +
                                                                 "d:75,15-27"),
                                                                edges()));
    }
    
    public Iterator edgesOutOf(Context srcCtxt,
                               SootMethod src,
                               Unit srcUnit) {
        return edgeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                ("edgeIterator(jedd.internal.Jedd.v().join(jedd.internal.Jedd." +
                                                                 "v().read(edges()), jedd.internal.Jedd.v().literal(new java.l" +
                                                                 "ang.Object[...], new jedd.Attribute[...], new jedd.PhysicalD" +
                                                                 "omain[...]), new jedd.PhysicalDomain[...])) at PaddleContext" +
                                                                 "SensitiveCallGraph.jedd:79,15-27"),
                                                                jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(edges()),
                                                                                            jedd.internal.Jedd.v().literal(new Object[] { srcCtxt, src, srcUnit },
                                                                                                                           new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v() },
                                                                                                                           new PhysicalDomain[] { C1.v(), MS.v(), ST.v() }),
                                                                                            new PhysicalDomain[] { C1.v(), MS.v(), ST.v() })));
    }
    
    public Iterator edgesOutOf(Context srcCtxt,
                               SootMethod src) {
        return edgeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                ("edgeIterator(jedd.internal.Jedd.v().join(jedd.internal.Jedd." +
                                                                 "v().read(edges()), jedd.internal.Jedd.v().literal(new java.l" +
                                                                 "ang.Object[...], new jedd.Attribute[...], new jedd.PhysicalD" +
                                                                 "omain[...]), new jedd.PhysicalDomain[...])) at PaddleContext" +
                                                                 "SensitiveCallGraph.jedd:84,15-27"),
                                                                jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(edges()),
                                                                                            jedd.internal.Jedd.v().literal(new Object[] { srcCtxt, src },
                                                                                                                           new Attribute[] { A_srcc.v(), A_srcm.v() },
                                                                                                                           new PhysicalDomain[] { C1.v(), MS.v() }),
                                                                                            new PhysicalDomain[] { C1.v(), MS.v() })));
    }
    
    public Iterator edgesInto(Context tgtCtxt,
                              SootMethod tgt) {
        return edgeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                ("edgeIterator(jedd.internal.Jedd.v().join(jedd.internal.Jedd." +
                                                                 "v().read(edges()), jedd.internal.Jedd.v().literal(new java.l" +
                                                                 "ang.Object[...], new jedd.Attribute[...], new jedd.PhysicalD" +
                                                                 "omain[...]), new jedd.PhysicalDomain[...])) at PaddleContext" +
                                                                 "SensitiveCallGraph.jedd:89,15-27"),
                                                                jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(edges()),
                                                                                            jedd.internal.Jedd.v().literal(new Object[] { tgtCtxt, tgt },
                                                                                                                           new Attribute[] { A_tgtc.v(), A_tgtm.v() },
                                                                                                                           new PhysicalDomain[] { C2.v(), MT.v() }),
                                                                                            new PhysicalDomain[] { C2.v(), MT.v() })));
    }
    
    private static Iterator edgeIterator(final jedd.internal.RelationContainer edges) {
        return new Iterator() {
            Iterator it =
              new Rsrcc_srcm_stmt_kind_tgtc_tgtmBDD(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                                        new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                                        ("new soot.jimple.paddle.queue.Rsrcc_srcm_stmt_kind_tgtc_tgtmB" +
                                                                                         "DD(...) at PaddleContextSensitiveCallGraph.jedd:95,26-29"),
                                                                                        edges)).iterator();
            
            public boolean hasNext() {
                return it.hasNext();
            }
            
            public Object next() {
                final Rsrcc_srcm_stmt_kind_tgtc_tgtm.Tuple t =
                  (Rsrcc_srcm_stmt_kind_tgtc_tgtm.Tuple)
                    it.next();
                return new ContextSensitiveEdge() {
                    public Context srcCtxt() {
                        return t.srcc();
                    }
                    
                    public SootMethod src() {
                        return t.srcm();
                    }
                    
                    public Unit srcUnit() {
                        return t.stmt();
                    }
                    
                    public Stmt srcStmt() {
                        return (Stmt)
                                 t.stmt();
                    }
                    
                    public Kind kind() {
                        return t.kind();
                    }
                    
                    public Context tgtCtxt() {
                        return t.tgtc();
                    }
                    
                    public SootMethod tgt() {
                        return t.tgtm();
                    }
                };
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
