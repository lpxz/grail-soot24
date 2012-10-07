package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class BDDVirtualCalls extends AbsVirtualCalls {
    BDDVirtualCalls(Rvarc_var_objc_obj pt,
                    Rvar_srcm_stmt_dtp_signature_kind receivers,
                    Rvar_srcm_stmt_tgtm specials,
                    Qvarc_var_objc_obj_srcm_stmt_kind_tgtm out,
                    Qsrcc_srcm_stmt_kind_tgtc_tgtm statics,
                    AbsP2Sets p2sets) {
        super(pt,
              receivers,
              specials,
              out,
              statics,
              p2sets);
        for (Iterator clIt =
               Scene.v().getClasses().iterator();
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
                if (m.isAbstract())
                    continue;
                declaresMethod.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m.getDeclaringClass().getType(), m.getNumberedSubSignature(), m },
                                                                      new jedd.Attribute[] { A_type.v(), A_signature.v(), A_method.v() },
                                                                      new jedd.PhysicalDomain[] { T3.v(), SG.v(), MT.v() }));
            }
        }
        for (Iterator clsIt =
               Scene.v().dynamicClasses().iterator();
             clsIt.hasNext();
             ) {
            final SootClass cls =
              (SootClass)
                clsIt.next();
            for (Iterator clinitIt =
                   EntryPoints.v().clinitsOf(cls).iterator();
                 clinitIt.hasNext();
                 ) {
                final SootMethod clinit =
                  (SootMethod)
                    clinitIt.next();
                dynamicClinits.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { clinit },
                                                                      new jedd.Attribute[] { A_tgtm.v() },
                                                                      new jedd.PhysicalDomain[] { MT.v() }));
            }
        }
    }
    
    private int lastVarNode =
      1;
    
    private Iterator allocNodeIt =
      PaddleNumberers.v().allocNodeNumberer().iterator();
    
    private final jedd.internal.RelationContainer varNodes =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_type.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), T1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_type> var" +
                                           "Nodes at BDDVirtualCalls.jedd:62,12-30"));
    
    private final jedd.internal.RelationContainer allocNodes =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_type.v() },
                                          new jedd.PhysicalDomain[] { H1.v(), T2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj, soot.jimple.pa" +
                                           "ddle.bdddomains.A_type> allocNodes at BDDVirtualCalls.jedd:6" +
                                           "3,12-27"));
    
    private final jedd.internal.RelationContainer virtual =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v() },
                                          new jedd.PhysicalDomain[] { KD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_kind> virtual = jed" +
                                           "d.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.i" +
                                           "nternal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.inte" +
                                           "rnal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.interna" +
                                           "l.Jedd.v().literal(new java.lang.Object[...], new jedd.Attri" +
                                           "bute[...], new jedd.PhysicalDomain[...])), jedd.internal.Jed" +
                                           "d.v().literal(new java.lang.Object[...], new jedd.Attribute[" +
                                           "...], new jedd.PhysicalDomain[...]))), jedd.internal.Jedd.v(" +
                                           ").literal(new java.lang.Object[...], new jedd.Attribute[...]" +
                                           ", new jedd.PhysicalDomain[...]))), jedd.internal.Jedd.v().li" +
                                           "teral(new java.lang.Object[...], new jedd.Attribute[...], ne" +
                                           "w jedd.PhysicalDomain[...])) at BDDVirtualCalls.jedd:64,12-2" +
                                           "0"),
                                          jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { Kind.VIRTUAL },
                                                                                                                                                                                                                                                    new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                                                    new jedd.PhysicalDomain[] { KD.v() })),
                                                                                                                                                                                         jedd.internal.Jedd.v().literal(new Object[] { Kind.INTERFACE },
                                                                                                                                                                                                                        new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                                                                                        new jedd.PhysicalDomain[] { KD.v() }))),
                                                                                                                                jedd.internal.Jedd.v().literal(new Object[] { Kind.PRIVILEGED },
                                                                                                                                                               new jedd.Attribute[] { A_kind.v() },
                                                                                                                                                               new jedd.PhysicalDomain[] { KD.v() }))),
                                                                       jedd.internal.Jedd.v().literal(new Object[] { Kind.INVOKE_FINALIZE },
                                                                                                      new jedd.Attribute[] { A_kind.v() },
                                                                                                      new jedd.PhysicalDomain[] { KD.v() })));
    
    private final jedd.internal.RelationContainer threads =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_type.v() },
                                          new jedd.PhysicalDomain[] { T3.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_type> threads = jed" +
                                           "d.internal.Jedd.v().falseBDD() at BDDVirtualCalls.jedd:65,12" +
                                           "-20"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private void updateNodes() {
        final jedd.internal.RelationContainer newStringConstants =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { H1.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1, soot.jimple.paddle.bdddomains.A_tgtm:soot.jimple." +
                                               "paddle.bdddomains.MT> newStringConstants = jedd.internal.Jed" +
                                               "d.v().falseBDD(); at BDDVirtualCalls.jedd:67,24-42"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer newNonStringConstants =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                              new jedd.PhysicalDomain[] { H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1> newNonStringConstants = jedd.internal.Jedd.v().fa" +
                                               "lseBDD(); at BDDVirtualCalls.jedd:68,16-37"),
                                              jedd.internal.Jedd.v().falseBDD());
        for (;
             lastVarNode <=
               PaddleNumberers.v().varNodeNumberer().size();
             lastVarNode++) {
            VarNode vn =
              (VarNode)
                PaddleNumberers.v().varNodeNumberer().get(lastVarNode);
            varNodes.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { vn, vn.getType() },
                                                            new jedd.Attribute[] { A_var.v(), A_type.v() },
                                                            new jedd.PhysicalDomain[] { V1.v(), T1.v() }));
        }
        for (Iterator anIt =
               allocNodeIt;
             anIt.hasNext();
             ) {
            final AllocNode an =
              (AllocNode)
                anIt.next();
            if (an ==
                  null)
                continue;
            allocNodes.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { an, an.getType() },
                                                              new jedd.Attribute[] { A_obj.v(), A_type.v() },
                                                              new jedd.PhysicalDomain[] { H1.v(), T2.v() }));
            if (an instanceof StringConstantNode) {
                StringConstantNode scn =
                  (StringConstantNode)
                    an;
                String constant =
                  scn.getString();
                int length =
                  constant.length();
                if (length >
                      0 &&
                      constant.charAt(0) ==
                        '[') {
                    if (length >
                          1 &&
                          constant.charAt(1) ==
                            'L' &&
                          constant.charAt(length -
                                            1) ==
                            ';') {
                        constant =
                          constant.substring(2,
                                             length -
                                               1);
                    } else
                        constant =
                          null;
                }
                if (constant !=
                      null &&
                      Scene.v().containsClass(constant)) {
                    SootClass cls =
                      Scene.v().getSootClass(constant);
                    for (Iterator methodIt =
                           EntryPoints.v().clinitsOf(cls).iterator();
                         methodIt.hasNext();
                         ) {
                        final SootMethod method =
                          (SootMethod)
                            methodIt.next();
                        newStringConstants.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { an, method },
                                                                                  new jedd.Attribute[] { A_obj.v(), A_tgtm.v() },
                                                                                  new jedd.PhysicalDomain[] { H1.v(), MT.v() }));
                    }
                }
            } else {
                newNonStringConstants.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { an },
                                                                             new jedd.Attribute[] { A_obj.v() },
                                                                             new jedd.PhysicalDomain[] { H1.v() }));
            }
        }
        threads.eq(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(hier.subtypeRelation(),
                                                                                                             new jedd.PhysicalDomain[] { T2.v() },
                                                                                                             new jedd.PhysicalDomain[] { T3.v() })),
                                                  jedd.internal.Jedd.v().literal(new Object[] { clRunnable },
                                                                                 new jedd.Attribute[] { A_type.v() },
                                                                                 new jedd.PhysicalDomain[] { T1.v() }),
                                                  new jedd.PhysicalDomain[] { T1.v() }));
        stringConstants.eqUnion(newStringConstants);
        nonStringConstants.eqUnion(newNonStringConstants);
        newClinitTargets.eqUnion(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(newStringConstants),
                                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newNonStringConstants),
                                                                                          dynamicClinits,
                                                                                          new jedd.PhysicalDomain[] {  })));
    }
    
    protected final RefType clRunnable =
      RefType.v("java.lang.Runnable");
    
    private final jedd.internal.RelationContainer stringConstants =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { H1.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj, soot.jimple.pa" +
                                           "ddle.bdddomains.A_tgtm> stringConstants = jedd.internal.Jedd" +
                                           ".v().falseBDD() at BDDVirtualCalls.jedd:113,12-27"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer nonStringConstants =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                          new jedd.PhysicalDomain[] { H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj:soot.jimple.pad" +
                                           "dle.bdddomains.H1> nonStringConstants = jedd.internal.Jedd.v" +
                                           "().falseBDD() at BDDVirtualCalls.jedd:114,12-22"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer newClinitTargets =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { H1.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj, soot.jimple.pa" +
                                           "ddle.bdddomains.A_tgtm> newClinitTargets = jedd.internal.Jed" +
                                           "d.v().falseBDD() at BDDVirtualCalls.jedd:115,12-27"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer clinitTargets =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { H1.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj, soot.jimple.pa" +
                                           "ddle.bdddomains.A_tgtm> clinitTargets = jedd.internal.Jedd.v" +
                                           "().falseBDD() at BDDVirtualCalls.jedd:116,12-27"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer dynamicClinits =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_tgtm> dynamicClinit" +
                                           "s = jedd.internal.Jedd.v().falseBDD() at BDDVirtualCalls.jed" +
                                           "d:117,12-20"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final NumberedString sigClinit =
      Scene.v().getSubSigNumberer().findOrAdd("void <clinit>()");
    
    private final jedd.internal.RelationContainer targets =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_type.v(), A_signature.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { T2.v(), SG.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_type, soot.jimple.p" +
                                           "addle.bdddomains.A_signature, soot.jimple.paddle.bdddomains." +
                                           "A_method> targets = jedd.internal.Jedd.v().falseBDD() at BDD" +
                                           "VirtualCalls.jedd:121,12-43"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer declaresMethod =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_type.v(), A_signature.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { T3.v(), SG.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_type, soot.jimple.p" +
                                           "addle.bdddomains.A_signature, soot.jimple.paddle.bdddomains." +
                                           "A_method> declaresMethod = jedd.internal.Jedd.v().falseBDD()" +
                                           " at BDDVirtualCalls.jedd:122,12-43"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private BDDHierarchy hier =
      PaddleScene.v().BDDHierarchy();
    
    private final jedd.internal.RelationContainer newPt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj> newPt = jedd.internal" +
                                           ".Jedd.v().falseBDD() at BDDVirtualCalls.jedd:125,12-42"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allPt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj> allPt = jedd.internal" +
                                           ".Jedd.v().falseBDD() at BDDVirtualCalls.jedd:126,12-42"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allPtNoObjc =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_obj>" +
                                           " allPtNoObjc = jedd.internal.Jedd.v().falseBDD() at BDDVirtu" +
                                           "alCalls.jedd:127,12-34"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer newRcv =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), SG.v(), KD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_dtp, soot.jimple.paddle.bd" +
                                           "ddomains.A_signature, soot.jimple.paddle.bdddomains.A_kind> " +
                                           "newRcv = jedd.internal.Jedd.v().falseBDD() at BDDVirtualCall" +
                                           "s.jedd:128,12-63"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allRcv =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), SG.v(), KD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_dtp, soot.jimple.paddle.bd" +
                                           "ddomains.A_signature, soot.jimple.paddle.bdddomains.A_kind> " +
                                           "allRcv = jedd.internal.Jedd.v().falseBDD() at BDDVirtualCall" +
                                           "s.jedd:129,12-63"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer newSpc =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_tgtm> newSpc = jedd.intern" +
                                           "al.Jedd.v().falseBDD() at BDDVirtualCalls.jedd:130,12-43"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allSpc =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_tgtm> allSpc = jedd.intern" +
                                           "al.Jedd.v().falseBDD() at BDDVirtualCalls.jedd:131,12-43"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private boolean change;
    
    public boolean update() {
        change =
          false;
        updateNodes();
        newPt.eq(pt.get());
        allPt.eqUnion(newPt);
        allPtNoObjc.eqUnion(jedd.internal.Jedd.v().project(newPt,
                                                           new jedd.PhysicalDomain[] { CH1.v() }));
        newRcv.eq(receivers.get());
        allRcv.eqUnion(newRcv);
        newSpc.eq(specials.get());
        allSpc.eqUnion(newSpc);
        updateClinits();
        updateVirtuals();
        updateSpecials();
        return change;
    }
    
    private final jedd.internal.RelationContainer clinits =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_kind.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), KD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_kind> clinits at BDDVirtua" +
                                           "lCalls.jedd:158,12-43"));
    
    private final jedd.internal.RelationContainer tgtMethods =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_var.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_tgtm" +
                                           "> tgtMethods at BDDVirtualCalls.jedd:159,12-35"));
    
    private void updateClinits() {
        clinits.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newRcv,
                                                                                                               new jedd.PhysicalDomain[] { T1.v(), SG.v() })),
                                                    jedd.internal.Jedd.v().literal(new Object[] { Kind.CLINIT },
                                                                                   new jedd.Attribute[] { A_kind.v() },
                                                                                   new jedd.PhysicalDomain[] { KD.v() }),
                                                    new jedd.PhysicalDomain[] { KD.v() }));
        tgtMethods.eqUnion(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(allPt,
                                                                                                                                                                              new jedd.PhysicalDomain[] { CH1.v() })),
                                                                                                                   newClinitTargets,
                                                                                                                   new jedd.PhysicalDomain[] { H1.v() })),
                                                        jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newPt,
                                                                                                                                                  new jedd.PhysicalDomain[] { CH1.v() })),
                                                                                       clinitTargets,
                                                                                       new jedd.PhysicalDomain[] { H1.v() })));
        clinitTargets.eqUnion(newClinitTargets);
        newClinitTargets.eq(jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer newStatics =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> newStatics = jedd.internal.Jedd.v().join(jedd.interna" +
                                               "l.Jedd.v().read(jedd.internal.Jedd.v().compose(jedd.internal" +
                                               ".Jedd.v().read(tgtMethods), clinits, new jedd.PhysicalDomain" +
                                               "[...])), jedd.internal.Jedd.v().literal(new java.lang.Object" +
                                               "[...], new jedd.Attribute[...], new jedd.PhysicalDomain[...]" +
                                               "), new jedd.PhysicalDomain[...]); at BDDVirtualCalls.jedd:17" +
                                               "0,57-67"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(tgtMethods),
                                                                                                                                     clinits,
                                                                                                                                     new jedd.PhysicalDomain[] { V1.v() })),
                                                                          jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                                         new jedd.Attribute[] { A_tgtc.v() },
                                                                                                         new jedd.PhysicalDomain[] { C2.v() }),
                                                                          new jedd.PhysicalDomain[] {  }));
        statics.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                        new jedd.PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                        "statics.add(newStatics) at BDDVirtualCalls.jedd:173,8-15",
                                                        newStatics));
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newStatics),
                                           jedd.internal.Jedd.v().falseBDD()))
            change =
              true;
    }
    
    private final jedd.internal.RelationContainer resolvedSpecials =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj, soot.jimple.paddle.bd" +
                                           "ddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt, soot." +
                                           "jimple.paddle.bdddomains.A_tgtm> resolvedSpecials = jedd.int" +
                                           "ernal.Jedd.v().falseBDD() at BDDVirtualCalls.jedd:176,12-66"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private void updateSpecials() {
        final jedd.internal.RelationContainer newSpecials =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jimple.padd" +
                                               "le.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.MS, soot." +
                                               "jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdddomain" +
                                               "s.ST, soot.jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddl" +
                                               "e.bdddomains.MT> newSpecials = jedd.internal.Jedd.v().union(" +
                                               "jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd" +
                                               ".internal.Jedd.v().read(newPt), allSpc, new jedd.PhysicalDom" +
                                               "ain[...])), jedd.internal.Jedd.v().join(jedd.internal.Jedd.v" +
                                               "().read(allPt), newSpc, new jedd.PhysicalDomain[...])); at B" +
                                               "DDVirtualCalls.jedd:179,63-74"),
                                              jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newPt),
                                                                                                                                   allSpc,
                                                                                                                                   new jedd.PhysicalDomain[] { V1.v() })),
                                                                           jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(allPt),
                                                                                                       newSpc,
                                                                                                       new jedd.PhysicalDomain[] { V1.v() })));
        newSpecials.eqMinus(resolvedSpecials);
        resolvedSpecials.eqUnion(newSpecials);
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_varc.v(), A_objc.v(), A_stmt.v(), A_kind.v() },
                                                    new jedd.PhysicalDomain[] { V1.v(), MS.v(), MT.v(), H1.v(), C1.v(), CH1.v(), ST.v(), KD.v() },
                                                    ("out.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().r" +
                                                     "ead(newSpecials), jedd.internal.Jedd.v().literal(new java.la" +
                                                     "ng.Object[...], new jedd.Attribute[...], new jedd.PhysicalDo" +
                                                     "main[...]), new jedd.PhysicalDomain[...])) at BDDVirtualCall" +
                                                     "s.jedd:186,8-11"),
                                                    jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newSpecials),
                                                                                jedd.internal.Jedd.v().literal(new Object[] { Kind.SPECIAL },
                                                                                                               new jedd.Attribute[] { A_kind.v() },
                                                                                                               new jedd.PhysicalDomain[] { KD.v() }),
                                                                                new jedd.PhysicalDomain[] {  })));
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newSpecials),
                                           jedd.internal.Jedd.v().falseBDD()))
            change =
              true;
    }
    
    private final jedd.internal.RelationContainer callSiteTargets =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_type.v(), A_kind.v(), A_tgtm.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T2.v(), KD.v(), MT.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_type, soot.jimple.paddle.b" +
                                           "dddomains.A_kind, soot.jimple.paddle.bdddomains.A_tgtm> call" +
                                           "SiteTargets = jedd.internal.Jedd.v().falseBDD() at BDDVirtua" +
                                           "lCalls.jedd:190,12-59"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer rcvSigs =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_dtp.v(), A_signature.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), T1.v(), SG.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_dtp, soot.jimple.paddle.bdddomains.A_signa" +
                                           "ture> rcvSigs = jedd.internal.Jedd.v().falseBDD() at BDDVirt" +
                                           "ualCalls.jedd:191,12-39"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer threadRcvSigs =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_dtp.v(), A_signature.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), T1.v(), SG.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_dtp, soot.jimple.paddle.bdddomains.A_signa" +
                                           "ture> threadRcvSigs = jedd.internal.Jedd.v().falseBDD() at B" +
                                           "DDVirtualCalls.jedd:192,12-39"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer rcv =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), SG.v(), KD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_srcm, soot.jimple.paddle.bdddomains.A_stmt" +
                                           ", soot.jimple.paddle.bdddomains.A_dtp, soot.jimple.paddle.bd" +
                                           "ddomains.A_signature, soot.jimple.paddle.bdddomains.A_kind> " +
                                           "rcv = jedd.internal.Jedd.v().falseBDD() at BDDVirtualCalls.j" +
                                           "edd:193,12-63"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allVarCtxtPt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_type.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), T2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj, soot.jimple.paddle.bd" +
                                           "ddomains.A_type> allVarCtxtPt = jedd.internal.Jedd.v().false" +
                                           "BDD() at BDDVirtualCalls.jedd:194,12-50"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allPtTypes =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_type.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), T2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_type> allPtTypes = jedd.internal.Jedd.v()." +
                                           "falseBDD() at BDDVirtualCalls.jedd:195,12-27"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private void updateVirtuals() {
        final jedd.internal.RelationContainer newVirtRcv =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), SG.v(), KD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple." +
                                               "paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:s" +
                                               "oot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dtp:soot.jimple.paddle.bdddomains.T1, soot.jimple.paddl" +
                                               "e.bdddomains.A_signature:soot.jimple.paddle.bdddomains.SG, s" +
                                               "oot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdddo" +
                                               "mains.KD> newVirtRcv = jedd.internal.Jedd.v().join(jedd.inte" +
                                               "rnal.Jedd.v().read(newRcv), jedd.internal.Jedd.v().union(jed" +
                                               "d.internal.Jedd.v().read(virtual), jedd.internal.Jedd.v().li" +
                                               "teral(new java.lang.Object[...], new jedd.Attribute[...], ne" +
                                               "w jedd.PhysicalDomain[...])), new jedd.PhysicalDomain[...]);" +
                                               " at BDDVirtualCalls.jedd:197,60-70"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newRcv),
                                                                          jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(virtual),
                                                                                                       jedd.internal.Jedd.v().literal(new Object[] { Kind.THREAD },
                                                                                                                                      new jedd.Attribute[] { A_kind.v() },
                                                                                                                                      new jedd.PhysicalDomain[] { KD.v() })),
                                                                          new jedd.PhysicalDomain[] { KD.v() }));
        rcv.eqUnion(newVirtRcv);
        final jedd.internal.RelationContainer sigs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), T1.v(), SG.v(), KD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dtp:soot.jimple.p" +
                                               "addle.bdddomains.T1, soot.jimple.paddle.bdddomains.A_signatu" +
                                               "re:soot.jimple.paddle.bdddomains.SG, soot.jimple.paddle.bddd" +
                                               "omains.A_kind:soot.jimple.paddle.bdddomains.KD> sigs = jedd." +
                                               "internal.Jedd.v().project(newVirtRcv, new jedd.PhysicalDomai" +
                                               "n[...]); at BDDVirtualCalls.jedd:201,44-48"),
                                              jedd.internal.Jedd.v().project(newVirtRcv,
                                                                             new jedd.PhysicalDomain[] { MS.v(), ST.v() }));
        final jedd.internal.RelationContainer newRcvSigs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_dtp.v(), A_signature.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), T1.v(), SG.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dtp:soot.jimple.p" +
                                               "addle.bdddomains.T1, soot.jimple.paddle.bdddomains.A_signatu" +
                                               "re:soot.jimple.paddle.bdddomains.SG> newRcvSigs = jedd.inter" +
                                               "nal.Jedd.v().compose(jedd.internal.Jedd.v().read(sigs), virt" +
                                               "ual, new jedd.PhysicalDomain[...]); at BDDVirtualCalls.jedd:" +
                                               "202,36-46"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(sigs),
                                                                             virtual,
                                                                             new jedd.PhysicalDomain[] { KD.v() }));
        rcvSigs.eqUnion(newRcvSigs);
        final jedd.internal.RelationContainer newThreadRcvSigs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_dtp.v(), A_signature.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), T1.v(), SG.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dtp:soot.jimple.p" +
                                               "addle.bdddomains.T1, soot.jimple.paddle.bdddomains.A_signatu" +
                                               "re:soot.jimple.paddle.bdddomains.SG> newThreadRcvSigs = jedd" +
                                               ".internal.Jedd.v().compose(jedd.internal.Jedd.v().read(sigs)" +
                                               ", jedd.internal.Jedd.v().literal(new java.lang.Object[...], " +
                                               "new jedd.Attribute[...], new jedd.PhysicalDomain[...]), new " +
                                               "jedd.PhysicalDomain[...]); at BDDVirtualCalls.jedd:204,36-52"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(sigs),
                                                                             jedd.internal.Jedd.v().literal(new Object[] { Kind.THREAD },
                                                                                                            new jedd.Attribute[] { A_kind.v() },
                                                                                                            new jedd.PhysicalDomain[] { KD.v() }),
                                                                             new jedd.PhysicalDomain[] { KD.v() }));
        threadRcvSigs.eqUnion(newThreadRcvSigs);
        final jedd.internal.RelationContainer ptTypes =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_type.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), T2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_type:soot.jimple." +
                                               "paddle.bdddomains.T2> ptTypes = jedd.internal.Jedd.v().compo" +
                                               "se(jedd.internal.Jedd.v().read(allocNodes), jedd.internal.Je" +
                                               "dd.v().project(newPt, new jedd.PhysicalDomain[...]), new jed" +
                                               "d.PhysicalDomain[...]); at BDDVirtualCalls.jedd:209,24-31"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(allocNodes),
                                                                             jedd.internal.Jedd.v().project(newPt,
                                                                                                            new jedd.PhysicalDomain[] { C1.v(), CH1.v() }),
                                                                             new jedd.PhysicalDomain[] { H1.v() }));
        final jedd.internal.RelationContainer newTypes =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_type.v(), A_dtp.v(), A_signature.v() },
                                              new jedd.PhysicalDomain[] { T3.v(), T1.v(), SG.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_type:soot.jimple.paddle.bdd" +
                                               "domains.T3, soot.jimple.paddle.bdddomains.A_dtp:soot.jimple." +
                                               "paddle.bdddomains.T1, soot.jimple.paddle.bdddomains.A_signat" +
                                               "ure:soot.jimple.paddle.bdddomains.SG> newTypes = jedd.intern" +
                                               "al.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.interna" +
                                               "l.Jedd.v().replace(ptTypes, new jedd.PhysicalDomain[...], ne" +
                                               "w jedd.PhysicalDomain[...])), rcvSigs, new jedd.PhysicalDoma" +
                                               "in[...]); at BDDVirtualCalls.jedd:211,37-45"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(ptTypes,
                                                                                                                                        new jedd.PhysicalDomain[] { T2.v() },
                                                                                                                                        new jedd.PhysicalDomain[] { T3.v() })),
                                                                             rcvSigs,
                                                                             new jedd.PhysicalDomain[] { V1.v() }));
        newTypes.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(ptTypes),
                                                                                                                                               jedd.internal.Jedd.v().replace(threads,
                                                                                                                                                                              new jedd.PhysicalDomain[] { T3.v() },
                                                                                                                                                                              new jedd.PhysicalDomain[] { T2.v() }),
                                                                                                                                               new jedd.PhysicalDomain[] { T2.v() }),
                                                                                                                   new jedd.PhysicalDomain[] { T2.v() },
                                                                                                                   new jedd.PhysicalDomain[] { T3.v() })),
                                                        threadRcvSigs,
                                                        new jedd.PhysicalDomain[] { V1.v() }));
        allPtTypes.eqUnion(ptTypes);
        newTypes.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(allPtTypes,
                                                                                                                   new jedd.PhysicalDomain[] { T2.v() },
                                                                                                                   new jedd.PhysicalDomain[] { T3.v() })),
                                                        newRcvSigs,
                                                        new jedd.PhysicalDomain[] { V1.v() }));
        newTypes.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(allPtTypes,
                                                                                                                                                                           new jedd.PhysicalDomain[] { T2.v() },
                                                                                                                                                                           new jedd.PhysicalDomain[] { T3.v() })),
                                                                                                                threads,
                                                                                                                new jedd.PhysicalDomain[] { T3.v() })),
                                                        newThreadRcvSigs,
                                                        new jedd.PhysicalDomain[] { V1.v() }));
        hier.update();
        newTypes.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(newTypes),
                                                                                       hier.anySub(),
                                                                                       new jedd.PhysicalDomain[] { T3.v() }),
                                                        new jedd.PhysicalDomain[] { T2.v() },
                                                        new jedd.PhysicalDomain[] { T3.v() }));
        newTypes.eq(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newTypes),
                                                jedd.internal.Jedd.v().replace(hier.concrete(),
                                                                               new jedd.PhysicalDomain[] { T2.v() },
                                                                               new jedd.PhysicalDomain[] { T3.v() }),
                                                new jedd.PhysicalDomain[] { T3.v() }));
        final jedd.internal.RelationContainer typesToResolve =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_signature.v(), A_type.v() },
                                              new jedd.PhysicalDomain[] { SG.v(), T3.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_signature:soot.jimple.paddl" +
                                               "e.bdddomains.SG, soot.jimple.paddle.bdddomains.A_type:soot.j" +
                                               "imple.paddle.bdddomains.T3> typesToResolve = jedd.internal.J" +
                                               "edd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd" +
                                               ".v().project(newTypes, new jedd.PhysicalDomain[...])), jedd." +
                                               "internal.Jedd.v().project(jedd.internal.Jedd.v().replace(tar" +
                                               "gets, new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[" +
                                               "...]), new jedd.PhysicalDomain[...])); at BDDVirtualCalls.je" +
                                               "dd:229,30-44"),
                                              jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newTypes,
                                                                                                                                      new jedd.PhysicalDomain[] { T1.v() })),
                                                                           jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().replace(targets,
                                                                                                                                         new jedd.PhysicalDomain[] { T2.v() },
                                                                                                                                         new jedd.PhysicalDomain[] { T3.v() }),
                                                                                                          new jedd.PhysicalDomain[] { MT.v() })));
        final jedd.internal.RelationContainer toResolve =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_subt.v(), A_signature.v(), A_supt.v() },
                                              new jedd.PhysicalDomain[] { T2.v(), SG.v(), T3.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_subt:soot.jimple.paddle.bdd" +
                                               "domains.T2, soot.jimple.paddle.bdddomains.A_signature:soot.j" +
                                               "imple.paddle.bdddomains.SG, soot.jimple.paddle.bdddomains.A_" +
                                               "supt:soot.jimple.paddle.bdddomains.T3> toResolve = jedd.inte" +
                                               "rnal.Jedd.v().copy(typesToResolve, new jedd.PhysicalDomain[." +
                                               "..], new jedd.Attribute[...], ...); at BDDVirtualCalls.jedd:" +
                                               "232,38-47"),
                                              jedd.internal.Jedd.v().copy(typesToResolve,
                                                                          new jedd.PhysicalDomain[] { T3.v() },
                                                                          new jedd.Attribute[] { A_type.v() },
                                                                          new jedd.PhysicalDomain[] { T2.v() }));
        final jedd.internal.RelationContainer newTargets =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_type.v(), A_signature.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { T2.v(), SG.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_type:soot.jimple.paddle.bdd" +
                                               "domains.T2, soot.jimple.paddle.bdddomains.A_signature:soot.j" +
                                               "imple.paddle.bdddomains.SG, soot.jimple.paddle.bdddomains.A_" +
                                               "method:soot.jimple.paddle.bdddomains.MT> newTargets = jedd.i" +
                                               "nternal.Jedd.v().falseBDD(); at BDDVirtualCalls.jedd:234,40-" +
                                               "50"),
                                              jedd.internal.Jedd.v().falseBDD());
        do  {
            final jedd.internal.RelationContainer resolved =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_subt.v(), A_signature.v(), A_supt.v(), A_method.v() },
                                                  new jedd.PhysicalDomain[] { T2.v(), SG.v(), T3.v(), MT.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_subt:soot.jimple.paddle.bdd" +
                                                   "domains.T2, soot.jimple.paddle.bdddomains.A_signature:soot.j" +
                                                   "imple.paddle.bdddomains.SG, soot.jimple.paddle.bdddomains.A_" +
                                                   "supt:soot.jimple.paddle.bdddomains.T3, soot.jimple.paddle.bd" +
                                                   "ddomains.A_method:soot.jimple.paddle.bdddomains.MT> resolved" +
                                                   " = jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(t" +
                                                   "oResolve), declaresMethod, new jedd.PhysicalDomain[...]); at" +
                                                   " BDDVirtualCalls.jedd:239,52-60"),
                                                  jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(toResolve),
                                                                              declaresMethod,
                                                                              new jedd.PhysicalDomain[] { T3.v(), SG.v() }));
            toResolve.eqMinus(jedd.internal.Jedd.v().project(resolved,
                                                             new jedd.PhysicalDomain[] { MT.v() }));
            newTargets.eqUnion(jedd.internal.Jedd.v().project(resolved,
                                                              new jedd.PhysicalDomain[] { T3.v() }));
            toResolve.eq(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(toResolve,
                                                                                                                   new jedd.PhysicalDomain[] { T3.v() },
                                                                                                                   new jedd.PhysicalDomain[] { T1.v() })),
                                                        jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(hier.extend()),
                                                                                     hier.array()),
                                                        new jedd.PhysicalDomain[] { T1.v() }));
        }while(!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(toResolve),
                                              jedd.internal.Jedd.v().falseBDD())); 
        final jedd.internal.RelationContainer typedPt =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_type.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), T2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jimple.padd" +
                                               "le.bdddomains.A_type:soot.jimple.paddle.bdddomains.T2> typed" +
                                               "Pt = jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read" +
                                               "(allocNodes), newPt, new jedd.PhysicalDomain[...]); at BDDVi" +
                                               "rtualCalls.jedd:254,47-54"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(allocNodes),
                                                                          newPt,
                                                                          new jedd.PhysicalDomain[] { H1.v() }));
        typedPt.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(typedPt,
                                                                                                                  new jedd.PhysicalDomain[] { T2.v() },
                                                                                                                  new jedd.PhysicalDomain[] { T3.v() })),
                                                       hier.anySub(),
                                                       new jedd.PhysicalDomain[] { T3.v() }));
        final jedd.internal.RelationContainer varCtxtPt =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_dtp.v(), A_objc.v(), A_obj.v(), A_type.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), T1.v(), CH1.v(), H1.v(), T2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dtp:so" +
                                               "ot.jimple.paddle.bdddomains.T1, soot.jimple.paddle.bdddomain" +
                                               "s.A_objc:soot.jimple.paddle.bdddomains.CH1, soot.jimple.padd" +
                                               "le.bdddomains.A_obj:soot.jimple.paddle.bdddomains.H1, soot.j" +
                                               "imple.paddle.bdddomains.A_type:soot.jimple.paddle.bdddomains" +
                                               ".T2> varCtxtPt = jedd.internal.Jedd.v().join(jedd.internal.J" +
                                               "edd.v().read(typedPt), varNodes, new jedd.PhysicalDomain[..." +
                                               "]); at BDDVirtualCalls.jedd:258,54-63"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(typedPt),
                                                                          varNodes,
                                                                          new jedd.PhysicalDomain[] { V1.v() }));
        varCtxtPt.eq(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(varCtxtPt),
                                                 hier.subtypeRelation(),
                                                 new jedd.PhysicalDomain[] { T2.v(), T1.v() }));
        varCtxtPt.eq(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(varCtxtPt),
                                                 hier.concrete(),
                                                 new jedd.PhysicalDomain[] { T2.v() }));
        allVarCtxtPt.eqUnion(jedd.internal.Jedd.v().project(varCtxtPt,
                                                            new jedd.PhysicalDomain[] { T1.v() }));
        final jedd.internal.RelationContainer newCallSiteTargets =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_type.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), T2.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple." +
                                               "paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:s" +
                                               "oot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dtp:soot.jimple.paddle.bdddomains.T1, soot.jimple.paddl" +
                                               "e.bdddomains.A_type:soot.jimple.paddle.bdddomains.T2, soot.j" +
                                               "imple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdddomains" +
                                               ".KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle" +
                                               ".bdddomains.MT> newCallSiteTargets = jedd.internal.Jedd.v()." +
                                               "union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().com" +
                                               "pose(jedd.internal.Jedd.v().read(newVirtRcv), targets, new j" +
                                               "edd.PhysicalDomain[...])), jedd.internal.Jedd.v().compose(je" +
                                               "dd.internal.Jedd.v().read(rcv), newTargets, new jedd.Physica" +
                                               "lDomain[...])); at BDDVirtualCalls.jedd:271,63-81"),
                                              jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(newVirtRcv),
                                                                                                                                      targets,
                                                                                                                                      new jedd.PhysicalDomain[] { SG.v() })),
                                                                           jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(rcv),
                                                                                                          newTargets,
                                                                                                          new jedd.PhysicalDomain[] { SG.v() })));
        targets.eqUnion(newTargets);
        newCallSiteTargets.eq(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newCallSiteTargets),
                                                                                                                   hier.subtypeRelation(),
                                                                                                                   new jedd.PhysicalDomain[] { T2.v(), T1.v() })),
                                                           jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newCallSiteTargets),
                                                                                       jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                                                      new jedd.Attribute[] { A_dtp.v() },
                                                                                                                      new jedd.PhysicalDomain[] { T1.v() }),
                                                                                       new jedd.PhysicalDomain[] { T1.v() })));
        callSiteTargets.eqUnion(jedd.internal.Jedd.v().project(newCallSiteTargets,
                                                               new jedd.PhysicalDomain[] { T1.v() }));
        final jedd.internal.RelationContainer newVirtuals =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jimple.padd" +
                                               "le.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.MS, soot." +
                                               "jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdddomain" +
                                               "s.ST, soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddl" +
                                               "e.bdddomains.KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.j" +
                                               "imple.paddle.bdddomains.MT> newVirtuals = jedd.internal.Jedd" +
                                               ".v().project(jedd.internal.Jedd.v().join(jedd.internal.Jedd." +
                                               "v().read(jedd.internal.Jedd.v().project(varCtxtPt, new jedd." +
                                               "PhysicalDomain[...])), callSiteTargets, new jedd.PhysicalDom" +
                                               "ain[...]), new jedd.PhysicalDomain[...]); at BDDVirtualCalls" +
                                               ".jedd:284,71-82"),
                                              jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(varCtxtPt,
                                                                                                                                                                    new jedd.PhysicalDomain[] { T1.v() })),
                                                                                                         callSiteTargets,
                                                                                                         new jedd.PhysicalDomain[] { T2.v(), V1.v() }),
                                                                             new jedd.PhysicalDomain[] { T2.v() }));
        newVirtuals.eqUnion(jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(allVarCtxtPt),
                                                                                       jedd.internal.Jedd.v().project(newCallSiteTargets,
                                                                                                                      new jedd.PhysicalDomain[] { T1.v() }),
                                                                                       new jedd.PhysicalDomain[] { T2.v(), V1.v() }),
                                                           new jedd.PhysicalDomain[] { T2.v() }));
        out.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                    new jedd.PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                    "out.add(newVirtuals) at BDDVirtualCalls.jedd:292,8-11",
                                                    newVirtuals));
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newVirtuals),
                                           jedd.internal.Jedd.v().falseBDD()))
            change =
              true;
    }
}
