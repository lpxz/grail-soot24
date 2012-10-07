package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class RobjIter extends Robj {
    protected Iterator r;
    
    public RobjIter(Iterator r, String name, PaddleQueue q) { super(name, q);
                                                              this.r = r; }
    
    public Iterator iterator() { return new Iterator() {
                                     public boolean hasNext() { boolean ret = r.hasNext();
                                                                return ret; }
                                     
                                     public Object next() { return new Tuple((AllocNode) r.next()); }
                                     
                                     public void remove() { throw new UnsupportedOperationException(); }
                                 }; }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { A_obj.v() },
                                              new PhysicalDomain[] { H1.v() },
                                              ("<soot.jimple.paddle.bdddomains.A_obj:soot.jimple.paddle.bddd" +
                                               "omains.H1> ret = jedd.internal.Jedd.v().falseBDD(); at RobjI" +
                                               "ter.jedd:46,19-22"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next() }, new Attribute[] { A_obj.v() },
                                                       new PhysicalDomain[] { H1.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { A_obj.v() }, new PhysicalDomain[] { H1.v() },
                                                   "return ret; at RobjIter.jedd:50,8-14", ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
