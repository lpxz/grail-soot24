package aTSE.traceProcess;

import java.util.List;

public class MatchTrace {
  
	public static void template()// copy the code inside to the proper place
	{
        StackTraceElement[] elements=  new Exception("Stack trace").getStackTrace();
        List<List> chain = ProcessTrace.parse("/home/lpxz/eclipse/workspace/soot24/src/aTSE/traceProcess/test.txt");
        boolean result =MatchTrace.match(elements, chain);
        System.err.println(result);
	}
	
	public static boolean match(StackTraceElement[] elements ,  List<List> chain)
	{
		List firstChain= chain.get(0);
		for(int i=0;i< elements.length; i++)// in-> out
        {
	       	 StackTraceElement ele = elements[i];
	       	 String classname =ele.getClassName();
	       	 String methodname = ele.getMethodName();
	       	 // note that for before constrcut, the pointcut name can not be recognized.
	       	 //at ContextSensitive.ajc$before$ContextSensitive$1$8937e300(ContextSensitive.aj:11)
//	       	 if(methodname.contains("_aroundBody"))
//	       	 {
//	       		 int firstOc  = methodname.indexOf("_aroundBody");
//	       		 methodname = methodname.substring(0, firstOc);
//	       		
//	       	 }
	       	 String cm = (classname +"."+ methodname);
	      
	       	 if(i<firstChain.size())
	       	 {
	       		 String cmTrace=	(String)firstChain.get(i);
	       		
	 	         if(!cm.equals(cmTrace))
	 	         {
	 	        	 return false;
	 	         }
	 	      }
	       	 else {
				return true;// within my capacity.
			}
        
        }
		return true ; // not false yet after inspecting all.
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
