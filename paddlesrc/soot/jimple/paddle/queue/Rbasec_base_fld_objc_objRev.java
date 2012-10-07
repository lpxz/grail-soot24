package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rbasec_base_fld_objc_objRev extends Rbasec_base_fld_objc_objSet {
    public Rbasec_base_fld_objc_objRev(String name, PaddleQueue q) { super(name, q); }
    
    void add(Tuple tuple) { bdd.addFirst(tuple); }
}
