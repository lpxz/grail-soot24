package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class QmethodDebug extends Qmethod {
    public QmethodDebug(String name) {
        super(name);
    }
    
    private QmethodBDD bdd =
      new QmethodBDD(name +
                     "bdd");
    
    private QmethodSet trad =
      new QmethodSet(name +
                     "set");
    
    public void add(SootMethod _method) {
        invalidate();
        bdd.add(_method);
        trad.add(_method);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                              new PhysicalDomain[] { MS.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at QmethodDebug.jedd:40" +
                                               ",22-24"),
                                              in).iterator(new Attribute[] { A_method.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   1;
                 i++) {
                add((SootMethod)
                      tuple[0]);
            }
        }
    }
    
    public Rmethod reader(String rname) {
        return new RmethodDebug((RmethodBDD)
                                  bdd.reader(rname),
                                (RmethodSet)
                                  trad.reader(rname),
                                name +
                                ":" +
                                rname,
                                this);
    }
}
