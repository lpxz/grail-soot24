package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qvarc_var_objc_obj_srcm_stmt_kind_tgtmNumTrace extends Qvarc_var_objc_obj_srcm_stmt_kind_tgtm {
    public Qvarc_var_objc_obj_srcm_stmt_kind_tgtmNumTrace(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(Context _varc, VarNode _var, Context _objc, AllocNode _obj, SootMethod _srcm, Unit _stmt,
                    Kind _kind, SootMethod _tgtm) {
        invalidate();
        Rvarc_var_objc_obj_srcm_stmt_kind_tgtm.Tuple in =
          new Rvarc_var_objc_obj_srcm_stmt_kind_tgtm.Tuple(_varc, _var, _objc, _obj, _srcm, _stmt, _kind, _tgtm);
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            Rvarc_var_objc_obj_srcm_stmt_kind_tgtmNumTrace reader =
              (Rvarc_var_objc_obj_srcm_stmt_kind_tgtmNumTrace) it.next();
            reader.add(in);
        }
    }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rvarc_var_objc_obj_srcm_stmt_kind_tgtm reader(String rname) {
        Rvarc_var_objc_obj_srcm_stmt_kind_tgtm ret =
          new Rvarc_var_objc_obj_srcm_stmt_kind_tgtmNumTrace(name + ":" + rname, this);
        readers.add(ret);
        return ret;
    }
}
