package ca.pfv.spmf.clustering;

import java.util.List;

import ca.pfv.spmf.sequentialpatterns.ItemValued;

public abstract class AbstractAlgoClustering {
	
	public abstract List<Cluster> runAlgorithm(List<ItemValued> items);

}
