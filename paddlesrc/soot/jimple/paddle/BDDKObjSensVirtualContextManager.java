package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import jedd.*;
import java.util.*;
import soot.*;

public class BDDKObjSensVirtualContextManager extends BDDVirtualContextManager {
    BDDKObjSensVirtualContextManager(Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in,
                                     Qsrcc_srcm_stmt_kind_tgtc_tgtm out,
                                     Qobjc_obj_varc_var thisOut,
                                     NodeFactory gnf,
                                     int k) {
        super(in,
              out,
              thisOut,
              gnf);
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
        final jedd.internal.RelationContainer newIn =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), CH1.v(), C2.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_objc:soot.jimple" +
                                               ".paddle.bdddomains.CH1, soot.jimple.paddle.bdddomains.A_obj:" +
                                               "soot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_srcm:soot.jimple.paddle.bdddomains.MS, soot.jimple.pad" +
                                               "dle.bdddomains.A_stmt:soot.jimple.paddle.bdddomains.ST, soot" +
                                               ".jimple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdddomai" +
                                               "ns.KD, soot.jimple.paddle.bdddomains.A_tgtm:soot.jimple.padd" +
                                               "le.bdddomains.MT> newIn = jedd.internal.Jedd.v().project(jed" +
                                               "d.internal.Jedd.v().replace(in.get(), new jedd.PhysicalDomai" +
                                               "n[...], new jedd.PhysicalDomain[...]), new jedd.PhysicalDoma" +
                                               "in[...]); at BDDKObjSensVirtualContextManager.jedd:53,64-69"),
                                              jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().replace(in.get(),
                                                                                                            new PhysicalDomain[] { H1.v() },
                                                                                                            new PhysicalDomain[] { C2.v() }),
                                                                             new PhysicalDomain[] { V1.v() }));
        final jedd.internal.RelationContainer newEdges =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                              new PhysicalDomain[] { C1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_objc:soot.jimple" +
                                               ".paddle.bdddomains.CH1, soot.jimple.paddle.bdddomains.A_obj:" +
                                               "soot.jimple.paddle.bdddomains.H1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_srcm:soot.jimple.paddle.bdddomains.MS, soot.jimple.pad" +
                                               "dle.bdddomains.A_stmt:soot.jimple.paddle.bdddomains.ST, soot" +
                                               ".jimple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdddomai" +
                                               "ns.KD, soot.jimple.paddle.bdddomains.A_tgtc:soot.jimple.padd" +
                                               "le.bdddomains.C2, soot.jimple.paddle.bdddomains.A_tgtm:soot." +
                                               "jimple.paddle.bdddomains.MT> newEdges = jedd.internal.Jedd.v" +
                                               "().copy(newIn, new jedd.PhysicalDomain[...], new jedd.Attrib" +
                                               "ute[...], ...); at BDDKObjSensVirtualContextManager.jedd:54," +
                                               "82-90"),
                                              jedd.internal.Jedd.v().copy(newIn,
                                                                          new PhysicalDomain[] { C2.v() },
                                                                          new Attribute[] { A_obj.v() },
                                                                          new PhysicalDomain[] { H1.v() }));
        newEdges.eq(jedd.internal.Jedd.v().cast((jedd.internal.RelationContainer)
                                                  new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                                                      new PhysicalDomain[] { KD.v(), MS.v(), C2.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                                                      ("newEdges.applyShifter(shifter) at BDDKObjSensVirtualContextM" +
                                                                                       "anager.jedd:57,12-20"),
                                                                                      newEdges).applyShifter(shifter),
                                                new Attribute[] { A_varc.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                                new PhysicalDomain[] { C1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() }));
        out.add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_srcc.v(), A_stmt.v() },
                                                    new PhysicalDomain[] { KD.v(), MS.v(), C2.v(), MT.v(), C1.v(), ST.v() },
                                                    ("out.add(jedd.internal.Jedd.v().project(newEdges, new jedd.Ph" +
                                                     "ysicalDomain[...])) at BDDKObjSensVirtualContextManager.jedd" +
                                                     ":58,8-11"),
                                                    jedd.internal.Jedd.v().project(newEdges,
                                                                                   new PhysicalDomain[] { H1.v(), CH1.v() })));
        if (thisOut !=
              null) {
            newMethods(new jedd.internal.RelationContainer(new Attribute[] { A_tgtm.v() },
                                                           new PhysicalDomain[] { MT.v() },
                                                           ("newMethods(jedd.internal.Jedd.v().project(newEdges, new jedd" +
                                                            ".PhysicalDomain[...])) at BDDKObjSensVirtualContextManager.j" +
                                                            "edd:61,12-22"),
                                                           jedd.internal.Jedd.v().project(newEdges,
                                                                                          new PhysicalDomain[] { KD.v(), MS.v(), C2.v(), H1.v(), C1.v(), CH1.v(), ST.v() })));
            thisOut.add(new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v(), A_varc.v(), A_var.v() },
                                                            new PhysicalDomain[] { H1.v(), CH1.v(), C1.v(), V1.v() },
                                                            ("thisOut.add(jedd.internal.Jedd.v().replace(jedd.internal.Jed" +
                                                             "d.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd" +
                                                             ".v().project(newEdges, new jedd.PhysicalDomain[...])), thisV" +
                                                             "ar(), new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain" +
                                                             "[...], new jedd.PhysicalDomain[...])) at BDDKObjSensVirtualC" +
                                                             "ontextManager.jedd:63,12-19"),
                                                            jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(newEdges,
                                                                                                                                                                                     new PhysicalDomain[] { KD.v(), MS.v(), C1.v(), ST.v() })),
                                                                                                                          thisVar(),
                                                                                                                          new PhysicalDomain[] { MT.v() }),
                                                                                           new PhysicalDomain[] { C2.v() },
                                                                                           new PhysicalDomain[] { C1.v() })));
        }
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newIn),
                                              jedd.internal.Jedd.v().falseBDD());
    }
}
