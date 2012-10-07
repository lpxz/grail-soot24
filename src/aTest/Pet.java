package aTest;

import java.util.HashSet;
import java.util.Set;

import soot.Scene;

public class Pet {

    int id = 0;
    public Pet(int para)
    {
    	id =para;
    	    	
    }
	public static void main(String[] args) {
		Set  set1 = new HashSet();
		Object o1 = new Object();
		set1.add(o1);
		
		Set  set2 = new HashSet();
		Object o2 = new Object();
		set2.add(o2);
		
		set1.addAll(set2);
		set2.clear();
		System.out.println(set1.size());

	}

}
