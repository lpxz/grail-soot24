package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcc_srcm_stmt_kind_tgtc_tgtmTrad extends Qsrcc_srcm_stmt_kind_tgtc_tgtm {
    public Qsrcc_srcm_stmt_kind_tgtc_tgtmTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(Context _srcc,
                    SootMethod _srcm,
                    Unit _stmt,
                    Kind _kind,
                    Context _tgtc,
                    SootMethod _tgtm) {
        q.add(_srcc);
        q.add(_srcm);
        q.add(_stmt);
        q.add(_kind);
        q.add(_tgtc);
        q.add(_tgtm);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcc.v(), A_srcm.v(), A_tgtc.v(), A_tgtm.v(), A_stmt.v() },
                                              new PhysicalDomain[] { KD.v(), C1.v(), MS.v(), C2.v(), MT.v(), ST.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrcc_srcm_stmt_kind" +
                                               "_tgtc_tgtmTrad.jedd:43,22-24"),
                                              in).iterator(new Attribute[] { A_srcc.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtc.v(), A_tgtm.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   6;
                 i++) {
                add((Context)
                      tuple[0],
                    (SootMethod)
                      tuple[1],
                    (Unit)
                      tuple[2],
                    (Kind)
                      tuple[3],
                    (Context)
                      tuple[4],
                    (SootMethod)
                      tuple[5]);
            }
        }
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm reader(String rname) {
        return new Rsrcc_srcm_stmt_kind_tgtc_tgtmTrad(q.reader(),
                                                      name +
                                                      ":" +
                                                      rname,
                                                      this);
    }
}
