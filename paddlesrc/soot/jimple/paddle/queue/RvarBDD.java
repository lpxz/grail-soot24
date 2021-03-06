package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class RvarBDD extends Rvar {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                          new PhysicalDomain[] { V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var:soot.jimple.pad" +
                                           "dle.bdddomains.V1> bdd at RvarBDD.jedd:31,12-22"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public RvarBDD(final jedd.internal.RelationContainer bdd,
                   String name,
                   PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                                new PhysicalDomain[] { V1.v() },
                                                "add(bdd) at RvarBDD.jedd:33,82-85",
                                                bdd));
    }
    
    public RvarBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                                new PhysicalDomain[] { V1.v() },
                                                "add(bdd) at RvarBDD.jedd:34,55-58",
                                                bdd));
    }
    
    RvarBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                                          new PhysicalDomain[] { V1.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at RvarBDD.jedd:46,25-" +
                                                           "28"),
                                                          bdd).iterator(new Attribute[] { A_var.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                              new PhysicalDomain[] { V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1> ret = bdd; at RvarBDD.jedd:56,19-22"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                                   new PhysicalDomain[] { V1.v() },
                                                   "return ret; at RvarBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
