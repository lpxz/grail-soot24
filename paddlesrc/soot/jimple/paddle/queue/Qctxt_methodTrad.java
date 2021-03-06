package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qctxt_methodTrad extends Qctxt_method {
    public Qctxt_methodTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(Context _ctxt,
                    SootMethod _method) {
        q.add(_ctxt);
        q.add(_method);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qctxt_methodTrad.jed" +
                                               "d:39,22-24"),
                                              in).iterator(new Attribute[] { A_ctxt.v(), A_method.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   2;
                 i++) {
                add((Context)
                      tuple[0],
                    (SootMethod)
                      tuple[1]);
            }
        }
    }
    
    public Rctxt_method reader(String rname) {
        return new Rctxt_methodTrad(q.reader(),
                                    name +
                                    ":" +
                                    rname,
                                    this);
    }
}
