package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrcc_srcm_stmt_kind_tgtc_tgtmNumTrace extends Qsrcc_srcm_stmt_kind_tgtc_tgtm {
    public Qsrcc_srcm_stmt_kind_tgtc_tgtmNumTrace(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(Context _srcc, SootMethod _srcm, Unit _stmt, Kind _kind, Context _tgtc, SootMethod _tgtm) {
        invalidate();
        Rsrcc_srcm_stmt_kind_tgtc_tgtm.Tuple in =
          new Rsrcc_srcm_stmt_kind_tgtc_tgtm.Tuple(_srcc, _srcm, _stmt, _kind, _tgtc, _tgtm);
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            Rsrcc_srcm_stmt_kind_tgtc_tgtmNumTrace reader = (Rsrcc_srcm_stmt_kind_tgtc_tgtmNumTrace) it.next();
            reader.add(in); }
    }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm reader(String rname) {
        Rsrcc_srcm_stmt_kind_tgtc_tgtm ret = new Rsrcc_srcm_stmt_kind_tgtc_tgtmNumTrace(name + ":" + rname, this);
        readers.add(ret);
        return ret; }
}
