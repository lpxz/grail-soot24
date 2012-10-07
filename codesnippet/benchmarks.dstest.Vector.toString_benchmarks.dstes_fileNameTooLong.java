public Object nextElement() {
    synchronized (vector) {
        if (count < vector.elementCount) {
            return vector.elementData[count++];
        }
    }
    throw new NoSuchElementException("VectorEnumerator");
}/**
     * Returns an enumeration of the components of this vector.
     *
     * @return an enumeration of the components of this vector.
     * @see java.util.Enumeration
     * @since JDK1.0
     */
public final synchronized Enumeration elements() {
    return new VectorEnumerator(this);
}/**
     * Returns a string representation of this vector.
     *
     * @return a string representation of this vector.
     * @since JDK1.0
     */
public final synchronized String toString() {
    int max = size() - 1;
    StringBuffer buf = new StringBuffer();
    Enumeration e = elements();
    buf.append("[");
    for (int i = 0; i <= max; i++) {
        String s = e.nextElement().toString();
        buf.append(s);
        if (i < max) {
            buf.append(", ");
        }
    }
    buf.append("]");
    return buf.toString();
}