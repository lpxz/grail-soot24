package aTest;

import java.util.Random;

import soot.jbco.util.Rand;

public class Teacher {

   Object stu2;
   public static Object field ;

	public static void main(String[] args) {
          Teacher teacher = new Teacher();
	      teacher.callee();

	      Random r = new Random();
	      r.setSeed(0);
	      for(int i=0;i<10;i++)
	      {
	    	  System.out.println(r.nextInt());
	      }
	      
	}
	public void callee() {
		synchronized (Teacher.class) {
//			stu2= null;
//			if(stu2==null)
//			{
//				System.out.println("haha");
//			}
			
		}
		
		
	}

}
