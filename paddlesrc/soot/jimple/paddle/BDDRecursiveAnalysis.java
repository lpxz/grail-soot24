package soot.jimple.paddle;

import soot.*;
import soot.jimple.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.queue.*;
import soot.util.*;
import java.util.*;

public class BDDRecursiveAnalysis {
    final jedd.internal.RelationContainer recursive =
      new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v() },
                                          new jedd.PhysicalDomain[] { CM1.v(), MC1.v() },
                                          ("<soot.jimple.paddle.bdddomains.A_srcc, soot.jimple.paddle.bd" +
                                           "ddomains.A_srcm> recursive = jedd.internal.Jedd.v().falseBDD" +
                                           "() at BDDRecursiveAnalysis.jedd:30,4-20"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    public void analyze() {
        final jedd.internal.RelationContainer nonClinit =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_kind.v() },
                                              new jedd.PhysicalDomain[] { KD.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_kind:soot.jimple.paddle.bdd" +
                                               "domains.KD> nonClinit = jedd.internal.Jedd.v().minus(jedd.in" +
                                               "ternal.Jedd.v().read(jedd.internal.Jedd.v().trueBDD()), jedd" +
                                               ".internal.Jedd.v().literal(new java.lang.Object[...], new je" +
                                               "dd.Attribute[...], new jedd.PhysicalDomain[...])); at BDDRec" +
                                               "ursiveAnalysis.jedd:50,17-26"),
                                              jedd.internal.Jedd.v().minus(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().trueBDD()),
                                                                           jedd.internal.Jedd.v().literal(new Object[] { Kind.CLINIT },
                                                                                                          new jedd.Attribute[] { A_kind.v() },
                                                                                                          new jedd.PhysicalDomain[] { KD.v() })));
        final jedd.internal.RelationContainer calls =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.CM1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimpl" +
                                               "e.paddle.bdddomains.MC1, soot.jimple.paddle.bdddomains.A_tgt" +
                                               "c:soot.jimple.paddle.bdddomains.CM2, soot.jimple.paddle.bddd" +
                                               "omains.A_tgtm:soot.jimple.paddle.bdddomains.MC2> calls; at B" +
                                               "DDRecursiveAnalysis.jedd:51,57-62"));
        if (contextInsensitive) {
            final jedd.internal.RelationContainer cicalls =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v(), A_tgtm.v() },
                                                  new jedd.PhysicalDomain[] { MS.v(), MT.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_srcm:soot.jimple.paddle.bdd" +
                                                   "domains.MS, soot.jimple.paddle.bdddomains.A_tgtm:soot.jimple" +
                                                   ".paddle.bdddomains.MT> cicalls = jedd.internal.Jedd.v().comp" +
                                                   "ose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().proje" +
                                                   "ct(soot.jimple.paddle.Results.v().callGraph().ciEdges().get(" +
                                                   "), new jedd.PhysicalDomain[...])), nonClinit, new jedd.Physi" +
                                                   "calDomain[...]); at BDDRecursiveAnalysis.jedd:53,35-42"),
                                                  jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(Results.v().callGraph().ciEdges().get(),
                                                                                                                                            new jedd.PhysicalDomain[] { ST.v() })),
                                                                                 nonClinit,
                                                                                 new jedd.PhysicalDomain[] { KD.v() }));
            calls.eq(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().join(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().replace(cicalls,
                                                                                                                                           new jedd.PhysicalDomain[] { MS.v() },
                                                                                                                                           new jedd.PhysicalDomain[] { MC1.v() })),
                                                                                jedd.internal.Jedd.v().literal(new Object[] { null, null },
                                                                                                               new jedd.Attribute[] { A_srcc.v(), A_tgtc.v() },
                                                                                                               new jedd.PhysicalDomain[] { CM1.v(), CM2.v() }),
                                                                                new jedd.PhysicalDomain[] {  }),
                                                    new jedd.PhysicalDomain[] { MT.v() },
                                                    new jedd.PhysicalDomain[] { MC2.v() }));
        } else {
            final jedd.internal.RelationContainer tmpCalls =
              new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v() },
                                                  new jedd.PhysicalDomain[] { C1.v(), MS.v(), C2.v(), MT.v() },
                                                  ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                                   "domains.C1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimple" +
                                                   ".paddle.bdddomains.MS, soot.jimple.paddle.bdddomains.A_tgtc:" +
                                                   "soot.jimple.paddle.bdddomains.C2, soot.jimple.paddle.bdddoma" +
                                                   "ins.A_tgtm:soot.jimple.paddle.bdddomains.MT> tmpCalls = jedd" +
                                                   ".internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd." +
                                                   "internal.Jedd.v().project(soot.jimple.paddle.Results.v().cal" +
                                                   "lGraph().csEdges().get(), new jedd.PhysicalDomain[...])), no" +
                                                   "nClinit, new jedd.PhysicalDomain[...]); at BDDRecursiveAnaly" +
                                                   "sis.jedd:58,57-65"),
                                                  jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(jedd.internal.Jedd.v().project(Results.v().callGraph().csEdges().get(),
                                                                                                                                            new jedd.PhysicalDomain[] { ST.v() })),
                                                                                 nonClinit,
                                                                                 new jedd.PhysicalDomain[] { KD.v() }));
            calls.eq(jedd.internal.Jedd.v().replace(tmpCalls,
                                                    new jedd.PhysicalDomain[] { C1.v(), MS.v(), C2.v(), MT.v() },
                                                    new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() }));
        }
        final jedd.internal.RelationContainer transCalls =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.CM1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimpl" +
                                               "e.paddle.bdddomains.MC1, soot.jimple.paddle.bdddomains.A_tgt" +
                                               "c:soot.jimple.paddle.bdddomains.CM2, soot.jimple.paddle.bddd" +
                                               "omains.A_tgtm:soot.jimple.paddle.bdddomains.MC2> transCalls " +
                                               "= calls; at BDDRecursiveAnalysis.jedd:63,57-67"),
                                              calls);
        final jedd.internal.RelationContainer newCalls =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { CM2.v(), MC2.v(), CM3.v(), MC3.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.CM2, soot.jimple.paddle.bdddomains.A_srcm:soot.jimpl" +
                                               "e.paddle.bdddomains.MC2, soot.jimple.paddle.bdddomains.A_tgt" +
                                               "c:soot.jimple.paddle.bdddomains.CM3, soot.jimple.paddle.bddd" +
                                               "omains.A_tgtm:soot.jimple.paddle.bdddomains.MC3> newCalls = " +
                                               "jedd.internal.Jedd.v().replace(calls, new jedd.PhysicalDomai" +
                                               "n[...], new jedd.PhysicalDomain[...]); at BDDRecursiveAnalys" +
                                               "is.jedd:64,57-65"),
                                              jedd.internal.Jedd.v().replace(calls,
                                                                             new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() },
                                                                             new jedd.PhysicalDomain[] { CM2.v(), MC2.v(), CM3.v(), MC3.v() }));
        do  {
            newCalls.eq(jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().compose(jedd.internal.Jedd.v().read(calls),
                                                                                      newCalls,
                                                                                      new jedd.PhysicalDomain[] { CM2.v(), MC2.v() }),
                                                       new jedd.PhysicalDomain[] { CM1.v(), MC1.v() },
                                                       new jedd.PhysicalDomain[] { CM2.v(), MC2.v() }));
            newCalls.eqMinus(jedd.internal.Jedd.v().replace(transCalls,
                                                            new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() },
                                                            new jedd.PhysicalDomain[] { CM2.v(), MC2.v(), CM3.v(), MC3.v() }));
            transCalls.eqUnion(jedd.internal.Jedd.v().replace(newCalls,
                                                              new jedd.PhysicalDomain[] { CM2.v(), MC2.v(), CM3.v(), MC3.v() },
                                                              new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() }));
        }while(!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(newCalls),
                                              jedd.internal.Jedd.v().falseBDD())); 
        final jedd.internal.RelationContainer source =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v() },
                                              new jedd.PhysicalDomain[] { CM1.v(), MC2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.CM1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimpl" +
                                               "e.paddle.bdddomains.MC2> source = jedd.internal.Jedd.v().rep" +
                                               "lace(jedd.internal.Jedd.v().project(transCalls, new jedd.Phy" +
                                               "sicalDomain[...]), new jedd.PhysicalDomain[...], new jedd.Ph" +
                                               "ysicalDomain[...]); at BDDRecursiveAnalysis.jedd:72,25-31"),
                                              jedd.internal.Jedd.v().replace(jedd.internal.Jedd.v().project(transCalls,
                                                                                                            new jedd.PhysicalDomain[] { CM2.v(), MC2.v() }),
                                                                             new jedd.PhysicalDomain[] { MC1.v() },
                                                                             new jedd.PhysicalDomain[] { MC2.v() }));
        final jedd.internal.RelationContainer id =
          new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v() },
                                              new jedd.PhysicalDomain[] { CM1.v(), MC1.v(), CM2.v(), MC2.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_srcc:soot.jimple.paddle.bdd" +
                                               "domains.CM1, soot.jimple.paddle.bdddomains.A_srcm:soot.jimpl" +
                                               "e.paddle.bdddomains.MC1, soot.jimple.paddle.bdddomains.A_tgt" +
                                               "c:soot.jimple.paddle.bdddomains.CM2, soot.jimple.paddle.bddd" +
                                               "omains.A_tgtm:soot.jimple.paddle.bdddomains.MC2> id = jedd.i" +
                                               "nternal.Jedd.v().copy(source, new jedd.PhysicalDomain[...], " +
                                               "new jedd.Attribute[...], ...); at BDDRecursiveAnalysis.jedd:" +
                                               "73,41-43"),
                                              jedd.internal.Jedd.v().copy(source,
                                                                          new jedd.PhysicalDomain[] { CM1.v(), MC2.v() },
                                                                          new jedd.Attribute[] { A_srcc.v(), A_srcm.v() },
                                                                          new jedd.PhysicalDomain[] { CM2.v(), MC1.v() }));
        recursive.eq(jedd.internal.Jedd.v().project(jedd.internal.Jedd.v().intersect(jedd.internal.Jedd.v().read(transCalls),
                                                                                     id),
                                                    new jedd.PhysicalDomain[] { CM2.v(), MC2.v() }));
    }
    
    public Iterator recursiveMethods() {
        return new jedd.internal.RelationContainer(new jedd.Attribute[] { A_srcm.v() },
                                                   new jedd.PhysicalDomain[] { MC1.v() },
                                                   ("jedd.internal.Jedd.v().project(recursive, new jedd.PhysicalD" +
                                                    "omain[...]).iterator() at BDDRecursiveAnalysis.jedd:79,37-45"),
                                                   jedd.internal.Jedd.v().project(recursive,
                                                                                  new jedd.PhysicalDomain[] { CM1.v() })).iterator();
    }
    
    private boolean contextInsensitive =
      false;
    
    public void setContextInsensitive() {
        contextInsensitive =
          true;
    }
    
    public BDDRecursiveAnalysis() {
        super();
    }
}
