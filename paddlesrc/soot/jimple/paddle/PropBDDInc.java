package soot.jimple.paddle;

import soot.*;
import soot.util.queue.*;
import java.util.*;
import soot.options.PaddleOptions;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.queue.*;
import jedd.*;

public final class PropBDDInc extends PropBDD {
    public PropBDDInc(Rsrcc_src_dstc_dst simple,
                      Rsrcc_src_fld_dstc_dst load,
                      Rsrcc_src_dstc_dst_fld store,
                      Robjc_obj_varc_var alloc,
                      Qvarc_var_objc_obj propout,
                      AbsPAG pag) {
        super(simple,
              load,
              store,
              alloc,
              propout,
              pag);
    }
    
    private final jedd.internal.RelationContainer ptFromLoad =
      new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { C2.v(), V2.v(), CH1.v(), H2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_varc, soot.jimple.p" +
                                           "addle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_objc" +
                                           ", soot.jimple.paddle.bdddomains.A_obj> ptFromLoad = jedd.int" +
                                           "ernal.Jedd.v().falseBDD() at PropBDDInc.jedd:39,12-42"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public final boolean fieldUpdate() {
        final jedd.internal.RelationContainer oldPt =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C2.v(), V2.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> oldPt = pt; at P" +
                                               "ropBDDInc.jedd:42,39-44"),
                                              pt);
        fieldPt.eq(jedd.internal.Jedd.v().replace(propStore(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                new PhysicalDomain[] { V2.v(), H2.v(), CH2.v(), C2.v() },
                                                                                                ("propStore(pt, pag.allStore().get(), jedd.internal.Jedd.v().r" +
                                                                                                 "eplace(pt, new jedd.PhysicalDomain[...], new jedd.PhysicalDo" +
                                                                                                 "main[...])) at PropBDDInc.jedd:44,18-27"),
                                                                                                pt),
                                                            new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v(), A_fld.v() },
                                                                                                new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v(), FD.v() },
                                                                                                ("propStore(pt, pag.allStore().get(), jedd.internal.Jedd.v().r" +
                                                                                                 "eplace(pt, new jedd.PhysicalDomain[...], new jedd.PhysicalDo" +
                                                                                                 "main[...])) at PropBDDInc.jedd:44,18-27"),
                                                                                                pag.allStore().get()),
                                                            new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                new PhysicalDomain[] { V2.v(), H1.v(), CH2.v(), C2.v() },
                                                                                                ("propStore(pt, pag.allStore().get(), jedd.internal.Jedd.v().r" +
                                                                                                 "eplace(pt, new jedd.PhysicalDomain[...], new jedd.PhysicalDo" +
                                                                                                 "main[...])) at PropBDDInc.jedd:44,18-27"),
                                                                                                jedd.internal.Jedd.v().replace(pt,
                                                                                                                               new PhysicalDomain[] { H2.v() },
                                                                                                                               new PhysicalDomain[] { H1.v() }))),
                                                  new PhysicalDomain[] { CH1.v(), CH2.v() },
                                                  new PhysicalDomain[] { CH2.v(), CH1.v() }));
        final jedd.internal.RelationContainer ptFromThisLoad =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C2.v(), V2.v(), CH1.v(), H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1> ptFromThisLoad =" +
                                               " jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().rea" +
                                               "d(jedd.internal.Jedd.v().replace(propLoad(new jedd.internal." +
                                               "RelationContainer(...), new jedd.internal.RelationContainer(" +
                                               "...), new jedd.internal.RelationContainer(...)), new jedd.Ph" +
                                               "ysicalDomain[...], new jedd.PhysicalDomain[...])), jedd.inte" +
                                               "rnal.Jedd.v().replace(typeFilter(), new jedd.PhysicalDomain[" +
                                               "...], new jedd.PhysicalDomain[...])); at PropBDDInc.jedd:45," +
                                               "39-53"),
                                              jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(propLoad(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                                                                                                                                                       new PhysicalDomain[] { FD.v(), H1.v(), CH2.v(), H2.v(), CH1.v() },
                                                                                                                                                                                       ("propLoad(fieldPt, pag.allLoad().get(), pt) at PropBDDInc.jed" +
                                                                                                                                                                                        "d:45,56-64"),
                                                                                                                                                                                       fieldPt),
                                                                                                                                                   new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                                                                                                                                                                       new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                                                                                                                                                                       ("propLoad(fieldPt, pag.allLoad().get(), pt) at PropBDDInc.jed" +
                                                                                                                                                                                        "d:45,56-64"),
                                                                                                                                                                                       pag.allLoad().get()),
                                                                                                                                                   new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                                                                                                       new PhysicalDomain[] { V2.v(), H2.v(), CH2.v(), C2.v() },
                                                                                                                                                                                       ("propLoad(fieldPt, pag.allLoad().get(), pt) at PropBDDInc.jed" +
                                                                                                                                                                                        "d:45,56-64"),
                                                                                                                                                                                       pt)),
                                                                                                                                          new PhysicalDomain[] { H2.v() },
                                                                                                                                          new PhysicalDomain[] { H1.v() })),
                                                                               jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                              new PhysicalDomain[] { C1.v(), CH2.v() },
                                                                                                              new PhysicalDomain[] { C2.v(), CH1.v() })));
        pt.eqUnion(jedd.internal.Jedd.v().replace(ptFromThisLoad,
                                                  new PhysicalDomain[] { H1.v(), CH1.v() },
                                                  new PhysicalDomain[] { H2.v(), CH2.v() }));
        ptFromLoad.eqUnion(jedd.internal.Jedd.v().replace(ptFromThisLoad,
                                                          new PhysicalDomain[] { H1.v() },
                                                          new PhysicalDomain[] { H2.v() }));
        outputPt(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                     new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                     ("outputPt(jedd.internal.Jedd.v().replace(ptFromThisLoad, new " +
                                                      "jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...])) at " +
                                                      "PropBDDInc.jedd:48,8-16"),
                                                     jedd.internal.Jedd.v().replace(ptFromThisLoad,
                                                                                    new PhysicalDomain[] { H1.v(), C2.v() },
                                                                                    new PhysicalDomain[] { H2.v(), C1.v() })));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(pt),
                                              oldPt);
    }
    
    public final boolean update() {
        final jedd.internal.RelationContainer oldPt =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C2.v(), V2.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> oldPt = pt; at P" +
                                               "ropBDDInc.jedd:54,39-44"),
                                              pt);
        final jedd.internal.RelationContainer ptFromAlloc =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> ptFromAlloc = je" +
                                               "dd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(j" +
                                               "edd.internal.Jedd.v().replace(newAlloc.get(), new jedd.Physi" +
                                               "calDomain[...], new jedd.PhysicalDomain[...])), jedd.interna" +
                                               "l.Jedd.v().replace(typeFilter(), new jedd.PhysicalDomain[..." +
                                               "], new jedd.PhysicalDomain[...])); at PropBDDInc.jedd:57,12-" +
                                               "23"),
                                              jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(newAlloc.get(),
                                                                                                                                          new PhysicalDomain[] { H1.v() },
                                                                                                                                          new PhysicalDomain[] { H2.v() })),
                                                                               jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                              new PhysicalDomain[] { V2.v(), CH2.v(), H1.v() },
                                                                                                              new PhysicalDomain[] { V1.v(), CH1.v(), H2.v() })));
        final jedd.internal.RelationContainer ptFromSimple1 =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V2.v(), CH1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> ptFromSimple1 = " +
                                               "jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().inters" +
                                               "ect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().repla" +
                                               "ce(propSimple(new jedd.internal.RelationContainer(...), new " +
                                               "jedd.internal.RelationContainer(...)), new jedd.PhysicalDoma" +
                                               "in[...], new jedd.PhysicalDomain[...])), jedd.internal.Jedd." +
                                               "v().replace(typeFilter(), new jedd.PhysicalDomain[...], new " +
                                               "jedd.PhysicalDomain[...])), new jedd.PhysicalDomain[...], ne" +
                                               "w jedd.PhysicalDomain[...]); at PropBDDInc.jedd:59,12-25"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(propSimple(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                                                                                                                                        new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                                                                                                                                                                                        ("propSimple(jedd.internal.Jedd.v().replace(pt, new jedd.Physi" +
                                                                                                                                                                                                                         "calDomain[...], new jedd.PhysicalDomain[...]), newSimple.get" +
                                                                                                                                                                                                                         "()) at PropBDDInc.jedd:59,28-38"),
                                                                                                                                                                                                                        jedd.internal.Jedd.v().replace(pt,
                                                                                                                                                                                                                                                       new PhysicalDomain[] { CH2.v(), C2.v() },
                                                                                                                                                                                                                                                       new PhysicalDomain[] { CH1.v(), C1.v() })),
                                                                                                                                                                                    new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                                                                                                                                                                                                        new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                                                                                                                                                                                                        ("propSimple(jedd.internal.Jedd.v().replace(pt, new jedd.Physi" +
                                                                                                                                                                                                                         "calDomain[...], new jedd.PhysicalDomain[...]), newSimple.get" +
                                                                                                                                                                                                                         "()) at PropBDDInc.jedd:59,28-38"),
                                                                                                                                                                                                                        newSimple.get())),
                                                                                                                                                                         new PhysicalDomain[] { CH1.v() },
                                                                                                                                                                         new PhysicalDomain[] { CH2.v() })),
                                                                                                              jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                                                             new PhysicalDomain[] { H1.v() },
                                                                                                                                             new PhysicalDomain[] { H2.v() })),
                                                                             new PhysicalDomain[] { CH2.v() },
                                                                             new PhysicalDomain[] { CH1.v() }));
        final jedd.internal.RelationContainer ptFromAllocAndSimple1 =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> ptFromAllocAndSi" +
                                               "mple1 = jedd.internal.Jedd.v().union(jedd.internal.Jedd.v()." +
                                               "read(ptFromAlloc), jedd.internal.Jedd.v().replace(ptFromSimp" +
                                               "le1, new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[." +
                                               "..])); at PropBDDInc.jedd:61,12-33"),
                                              jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(ptFromAlloc),
                                                                           jedd.internal.Jedd.v().replace(ptFromSimple1,
                                                                                                          new PhysicalDomain[] { V2.v() },
                                                                                                          new PhysicalDomain[] { V1.v() })));
        final jedd.internal.RelationContainer ptFromSimple2 =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> ptFromSimple2 = " +
                                               "jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read" +
                                               "(jedd.internal.Jedd.v().replace(propSimple(new jedd.internal" +
                                               ".RelationContainer(...), new jedd.internal.RelationContainer" +
                                               "(...)), new jedd.PhysicalDomain[...], new jedd.PhysicalDomai" +
                                               "n[...])), jedd.internal.Jedd.v().replace(typeFilter(), new j" +
                                               "edd.PhysicalDomain[...], new jedd.PhysicalDomain[...])); at " +
                                               "PropBDDInc.jedd:63,12-25"),
                                              jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(propSimple(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                                                                                                                                                         new PhysicalDomain[] { V2.v(), H2.v(), C1.v(), CH1.v() },
                                                                                                                                                                                         ("propSimple(jedd.internal.Jedd.v().replace(jedd.internal.Jedd" +
                                                                                                                                                                                          ".v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v(" +
                                                                                                                                                                                          ").replace(ptFromAllocAndSimple1, new jedd.PhysicalDomain[..." +
                                                                                                                                                                                          "], new jedd.PhysicalDomain[...])), ptFromLoad), new jedd.Phy" +
                                                                                                                                                                                          "sicalDomain[...], new jedd.PhysicalDomain[...]), pag.allSimp" +
                                                                                                                                                                                          "le().get()) at PropBDDInc.jedd:63,28-38"),
                                                                                                                                                                                         jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(ptFromAllocAndSimple1,
                                                                                                                                                                                                                                                                                                                new PhysicalDomain[] { V1.v(), C1.v() },
                                                                                                                                                                                                                                                                                                                new PhysicalDomain[] { V2.v(), C2.v() })),
                                                                                                                                                                                                                                                     ptFromLoad),
                                                                                                                                                                                                                        new PhysicalDomain[] { C2.v() },
                                                                                                                                                                                                                        new PhysicalDomain[] { C1.v() })),
                                                                                                                                                     new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                                                                                                                                                                         new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                                                                                                                                                                         ("propSimple(jedd.internal.Jedd.v().replace(jedd.internal.Jedd" +
                                                                                                                                                                                          ".v().union(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v(" +
                                                                                                                                                                                          ").replace(ptFromAllocAndSimple1, new jedd.PhysicalDomain[..." +
                                                                                                                                                                                          "], new jedd.PhysicalDomain[...])), ptFromLoad), new jedd.Phy" +
                                                                                                                                                                                          "sicalDomain[...], new jedd.PhysicalDomain[...]), pag.allSimp" +
                                                                                                                                                                                          "le().get()) at PropBDDInc.jedd:63,28-38"),
                                                                                                                                                                                         pag.allSimple().get())),
                                                                                                                                          new PhysicalDomain[] { V2.v() },
                                                                                                                                          new PhysicalDomain[] { V1.v() })),
                                                                               jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                              new PhysicalDomain[] { V2.v(), CH2.v(), H1.v() },
                                                                                                              new PhysicalDomain[] { V1.v(), CH1.v(), H2.v() })));
        ptFromLoad.eq(jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer ptFromAllocAndSimple =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> ptFromAllocAndSi" +
                                               "mple = jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v()" +
                                               ".union(jedd.internal.Jedd.v().read(ptFromAllocAndSimple1), p" +
                                               "tFromSimple2), new jedd.PhysicalDomain[...], new jedd.Physic" +
                                               "alDomain[...]); at PropBDDInc.jedd:67,12-32"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(ptFromAllocAndSimple1),
                                                                                                          ptFromSimple2),
                                                                             new PhysicalDomain[] { CH1.v() },
                                                                             new PhysicalDomain[] { CH2.v() }));
        pt.eqUnion(jedd.internal.Jedd.v().replace(ptFromAllocAndSimple,
                                                  new PhysicalDomain[] { V1.v(), C1.v() },
                                                  new PhysicalDomain[] { V2.v(), C2.v() }));
        outputPt(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                     new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                     ("outputPt(jedd.internal.Jedd.v().replace(ptFromAllocAndSimple" +
                                                      ", new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...]" +
                                                      ")) at PropBDDInc.jedd:69,8-16"),
                                                     jedd.internal.Jedd.v().replace(ptFromAllocAndSimple,
                                                                                    new PhysicalDomain[] { V1.v(), CH2.v() },
                                                                                    new PhysicalDomain[] { V2.v(), CH1.v() })));
        if (PaddleScene.v().options().verbose()) {
            G.v().out.println("Major iteration: ");
        }
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(pt),
                                              oldPt);
    }
}
