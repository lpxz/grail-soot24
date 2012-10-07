package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rvarc_var_objc_objIter extends Rvarc_var_objc_obj {
    protected Iterator r;
    
    public Rvarc_var_objc_objIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                                            this.r = r; }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { boolean ret = r.hasNext();
                                       return ret; }
            
            public Object next() {
                return new Tuple((Context) r.next(), (VarNode) r.next(), (Context) r.next(), (AllocNode) r.next()); }
            
            public void remove() { throw new UnsupportedOperationException(); }
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
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1> ret = jedd.inter" +
                                               "nal.Jedd.v().falseBDD(); at Rvarc_var_objc_objIter.jedd:46,5" +
                                               "2-55"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                                       new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                   new PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                   "return ret; at Rvarc_var_objc_objIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
