package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qbasec_base_fld_objc_objTrace extends Qbasec_base_fld_objc_objTrad {
    public Qbasec_base_fld_objc_objTrace(String name) { super(name); }
    
    public void add(Context _basec, AllocNode _base, PaddleField _fld, Context _objc, AllocNode _obj) {
        G.v().out.print(name + ": ");
        G.v().out.print(_basec + ", ");
        G.v().out.print(_base + ", ");
        G.v().out.print(_fld + ", ");
        G.v().out.print(_objc + ", ");
        G.v().out.print(_obj + ", ");
        G.v().out.println();
        super.add(_basec, _base, _fld, _objc, _obj); }
}
