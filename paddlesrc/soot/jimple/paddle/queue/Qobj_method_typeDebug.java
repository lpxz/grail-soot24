package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qobj_method_typeDebug extends Qobj_method_type {
    public Qobj_method_typeDebug(String name) {
        super(name);
    }
    
    private Qobj_method_typeBDD bdd =
      new Qobj_method_typeBDD(name +
                              "bdd");
    
    private Qobj_method_typeSet trad =
      new Qobj_method_typeSet(name +
                              "set");
    
    public void add(AllocNode _obj,
                    SootMethod _method,
                    Type _type) {
        invalidate();
        bdd.add(_obj,
                _method,
                _type);
        trad.add(_obj,
                 _method,
                 _type);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_obj.v(), A_method.v() },
                                              new PhysicalDomain[] { T1.v(), H1.v(), MS.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qobj_method_typeDebu" +
                                               "g.jedd:40,22-24"),
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
        return new Robj_method_typeDebug((Robj_method_typeBDD)
                                           bdd.reader(rname),
                                         (Robj_method_typeSet)
                                           trad.reader(rname),
                                         name +
                                         ":" +
                                         rname,
                                         this);
    }
}
