package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrcc_src_dstc_dstMerge extends Rsrcc_src_dstc_dst {
    void add(final jedd.internal.RelationContainer tuple) { throw new RuntimeException(); }
    
    private Rsrcc_src_dstc_dst in1;
    
    private Rsrcc_src_dstc_dst in2;
    
    public Rsrcc_src_dstc_dstMerge(Rsrcc_src_dstc_dst in1, Rsrcc_src_dstc_dst in2) {
        super(in1.name + "+" + in2.name, null);
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
        return new jedd.internal.RelationContainer(new Attribute[] { A_srcc.v(), A_dstc.v(), A_src.v(), A_dst.v() },
                                                   new PhysicalDomain[] { C1.v(), C2.v(), V1.v(), V2.v() },
                                                   ("return jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().r" +
                                                    "ead(in1.get()), in2.get()); at Rsrcc_src_dstc_dstMerge.jedd:" +
                                                    "52,8-14"),
                                                   jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(in1.get()),
                                                                                in2.get()));
    }
    
    public boolean hasNext() { return in1.hasNext() || in2.hasNext(); }
}
