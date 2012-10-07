package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvarc_var_objc_objBDD extends Rvarc_var_objc_obj {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc:soot.jimple.pa" +
                                           "ddle.bdddomains.C1, soot.jimple.paddle.bdddomains.A_var:soot" +
                                           ".jimple.paddle.bdddomains.V1, soot.jimple.paddle.bdddomains." +
                                           "A_objc:soot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle" +
                                           ".bdddomains.A_obj:soot.jimple.paddle.bdddomains.H1> bdd at R" +
                                           "varc_var_objc_objBDD.jedd:31,12-55"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rvarc_var_objc_objBDD(final jedd.internal.RelationContainer bdd,
                                 String name,
                                 PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                new PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                "add(bdd) at Rvarc_var_objc_objBDD.jedd:33,129-132",
                                                bdd));
    }
    
    public Rvarc_var_objc_objBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                new PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                "add(bdd) at Rvarc_var_objc_objBDD.jedd:34,102-105",
                                                bdd));
    }
    
    Rvarc_var_objc_objBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                          new PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rvarc_var_objc_objB" +
                                                           "DD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((Context)
                                   components[0],
                                 (VarNode)
                                   components[1],
                                 (Context)
                                   components[2],
                                 (AllocNode)
                                   components[3]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1> ret = bdd; at Rv" +
                                               "arc_var_objc_objBDD.jedd:56,52-55"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                   new PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                   "return ret; at Rvarc_var_objc_objBDD.jedd:58,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
