package soot.jimple.paddle;

import soot.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;
import jedd.*;

public class BDDPAG extends AbsPAG {
    BDDPAG(Rsrcc_src_dstc_dst simple,
           Rsrcc_src_fld_dstc_dst load,
           Rsrcc_src_dstc_dst_fld store,
           Robjc_obj_varc_var alloc) {
        super(simple,
              load,
              store,
              alloc);
    }
    
    public boolean update() {
        boolean ret =
          false;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(simpleBDD),
                                           simpleBDD.eqUnion(simple.get())))
            ret =
              true;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(allocBDD),
                                           allocBDD.eqUnion(jedd.internal.Jedd.v().replace(alloc.get(),
                                                                                           new PhysicalDomain[] { C1.v() },
                                                                                           new PhysicalDomain[] { C2.v() }))))
            ret =
              true;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(loadBDD),
                                           loadBDD.eqUnion(load.get())))
            ret =
              true;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(storeBDD),
                                           storeBDD.eqUnion(jedd.internal.Jedd.v().replace(store.get(),
                                                                                           new PhysicalDomain[] { C1.v(), C2.v() },
                                                                                           new PhysicalDomain[] { C2.v(), C1.v() }))))
            ret =
              true;
        return ret;
    }
    
    public Iterator simpleSources() {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v() },
                                                                              new PhysicalDomain[] { C2.v(), V1.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:46,15-18"),
                                                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(simpleBDD,
                                                                                                                                            new PhysicalDomain[] { C2.v(), V2.v() }),
                                                                                                             new PhysicalDomain[] { C1.v() },
                                                                                                             new PhysicalDomain[] { C2.v() })));
    }
    
    public Iterator loadSources() {
        return new FieldRefIterator(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_varc.v(), A_var.v() },
                                                                        new PhysicalDomain[] { FD.v(), C1.v(), V1.v() },
                                                                        ("new soot.jimple.paddle.BDDPAG.FieldRefIterator(...) at BDDPA" +
                                                                         "G.jedd:49,15-18"),
                                                                        jedd.internal.Jedd.v().project(loadBDD,
                                                                                                       new PhysicalDomain[] { C2.v(), V2.v() })));
    }
    
    public Iterator storeSources() {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v() },
                                                                              new PhysicalDomain[] { C2.v(), V1.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:52,15-18"),
                                                                              jedd.internal.Jedd.v().project(storeBDD,
                                                                                                             new PhysicalDomain[] { FD.v(), C1.v(), V2.v() })));
    }
    
    public Iterator allocSources() {
        return new ContextAllocNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v() },
                                                                                new PhysicalDomain[] { H1.v(), CH1.v() },
                                                                                ("new soot.jimple.paddle.BDDPAG.ContextAllocNodeIterator(...) " +
                                                                                 "at BDDPAG.jedd:55,15-18"),
                                                                                jedd.internal.Jedd.v().project(allocBDD,
                                                                                                               new PhysicalDomain[] { V1.v(), C2.v() })));
    }
    
    public Iterator simpleInvSources() {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v() },
                                                                              new PhysicalDomain[] { C2.v(), V1.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:58,15-18"),
                                                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(simpleBDD,
                                                                                                                                            new PhysicalDomain[] { C1.v(), V1.v() }),
                                                                                                             new PhysicalDomain[] { V2.v() },
                                                                                                             new PhysicalDomain[] { V1.v() })));
    }
    
    public Iterator loadInvSources() {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v() },
                                                                              new PhysicalDomain[] { C2.v(), V1.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:61,15-18"),
                                                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(loadBDD,
                                                                                                                                            new PhysicalDomain[] { FD.v(), C1.v(), V1.v() }),
                                                                                                             new PhysicalDomain[] { V2.v() },
                                                                                                             new PhysicalDomain[] { V1.v() })));
    }
    
    public Iterator storeInvSources() {
        return new FieldRefIterator(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_varc.v(), A_var.v() },
                                                                        new PhysicalDomain[] { FD.v(), C1.v(), V1.v() },
                                                                        ("new soot.jimple.paddle.BDDPAG.FieldRefIterator(...) at BDDPA" +
                                                                         "G.jedd:64,15-18"),
                                                                        jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(storeBDD,
                                                                                                                                      new PhysicalDomain[] { C2.v(), V1.v() }),
                                                                                                       new PhysicalDomain[] { V2.v() },
                                                                                                       new PhysicalDomain[] { V1.v() })));
    }
    
    public Iterator allocInvSources() {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                                              new PhysicalDomain[] { V1.v(), C2.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:67,15-18"),
                                                                              jedd.internal.Jedd.v().project(allocBDD,
                                                                                                             new PhysicalDomain[] { H1.v(), CH1.v() })));
    }
    
    public Iterator simpleLookup(Context ctxt,
                                 VarNode key) {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                                              new PhysicalDomain[] { V1.v(), C2.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:71,15-18"),
                                                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(simpleBDD),
                                                                                                                                            jedd.internal.Jedd.v().literal(new Object[] { ctxt, key },
                                                                                                                                                                           new Attribute[] { A_srcc.v(), A_src.v() },
                                                                                                                                                                           new PhysicalDomain[] { C1.v(), V1.v() }),
                                                                                                                                            new PhysicalDomain[] { C1.v(), V1.v() }),
                                                                                                             new PhysicalDomain[] { V2.v() },
                                                                                                             new PhysicalDomain[] { V1.v() })));
    }
    
    public Iterator loadLookup(Context ctxt,
                               FieldRefNode key) {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                                              new PhysicalDomain[] { V1.v(), C2.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:76,15-18"),
                                                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(loadBDD),
                                                                                                                                            jedd.internal.Jedd.v().literal(new Object[] { ctxt, key.base(), key.field() },
                                                                                                                                                                           new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v() },
                                                                                                                                                                           new PhysicalDomain[] { C1.v(), V1.v(), FD.v() }),
                                                                                                                                            new PhysicalDomain[] { C1.v(), V1.v(), FD.v() }),
                                                                                                             new PhysicalDomain[] { V2.v() },
                                                                                                             new PhysicalDomain[] { V1.v() })));
    }
    
    public Iterator storeLookup(Context ctxt,
                                VarNode key) {
        return new FieldRefIterator(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_varc.v(), A_var.v() },
                                                                        new PhysicalDomain[] { FD.v(), C1.v(), V1.v() },
                                                                        ("new soot.jimple.paddle.BDDPAG.FieldRefIterator(...) at BDDPA" +
                                                                         "G.jedd:81,15-18"),
                                                                        jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(storeBDD),
                                                                                                                                      jedd.internal.Jedd.v().literal(new Object[] { ctxt, key },
                                                                                                                                                                     new Attribute[] { A_srcc.v(), A_src.v() },
                                                                                                                                                                     new PhysicalDomain[] { C2.v(), V1.v() }),
                                                                                                                                      new PhysicalDomain[] { C2.v(), V1.v() }),
                                                                                                       new PhysicalDomain[] { V2.v() },
                                                                                                       new PhysicalDomain[] { V1.v() })));
    }
    
    public Iterator allocLookup(Context ctxt,
                                AllocNode key) {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                                              new PhysicalDomain[] { V1.v(), C2.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:85,15-18"),
                                                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(allocBDD),
                                                                                                             jedd.internal.Jedd.v().literal(new Object[] { ctxt, key },
                                                                                                                                            new Attribute[] { A_objc.v(), A_obj.v() },
                                                                                                                                            new PhysicalDomain[] { CH1.v(), H1.v() }),
                                                                                                             new PhysicalDomain[] { CH1.v(), H1.v() })));
    }
    
    public Iterator simpleInvLookup(Context ctxt,
                                    VarNode key) {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                                              new PhysicalDomain[] { V1.v(), C2.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:89,15-18"),
                                                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(simpleBDD),
                                                                                                                                            jedd.internal.Jedd.v().literal(new Object[] { ctxt, key },
                                                                                                                                                                           new Attribute[] { A_dstc.v(), A_dst.v() },
                                                                                                                                                                           new PhysicalDomain[] { C2.v(), V2.v() }),
                                                                                                                                            new PhysicalDomain[] { C2.v(), V2.v() }),
                                                                                                             new PhysicalDomain[] { C1.v() },
                                                                                                             new PhysicalDomain[] { C2.v() })));
    }
    
    public Iterator loadInvLookup(Context ctxt,
                                  VarNode key) {
        return new FieldRefIterator(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_varc.v(), A_var.v() },
                                                                        new PhysicalDomain[] { FD.v(), C1.v(), V1.v() },
                                                                        ("new soot.jimple.paddle.BDDPAG.FieldRefIterator(...) at BDDPA" +
                                                                         "G.jedd:94,15-18"),
                                                                        jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(loadBDD),
                                                                                                       jedd.internal.Jedd.v().literal(new Object[] { ctxt, key },
                                                                                                                                      new Attribute[] { A_dstc.v(), A_dst.v() },
                                                                                                                                      new PhysicalDomain[] { C2.v(), V2.v() }),
                                                                                                       new PhysicalDomain[] { C2.v(), V2.v() })));
    }
    
    public Iterator storeInvLookup(Context ctxt,
                                   FieldRefNode key) {
        return new ContextVarNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                                              new PhysicalDomain[] { V1.v(), C2.v() },
                                                                              ("new soot.jimple.paddle.BDDPAG.ContextVarNodeIterator(...) at" +
                                                                               " BDDPAG.jedd:99,15-18"),
                                                                              jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(storeBDD),
                                                                                                             jedd.internal.Jedd.v().literal(new Object[] { ctxt, key.base(), key.field() },
                                                                                                                                            new Attribute[] { A_dstc.v(), A_dst.v(), A_fld.v() },
                                                                                                                                            new PhysicalDomain[] { C1.v(), V2.v(), FD.v() }),
                                                                                                             new PhysicalDomain[] { C1.v(), V2.v(), FD.v() })));
    }
    
    public Iterator allocInvLookup(Context ctxt,
                                   VarNode key) {
        return new ContextAllocNodeIterator(new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v() },
                                                                                new PhysicalDomain[] { H1.v(), CH1.v() },
                                                                                ("new soot.jimple.paddle.BDDPAG.ContextAllocNodeIterator(...) " +
                                                                                 "at BDDPAG.jedd:104,15-18"),
                                                                                jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(allocBDD),
                                                                                                               jedd.internal.Jedd.v().literal(new Object[] { ctxt, key },
                                                                                                                                              new Attribute[] { A_varc.v(), A_var.v() },
                                                                                                                                              new PhysicalDomain[] { C2.v(), V1.v() }),
                                                                                                               new PhysicalDomain[] { C2.v(), V1.v() })));
    }
    
    public Rsrcc_src_dstc_dst allSimple() {
        return new Rsrcc_src_dstc_dstBDD(new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                                             new PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                                             ("new soot.jimple.paddle.queue.Rsrcc_src_dstc_dstBDD(...) at B" +
                                                                              "DDPAG.jedd:108,51-54"),
                                                                             simpleBDD),
                                         "allsimple",
                                         null);
    }
    
    public Rsrcc_src_fld_dstc_dst allLoad() {
        return new Rsrcc_src_fld_dstc_dstBDD(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                                                 new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                                                 ("new soot.jimple.paddle.queue.Rsrcc_src_fld_dstc_dstBDD(...) " +
                                                                                  "at BDDPAG.jedd:109,53-56"),
                                                                                 loadBDD),
                                             "allload",
                                             null);
    }
    
    public Rsrcc_src_dstc_dst_fld allStore() {
        return new Rsrcc_src_dstc_dst_fldBDD(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                                                 new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                                                 ("new soot.jimple.paddle.queue.Rsrcc_src_dstc_dst_fldBDD(...) " +
                                                                                  "at BDDPAG.jedd:110,54-57"),
                                                                                 jedd.internal.Jedd.v().replace(storeBDD,
                                                                                                                new PhysicalDomain[] { C2.v(), C1.v() },
                                                                                                                new PhysicalDomain[] { C1.v(), C2.v() })),
                                             "allstore",
                                             null);
    }
    
    public Robjc_obj_varc_var allAlloc() {
        return new Robjc_obj_varc_varBDD(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                                             new PhysicalDomain[] { V1.v(), H1.v(), C1.v(), CH1.v() },
                                                                             ("new soot.jimple.paddle.queue.Robjc_obj_varc_varBDD(...) at B" +
                                                                              "DDPAG.jedd:111,50-53"),
                                                                             jedd.internal.Jedd.v().replace(allocBDD,
                                                                                                            new PhysicalDomain[] { C2.v() },
                                                                                                            new PhysicalDomain[] { C1.v() })),
                                         "allalloc",
                                         null);
    }
    
    private static class FieldRefIterator implements Iterator {
        FieldRefIterator(final jedd.internal.RelationContainer bdd) {
            super();
            this.it =
              new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_var.v(), A_varc.v() },
                                                  new PhysicalDomain[] { FD.v(), V1.v(), C1.v() },
                                                  ("bdd.iterator(new jedd.Attribute[...]) at BDDPAG.jedd:115,22-" +
                                                   "25"),
                                                  bdd).iterator(new Attribute[] { A_varc.v(), A_var.v(), A_fld.v() });
        }
        
        private Iterator it;
        
        public boolean hasNext() {
            return it.hasNext();
        }
        
        public Object next() {
            Object[] ret =
              (Object[])
                it.next();
            return ContextFieldRefNode.make((Context)
                                              ret[0],
                                            ((VarNode)
                                               ret[1]).dot((PaddleField)
                                                             ret[2]));
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    
    private static class ContextVarNodeIterator implements Iterator {
        ContextVarNodeIterator(final jedd.internal.RelationContainer bdd) {
            super();
            this.it =
              new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_varc.v() },
                                                  new PhysicalDomain[] { V1.v(), C2.v() },
                                                  ("bdd.iterator(new jedd.Attribute[...]) at BDDPAG.jedd:129,22-" +
                                                   "25"),
                                                  bdd).iterator(new Attribute[] { A_varc.v(), A_var.v() });
        }
        
        private Iterator it;
        
        public boolean hasNext() {
            return it.hasNext();
        }
        
        public Object next() {
            Object[] ret =
              (Object[])
                it.next();
            return ContextVarNode.make((Context)
                                         ret[0],
                                       (Node)
                                         ret[1]);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    
    private static class ContextAllocNodeIterator implements Iterator {
        ContextAllocNodeIterator(final jedd.internal.RelationContainer bdd) {
            super();
            this.it =
              new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_objc.v() },
                                                  new PhysicalDomain[] { H1.v(), CH1.v() },
                                                  ("bdd.iterator(new jedd.Attribute[...]) at BDDPAG.jedd:142,22-" +
                                                   "25"),
                                                  bdd).iterator(new Attribute[] { A_objc.v(), A_obj.v() });
        }
        
        private Iterator it;
        
        public boolean hasNext() {
            return it.hasNext();
        }
        
        public Object next() {
            Object[] ret =
              (Object[])
                it.next();
            return ContextAllocNode.make((Context)
                                           ret[0],
                                         (Node)
                                           ret[1]);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    
    private final jedd.internal.RelationContainer simpleBDD =
      new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v() },
                                          new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.p" +
                                           "addle.bdddomains.A_src, soot.jimple.paddle.bdddomains.A_dstc" +
                                           ", soot.jimple.paddle.bdddomains.A_dst> simpleBDD = jedd.inte" +
                                           "rnal.Jedd.v().falseBDD() at BDDPAG.jedd:153,12-42"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer loadBDD =
      new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                          new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.p" +
                                           "addle.bdddomains.A_src, soot.jimple.paddle.bdddomains.A_fld," +
                                           " soot.jimple.paddle.bdddomains.A_dstc, soot.jimple.paddle.bd" +
                                           "ddomains.A_dst> loadBDD = jedd.internal.Jedd.v().falseBDD() " +
                                           "at BDDPAG.jedd:154,12-49"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer storeBDD =
      new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                          new PhysicalDomain[] { C2.v(), V1.v(), FD.v(), C1.v(), V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.p" +
                                           "addle.bdddomains.A_src, soot.jimple.paddle.bdddomains.A_fld," +
                                           " soot.jimple.paddle.bdddomains.A_dstc, soot.jimple.paddle.bd" +
                                           "ddomains.A_dst> storeBDD = jedd.internal.Jedd.v().falseBDD()" +
                                           " at BDDPAG.jedd:155,12-49"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer allocBDD =
      new jedd.internal.RelationContainer(new Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                          new PhysicalDomain[] { CH1.v(), H1.v(), C2.v(), V1.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_objc, soot.jimple.p" +
                                           "addle.bdddomains.A_obj, soot.jimple.paddle.bdddomains.A_varc" +
                                           ", soot.jimple.paddle.bdddomains.A_var> allocBDD = jedd.inter" +
                                           "nal.Jedd.v().falseBDD() at BDDPAG.jedd:156,12-42"),
                                          jedd.internal.Jedd.v().falseBDD());
}
