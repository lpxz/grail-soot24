package ca.pfv.spmf.sequential_rules.cmdeogun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



/**
 * An algorithm for mining sequential rules common to several sequences
 * adapted from the algorithm of Deogun et al.
 * 
 * It is described very briefly in section "Evaluation of the algorithm" of this paper:
 * 
 * Fournier-Viger, P., Faghihi, U., Nkambou, R. & Mephu Nguifo, E. (2010). 
 * CMRules: An Efficient Algorithm for Mining Sequential Rules Common to Several Sequences. 
 * Proceedings of the 23th International Florida Artificial Intelligence Research Society Conference 
 * (FLAIRS 2010). AAAI press. 
 * 
 * and a french description is provided in my Ph.D. thesis.
 * 
 * @author Philippe Fournier-Viger, 2009
 */
public class AlgoCMDeogun {
	
	Rules sequentialRules =  new Rules("All sequential rules");
	
	// statistics
	long timeStart = 0;
	long timeEnd = 0;

	long timeStart11 = 0;
	long timeEnd11 = 0;
	public long timeEndPreprocessing = 0;
	
	double maxMemory =0;
	
	double minSupport;
	double minConfidence; 
	int minsuppRelative;
	
	int maxItemId=0;
	Map<Integer, Set<Integer>> mapItemCount;
	List<Integer> listFrequents = new ArrayList<Integer>();
	
	SequenceDatabase database;
	
	// Special parameter to set the size of rules to be discovered
	int minLeftSize = 0;  // min size of left part of the rule
	int maxLeftSize = 500; // max size of left part of the rule
	int minRightSize = 0; // min  size of right part of the rule
	int maxRightSize = 500; // max size of right part of the rule

	public AlgoCMDeogun() {
		
	}
	
	private void checkMemory() {
		double currentMemory = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		if(currentMemory > maxMemory){
			maxMemory = currentMemory;
		}
	}

	public Rules runAlgorithm(double minSupport, double minConfidence, SequenceDatabase database) {
		this.minSupport = minSupport;
		this.minConfidence = minConfidence;
		this.database = database;
		maxMemory = 0;
		
		this.minsuppRelative = (int) Math.ceil(minSupport * database.size());
		if(this.minsuppRelative == 0){ // protection
			this.minsuppRelative = 1;
		}

		timeStart = System.currentTimeMillis(); // for stats
		// REMOVE ITEMS THAT ARE NOT FREQUENT
		removeItemsThatAreNotFrequent(database, minSupport);
		
		// NOTE ITEMS THAT ARE FREQUENT IN A LIST THAT IS LEXICOGRAPHICALLY ORDERED 
		for(int i=0; i <= maxItemId; i++){
			if(mapItemCount.get(i) != null && mapItemCount.get(i).size() >= minsuppRelative){
				listFrequents.add(i);
			}
		}
//		System.out.println("FIN PREPROCESSING");
		
		timeEndPreprocessing   = System.currentTimeMillis(); // for stats

		// START ALGORITHM
		start(mapItemCount);
		
		timeEnd = System.currentTimeMillis(); // for stats
		
		return sequentialRules;
	}

	private void start(Map<Integer, Set<Integer>> mapItemCount) {
		timeStart11 = System.currentTimeMillis();
		
		// (1) generate all rules with 1-left-itemset and 1-right-itemset
		Rules ruleSize11 = new Rules("candidate size 11");
		
		// FOR EACH FREQUENT ITEM WE COMPARE WITH OTHER FREQUENT ITEM TO 
		// TRY TO GENERATE A RULE 1-1.
		for(int i=0; i< listFrequents.size(); i++){
			Integer intI = listFrequents.get(i);
			Set<Integer> tidsI = mapItemCount.get(intI);
			for(int j=i+1; j< listFrequents.size(); j++){
				Integer intJ = listFrequents.get(j);
				Set<Integer> tidsJ = mapItemCount.get(intJ);
				// (1) Build list of common  tids
				List<Integer> commonTids = new ArrayList<Integer>();
				for(Integer tid : tidsI){
					if(tidsJ.contains(tid)){
						commonTids.add(tid);
					}
				}
				// (2) check if the two itemsets have enough common tids
				// if not, we don't need to generate a rule for them.
				if(commonTids.size() >= minsuppRelative){
					generateRuleSize11(intI, tidsI, intJ, tidsJ, commonTids, ruleSize11);
				}
			}
		}
		timeEnd11 = System.currentTimeMillis();
//		System.out.println("11 size" + ruleSize11.getRulesCount() + " confid " +  sequentialRules.getRulesCount());
		
		// END DEBUG
		if( maxLeftSize >1){
			performLeftExpansion(ruleSize11);
		}
		if( maxRightSize >1){
			performRightExpansion(ruleSize11);
		}
	}


