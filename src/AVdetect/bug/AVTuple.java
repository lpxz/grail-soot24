package AVdetect.bug;



public class AVTuple {
    public Object x;
    public Object y;
    public Object z;
    
	public AVTuple(Object x, Object y, Object z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int hashCode() {
    	int o1hash= 0;int o2hash=0; int o3hash =0;
    	if(x!=null) o1hash = x.hashCode();
    	
    	if(y!=null) o2hash  =y.hashCode();
    	
    	if(z!=null) o3hash = z.hashCode();
    	
        return  o1hash + o2hash + o3hash;
    }
    public boolean equals( Object other ) {
        if( other instanceof AVTuple) {
        	AVTuple p = (AVTuple) other;
            return x.equals( p.x ) && y.equals( p.y ) && z.equals(p.z);
        } else return false;
    }
    public String toString() {
        return "AVTuple "+ x+","+y + "," + z;
    }
    
	public Object getX() {
		return x;
	}

	public void setX(Object x) {
		this.x = x;
	}

	public Object getY() {
		return y;
	}

	public void setY(Object y) {
		this.y = y;
	}

	public Object getZ() {
		return z;
	}

	public void setZ(Object z) {
		this.z = z;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
