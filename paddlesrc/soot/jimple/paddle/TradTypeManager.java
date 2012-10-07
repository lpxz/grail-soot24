package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class TradTypeManager extends AbsTypeManager {
    TradTypeManager(Rvar_method_type locals,
                    Rvar_type globals,
                    Robj_method_type localallocs,
                    Robj_type globalallocs) {
        super(locals,
              globals,
              localallocs,
              globalallocs);
        this.fh =
          PaddleScene.v().fh;
        newContextAllocNodes =
          PaddleNumberers.v().contextAllocNodeNumberer().iterator();
    }
    
    private Iterator newContextAllocNodes;
    
    private void handleVarType(Type type) {
        if (typeMask.get(type) !=
              null)
            return;
        BitVector bv =
          new BitVector(PaddleNumberers.v().contextAllocNodeNumberer().size());
        typeMask.put(type,
                     bv);
        for (Iterator canIt =
               PaddleNumberers.v().contextAllocNodeNumberer().iterator();
             canIt.hasNext();
             ) {
            final ContextAllocNode can =
              (ContextAllocNode)
                canIt.next();
            if (castNeverFails(can.getType(),
                               type)) {
                bv.set(can.getNumber());
                change =
                  true;
            }
        }
    }
    
    private void handleAllocNode(ContextAllocNode an,
                                 Type antype) {
        for (Iterator typeIt =
               Scene.v().getTypeNumberer().iterator();
             typeIt.hasNext();
             ) {
            final Type type =
              (Type)
                typeIt.next();
            if (!(type instanceof RefLikeType))
                continue;
            if (type instanceof AnySubType)
                continue;
            BitVector bv =
              (BitVector)
                typeMask.get(type);
            if (bv ==
                  null)
                continue;
            if (castNeverFails(antype,
                               type)) {
                bv.set(an.getNumber());
                change =
                  true;
            }
        }
    }
    
    public boolean update() {
        boolean ret =
          false;
        for (Iterator tIt =
               locals.iterator();
             tIt.hasNext();
             ) {
            final Rvar_method_type.Tuple t =
              (Rvar_method_type.Tuple)
                tIt.next();
            handleVarType(t.type());
            ret =
              true;
        }
        for (Iterator tIt =
               globals.iterator();
             tIt.hasNext();
             ) {
            final Rvar_type.Tuple t =
              (Rvar_type.Tuple)
                tIt.next();
            handleVarType(t.type());
            ret =
              true;
        }
        while (newContextAllocNodes.hasNext()) {
            ContextAllocNode can =
              (ContextAllocNode)
                newContextAllocNodes.next();
            handleAllocNode(can,
                            can.getType());
            ret =
              true;
        }
        return ret;
    }
    
    public BitVector get(Type type) {
        if (type ==
              null)
            return null;
        update();
        BitVector ret =
          (BitVector)
            typeMask.get(type);
        if (ret ==
              null &&
              fh !=
                null)
            throw new RuntimeException("oops" +
                                       type);
        return ret;
    }
    
    private BDDGetter bddGetter;
    
    public jedd.internal.RelationContainer get() {
        if (fh ==
              null)
            return new jedd.internal.RelationContainer(new jedd.Attribute[] {  },
                                                       new jedd.PhysicalDomain[] {  },
                                                       ("return jedd.internal.Jedd.v().trueBDD(); at TradTypeManager." +
                                                        "jedd:92,25-31"),
                                                       jedd.internal.Jedd.v().trueBDD());
        if (bddGetter ==
              null)
            bddGetter =
              new BDDGetter();
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v() },
                                                   new jedd.PhysicalDomain[] { V2.v(), H1.v() },
                                                   ("return jedd.internal.Jedd.v().replace(bddGetter.get(), new j" +
                                                    "edd.PhysicalDomain[...], new jedd.PhysicalDomain[...]); at T" +
                                                    "radTypeManager.jedd:94,8-14"),
                                                   jedd.internal.Jedd.v().replace(bddGetter.get(),
                                                                                  new jedd.PhysicalDomain[] { V1.v() },
                                                                                  new jedd.PhysicalDomain[] { V2.v() }));
    }
    
    class BDDGetter {
        private final jedd.internal.RelationContainer cachedTypeMasks =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_type.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { T1.v(), H1.v() },
                                              ("private <soot.jimple.paddle.bdddomains.A_type:soot.jimple.pa" +
                                               "ddle.bdddomains.T1, soot.jimple.paddle.bdddomains.A_obj> cac" +
                                               "hedTypeMasks = jedd.internal.Jedd.v().falseBDD() at TradType" +
                                               "Manager.jedd:97,16-34"),
                                              jedd.internal.Jedd.v().falseBDD());
        
        private final jedd.internal.RelationContainer cachedVarNodes =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_type.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), T1.v() },
                                              ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                               "ddle.bdddomains.A_type> cachedVarNodes = jedd.internal.Jedd." +
                                               "v().falseBDD() at TradTypeManager.jedd:98,16-31"),
                                              jedd.internal.Jedd.v().falseBDD());
        
        private final jedd.internal.RelationContainer cachedVarObj =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v() },
                                              new jedd.PhysicalDomain[] { V1.v(), H1.v() },
                                              ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                               "ddle.bdddomains.A_obj> cachedVarObj = jedd.internal.Jedd.v()" +
                                               ".falseBDD() at TradTypeManager.jedd:99,16-30"),
                                              jedd.internal.Jedd.v().falseBDD());
        
        public jedd.internal.RelationContainer get() {
            update();
            if (change) {
                for (Iterator tIt =
                       Scene.v().getTypeNumberer().iterator();
                     tIt.hasNext();
                     ) {
                    final Type t =
                      (Type)
                        tIt.next();
                    BitVector mask =
                      (BitVector)
                        typeMask.get(t);
                    if (mask ==
                          null)
                        continue;
                    BitSetIterator bsi =
                      mask.iterator();
                    Numberer objNumberer =
                      PaddleNumberers.v().contextAllocNodeNumberer();
                    while (bsi.hasNext()) {
                        int objNum =
                          bsi.next();
                        cachedTypeMasks.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { t, objNumberer.get(objNum) },
                                                                               new jedd.Attribute[] { A_type.v(), A_obj.v() },
                                                                               new jedd.PhysicalDomain[] { T1.v(), H1.v() }));
                    }
                }
                cachedVarObj.eq(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(cachedTypeMasks),
                                                               cachedVarNodes,
                                                               new jedd.PhysicalDomain[] { T1.v() }));
                change =
                  false;
            }
            final jedd.internal.RelationContainer varNodes =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_type.v() },
                                                  new jedd.PhysicalDomain[] { V1.v(), T1.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                                   "omains.V1, soot.jimple.paddle.bdddomains.A_type:soot.jimple." +
                                                   "paddle.bdddomains.T1> varNodes = jedd.internal.Jedd.v().fals" +
                                                   "eBDD(); at TradTypeManager.jedd:118,28-36"),
                                                  jedd.internal.Jedd.v().falseBDD());
            while (newVarNodes.hasNext()) {
                VarNode vn =
                  (VarNode)
                    newVarNodes.next();
                varNodes.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { vn, vn.getType() },
                                                                new jedd.Attribute[] { A_var.v(), A_type.v() },
                                                                new jedd.PhysicalDomain[] { V1.v(), T1.v() }));
            }
            cachedVarObj.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(cachedTypeMasks),
                                                                varNodes,
                                                                new jedd.PhysicalDomain[] { T1.v() }));
            cachedVarNodes.eqUnion(varNodes);
            return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_obj.v() },
                                                       new jedd.PhysicalDomain[] { V1.v(), H1.v() },
                                                       "return cachedVarObj; at TradTypeManager.jedd:125,12-18",
                                                       cachedVarObj);
        }
        
        public BDDGetter() {
            super();
        }
    }
    
    
    public boolean castNeverFails(Type from,
                                  Type to) {
        if (fh ==
              null)
            return true;
        if (to ==
              null)
            return true;
        if (to ==
              from)
            return true;
        if (from ==
              null)
            return false;
        if (to.equals(from))
            return true;
        boolean ret =
          castNeverFailsGuts(from,
                             to);
        return ret;
    }
    
    public boolean castNeverFailsGuts(Type from,
                                      Type to) {
        if (from instanceof NullType)
            return true;
        if (to instanceof NullType)
            return false;
        if (to instanceof AnySubType)
            throw new RuntimeException("oops from=" +
                                       from +
                                       " to=" +
                                       to);
        return fh.canStoreType(from,
                               to);
    }
    
    private LargeNumberedMap typeMask =
      new LargeNumberedMap(Scene.v().getTypeNumberer());
    
    private Iterator newVarNodes =
      PaddleNumberers.v().varNodeNumberer().iterator();
    
    private FastHierarchy fh;
    
    private boolean change =
      false;
}
