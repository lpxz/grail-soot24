package aTSE.runtimeRegion;

import java.util.HashMap;
import java.util.HashSet;


import org.aspectj.lang.Signature;

import aTSE.OG.OGTraverse;
import aTest.Teacher;


public aspect RegionSE {

    //===============injected code:
	// inject the code to the class to be woven.
	public static void strangeStart(){};
	public static void strangeStop(){};
	//================region defintion:
    //put the startFlag state machine in right adivces.
	public static boolean startFlag = false;
	pointcut scope():within(aTest.*) && !within(aTSE.runtimeRegion.RegionSE);
     pointcut start() : scope()&& call(void  aTSE.runtimeRegion.RegionSE.strangeStart(..));
     pointcut stop() :scope() &&  call(void  aTSE.runtimeRegion.RegionSE.strangeStop(..));
     pointcut end():scope() && execution(void aTest.Teacher.main(..));
     
     after() : start() {
    	 startFlag= true;
    	 System.err.println("\nregion start");
      }
     after():stop()
     {
    	 startFlag= false;
    	 System.err.println("\nregion end");
    	 OGTraverse.ogvisit_root(setmap, Teacher.field);
     }
     
     after():end()
     {    	
    	 System.err.println("\n program end");
     }
     //============================SE:
 	public HashMap<Object, HashSet> setmap = new HashMap<Object, HashSet>();
	public HashMap<Object, HashSet> getmap = new HashMap<Object, HashSet>();
	public String ARRAYFIELD= "ARRAYFIELD" ;
     pointcut setfield(Object input, Object tgt) : scope() &&set(* *.*)&&args(input) && target(tgt);    
     after(Object input, Object tgt) : setfield(input, tgt)  {
    	 if(!startFlag) return;    		 
    	 String classname = tgt.getClass().toString();
    	 if(isLibrary(classname)) 
    		 return;
    	 Signature s = thisJoinPoint.getSignature(); 
    	 String fieldname="";
    	 try{
    		  fieldname =s.getName();
    		// System.out.println( s.getDeclaringType().getField(s.getName()));
    		 }
    		 catch (Exception e){
    		 e.printStackTrace();
    		 } 
    		HashSet set =  setmap.get(tgt);
    		if(set==null)
    		{
    			set = new HashSet();
    			setmap.put(tgt, set);
    		}
    		set.add(fieldname);
  //  		 System.err.println("setting the field " +fieldname +" of " + classname );
//    	System.err.println("setting object@" + tgt.hashCode() + " to" + input); 
    	 
     }
     
     
     pointcut getfield(Object tgt) :scope()&& get(* *.*)&&target(tgt);
     after(Object tgt) : getfield(tgt)  {
    	 if(!startFlag) return;    		 
    	 String classname = tgt.getClass().toString();
    	 if(isLibrary(classname)) 
    		 return;
    	 Signature s = thisJoinPoint.getSignature(); 
    	 String fieldname="";
    	 try{
    		  fieldname =s.getName();
    		// System.out.println( s.getDeclaringType().getField(s.getName()));
    		 }
    		 catch (Exception e){
    		 e.printStackTrace();
    		 } 
    		HashSet set =  getmap.get(tgt);
    		if(set==null)
    		{
    			set = new HashSet();
    			getmap.put(tgt, set);
    		}
    		set.add(fieldname);
  //  		 System.err.println("setting the field " +fieldname +" of " + classname );
//    	System.err.println("setting object@" + tgt.hashCode() + " to" + input); 
    	 
     }
     
 before (Object tgt) : scope() && set(*[] *) && target(tgt){
	// System.err.println(thisJoinPoint.getSignature());// the whole array
	 if(!startFlag) return;    		 
	 String classname = tgt.getClass().toString();
	 if(isLibrary(classname)) 
		 return;
	
	 String fieldname=ARRAYFIELD;
	 
		HashSet set =  setmap.get(tgt);
		if(set==null)
		{
			set = new HashSet();
			setmap.put(tgt, set);
		}
		set.add(fieldname);

 }

 after (Object tgt)  :scope() &&  get(*[] *) && target(tgt){
	// System.err.println(thisJoinPoint.getSignature());
             //get(Object[] Bayes.Vector_t.elements)Bayes.Vector_t@1051e66

	 if(!startFlag) return;    		 
	 String classname = tgt.getClass().toString();
	 if(isLibrary(classname)) 
		 return;
	 Signature s = thisJoinPoint.getSignature(); 
	 String fieldname=ARRAYFIELD; 

		HashSet set =  getmap.get(tgt);
		if(set==null)
		{
			set = new HashSet();
			getmap.put(tgt, set);
		}
		set.add(fieldname);
//  		 System.err.println("setting the field " +fieldname +" of " + classname );
//	System.err.println("setting object@" + tgt.hashCode() + " to" + input); 
	 
 
 } 
     

  
private boolean isLibrary(String classname) {
	{// special treatment.
		if(classname.startsWith("java.util."))// speciall
		{
			return false;
		}
	}
	
	if(classname.startsWith("java.") || classname.startsWith("javax.")
			||classname.startsWith("sun.")||
			classname.startsWith("javax.")||
			classname.startsWith("com.sun.")||
			classname.startsWith("com.ibm.")||
			classname.startsWith("org.xml.")||
			classname.startsWith("org.w3c.")||
			classname.startsWith("com.apple."))
   
	{
		return true;
	}
	else {
		return false;
	}
	}






}
