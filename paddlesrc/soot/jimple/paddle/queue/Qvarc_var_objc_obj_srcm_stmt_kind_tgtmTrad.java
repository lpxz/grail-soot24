package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qvarc_var_objc_obj_srcm_stmt_kind_tgtmTrad extends Qvarc_var_objc_obj_srcm_stmt_kind_tgtm {
    public Qvarc_var_objc_obj_srcm_stmt_kind_tgtmTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(Context _varc,
                    VarNode _var,
                    Context _objc,
                    AllocNode _obj,
                    SootMethod _srcm,
                    Unit _stmt,
                    Kind _kind,
                    SootMethod _tgtm) {
        q.add(_varc);
        q.add(_var);
        q.add(_objc);
        q.add(_obj);
        q.add(_srcm);
        q.add(_stmt);
        q.add(_kind);
        q.add(_tgtm);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                              new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qvarc_var_objc_obj_s" +
                                               "rcm_stmt_kind_tgtmTrad.jedd:45,22-24"),
                                              in).iterator(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   8;
                 i++) {
                add((Context)
                      tuple[0],
                    (VarNode)
                      tuple[1],
                    (Context)
                      tuple[2],
                    (AllocNode)
                      tuple[3],
                    (SootMethod)
                      tuple[4],
                    (Unit)
                      tuple[5],
                    (Kind)
                      tuple[6],
                    (SootMethod)
                      tuple[7]);
            }
        }
    }
    
    public Rvarc_var_objc_obj_srcm_stmt_kind_tgtm reader(String rname) {
        return new Rvarc_var_objc_obj_srcm_stmt_kind_tgtmTrad(q.reader(),
                                                              name +
                                                              ":" +
                                                              rname,
                                                              this);
    }
}
