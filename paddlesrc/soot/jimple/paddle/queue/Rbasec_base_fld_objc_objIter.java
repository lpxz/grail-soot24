package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rbasec_base_fld_objc_objIter extends Rbasec_base_fld_objc_obj {
    protected Iterator r;
    
    public Rbasec_base_fld_objc_objIter(Iterator r,
                                        String name,
                                        PaddleQueue q) {
        super(name,
              q);
        this.r =
          r;
    }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                boolean ret =
                  r.hasNext();
                return ret;
            }
            
            public Object next() {
                return new Tuple((Context)
                                   r.next(),
                                 (AllocNode)
                                   r.next(),
                                 (PaddleField)
                                   r.next(),
                                 (Context)
                                   r.next(),
                                 (AllocNode)
                                   r.next());
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
                                               " = jedd.internal.Jedd.v().falseBDD(); at Rbasec_base_fld_obj" +
                                               "c_objIter.jedd:46,65-68"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                                       new PhysicalDomain[] { CH1.v(), H1.v(), FD.v(), CH2.v(), H2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                   new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                   "return ret; at Rbasec_base_fld_objc_objIter.jedd:50,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return r.hasNext();
    }
}
