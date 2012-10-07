package pldi.research;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Drivers.Java4Jimple;

public class PostProcessLP {


	private static final String srcFolder = "/home/lpxz/eclipse/workspace/specjbb2005107_runnable/src";



	public static void main(String[] args) {
	  String filename ="/home/lpxz/eclipse/workspace/soot24/src/Drivers/research/postprocess.txt";
	  List<String> loadedStmts = new ArrayList<String>();
		loadFile(filename,loadedStmts);
		   Collections.sort(loadedStmts);

		//   loadedStmts= withinProcessScope(loadedStmts);
		   howmanyLocks(loadedStmts);
		   detailedInfo(loadedStmts);
		   
		   
	}

	

	private static void detailedInfo(List<String> loadedStmts) {
		   for(String str: loadedStmts)
		   {
			   System.out.println(str);// alphabetic natural
		   }
		
	}



	private static void howmanyLocks(List<String> loadedStmts) {
		
		
		Set<String>  lockIDs = new HashSet<String>();
		for(String str : loadedStmts)
		{
		   char[] chars =	str.toCharArray();
		   
		   for(int  i=0;i<chars.length;i++)
		   {
			   if(chars[i]=='@')
			   {
				   String getit="";
				   int j=i+1;
				   char ch;
				   while(( ch=chars[j])!=',')
				   {
					   getit=getit+ch;
					   j++;
				   }
				   lockIDs.add(getit);
			   }
		   }
		}
		//==================size is:
		System.out.println(lockIDs.size());
	    for(String got:lockIDs)
	    {
	    	String  locksig  ="public static Object  lock_"+got+ " = new Object();";
	    	System.out.println(locksig);
	    }

		
	}



	private static List<String> withinProcessScope(List<String> loadedStmts) {
		List<String> loadedStmtToRet = new ArrayList<String>();
		for(String str : loadedStmts)
		{
			String filename =null;
			try {
				 filename = getFileName(str);
			} catch (Exception e) {
				System.out.println("look at:"+str);
			}
			
			if(!filename.contains("Transaction.java")) continue;
			int lineNo  = getLineNo(str);
			String fileAbsPath = Java4Jimple.searchFileIn(filename, srcFolder);
			//================================================: process _scope
			File file = null;
			FileReader freader = null;
		    LineNumberReader lnreader = null;
		    try{
		      file = new File(fileAbsPath);
		      freader = new FileReader(file);
		      lnreader = new LineNumberReader(freader);
		      String line = "";
		      int left =0;
		      int right =0;
              boolean start = false; int startline =0;
              boolean end =false; int endline =0;
		      while ((line = lnreader.readLine()) != null){
		           if(line.contains("boolean")&& line.contains("process("))
		           {
		        	   start=true;
		        	   startline=lnreader.getLineNumber();
		        	   left = getleft(line);
		        	   continue;
		        	//   right =getright(line);
		           }
		           if(start)
		           {
		        	   left = left+getleft(line);
		        	   right =right+ getright(line);
		        	   if(left==right)
		        	   {
		        		   end=true;
		        		   endline= lnreader.getLineNumber();
		        		   break;
		        	   }
		        	   
		           }
		      }
		
		      
		      if(lineNo>=startline && lineNo<=endline)
		      {
		    	  loadedStmtToRet.add(str);
		      }
		      freader.close();
		      lnreader.close();
		    }
		    catch (Exception e) {
				System.out.println("I can not read it..sorry");
				
			}
		    //=========================================
		}
		
		return loadedStmtToRet;
	}



	private static int getleft(String line) {
		int sum=0;
		char[] chars= line.toCharArray();
		for(int i=0;i<chars.length;i++)
		{
			if(chars[i]=='{') sum++;
		}
		
		return sum;
	}
	private static int getright(String line) {
		int sum=0;
		char[] chars= line.toCharArray();
		for(int i=0;i<chars.length;i++)
		{
			if(chars[i]=='}') sum++;
		}
		
		return sum;
	}



	private static int getLineNo(String str) {
        int start = str.indexOf(' ');
        int end =str.indexOf(':');
        String linString= str.substring(start+1, end);
		return Integer.valueOf(linString);
	}



	private static String getFileName(String str) {
	    int start  = str.indexOf('/');
	    int end1 = str.indexOf(' ');
	    return str.substring(start+1, end1);
	//	return null;
	}



	private static void loadFile(String fileAbsPath, List loadedStmts) {

		
		File file = null;
	    FileReader freader = null;
	    LineNumberReader lnreader = null;
	    try{
	      file = new File(fileAbsPath);
	      freader = new FileReader(file);
	      lnreader = new LineNumberReader(freader);
	      String line = "";

	      while ((line = lnreader.readLine()) != null){
	      //   System.out.println("Line:  " + + ": " + line);
	    	  loadedStmts.add(line);
	        
	       
	      }
	
	      freader.close();
	      lnreader.close();
	    }
	    catch (Exception e) {
			System.out.println("I can not read it..sorry");
			
		}


	
		
	}

}
