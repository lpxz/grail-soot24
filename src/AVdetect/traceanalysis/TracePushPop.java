package AVdetect.traceanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.omg.CORBA.PUBLIC_MEMBER;

import AVdetect.bug.AVTuple;
import Drivers.Chocalate;

public class TracePushPop {

	/**
	 * @param args
	 */
	public static String readFile(File file, List<String> lines)
	throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream(file)));
try {
	StringBuilder ret = new StringBuilder();
	String line;
	while ((line = reader.readLine()) != null) {
		ret.append(line);
		lines.add(line);
		ret.append("\n");
	}
	return ret.toString();
} finally {
	reader.close();
}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String>();
		String testfile = "/home/lpxz/eclipse/workspace/soot24/src/AVdetect/traceanalysis/trace.txt";
	
		try {
			String source = readFile(new File(testfile), lines);
			stacking(lines);
			

	    }
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void stacking(List<String> lines) {
		HashMap<Long,  Stack> map = new HashMap<Long, Stack>();

		for (int i = 0; i < lines.size(); i++) {
			String lineString = lines.get(i);
			if(lineString.equals(""))
			{continue;}
			if(lineString.startsWith("after"))
				continue;
			int douhao = lineString.indexOf(',');
			int maohao = lineString.indexOf(':');
			int lBrace = lineString.indexOf('(');
			
			try {
				lineString.substring(0, douhao);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String beforeDouhao= lineString.substring(0, douhao);
			String beforeMaoHao = lineString.substring(douhao+1, maohao);
			String methodName  = lineString.substring(maohao+1, lBrace);
				
			long tid = Long.parseLong(beforeDouhao);
			Stack stack = map.get(tid);
			if(stack==null)
			{
				stack = new Stack();
				map.put(tid, stack);				
			}
		
			if(beforeMaoHao.contains("pushed"))
			{
				stack.push(methodName);
				if(tid==40)
				{
					if(lineString.contains("attempt"))
					System.out.println(lineString);
//					if(lineString.equals("23,pushed:org.exolab.jms.net.proxy.Proxy.invoke(RegistryImpl__Proxy.java:39)"))
//					{
//						System.err.println("xxx");
//					}
				}
				
			}
			else if (beforeMaoHao.contains("exiting")) {
				String pString = (String) stack.peek();
				if(methodName.equals(pString))
				{
					stack.pop();
					if(tid==40)
					{
						if(lineString.contains("attempt"))
							System.out.println(lineString);
					}
					
				}
				else {
					throw new RuntimeException();
					//popUtilHitting(stack, methodName);
//					System.err.println("line NO wrong: " + i);
//					
//					System.out.println("stack information:");
//					for(Object o : stack)
//					{
//						System.out.println(o.toString());
//					}
////					
//					System.out.println("10 exiting since the error");
//					for(int k = i; k<= i+20; k++)
//					{
//						System.out.println(lines.get(k));
//					}					
//					throw new RuntimeException();
				}
			}
			else {
				throw new RuntimeException();
			}
			

		}
		
	}
	private static void popUtilHitting(Stack stack, String methodName) {
		
		while(stack.size() !=0)
		{
			Object o =stack.peek();
			if(!o.toString().equals(methodName))
			{
				stack.pop();
			}
			else {
				break;
			}
		}
		if(stack.size()==0)
		{
			throw new RuntimeException();
		}
		if(stack.peek().toString().equals(methodName))
		{ 
			 Object poped = stack.pop();// the top is the methodName now, exiting it
		     System.out.println(poped);		     
		}
		else {
			throw new RuntimeException();
		}
	}

}
