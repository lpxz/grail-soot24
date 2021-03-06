package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrcc_src_dstc_dst_fldBDD extends Qsrcc_src_dstc_dst_fld {
    public Qsrcc_src_dstc_dst_fldBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(Context _srcc,
                    VarNode _src,
                    Context _dstc,
                    VarNode _dst,
                    PaddleField _fld) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v(), A_fld.v() },
                                                new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v(), FD.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qsrcc_src_dstc_dst_fldBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _srcc, _src, _dstc, _dst, _fld },
                                                                               new Attribute[] { A_srcc.v(), A_src.v(), A_dstc.v(), A_dst.v(), A_fld.v() },
                                                                               new PhysicalDomain[] { C1.v(), V1.v(), C2.v(), V2.v(), FD.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Rsrcc_src_dstc_dst_fldBDD reader =
              (Rsrcc_src_dstc_dst_fldBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                           new PhysicalDomain[] { FD.v(), C1.v(), C2.v(), V1.v(), V2.v() },
                                                           "reader.add(in) at Qsrcc_src_dstc_dst_fldBDD.jedd:40,12-18",
                                                           in));
        }
    }
    
    public Rsrcc_src_dstc_dst_fld reader(String rname) {
        Rsrcc_src_dstc_dst_fld ret =
          new Rsrcc_src_dstc_dst_fldBDD(name +
                                        ":" +
                                        rname,
                                        this);
        readers.add(ret);
        return ret;
    }
}
