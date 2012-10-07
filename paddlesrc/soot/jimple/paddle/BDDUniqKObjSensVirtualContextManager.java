package soot.jimple.paddle;

import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import jedd.*;
import java.util.*;
import soot.*;

public class BDDUniqKObjSensVirtualContextManager extends BDDVirtualContextManager {
    BDDUniqKObjSensVirtualContextManager(Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in,
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
    
    private Jedd.Shifter[] shifters;
    
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
        if (shifters ==
              null) {
            shifters =
              (new Jedd.Shifter[k]);
            for (int j =
                   0;
                 j <
                   k;
                 j++) {
                int[] from =
                  new int[shiftWidth()];
                int[] to =
                  new int[shiftWidth()];
                for (int i =
                       0;
                     i <
                       from.length;
                     i++) {
                    from[i] =
                      i +
                        C2.v().firstBit();
                    to[i] =
                      i +
                        C1.v().firstBit() +
                        j *
                          shiftWidth();
                }
                shifters[j] =
                  Jedd.v().makeShifter(from,
                                       to);
            }
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
                                               "le.bdddomains.MT> newIn = jedd.internal.Jedd.v().replace(jed" +
                                               "d.internal.Jedd.v().project(in.get(), new jedd.PhysicalDomai" +
                                               "n[...]), new jedd.PhysicalDomain[...], new jedd.PhysicalDoma" +
                                               "in[...]); at BDDUniqKObjSensVirtualContextManager.jedd:67,64" +
                                               "-69"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(in.get(),
                                                                                                            new PhysicalDomain[] { V1.v() }),
                                                                             new PhysicalDomain[] { H1.v() },
                                                                             new PhysicalDomain[] { C2.v() }));
        final jedd.internal.RelationContainer objects =
          new jedd.internal.RelationContainer(new Attribute[] { A_obj.v() },
                                              new PhysicalDomain[] { C2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.C2> objects = jedd.internal.Jedd.v().project(newIn, n" +
                                               "ew jedd.PhysicalDomain[...]); at BDDUniqKObjSensVirtualConte" +
                                               "xtManager.jedd:69,19-26"),
                                              jedd.internal.Jedd.v().project(newIn,
                                                                             new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), C1.v(), CH1.v(), ST.v() }));
        final jedd.internal.RelationContainer existing =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), C2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple." +
                                               "paddle.bdddomains.C2> existing = jedd.internal.Jedd.v().fals" +
                                               "eBDD(); at BDDUniqKObjSensVirtualContextManager.jedd:71,30-3" +
                                               "8"),
                                              jedd.internal.Jedd.v().falseBDD());
        for (int i =
               0;
             i <
               k;
             i++) {
            existing.eqUnion(jedd.internal.Jedd.v().cast((jedd.internal.RelationContainer)
                                                           new jedd.internal.RelationContainer(new Attribute[] { A_obj.v() },
                                                                                               new PhysicalDomain[] { C2.v() },
                                                                                               ("objects.applyShifter(shifters[i]) at BDDUniqKObjSensVirtualC" +
                                                                                                "ontextManager.jedd:73,42-49"),
                                                                                               objects).applyShifter(shifters[i]),
                                                         new Attribute[] { A_varc.v(), A_obj.v() },
                                                         new PhysicalDomain[] { C1.v(), C2.v() }));
        }
        final jedd.internal.RelationContainer unchanged =
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
                                               "le.bdddomains.MT> unchanged = jedd.internal.Jedd.v().join(je" +
                                               "dd.internal.Jedd.v().read(newIn), existing, new jedd.Physica" +
                                               "lDomain[...]); at BDDUniqKObjSensVirtualContextManager.jedd:" +
                                               "78,64-73"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newIn),
                                                                          existing,
                                                                          new PhysicalDomain[] { C2.v(), C1.v() }));
        final jedd.internal.RelationContainer changed =
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
                                               "le.bdddomains.MT> changed = jedd.internal.Jedd.v().minus(jed" +
                                               "d.internal.Jedd.v().read(newIn), unchanged); at BDDUniqKObjS" +
                                               "ensVirtualContextManager.jedd:81,64-71"),
                                              jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(newIn),
                                                                           unchanged));
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
                                               "().copy(jedd.internal.Jedd.v().replace(changed, new jedd.Phy" +
                                               "sicalDomain[...], new jedd.PhysicalDomain[...]), new jedd.Ph" +
                                               "ysicalDomain[...], new jedd.Attribute[...], ...); at BDDUniq" +
                                               "KObjSensVirtualContextManager.jedd:84,82-90"),
                                              jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(changed,
                                                                                                         new PhysicalDomain[] { C2.v() },
                                                                                                         new PhysicalDomain[] { H1.v() }),
                                                                          new PhysicalDomain[] { H1.v() },
                                                                          new Attribute[] { A_obj.v() },
                                                                          new PhysicalDomain[] { C2.v() }));
        newEdges.eq(jedd.internal.Jedd.v().cast((jedd.internal.RelationContainer)
                                                  new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                                                      new PhysicalDomain[] { KD.v(), MS.v(), C2.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                                                      ("newEdges.applyShifter(shifter) at BDDUniqKObjSensVirtualCont" +
                                                                                       "extManager.jedd:88,12-20"),
                                                                                      newEdges).applyShifter(shifter),
                                                new Attribute[] { A_varc.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() },
                                                new PhysicalDomain[] { C1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), C2.v(), MT.v() }));
        newEdges.eqUnion(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(unchanged,
                                                                                    new PhysicalDomain[] { C2.v(), C1.v() },
                                                                                    new PhysicalDomain[] { H1.v(), C2.v() }),
                                                     new PhysicalDomain[] { C2.v() },
                                                     new Attribute[] { A_varc.v() },
                                                     new PhysicalDomain[] { C1.v() }));
        out.add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_srcc.v(), A_stmt.v() },
                                                    new PhysicalDomain[] { KD.v(), MS.v(), C2.v(), MT.v(), C1.v(), ST.v() },
                                                    ("out.add(jedd.internal.Jedd.v().project(newEdges, new jedd.Ph" +
                                                     "ysicalDomain[...])) at BDDUniqKObjSensVirtualContextManager." +
                                                     "jedd:92,8-11"),
                                                    jedd.internal.Jedd.v().project(newEdges,
                                                                                   new PhysicalDomain[] { H1.v(), CH1.v() })));
        if (thisOut !=
              null) {
            newMethods(new jedd.internal.RelationContainer(new Attribute[] { A_tgtm.v() },
                                                           new PhysicalDomain[] { MT.v() },
                                                           ("newMethods(jedd.internal.Jedd.v().project(newEdges, new jedd" +
                                                            ".PhysicalDomain[...])) at BDDUniqKObjSensVirtualContextManag" +
                                                            "er.jedd:95,12-22"),
                                                           jedd.internal.Jedd.v().project(newEdges,
                                                                                          new PhysicalDomain[] { KD.v(), MS.v(), C2.v(), H1.v(), C1.v(), CH1.v(), ST.v() })));
            thisOut.add(new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v(), A_varc.v(), A_var.v() },
                                                            new PhysicalDomain[] { H1.v(), CH1.v(), C1.v(), V1.v() },
                                                            ("thisOut.add(jedd.internal.Jedd.v().replace(jedd.internal.Jed" +
                                                             "d.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd" +
                                                             ".v().project(newEdges, new jedd.PhysicalDomain[...])), thisV" +
                                                             "ar(), new jedd.PhysicalDomain[...]), new jedd.PhysicalDomain" +
                                                             "[...], new jedd.PhysicalDomain[...])) at BDDUniqKObjSensVirt" +
                                                             "ualContextManager.jedd:97,12-19"),
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
