package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Rsrc_fld_dst implements PaddleQueueReader {
    public Rsrc_fld_dst(String name, PaddleQueue q) { super();
                                                      this.name = name;
                                                      this.q = q;
                                                      Readers.v().add(this); }
    
    protected String name;
    
    protected PaddleQueue q;
    
    public PaddleQueue queue() { return q; }
    
    public final String toString() { return name; }
    
    public abstract Iterator iterator();
    
    public abstract jedd.internal.RelationContainer get();
    
    public abstract boolean hasNext();
    
    public static class Tuple {
        private VarNode _src;
        
        public VarNode src() { return _src; }
        
        private PaddleField _fld;
        
        public PaddleField fld() { return _fld; }
        
        private VarNode _dst;
        
        public VarNode dst() { return _dst; }
        
        public Tuple(VarNode _src, PaddleField _fld, VarNode _dst) { super();
                                                                     this._src = _src;
                                                                     this._fld = _fld;
                                                                     this._dst = _dst; }
        
        public int hashCode() { return 0; }
        
        public boolean equals(Object other) { if (!(other instanceof Tuple)) return false;
                                              Tuple o = (Tuple) other;
                                              if (o._src != _src) return false;
                                              if (o._fld != _fld) return false;
                                              if (o._dst != _dst) return false;
                                              return true; }
        
        public String toString() { StringBuffer ret = new StringBuffer();
                                   ret.append(src());
                                   ret.append(", ");
                                   ret.append(fld());
                                   ret.append(", ");
                                   ret.append(dst());
                                   ret.append(", ");
                                   return ret.toString(); }
    }
    
}
