package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcm_stmt_kind_tgtmDebug extends Qsrcm_stmt_kind_tgtm {
    public Qsrcm_stmt_kind_tgtmDebug(String name) {
        super(name);
    }
    
    private Qsrcm_stmt_kind_tgtmBDD bdd =
      new Qsrcm_stmt_kind_tgtmBDD(name +
                                  "bdd");
    
    private Qsrcm_stmt_kind_tgtmSet trad =
      new Qsrcm_stmt_kind_tgtmSet(name +
                                  "set");
    
    public void add(SootMethod _srcm,
                    Unit _stmt,
                    Kind _kind,
                    SootMethod _tgtm) {
        invalidate();
        bdd.add(_srcm,
                _stmt,
                _kind,
                _tgtm);
        trad.add(_srcm,
                 _stmt,
                 _kind,
                 _tgtm);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                              new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrcm_stmt_kind_tgtm" +
                                               "Debug.jedd:40,22-24"),
                                              in).iterator(new Attribute[] { A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   4;
                 i++) {
                add((SootMethod)
                      tuple[0],
                    (Unit)
                      tuple[1],
                    (Kind)
                      tuple[2],
                    (SootMethod)
                      tuple[3]);
            }
        }
    }
    
    public Rsrcm_stmt_kind_tgtm reader(String rname) {
        return new Rsrcm_stmt_kind_tgtmDebug((Rsrcm_stmt_kind_tgtmBDD)
                                               bdd.reader(rname),
                                             (Rsrcm_stmt_kind_tgtmSet)
                                               trad.reader(rname),
                                             name +
                                             ":" +
                                             rname,
                                             this);
    }
}
