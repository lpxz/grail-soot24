package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrcm_stmt_kind_tgtmNumTrace extends Qsrcm_stmt_kind_tgtm {
    public Qsrcm_stmt_kind_tgtmNumTrace(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(SootMethod _srcm, Unit _stmt, Kind _kind, SootMethod _tgtm) {
        invalidate();
        Rsrcm_stmt_kind_tgtm.Tuple in = new Rsrcm_stmt_kind_tgtm.Tuple(_srcm, _stmt, _kind, _tgtm);
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            Rsrcm_stmt_kind_tgtmNumTrace reader = (Rsrcm_stmt_kind_tgtmNumTrace) it.next();
            reader.add(in); }
    }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rsrcm_stmt_kind_tgtm reader(String rname) {
        Rsrcm_stmt_kind_tgtm ret = new Rsrcm_stmt_kind_tgtmNumTrace(name + ":" + rname, this);
        readers.add(ret);
        return ret; }
}
