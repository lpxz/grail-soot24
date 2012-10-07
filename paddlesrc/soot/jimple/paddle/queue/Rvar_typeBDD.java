package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvar_typeBDD extends Rvar_type {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_type.v() },
                                          new PhysicalDomain[] { V1.v(), T1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_type:soot" +
                                           ".jimple.paddle.bdddomains.T1> bdd at Rvar_typeBDD.jedd:31,12" +
                                           "-33"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rvar_typeBDD(final jedd.internal.RelationContainer bdd,
                        String name,
                        PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v() },
                                                new PhysicalDomain[] { T1.v(), V1.v() },
                                                "add(bdd) at Rvar_typeBDD.jedd:33,98-101",
                                                bdd));
    }
    
    public Rvar_typeBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v() },
                                                new PhysicalDomain[] { T1.v(), V1.v() },
                                                "add(bdd) at Rvar_typeBDD.jedd:34,71-74",
                                                bdd));
    }
    
    Rvar_typeBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v() },
                                                          new PhysicalDomain[] { T1.v(), V1.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rvar_typeBDD.jedd:4" +
                                                           "6,25-28"),
                                                          bdd).iterator(new Attribute[] { A_var.v(), A_type.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0],
                                 (Type)
                                   components[1]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_type.v() },
                                              new PhysicalDomain[] { V1.v(), T1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_type:soot.jimple." +
                                               "paddle.bdddomains.T1> ret = bdd; at Rvar_typeBDD.jedd:56,30-" +
                                               "33"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v() },
                                                   new PhysicalDomain[] { T1.v(), V1.v() },
                                                   "return ret; at Rvar_typeBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
