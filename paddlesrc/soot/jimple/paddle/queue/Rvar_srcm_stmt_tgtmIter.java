package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rvar_srcm_stmt_tgtmIter extends Rvar_srcm_stmt_tgtm {
    protected Iterator r;
    
    public Rvar_srcm_stmt_tgtmIter(Iterator r,
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
                return new Tuple((VarNode)
                                   r.next(),
                                 (SootMethod)
                                   r.next(),
                                 (Unit)
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
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { V1.v(), MS.v(), ST.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple." +
                                               "paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:s" +
                                               "oot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddomai" +
                                               "ns.A_tgtm:soot.jimple.paddle.bdddomains.MT> ret = jedd.inter" +
                                               "nal.Jedd.v().falseBDD(); at Rvar_srcm_stmt_tgtmIter.jedd:46," +
                                               "52-55"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() },
                                                       new PhysicalDomain[] { V1.v(), MS.v(), ST.v(), MT.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { V1.v(), MS.v(), MT.v(), ST.v() },
                                                   "return ret; at Rvar_srcm_stmt_tgtmIter.jedd:50,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return r.hasNext();
    }
}
