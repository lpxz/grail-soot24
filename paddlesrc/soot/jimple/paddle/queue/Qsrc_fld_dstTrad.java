package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrc_fld_dstTrad extends Qsrc_fld_dst {
    public Qsrc_fld_dstTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(VarNode _src,
                    PaddleField _fld,
                    VarNode _dst) {
        q.add(_src);
        q.add(_fld);
        q.add(_dst);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrc_fld_dstTrad.jed" +
                                               "d:40,22-24"),
                                              in).iterator(new Attribute[] { A_src.v(), A_fld.v(), A_dst.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   3;
                 i++) {
                add((VarNode)
                      tuple[0],
                    (PaddleField)
                      tuple[1],
                    (VarNode)
                      tuple[2]);
            }
        }
    }
    
    public Rsrc_fld_dst reader(String rname) {
        return new Rsrc_fld_dstTrad(q.reader(),
                                    name +
                                    ":" +
                                    rname,
                                    this);
    }
}
