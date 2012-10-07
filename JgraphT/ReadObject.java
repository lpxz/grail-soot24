import java.io.*;
import java.util.zip.*;

public class ReadObject {
	
	  public static void readObjects(int times, boolean bvalue) throws 
	     Exception{

	      //deserialize objects sarah and sam
	      FileInputStream fis = new FileInputStream("db");
	      ObjectInputStream ois =null;
	 //    GZIPInputStream gs = new GZIPInputStream(fis);
	      if(bvalue)
	      {
	    	  GZIPInputStream gs = new GZIPInputStream(fis);
	    	  ois = new ObjectInputStream(gs);
	      }
	       else {
	    	   ois = new ObjectInputStream(fis);
		  }
	    
	      
	      
	      //=================heat up
	      int sum=0;
	      for(int i=1; i<=1000;i++)
	      {sum+=i;
	       }
	      System.out.println(sum);
	      //=========================
	      
	      
	      long start=System.currentTimeMillis();
	      for(int i=1;i<=times;i++)
	      {
	          Object g1= ois.readObject();
	          Object g2= ois.readObject();
	      }

	      
	      long end =System.currentTimeMillis();
	      System.out.println("read:" + times +" uses"+ (end-start));

	      //print the records after reconstruction of state
//	      sarah.print();
//	      sam.print();
	      ois.close();
	      fis.close();
	   
		  
	  }
   public static void main(String argv[]) throws 
     Exception{
	 //  readObjects(300000);
	   int i= Integer.parseInt(argv[0]);
	   boolean bvalue = Boolean.parseBoolean(argv[1]);
	   readObjects(i*10,bvalue);
//	   for(int i=1;i <=9; i=i+2)
//	   {
//		  
//		   SaveObject.saveObjects(i*100000);
//		   readObjects(i*100000);
//	   }
	   }
}