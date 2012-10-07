package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrc_dst_fldBDD extends Rsrc_dst_fld {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v(), A_fld.v() },
                                          new PhysicalDomain[] { V1.v(), V2.v(), FD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_src:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dst:soot." +
                                           "jimple.paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A" +
                                           "_fld:soot.jimple.paddle.bdddomains.FD> bdd at Rsrc_dst_fldBD" +
                                           "D.jedd:31,12-42"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rsrc_dst_fldBDD(final jedd.internal.RelationContainer bdd,
                           String name,
                           PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                                "add(bdd) at Rsrc_dst_fldBDD.jedd:33,110-113",
                                                bdd));
    }
    
    public Rsrc_dst_fldBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                                "add(bdd) at Rsrc_dst_fldBDD.jedd:34,83-86",
                                                bdd));
    }
    
    Rsrc_dst_fldBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                                          new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rsrc_dst_fldBDD.jed" +
                                                           "d:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_src.v(), A_dst.v(), A_fld.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0],
                                 (VarNode)
                                   components[1],
                                 (PaddleField)
                                   components[2]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v(), A_fld.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v(), FD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dst:soot.jimple.p" +
                                               "addle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_fld:soo" +
                                               "t.jimple.paddle.bdddomains.FD> ret = bdd; at Rsrc_dst_fldBDD" +
                                               ".jedd:56,39-42"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                                   "return ret; at Rsrc_dst_fldBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
