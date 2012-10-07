package soot.jimple.paddle;

import soot.*;
import soot.jimple.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.queue.*;
import soot.util.*;
import java.util.*;

public class BDDEscapeAnalysis {
    final jedd.internal.RelationContainer escapesThread =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { CH1.v(), H1.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_objc, soot.jimple.paddle.bd" +
                                           "ddomains.A_obj> escapesThread = jedd.internal.Jedd.v().false" +
                                           "BDD() at BDDEscapeAnalysis.jedd:30,4-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    final jedd.internal.RelationContainer escapesMethod =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { CH1.v(), H2.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_objc, soot.jimple.paddle.bd" +
                                           "ddomains.A_obj> escapesMethod = jedd.internal.Jedd.v().false" +
                                           "BDD() at BDDEscapeAnalysis.jedd:31,4-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer staticVars =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v() },
                                          new jedd.PhysicalDomain[] { V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var> staticVars = j" +
                                           "edd.internal.Jedd.v().falseBDD() at BDDEscapeAnalysis.jedd:3" +
                                           "3,12-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer threadThis =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v() },
                                          new jedd.PhysicalDomain[] { V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var> threadThis = j" +
                                           "edd.internal.Jedd.v().falseBDD() at BDDEscapeAnalysis.jedd:3" +
                                           "4,12-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer methodRoots =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_var.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method, soot.jimple" +
                                           ".paddle.bdddomains.A_var> methodRoots = jedd.internal.Jedd.v" +
                                           "().falseBDD() at BDDEscapeAnalysis.jedd:36,12-29"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer pt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj> pt = jedd.internal.Je" +
                                           "dd.v().falseBDD() at BDDEscapeAnalysis.jedd:38,12-42"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer fieldPt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_basec.v(), A_base.v(), A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { CH1.v(), H1.v(), CH2.v(), H2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_basec, soot.jimple." +
                                           "paddle.bdddomains.A_base, soot.jimple.paddle.bdddomains.A_ob" +
                                           "jc, soot.jimple.paddle.bdddomains.A_obj> fieldPt = jedd.inte" +
                                           "rnal.Jedd.v().falseBDD() at BDDEscapeAnalysis.jedd:39,12-44"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private void setupRoots() {
        pt.eq(Results.v().p2sets().getReader().get());
        fieldPt.eq(jedd.internal.Jedd.v().project(Results.v().p2sets().fieldPt().get(),
                                                  new jedd.PhysicalDomain[] { FD.v() }));
        NodeFactory gnf =
          Results.v().nodeFactory();
        Rmethod rmethods =
          Results.v().reachableMethods().methods();
        final jedd.internal.RelationContainer methods =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                              new jedd.PhysicalDomain[] { MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MS> methods = rmethods.get(); at BDDEscapeAnalysis" +
                                               ".jedd:47,19-26"),
                                              rmethods.get());
        for (Iterator mIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MS.v() },
                                                   "methods.iterator() at BDDEscapeAnalysis.jedd:48,28-35",
                                                   methods).iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            MethodNodeFactory mnf =
              new MethodNodeFactory(m,
                                    gnf);
            if (!m.isStatic()) {
                methodRoots.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m, mnf.caseThis() },
                                                                   new jedd.Attribute[] { A_method.v(), A_var.v() },
                                                                   new jedd.PhysicalDomain[] { MS.v(), V1.v() }));
            }
            for (int i =
                   0;
                 i <
                   m.getParameterCount();
                 i++) {
                if (!(m.getParameterType(i) instanceof RefLikeType))
                    continue;
                methodRoots.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m, mnf.caseParm(i) },
                                                                   new jedd.Attribute[] { A_method.v(), A_var.v() },
                                                                   new jedd.PhysicalDomain[] { MS.v(), V1.v() }));
            }
            if (m.getReturnType() instanceof RefLikeType) {
                methodRoots.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m, mnf.caseRet() },
                                                                   new jedd.Attribute[] { A_method.v(), A_var.v() },
                                                                   new jedd.PhysicalDomain[] { MS.v(), V1.v() }));
            }
        }
        methodRoots.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(methods),
                                                        jedd.internal.Jedd.v().literal(new Object[] { gnf.caseThrow() },
                                                                                       new jedd.Attribute[] { A_var.v() },
                                                                                       new jedd.PhysicalDomain[] { V1.v() }),
                                                        new jedd.PhysicalDomain[] {  }));
        for (Iterator vnIt =
               PaddleNumberers.v().varNodeNumberer().iterator();
             vnIt.hasNext();
             ) {
            final VarNode vn =
              (VarNode)
                vnIt.next();
            Object o =
              vn.getVariable();
            if (o instanceof SootField) {
                SootField sf =
                  (SootField)
                    o;
                if (sf.isStatic())
                    staticVars.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { vn },
                                                                      new jedd.Attribute[] { A_var.v() },
                                                                      new jedd.PhysicalDomain[] { V1.v() }));
            }
        }
        FastHierarchy fh =
          Scene.v().getOrMakeFastHierarchy();
        LinkedList queue =
          new LinkedList();
        queue.add(Scene.v().getSootClass("java.lang.Thread"));
        while (!queue.isEmpty()) {
            SootClass cl =
              (SootClass)
                queue.removeFirst();
            queue.addAll(fh.getSubclassesOf(cl));
            if (cl.declaresMethod(sigRun)) {
                SootMethod run =
                  cl.getMethod(sigRun);
                threadThis.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { new MethodNodeFactory(run,
                                                                                                       gnf).caseThis() },
                                                                  new jedd.Attribute[] { A_var.v() },
                                                                  new jedd.PhysicalDomain[] { V1.v() }));
            }
        }
    }
    
    private NumberedString sigRun =
      Scene.v().getSubSigNumberer().findOrAdd("void run()");
    
    private void propagate() {
        escapesThread.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(pt,
                                                                                                                        new jedd.PhysicalDomain[] { C1.v() })),
                                                             jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(staticVars),
                                                                                          threadThis),
                                                             new jedd.PhysicalDomain[] { V1.v() }));
        while (true) {
            if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(escapesThread),
                                               escapesThread.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(escapesThread),
                                                                                                                                   fieldPt,
                                                                                                                                   new jedd.PhysicalDomain[] { CH1.v(), H1.v() }),
                                                                                                    new jedd.PhysicalDomain[] { H2.v(), CH2.v() },
                                                                                                    new jedd.PhysicalDomain[] { H1.v(), CH1.v() }))))
                break;
        }
        final jedd.internal.RelationContainer methodReachable =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v(), A_objc.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_obj" +
                                               "c:soot.jimple.paddle.bdddomains.CH2, soot.jimple.paddle.bddd" +
                                               "omains.A_obj:soot.jimple.paddle.bdddomains.H2> methodReachab" +
                                               "le = jedd.internal.Jedd.v().falseBDD(); at BDDEscapeAnalysis" +
                                               ".jedd:96,42-57"),
                                              jedd.internal.Jedd.v().falseBDD());
        methodReachable.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(pt),
                                                                                              methodRoots,
                                                                                              new jedd.PhysicalDomain[] { V1.v() }),
                                                               new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                               new jedd.PhysicalDomain[] { H2.v(), CH2.v() }));
        while (true) {
            if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(methodReachable),
                                              methodReachable.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(methodReachable,
                                                                                                                                                                new jedd.PhysicalDomain[] { H2.v(), CH2.v() },
                                                                                                                                                                new jedd.PhysicalDomain[] { H1.v(), CH1.v() })),
                                                                                                     fieldPt,
                                                                                                     new jedd.PhysicalDomain[] { CH1.v(), H1.v() }))))
                break;
        }
        final jedd.internal.RelationContainer localallocs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { H2.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H2, soot.jimple.paddle.bdddomains.A_method:soot.jimpl" +
                                               "e.paddle.bdddomains.MS> localallocs = (soot.jimple.paddle.BD" +
                                               "DNodeInfo) soot.jimple.paddle.PaddleScene.v().ni.localallocM" +
                                               "ap(); at BDDEscapeAnalysis.jedd:104,26-37"),
                                              ((BDDNodeInfo)
                                                 PaddleScene.v().ni).localallocMap());
        escapesMethod.eqUnion(jedd.internal.Jedd.v().replace(escapesThread,
                                                             new jedd.PhysicalDomain[] { H1.v() },
                                                             new jedd.PhysicalDomain[] { H2.v() }));
        final jedd.internal.RelationContainer methodMatches =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v(), A_objc.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), CH1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_obj" +
                                               "c:soot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bddd" +
                                               "omains.A_obj:soot.jimple.paddle.bdddomains.H2> methodMatches" +
                                               " = jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().joi" +
                                               "n(jedd.internal.Jedd.v().read(methodReachable), localallocs," +
                                               " new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...]" +
                                               ", new jedd.PhysicalDomain[...]); at BDDEscapeAnalysis.jedd:1" +
                                               "07,42-55"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(methodReachable),
                                                                                                         localallocs,
                                                                                                         new jedd.PhysicalDomain[] { MS.v(), H2.v() }),
                                                                             new jedd.PhysicalDomain[] { CH2.v() },
                                                                             new jedd.PhysicalDomain[] { CH1.v() }));
        final jedd.internal.RelationContainer contextMatches =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_objc.v(), A_method.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { CH1.v(), MS.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdd" +
                                               "domains.CH1, soot.jimple.paddle.bdddomains.A_method:soot.jim" +
                                               "ple.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_ob" +
                                               "j:soot.jimple.paddle.bdddomains.H2> contextMatches; at BDDEs" +
                                               "capeAnalysis.jedd:109,34-48"));
        if (PaddleScene.v().options().context_heap()) {
            contextMatches.eq(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(methodMatches,
                                                                                                                                                                                   new jedd.PhysicalDomain[] { C1.v() }),
                                                                                                                                                    new jedd.PhysicalDomain[] { CH1.v() },
                                                                                                                                                    new jedd.PhysicalDomain[] { C1.v() })),
                                                                                         jedd.internal.Jedd.v().project(methodMatches,
                                                                                                                        new jedd.PhysicalDomain[] { CH1.v() }),
                                                                                         new jedd.PhysicalDomain[] { C1.v(), MS.v(), H2.v() }),
                                                             new jedd.PhysicalDomain[] { C1.v() },
                                                             new jedd.PhysicalDomain[] { CH1.v() }));
        } else {
            contextMatches.eq(jedd.internal.Jedd.v().project(methodMatches,
                                                             new jedd.PhysicalDomain[] { C1.v() }));
        }
        escapesMethod.eqUnion(jedd.internal.Jedd.v().project(contextMatches,
                                                             new jedd.PhysicalDomain[] { MS.v() }));
        escapesMethod.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(((BDDNodeInfo)
                                                                                         PaddleScene.v().ni).globalallocSet()),
                                                          jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                         new jedd.Attribute[] { A_objc.v() },
                                                                                         new jedd.PhysicalDomain[] { CH1.v() }),
                                                          new jedd.PhysicalDomain[] {  }));
    }
    
    public void analyze() {
        setupRoots();
        propagate();
    }
    
    public Iterator escapesThread() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                                   new jedd.PhysicalDomain[] { H1.v() },
                                                   ("jedd.internal.Jedd.v().project(escapesThread, new jedd.Physi" +
                                                    "calDomain[...]).iterator() at BDDEscapeAnalysis.jedd:128,42-" +
                                                    "50"),
                                                   jedd.internal.Jedd.v().project(escapesThread,
                                                                                  new jedd.PhysicalDomain[] { CH1.v() })).iterator();
    }
    
    public Iterator escapesMethod() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                                   new jedd.PhysicalDomain[] { H2.v() },
                                                   ("jedd.internal.Jedd.v().project(escapesMethod, new jedd.Physi" +
                                                    "calDomain[...]).iterator() at BDDEscapeAnalysis.jedd:131,42-" +
                                                    "50"),
                                                   jedd.internal.Jedd.v().project(escapesMethod,
                                                                                  new jedd.PhysicalDomain[] { CH1.v() })).iterator();
    }
    
    public BDDEscapeAnalysis() {
        super();
    }
}
