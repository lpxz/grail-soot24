package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class RmethodBDD extends Rmethod {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                          new PhysicalDomain[] { MS.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method:soot.jimple." +
                                           "paddle.bdddomains.MS> bdd at RmethodBDD.jedd:31,12-25"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public RmethodBDD(final jedd.internal.RelationContainer bdd,
                      String name,
                      PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                                new PhysicalDomain[] { MS.v() },
                                                "add(bdd) at RmethodBDD.jedd:33,88-91",
                                                bdd));
    }
    
    public RmethodBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                                new PhysicalDomain[] { MS.v() },
                                                "add(bdd) at RmethodBDD.jedd:34,61-64",
                                                bdd));
    }
    
    RmethodBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                                          new PhysicalDomain[] { MS.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at RmethodBDD.jedd:46," +
                                                           "25-28"),
                                                          bdd).iterator(new Attribute[] { A_method.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((SootMethod)
                                   components[0]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                              new PhysicalDomain[] { MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_method:soot.jimple.paddle.b" +
                                               "dddomains.MS> ret = bdd; at RmethodBDD.jedd:56,22-25"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                                   new PhysicalDomain[] { MS.v() },
                                                   "return ret; at RmethodBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
