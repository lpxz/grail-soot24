package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrc_fld_dstSet extends Qsrc_fld_dst {
    public Qsrc_fld_dstSet(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(VarNode _src, PaddleField _fld, VarNode _dst) {
        invalidate();
        Rsrc_fld_dst.Tuple in = new Rsrc_fld_dst.Tuple(_src, _fld, _dst);
        for (Iterator it = readers.iterator(); it.hasNext(); ) { Rsrc_fld_dstSet reader = (Rsrc_fld_dstSet) it.next();
                                                                 reader.add(in); } }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rsrc_fld_dst reader(String rname) { Rsrc_fld_dst ret = new Rsrc_fld_dstSet(name + ":" + rname, this);
                                               readers.add(ret);
                                               return ret; }
    
    public Rsrc_fld_dst revreader(String rname) { Rsrc_fld_dst ret = new Rsrc_fld_dstRev(name + ":" + rname, this);
                                                  readers.add(ret);
                                                  return ret; }
}
