package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Robj_typeBDD extends Robj_type {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_type.v() },
                                          new PhysicalDomain[] { H1.v(), T1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj:soot.jimple.pad" +
                                           "dle.bdddomains.H1, soot.jimple.paddle.bdddomains.A_type:soot" +
                                           ".jimple.paddle.bdddomains.T1> bdd at Robj_typeBDD.jedd:31,12" +
                                           "-33"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Robj_typeBDD(final jedd.internal.RelationContainer bdd,
                        String name,
                        PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_obj.v() },
                                                new PhysicalDomain[] { T1.v(), H1.v() },
                                                "add(bdd) at Robj_typeBDD.jedd:33,98-101",
                                                bdd));
    }
    
    public Robj_typeBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_obj.v() },
                                                new PhysicalDomain[] { T1.v(), H1.v() },
                                                "add(bdd) at Robj_typeBDD.jedd:34,71-74",
                                                bdd));
    }
    
    Robj_typeBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_obj.v() },
                                                          new PhysicalDomain[] { T1.v(), H1.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Robj_typeBDD.jedd:4" +
                                                           "6,25-28"),
                                                          bdd).iterator(new Attribute[] { A_obj.v(), A_type.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((AllocNode)
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
          new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_type.v() },
                                              new PhysicalDomain[] { H1.v(), T1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1, soot.jimple.paddle.bdddomains.A_type:soot.jimple." +
                                               "paddle.bdddomains.T1> ret = bdd; at Robj_typeBDD.jedd:56,30-" +
                                               "33"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_obj.v() },
                                                   new PhysicalDomain[] { T1.v(), H1.v() },
                                                   "return ret; at Robj_typeBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
