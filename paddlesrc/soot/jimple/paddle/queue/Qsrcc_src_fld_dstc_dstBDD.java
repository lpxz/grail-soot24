package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrcc_src_fld_dstc_dstBDD extends Qsrcc_src_fld_dstc_dst {
    public Qsrcc_src_fld_dstc_dstBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(Context _srcc,
                    VarNode _src,
                    PaddleField _fld,
                    Context _dstc,
                    VarNode _dst) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                                new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qsrcc_src_fld_dstc_dstBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _srcc, _src, _fld, _dstc, _dst },
                                                                               new Attribute[] { A_srcc.v(), A_src.v(), A_fld.v(), A_dstc.v(), A_dst.v() },
                                                                               new PhysicalDomain[] { C1.v(), V1.v(), FD.v(), C2.v(), V2.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Rsrcc_src_fld_dstc_dstBDD reader =
              (Rsrcc_src_fld_dstc_dstBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                           new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                           "reader.add(in) at Qsrcc_src_fld_dstc_dstBDD.jedd:40,12-18",
                                                           in));
        }
    }
    
    public Rsrcc_src_fld_dstc_dst reader(String rname) {
        Rsrcc_src_fld_dstc_dst ret =
          new Rsrcc_src_fld_dstc_dstBDD(name +
                                        ":" +
                                        rname,
                                        this);
        readers.add(ret);
        return ret;
    }
}
