package soot.jimple.paddle;

import soot.*;
import soot.util.queue.*;
import java.util.*;
import soot.options.PaddleOptions;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.queue.*;
import jedd.*;

public class PropBDD extends AbsPropagator {
    public PropBDD(Rsrcc_src_dstc_dst simple,
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
    
    final jedd.internal.RelationContainer pt =
      new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { C2.v(), V2.v(), CH2.v(), H2.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_varc, soot.jimple.paddle.bd" +
                                           "ddomains.A_var, soot.jimple.paddle.bdddomains.A_objc, soot.j" +
                                           "imple.paddle.bdddomains.A_obj> pt = jedd.internal.Jedd.v().f" +
                                           "alseBDD() at PropBDD.jedd:39,16-46"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    final jedd.internal.RelationContainer fieldPt =
      new jedd.internal.RelationContainer(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { CH2.v(), H1.v(), FD.v(), CH1.v(), H2.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_basec, soot.jimple.paddle.b" +
                                           "dddomains.A_base, soot.jimple.paddle.bdddomains.A_fld, soot." +
                                           "jimple.paddle.bdddomains.A_objc, soot.jimple.paddle.bdddomai" +
                                           "ns.A_obj> fieldPt = jedd.internal.Jedd.v().falseBDD() at Pro" +
                                           "pBDD.jedd:40,16-55"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    protected jedd.internal.RelationContainer typeFilter() {
        final jedd.internal.RelationContainer allContexts =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_objc.v() },
                                              new PhysicalDomain[] { C1.v(), CH2.v() },
                                              ("final <soot.jimple.paddle.bdddomains.A_varc:soot.jimple.padd" +
                                               "le.bdddomains.C1, soot.jimple.paddle.bdddomains.A_objc:soot." +
                                               "jimple.paddle.bdddomains.CH2> allContexts = jedd.internal.Je" +
                                               "dd.v().trueBDD(); at PropBDD.jedd:43,31-42"),
                                              jedd.internal.Jedd.v().trueBDD());
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                   new PhysicalDomain[] { V2.v(), H1.v(), C1.v(), CH2.v() },
                                                   ("return jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().re" +
                                                    "ad(soot.jimple.paddle.PaddleScene.v().tm.get()), allContexts" +
                                                    ", new jedd.PhysicalDomain[...]); at PropBDD.jedd:44,8-14"),
                                                   jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(PaddleScene.v().tm.get()),
                                                                               allContexts,
                                                                               new PhysicalDomain[] {  }));
    }
    
