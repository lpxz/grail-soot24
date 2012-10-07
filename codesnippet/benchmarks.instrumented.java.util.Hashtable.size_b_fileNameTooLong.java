/**
     * Returns a string representation of this <tt>Hashtable</tt> object 
     * in the form of a set of entries, enclosed in braces and separated 
     * by the ASCII characters "<tt>,&nbsp;</tt>" (comma and space). Each 
     * entry is rendered as the key, an equals sign <tt>=</tt>, and the 
     * associated element, where the <tt>toString</tt> method is used to 
     * convert the key and element to strings. <p>Overrides to 
     * <tt>toString</tt> method of <tt>Object</tt>.
     *
     * @return  a string representation of this hashtable.
     */
public synchronized String toString() {
    int max = size() - 1;
    StringBuffer buf = new StringBuffer();
    Iterator it = entrySet().iterator();
    buf.append("{");
    for (int i = 0; i <= max; i++) {
        Map.Entry e = (Map.Entry) (it.next());
        Object key = e.getKey();
        Object value = e.getValue();
        buf.append((key == this ? "(this Map)" : key) + "=" + (value == this ? "(this Map)" : value));
        if (i < max) buf.append(", ");
    }
    buf.append("}");
    return buf.toString();
}/**
     * Compares the specified Object with this Map for equality,
     * as per the definition in the Map interface.
     *
     * @param  o object to be compared for equality with this Hashtable
     * @return true if the specified Object is equal to this Map.
     * @see Map#equals(Object)
     * @since 1.2
     */
public synchronized boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Map)) return false;
    Map t = (Map) o;
    if (t.size() != size()) return false;
    try {
        Iterator i = entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry e = (Map.Entry) i.next();
            Object key = e.getKey();
            Object value = e.getValue();
            if (value == null) {
                if (!(t.get(key) == null && t.containsKey(key))) return false;
            } else {
                if (!value.equals(t.get(key))) return false;
            }
        }
    } catch (ClassCastException unused) {
        return false;
    } catch (NullPointerException unused) {
        return false;
    }
    return true;
}/**
     * Returns the value to which the specified key is mapped in this hashtable.
     *
     * @param   key   a key in the hashtable.
     * @return  the value to which the key is mapped in this hashtable;
     *          <code>null</code> if the key is not mapped to any value in
     *          this hashtable.
     * @throws  NullPointerException  if the key is <code>null</code>.
     * @see     #put(Object, Object)
     */
public synchronized Object get(Object key) {
    Entry tab[] = table;
    int hash = key.hashCode();
    int index = (hash & 0x7FFFFFFF) % tab.length;
    for (Entry e = tab[index]; e != null; e = e.next) {
        if ((e.hash == hash) && e.key.equals(key)) {
            return e.value;
        }
    }
    return null;
}/**
     * Returns the hash code value for this Map as per the definition in the
     * Map interface.
     *
     * @see Map#hashCode()
     * @since 1.2
     */
public synchronized int hashCode() {
    int h = 0;
    if (count == 0 || loadFactor < 0) return h;
    loadFactor = -loadFactor;
    Entry tab[] = table;
    for (int i = 0; i < tab.length; i++) for (Entry e = tab[i]; e != null; e = e.next) h += e.key.hashCode() ^ e.value.hashCode();
    loadFactor = -loadFactor;
    return h;
}/**
     * Returns the number of keys in this hashtable.
     *
     * @return  the number of keys in this hashtable.
     */
public synchronized int size() {
    return count;
}/**
     * Tests if the specified object is a key in this hashtable.
     * 
     * @param   key   possible key.
     * @return  <code>true</code> if and only if the specified object 
     *          is a key in this hashtable, as determined by the 
     *          <tt>equals</tt> method; <code>false</code> otherwise.
     * @throws  NullPointerException  if the key is <code>null</code>.
     * @see     #contains(Object)
     */
public synchronized boolean containsKey(Object key) {
    Entry tab[] = table;
    int hash = key.hashCode();
    int index = (hash & 0x7FFFFFFF) % tab.length;
    for (Entry e = tab[index]; e != null; e = e.next) {
        if ((e.hash == hash) && e.key.equals(key)) {
            return true;
        }
    }
    return false;
}