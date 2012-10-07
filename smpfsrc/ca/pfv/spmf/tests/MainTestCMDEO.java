package ca.pfv.spmf.tests;

import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.sequential_rules.cmdeogun.AlgoCMDeogun;
import ca.pfv.spmf.sequential_rules.cmdeogun.Rules;
import ca.pfv.spmf.sequential_rules.cmdeogun.SequenceDatabase;

/**
 * Class to test the the CMDEO algorithm
 * @author Philippe Fournier-Viger (Copyright 2010)
 */
public class MainTestCMDEO {

	public static void main(String [] arg){
		// Loading the database
		SequenceDatabase sequenceDatabase = new SequenceDatabase(); 
		try {
			sequenceDatabase.loadFile(fileToPath("contextPrefixSpan.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sequenceDatabase.printContext();
		sequenceDatabase.printDatabaseStats();
		
		double minSup = 0.75;
		double minConf = 0.50; 
		AlgoCMDeogun algo = new AlgoCMDeogun();
		
		// TO SET MINIMUM / MAXIMUM SIZE CONSTRAINTS you can use the following lines:
//		algo.setMinLeftSize(1);
//		algo.setMaxLeftSize(2);
//		algo.setMinRightSize(1);
//		algo.setMaxRightSize(2);
		
		Rules rules = algo.runAlgorithm(minSup, minConf, sequenceDatabase);
		
		rules.printRules(sequenceDatabase.size());
		algo.printStats();
		
	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestCMDEO.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
