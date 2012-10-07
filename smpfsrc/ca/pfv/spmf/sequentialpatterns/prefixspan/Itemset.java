package ca.pfv.spmf.sequentialpatterns.prefixspan;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * This class represents an itemset from a sequence from a sequence database.
 * The itemset can thus have a timestamp.
 * @author Philippe Fournier-Viger 
 */
public class Itemset{

	private final List<Item> items = new ArrayList<Item>(); // ordered list.
	
	public Itemset(Item item){
		addItem(item);
	}
	
	public Itemset(){
	}

	public void addItem(Item value){
			items.add(value);
	}
	
	public List<Item> getItems(){
		return items;
	}
	
	public Item get(int index){
		return items.get(index);
	}
	
	public void print(){
		System.out.print(toString());
	}
	
	public String toString(){
		StringBuffer r = new StringBuffer ();
		for(Item attribute : items){
			r.append(attribute.toString());
			r.append(' ');
		}
		return r.toString();
	}

	
	public int size(){
		return items.size();
	}
	
	public Itemset cloneItemSetMinusItems(Map<Item, Set<Integer>> mapSequenceID, double minsuppRelatif) {
		Itemset itemset = new Itemset();
		for(Item item : items){
			if(mapSequenceID.get(item).size() >= minsuppRelatif){
				itemset.addItem(item);
			}
		}
		return itemset;
	}
	
	public Itemset cloneItemSet(){
		Itemset itemset = new Itemset();
		itemset.getItems().addAll(items);
		return itemset;
	}
}
