package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class QmethodTrace extends QmethodTrad {
    public QmethodTrace(String name) { super(name); }
    
    public void add(SootMethod _method) { G.v().out.print(name + ": ");
                                          G.v().out.print(_method + ", ");
                                          G.v().out.println();
                                          super.add(_method); }
}
