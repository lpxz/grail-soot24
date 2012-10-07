package ca.pfv.spmf.tests;

import java.util.ArrayList;
import java.util.List;

import ca.pfv.spmf.clustering.AlgoKMeans;
import ca.pfv.spmf.clustering.AlgoKMeansWithSupport;
import ca.pfv.spmf.clustering.Cluster;
import ca.pfv.spmf.sequentialpatterns.ItemValued;


public class MainTestKMeans2 {
	
	public static void main(String []args){
		// Data
		List<ItemValued> items = new ArrayList<ItemValued>();
		// Each item has three parts : 
		// (1) the id
		// (2) the value
		// (3) the sequence id.
		// These are because this implementation of the K-Means algorithm was done
		// for being used by a sequential pattern mining algorithm.
		// If you want to use only K-Means separately, you can ignore "id" and "sequence id"
		// Just fill the values as presented next. To represent the
		// set of values {2, 2, 3, 7, 7,7, 7, 3}, we did : 
		items.add(new ItemValued(1, 2, 0));  
		items.add(new ItemValued(1, 2, 1));
		items.add(new ItemValued(1, 3, 2));
		items.add(new ItemValued(1, 7, 3));
		items.add(new ItemValued(1, 7, 4));
		items.add(new ItemValued(1, 7, 5));
		items.add(new ItemValued(1, 7, 6));
		items.add(new ItemValued(1, 3, 7));
		
		System.out.println("k-means with support, PARAM = max number of clusters, PARAM = min size of clusters, PARAM=AlgoKMeans, PARAM=number of try for each K");
		// Apply the algorithm : 
		// Parameters that are used for this example : Kmax =6, X=4, Y=5, K=3
		AlgoKMeansWithSupport algoKMeansWithSupport = new AlgoKMeansWithSupport(6, 4, new AlgoKMeans(6), 5);
		List<Cluster> clusters3 = algoKMeansWithSupport.runAlgorithm(items);
		// Print results
		for(Cluster cluster : clusters3){
			System.out.println(cluster.toString());
		}

	}
	
	
}
