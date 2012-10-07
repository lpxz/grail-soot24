package pldi.locking;



public class MyPair<T, U>
{
    public MyPair( T o1, U o2 ) { this.o1 = o1; this.o2 = o2; }
    static int times =0;
    public int hashCode() {
    	int o1hash= 0;int o2hash=0;
    	if(o1!=null) o1hash = o1.hashCode();
    	else {
    		times++;if(times>=3)System.exit(1);
			System.err.println("o1 of pair is null");// I am afraid of this branch!-> okay
		}
    	if(o2!=null) o2hash  =o2.hashCode();
    	else {
			System.err.println("o2 of pair is null, no matter");
		}
    	
        return  o1hash + o2hash;
    }
    public boolean equals( Object other ) {
        if( other instanceof MyPair) {
            MyPair p = (MyPair) other;
            return o1.equals( p.o1 ) && o2.equals( p.o2 );
        } else return false;
    }
    public String toString() {
        return "Pair "+o1+","+o2;
    }
    public T getO1() { return o1; }
    public U getO2() { return o2; }

    protected T o1;
    protected U o2;
}
