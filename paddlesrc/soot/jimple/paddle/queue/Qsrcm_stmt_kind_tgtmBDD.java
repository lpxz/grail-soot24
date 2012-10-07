package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrcm_stmt_kind_tgtmBDD extends Qsrcm_stmt_kind_tgtm {
    public Qsrcm_stmt_kind_tgtmBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(SootMethod _srcm,
                    Unit _stmt,
                    Kind _kind,
                    SootMethod _tgtm) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                new PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qsrcm_stmt_kind_tgtmBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _srcm, _stmt, _kind, _tgtm },
                                                                               new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                                               new PhysicalDomain[] { MS.v(), ST.v(), KD.v(), MT.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Rsrcm_stmt_kind_tgtmBDD reader =
              (Rsrcm_stmt_kind_tgtmBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                                           new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                                           "reader.add(in) at Qsrcm_stmt_kind_tgtmBDD.jedd:40,12-18",
                                                           in));
        }
    }
    
    public Rsrcm_stmt_kind_tgtm reader(String rname) {
        Rsrcm_stmt_kind_tgtm ret =
          new Rsrcm_stmt_kind_tgtmBDD(name +
                                      ":" +
                                      rname,
                                      this);
        readers.add(ret);
        return ret;
    }
}
