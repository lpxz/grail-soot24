package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class QvarBDD extends Qvar {
    public QvarBDD(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(VarNode _var) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                                new PhysicalDomain[] { V1.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " QvarBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _var },
                                                                               new Attribute[] { A_var.v() },
                                                                               new PhysicalDomain[] { V1.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in), jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            RvarBDD reader = (RvarBDD) it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v() },
                                                           new PhysicalDomain[] { V1.v() },
                                                           "reader.add(in) at QvarBDD.jedd:40,12-18", in));
        }
    }
    
    public Rvar reader(String rname) { Rvar ret = new RvarBDD(name + ":" + rname, this);
                                       readers.add(ret);
                                       return ret; }
}
