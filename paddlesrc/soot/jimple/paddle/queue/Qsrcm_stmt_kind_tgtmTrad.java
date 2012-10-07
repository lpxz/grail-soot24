package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcm_stmt_kind_tgtmTrad extends Qsrcm_stmt_kind_tgtm {
    public Qsrcm_stmt_kind_tgtmTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(SootMethod _srcm,
                    Unit _stmt,
                    Kind _kind,
                    SootMethod _tgtm) {
        q.add(_srcm);
        q.add(_stmt);
        q.add(_kind);
        q.add(_tgtm);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                              new PhysicalDomain[] { KD.v(), MS.v(), MT.v(), ST.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrcm_stmt_kind_tgtm" +
                                               "Trad.jedd:41,22-24"),
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
        return new Rsrcm_stmt_kind_tgtmTrad(q.reader(),
                                            name +
                                            ":" +
                                            rname,
                                            this);
    }
}
