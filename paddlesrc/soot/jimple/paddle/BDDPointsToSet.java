package soot.jimple.paddle;

import soot.*;
import java.util.*;
import soot.jimple.paddle.bdddomains.*;
import jedd.*;

public class BDDPointsToSet extends PointsToSetReadOnly {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { CH1.v(), H1.v() },
                                          ("private final <soot.jimple.paddle.bdddomains.A_objc, soot.ji" +
                                           "mple.paddle.bdddomains.A_obj:soot.jimple.paddle.bdddomains.H" +
                                           "1> bdd at BDDPointsToSet.jedd:30,18-36"));
    
    public BDDPointsToSet(final jedd.internal.RelationContainer bdd) {
        super(null);
        this.bdd.eq(bdd);
    }
    
    public boolean isEmpty() {
        return jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                             jedd.internal.Jedd.v().falseBDD());
    }
    
    public boolean hasNonEmptyIntersection(PointsToSet other) {
        BDDPointsToSet o =
          (BDDPointsToSet)
            other;
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(bdd),
                                                                                                           o.bdd)),
                                              jedd.internal.Jedd.v().falseBDD());
    }
    
    public boolean forall(P2SetVisitor v) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v() },
                                              new PhysicalDomain[] { H1.v(), CH1.v() },
                                              ("bdd.iterator(new jedd.Attribute[...]) at BDDPointsToSet.jedd" +
                                               ":44,22-25"),
                                              bdd).iterator(new Attribute[] { A_objc.v(), A_obj.v() });
        while (it.hasNext()) {
            Object[] item =
              (Object[])
                it.next();
            v.visit(ContextAllocNode.make((Context)
                                            item[0],
                                          (AllocNode)
                                            item[1]));
        }
        return v.getReturnValue();
    }
    
    public boolean contains(ContextAllocNode n) {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().falseBDD()),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().literal(new Object[] { n.obj(), n.ctxt() },
                                                                                                                                     new Attribute[] { A_obj.v(), A_objc.v() },
                                                                                                                                     new PhysicalDomain[] { H1.v(), CH1.v() })),
                                                                          bdd,
                                                                          new PhysicalDomain[] { H1.v(), CH1.v() }));
    }
    
    public jedd.internal.RelationContainer bdd() {
        return new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v() },
                                                   new PhysicalDomain[] { H1.v(), CH1.v() },
                                                   "return bdd; at BDDPointsToSet.jedd:59,8-14",
                                                   bdd);
    }
}
