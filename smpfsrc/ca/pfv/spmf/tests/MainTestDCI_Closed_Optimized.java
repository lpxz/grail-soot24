package ca.pfv.spmf.tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.frequentpatterns.dci_closed_optimized.AlgoDCI_Closed_Optimized;

/**
 * Class to test the DCI_Closed algorithm .
 * @author Philippe Fournier-Viger 
 */
public class MainTestDCI_Closed_Optimized {

	public static void main(String [] arg) throws IOException{
		
		String input = ("/home/lpxz/eclipse/workspace/soot24/smpf/batik_smpfData");
		String output = "/home/lpxz/eclipse/workspace/smpf/output";
		int minsup = 1;  // means 2 transactions (we use a relative support)
		
		// Applying the  algorithm
		AlgoDCI_Closed_Optimized algorithm = new AlgoDCI_Closed_Optimized();
		algorithm.runAlgorithm(input, output, minsup);
	}
	
public static void DCI_close(String input, String output, int minSupportArg) {		

		int minsup = minSupportArg;  // means 2 transactions (we use a relative support)
		
		// Applying the  algorithm
		AlgoDCI_Closed_Optimized algorithm = new AlgoDCI_Closed_Optimized();
		try {
			algorithm.runAlgorithm(input, output, minsup);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestDCI_Closed_Optimized.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
