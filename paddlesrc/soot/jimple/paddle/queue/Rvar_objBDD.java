package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvar_objBDD extends Rvar_obj {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                          new PhysicalDomain[] { V1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_obj:soot." +
                                           "jimple.paddle.bdddomains.H1> bdd at Rvar_objBDD.jedd:31,12-3" +
                                           "2"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rvar_objBDD(final jedd.internal.RelationContainer bdd,
                       String name,
                       PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                new PhysicalDomain[] { V1.v(), H1.v() },
                                                "add(bdd) at Rvar_objBDD.jedd:33,96-99",
                                                bdd));
    }
    
    public Rvar_objBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                new PhysicalDomain[] { V1.v(), H1.v() },
                                                "add(bdd) at Rvar_objBDD.jedd:34,69-72",
                                                bdd));
    }
    
    Rvar_objBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                          new PhysicalDomain[] { V1.v(), H1.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rvar_objBDD.jedd:46" +
                                                           ",25-28"),
                                                          bdd).iterator(new Attribute[] { A_var.v(), A_obj.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0],
                                 (AllocNode)
                                   components[1]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                              new PhysicalDomain[] { V1.v(), H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple.p" +
                                               "addle.bdddomains.H1> ret = bdd; at Rvar_objBDD.jedd:56,29-32"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                   new PhysicalDomain[] { V1.v(), H1.v() },
                                                   "return ret; at Rvar_objBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
