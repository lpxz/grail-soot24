package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcc_src_fld_dstc_dstDebug extends Qsrcc_src_fld_dstc_dst {
    public Qsrcc_src_fld_dstc_dstDebug(String name) {
        super(name);
    }
    
    private Qsrcc_src_fld_dstc_dstBDD bdd =
      new Qsrcc_src_fld_dstc_dstBDD(name +
                                    "bdd");
    
    private Qsrcc_src_fld_dstc_dstSet trad =
      new Qsrcc_src_fld_dstc_dstSet(name +
                                    "set");
    
    public void add(Context _srcc,
                    VarNode _src,
                    PaddleField _fld,
                    Context _dstc,
                    VarNode _dst) {
        invalidate();
        bdd.add(_srcc,
                _src,
                _fld,
                _dstc,
                _dst);
        trad.add(_srcc,
                 _src,
                 _fld,
                 _dstc,
                 _dst);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                              new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qsrcc_src_fld_dstc_d" +
                                               "stDebug.jedd:40,22-24"),
                                              in).iterator(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() });
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
                    (PaddleField)
                      tuple[2],
                    (Context)
                      tuple[3],
                    (VarNode)
                      tuple[4]);
            }
        }
    }
    
    public Rsrcc_src_fld_dstc_dst reader(String rname) {
        return new Rsrcc_src_fld_dstc_dstDebug((Rsrcc_src_fld_dstc_dstBDD)
                                                 bdd.reader(rname),
                                               (Rsrcc_src_fld_dstc_dstSet)
                                                 trad.reader(rname),
                                               name +
                                               ":" +
                                               rname,
                                               this);
    }
}
