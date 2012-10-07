package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class QmethodBDD extends Qmethod {
    public QmethodBDD(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(SootMethod _method) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                                new PhysicalDomain[] { MS.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " QmethodBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _method },
                                                                               new Attribute[] { A_method.v() },
                                                                               new PhysicalDomain[] { MS.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in), jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            RmethodBDD reader = (RmethodBDD) it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                                           new PhysicalDomain[] { MS.v() },
                                                           "reader.add(in) at QmethodBDD.jedd:40,12-18", in));
        }
    }
    
    public Rmethod reader(String rname) { Rmethod ret = new RmethodBDD(name + ":" + rname, this);
                                          readers.add(ret);
                                          return ret; }
}
