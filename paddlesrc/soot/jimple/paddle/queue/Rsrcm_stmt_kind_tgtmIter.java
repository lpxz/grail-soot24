package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrcm_stmt_kind_tgtmIter extends Rsrcm_stmt_kind_tgtm {
    protected Iterator r;
    
    public Rsrcm_stmt_kind_tgtmIter(Iterator r,
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
                return new Tuple((SootMethod)
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
          new jedd.internal.RelationContainer(new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                               "domains.MS, soot.jimple.paddle.bdddomains.A_stmt:soot.jimple" +
                                               ".paddle.bdddomains.ST, soot.jimple.paddle.bdddomains.A_kind:" +
                                               "soot.jimple.paddle.bdddomains.KD, soot.jimple.paddle.bdddoma" +
                                               "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> ret = jedd.inte" +
                                               "rnal.Jedd.v().falseBDD(); at Rsrcm_stmt_kind_tgtmIter.jedd:4" +
                                               "6,53-56"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                       new PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                   "return ret; at Rsrcm_stmt_kind_tgtmIter.jedd:50,8-14",
                                                   ret);
    }
    
    public boolean hasNext() {
        return r.hasNext();
    }
}
