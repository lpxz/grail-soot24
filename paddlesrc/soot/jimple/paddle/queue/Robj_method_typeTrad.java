package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Robj_method_typeTrad extends Robj_method_typeIter {
    Robj_method_typeTrad(QueueReader r, String name, PaddleQueue q) { super(r, name, q); }
    
    public Robj_method_typeTrad copy() {
        return new Robj_method_typeTrad((QueueReader) ((QueueReader) r).clone(), name, queue()); }
}
