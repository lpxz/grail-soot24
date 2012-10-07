import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DirectLoad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime= System.currentTimeMillis();
	Object loaded= singlefileLoad();
	
	long endTime = System.currentTimeMillis();
	long passedTime=endTime-startTime;
	System.out.println("load costs :"+ passedTime);

	}
	public static Object singlefileLoad() {
		 Object returnObj=null;

		 ObjectInputStream ois =null;
		 FileInputStream fis=null;
			
			try {
				if(ois==null)
				{
					fis = new FileInputStream("testXS.txt");
					ois = new ObjectInputStream(fis);	
				}

				returnObj=ois.readObject();

				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return returnObj;
	}

}
