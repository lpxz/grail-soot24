package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class QobjSet extends Qobj {
    public QobjSet(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(AllocNode _obj) {
        invalidate();
        Robj.Tuple in = new Robj.Tuple(_obj);
        for (Iterator it = readers.iterator(); it.hasNext(); ) { RobjSet reader = (RobjSet) it.next();
                                                                 reader.add(in); } }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Robj reader(String rname) { Robj ret = new RobjSet(name + ":" + rname, this);
                                       readers.add(ret);
                                       return ret; }
    
    public Robj revreader(String rname) { Robj ret = new RobjRev(name + ":" + rname, this);
                                          readers.add(ret);
                                          return ret; }
}
