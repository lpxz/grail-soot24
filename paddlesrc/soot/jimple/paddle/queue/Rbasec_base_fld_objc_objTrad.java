package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rbasec_base_fld_objc_objTrad extends Rbasec_base_fld_objc_objIter {
    Rbasec_base_fld_objc_objTrad(QueueReader r, String name, PaddleQueue q) { super(r, name, q); }
    
    public Rbasec_base_fld_objc_objTrad copy() {
        return new Rbasec_base_fld_objc_objTrad((QueueReader) ((QueueReader) r).clone(), name, queue()); }
}
