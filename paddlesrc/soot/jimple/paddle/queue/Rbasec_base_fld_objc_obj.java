package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Rbasec_base_fld_objc_obj implements PaddleQueueReader {
    public Rbasec_base_fld_objc_obj(String name, PaddleQueue q) { super();
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
        private Context _basec;
        
        public Context basec() { return _basec; }
        
        private AllocNode _base;
        
        public AllocNode base() { return _base; }
        
        private PaddleField _fld;
        
        public PaddleField fld() { return _fld; }
        
        private Context _objc;
        
        public Context objc() { return _objc; }
        
        private AllocNode _obj;
        
        public AllocNode obj() { return _obj; }
        
        public Tuple(Context _basec, AllocNode _base, PaddleField _fld, Context _objc, AllocNode _obj) {
            super();
            this._basec = _basec;
            this._base = _base;
            this._fld = _fld;
            this._objc = _objc;
            this._obj = _obj; }
        
        public int hashCode() { return 0; }
        
        public boolean equals(Object other) { if (!(other instanceof Tuple)) return false;
                                              Tuple o = (Tuple) other;
                                              if (o._basec != _basec) return false;
                                              if (o._base != _base) return false;
                                              if (o._fld != _fld) return false;
                                              if (o._objc != _objc) return false;
                                              if (o._obj != _obj) return false;
                                              return true; }
        
        public String toString() { StringBuffer ret = new StringBuffer();
                                   ret.append(basec());
                                   ret.append(", ");
                                   ret.append(base());
                                   ret.append(", ");
                                   ret.append(fld());
                                   ret.append(", ");
                                   ret.append(objc());
                                   ret.append(", ");
                                   ret.append(obj());
                                   ret.append(", ");
                                   return ret.toString(); }
    }
    
}
