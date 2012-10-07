package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qbasec_base_fld_objc_objTrad extends Qbasec_base_fld_objc_obj {
    public Qbasec_base_fld_objc_objTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(Context _basec,
                    AllocNode _base,
                    PaddleField _fld,
                    Context _objc,
                    AllocNode _obj) {
        q.add(_basec);
        q.add(_base);
        q.add(_fld);
        q.add(_objc);
        q.add(_obj);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                              new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qbasec_base_fld_objc" +
                                               "_objTrad.jedd:42,22-24"),
                                              in).iterator(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() });
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
                    (AllocNode)
                      tuple[1],
                    (PaddleField)
                      tuple[2],
                    (Context)
                      tuple[3],
                    (AllocNode)
                      tuple[4]);
            }
        }
    }
    
    public Rbasec_base_fld_objc_obj reader(String rname) {
        return new Rbasec_base_fld_objc_objTrad(q.reader(),
                                                name +
                                                ":" +
                                                rname,
                                                this);
    }
}
