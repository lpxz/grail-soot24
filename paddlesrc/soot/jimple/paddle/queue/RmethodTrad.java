package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class RmethodTrad extends RmethodIter {
    RmethodTrad(QueueReader r, String name, PaddleQueue q) { super(r, name, q); }
    
    public RmethodTrad copy() { return new RmethodTrad((QueueReader) ((QueueReader) r).clone(), name, queue()); }
}
