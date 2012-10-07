package popl.example;

public class StringBufferTest {


	 public static StringBuffer s1, s2 = null;
	 static Thread th1 = new Thread()
	 {
		 public void run()
		 {
			 synchronized (s1) {
		       int len = s2.length();
		       s2.getChars(0, len, s1.value, s1.count);				 
			}
		 }
	 };
	 static Thread th2 = new Thread()
	 {
		 public void run()
		 {
			 s2.delete(0, s2.length());
		 }
	 };
	public static void main(String[] args) throws Exception {
		
		s1 = new StringBuffer("hello");
		s2 = new StringBuffer("world");
		th1.start(); th2.start();
		th1.join(); th2.join();

	}

}
