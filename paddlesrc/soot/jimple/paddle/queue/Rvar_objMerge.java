package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rvar_objMerge extends Rvar_obj {
    void add(final jedd.internal.RelationContainer tuple) { throw new RuntimeException(); }
    
    private Rvar_obj in1;
    
    private Rvar_obj in2;
    
    public Rvar_objMerge(Rvar_obj in1, Rvar_obj in2) { super(in1.name + "+" + in2.name, null);
                                                       this.in1 = in1;
                                                       this.in2 = in2; }
    
    public Iterator iterator() { ;
                                 final Iterator it1 = in1.iterator();
                                 final Iterator it2 = in2.iterator();
                                 return new Iterator() {
                                     public boolean hasNext() { return it1.hasNext() || it2.hasNext(); }
                                     
                                     public Object next() { if (it1.hasNext()) return it1.next();
                                                            return it2.next(); }
                                     
                                     public void remove() { throw new UnsupportedOperationException(); }
                                 }; }
    
    public jedd.internal.RelationContainer get() {
        return new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v() },
                                                   new PhysicalDomain[] { V1.v(), H1.v() },
                                                   ("return jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().r" +
                                                    "ead(in1.get()), in2.get()); at Rvar_objMerge.jedd:52,8-14"),
                                                   jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(in1.get()),
                                                                                in2.get()));
    }
    
    public boolean hasNext() { return in1.hasNext() || in2.hasNext(); }
}
