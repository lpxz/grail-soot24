package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class QmethodTrad extends Qmethod {
    public QmethodTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(SootMethod _method) {
        q.add(_method);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_method.v() },
                                              new PhysicalDomain[] { MS.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at QmethodTrad.jedd:38," +
                                               "22-24"),
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
        return new RmethodTrad(q.reader(),
                               name +
                               ":" +
                               rname,
                               this);
    }
}