    protected final jedd.internal.RelationContainer outputtedPt =
      new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                          new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                          ("protected <soot.jimple.paddle.bdddomains.A_varc, soot.jimple" +
                                           ".paddle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_ob" +
                                           "jc, soot.jimple.paddle.bdddomains.A_obj> outputtedPt = jedd." +
                                           "internal.Jedd.v().falseBDD() at PropBDD.jedd:47,14-44"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    protected void outputPt(final jedd.internal.RelationContainer pt) {
        final jedd.internal.RelationContainer toOutput =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H1> toOutput = jedd." +
                                               "internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.int" +
                                               "ernal.Jedd.v().replace(pt, new jedd.PhysicalDomain[...], new" +
                                               " jedd.PhysicalDomain[...])), outputtedPt); at PropBDD.jedd:4" +
                                               "9,39-47"),
                                              jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(pt,
                                                                                                                                      new PhysicalDomain[] { V2.v(), H2.v() },
                                                                                                                                      new PhysicalDomain[] { V1.v(), H1.v() })),
                                                                           outputtedPt));
        if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(toOutput),
                                          jedd.internal.Jedd.v().falseBDD()))
            return;
        ptout.add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                      new PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                      "ptout.add(toOutput) at PropBDD.jedd:51,8-13",
                                                      toOutput));
        outputtedPt.eqUnion(toOutput);
    }
    
    protected jedd.internal.RelationContainer propSimple(final jedd.internal.RelationContainer pt,
                                                         final jedd.internal.RelationContainer simple) {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C1.v(), V2.v(), CH1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> ret = jedd.inter" +
                                               "nal.Jedd.v().falseBDD(); at PropBDD.jedd:61,39-42"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (true) {
            pt.eq(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                                                             new PhysicalDomain[] { CH2.v() },
                                                                                                                                             new PhysicalDomain[] { CH1.v() })),
                                                                                  jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(simple),
                                                                                                                                                jedd.internal.Jedd.v().replace(pt,
                                                                                                                                                                               new PhysicalDomain[] { V2.v(), H2.v() },
                                                                                                                                                                               new PhysicalDomain[] { V1.v(), H1.v() }),
                                                                                                                                                new PhysicalDomain[] { C1.v(), V1.v() }),
                                                                                                                 new PhysicalDomain[] { C2.v() },
                                                                                                                 new PhysicalDomain[] { C1.v() })),
                                                 new PhysicalDomain[] { H1.v() },
                                                 new PhysicalDomain[] { H2.v() }));
            pt.eqMinus(ret);
            if (jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(pt),
                                              jedd.internal.Jedd.v().falseBDD()))
                break;
            ret.eqUnion(pt);
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                   new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                   "return ret; at PropBDD.jedd:71,8-14",
                                                   ret);
    }
    
    protected jedd.internal.RelationContainer propStore(final jedd.internal.RelationContainer pt,
                                                        final jedd.internal.RelationContainer store,
                                                        final jedd.internal.RelationContainer storePt) {
        final jedd.internal.RelationContainer objectsBeingStored =
          new jedd.internal.RelationContainer(new Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v(), A_fld.v() },
                                              new PhysicalDomain[] { CH2.v(), H2.v(), C2.v(), V2.v(), FD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdd" +
                                               "domains.CH2, soot.jimple.paddle.bdddomains.A_obj:soot.jimple" +
                                               ".paddle.bdddomains.H2, soot.jimple.paddle.bdddomains.A_varc:" +
                                               "soot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_var:soot.jimple.paddle.bdddomains.V2, soot.jimple.padd" +
                                               "le.bdddomains.A_fld:soot.jimple.paddle.bdddomains.FD> object" +
                                               "sBeingStored = jedd.internal.Jedd.v().compose(jedd.internal." +
                                               "Jedd.v().read(store), jedd.internal.Jedd.v().replace(pt, new" +
                                               " jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...]), ne" +
                                               "w jedd.PhysicalDomain[...]); at PropBDD.jedd:80,46-64"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(store),
                                                                             jedd.internal.Jedd.v().replace(pt,
                                                                                                            new PhysicalDomain[] { V2.v(), C2.v() },
                                                                                                            new PhysicalDomain[] { V1.v(), C1.v() }),
                                                                             new PhysicalDomain[] { C1.v(), V1.v() }));
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_obj.v(), A_objc.v(), A_base.v(), A_basec.v() },
                                                   new PhysicalDomain[] { FD.v(), H2.v(), CH2.v(), H1.v(), CH1.v() },
                                                   ("return jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v()" +
                                                    ".read(objectsBeingStored), jedd.internal.Jedd.v().replace(st" +
                                                    "orePt, new jedd.PhysicalDomain[...], new jedd.PhysicalDomain" +
                                                    "[...]), new jedd.PhysicalDomain[...]); at PropBDD.jedd:84,8-" +
                                                    "14"),
                                                   jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(objectsBeingStored),
                                                                                  jedd.internal.Jedd.v().replace(storePt,
                                                                                                                 new PhysicalDomain[] { CH2.v() },
                                                                                                                 new PhysicalDomain[] { CH1.v() }),
                                                                                  new PhysicalDomain[] { C2.v(), V2.v() }));
    }
    
    protected jedd.internal.RelationContainer propLoad(final jedd.internal.RelationContainer fpt,
                                                       final jedd.internal.RelationContainer load,
                                                       final jedd.internal.RelationContainer loadPt) {
        final jedd.internal.RelationContainer loadsFromHeap =
          new jedd.internal.RelationContainer(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new PhysicalDomain[] { CH2.v(), H2.v(), FD.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_basec:soot.jimple.paddle.bd" +
                                               "ddomains.CH2, soot.jimple.paddle.bdddomains.A_base:soot.jimp" +
                                               "le.paddle.bdddomains.H2, soot.jimple.paddle.bdddomains.A_fld" +
                                               ":soot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddom" +
                                               "ains.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.pa" +
                                               "ddle.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V2> load" +
                                               "sFromHeap; at PropBDD.jedd:94,48-61"));
        loadsFromHeap.eq(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(load),
                                                        jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().replace(loadPt,
                                                                                                                      new PhysicalDomain[] { C2.v() },
                                                                                                                      new PhysicalDomain[] { C1.v() }),
                                                                                       new PhysicalDomain[] { V2.v() },
                                                                                       new PhysicalDomain[] { V1.v() }),
                                                        new PhysicalDomain[] { C1.v(), V1.v() }));
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v(), A_obj.v(), A_objc.v() },
                                                   new PhysicalDomain[] { V2.v(), C2.v(), H2.v(), CH1.v() },
                                                   ("return jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v()" +
                                                    ".read(jedd.internal.Jedd.v().replace(loadsFromHeap, new jedd" +
                                                    ".PhysicalDomain[...], new jedd.PhysicalDomain[...])), fpt, n" +
                                                    "ew jedd.PhysicalDomain[...]); at PropBDD.jedd:98,8-14"),
                                                   jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(loadsFromHeap,
                                                                                                                                             new PhysicalDomain[] { H2.v() },
                                                                                                                                             new PhysicalDomain[] { H1.v() })),
                                                                                  fpt,
                                                                                  new PhysicalDomain[] { CH2.v(), H1.v(), FD.v() }));
    }
    
    public boolean fieldUpdate() {
        final jedd.internal.RelationContainer oldPt =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C2.v(), V2.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> oldPt = pt; at P" +
                                               "ropBDD.jedd:103,39-44"),
                                              pt);
        fieldPt.eqUnion(jedd.internal.Jedd.v().replace(propStore(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                     new PhysicalDomain[] { V2.v(), H2.v(), CH2.v(), C2.v() },
                                                                                                     ("propStore(pt, pag.allStore().get(), jedd.internal.Jedd.v().r" +
                                                                                                      "eplace(pt, new jedd.PhysicalDomain[...], new jedd.PhysicalDo" +
                                                                                                      "main[...])) at PropBDD.jedd:105,19-28"),
                                                                                                     pt),
                                                                 new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v(), A_fld.v() },
                                                                                                     new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v(), FD.v() },
                                                                                                     ("propStore(pt, pag.allStore().get(), jedd.internal.Jedd.v().r" +
                                                                                                      "eplace(pt, new jedd.PhysicalDomain[...], new jedd.PhysicalDo" +
                                                                                                      "main[...])) at PropBDD.jedd:105,19-28"),
                                                                                                     pag.allStore().get()),
                                                                 new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                     new PhysicalDomain[] { V2.v(), H1.v(), CH2.v(), C2.v() },
                                                                                                     ("propStore(pt, pag.allStore().get(), jedd.internal.Jedd.v().r" +
                                                                                                      "eplace(pt, new jedd.PhysicalDomain[...], new jedd.PhysicalDo" +
                                                                                                      "main[...])) at PropBDD.jedd:105,19-28"),
                                                                                                     jedd.internal.Jedd.v().replace(pt,
                                                                                                                                    new PhysicalDomain[] { H2.v() },
                                                                                                                                    new PhysicalDomain[] { H1.v() }))),
                                                       new PhysicalDomain[] { CH1.v(), CH2.v() },
                                                       new PhysicalDomain[] { CH2.v(), CH1.v() }));
        pt.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(propLoad(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                                                                                                                            new PhysicalDomain[] { FD.v(), H1.v(), CH2.v(), H2.v(), CH1.v() },
                                                                                                                                                            ("propLoad(fieldPt, pag.allLoad().get(), pt) at PropBDD.jedd:1" +
                                                                                                                                                             "06,14-22"),
                                                                                                                                                            fieldPt),
                                                                                                                        new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                                                                                                                                            new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                                                                                                                                            ("propLoad(fieldPt, pag.allLoad().get(), pt) at PropBDD.jedd:1" +
                                                                                                                                                             "06,14-22"),
                                                                                                                                                            pag.allLoad().get()),
                                                                                                                        new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                                                                            new PhysicalDomain[] { V2.v(), H2.v(), CH2.v(), C2.v() },
                                                                                                                                                            ("propLoad(fieldPt, pag.allLoad().get(), pt) at PropBDD.jedd:1" +
                                                                                                                                                             "06,14-22"),
                                                                                                                                                            pt))),
                                                                                   jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                                  new PhysicalDomain[] { C1.v(), CH2.v(), H1.v() },
                                                                                                                  new PhysicalDomain[] { C2.v(), CH1.v(), H2.v() })),
                                                  new PhysicalDomain[] { CH1.v() },
                                                  new PhysicalDomain[] { CH2.v() }));
        outputPt(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                     new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                     ("outputPt(jedd.internal.Jedd.v().replace(pt, new jedd.Physica" +
                                                      "lDomain[...], new jedd.PhysicalDomain[...])) at PropBDD.jedd" +
                                                      ":108,8-16"),
                                                     jedd.internal.Jedd.v().replace(pt,
                                                                                    new PhysicalDomain[] { CH2.v(), C2.v() },
                                                                                    new PhysicalDomain[] { CH1.v(), C1.v() })));
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(pt),
                                              oldPt);
    }
    
    public boolean update() {
        final jedd.internal.RelationContainer oldPt =
          new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v() },
                                              new PhysicalDomain[] { C2.v(), V2.v(), CH2.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_varc:soot.jimple.paddle.bdd" +
                                               "domains.C2, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_objc:s" +
                                               "oot.jimple.paddle.bdddomains.CH2, soot.jimple.paddle.bdddoma" +
                                               "ins.A_obj:soot.jimple.paddle.bdddomains.H2> oldPt = pt; at P" +
                                               "ropBDD.jedd:113,39-44"),
                                              pt);
        pt.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(newAlloc.get(),
                                                                                                                                              new PhysicalDomain[] { CH1.v(), V1.v() },
                                                                                                                                              new PhysicalDomain[] { CH2.v(), V2.v() })),
                                                                                   typeFilter()),
                                                  new PhysicalDomain[] { H1.v(), C1.v() },
                                                  new PhysicalDomain[] { H2.v(), C2.v() }));
        pt.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(propSimple(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                                                                                                                              new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                                                                                                                              ("propSimple(jedd.internal.Jedd.v().replace(pt, new jedd.Physi" +
                                                                                                                                                               "calDomain[...], new jedd.PhysicalDomain[...]), pag.allSimple" +
                                                                                                                                                               "().get()) at PropBDD.jedd:116,14-24"),
                                                                                                                                                              jedd.internal.Jedd.v().replace(pt,
                                                                                                                                                                                             new PhysicalDomain[] { CH2.v(), C2.v() },
                                                                                                                                                                                             new PhysicalDomain[] { CH1.v(), C1.v() })),
                                                                                                                          new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                                                                                                                                              new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                                                                                                                                              ("propSimple(jedd.internal.Jedd.v().replace(pt, new jedd.Physi" +
                                                                                                                                                               "calDomain[...], new jedd.PhysicalDomain[...]), pag.allSimple" +
                                                                                                                                                               "().get()) at PropBDD.jedd:116,14-24"),
                                                                                                                                                              pag.allSimple().get()))),
                                                                                   jedd.internal.Jedd.v().replace(typeFilter(),
                                                                                                                  new PhysicalDomain[] { CH2.v(), H1.v() },
                                                                                                                  new PhysicalDomain[] { CH1.v(), H2.v() })),
                                                  new PhysicalDomain[] { CH1.v(), C1.v() },
                                                  new PhysicalDomain[] { CH2.v(), C2.v() }));
        outputPt(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                     new PhysicalDomain[] { V2.v(), H2.v(), CH1.v(), C1.v() },
                                                     ("outputPt(jedd.internal.Jedd.v().replace(pt, new jedd.Physica" +
                                                      "lDomain[...], new jedd.PhysicalDomain[...])) at PropBDD.jedd" +
                                                      ":117,8-16"),
                                                     jedd.internal.Jedd.v().replace(pt,
                                                                                    new PhysicalDomain[] { CH2.v(), C2.v() },
                                                                                    new PhysicalDomain[] { CH1.v(), C1.v() })));
        if (PaddleScene.v().options().verbose()) {
            G.v().out.println("Major iteration: ");
        }
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(pt),
                                              oldPt);
    }
    
    private BDDP2Sets p2sets =
      new BDDP2Sets(this);
    
    public AbsP2Sets p2sets() {
        return p2sets;
    }
}
