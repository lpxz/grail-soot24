package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qobj_method_typeTrad extends Qobj_method_type {
    public Qobj_method_typeTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(AllocNode _obj,
                    SootMethod _method,
                    Type _type) {
        q.add(_obj);
        q.add(_method);
        q.add(_type);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_obj.v(), A_method.v() },
                                              new PhysicalDomain[] { T1.v(), H1.v(), MS.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qobj_method_typeTrad" +
                                               ".jedd:40,22-24"),
                                              in).iterator(new Attribute[] { A_obj.v(), A_method.v(), A_type.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   3;
                 i++) {
                add((AllocNode)
                      tuple[0],
                    (SootMethod)
                      tuple[1],
                    (Type)
                      tuple[2]);
            }
        }
    }
    
    public Robj_method_type reader(String rname) {
        return new Robj_method_typeTrad(q.reader(),
                                        name +
                                        ":" +
                                        rname,
                                        this);
    }
}