	private void generateRuleSize11(Integer item1, Set<Integer> tids1, Integer item2, Set<Integer> tids2, List<Integer> commonTids,
			Rules ruleSize11) {
		
		// count the support of the rule  Left then right and right then left at the same time
		int countLeftBeforeRight =0;
		int countRightBeforeLeft =0;
		
		for(Integer tid : commonTids){ // FOR EACH SEQUENCE where the rule appears.
			int firstOccurence1 = -1;
			int firstOccurence2 = -1;
			boolean saw1before2 = false;
			boolean saw2before1 = false;
			List<Itemset> list = database.getSequences().get(tid).getItemsets();
			 
			for(int i=0; i< list.size(); i++){  // for each itemset
				for(Integer item : list.get(i).getItems()){  // for each item
					if(item.equals(item1)){
						if(firstOccurence1 == -1){
							firstOccurence1 = i;
						}
						if(firstOccurence2 > -1 && firstOccurence2 < i){
							saw2before1 = true;
						}
					}
					else if(item.equals(item2)){
						if(firstOccurence2 == -1){
							firstOccurence2 = i;
						}
						if(firstOccurence1 > -1 && firstOccurence1 < i){
							saw1before2 = true;
						}
					}
				}
			}
			if(saw2before1){
				countRightBeforeLeft++;
			}
			if(saw1before2){
				countLeftBeforeRight++;
			}
		}

		// if left then right has minimum support
		if(countLeftBeforeRight >= minsuppRelative){
			Itemset itemset1 = new Itemset();
			itemset1.addItem(item1);
			itemset1.setTIDs(tids1);
			Itemset itemset2 = new Itemset();
			itemset2.addItem(item2);
			itemset2.setTIDs(tids2);
			
			Rule ruleLR = new Rule(itemset1, itemset2);
			ruleLR.setTransactioncount(countLeftBeforeRight);
			
			ruleSize11.addRule(ruleLR); // ADD TO RULES OF SIZE 1-1
			
			if(ruleLR.getConfidence() >= minConfidence){
				if(ruleLR.getItemset1().size()>= minLeftSize &&
						ruleLR.getItemset2().size()>= minRightSize){
					sequentialRules.addRule(ruleLR); // ADD TO RESULT SET !!!!!!!!!!
				}
			}
		}
		// if right then left has minimum support
		if(countRightBeforeLeft >= minsuppRelative){
			Itemset itemset1 = new Itemset();
			itemset1.addItem(item1);
			itemset1.setTIDs(tids1);
			Itemset itemset2 = new Itemset();
			itemset2.addItem(item2);
			itemset2.setTIDs(tids2);
			
			Rule ruleRL = new Rule(itemset2, itemset1);
			ruleRL.setTransactioncount(countRightBeforeLeft);
			
			ruleSize11.addRule(ruleRL); // ADD TO RULES OF SIZE 1-1
			
			if(ruleRL.getConfidence() >= minConfidence){
				if(ruleRL.getItemset1().size()>= minLeftSize &&
						ruleRL.getItemset2().size()>= minRightSize){
					sequentialRules.addRule(ruleRL); // ADD TO RESULT SET !!!!!!!!!!
				}
			}
		}
	}
	


