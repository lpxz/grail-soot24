package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;
import jedd.*;

public class BDDTypeManager extends AbsTypeManager {
    BDDTypeManager(Rvar_method_type locals,
                   Rvar_type globals,
                   Robj_method_type localallocs,
                   Robj_type globalallocs) {
        super(locals,
              globals,
              localallocs,
              globalallocs);
        this.fh =
          PaddleScene.v().BDDHierarchy();
    }
    
    final jedd.internal.RelationContainer result =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                          new PhysicalDomain[] { V1.v(), H1.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_var, soot.jimple.paddle.bdd" +
                                           "domains.A_obj> result = jedd.internal.Jedd.v().falseBDD() at" +
                                           " BDDTypeManager.jedd:37,4-18"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    final jedd.internal.RelationContainer allVars =
      new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_type.v() },
                                          new PhysicalDomain[] { V1.v(), T1.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_var, soot.jimple.paddle.bdd" +
                                           "domains.A_type> allVars = jedd.internal.Jedd.v().falseBDD() " +
                                           "at BDDTypeManager.jedd:38,4-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    final jedd.internal.RelationContainer allObjs =
      new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_type.v() },
                                          new PhysicalDomain[] { H1.v(), T1.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_obj, soot.jimple.paddle.bdd" +
                                           "domains.A_type> allObjs = jedd.internal.Jedd.v().falseBDD() " +
                                           "at BDDTypeManager.jedd:39,4-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public boolean update() {
        if (fh ==
              null) {
            result.eq(jedd.internal.Jedd.v().trueBDD());
            return true;
        }
        final jedd.internal.RelationContainer newVars =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_type.v() },
                                              new PhysicalDomain[] { V1.v(), T1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_var:soot.jimple.paddle.bddd" +
                                               "omains.V1, soot.jimple.paddle.bdddomains.A_type:soot.jimple." +
                                               "paddle.bdddomains.T1> newVars; at BDDTypeManager.jedd:46,24-" +
                                               "31"));
        newVars.eq(jedd.internal.Jedd.v().project(locals.get(),
                                                  new PhysicalDomain[] { MS.v() }));
        newVars.eqUnion(globals.get());
        allVars.eqUnion(newVars);
        final jedd.internal.RelationContainer newObjs =
          new jedd.internal.RelationContainer(new Attribute[] { A_obj.v(), A_type.v() },
                                              new PhysicalDomain[] { H1.v(), T1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1, soot.jimple.paddle.bdddomains.A_type:soot.jimple." +
                                               "paddle.bdddomains.T1> newObjs; at BDDTypeManager.jedd:51,24-" +
                                               "31"));
        newObjs.eq(jedd.internal.Jedd.v().project(localallocs.get(),
                                                  new PhysicalDomain[] { MS.v() }));
        newObjs.eqUnion(globalallocs.get());
        allObjs.eqUnion(newObjs);
        final jedd.internal.RelationContainer subtypeRelation =
          new jedd.internal.RelationContainer(new Attribute[] { A_subt.v(), A_supt.v() },
                                              new PhysicalDomain[] { T2.v(), T1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_subt:soot.jimple.paddle.bdd" +
                                               "domains.T2, soot.jimple.paddle.bdddomains.A_supt:soot.jimple" +
                                               ".paddle.bdddomains.T1> subtypeRelation = fh.subtypeRelation(" +
                                               "); at BDDTypeManager.jedd:56,25-40"),
                                              fh.subtypeRelation());
        result.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(subtypeRelation),
                                                                                                                                                newVars,
                                                                                                                                                new PhysicalDomain[] { T1.v() }),
                                                                                                                 new PhysicalDomain[] { T2.v() },
                                                                                                                 new PhysicalDomain[] { T1.v() })),
                                                      allObjs,
                                                      new PhysicalDomain[] { T1.v() }));
        result.eqUnion(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(subtypeRelation),
                                                                                                                                                allVars,
                                                                                                                                                new PhysicalDomain[] { T1.v() }),
                                                                                                                 new PhysicalDomain[] { T2.v() },
                                                                                                                 new PhysicalDomain[] { T1.v() })),
                                                      newObjs,
                                                      new PhysicalDomain[] { T1.v() }));
        return true;
    }
    
    public BitVector get(Type type) {
        throw new RuntimeException("Not implemented");
    }
    
    public jedd.internal.RelationContainer get() {
        update();
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                   new PhysicalDomain[] { V2.v(), H1.v() },
                                                   ("return jedd.internal.Jedd.v().replace(result, new jedd.Physi" +
                                                    "calDomain[...], new jedd.PhysicalDomain[...]); at BDDTypeMan" +
                                                    "ager.jedd:66,8-14"),
                                                   jedd.internal.Jedd.v().replace(result,
                                                                                  new PhysicalDomain[] { V1.v() },
                                                                                  new PhysicalDomain[] { V2.v() }));
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
        if (to instanceof AnySubType)
            throw new RuntimeException("oops from=" +
                                       from +
                                       " to=" +
                                       to);
        return !jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().falseBDD()),
                                              jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(fh.subtypeRelation()),
                                                                               jedd.internal.Jedd.v().literal(new Object[] { from, to },
                                                                                                              new Attribute[] { A_subt.v(), A_supt.v() },
                                                                                                              new PhysicalDomain[] { T2.v(), T1.v() })));
    }
    
    private BDDHierarchy fh;
}
