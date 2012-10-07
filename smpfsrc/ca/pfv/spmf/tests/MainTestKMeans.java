package ca.pfv.spmf.tests;

import java.util.ArrayList;
import java.util.List;

import ca.pfv.spmf.clustering.AlgoKMeans;
import ca.pfv.spmf.clustering.Cluster;
import ca.pfv.spmf.sequentialpatterns.ItemValued;


public class MainTestKMeans {
	
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
		
		System.out.println("k-means, PARAM = number of clusters");
		// Apply the algorithm
		AlgoKMeans algoKMeans = new AlgoKMeans(3);  // we request 3 clusters
		List<Cluster> clusters2 = algoKMeans.runAlgorithm(items);
		// Print the results
		for(Cluster cluster : clusters2){
			System.out.println(cluster.toString());
		}

	}
	
	
}
