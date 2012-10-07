package aTSE.codeRegion;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;


import soot.Unit;
import soot.tagkit.LineNumberTag;

public class Criteria {
	//instance-base reflection
	// use unique names for eqch method! there is a naming mechanism in the reflection=bsed invocation
	// use the Integer instead of int in the argument! for relfection-based invocation.
	public  String methodName  ="";
	public  List  argList = null;
	private static final String LINENUMBERTAG = "LineNumberTag";
 
 public	 boolean equalineNO(Integer lineNOParObj, Unit unit ){
		    int lineNOPar = lineNOParObj.intValue();
			LineNumberTag lt = (LineNumberTag)unit.getTag(LINENUMBERTAG);
			int lineNo=-1;
			if(lt!=null)
			{
			  lineNo=	lt.getLineNumber();
			}
			else {
				System.err.println("no line tag avialable");
				throw new RuntimeException();
				
			}
			return (lineNOPar == lineNo);		
	}
	public static void main(String[] args) throws Exception {
		 Criteria criteria = new Criteria();
		 String metC  = criteria.methodName;
		 Class cls = Class.forName("aTSE.select.Criteria");
		 Method torun =null;
         Method[] methodsR= cls.getMethods();
         for(int i=0;i<methodsR.length;i++)
         {
      	   Method  mR = methodsR[i];
      	   if(mR.getName().equals(metC))
      	   {
      		   torun =mR;
      		   break;
      	   }
         }
         List argList = new ArrayList();
         argList.add(new Integer(5));
         Object o = new Object();
         argList.add((Unit)o );
         torun.invoke(criteria, argList);
         
         

	}

}
