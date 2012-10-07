package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrc_dstTrad extends Qsrc_dst {
    public Qsrc_dstTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(VarNode _src,
                    VarNode _dst) {
        q.add(_src);
        q.add(_dst);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrc_dstTrad.jedd:39" +
                                               ",22-24"),
                                              in).iterator(new Attribute[] { A_src.v(), A_dst.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   2;
                 i++) {
                add((VarNode)
                      tuple[0],
                    (VarNode)
                      tuple[1]);
            }
        }
    }
    
    public Rsrc_dst reader(String rname) {
        return new Rsrc_dstTrad(q.reader(),
                                name +
                                ":" +
                                rname,
                                this);
    }
}