	/**
	 * 
	 * @param ruleSizeKm1  rule with a left part of size k-1
	 * @param array
	 */
	private void performLeftExpansion(Rules ruleSizeKm1) {
		// For each rule such that the right itemset is the same,
		// check if we can combine them to generate a candidate.
		// If so, check if that candidate is 
		Rules ruleSizeK = new Rules("Candidates");
		
		for(int i=0; i< ruleSizeKm1.getRulesCount(); i++){
			Rule ruleI = ruleSizeKm1.getRules().get(i);
			for(int j=i+1; j< ruleSizeKm1.getRulesCount(); j++){
//				checkCount++;
				Rule ruleJ = ruleSizeKm1.getRules().get(j);
				// if the right part is the same..
				if(ruleI.getItemset2().allTheSame(ruleJ.getItemset2())){
					// check if the left part share all items except the last one.
					if(ruleI.getItemset1().allTheSameExceptLastItemV2(ruleJ.getItemset1())){
//						expansionCount++;
						// expand left part of rule
						Itemset newLeftItemset = new Itemset();
						newLeftItemset.getItems().addAll(ruleI.getItemset1().getItems());
						newLeftItemset.addItem(ruleJ.getItemset1().getLastItem()); 
						// SPECIAL TRICK FOR LEFT EXPANSION : WE NEED TO CALCULATE THE NEW SUPPORT FOR 
						// THE LEFT ITEMSET (for the confidence calculation, later):
						// It is the intersection of the tids for the left itemset of both rules.
						for(Integer id : ruleI.getItemset1().transactionsIds){
							if(ruleJ.getItemset1().transactionsIds.contains(id)){
								newLeftItemset.transactionsIds.add(id);
							}
						}
	
						// create the candidate rule
						Rule candidate = new Rule(newLeftItemset,  ruleI.getItemset2());
						// calculate the support and confidence
						for(Integer tid : candidate.getItemset1().getTransactionsIds()){ // FOR EACH SEQUENCE that is relevant for this rule..
							if(candidate.getItemset2().transactionsIds.contains(tid)){
								calculateInterestingnessMeasures(candidate, database.getSequences().get(tid), true, false);
							}
						}
						if(candidate.getTransactionCount() >= minsuppRelative){
							ruleSizeK.addRule(candidate); // ADD TO RULE OF SIZE 1-1
							if(candidate.getConfidence() >= minConfidence){
//								System.out.println("RULE FOUND : " + candidate.toString());
								if(candidate.getItemset1().size()>= minLeftSize &&
										candidate.getItemset2().size()>= minRightSize){
									sequentialRules.addRule(candidate); // ADD TO RESULT SET !!!!!!!!!!
//									validExpansionCount++;
								}
							}
						}
					}
				}
			}
		}
		if(ruleSizeK.getRulesCount() !=0  &&  ruleSizeK.getRules().get(0).getItemset1().size() < maxLeftSize){
			// continue with the next level!
			performLeftExpansion(ruleSizeK);
//			performRightExpansion(ruleSizeK); /// IMPORTANT OTHERWISE WE WILL FIND SOME RULES TWO TIMES!!!!!!
		}

		checkMemory();
	}
	
	private void performRightExpansion(Rules ruleSizeKm1) {
		// For each rule such that the right itemset is the same,
		// check if we can combine them to generate a candidate.
		// If so, check if that candidate is 
		Rules ruleSizeK = new Rules("Candidates");
		
		for(int i=0; i< ruleSizeKm1.getRulesCount(); i++){
			Rule ruleI = ruleSizeKm1.getRules().get(i);
			for(int j=i+1; j< ruleSizeKm1.getRulesCount(); j++){
				Rule ruleJ = ruleSizeKm1.getRules().get(j);
//				checkCount++;
				// if the right part is the same..
				if(ruleI.getItemset1().allTheSame(ruleJ.getItemset1())){
					// check if the left part share all items except the last one.
					if(ruleI.getItemset2().allTheSameExceptLastItemV2(ruleJ.getItemset2())){
//						expansionCount++;
						// expand left part of rule
						Itemset newRightItemset = new Itemset();
						newRightItemset.getItems().addAll(ruleI.getItemset2().getItems());
						newRightItemset.addItem(ruleJ.getItemset2().getLastItem()); 
						// SPECIAL TRICK FOR RIGHT EXPANSION : WE CALCULATE THE NEW SUPPORT FOR 
						// THE RIGHT ITEMSET ):
						// It is the intersection of the tids for the right itemset of both rules.
						for(Integer id : ruleI.getItemset2().transactionsIds){
							if(ruleJ.getItemset2().transactionsIds.contains(id)){
								newRightItemset.transactionsIds.add(id);
							}
						}
						
						// create the candidate rule
						Rule candidate = new Rule(ruleI.getItemset1(), newRightItemset);
						// calculate the support and confidence
						for(Integer tid : candidate.getItemset1().getTransactionsIds()){ // FOR EACH SEQUENCE that is relevant for this rule..
							if(candidate.getItemset2().transactionsIds.contains(tid)){
								calculateInterestingnessMeasures(candidate, database.getSequences().get(tid), false, true);
							}
						}
						if(candidate.getTransactionCount() >= minsuppRelative){
							ruleSizeK.addRule(candidate); // ADD TO RULE OF SIZE 1-1    // I CHANGE IT !!!!!
							if(candidate.getConfidence() >= minConfidence){
//								System.out.println("RULE FOUND : " + candidate.toString());
								if(candidate.getItemset1().size()>= minLeftSize &&
										candidate.getItemset2().size()>= minRightSize){
									sequentialRules.addRule(candidate); // ADD TO RESULT SET !!!!!!!!!!
//									validExpansionCount++;
								}
							}
						}
					}
				}
			}
		}
		if(ruleSizeK.getRulesCount() !=0){
			// continue with the next level!
			if(ruleSizeK.getRules().get(0).getItemset1().size() < maxLeftSize){
				performLeftExpansion(ruleSizeK);   
			}
			if(ruleSizeK.getRules().get(0).getItemset2().size() < maxRightSize){
				performRightExpansion(ruleSizeK);
			}
		}
		checkMemory();
	}

