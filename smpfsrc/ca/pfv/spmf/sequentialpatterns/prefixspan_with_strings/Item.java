package ca.pfv.spmf.sequentialpatterns.prefixspan_with_strings;


public class Item{
	
	private final String id;
	
	public Item(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String toString(){
		return "" + getId();
	}
	
	public boolean equals(Object object){
		Item item = (Item) object;
		if((item.getId().equals(this.getId()))){
			return true;
		}
		return false;
	}
	
	public int hashCode()
	{
		return getId().hashCode();
	}
	
}
