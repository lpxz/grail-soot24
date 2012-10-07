package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rvarc_var_objc_obj_srcm_stmt_kind_tgtmIter extends Rvarc_var_objc_obj_srcm_stmt_kind_tgtm {
    protected Iterator r;
    
    public Rvarc_var_objc_obj_srcm_stmt_kind_tgtmIter(Iterator r,
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
                                 (VarNode)
                                   r.next(),
                                 (Context)
                                   r.next(),
                                 (AllocNode)
                                   r.next(),
                                 (SootMethod)
                                   r.next(),
                                 (Unit)
                                   r.next(),
                                 (Kind)
                                   r.next(),
                                 (SootMethod)
                                   r.next());
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1, soot.jimple.padd" +
                                               "le.bdddomains.A_srcm:soot.jimple.paddle.bdddomains.MS, soot." +
                                               "jimple.paddle.bdddomains.A_stmt:soot.jimple.paddle.bdddomain" +
                                               "s.ST, soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddl" +
                                               "e.bdddomains.KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.j" +
                                               "imple.paddle.bdddomains.MT> ret = jedd.internal.Jedd.v().fal" +
                                               "seBDD(); at Rvarc_var_objc_obj_srcm_stmt_kind_tgtmIter.jedd:" +
                                               "46,96-99"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next(), r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                       new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                   ("return ret; at Rvarc_var_objc_obj_srcm_stmt_kind_tgtmIter.je" +
                                                    "dd:50,8-14"),
                                                   ret);
    }
    
    public boolean hasNext() {
        return r.hasNext();
    }
}
