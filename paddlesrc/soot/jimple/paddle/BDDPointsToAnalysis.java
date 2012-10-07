package soot.jimple.paddle;

import soot.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class BDDPointsToAnalysis extends AbsPointsToAnalysis {
    public BDDPointsToAnalysis(AbsP2Sets p2sets) {
        super(p2sets);
        this.pt.eq(p2sets.getReader().get());
        this.fieldPt.eq(p2sets.fieldPt().get());
    }
    
    private final jedd.internal.RelationContainer pt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj> pt at BDDPointsToAnal" +
                                           "ysis.jedd:37,12-42"));
    
    private final jedd.internal.RelationContainer fieldPt =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { CH1.v(), H1.v(), FD.v(), CH2.v(), H2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_basec, soot.jimple." +
                                           "paddle.bdddomains.A_base, soot.jimple.paddle.bdddomains.A_fl" +
                                           "d, soot.jimple.paddle.bdddomains.A_objc, soot.jimple.paddle." +
                                           "bdddomains.A_obj> fieldPt at BDDPointsToAnalysis.jedd:38,12-" +
                                           "51"));
    
    public PointsToSet reachingObjects(Local l) {
        if (local(l) ==
              null)
            return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] {  },
                                                                          new jedd.PhysicalDomain[] {  },
                                                                          ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                           "lysis.jedd:41,36-39"),
                                                                          jedd.internal.Jedd.v().falseBDD()));
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                       "lysis.jedd:42,15-18"),
                                                                      jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(pt,
                                                                                                                                                                new jedd.PhysicalDomain[] { C1.v() })),
                                                                                                     jedd.internal.Jedd.v().literal(new Object[] { local(l) },
                                                                                                                                    new jedd.Attribute[] { A_var.v() },
                                                                                                                                    new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                     new jedd.PhysicalDomain[] { V1.v() })));
    }
    
    public PointsToSet reachingObjects(Context c,
                                       Local l) {
        if (local(l) ==
              null)
            return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] {  },
                                                                          new jedd.PhysicalDomain[] {  },
                                                                          ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                           "lysis.jedd:45,36-39"),
                                                                          jedd.internal.Jedd.v().falseBDD()));
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                       "lysis.jedd:46,15-18"),
                                                                      jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(pt),
                                                                                                     jedd.internal.Jedd.v().literal(new Object[] { local(l), c },
                                                                                                                                    new jedd.Attribute[] { A_var.v(), A_varc.v() },
                                                                                                                                    new jedd.PhysicalDomain[] { V1.v(), C1.v() }),
                                                                                                     new jedd.PhysicalDomain[] { V1.v(), C1.v() })));
    }
    
    public PointsToSet reachingObjects(SootField f) {
        if (field(f) ==
              null)
            return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] {  },
                                                                          new jedd.PhysicalDomain[] {  },
                                                                          ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                           "lysis.jedd:50,36-39"),
                                                                          jedd.internal.Jedd.v().falseBDD()));
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                       "lysis.jedd:51,15-18"),
                                                                      jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(pt,
                                                                                                                                                                new jedd.PhysicalDomain[] { C1.v() })),
                                                                                                     jedd.internal.Jedd.v().literal(new Object[] { field(f) },
                                                                                                                                    new jedd.Attribute[] { A_var.v() },
                                                                                                                                    new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                     new jedd.PhysicalDomain[] { V1.v() })));
    }
    
    public PointsToSet reachingObjects(PointsToSet s,
                                       SootField f) {
        BDDPointsToSet bdds =
          (BDDPointsToSet)
            s;
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                       "lysis.jedd:55,15-18"),
                                                                      jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(bdds.bdd()),
                                                                                                                                                                                            jedd.internal.Jedd.v().literal(new Object[] { f },
                                                                                                                                                                                                                           new jedd.Attribute[] { A_fld.v() },
                                                                                                                                                                                                                           new jedd.PhysicalDomain[] { FD.v() }),
                                                                                                                                                                                            new jedd.PhysicalDomain[] {  })),
                                                                                                                                    fieldPt,
                                                                                                                                    new jedd.PhysicalDomain[] { CH1.v(), H1.v(), FD.v() }),
                                                                                                     new jedd.PhysicalDomain[] { H2.v(), CH2.v() },
                                                                                                     new jedd.PhysicalDomain[] { H1.v(), CH1.v() })));
    }
    
    public PointsToSet reachingObjects(Local l,
                                       SootField f) {
        return reachingObjects(reachingObjects(l),
                               f);
    }
    
    public PointsToSet reachingObjects(Context c,
                                       Local l,
                                       SootField f) {
        return reachingObjects(reachingObjects(c,
                                               l),
                               f);
    }
    
    public PointsToSet reachingObjectsOfArrayElement(PointsToSet s) {
        BDDPointsToSet bdds =
          (BDDPointsToSet)
            s;
        return new BDDPointsToSet(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_objc.v() },
                                                                      new jedd.PhysicalDomain[] { H1.v(), CH1.v() },
                                                                      ("new soot.jimple.paddle.BDDPointsToSet(...) at BDDPointsToAna" +
                                                                       "lysis.jedd:67,15-18"),
                                                                      jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(bdds.bdd()),
                                                                                                                                                                                            jedd.internal.Jedd.v().literal(new Object[] { ArrayElement.v() },
                                                                                                                                                                                                                           new jedd.Attribute[] { A_fld.v() },
                                                                                                                                                                                                                           new jedd.PhysicalDomain[] { FD.v() }),
                                                                                                                                                                                            new jedd.PhysicalDomain[] {  })),
                                                                                                                                    fieldPt,
                                                                                                                                    new jedd.PhysicalDomain[] { CH1.v(), H1.v(), FD.v() }),
                                                                                                     new jedd.PhysicalDomain[] { H2.v(), CH2.v() },
                                                                                                     new jedd.PhysicalDomain[] { H1.v(), CH1.v() })));
    }
}
