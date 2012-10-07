package soot.jimple.toolkits.thread.synchronizationLP.Jimples;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String arg1 = args[0];
		System.out.println(arg1);
		List xx = new ArrayList();
		xx.add(1.2);
		
		Integer iii = (Integer)xx.get(1);
		int i =iii; 
		
       xx.add("xx");
	}
	
	public static void testBranch()
	{
		int i=1;
		if(i>2)
		{
			i++;
		}
		else if(i>=0) {
			i--;
		}
		else {
			i=i;
		}
	}
	
	public static void  testTrap()
	{
		int i=1;
		int j=100;
		int s = i-1;
		
			try {
				
				synchronized ("hello") {
				
					int divi= j/s;
				}
				
				int divi2 = j/s;
				
				
			} catch (Exception e) {
				System.out.println("what is up");
				throw new RuntimeException();
			}
		
		try {
			FileOutputStream fos= new FileOutputStream("file");
		    fos.write(4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
