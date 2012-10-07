package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrc_dst_fldTrad extends Qsrc_dst_fld {
    public Qsrc_dst_fldTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(VarNode _src,
                    VarNode _dst,
                    PaddleField _fld) {
        q.add(_src);
        q.add(_dst);
        q.add(_fld);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrc_dst_fldTrad.jed" +
                                               "d:40,22-24"),
                                              in).iterator(new Attribute[] { A_src.v(), A_dst.v(), A_fld.v() });
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
                    (VarNode)
                      tuple[1],
                    (PaddleField)
                      tuple[2]);
            }
        }
    }
    
    public Rsrc_dst_fld reader(String rname) {
        return new Rsrc_dst_fldTrad(q.reader(),
                                    name +
                                    ":" +
                                    rname,
                                    this);
    }
}
