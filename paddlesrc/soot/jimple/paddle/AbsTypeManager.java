package soot.jimple.paddle;

import soot.*;
import soot.util.*;
import soot.jimple.paddle.queue.*;
import soot.jimple.paddle.bdddomains.*;

public abstract class AbsTypeManager implements PaddleComponent {
    protected Rvar_method_type locals;
    
    protected Rvar_type globals;
    
    protected Robj_method_type localallocs;
    
    protected Robj_type globalallocs;
    
    AbsTypeManager(Rvar_method_type locals, Rvar_type globals, Robj_method_type localallocs, Robj_type globalallocs) {
        super();
        this.locals = locals;
        this.globals = globals;
        this.localallocs = localallocs;
        this.globalallocs = globalallocs; }
    
    public abstract boolean update();
    
    public abstract BitVector get(Type type);
    
    public abstract jedd.internal.RelationContainer get();
    
    public abstract boolean castNeverFails(Type from, Type to);
    
    public void queueDeps(DependencyManager depMan) { depMan.addQueueDep(locals, this);
                                                      depMan.addQueueDep(globals, this);
                                                      depMan.addQueueDep(localallocs, this);
                                                      depMan.addQueueDep(globalallocs, this); }
}