	private void calculateInterestingnessMeasures( Rule rule, Sequence sequence, boolean calculateTIDSLeftItemset, boolean calculateTIDSRightItemset) {
		Set<Integer> setAlreadySeen = new HashSet<Integer>(rule.getItemset1().size() * 3); // could be replaced with a flag on items
		int i=0;
		firstpass:{
			for(; i< sequence.getItemsets().size(); i++){ // TO MATCH LEFT PART OF THE RULE
				int j=0;
				Itemset itemset = sequence.get(i);
				for(; j< itemset.getItems().size(); j++){ // FOR EACH ITEM OF THIS SEQUENCE
					int item = itemset.get(j);
					if(rule.getItemset1().contains(item)){ // left part of rule
						setAlreadySeen.add(item);
						if(setAlreadySeen.size() == rule.getItemset1().size()){
							 break firstpass;
						}
					}
				 }
			}
		}
		
		if(calculateTIDSLeftItemset){
			rule.getItemset1().transactionsIds.add(sequence.getId());
		}
		
		i++; // go to next itemset...
		setAlreadySeen.clear();
		for(; i< sequence.getItemsets().size(); i++){ // TO MATCH RIGHT PART OF THE RULE
			int j=0;
			Itemset itemset = sequence.get(i);
			for(; j< itemset.getItems().size(); j++){ // FOR EACH ITEM OF THIS SEQUENCE
				int item = itemset.get(j);
				if(rule.getItemset2().contains(item)){ // right part of rule
					setAlreadySeen.add(item);
					if(setAlreadySeen.size() == rule.getItemset2().size()){
						if(calculateTIDSRightItemset){
							rule.getItemset2().transactionsIds.add(sequence.getId());
						}
						rule.incrementTransactionCount();  /////////  HIGHER COUNT!!!
						return;
					}
				 }
			 }
		 }
	}

	private Map<Integer, Set<Integer>> removeItemsThatAreNotFrequent(SequenceDatabase sequences, double minSeqSupport) {
		// (1) count the support of each item in the database in one database pass
		mapItemCount = new HashMap<Integer, Set<Integer>>(); // id item, count
		
		for(Sequence sequence : sequences.getSequences()){
			for(Itemset itemset : sequence.getItemsets()){
				for(int i=0; i< itemset.size(); i++){
					Set<Integer> tids = mapItemCount.get(itemset.get(i));
					if(tids == null){
						tids = new HashSet<Integer>();
						mapItemCount.put(itemset.get(i), tids);
						if(itemset.get(i) > maxItemId){
							maxItemId = itemset.get(i);
						}
					}
					tids.add(sequence.getId());
				}
			}
		}
		System.out.println("NUMBER OF DIFFERENT ITEMS : " + mapItemCount.size());
		// (2) remove all items that are not frequent from the database
		
		for(Sequence sequence : sequences.getSequences()){
			int i=0;
			while(i < sequence.getItemsets().size()){
				Itemset itemset = sequence.getItemsets().get(i);
				int j=0;
				while(j < itemset.size()){
					double count = mapItemCount.get(itemset.get(j)).size();
					if(count < minsuppRelative){
						itemset.getItems().remove(j);
					}else{
						j++;
					}
				}
				if(itemset.size() == 0){
					sequence.getItemsets().remove(i);
				}else{
					i++;
				}
			}
		}
		return mapItemCount;
	}

	public void printStats() {
		System.out
				.println("=============  SEQUENTIAL RULES - STATS =============");
		System.out.println("Sequential rules count: " + sequentialRules.getRulesCount());
		System.out.println("Total time : " + (timeEnd - timeStart) + " ms");		
		System.out.println("Max memory: " + maxMemory);
//		System.out.println("Time preprocessing : " + (timeEndPreprocessing - timeStart) + " ms");
//		System.out.println("Time candidate 11: "  + (timeEnd11 - timeStart11) + " ms");
//		System.out.println("Expansion coutn : " + expansionCount);
//		System.out.println("Valid Expansion coutn : " + validExpansionCount);
//		System.out.println("Check coutn : " + checkCount);
		System.out
				.println("===================================================");
	}

	public void setMinLeftSize(int minLeftSize) {
		this.minLeftSize = minLeftSize;
	}

	public void setMaxLeftSize(int maxLeftSize) {
		this.maxLeftSize = maxLeftSize;
	}

	public void setMinRightSize(int minRightSize) {
		this.minRightSize = minRightSize;
	}

	public void setMaxRightSize(int maxRightSize) {
		this.maxRightSize = maxRightSize;
	}
}
