
public class Batch {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		boolean bvalue =false;
		for(int i=0;i<=9;i++)
		{
			int times  = 100000*i;
			 SaveObject.saveObjects(times,bvalue);
			 ReadObject.readObjects(times,bvalue);
			 
		
		}

	}

}
