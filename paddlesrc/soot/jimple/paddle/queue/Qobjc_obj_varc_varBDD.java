package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qobjc_obj_varc_varBDD extends Qobjc_obj_varc_var {
    public Qobjc_obj_varc_varBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(Context _objc,
                    AllocNode _obj,
                    Context _varc,
                    VarNode _var) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                                new PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V1.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qobjc_obj_varc_varBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _objc, _obj, _varc, _var },
                                                                               new Attribute[] { A_objc.v(), A_obj.v(), A_varc.v(), A_var.v() },
                                                                               new PhysicalDomain[] { CH1.v(), H1.v(), C1.v(), V1.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Robjc_obj_varc_varBDD reader =
              (Robjc_obj_varc_varBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_var.v(), A_obj.v(), A_varc.v(), A_objc.v() },
                                                           new PhysicalDomain[] { V1.v(), H1.v(), C1.v(), CH1.v() },
                                                           "reader.add(in) at Qobjc_obj_varc_varBDD.jedd:40,12-18",
                                                           in));
        }
    }
    
    public Robjc_obj_varc_var reader(String rname) {
        Robjc_obj_varc_var ret =
          new Robjc_obj_varc_varBDD(name +
                                    ":" +
                                    rname,
                                    this);
        readers.add(ret);
        return ret;
    }
}
