package ca.pfv.spmf.tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.associationrules.IGB.AlgoGenIGBClosed;
import ca.pfv.spmf.associationrules.IGB.RulesIGB;
import ca.pfv.spmf.associationrules.MNRRules.AlgoMNRRules;
import ca.pfv.spmf.associationrules.MNRRules.RulesMNR;
import ca.pfv.spmf.frequentpatterns.zart.AlgoZart;
import ca.pfv.spmf.frequentpatterns.zart.ContextZart;
import ca.pfv.spmf.frequentpatterns.zart.ItemsetZart;
import ca.pfv.spmf.frequentpatterns.zart.TZTableClosed;

/**
 * Class to test the class "AlgoGenIGBClosed".
 * 
 * @author Philippe Fournier-Viger, 2008
 */
public class MainTestMNRRules {

	public static void main(String[] args) throws IOException {
		System.out.println("STEP 1 : EXECUTING THE ZART ALGORITHM TO FIND CLOSED ITEMSETS AND MINIMUM GENERATORS");
		TZTableClosed results = null;
		// Load a binary context
		ContextZart context = new ContextZart();
		try {
			context.loadFile(fileToPath("contextZart.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		long timeStamp = System.currentTimeMillis();
		// Apply the Zart algorithm
		AlgoZart zart = new AlgoZart(0.60);
		results = zart.runAlgorithm(context);
		long timeStamp2 = System.currentTimeMillis();
		System.out.println("ZART EXECUTION TIME : " + (timeStamp2 - timeStamp) + " ms");
		
		
		// PRINT RESULTS FROM THE ZART ALGORITHM
		int countClosed=0;
		int countGenerators=0;
		System.out.println("===================");
		for(int i=0; i< results.levels.size(); i++){
			System.out.println("LEVEL : " + i);
			for(ItemsetZart closed : results.levels.get(i)){
				System.out.println(" CLOSED : " + closed.toString() + "  supp : " + closed.getAbsoluteSupport());
				countClosed++;
				System.out.println("   GENERATORS : ");
					for(ItemsetZart generator : results.mapGenerators.get(closed)){
						countGenerators++;
						System.out.println("     =" + generator.toString());
					}
			}
		}
		
		System.out.println("STEP 2 : CALCULATING MNR ASSOCIATION RULES");
		double minconf = 0.60; // minimum confidence
		// Create MNR rules.
		AlgoMNRRules algoMNR = new AlgoMNRRules(minconf);
		RulesMNR rules = algoMNR.runAlgorithm(results );
		rules.printRules(context.getObjects().size());
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestMNRRules.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
