package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qctxt_methodDebug extends Qctxt_method {
    public Qctxt_methodDebug(String name) {
        super(name);
    }
    
    private Qctxt_methodBDD bdd =
      new Qctxt_methodBDD(name +
                          "bdd");
    
    private Qctxt_methodSet trad =
      new Qctxt_methodSet(name +
                          "set");
    
    public void add(Context _ctxt,
                    SootMethod _method) {
        invalidate();
        bdd.add(_ctxt,
                _method);
        trad.add(_ctxt,
                 _method);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { A_ctxt.v(), A_method.v() },
                                              new PhysicalDomain[] { C1.v(), MS.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at Qctxt_methodDebug.je" +
                                               "dd:40,22-24"),
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
        return new Rctxt_methodDebug((Rctxt_methodBDD)
                                       bdd.reader(rname),
                                     (Rctxt_methodSet)
                                       trad.reader(rname),
                                     name +
                                     ":" +
                                     rname,
                                     this);
    }
}
