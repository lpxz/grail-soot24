package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qvar_srcm_stmt_tgtmTrad extends Qvar_srcm_stmt_tgtm {
    public Qvar_srcm_stmt_tgtmTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(VarNode _var,
                    SootMethod _srcm,
                    Unit _stmt,
                    SootMethod _tgtm) {
        q.add(_var);
        q.add(_srcm);
        q.add(_stmt);
        q.add(_tgtm);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_srcm.v(), A_tgtm.v(), A_stmt.v() },
                                              new PhysicalDomain[] { V1.v(), MS.v(), MT.v(), ST.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qvar_srcm_stmt_tgtmT" +
                                               "rad.jedd:41,22-24"),
                                              in).iterator(new Attribute[] { A_var.v(), A_srcm.v(), A_stmt.v(), A_tgtm.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   4;
                 i++) {
                add((VarNode)
                      tuple[0],
                    (SootMethod)
                      tuple[1],
                    (Unit)
                      tuple[2],
                    (SootMethod)
                      tuple[3]);
            }
        }
    }
    
    public Rvar_srcm_stmt_tgtm reader(String rname) {
        return new Rvar_srcm_stmt_tgtmTrad(q.reader(),
                                           name +
                                           ":" +
                                           rname,
                                           this);
    }
}
