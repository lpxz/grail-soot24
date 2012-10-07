package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class BDDMethodPAGContextifier extends AbsMethodPAGContextifier {
    private BDDNodeInfo ni;
    
    public BDDMethodPAGContextifier(BDDNodeInfo ni,
                                    Rsrc_dst simple,
                                    Rsrc_fld_dst load,
                                    Rsrc_dst_fld store,
                                    Robj_var alloc,
                                    Rctxt_method rcout,
                                    Qsrcc_src_dstc_dst csimple,
                                    Qsrcc_src_fld_dstc_dst cload,
                                    Qsrcc_src_dstc_dst_fld cstore,
                                    Qobjc_obj_varc_var calloc) {
        super(simple,
              load,
              store,
              alloc,
              rcout,
              csimple,
              cload,
              cstore,
              calloc);
        this.ni =
          ni;
    }
    
    public boolean update() {
        boolean contextHeap =
          PaddleScene.v().options().context_heap();
        final jedd.internal.RelationContainer simpleOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> simpleOut = jedd." +
                                               "internal.Jedd.v().falseBDD(); at BDDMethodPAGContextifier.je" +
                                               "dd:56,39-48"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer loadOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V2> loadOut" +
                                               " = jedd.internal.Jedd.v().falseBDD(); at BDDMethodPAGContext" +
                                               "ifier.jedd:57,46-53"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer storeOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V2.v(), FD.v(), C2.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V1> storeOu" +
                                               "t = jedd.internal.Jedd.v().falseBDD(); at BDDMethodPAGContex" +
                                               "tifier.jedd:58,46-54"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer allocOut =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                              new jedd.PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdd" +
                                               "domains.CH1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple" +
                                               ".paddle.bdddomains.H1, soot.jimple.paddle.bdddomains.A_varc:" +
                                               "soot.jimple.paddle.bdddomains.C1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_var:soot.jimple.paddle.bdddomains.V1> allocOut = jedd." +
                                               "internal.Jedd.v().falseBDD(); at BDDMethodPAGContextifier.je" +
                                               "dd:59,39-47"),
                                              jedd.internal.Jedd.v().falseBDD());
        final jedd.internal.RelationContainer newSimple =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_src.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_dst:soot.jimple.p" +
                                               "addle.bdddomains.V2> newSimple = simple.get(); at BDDMethodP" +
                                               "AGContextifier.jedd:61,23-32"),
                                              simple.get());
        csimple.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_src.v(), A_dst.v(), A_srcc.v(), A_dstc.v() },
                                                        new jedd.PhysicalDomain[] { V1.v(), V2.v(), C1.v(), C2.v() },
                                                        ("csimple.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v" +
                                                         "().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().r" +
                                                         "ead(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(" +
                                                         "newSimple), jedd.internal.Jedd.v().replace(ni.globalSet(), n" +
                                                         "ew jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...]), " +
                                                         "new jedd.PhysicalDomain[...])), ni.globalSet(), new jedd.Phy" +
                                                         "sicalDomain[...])), jedd.internal.Jedd.v().literal(new java." +
                                                         "lang.Object[...], new jedd.Attribute[...], new jedd.Physical" +
                                                         "Domain[...]), new jedd.PhysicalDomain[...])) at BDDMethodPAG" +
                                                         "Contextifier.jedd:62,8-15"),
                                                        jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newSimple),
                                                                                                                                                                                                    jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                                                                                                                                                   new jedd.PhysicalDomain[] { V2.v() },
                                                                                                                                                                                                                                   new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                                                                                                                    new jedd.PhysicalDomain[] { V1.v() })),
                                                                                                                                            ni.globalSet(),
                                                                                                                                            new jedd.PhysicalDomain[] { V2.v() })),
                                                                                    jedd.internal.Jedd.v().literal(new Object[] { null, null },
                                                                                                                   new jedd.Attribute[] { A_srcc.v(), A_dstc.v() },
                                                                                                                   new jedd.PhysicalDomain[] { C1.v(), C2.v() }),
                                                                                    new jedd.PhysicalDomain[] {  })));
        mpagSimple.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newSimple),
                                                       ni.localMap(),
                                                       new jedd.PhysicalDomain[] { V1.v() }));
        mpagSimple.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newSimple),
                                                       jedd.internal.Jedd.v().replace(ni.localMap(),
                                                                                      new jedd.PhysicalDomain[] { V1.v() },
                                                                                      new jedd.PhysicalDomain[] { V2.v() }),
                                                       new jedd.PhysicalDomain[] { V2.v() }));
        final jedd.internal.RelationContainer newStore =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_src.v(), A_fld.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { V2.v(), FD.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V2, soot.jimple.paddle.bdddomains.A_fld:soot.jimple.p" +
                                               "addle.bdddomains.FD, soot.jimple.paddle.bdddomains.A_dst:soo" +
                                               "t.jimple.paddle.bdddomains.V1> newStore = jedd.internal.Jedd" +
                                               ".v().replace(store.get(), new jedd.PhysicalDomain[...], new " +
                                               "jedd.PhysicalDomain[...]); at BDDMethodPAGContextifier.jedd:" +
                                               "69,30-38"),
                                              jedd.internal.Jedd.v().replace(store.get(),
                                                                             new jedd.PhysicalDomain[] { V1.v(), V2.v() },
                                                                             new jedd.PhysicalDomain[] { V2.v(), V1.v() }));
        cstore.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_fld.v(), A_src.v(), A_dst.v(), A_srcc.v(), A_dstc.v() },
                                                       new jedd.PhysicalDomain[] { FD.v(), V1.v(), V2.v(), C1.v(), C2.v() },
                                                       ("cstore.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v(" +
                                                        ").read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().re" +
                                                        "ad(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(j" +
                                                        "edd.internal.Jedd.v().replace(newStore, new jedd.PhysicalDom" +
                                                        "ain[...], new jedd.PhysicalDomain[...])), jedd.internal.Jedd" +
                                                        ".v().replace(ni.globalSet(), new jedd.PhysicalDomain[...], n" +
                                                        "ew jedd.PhysicalDomain[...]), new jedd.PhysicalDomain[...]))" +
                                                        ", ni.globalSet(), new jedd.PhysicalDomain[...])), jedd.inter" +
                                                        "nal.Jedd.v().literal(new java.lang.Object[...], new jedd.Att" +
                                                        "ribute[...], new jedd.PhysicalDomain[...]), new jedd.Physica" +
                                                        "lDomain[...])) at BDDMethodPAGContextifier.jedd:70,8-14"),
                                                       jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(newStore,
                                                                                                                                                                                                                                                              new jedd.PhysicalDomain[] { V2.v(), V1.v() },
                                                                                                                                                                                                                                                              new jedd.PhysicalDomain[] { V1.v(), V2.v() })),
                                                                                                                                                                                                   jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                                                                                                                                                  new jedd.PhysicalDomain[] { V2.v() },
                                                                                                                                                                                                                                  new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                                                                                                                   new jedd.PhysicalDomain[] { V1.v() })),
                                                                                                                                           ni.globalSet(),
                                                                                                                                           new jedd.PhysicalDomain[] { V2.v() })),
                                                                                   jedd.internal.Jedd.v().literal(new Object[] { null, null },
                                                                                                                  new jedd.Attribute[] { A_srcc.v(), A_dstc.v() },
                                                                                                                  new jedd.PhysicalDomain[] { C1.v(), C2.v() }),
                                                                                   new jedd.PhysicalDomain[] {  })));
        mpagStore.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newStore),
                                                      jedd.internal.Jedd.v().replace(ni.localMap(),
                                                                                     new jedd.PhysicalDomain[] { V1.v() },
                                                                                     new jedd.PhysicalDomain[] { V2.v() }),
                                                      new jedd.PhysicalDomain[] { V2.v() }));
        mpagStore.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newStore),
                                                      ni.localMap(),
                                                      new jedd.PhysicalDomain[] { V1.v() }));
        final jedd.internal.RelationContainer newLoad =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_src.v(), A_fld.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), FD.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_src:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_fld:soot.jimple.p" +
                                               "addle.bdddomains.FD, soot.jimple.paddle.bdddomains.A_dst:soo" +
                                               "t.jimple.paddle.bdddomains.V2> newLoad = load.get(); at BDDM" +
                                               "ethodPAGContextifier.jedd:77,30-37"),
                                              load.get());
        cload.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_fld.v(), A_src.v(), A_dst.v(), A_srcc.v(), A_dstc.v() },
                                                      new jedd.PhysicalDomain[] { FD.v(), V1.v(), V2.v(), C1.v(), C2.v() },
                                                      ("cload.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v()" +
                                                       ".read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().rea" +
                                                       "d(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(ne" +
                                                       "wLoad), jedd.internal.Jedd.v().replace(ni.globalSet(), new j" +
                                                       "edd.PhysicalDomain[...], new jedd.PhysicalDomain[...]), new " +
                                                       "jedd.PhysicalDomain[...])), ni.globalSet(), new jedd.Physica" +
                                                       "lDomain[...])), jedd.internal.Jedd.v().literal(new java.lang" +
                                                       ".Object[...], new jedd.Attribute[...], new jedd.PhysicalDoma" +
                                                       "in[...]), new jedd.PhysicalDomain[...])) at BDDMethodPAGCont" +
                                                       "extifier.jedd:78,8-13"),
                                                      jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newLoad),
                                                                                                                                                                                                  jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                                                                                                                                                 new jedd.PhysicalDomain[] { V2.v() },
                                                                                                                                                                                                                                 new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                                                                                                                  new jedd.PhysicalDomain[] { V1.v() })),
                                                                                                                                          ni.globalSet(),
                                                                                                                                          new jedd.PhysicalDomain[] { V2.v() })),
                                                                                  jedd.internal.Jedd.v().literal(new Object[] { null, null },
                                                                                                                 new jedd.Attribute[] { A_srcc.v(), A_dstc.v() },
                                                                                                                 new jedd.PhysicalDomain[] { C1.v(), C2.v() }),
                                                                                  new jedd.PhysicalDomain[] {  })));
        mpagLoad.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newLoad),
                                                     ni.localMap(),
                                                     new jedd.PhysicalDomain[] { V1.v() }));
        mpagLoad.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newLoad),
                                                     jedd.internal.Jedd.v().replace(ni.localMap(),
                                                                                    new jedd.PhysicalDomain[] { V1.v() },
                                                                                    new jedd.PhysicalDomain[] { V2.v() }),
                                                     new jedd.PhysicalDomain[] { V2.v() }));
        final jedd.internal.RelationContainer newAlloc =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple.p" +
                                               "addle.bdddomains.H1> newAlloc = alloc.get(); at BDDMethodPAG" +
                                               "Contextifier.jedd:85,23-31"),
                                              alloc.get());
        final jedd.internal.RelationContainer globalallocSet =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                              new jedd.PhysicalDomain[] { H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1> globalallocSet = jedd.internal.Jedd.v().replace(n" +
                                               "i.globalallocSet(), new jedd.PhysicalDomain[...], new jedd.P" +
                                               "hysicalDomain[...]); at BDDMethodPAGContextifier.jedd:86,16-" +
                                               "30"),
                                              jedd.internal.Jedd.v().replace(ni.globalallocSet(),
                                                                             new jedd.PhysicalDomain[] { H2.v() },
                                                                             new jedd.PhysicalDomain[] { H1.v() }));
        if (!contextHeap)
            globalallocSet.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(ni.localallocMap(),
                                                                                                 new jedd.PhysicalDomain[] { MS.v() }),
                                                                  new jedd.PhysicalDomain[] { H2.v() },
                                                                  new jedd.PhysicalDomain[] { H1.v() }));
        calloc.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_objc.v(), A_varc.v() },
                                                       new jedd.PhysicalDomain[] { V1.v(), H1.v(), CH1.v(), C1.v() },
                                                       ("calloc.add(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v(" +
                                                        ").read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().re" +
                                                        "ad(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(n" +
                                                        "ewAlloc), jedd.internal.Jedd.v().replace(ni.globalSet(), new" +
                                                        " jedd.PhysicalDomain[...], new jedd.PhysicalDomain[...]), ne" +
                                                        "w jedd.PhysicalDomain[...])), globalallocSet, new jedd.Physi" +
                                                        "calDomain[...])), jedd.internal.Jedd.v().literal(new java.la" +
                                                        "ng.Object[...], new jedd.Attribute[...], new jedd.PhysicalDo" +
                                                        "main[...]), new jedd.PhysicalDomain[...])) at BDDMethodPAGCo" +
                                                        "ntextifier.jedd:88,8-14"),
                                                       jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(newAlloc),
                                                                                                                                                                                                   jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                                                                                                                                                  new jedd.PhysicalDomain[] { V2.v() },
                                                                                                                                                                                                                                  new jedd.PhysicalDomain[] { V1.v() }),
                                                                                                                                                                                                   new jedd.PhysicalDomain[] { V1.v() })),
                                                                                                                                           globalallocSet,
                                                                                                                                           new jedd.PhysicalDomain[] { H1.v() })),
                                                                                   jedd.internal.Jedd.v().literal(new Object[] { null, null },
                                                                                                                  new jedd.Attribute[] { A_varc.v(), A_objc.v() },
                                                                                                                  new jedd.PhysicalDomain[] { C1.v(), CH1.v() }),
                                                                                   new jedd.PhysicalDomain[] {  })));
        mpagAlloc.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(newAlloc,
                                                                                                                 new jedd.PhysicalDomain[] { H1.v() },
                                                                                                                 new jedd.PhysicalDomain[] { H2.v() })),
                                                      ni.localMap(),
                                                      new jedd.PhysicalDomain[] { V1.v() }));
        if (contextHeap) {
            mpagAlloc.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(newAlloc,
                                                                                                                     new jedd.PhysicalDomain[] { H1.v() },
                                                                                                                     new jedd.PhysicalDomain[] { H2.v() })),
                                                          ni.localallocMap(),
                                                          new jedd.PhysicalDomain[] { H2.v() }));
        }
        final jedd.internal.RelationContainer localSet =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v() },
                                              new jedd.PhysicalDomain[] { V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1> localSet = jedd.internal.Jedd.v().project(ni.loca" +
                                               "lMap(), new jedd.PhysicalDomain[...]); at BDDMethodPAGContex" +
                                               "tifier.jedd:97,16-24"),
                                              jedd.internal.Jedd.v().project(ni.localMap(),
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        final jedd.internal.RelationContainer contexts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_method.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), MS.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_method:soot.jimp" +
                                               "le.paddle.bdddomains.MS> contexts = rcout.get(); at BDDMetho" +
                                               "dPAGContextifier.jedd:99,30-38"),
                                              rcout.get());
        final jedd.internal.RelationContainer ctxtSimple =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_src.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dst:so" +
                                               "ot.jimple.paddle.bdddomains.V2> ctxtSimple = jedd.internal.J" +
                                               "edd.v().compose(jedd.internal.Jedd.v().read(contexts), mpagS" +
                                               "imple, new jedd.PhysicalDomain[...]); at BDDMethodPAGContext" +
                                               "ifier.jedd:101,34-44"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(contexts),
                                                                             mpagSimple,
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        simpleOut.eqUnion(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(ctxtSimple,
                                                                                     new jedd.PhysicalDomain[] { C1.v() },
                                                                                     new jedd.PhysicalDomain[] { C2.v() }),
                                                      new jedd.PhysicalDomain[] { C2.v() },
                                                      new jedd.Attribute[] { A_ctxt.v() },
                                                      new jedd.PhysicalDomain[] { C1.v() }));
        final jedd.internal.RelationContainer ctxtStore =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_src.v(), A_fld.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V2.v(), FD.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dst:soot.jimple.paddle.bdddomains.V1> ctxtStore = jedd.i" +
                                               "nternal.Jedd.v().compose(jedd.internal.Jedd.v().read(context" +
                                               "s), mpagStore, new jedd.PhysicalDomain[...]); at BDDMethodPA" +
                                               "GContextifier.jedd:104,41-50"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(contexts),
                                                                             mpagStore,
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        storeOut.eqUnion(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(ctxtStore,
                                                                                    new jedd.PhysicalDomain[] { C1.v() },
                                                                                    new jedd.PhysicalDomain[] { C2.v() }),
                                                     new jedd.PhysicalDomain[] { C2.v() },
                                                     new jedd.Attribute[] { A_ctxt.v() },
                                                     new jedd.PhysicalDomain[] { C1.v() }));
        final jedd.internal.RelationContainer ctxtLoad =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_src.v(), A_fld.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), FD.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dst:soot.jimple.paddle.bdddomains.V2> ctxtLoad = jedd.in" +
                                               "ternal.Jedd.v().compose(jedd.internal.Jedd.v().read(contexts" +
                                               "), mpagLoad, new jedd.PhysicalDomain[...]); at BDDMethodPAGC" +
                                               "ontextifier.jedd:107,41-49"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(contexts),
                                                                             mpagLoad,
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        loadOut.eqUnion(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(ctxtLoad,
                                                                                   new jedd.PhysicalDomain[] { C1.v() },
                                                                                   new jedd.PhysicalDomain[] { C2.v() }),
                                                    new jedd.PhysicalDomain[] { C2.v() },
                                                    new jedd.Attribute[] { A_ctxt.v() },
                                                    new jedd.PhysicalDomain[] { C1.v() }));
        final jedd.internal.RelationContainer ctxtAlloc =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_ctxt.v(), A_var.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), H2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_ctxt:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_var:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_obj:so" +
                                               "ot.jimple.paddle.bdddomains.H2> ctxtAlloc = jedd.internal.Je" +
                                               "dd.v().compose(jedd.internal.Jedd.v().read(contexts), mpagAl" +
                                               "loc, new jedd.PhysicalDomain[...]); at BDDMethodPAGContextif" +
                                               "ier.jedd:110,34-43"),
                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(contexts),
                                                                             mpagAlloc,
                                                                             new jedd.PhysicalDomain[] { MS.v() }));
        if (contextHeap) {
            allocOut.eqUnion(jedd.internal.Jedd.v().copy(jedd.internal.Jedd.v().replace(ctxtAlloc,
                                                                                        new jedd.PhysicalDomain[] { H2.v(), C1.v() },
                                                                                        new jedd.PhysicalDomain[] { H1.v(), CH1.v() }),
                                                         new jedd.PhysicalDomain[] { CH1.v() },
                                                         new jedd.Attribute[] { A_ctxt.v() },
                                                         new jedd.PhysicalDomain[] { C1.v() }));
        } else {
            allocOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(ctxtAlloc,
                                                                                                                    new jedd.PhysicalDomain[] { H2.v() },
                                                                                                                    new jedd.PhysicalDomain[] { H1.v() })),
                                                         jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                        new jedd.Attribute[] { A_objc.v() },
                                                                                        new jedd.PhysicalDomain[] { CH1.v() }),
                                                         new jedd.PhysicalDomain[] {  }));
        }
        final jedd.internal.RelationContainer globalDsts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> globalDsts = jedd" +
                                               ".internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOu" +
                                               "t), ni.globalSet(), new jedd.PhysicalDomain[...]); at BDDMet" +
                                               "hodPAGContextifier.jedd:117,39-49"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOut),
                                                                          ni.globalSet(),
                                                                          new jedd.PhysicalDomain[] { V2.v() }));
        simpleOut.eqMinus(globalDsts);
        simpleOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalDsts,
                                                                                                                 new jedd.PhysicalDomain[] { C2.v() })),
                                                      jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                     new jedd.Attribute[] { A_dstc.v() },
                                                                                     new jedd.PhysicalDomain[] { C2.v() }),
                                                      new jedd.PhysicalDomain[] {  }));
        final jedd.internal.RelationContainer globalSrcs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_dstc:s" +
                                               "oot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddomai" +
                                               "ns.A_dst:soot.jimple.paddle.bdddomains.V2> globalSrcs = jedd" +
                                               ".internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOu" +
                                               "t), jedd.internal.Jedd.v().replace(ni.globalSet(), new jedd." +
                                               "PhysicalDomain[...], new jedd.PhysicalDomain[...]), new jedd" +
                                               ".PhysicalDomain[...]); at BDDMethodPAGContextifier.jedd:120," +
                                               "39-49"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(simpleOut),
                                                                          jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                         new jedd.PhysicalDomain[] { V2.v() },
                                                                                                         new jedd.PhysicalDomain[] { V1.v() }),
                                                                          new jedd.PhysicalDomain[] { V1.v() }));
        simpleOut.eqMinus(globalSrcs);
        simpleOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalSrcs,
                                                                                                                 new jedd.PhysicalDomain[] { C1.v() })),
                                                      jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                     new jedd.Attribute[] { A_srcc.v() },
                                                                                     new jedd.PhysicalDomain[] { C1.v() }),
                                                      new jedd.PhysicalDomain[] {  }));
        csimple.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                        new jedd.PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                        ("csimple.add(simpleOut) at BDDMethodPAGContextifier.jedd:123," +
                                                         "8-15"),
                                                        simpleOut));
        final jedd.internal.RelationContainer globalStoreDsts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V2.v(), FD.v(), C2.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V1> globalS" +
                                               "toreDsts = jedd.internal.Jedd.v().join(jedd.internal.Jedd.v(" +
                                               ").read(storeOut), jedd.internal.Jedd.v().replace(ni.globalSe" +
                                               "t(), new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[." +
                                               "..]), new jedd.PhysicalDomain[...]); at BDDMethodPAGContexti" +
                                               "fier.jedd:125,46-61"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(storeOut),
                                                                          jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                         new jedd.PhysicalDomain[] { V2.v() },
                                                                                                         new jedd.PhysicalDomain[] { V1.v() }),
                                                                          new jedd.PhysicalDomain[] { V1.v() }));
        storeOut.eqMinus(globalStoreDsts);
        storeOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalStoreDsts,
                                                                                                                new jedd.PhysicalDomain[] { C2.v() })),
                                                     jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                    new jedd.Attribute[] { A_dstc.v() },
                                                                                    new jedd.PhysicalDomain[] { C2.v() }),
                                                     new jedd.PhysicalDomain[] {  }));
        final jedd.internal.RelationContainer globalStoreSrcs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V2.v(), FD.v(), C2.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V2, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V1> globalS" +
                                               "toreSrcs = jedd.internal.Jedd.v().join(jedd.internal.Jedd.v(" +
                                               ").read(storeOut), ni.globalSet(), new jedd.PhysicalDomain[.." +
                                               ".]); at BDDMethodPAGContextifier.jedd:128,46-61"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(storeOut),
                                                                          ni.globalSet(),
                                                                          new jedd.PhysicalDomain[] { V2.v() }));
        storeOut.eqMinus(globalStoreSrcs);
        storeOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalStoreSrcs,
                                                                                                                new jedd.PhysicalDomain[] { C1.v() })),
                                                     jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                    new jedd.Attribute[] { A_srcc.v() },
                                                                                    new jedd.PhysicalDomain[] { C1.v() }),
                                                     new jedd.PhysicalDomain[] {  }));
        cstore.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                       new jedd.PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                       ("cstore.add(jedd.internal.Jedd.v().replace(storeOut, new jedd" +
                                                        ".PhysicalDomain[...], new jedd.PhysicalDomain[...])) at BDDM" +
                                                        "ethodPAGContextifier.jedd:131,8-14"),
                                                       jedd.internal.Jedd.v().replace(storeOut,
                                                                                      new jedd.PhysicalDomain[] { V2.v(), V1.v() },
                                                                                      new jedd.PhysicalDomain[] { V1.v(), V2.v() })));
        final jedd.internal.RelationContainer globalLoadDsts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V2> globalL" +
                                               "oadDsts = jedd.internal.Jedd.v().join(jedd.internal.Jedd.v()" +
                                               ".read(loadOut), ni.globalSet(), new jedd.PhysicalDomain[...]" +
                                               "); at BDDMethodPAGContextifier.jedd:133,46-60"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(loadOut),
                                                                          ni.globalSet(),
                                                                          new jedd.PhysicalDomain[] { V2.v() }));
        loadOut.eqMinus(globalLoadDsts);
        loadOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalLoadDsts,
                                                                                                               new jedd.PhysicalDomain[] { C2.v() })),
                                                    jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                   new jedd.Attribute[] { A_dstc.v() },
                                                                                   new jedd.PhysicalDomain[] { C2.v() }),
                                                    new jedd.PhysicalDomain[] {  }));
        final jedd.internal.RelationContainer globalLoadSrcs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                              new jedd.PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.C1, soot.jimple.paddle.bdddomains.A_src:soot.jimple." +
                                               "paddle.bdddomains.V1, soot.jimple.paddle.bdddomains.A_fld:so" +
                                               "ot.jimple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomain" +
                                               "s.A_dstc:soot.jimple.paddle.bdddomains.C2, soot.jimple.paddl" +
                                               "e.bdddomains.A_dst:soot.jimple.paddle.bdddomains.V2> globalL" +
                                               "oadSrcs = jedd.internal.Jedd.v().join(jedd.internal.Jedd.v()" +
                                               ".read(loadOut), jedd.internal.Jedd.v().replace(ni.globalSet(" +
                                               "), new jedd.PhysicalDomain[...], new jedd.PhysicalDomain[..." +
                                               "]), new jedd.PhysicalDomain[...]); at BDDMethodPAGContextifi" +
                                               "er.jedd:136,46-60"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(loadOut),
                                                                          jedd.internal.Jedd.v().replace(ni.globalSet(),
                                                                                                         new jedd.PhysicalDomain[] { V2.v() },
                                                                                                         new jedd.PhysicalDomain[] { V1.v() }),
                                                                          new jedd.PhysicalDomain[] { V1.v() }));
        loadOut.eqMinus(globalLoadSrcs);
        loadOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalLoadSrcs,
                                                                                                               new jedd.PhysicalDomain[] { C1.v() })),
                                                    jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                   new jedd.Attribute[] { A_srcc.v() },
                                                                                   new jedd.PhysicalDomain[] { C1.v() }),
                                                    new jedd.PhysicalDomain[] {  }));
        cload.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                      new jedd.PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                      "cload.add(loadOut) at BDDMethodPAGContextifier.jedd:139,8-13",
                                                      loadOut));
        final jedd.internal.RelationContainer globalAllocDsts =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                              new jedd.PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdd" +
                                               "domains.CH1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple" +
                                               ".paddle.bdddomains.H1, soot.jimple.paddle.bdddomains.A_varc:" +
                                               "soot.jimple.paddle.bdddomains.C1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_var:soot.jimple.paddle.bdddomains.V2> globalAllocDsts " +
                                               "= jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(je" +
                                               "dd.internal.Jedd.v().replace(allocOut, new jedd.PhysicalDoma" +
                                               "in[...], new jedd.PhysicalDomain[...])), ni.globalSet(), new" +
                                               " jedd.PhysicalDomain[...]); at BDDMethodPAGContextifier.jedd" +
                                               ":141,39-54"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(allocOut,
                                                                                                                                     new jedd.PhysicalDomain[] { V1.v() },
                                                                                                                                     new jedd.PhysicalDomain[] { V2.v() })),
                                                                          ni.globalSet(),
                                                                          new jedd.PhysicalDomain[] { V2.v() }));
        allocOut.eqMinus(jedd.internal.Jedd.v().replace(globalAllocDsts,
                                                        new jedd.PhysicalDomain[] { V2.v() },
                                                        new jedd.PhysicalDomain[] { V1.v() }));
        allocOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(globalAllocDsts,
                                                                                                                                               new jedd.PhysicalDomain[] { C1.v() }),
                                                                                                                new jedd.PhysicalDomain[] { V2.v() },
                                                                                                                new jedd.PhysicalDomain[] { V1.v() })),
                                                     jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                    new jedd.Attribute[] { A_varc.v() },
                                                                                    new jedd.PhysicalDomain[] { C1.v() }),
                                                     new jedd.PhysicalDomain[] {  }));
        final jedd.internal.RelationContainer globalAllocSrcs =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                              new jedd.PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_objc:soot.jimple.paddle.bdd" +
                                               "domains.CH1, soot.jimple.paddle.bdddomains.A_obj:soot.jimple" +
                                               ".paddle.bdddomains.H1, soot.jimple.paddle.bdddomains.A_varc:" +
                                               "soot.jimple.paddle.bdddomains.C1, soot.jimple.paddle.bdddoma" +
                                               "ins.A_var:soot.jimple.paddle.bdddomains.V1> globalAllocSrcs " +
                                               "= jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(al" +
                                               "locOut), globalallocSet, new jedd.PhysicalDomain[...]); at B" +
                                               "DDMethodPAGContextifier.jedd:144,39-54"),
                                              jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(allocOut),
                                                                          globalallocSet,
                                                                          new jedd.PhysicalDomain[] { H1.v() }));
        allocOut.eqMinus(globalAllocSrcs);
        allocOut.eqUnion(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(globalAllocSrcs,
                                                                                                                new jedd.PhysicalDomain[] { CH1.v() })),
                                                     jedd.internal.Jedd.v().literal(new Object[] { null },
                                                                                    new jedd.Attribute[] { A_objc.v() },
                                                                                    new jedd.PhysicalDomain[] { CH1.v() }),
                                                     new jedd.PhysicalDomain[] {  }));
        calloc.add(new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                       new jedd.PhysicalDomain[] { V1.v(), H1.v(), C1.v(), CH1.v() },
                                                       ("calloc.add(allocOut) at BDDMethodPAGContextifier.jedd:147,8-" +
                                                        "14"),
                                                       allocOut));
        return false;
    }
    
    private final jedd.internal.RelationContainer mpagSimple =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_src.v(), A_dst.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), V1.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method, soot.jimple" +
                                           ".paddle.bdddomains.A_src, soot.jimple.paddle.bdddomains.A_ds" +
                                           "t> mpagSimple = jedd.internal.Jedd.v().falseBDD() at BDDMeth" +
                                           "odPAGContextifier.jedd:151,12-36"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer mpagStore =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_src.v(), A_fld.v(), A_dst.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), V2.v(), FD.v(), V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method, soot.jimple" +
                                           ".paddle.bdddomains.A_src, soot.jimple.paddle.bdddomains.A_fl" +
                                           "d, soot.jimple.paddle.bdddomains.A_dst> mpagStore = jedd.int" +
                                           "ernal.Jedd.v().falseBDD() at BDDMethodPAGContextifier.jedd:1" +
                                           "52,12-43"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer mpagLoad =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_src.v(), A_fld.v(), A_dst.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), V1.v(), FD.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method, soot.jimple" +
                                           ".paddle.bdddomains.A_src, soot.jimple.paddle.bdddomains.A_fl" +
                                           "d, soot.jimple.paddle.bdddomains.A_dst> mpagLoad = jedd.inte" +
                                           "rnal.Jedd.v().falseBDD() at BDDMethodPAGContextifier.jedd:15" +
                                           "3,12-43"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer mpagAlloc =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_method.v(), A_var.v(), A_obj.v() },
                                          new jedd.PhysicalDomain[] { MS.v(), V1.v(), H2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_method, soot.jimple" +
                                           ".paddle.bdddomains.A_var, soot.jimple.paddle.bdddomains.A_ob" +
                                           "j> mpagAlloc = jedd.internal.Jedd.v().falseBDD() at BDDMetho" +
                                           "dPAGContextifier.jedd:154,12-36"),
                                          jedd.internal.Jedd.v().falseBDD());
}
