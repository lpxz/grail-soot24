package soot.jimple.paddle;

import soot.jimple.paddle.bdddomains.*;
import soot.*;
import java.util.*;
import soot.toolkits.scalar.*;
import soot.toolkits.graph.*;

public class ExecutesManyAnalysis {
    public class IntraProc extends ForwardFlowAnalysis {
        public IntraProc(UnitGraph g) {
            super(g);
            doAnalysis();
        }
        
        protected void copy(Object inO,
                            Object outO) {
            FlowSet in =
              (FlowSet)
                inO;
            FlowSet out =
              (FlowSet)
                outO;
            in.copy(out);
        }
        
        protected void merge(Object inoutO,
                             Object inO) {
            FlowSet inout =
              (FlowSet)
                inoutO;
            FlowSet in =
              (FlowSet)
                inO;
            inout.union(in);
        }
        
        protected void merge(Object in1O,
                             Object in2O,
                             Object outO) {
            FlowSet in1 =
              (FlowSet)
                in1O;
            FlowSet in2 =
              (FlowSet)
                in2O;
            FlowSet out =
              (FlowSet)
                outO;
            in1.union(in2,
                      out);
        }
        
        protected void flowThrough(Object outValue,
                                   Object unit,
                                   Object inValue) {
            Unit u =
              (Unit)
                unit;
            FlowSet in =
              (FlowSet)
                inValue;
            FlowSet out =
              (FlowSet)
                outValue;
            in.copy(out);
            out.add(u);
        }
        
        protected Object entryInitialFlow() {
            return new ArraySparseSet();
        }
        
        protected Object newInitialFlow() {
            return new ArraySparseSet();
        }
        
