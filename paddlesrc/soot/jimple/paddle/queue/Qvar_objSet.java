package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qvar_objSet extends Qvar_obj {
    public Qvar_objSet(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(VarNode _var, AllocNode _obj) {
        invalidate();
        Rvar_obj.Tuple in = new Rvar_obj.Tuple(_var, _obj);
        for (Iterator it = readers.iterator(); it.hasNext(); ) { Rvar_objSet reader = (Rvar_objSet) it.next();
                                                                 reader.add(in); } }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rvar_obj reader(String rname) { Rvar_obj ret = new Rvar_objSet(name + ":" + rname, this);
                                           readers.add(ret);
                                           return ret; }
    
    public Rvar_obj revreader(String rname) { Rvar_obj ret = new Rvar_objRev(name + ":" + rname, this);
                                              readers.add(ret);
                                              return ret; }
}
