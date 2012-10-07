package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qbasec_base_fld_objc_objNumTrace extends Qbasec_base_fld_objc_obj {
    public Qbasec_base_fld_objc_objNumTrace(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(Context _basec, AllocNode _base, PaddleField _fld, Context _objc, AllocNode _obj) {
        invalidate();
        Rbasec_base_fld_objc_obj.Tuple in = new Rbasec_base_fld_objc_obj.Tuple(_basec, _base, _fld, _objc, _obj);
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            Rbasec_base_fld_objc_objNumTrace reader = (Rbasec_base_fld_objc_objNumTrace) it.next();
            reader.add(in); }
    }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rbasec_base_fld_objc_obj reader(String rname) {
        Rbasec_base_fld_objc_obj ret = new Rbasec_base_fld_objc_objNumTrace(name + ":" + rname, this);
        readers.add(ret);
        return ret; }
}
