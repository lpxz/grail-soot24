package soot.jimple.paddle;

import soot.*;
import soot.jimple.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class BDDCflowStack {
    public static final boolean DEBUG =
      false;
    
    BDDCflow cflow;
    
    boolean bindsArgs;
    
    public BDDCflowStack(BDDCflow cflow,
                         Collection shadows,
                         Collection isValids,
                         boolean bindsArgs) {
        super();
        this.cflow =
          cflow;
        this.bindsArgs =
          bindsArgs;
        for (Iterator sIt =
               isValids.iterator();
             sIt.hasNext();
             ) {
            final Stmt s =
              (Stmt)
                sIt.next();
            Scene.v().getUnitNumberer().add(s);
            this.isValids.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { s },
                                                                 new jedd.Attribute[] { A_stmt.v() },
                                                                 new jedd.PhysicalDomain[] { ST.v() }));
        }
        for (Iterator sIt =
               shadows.iterator();
             sIt.hasNext();
             ) {
            final Shadow s =
              (Shadow)
                sIt.next();
            ShadowNumberer.v().add(s);
            Scene.v().getUnitNumberer().add(s.pushStmt());
            Scene.v().getUnitNumberer().add(s.popStmt());
            this.shadows.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { s },
                                                                new jedd.Attribute[] { A_shadow.v() },
                                                                new jedd.PhysicalDomain[] { V1.v() }));
            this.pushes.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { s, s.pushStmt() },
                                                               new jedd.Attribute[] { A_shadow.v(), A_stmt.v() },
                                                               new jedd.PhysicalDomain[] { V1.v(), ST.v() }));
        }
    }
    
    private void debug(String s) {
        if (DEBUG)
            G.v().out.println(s);
    }
    
    private jedd.internal.RelationContainer within(Shadow sh) {
        debug("Doing within " +
              sh);
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                               "domains.ST> ret = jedd.internal.Jedd.v().falseBDD(); at BDDC" +
                                               "flowStack.jedd:60,17-20"),
                                              jedd.internal.Jedd.v().falseBDD());
        boolean inShadow =
          false;
        for (Iterator sIt =
               sh.method().getActiveBody().getUnits().iterator();
             sIt.hasNext();
             ) {
            final Stmt s =
              (Stmt)
                sIt.next();
            if (s ==
                  sh.popStmt())
                inShadow =
                  false;
            if (inShadow) {
                Scene.v().getUnitNumberer().add(s);
                ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { s },
                                                           new jedd.Attribute[] { A_stmt.v() },
                                                           new jedd.PhysicalDomain[] { ST.v() }));
            }
            if (s ==
                  sh.pushStmt())
                inShadow =
                  true;
        }
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { ST.v() },
                                                   "return ret; at BDDCflowStack.jedd:71,8-14",
                                                   ret);
    }
    
    private jedd.internal.RelationContainer targetsOf(final jedd.internal.RelationContainer calls) {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                   new jedd.PhysicalDomain[] { MT.v() },
                                                   ("return jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v()" +
                                                    ".read(jedd.internal.Jedd.v().project(cflow.callGraph(), new " +
                                                    "jedd.PhysicalDomain[...])), calls, new jedd.PhysicalDomain[." +
                                                    "..]); at BDDCflowStack.jedd:75,8-14"),
                                                   jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(cflow.callGraph(),
                                                                                                                                             new jedd.PhysicalDomain[] { MS.v() })),
                                                                                  calls,
                                                                                  new jedd.PhysicalDomain[] { ST.v() }));
    }
    
    private jedd.internal.RelationContainer targetsOfShadow(final jedd.internal.RelationContainer calls) {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_shadow.v() },
                                                   new jedd.PhysicalDomain[] { MT.v(), V1.v() },
                                                   ("return jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v()" +
                                                    ".read(jedd.internal.Jedd.v().project(cflow.callGraph(), new " +
                                                    "jedd.PhysicalDomain[...])), calls, new jedd.PhysicalDomain[." +
                                                    "..]); at BDDCflowStack.jedd:79,8-14"),
                                                   jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(cflow.callGraph(),
                                                                                                                                             new jedd.PhysicalDomain[] { MS.v() })),
                                                                                  calls,
                                                                                  new jedd.PhysicalDomain[] { ST.v() }));
    }
    
    private jedd.internal.RelationContainer stmtsIn(final jedd.internal.RelationContainer methods) {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { ST.v() },
                                                   ("return jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v()" +
                                                    ".read(cflow.stmtMethod()), methods, new jedd.PhysicalDomain[" +
                                                    "...]); at BDDCflowStack.jedd:83,8-14"),
                                                   jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(cflow.stmtMethod()),
                                                                                  methods,
                                                                                  new jedd.PhysicalDomain[] { MT.v() }));
    }
    
    private jedd.internal.RelationContainer stmtsInShadow(final jedd.internal.RelationContainer methods) {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v(), A_shadow.v() },
                                                   new jedd.PhysicalDomain[] { ST.v(), V1.v() },
                                                   ("return jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v()" +
                                                    ".read(cflow.stmtMethod()), methods, new jedd.PhysicalDomain[" +
                                                    "...]); at BDDCflowStack.jedd:87,8-14"),
                                                   jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(cflow.stmtMethod()),
                                                                                  methods,
                                                                                  new jedd.PhysicalDomain[] { MT.v() }));
    }
    
    private jedd.internal.RelationContainer mayCflow() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_stmt.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_shadow:soot.jimple.paddle.b" +
                                               "dddomains.V1, soot.jimple.paddle.bdddomains.A_stmt:soot.jimp" +
                                               "le.paddle.bdddomains.ST> ret = jedd.internal.Jedd.v().falseB" +
                                               "DD(); at BDDCflowStack.jedd:91,27-30"),
                                              jedd.internal.Jedd.v().falseBDD());
        for (Iterator shIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                                   new jedd.PhysicalDomain[] { V1.v() },
                                                   "shadows.iterator() at BDDCflowStack.jedd:92,29-36",
                                                   shadows).iterator();
             shIt.hasNext();
             ) {
            final Shadow sh =
              (Shadow)
                shIt.next();
            ret.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { sh },
                                                                                                               new jedd.Attribute[] { A_shadow.v() },
                                                                                                               new jedd.PhysicalDomain[] { V1.v() })),
                                                    within(sh),
                                                    new jedd.PhysicalDomain[] {  }));
        }
        while (true) {
            final jedd.internal.RelationContainer targets =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_method.v() },
                                                  new jedd.PhysicalDomain[] { V1.v(), MT.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_shadow:soot.jimple.paddle.b" +
                                                   "dddomains.V1, soot.jimple.paddle.bdddomains.A_method:soot.ji" +
                                                   "mple.paddle.bdddomains.MT> targets = targetsOfShadow(new jed" +
                                                   "d.internal.RelationContainer(...)); at BDDCflowStack.jedd:97" +
                                                   ",33-40"),
                                                  targetsOfShadow(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_stmt.v() },
                                                                                                      new jedd.PhysicalDomain[] { V1.v(), ST.v() },
                                                                                                      "targetsOfShadow(ret) at BDDCflowStack.jedd:97,43-58",
                                                                                                      ret)));
            if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(ret),
                                              ret.eqUnion(stmtsInShadow(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_method.v() },
                                                                                                            new jedd.PhysicalDomain[] { V1.v(), MT.v() },
                                                                                                            "stmtsInShadow(targets) at BDDCflowStack.jedd:98,31-44",
                                                                                                            targets)))))
                break;
        }
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { V1.v(), ST.v() },
                                                   "return ret; at BDDCflowStack.jedd:100,8-14",
                                                   ret);
    }
    
    private jedd.internal.RelationContainer mustCflow() {
        final jedd.internal.RelationContainer shadowStmts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                               "domains.ST> shadowStmts = jedd.internal.Jedd.v().falseBDD();" +
                                               " at BDDCflowStack.jedd:121,17-28"),
                                              jedd.internal.Jedd.v().falseBDD());
        for (Iterator shIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                                   new jedd.PhysicalDomain[] { V1.v() },
                                                   "shadows.iterator() at BDDCflowStack.jedd:122,29-36",
                                                   shadows).iterator();
             shIt.hasNext();
             ) {
            final Shadow sh =
              (Shadow)
                shIt.next();
            if (sh.unconditional()) {
                shadowStmts.eqUnion(within(sh));
            }
        }
        final jedd.internal.RelationContainer targets =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                              new jedd.PhysicalDomain[] { MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MT> targets = jedd.internal.Jedd.v().falseBDD(); a" +
                                               "t BDDCflowStack.jedd:128,19-26"),
                                              jedd.internal.Jedd.v().falseBDD());
        for (Iterator mIt =
               Scene.v().getEntryPoints().iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            targets.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m },
                                                           new jedd.Attribute[] { A_method.v() },
                                                           new jedd.PhysicalDomain[] { MT.v() }));
        }
        targets.eqUnion(cflow.threadEntries());
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                               "domains.ST> ret = jedd.internal.Jedd.v().falseBDD(); at BDDC" +
                                               "flowStack.jedd:134,17-20"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer oldRet =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                               "domains.ST> oldRet; at BDDCflowStack.jedd:135,17-23"));
        do  {
            final jedd.internal.RelationContainer targetStmts =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                  new jedd.PhysicalDomain[] { ST.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                                   "domains.ST> targetStmts = stmtsIn(new jedd.internal.Relation" +
                                                   "Container(...)); at BDDCflowStack.jedd:137,21-32"),
                                                  stmtsIn(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v() },
                                                                                              new jedd.PhysicalDomain[] { MT.v() },
                                                                                              "stmtsIn(targets) at BDDCflowStack.jedd:137,35-42",
                                                                                              targets)));
            targetStmts.eqMinus(shadowStmts);
            targets.eq(targetsOf(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                                     new jedd.PhysicalDomain[] { ST.v() },
                                                                     "targetsOf(targetStmts) at BDDCflowStack.jedd:139,22-31",
                                                                     targetStmts)));
            oldRet.eq(ret);
            ret.eqUnion(targetStmts);
        }while(!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(oldRet),
                                              ret)); 
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { ST.v() },
                                                   ("return jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().r" +
                                                    "ead(jedd.internal.Jedd.v().trueBDD()), ret); at BDDCflowStac" +
                                                    "k.jedd:143,8-14"),
                                                   jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().trueBDD()),
                                                                                ret));
    }
    
    private final jedd.internal.RelationContainer shadows =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                          new jedd.PhysicalDomain[] { V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_shadow:soot.jimple." +
                                           "paddle.bdddomains.V1> shadows = jedd.internal.Jedd.v().false" +
                                           "BDD() at BDDCflowStack.jedd:146,12-25"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer pushes =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_stmt.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), ST.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_shadow, soot.jimple" +
                                           ".paddle.bdddomains.A_stmt> pushes = jedd.internal.Jedd.v().f" +
                                           "alseBDD() at BDDCflowStack.jedd:147,12-30"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer mustCflow =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                          new jedd.PhysicalDomain[] { ST.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_stmt> mustCflow = j" +
                                           "edd.internal.Jedd.v().trueBDD() at BDDCflowStack.jedd:148,12" +
                                           "-20"),
                                          jedd.internal.Jedd.v().trueBDD());
    
    private final jedd.internal.RelationContainer mayCflow =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v(), A_stmt.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), ST.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_shadow, soot.jimple" +
                                           ".paddle.bdddomains.A_stmt> mayCflow = jedd.internal.Jedd.v()" +
                                           ".trueBDD() at BDDCflowStack.jedd:149,12-30"),
                                          jedd.internal.Jedd.v().trueBDD());
    
    private final jedd.internal.RelationContainer isValids =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                          new jedd.PhysicalDomain[] { ST.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_stmt> isValids = je" +
                                           "dd.internal.Jedd.v().falseBDD() at BDDCflowStack.jedd:150,12" +
                                           "-20"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer neverValid =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                          new jedd.PhysicalDomain[] { ST.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_stmt> neverValid = " +
                                           "jedd.internal.Jedd.v().falseBDD() at BDDCflowStack.jedd:151," +
                                           "12-20"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer alwaysValid =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                          new jedd.PhysicalDomain[] { ST.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_stmt> alwaysValid =" +
                                           " jedd.internal.Jedd.v().falseBDD() at BDDCflowStack.jedd:152" +
                                           ",12-20"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public String queryStats() {
        return "LaTeX: " +
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                                   new jedd.PhysicalDomain[] { V1.v() },
                                                   "shadows.size() at BDDCflowStack.jedd:156,13-20",
                                                   shadows).size() +
               " & " +
               (new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                                    new jedd.PhysicalDomain[] { V1.v() },
                                                    "shadows.size() at BDDCflowStack.jedd:157,14-21",
                                                    shadows).size() -
                  new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                                      new jedd.PhysicalDomain[] { V1.v() },
                                                      "unnecessaryShadows.size() at BDDCflowStack.jedd:157,29-47",
                                                      unnecessaryShadows).size()) +
               " & " +
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { ST.v() },
                                                   "isValids.size() at BDDCflowStack.jedd:158,13-21",
                                                   isValids).size() +
               " & " +
               +new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { ST.v() },
                                                    ("jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read" +
                                                     "(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().rea" +
                                                     "d(isValids), neverValid)), alwaysValid).size() at BDDCflowSt" +
                                                     "ack.jedd:159,47-51"),
                                                    jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(isValids),
                                                                                                                                                  neverValid)),
                                                                                     alwaysValid)).size() +
               " & " +
               +new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { ST.v() },
                                                    ("jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(nev" +
                                                     "erValid), alwaysValid).size() at BDDCflowStack.jedd:160,38-4" +
                                                     "2"),
                                                    jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(neverValid),
                                                                                 alwaysValid)).size() +
               " & " +
               +new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { ST.v() },
                                                    ("jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(alw" +
                                                     "aysValid), neverValid).size() at BDDCflowStack.jedd:161,38-4" +
                                                     "2"),
                                                    jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(alwaysValid),
                                                                                 neverValid)).size() +
               " & " +
               +new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { ST.v() },
                                                    ("jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jed" +
                                                     "d.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(isVali" +
                                                     "ds), neverValid)), alwaysValid).size() at BDDCflowStack.jedd" +
                                                     ":162,47-51"),
                                                    jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(isValids),
                                                                                                                                          neverValid)),
                                                                                 alwaysValid)).size() +
        " \\";
    }
    
    public boolean neverValid(Stmt s) {
        if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(mayCflow),
                                          jedd.internal.Jedd.v().trueBDD()))
            mayCflow.eq(mayCflow());
        return jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { s },
                                                                                                                                                                new jedd.Attribute[] { A_stmt.v() },
                                                                                                                                                                new jedd.PhysicalDomain[] { ST.v() })),
                                                                                                     jedd.internal.Jedd.v().project(mayCflow,
                                                                                                                                    new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                     new jedd.PhysicalDomain[] { ST.v() })),
                                             jedd.internal.Jedd.v().falseBDD());
    }
    
    public boolean alwaysValid(Stmt s) {
        if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(mustCflow),
                                          jedd.internal.Jedd.v().trueBDD()))
            mustCflow.eq(mustCflow());
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { s },
                                                                                                                                                                 new jedd.Attribute[] { A_stmt.v() },
                                                                                                                                                                 new jedd.PhysicalDomain[] { ST.v() })),
                                                                                                      mustCflow,
                                                                                                      new jedd.PhysicalDomain[] { ST.v() })),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    private jedd.internal.RelationContainer computeNeverValid() {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(neverValid),
                                           jedd.internal.Jedd.v().falseBDD()))
            return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                       new jedd.PhysicalDomain[] { ST.v() },
                                                       "return neverValid; at BDDCflowStack.jedd:188,29-35",
                                                       neverValid);
        if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(mayCflow),
                                          jedd.internal.Jedd.v().trueBDD()))
            mayCflow.eq(mayCflow());
        final jedd.internal.RelationContainer mayBeValid =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                               "domains.ST> mayBeValid = jedd.internal.Jedd.v().join(jedd.in" +
                                               "ternal.Jedd.v().read(jedd.internal.Jedd.v().project(mayCflow" +
                                               ", new jedd.PhysicalDomain[...])), isValids, new jedd.Physica" +
                                               "lDomain[...]); at BDDCflowStack.jedd:190,17-27"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(mayCflow,
                                                                                                                                     new jedd.PhysicalDomain[] { V1.v() })),
                                                                          isValids,
                                                                          new jedd.PhysicalDomain[] { ST.v() }));
        neverValid.eq(jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(isValids),
                                                   mayBeValid));
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { ST.v() },
                                                   "return neverValid; at BDDCflowStack.jedd:192,8-14",
                                                   neverValid);
    }
    
    public Iterator neverValid() {
        debug("Computing neverValid");
        Iterator ret =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("computeNeverValid().iterator() at BDDCflowStack.jedd:199,43-" +
                                               "51"),
                                              computeNeverValid()).iterator();
        debug("Done computing neverValid");
        return ret;
    }
    
    private jedd.internal.RelationContainer computeAlwaysValid() {
        if (bindsArgs) {
            alwaysValid.eq(jedd.internal.Jedd.v().falseBDD());
            return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                       new jedd.PhysicalDomain[] { ST.v() },
                                                       "return alwaysValid; at BDDCflowStack.jedd:207,12-18",
                                                       alwaysValid);
        }
        if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(mustCflow),
                                          jedd.internal.Jedd.v().trueBDD()))
            mustCflow.eq(mustCflow());
        alwaysValid.eq(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(mustCflow),
                                                   isValids,
                                                   new jedd.PhysicalDomain[] { ST.v() }));
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                                   new jedd.PhysicalDomain[] { ST.v() },
                                                   "return alwaysValid; at BDDCflowStack.jedd:211,8-14",
                                                   alwaysValid);
    }
    
    public Iterator alwaysValid() {
        debug("Computing alwaysValid");
        Iterator ret =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("computeAlwaysValid().iterator() at BDDCflowStack.jedd:219,44" +
                                               "-52"),
                                              computeAlwaysValid()).iterator();
        debug("Done computing alwaysValid");
        return ret;
    }
    
    final jedd.internal.RelationContainer unnecessaryShadows =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                          new jedd.PhysicalDomain[] { V1.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_shadow> unnecessaryShadows " +
                                           "= jedd.internal.Jedd.v().falseBDD() at BDDCflowStack.jedd:22" +
                                           "4,4-14"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public Iterator unnecessaryShadows() {
        debug("Computing unnecessaryShadows");
        final jedd.internal.RelationContainer interestingIsValids =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_stmt.v() },
                                              new jedd.PhysicalDomain[] { ST.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdd" +
                                               "domains.ST> interestingIsValids = isValids; at BDDCflowStack" +
                                               ".jedd:233,17-36"),
                                              isValids);
        interestingIsValids.eqMinus(computeAlwaysValid());
        interestingIsValids.eqMinus(computeNeverValid());
        if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(mayCflow),
                                          jedd.internal.Jedd.v().trueBDD()))
            mayCflow.eq(mayCflow());
        final jedd.internal.RelationContainer necessaryShadows =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                              new jedd.PhysicalDomain[] { V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_shadow:soot.jimple.paddle.b" +
                                               "dddomains.V1> necessaryShadows = jedd.internal.Jedd.v().comp" +
                                               "ose(jedd.internal.Jedd.v().read(mayCflow), interestingIsVali" +
                                               "ds, new jedd.PhysicalDomain[...]); at BDDCflowStack.jedd:237" +
                                               ",19-35"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(mayCflow),
                                                                             interestingIsValids,
                                                                             new jedd.PhysicalDomain[] { ST.v() }));
        if (!bindsArgs) {
            necessaryShadows.eqMinus(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(mustCflow),
                                                                    pushes,
                                                                    new jedd.PhysicalDomain[] { ST.v() }));
        }
        unnecessaryShadows.eq(jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(shadows),
                                                           necessaryShadows));
        Iterator ret =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_shadow.v() },
                                              new jedd.PhysicalDomain[] { V1.v() },
                                              ("unnecessaryShadows.iterator() at BDDCflowStack.jedd:242,23-4" +
                                               "1"),
                                              unnecessaryShadows).iterator();
        debug("Done computing unnecessaryShadows");
        return ret;
    }
}
