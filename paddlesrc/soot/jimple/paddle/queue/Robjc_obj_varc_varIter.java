package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Robjc_obj_varc_varIter extends Robjc_obj_varc_var {
    protected Iterator r;
    
    public Robjc_obj_varc_varIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                            this.r = r; }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { boolean ret = r.hasNext();
                                       return ret; }
            
            public Object next() {
                return new Tuple((Context) r.next(), (AllocNode) r.next(), (Context) r.next(), (VarNode) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                              new PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdd" +
                                               "domains.CH1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple" +
                                               ".paddle.bdddomains.H1, soot.jimple.paddle.bdddomains.A_varc:" +
                                               "soot.jimple.paddle.bdddomains.C1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_var:soot.jimple.paddle.bdddomains.V1> ret = jedd.inter" +
                                               "nal.Jedd.v().falseBDD(); at Robjc_obj_varc_varIter.jedd:46,5" +
                                               "2-55"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                                       new PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V1.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                   new PhysicalDomain[] { V1.v(), H1.v(), C1.v(), CH1.v() },
                                                   "return ret; at Robjc_obj_varc_varIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
