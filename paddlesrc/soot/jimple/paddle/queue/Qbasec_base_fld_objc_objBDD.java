package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qbasec_base_fld_objc_objBDD extends Qbasec_base_fld_objc_obj {
    public Qbasec_base_fld_objc_objBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(Context _basec,
                    AllocNode _base,
                    PaddleField _fld,
                    Context _objc,
                    AllocNode _obj) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                                new PhysicalDomain[] { CH1.v(), H1.v(), FD.v(), CH2.v(), H2.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qbasec_base_fld_objc_objBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _basec, _base, _fld, _objc, _obj },
                                                                               new Attribute[] { A_basec.v(), A_base.v(), A_fld.v(), A_objc.v(), A_obj.v() },
                                                                               new PhysicalDomain[] { CH1.v(), H1.v(), FD.v(), CH2.v(), H2.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Rbasec_base_fld_objc_objBDD reader =
              (Rbasec_base_fld_objc_objBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_fld.v(), A_base.v(), A_basec.v(), A_obj.v(), A_objc.v() },
                                                           new PhysicalDomain[] { FD.v(), H1.v(), CH1.v(), H2.v(), CH2.v() },
                                                           "reader.add(in) at Qbasec_base_fld_objc_objBDD.jedd:40,12-18",
                                                           in));
        }
    }
    
    public Rbasec_base_fld_objc_obj reader(String rname) {
        Rbasec_base_fld_objc_obj ret =
          new Rbasec_base_fld_objc_objBDD(name +
                                          ":" +
                                          rname,
                                          this);
        readers.add(ret);
        return ret;
    }
}
