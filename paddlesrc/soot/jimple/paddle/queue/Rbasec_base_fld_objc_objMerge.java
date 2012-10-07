package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rbasec_base_fld_objc_objMerge extends Rbasec_base_fld_objc_obj {
    void add(final jedd.internal.RelationContainer tuple) {
        throw new RuntimeException();
    }
    
    private Rbasec_base_fld_objc_obj in1;
    
    private Rbasec_base_fld_objc_obj in2;
    
    public Rbasec_base_fld_objc_objMerge(Rbasec_base_fld_objc_obj in1,
                                         Rbasec_base_fld_objc_obj in2) {
        super(in1.name +
              "+" +
              in2.name,
              null);
        this.in1 =
          in1;
        this.in2 =
          in2;
    }
    
    public Iterator iterator() {
        ;
        final Iterator it1 =
          in1.iterator();
        final Iterator it2 =
          in2.iterator();
        return new Iterator() {
            public boolean hasNext() {
                return it1.hasNext() ||
                  it2.hasNext();
            }
            
            public Object next() {
                if (it1.hasNext())
                    return it1.next();
                return it2.next();
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        return new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                   new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                   ("return jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().r" +
                                                    "ead(in1.get()), in2.get()); at Rbasec_base_fld_objc_objMerge" +
                                                    ".jedd:52,8-14"),
                                                   jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(in1.get()),
                                                                                in2.get()));
    }
    
    public boolean hasNext() {
        return in1.hasNext() ||
          in2.hasNext();
    }
}
