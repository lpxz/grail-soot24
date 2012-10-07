package soot.jimple.paddle;

import soot.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import jedd.*;
import java.util.*;

public class BDDKCFAStaticContextManager extends AbsStaticContextManager {
    BDDKCFAStaticContextManager(Rsrcc_srcm_stmt_kind_tgtc_tgtm in,
                                Qsrcc_srcm_stmt_kind_tgtc_tgtm out,
                                int k) {
        super(in,
              out);
        this.k =
          k;
    }
    
    private Jedd.Shifter shifter;
    
    private int k;
    
    private int shiftWidth() {
        return ((ContextStringNumberer)
                  Scene.v().getContextNumberer()).shiftWidth;
    }
    
    public boolean update() {
        if (shifter ==
              null) {
            int[] from =
              new int[(k -
                         1) *
                        shiftWidth()];
            int[] to =
              new int[(k -
                         1) *
                        shiftWidth()];
            for (int i =
                   0;
                 i <
                   from.length;
                 i++) {
                from[i] =
                  i +
                    C1.v().firstBit();
                to[i] =
                  i +
                    C2.v().firstBit() +
                    shiftWidth();
            }
            shifter =
              Jedd.v().makeShifter(from,
                                   to);
        }
        final jedd.internal.RelationContainer newEdges =
          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                               ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_stmt:" +
                                               "soot.jimple.paddle.bdddomains.ST, soot.jimple.paddle.bdddoma" +
                                               "ins.A_kind:soot.jimple.paddle.bdddomains.KD, soot.jimple.pad" +
                                               "dle.bdddomains.A_tgtc:soot.jimple.paddle.bdddomains.C2, soot" +
                                               ".jimple.paddle.bdddomains.A_tgtm:soot.jimple.paddle.bdddomai" +
                                               "ns.MT> newEdges = jedd.internal.Jedd.v().copy(jedd.internal." +
                                               "Jedd.v().project(in.get(), new jedd.PhysicalDomain[...]), ne" +
                                               "w jedd.PhysicalDomain[...], new jedd.Attribute[...], ...); a" +
                                               "t BDDKCFAStaticContextManager.jedd:53,63-71"),
                                              jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().project(in.get(),
                                                                                                         new PhysicalDomain[] { C2.v() }),
                                                                          new PhysicalDomain[] { ST.v() },
                                                                          new Attribute[] { A_stmt.v() },
                                                                          new PhysicalDomain[] { C2.v() }));
        newEdges.eq(jedd.internal.Jedd.v().cast((jedd.internal.RelationContainer)
                                                  new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                                                      new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                                                      ("newEdges.applyShifter(shifter) at BDDKCFAStaticContextManage" +
                                                                                       "r.jedd:56,12-20"),
                                                                                      newEdges).applyShifter(shifter),
                                                new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                                new PhysicalDomain[] { C1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() }));
        out.add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                                    new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                                    ("out.add(newEdges) at BDDKCFAStaticContextManager.jedd:57,8-1" +
                                                     "1"),
                                                    newEdges));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newEdges),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
