package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Qvar_srcm_stmt_dtp_signature_kind implements PaddleQueue {
    public Qvar_srcm_stmt_dtp_signature_kind(String name) { super();
                                                            this.name = name; }
    
    protected String name;
    
    public final String toString() { return name; }
    
    public abstract void add(VarNode _var, SootMethod _srcm, Unit _stmt, Type _dtp, NumberedString _signature,
                             Kind _kind);
    
    public abstract void add(final jedd.internal.RelationContainer in);
    
    public abstract Rvar_srcm_stmt_dtp_signature_kind reader(String rname);
    
    public Rvar_srcm_stmt_dtp_signature_kind revreader(String rname) { return reader(rname); }
    
    public void add(Rvar_srcm_stmt_dtp_signature_kind.Tuple in) {
        add(in.var(), in.srcm(), in.stmt(), in.dtp(), in.signature(), in.kind()); }
    
    public void invalidate() { for (int i = 0; i < depMans.length; i++) depMans[i].invalidate(this); }
    
    private DependencyManager[] depMans = new DependencyManager[0];
    
    public void addDepMan(DependencyManager depMan) {
        for (int i = 0; i < depMans.length; i++) if (depMan == depMans[i]) return;
        DependencyManager[] oldDepMans = depMans;
        depMans = (new DependencyManager[depMans.length + 1]);
        for (int i = 0; i < oldDepMans.length; i++) depMans[i] = oldDepMans[i];
        depMans[oldDepMans.length] = depMan; }
}
