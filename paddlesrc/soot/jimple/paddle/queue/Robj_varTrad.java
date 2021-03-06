package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Robj_varTrad extends Robj_varIter {
    Robj_varTrad(QueueReader r, String name, PaddleQueue q) { super(r, name, q); }
    
    public Robj_varTrad copy() { return new Robj_varTrad((QueueReader) ((QueueReader) r).clone(), name, queue()); }
}
