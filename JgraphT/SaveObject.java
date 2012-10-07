import java.io.*;
import java.util.zip.*;

public class SaveObject {
	
	public static void saveObjects(int times, boolean bvalue) throws 
    Exception {

	      // serialize the objects sarah and sam
	      FileOutputStream fos = new 
	        FileOutputStream("db");
	  //  
	      
	      ObjectOutputStream oos = null;
	      if(bvalue)
	      {
	    	  GZIPOutputStream gz = new GZIPOutputStream(fos);
		   oos=   new 
		        ObjectOutputStream(gz);
	      }else {
			oos= new  ObjectOutputStream(fos);
		  }

	      
	      //=================heat up
	      int sum=0;
	      for(int i=1; i<=1000;i++)
	      {sum+=i;
	    	  
	      }
	      System.out.println(sum);
	      //=========================
	      PerformanceDemo.PrepareGraphs();
	      
	      long start=System.currentTimeMillis();
	      for(int i=1;i<=times;i++)
	      {
	          oos.writeObject(PerformanceDemo.g1);
	          oos.writeObject(PerformanceDemo.g2);
	      }

	      
	      long end =System.currentTimeMillis();
	      System.out.println("save:" + times +" uses"+ (end-start));
	      oos.flush();
	      oos.close();
	      fos.close();
	   
	
	}
   public static void main(String argv[]) throws 
     Exception {
	   int i= Integer.parseInt(argv[0]);
	   boolean bvalue = Boolean.parseBoolean(argv[1]);
	   saveObjects(i*10,bvalue);
   }
}