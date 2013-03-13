package aTest;

import java.util.HashSet;
import java.util.Set;

import soot.Scene;

public class Dog extends Pet{

    public Dog(int para) {
		super(para);
		// TODO Auto-generated constructor stub
	}

	//int id = 0;

	public static void main(String[] args) {
            
                Set  set1 = new HashSet();
		Object o1 = new Object();
		set1.add(o1);
		synchronized (o1) {
			Set  set2 = new HashSet();
			synchronized (o1) {
				Object o2 = new Object();
				set2.add(o2);
			}
			set1.addAll(set2);
			set2.clear();
		
		}

		

		System.out.println(set1.size());
        
        
	}

}
