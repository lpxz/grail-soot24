package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qvar_typeDebug extends Qvar_type {
    public Qvar_typeDebug(String name) {
        super(name);
    }
    
    private Qvar_typeBDD bdd =
      new Qvar_typeBDD(name +
                       "bdd");
    
    private Qvar_typeSet trad =
      new Qvar_typeSet(name +
                       "set");
    
    public void add(VarNode _var,
                    Type _type) {
        invalidate();
        bdd.add(_var,
                _type);
        trad.add(_var,
                 _type);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_type.v(), A_var.v() },
                                              new PhysicalDomain[] { T1.v(), V1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qvar_typeDebug.jedd:" +
                                               "40,22-24"),
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
        return new Rvar_typeDebug((Rvar_typeBDD)
                                    bdd.reader(rname),
                                  (Rvar_typeSet)
                                    trad.reader(rname),
                                  name +
                                  ":" +
                                  rname,
                                  this);
    }
}
