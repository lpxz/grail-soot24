package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rctxt_methodBDD extends Rctxt_method {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                          new PhysicalDomain[] { C1.v(), MS.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.pa" +
                                           "ddle.bdddomains.C1, soot.jimple.paddle.bdddomains.A_method:s" +
                                           "oot.jimple.paddle.bdddomains.MS> bdd at Rctxt_methodBDD.jedd" +
                                           ":31,12-36"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rctxt_methodBDD(final jedd.internal.RelationContainer bdd,
                           String name,
                           PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                                new PhysicalDomain[] { C1.v(), MS.v() },
                                                "add(bdd) at Rctxt_methodBDD.jedd:33,104-107",
                                                bdd));
    }
    
    public Rctxt_methodBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                                new PhysicalDomain[] { C1.v(), MS.v() },
                                                "add(bdd) at Rctxt_methodBDD.jedd:34,77-80",
                                                bdd));
    }
    
    Rctxt_methodBDD(String name,
                    PaddleQueue q) {
        super(name,
              q);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
    }
    
    public Iterator iterator() {
        ;
        return new Iterator() {
            private Iterator it;
            
            public boolean hasNext() {
                if (it !=
                      null &&
                      it.hasNext())
                    return true;
                if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                                   jedd.internal.Jedd.v().falseBDD()))
                    return true;
                return false;
            }
            
            public Object next() {
                if (it ==
                      null ||
                      !it.hasNext()) {
                    it =
                      new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                                          new PhysicalDomain[] { C1.v(), MS.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rctxt_methodBDD.jed" +
                                                           "d:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_ctxt.v(), A_method.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((Context)
                                   components[0],
                                 (SootMethod)
                                   components[1]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> ret = bdd; at Rctxt_methodBDD.jedd:" +
                                               "56,33-36"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                                   new PhysicalDomain[] { C1.v(), MS.v() },
                                                   "return ret; at Rctxt_methodBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
