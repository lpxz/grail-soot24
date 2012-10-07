package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Qsrcc_srcm_stmt_kind_tgtc_tgtm implements PaddleQueue {
    public Qsrcc_srcm_stmt_kind_tgtc_tgtm(String name) { super();
                                                         this.name = name; }
    
    protected String name;
    
    public final String toString() { return name; }
    
    public abstract void add(Context _srcc, SootMethod _srcm, Unit _stmt, Kind _kind, Context _tgtc, SootMethod _tgtm);
    
    public abstract void add(final jedd.internal.RelationContainer in);
    
    public abstract Rsrcc_srcm_stmt_kind_tgtc_tgtm reader(String rname);
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm revreader(String rname) { return reader(rname); }
    
    public void add(Rsrcc_srcm_stmt_kind_tgtc_tgtm.Tuple in) {
        add(in.srcc(), in.srcm(), in.stmt(), in.kind(), in.tgtc(), in.tgtm()); }
    
    public void invalidate() { for (int i = 0; i < depMans.length; i++) depMans[i].invalidate(this); }
    
    private DependencyManager[] depMans = new DependencyManager[0];
    
    public void addDepMan(DependencyManager depMan) {
        for (int i = 0; i < depMans.length; i++) if (depMan == depMans[i]) return;
        DependencyManager[] oldDepMans = depMans;
        depMans = (new DependencyManager[depMans.length + 1]);
        for (int i = 0; i < oldDepMans.length; i++) depMans[i] = oldDepMans[i];
        depMans[oldDepMans.length] = depMan; }
}
