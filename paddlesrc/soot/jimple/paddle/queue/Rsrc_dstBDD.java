package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrc_dstBDD extends Rsrc_dst {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                          new PhysicalDomain[] { V1.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_src:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dst:soot." +
                                           "jimple.paddle.bdddomains.V2> bdd at Rsrc_dstBDD.jedd:31,12-3" +
                                           "2"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rsrc_dstBDD(final jedd.internal.RelationContainer bdd,
                       String name,
                       PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { V1.v(), V2.v() },
                                                "add(bdd) at Rsrc_dstBDD.jedd:33,96-99",
                                                bdd));
    }
    
    public Rsrc_dstBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { V1.v(), V2.v() },
                                                "add(bdd) at Rsrc_dstBDD.jedd:34,69-72",
                                                bdd));
    }
    
    Rsrc_dstBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                          new PhysicalDomain[] { V1.v(), V2.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rsrc_dstBDD.jedd:46" +
                                                           ",25-28"),
                                                          bdd).iterator(new Attribute[] { A_src.v(), A_dst.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0],
                                 (VarNode)
                                   components[1]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dst:soot.jimple.p" +
                                               "addle.bdddomains.V2> ret = bdd; at Rsrc_dstBDD.jedd:56,29-32"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { V1.v(), V2.v() },
                                                   "return ret; at Rsrc_dstBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
