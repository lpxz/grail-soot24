package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Qsrcc_src_dstc_dst implements PaddleQueue {
    public Qsrcc_src_dstc_dst(String name) { super();
                                             this.name = name; }
    
    protected String name;
    
    public final String toString() { return name; }
    
    public abstract void add(Context _srcc, VarNode _src, Context _dstc, VarNode _dst);
    
    public abstract void add(final jedd.internal.RelationContainer in);
    
    public abstract Rsrcc_src_dstc_dst reader(String rname);
    
    public Rsrcc_src_dstc_dst revreader(String rname) { return reader(rname); }
    
    public void add(Rsrcc_src_dstc_dst.Tuple in) { add(in.srcc(), in.src(), in.dstc(), in.dst()); }
    
    public void invalidate() { for (int i = 0; i < depMans.length; i++) depMans[i].invalidate(this); }
    
    private DependencyManager[] depMans = new DependencyManager[0];
    
    public void addDepMan(DependencyManager depMan) {
        for (int i = 0; i < depMans.length; i++) if (depMan == depMans[i]) return;
        DependencyManager[] oldDepMans = depMans;
        depMans = (new DependencyManager[depMans.length + 1]);
        for (int i = 0; i < oldDepMans.length; i++) depMans[i] = oldDepMans[i];
        depMans[oldDepMans.length] = depMan; }
}
