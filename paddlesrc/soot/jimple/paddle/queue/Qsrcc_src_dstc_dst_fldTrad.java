package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcc_src_dstc_dst_fldTrad extends Qsrcc_src_dstc_dst_fld {
    public Qsrcc_src_dstc_dst_fldTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(Context _srcc,
                    VarNode _src,
                    Context _dstc,
                    VarNode _dst,
                    PaddleField _fld) {
        q.add(_srcc);
        q.add(_src);
        q.add(_dstc);
        q.add(_dst);
        q.add(_fld);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrcc_src_dstc_dst_f" +
                                               "ldTrad.jedd:42,22-24"),
                                              in).iterator(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v(), A_fld.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   5;
                 i++) {
                add((Context)
                      tuple[0],
                    (VarNode)
                      tuple[1],
                    (Context)
                      tuple[2],
                    (VarNode)
                      tuple[3],
                    (PaddleField)
                      tuple[4]);
            }
        }
    }
    
    public Rsrcc_src_dstc_dst_fld reader(String rname) {
        return new Rsrcc_src_dstc_dst_fldTrad(q.reader(),
                                              name +
                                              ":" +
                                              rname,
                                              this);
    }
}
