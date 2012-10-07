package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import soot.*;
import java.util.*;

public abstract class BDDVirtualContextManager extends AbsVirtualContextManager {
    BDDVirtualContextManager(Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in,
                             Qsrcc_srcm_stmt_kind_tgtc_tgtm out,
                             Qobjc_obj_varc_var thisOut,
                             NodeFactory gnf) {
        super(in,
              out,
              thisOut,
              gnf);
    }
    
    public void newMethods(final jedd.internal.RelationContainer methods) {
        for (Iterator mIt =
               new jedd.internal.RelationContainer(new jedd.Attribute[] { A_tgtm.v() },
                                                   new jedd.PhysicalDomain[] { MT.v() },
                                                   "methods.iterator() at BDDVirtualContextManager.jedd:36,28-35",
                                                   methods).iterator();
             mIt.hasNext();
             ) {
            final SootMethod m =
              (SootMethod)
                mIt.next();
            VarNode thisNode =
              (VarNode)
                new MethodNodeFactory(m,
                                      gnf).caseThis();
            thisVar.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { m, thisNode },
                                                           new jedd.Attribute[] { A_method.v(), A_var.v() },
                                                           new jedd.PhysicalDomain[] { MT.v(), V1.v() }));
        }
    }
    
    private final jedd.internal.RelationContainer thisVar =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_var.v() },
                                          new jedd.PhysicalDomain[] { MT.v(), V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method, soot.jimple" +
                                           ".paddle.bdddomains.A_var> thisVar = jedd.internal.Jedd.v().f" +
                                           "alseBDD() at BDDVirtualContextManager.jedd:42,12-29"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public jedd.internal.RelationContainer thisVar() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_method.v() },
                                                   new jedd.PhysicalDomain[] { V1.v(), MT.v() },
                                                   "return thisVar; at BDDVirtualContextManager.jedd:44,8-14",
                                                   thisVar);
    }
}
