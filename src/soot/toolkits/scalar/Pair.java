/* Soot - a J*va Optimization Framework
 * Copyright (C) 2002 Ondrej Lhotak
 * Copyright (C) 2007 Manu Sridharan
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */
package soot.toolkits.scalar;

/** Just a pair of arbitrary objects.
 * 
 * @author Ondrej Lhotak
 * @author Manu Sridharan (genericized it)
 */
public class Pair<T, U>
{
    public Pair( T o1, U o2 ) { this.o1 = o1; this.o2 = o2; }
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
			//System.err.println("o2 of pair is null, no matter");
		}
    	
        return  o1hash + o2hash;
    }
    public boolean equals( Object other ) {
        if( other instanceof Pair) {
            Pair p = (Pair) other;
            return o1.equals( p.o1 ) && o2.equals( p.o2 );
        } else return false;
    }
    public String toString() {
        return "Pair "+o1+","+o2;
    }
    public T getO1() { return o1; }
    public U getO2() { return o2; }

    
    
    public void setO1(T o1) {
		this.o1 = o1;
	}
	public void setO2(U o2) {
		this.o2 = o2;
	}
	protected T o1;
    protected U o2;
}