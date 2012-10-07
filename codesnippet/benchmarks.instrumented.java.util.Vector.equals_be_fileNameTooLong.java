/**
     * Compares the specified Object with this Vector for equality.  Returns
     * true if and only if the specified Object is also a List, both Lists
     * have the same size, and all corresponding pairs of elements in the two
     * Lists are <em>equal</em>.  (Two elements <code>e1</code> and
     * <code>e2</code> are <em>equal</em> if <code>(e1==null ? e2==null :
     * e1.equals(e2))</code>.)  In other words, two Lists are defined to be
     * equal if they contain the same elements in the same order.
     *
     * @param o the Object to be compared for equality with this Vector.
     * @return true if the specified Object is equal to this Vector
     */
public synchronized boolean equals(Object o) {
    return super.equals(o);
}/**
     * Searches for the first occurence of the given argument, testing 
     * for equality using the <code>equals</code> method. 
     *
     * @param   elem   an object.
     * @return  the index of the first occurrence of the argument in this
     *          vector, that is, the smallest value <tt>k</tt> such that 
     *          <tt>elem.equals(elementData[k])</tt> is <tt>true</tt>; 
     *          returns <code>-1</code> if the object is not found.
     * @see     Object#equals(Object)
     */
public int indexOf(Object elem) {
    return indexOf(elem, 0);
}/**
     * Searches for the first occurence of the given argument, beginning 
     * the search at <code>index</code>, and testing for equality using 
     * the <code>equals</code> method. 
     *
     * @param   elem    an object.
     * @param   index   the non-negative index to start searching from.
     * @return  the index of the first occurrence of the object argument in
     *          this vector at position <code>index</code> or later in the
     *          vector, that is, the smallest value <tt>k</tt> such that 
     *          <tt>elem.equals(elementData[k]) && (k &gt;= index)</tt> is 
     *          <tt>true</tt>; returns <code>-1</code> if the object is not 
     *          found. (Returns <code>-1</code> if <tt>index</tt> &gt;= the
     *          current size of this <tt>Vector</tt>.)
     * @exception  IndexOutOfBoundsException  if <tt>index</tt> is negative.
     * @see     Object#equals(Object)
     */
public synchronized int indexOf(Object elem, int index) {
    if (elem == null) {
        for (int i = index; i < elementCount; i++) if (elementData[i] == null) return i;
    } else {
        for (int i = index; i < elementCount; i++) if (elem.equals(elementData[i])) return i;
    }
    return -1;
}/**
     * Returns the hash code value for this Vector.
     */
public synchronized int hashCode() {
    return super.hashCode();
}/**
     * Returns the number of components in this vector.
     *
     * @return  the number of components in this vector.
     */
public synchronized int size() {
    return elementCount;
}/**
     * Returns the element at the specified position in this Vector.
     *
     * @param index index of element to return.
     * @return object at the specified index
     * @exception ArrayIndexOutOfBoundsException index is out of range (index
     * 		  &lt; 0 || index &gt;= size()).
     * @since 1.2
     */
public synchronized Object get(int index) {
    if (index >= elementCount) throw new ArrayIndexOutOfBoundsException(index);
    return elementData[index];
}/**
     * Returns a string representation of this Vector, containing
     * the String representation of each element.
     */
public synchronized String toString() {
    return super.toString();
}