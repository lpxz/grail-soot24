package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Qobj_method_type implements PaddleQueue {
    public Qobj_method_type(String name) { super();
                                           this.name = name; }
    
    protected String name;
    
    public final String toString() { return name; }
    
    public abstract void add(AllocNode _obj, SootMethod _method, Type _type);
    
    public abstract void add(final jedd.internal.RelationContainer in);
    
    public abstract Robj_method_type reader(String rname);
    
    public Robj_method_type revreader(String rname) { return reader(rname); }
    
    public void add(Robj_method_type.Tuple in) { add(in.obj(), in.method(), in.type()); }
    
    public void invalidate() { for (int i = 0; i < depMans.length; i++) depMans[i].invalidate(this); }
    
    private DependencyManager[] depMans = new DependencyManager[0];
    
    public void addDepMan(DependencyManager depMan) {
        for (int i = 0; i < depMans.length; i++) if (depMan == depMans[i]) return;
        DependencyManager[] oldDepMans = depMans;
        depMans = (new DependencyManager[depMans.length + 1]);
        for (int i = 0; i < oldDepMans.length; i++) depMans[i] = oldDepMans[i];
        depMans[oldDepMans.length] = depMan; }
}
