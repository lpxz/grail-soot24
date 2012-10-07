package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;
import java.util.*;

public class BDDNodeInfo extends AbsNodeInfo {
    public BDDNodeInfo(Rvar_method_type locals,
                       Rvar_type globals,
                       Robj_method_type localallocs,
                       Robj_type globalallocs) {
        super(locals,
              globals,
              localallocs,
              globalallocs);
    }
    
    public boolean update() {
        boolean ret =
          false;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(localMap),
                                           localMap.eqUnion(jedd.internal.Jedd.v().project(locals.get(),
                                                                                           new jedd.PhysicalDomain[] { T1.v() }))))
            ret =
              true;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(globalSet),
                                           globalSet.eqUnion(jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().replace(globals.get(),
                                                                                                                           new jedd.PhysicalDomain[] { V1.v() },
                                                                                                                           new jedd.PhysicalDomain[] { V2.v() }),
                                                                                            new jedd.PhysicalDomain[] { T1.v() }))))
            ret =
              true;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(localallocMap),
                                           localallocMap.eqUnion(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(localallocs.get(),
                                                                                                                               new jedd.PhysicalDomain[] { T1.v() }),
                                                                                                new jedd.PhysicalDomain[] { H1.v() },
                                                                                                new jedd.PhysicalDomain[] { H2.v() }))))
            ret =
              true;
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(globalallocSet),
                                           globalallocSet.eqUnion(jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().replace(globalallocs.get(),
                                                                                                                                new jedd.PhysicalDomain[] { H1.v() },
                                                                                                                                new jedd.PhysicalDomain[] { H2.v() }),
                                                                                                 new jedd.PhysicalDomain[] { T1.v() }))))
            ret =
              true;
        return ret;
    }
    
    private final jedd.internal.RelationContainer localMap =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { V1.v(), MS.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var, soot.jimple.pa" +
                                           "ddle.bdddomains.A_method> localMap = jedd.internal.Jedd.v()." +
                                           "falseBDD() at BDDNodeInfo.jedd:53,12-29"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer globalSet =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v() },
                                          new jedd.PhysicalDomain[] { V2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_var> globalSet = je" +
                                           "dd.internal.Jedd.v().falseBDD() at BDDNodeInfo.jedd:54,12-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer localallocMap =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_method.v() },
                                          new jedd.PhysicalDomain[] { H2.v(), MS.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj, soot.jimple.pa" +
                                           "ddle.bdddomains.A_method> localallocMap = jedd.internal.Jedd" +
                                           ".v().falseBDD() at BDDNodeInfo.jedd:55,12-29"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    private final jedd.internal.RelationContainer globalallocSet =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                          new jedd.PhysicalDomain[] { H2.v() },
                                          ("private <soot.jimple.paddle.bdddomains.A_obj> globalallocSet" +
                                           " = jedd.internal.Jedd.v().falseBDD() at BDDNodeInfo.jedd:56," +
                                           "12-19"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public jedd.internal.RelationContainer localMap() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v(), A_method.v() },
                                                   new jedd.PhysicalDomain[] { V1.v(), MS.v() },
                                                   "return localMap; at BDDNodeInfo.jedd:58,42-48",
                                                   localMap);
    }
    
    public jedd.internal.RelationContainer globalSet() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_var.v() },
                                                   new jedd.PhysicalDomain[] { V2.v() },
                                                   "return globalSet; at BDDNodeInfo.jedd:59,33-39",
                                                   globalSet);
    }
    
    public jedd.internal.RelationContainer localallocMap() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v(), A_method.v() },
                                                   new jedd.PhysicalDomain[] { H2.v(), MS.v() },
                                                   "return localallocMap; at BDDNodeInfo.jedd:60,47-53",
                                                   localallocMap);
    }
    
    public jedd.internal.RelationContainer globalallocSet() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_obj.v() },
                                                   new jedd.PhysicalDomain[] { H2.v() },
                                                   "return globalallocSet; at BDDNodeInfo.jedd:61,38-44",
                                                   globalallocSet);
    }
}
