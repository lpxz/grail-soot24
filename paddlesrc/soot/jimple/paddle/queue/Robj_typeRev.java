package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Robj_typeRev extends Robj_typeSet {
    public Robj_typeRev(String name, PaddleQueue q) { super(name, q); }
    
    void add(Tuple tuple) { bdd.addFirst(tuple); }
}
