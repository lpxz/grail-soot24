package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrc_dstBDD extends Qsrc_dst {
    public Qsrc_dstBDD(String name) {
        super(name);
    }
    
    private LinkedList readers =
      new LinkedList();
    
    public void add(VarNode _src,
                    VarNode _dst) {
        add(new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                new PhysicalDomain[] { V1.v(), V2.v() },
                                                ("add(jedd.internal.Jedd.v().literal(new java.lang.Object[...]" +
                                                 ", new jedd.Attribute[...], new jedd.PhysicalDomain[...])) at" +
                                                 " Qsrc_dstBDD.jedd:34,8-11"),
                                                jedd.internal.Jedd.v().literal(new Object[] { _src, _dst },
                                                                               new Attribute[] { A_src.v(), A_dst.v() },
                                                                               new PhysicalDomain[] { V1.v(), V2.v() })));
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        if (!jedd.internal.Jedd.v().equals(jedd.internal.Jedd.v().read(in),
                                           jedd.internal.Jedd.v().falseBDD()))
            invalidate();
        for (Iterator it =
               readers.iterator();
             it.hasNext();
             ) {
            Rsrc_dstBDD reader =
              (Rsrc_dstBDD)
                it.next();
            reader.add(new jedd.internal.RelationContainer(new Attribute[] { A_src.v(), A_dst.v() },
                                                           new PhysicalDomain[] { V1.v(), V2.v() },
                                                           "reader.add(in) at Qsrc_dstBDD.jedd:40,12-18",
                                                           in));
        }
    }
    
    public Rsrc_dst reader(String rname) {
        Rsrc_dst ret =
          new Rsrc_dstBDD(name +
                          ":" +
                          rname,
                          this);
        readers.add(ret);
        return ret;
    }
}