        public boolean mayExecuteTwice(Unit u) {
            return ((FlowSet)
                      getFlowBefore(u)).contains(u);
        }
    }
    
    
    public void analyze() {
        final jedd.internal.RelationContainer allContexts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v() },
                                              new jedd.PhysicalDomain[] { C1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1> allContexts = jedd.internal.Jedd.v().trueBDD(); " +
                                               "at ExecutesManyAnalysis.jedd:101,17-28"),
                                              jedd.internal.Jedd.v().trueBDD());
        for (Iterator clIt =
               Scene.v().getApplicationClasses().iterator();
             clIt.hasNext();
             ) {
            final SootClass cl =
              (SootClass)
                clIt.next();
            for (Iterator mIt =
                   cl.getMethods().iterator();
                 mIt.hasNext();
                 ) {
                final SootMethod m =
                  (SootMethod)
                    mIt.next();
                if (!m.hasActiveBody())
                    continue;
                if (!Results.v().reachableMethods().contains(null,
                                                             m))
                    continue;
                IntraProc intra =
                  new IntraProc(new ExceptionalUnitGraph(m.getActiveBody()));
                for (Iterator sIt =
                       m.getActiveBody().getUnits().iterator();
                     sIt.hasNext();
                     ) {
                    final Unit s =
                      (Unit)
                        sIt.next();
                    Scene.v().getUnitNumberer().add(s);
                    stmtMethod.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { s, m },
                                                                      new jedd.Attribute[] { A_stmt.v(), A_method.v() },
                                                                      new jedd.PhysicalDomain[] { ST.v(), MT.v() }));
                    if (intra.mayExecuteTwice(s)) {
                        twiceUnit.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { s },
                                                                                                                                 new jedd.Attribute[] { A_stmt.v() },
                                                                                                                                 new jedd.PhysicalDomain[] { ST.v() })),
                                                                      allContexts,
                                                                      new jedd.PhysicalDomain[] {  }));
                    }
                }
            }
        }
        callGraph.eq(jedd.internal.Jedd.v().project(Results.v().callGraph().csEdges().get(),
                                                    new jedd.PhysicalDomain[] { KD.v() }));
        while (true) {
            final jedd.internal.RelationContainer oldUnit =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_stmt.v() },
                                                  new jedd.PhysicalDomain[] { C1.v(), ST.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                                   "domains.C1, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                                   ".paddle.bdddomains.ST> oldUnit = twiceUnit; at ExecutesManyA" +
                                                   "nalysis.jedd:123,29-36"),
                                                  twiceUnit);
            final jedd.internal.RelationContainer oldMethod =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                                  new jedd.PhysicalDomain[] { C1.v(), MT.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                                   "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                                   "le.paddle.bdddomains.MT> oldMethod = twiceMethod; at Execute" +
                                                   "sManyAnalysis.jedd:124,31-40"),
                                                  twiceMethod);
            twiceMethod.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(twiceUnit),
                                                                                              jedd.internal.Jedd.v().project(callGraph,
                                                                                                                             new jedd.PhysicalDomain[] { MS.v() }),
                                                                                              new jedd.PhysicalDomain[] { ST.v(), C1.v() }),
                                                               new jedd.PhysicalDomain[] { C2.v() },
                                                               new jedd.PhysicalDomain[] { C1.v() }));
            twiceMethod.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(twiceMethod,
                                                                                                                                                         new jedd.PhysicalDomain[] { MT.v() },
                                                                                                                                                         new jedd.PhysicalDomain[] { MS.v() })),
                                                                                              jedd.internal.Jedd.v().project(callGraph,
                                                                                                                             new jedd.PhysicalDomain[] { ST.v() }),
                                                                                              new jedd.PhysicalDomain[] { MS.v(), C1.v() }),
                                                               new jedd.PhysicalDomain[] { C2.v() },
                                                               new jedd.PhysicalDomain[] { C1.v() }));
            twiceUnit.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(twiceMethod),
                                                             stmtMethod,
                                                             new jedd.PhysicalDomain[] { MT.v() }));
            if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(oldUnit),
                                              twiceUnit) &&
                  jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(oldMethod),
                                                twiceMethod))
                break;
        }
    }
    
    public boolean executesMany(Unit s) {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(twiceUnit,
                                                                                                                                                                 new jedd.PhysicalDomain[] { C1.v() })),
                                                                                                      jedd.internal.Jedd.v().literal(new Object[] { s },
                                                                                                                                     new jedd.Attribute[] { A_stmt.v() },
                                                                                                                                     new jedd.PhysicalDomain[] { ST.v() }),
                                                                                                      new jedd.PhysicalDomain[] { ST.v() })),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    public boolean executesMany(SootMethod m) {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(twiceMethod,
                                                                                                                                                                 new jedd.PhysicalDomain[] { C1.v() })),
                                                                                                      jedd.internal.Jedd.v().literal(new Object[] { m },
                                                                                                                                     new jedd.Attribute[] { A_method.v() },
                                                                                                                                     new jedd.PhysicalDomain[] { MT.v() }),
                                                                                                      new jedd.PhysicalDomain[] { MT.v() })),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    protected final jedd.internal.RelationContainer stmtMethod =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { ST.v(), MT.v() },
                                          ("protected <soot.jimple.paddle.bdddomains.A_stmt, soot.jimple" +
                                           ".paddle.bdddomains.A_method> stmtMethod at ExecutesManyAnaly" +
                                           "sis.jedd:140,14-32"));
    
    protected final jedd.internal.RelationContainer twiceUnit =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_stmt.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), ST.v() },
                                          ("protected <soot.jimple.paddle.bdddomains.A_ctxt, soot.jimple" +
                                           ".paddle.bdddomains.A_stmt> twiceUnit at ExecutesManyAnalysis" +
                                           ".jedd:141,14-30"));
    
    protected final jedd.internal.RelationContainer twiceMethod =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), MT.v() },
                                          ("protected <soot.jimple.paddle.bdddomains.A_ctxt, soot.jimple" +
                                           ".paddle.bdddomains.A_method> twiceMethod at ExecutesManyAnal" +
                                           "ysis.jedd:142,14-32"));
    
    protected final jedd.internal.RelationContainer callGraph =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_tgtc.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), C2.v(), MT.v() },
                                          ("protected <soot.jimple.paddle.bdddomains.A_srcc, soot.jimple" +
                                           ".paddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_s" +
                                           "tmt, soot.jimple.paddle.bdddomains.A_tgtc, soot.jimple.paddl" +
                                           "e.bdddomains.A_tgtm> callGraph at ExecutesManyAnalysis.jedd:" +
                                           "143,14-54"));
    
    public ExecutesManyAnalysis() {
        super();
    }
}
