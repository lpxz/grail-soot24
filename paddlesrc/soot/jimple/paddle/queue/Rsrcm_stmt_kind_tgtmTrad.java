package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Rsrcm_stmt_kind_tgtmTrad extends Rsrcm_stmt_kind_tgtmIter {
    Rsrcm_stmt_kind_tgtmTrad(QueueReader r, String name, PaddleQueue q) { super(r, name, q); }
    
    public Rsrcm_stmt_kind_tgtmTrad copy() {
        return new Rsrcm_stmt_kind_tgtmTrad((QueueReader) ((QueueReader) r).clone(), name, queue()); }
}
