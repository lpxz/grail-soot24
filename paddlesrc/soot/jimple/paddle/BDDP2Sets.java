package soot.jimple.paddle;

import soot.*;
import soot.jimple.paddle.queue.*;
import java.util.*;
import soot.jimple.paddle.bdddomains.*;

public class BDDP2Sets extends AbsP2Sets {
    PropBDD prop;
    
    public BDDP2Sets(PropBDD prop) {
        super();
        this.prop =
          prop;
    }
    
    public PointsToSetReadOnly get(Context ctxt,
                                   VarNode v) {
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDP2Sets.jedd" +
                                                                       ":39,15-18"),
                                                                      jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(prop.pt),
                                                                                                                                    jedd.internal.Jedd.v().literal(new Object[] { ctxt, v },
                                                                                                                                                                   new jedd.Attribute[] { A_varc.v(), A_var.v() },
                                                                                                                                                                   new jedd.PhysicalDomain[] { C2.v(), V2.v() }),
                                                                                                                                    new jedd.PhysicalDomain[] { C2.v(), V2.v() }),
                                                                                                     new jedd.PhysicalDomain[] { H2.v(), CH2.v() },
                                                                                                     new jedd.PhysicalDomain[] { H1.v(), CH1.v() })));
    }
    
    public PointsToSetReadOnly get(Context ctxt,
                                   AllocDotField adf) {
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDP2Sets.jedd" +
                                                                       ":43,15-18"),
                                                                      jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(prop.fieldPt),
                                                                                                                                    jedd.internal.Jedd.v().literal(new Object[] { ctxt, adf.base(), adf.field() },
                                                                                                                                                                   new jedd.Attribute[] { A_basec.v(), A_base.v(), A_fld.v() },
                                                                                                                                                                   new jedd.PhysicalDomain[] { CH2.v(), H1.v(), FD.v() }),
                                                                                                                                    new jedd.PhysicalDomain[] { CH2.v(), H1.v(), FD.v() }),
                                                                                                     new jedd.PhysicalDomain[] { H2.v() },
                                                                                                     new jedd.PhysicalDomain[] { H1.v() })));
    }
    
    public PointsToSetInternal make(Context c,
                                    VarNode v) {
        throw new RuntimeException("Not implemented");
    }
    
    public PointsToSetInternal make(Context c,
                                    AllocDotField adf) {
        throw new RuntimeException("Not implemented");
    }
    
    public Rvarc_var_objc_obj getReader(VarNode vn) {
        Rvarc_var_objc_objBDD ret =
          new Rvarc_var_objc_objBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                                        new jedd.PhysicalDomain[] { V1.v(), H1.v(), C1.v(), CH1.v() },
                                                                        ("new soot.jimple.paddle.queue.Rvarc_var_objc_objBDD(...) at B" +
                                                                         "DDP2Sets.jedd:55,36-39"),
                                                                        jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(prop.pt,
                                                                                                                                                                                              new jedd.PhysicalDomain[] { H2.v(), CH2.v(), C2.v() },
                                                                                                                                                                                              new jedd.PhysicalDomain[] { H1.v(), CH1.v(), C1.v() })),
                                                                                                                                   jedd.internal.Jedd.v().literal(new Object[] { vn },
                                                                                                                                                                  new jedd.Attribute[] { A_var.v() },
                                                                                                                                                                  new jedd.PhysicalDomain[] { V2.v() }),
                                                                                                                                   new jedd.PhysicalDomain[] { V2.v() }),
                                                                                                       new jedd.PhysicalDomain[] { V2.v() },
                                                                                                       new jedd.PhysicalDomain[] { V1.v() })),
                                    "getReader",
                                    null);
        return ret;
    }
    
    public Rvarc_var_objc_obj getReader() {
        return new Rvarc_var_objc_objBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                             new jedd.PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                                             ("new soot.jimple.paddle.queue.Rvarc_var_objc_objBDD(...) at B" +
                                                                              "DDP2Sets.jedd:61,15-18"),
                                                                             jedd.internal.Jedd.v().replace(prop.pt,
                                                                                                            new jedd.PhysicalDomain[] { V2.v(), H2.v(), CH2.v(), C2.v() },
                                                                                                            new jedd.PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() })));
    }
    
    public Rbasec_base_fld_objc_obj fieldPt() {
        return new Rbasec_base_fld_objc_objBDD(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                                                   new jedd.PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                                                   ("new soot.jimple.paddle.queue.Rbasec_base_fld_objc_objBDD(..." +
                                                                                    ") at BDDP2Sets.jedd:64,15-18"),
                                                                                   jedd.internal.Jedd.v().replace(prop.fieldPt,
                                                                                                                  new jedd.PhysicalDomain[] { CH2.v(), CH1.v() },
                                                                                                                  new jedd.PhysicalDomain[] { CH1.v(), CH2.v() })));
    }
}
