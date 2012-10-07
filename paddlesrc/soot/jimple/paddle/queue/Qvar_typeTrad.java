package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qvar_typeTrad extends Qvar_type {
    public Qvar_typeTrad(String name) {
        super(name);
    }
    
    private ChunkedQueue q =
      new ChunkedQueue();
    
    public void add(VarNode _var,
                    Type _type) {
        q.add(_var);
        q.add(_type);
        invalidate();
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v() },
                                              new PhysicalDomain[] { T1.v(), V1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qvar_typeTrad.jedd:3" +
                                               "9,22-24"),
                                              in).iterator(new Attribute[] { A_var.v(), A_type.v() });
        while (it.hasNext()) {
            Object[] tuple =
              (Object[])
                it.next();
            for (int i =
                   0;
                 i <
                   2;
                 i++) {
                add((VarNode)
                      tuple[0],
                    (Type)
                      tuple[1]);
            }
        }
    }
    
    public Rvar_type reader(String rname) {
        return new Rvar_typeTrad(q.reader(),
                                 name +
                                 ":" +
                                 rname,
                                 this);
    }
}
