package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrc_fld_dstDebug extends Qsrc_fld_dst {
    public Qsrc_fld_dstDebug(String name) {
        super(name);
    }
    
    private Qsrc_fld_dstBDD bdd =
      new Qsrc_fld_dstBDD(name +
                          "bdd");
    
    private Qsrc_fld_dstSet trad =
      new Qsrc_fld_dstSet(name +
                          "set");
    
    public void add(VarNode _src,
                    PaddleField _fld,
                    VarNode _dst) {
        invalidate();
        bdd.add(_src,
                _fld,
                _dst);
        trad.add(_src,
                 _fld,
                 _dst);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { FD.v(), V1.v(), V2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrc_fld_dstDebug.je" +
                                               "dd:40,22-24"),
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
        return new Rsrc_fld_dstDebug((Rsrc_fld_dstBDD)
                                       bdd.reader(rname),
                                     (Rsrc_fld_dstSet)
                                       trad.reader(rname),
                                     name +
                                     ":" +
                                     rname,
                                     this);
    }
}
