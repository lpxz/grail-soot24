package soot.jimple.toolkits.thread.synchronizationLP.Jimples;
//soot.jimple.toolkits.thread.synchronizationLP.Jimples.JavaBlockRepo
import java.util.ArrayList;
import java.util.List;

public class JavaBlockRepo {
     
	public static List block1(List paraList)
	{
          Integer intGet = (Integer)paraList.get(0);
          if(intGet.intValue()>5)
        	   intGet--;
          ArrayList  list = new ArrayList();
          list.add(intGet);
          return list;
		
	}
	
	public static List block2(List paraList)
	{
         for(int i=0;i<paraList.size();i++)
         {
        	 System.out.println(paraList.get(i));
         }
		return null;
	}
	
	public static List block3(List paraList)
	{
    long time= System.currentTimeMillis();
    System.out.println(time);
    return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
