package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qvar_srcm_stmt_dtp_signature_kindNumTrace extends Qvar_srcm_stmt_dtp_signature_kind {
    public Qvar_srcm_stmt_dtp_signature_kindNumTrace(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(VarNode _var, SootMethod _srcm, Unit _stmt, Type _dtp, NumberedString _signature, Kind _kind) {
        invalidate();
        Rvar_srcm_stmt_dtp_signature_kind.Tuple in =
          new Rvar_srcm_stmt_dtp_signature_kind.Tuple(_var, _srcm, _stmt, _dtp, _signature, _kind);
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            Rvar_srcm_stmt_dtp_signature_kindNumTrace reader = (Rvar_srcm_stmt_dtp_signature_kindNumTrace) it.next();
            reader.add(in); }
    }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rvar_srcm_stmt_dtp_signature_kind reader(String rname) {
        Rvar_srcm_stmt_dtp_signature_kind ret = new Rvar_srcm_stmt_dtp_signature_kindNumTrace(name + ":" + rname, this);
        readers.add(ret);
        return ret; }
}
