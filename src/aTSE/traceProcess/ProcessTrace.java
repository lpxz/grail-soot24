package aTSE.traceProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class ProcessTrace {

//	java.lang.ArithmeticException: / by zero
//	at Yada.java.Barrier.enterBarrier(Barrier.java:10)
//	at Bayes.Bayes.main(Bayes.java:229)
	public static void main(String[] args) {
		String filename = "/home/lpxz/eclipse/workspace/soot24/src/aTSE/traceProcess/test.txt";
		parse(filename);
         
	}
  
   public static String at  ="at";
   public static boolean hasAt = false;
   //NOTE that the trace should be well -formed
   // just have a look at the debugging OG.
   //we often care about the stack=list.get(0), and the stack.peek() is the nearest caller method.
	public static List<List> parse(String filename) {
		try {
		    BufferedReader in = new BufferedReader(new FileReader(filename));
		    String str;
		    List<List> chain = new ArrayList<List>();// the first one is always the presentation one
		    boolean lastFirstNonAt= true; // the first is nonat
		    while ((str = in.readLine()) != null) {
		    	
		        StringTokenizer st = new StringTokenizer(str);
		        if( st.hasMoreTokens())//first token of the statement
		        {
		        	String token = st.nextToken();
		        	if(token.equals(at))
		        	{
		        		hasAt=true;
		        		if(lastFirstNonAt)
		        		{
		        			//System.err.println("create a new stack");
		        			List stack = new ArrayList();
		        			chain.add(stack);// the last stack in the chain		        			
		        		}
		        		
		        		lastFirstNonAt= false;
		        	}
		        	else {
		        		lastFirstNonAt= true;
					}
		        }
		        if(hasAt)//second toekn, only has at do we insert it to the stack
		        {
		        	if( st.hasMoreTokens())
			        {
			        	String token = st.nextToken();
			        	int leftParent =token.indexOf('(');
			        	int rightParent = token.indexOf(')');
			        	String cm = token.substring(0, leftParent);
			        	String phyLoc = token.substring(leftParent+1, rightParent);	
			        	List stack =chain.get(chain.size()-1);
			        	stack.add(cm);// in-> out
			        }
		        	
		        }

		        
		    }
		    hasAt=false;
		   
		    in.close();
//		    // reverse each stack, so that the element appearing first is placed in the top (as in the calling relations), instead of being in the bottom.
//		    for(int i=0;i< chain.size();i++)
//		    {
//		    	Stack stack =chain.get(i);
//		       Stack stacktmp = new Stack();
//		       Object o=null;
//		       while((stack.size()!=0)&&( o = stack.pop())!=null)
//		       {
//		    	   stacktmp.push(o);
//		       }
//		       chain.set(i, stacktmp);
//		       
//		    }
		    return chain;
		} catch (IOException e) {
			return null;
		}
		

		
		
		
	}
	

}
