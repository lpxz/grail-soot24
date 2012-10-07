package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD extends Qvarc_var_objc_obj_srcm_stmt_kind_tgtm {
    public Qvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(Context _varc,
                    VarNode _var,
                    Context _objc,
                    AllocNode _obj,
                    SootMethod _srcm,
                    Unit _stmt,
                    Kind _kind,
                    SootMethod _tgtm) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _varc, _var, _objc, _obj, _srcm, _stmt, _kind, _tgtm },
                                                                               new Attribute[] { A_varc.v(), A_var.v(), A_objc.v(), A_obj.v(), A_srcm.v(), A_stmt.v(), A_kind.v(), A_tgtm.v() },
                                                                               new PhysicalDomain[] { C1.v(), V1.v(), CH1.v(), H1.v(), MS.v(), ST.v(), KD.v(), MT.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD reader =
              (Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_kind.v(), A_var.v(), A_srcm.v(), A_tgtm.v(), A_obj.v(), A_objc.v(), A_varc.v(), A_stmt.v() },
                                                           new PhysicalDomain[] { KD.v(), V1.v(), MS.v(), MT.v(), H1.v(), CH1.v(), C1.v(), ST.v() },
                                                           ("reader.add(in) at Qvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD." +
                                                            "jedd:40,12-18"),
                                                           in));
        }
    }
    
    public Rvarc_var_objc_obj_srcm_stmt_kind_tgtm reader(String rname) {
        Rvarc_var_objc_obj_srcm_stmt_kind_tgtm ret =
          new Rvarc_var_objc_obj_srcm_stmt_kind_tgtmBDD(name +
                                                        ":" +
                                                        rname,
                                                        this);
        readers.add(ret);
        return ret;
    }
}
