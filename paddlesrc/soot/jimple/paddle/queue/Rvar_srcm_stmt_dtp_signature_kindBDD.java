package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvar_srcm_stmt_dtp_signature_kindBDD extends Rvar_srcm_stmt_dtp_signature_kind {
    private final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                          new PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), SG.v(), KD.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var:soot.jimple.pad" +
                                           "dle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot" +
                                           ".jimple.paddle.bdddomains.MS, soot.jimple.paddle.bdddomains." +
                                           "A_stmt:soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle." +
                                           "bdddomains.A_dtp:soot.jimple.paddle.bdddomains.T1, soot.jimp" +
                                           "le.paddle.bdddomains.A_signature:soot.jimple.paddle.bdddomai" +
                                           "ns.SG, soot.jimple.paddle.bdddomains.A_kind:soot.jimple.padd" +
                                           "le.bdddomains.KD> bdd at Rvar_srcm_stmt_dtp_signature_kindBD" +
                                           "D.jedd:31,12-81"));
    
    void add(final jedd.internal.RelationContainer tuple) {
        bdd.eqUnion(tuple);
    }
    
    public Rvar_srcm_stmt_dtp_signature_kindBDD(final jedd.internal.RelationContainer bdd,
                                                String name,
                                                PaddleQueue q) {
        this(name,
             q);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_dtp.v(), A_signature.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), T1.v(), SG.v(), ST.v() },
                                                ("add(bdd) at Rvar_srcm_stmt_dtp_signature_kindBDD.jedd:33,170" +
                                                 "-173"),
                                                bdd));
    }
    
    public Rvar_srcm_stmt_dtp_signature_kindBDD(final jedd.internal.RelationContainer bdd) {
        this("",
             null);
        add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_dtp.v(), A_signature.v(), A_stmt.v() },
                                                new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), T1.v(), SG.v(), ST.v() },
                                                ("add(bdd) at Rvar_srcm_stmt_dtp_signature_kindBDD.jedd:34,143" +
                                                 "-146"),
                                                bdd));
    }
    
    Rvar_srcm_stmt_dtp_signature_kindBDD(String name,
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
                      new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_dtp.v(), A_signature.v(), A_stmt.v() },
                                                          new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), T1.v(), SG.v(), ST.v() },
                                                          ("bdd.iterator(new jedd.Attribute[...]) at Rvar_srcm_stmt_dtp_" +
                                                           "signature_kindBDD.jedd:46,25-28"),
                                                          bdd).iterator(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() });
                    bdd.eq(jedd.internal.Jedd.v().falseBDD());
                }
                Object[] components =
                  (Object[])
                    it.next();
                return new Tuple((VarNode)
                                   components[0],
                                 (SootMethod)
                                   components[1],
                                 (Unit)
                                   components[2],
                                 (Type)
                                   components[3],
                                 (NumberedString)
                                   components[4],
                                 (Kind)
                                   components[5]);
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_dtp.v(), A_signature.v(), A_kind.v() },
                                              new PhysicalDomain[] { V1.v(), MS.v(), ST.v(), T1.v(), SG.v(), KD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple." +
                                               "paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:s" +
                                               "oot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dtp:soot.jimple.paddle.bdddomains.T1, soot.jimple.paddl" +
                                               "e.bdddomains.A_signature:soot.jimple.paddle.bdddomains.SG, s" +
                                               "oot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdddo" +
                                               "mains.KD> ret = bdd; at Rvar_srcm_stmt_dtp_signature_kindBDD" +
                                               ".jedd:56,78-81"),
                                              bdd);
        bdd.eq(jedd.internal.Jedd.v().falseBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_dtp.v(), A_signature.v(), A_stmt.v() },
                                                   new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), T1.v(), SG.v(), ST.v() },
                                                   ("return ret; at Rvar_srcm_stmt_dtp_signature_kindBDD.jedd:58," +
                                                    "8-14"),
                                                   ret);
    }
    
    public boolean hasNext() {
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(bdd),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
