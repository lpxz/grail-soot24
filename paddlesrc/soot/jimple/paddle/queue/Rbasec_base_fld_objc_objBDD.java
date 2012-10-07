package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rbasec_base_fld_objc_objBDD extends Rbasec_base_fld_objc_obj {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { CH1.v(), H1.v(), FD.v(), CH2.v(), H2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_basec:soot.jimple.p" +
                                           "addle.bdddomains.CH1, soot.jimple.paddle.bdddomains.A_base:s" +
                                           "oot.jimple.paddle.bdddomains.H1, soot.jimple.paddle.bdddomai" +
                                           "ns.A_fld:soot.jimple.paddle.bdddomains.FD, soot.jimple.paddl" +
                                           "e.bdddomains.A_objc:soot.jimple.paddle.bdddomains.CH2, soot." +
                                           "jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bdddomains" +
                                           ".H2> bdd at Rbasec_base_fld_objc_objBDD.jedd:31,12-68"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rbasec_base_fld_objc_objBDD(final jedd.internal.RelationContainer bdd,
                                       String name,
                                       PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                "add(bdd) at Rbasec_base_fld_objc_objBDD.jedd:33,148-151",
                                                bdd));
    }
    
    public Rbasec_base_fld_objc_objBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                "add(bdd) at Rbasec_base_fld_objc_objBDD.jedd:34,121-124",
                                                bdd));
    }
    
    Rbasec_base_fld_objc_objBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                          new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rbasec_base_fld_obj" +
                                                           "c_objBDD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((Context)
                                   components[0],
                                 (AllocNode)
                                   components[1],
                                 (PaddleField)
                                   components[2],
                                 (Context)
                                   components[3],
                                 (AllocNode)
                                   components[4]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { CH1.v(), H1.v(), FD.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_basec:soot.jimple.paddle.bd" +
                                               "ddomains.CH1, soot.jimple.paddle.bdddomains.A_base:soot.jimp" +
                                               "le.paddle.bdddomains.H1, soot.jimple.paddle.bdddomains.A_fld" +
                                               ":soot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddom" +
                                               "ains.A_objc:soot.jimple.paddle.bdddomains.CH2, soot.jimple.p" +
                                               "addle.bdddomains.A_obj:soot.jimple.paddle.bdddomains.H2> ret" +
                                               " = bdd; at Rbasec_base_fld_objc_objBDD.jedd:56,65-68"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                   new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                   "return ret; at Rbasec_base_fld_objc_objBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
