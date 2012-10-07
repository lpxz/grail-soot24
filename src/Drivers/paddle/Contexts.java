package Drivers.paddle;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import soot.Context;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.paddle.AllocNode;
import soot.jimple.paddle.ContextAllocNode;
import soot.util.Cons;

public class Contexts {

    private Map contextAllocMap = new HashMap();
    public PairKey getCtxtAlloc( Context ctxt, AllocNode var ) {
        PairKey c = new PairKey(ctxt, var);
        PairKey ret = (PairKey) contextAllocMap.get(c);
        if(ret==null) 
        {
        	contextAllocMap.put(c, c);
        	ret = (PairKey)contextAllocMap.get(c);
        }
        return ret;
    }
    
    private Map contextMethodMap = new HashMap();
    public PairKey getCtxtMethod( Context ctxt, SootMethod  sm ) {
        PairKey c = new PairKey(ctxt, sm);
        PairKey ret = (PairKey) contextMethodMap.get(c);
        if(ret==null) 
        {
        	contextMethodMap.put(c, c);
        	ret = (PairKey)contextMethodMap.get(c);
        }
        return ret;
    }
    

    private Map contextAlloc_fieldMap = new HashMap();
    public PairKey getCtxtAlloc_field( PairKey ctxtVar, SootField sf ) {
        PairKey c = new PairKey(ctxtVar, sf);
        PairKey ret = (PairKey) contextAlloc_fieldMap.get(c);
        if(ret==null) 
        {
        	contextAlloc_fieldMap.put(c, c);
        	ret = (PairKey)contextAlloc_fieldMap.get(c);
        }
        return ret;
    }
    
    
    private Map testMap = new HashMap();
    public PairKey getStrStr( String ctxt, String  sm ) {
        PairKey c = new PairKey(ctxt, sm);
        PairKey ret = (PairKey) testMap.get(c);
        if(ret==null) 
        {
        	testMap.put(c, c);
        	ret = (PairKey)testMap.get(c);
        }
        return ret;
    }
	public static void main(String[] args) {
	     Contexts cc = new Contexts();
	     PairKey ab=cc.getStrStr("a", "b");
         PairKey ba =cc.getStrStr("b", "a");
         PairKey abCopy =cc.getStrStr("a", "b");
         Assert.assertTrue(ab!=ba);
         Assert.assertTrue(ab==abCopy);
      //   Assert.assertTrue(ab==ba);
         
         
	}
	
	public final class PairKey {
		public Object get1()
		{
			return car;
		}
		public Object get2()
		{
			return cdr;
		}
	    public PairKey( Object car, Object cdr ) {
	        this.car = car;
	        this.cdr = cdr;
	    }
	    final private Object car;
	    final private Object cdr;
	    public int hashCode() {
	        int ret = 0;
	        if( car != null ) ret += car.hashCode();
	        if( cdr != null ) ret += cdr.hashCode();
	        return ret;
	    }
	    public boolean equals(Object o) {
	        if( !( o instanceof PairKey ) ) return false;
	        PairKey other = (PairKey) o;
	        if( car == null ) {
	            if( other.car != null ) return false;
	        } else {
	            if( !car.equals(other.car) ) return false;
	        }
	        if( cdr == null ) {
	            if( other.cdr != null ) return false;
	        } else {
	            if( !cdr.equals(other.cdr) ) return false;
	        }
	        return true;
	    }
	    public Object car() { return car; }
	    public Object cdr() { return cdr; }
	}

}
