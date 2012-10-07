/**
     * The specified character of the sequence currently represented by
     * the string buffer, as indicated by the <code>index</code> argument,
     * is returned. The first character of a string buffer is at index
     * <code>0</code>, the next at index <code>1</code>, and so on, for
     * array indexing.
     * <p>
     * The index argument must be greater than or equal to
     * <code>0</code>, and less than the length of this string buffer.
     *
     * @param      index   the index of the desired character.
     * @return     the character at the specified index of this string buffer.
     * @exception  IndexOutOfBoundsException  if <code>index</code> is
     *             negative or greater than or equal to <code>length()</code>.
     * @see        java.lang.StringBuffer#length()
     */
public synchronized char charAt(int index) {
    if ((index < 0) || (index >= count)) {
        throw new StringIndexOutOfBoundsException(index);
    }
    return value[index];
}/**
     * Returns a new <code>String</code> that contains a subsequence of
     * characters currently contained in this <code>StringBuffer</code>.The
     * substring begins at the specified index and extends to the end of the
     * <code>StringBuffer</code>.
     *
     * @param      start    The beginning index, inclusive.
     * @return     The new string.
     * @exception  StringIndexOutOfBoundsException  if <code>start</code> is
     *             less than zero, or greater than the length of this
     *             <code>StringBuffer</code>.
     * @since      1.2
     */
public synchronized String substring(int start) {
    return substring(start, count);
}/**
     * Returns a new <code>String</code> that contains a subsequence of
     * characters currently contained in this <code>StringBuffer</code>. The
     * substring begins at the specified <code>start</code> and
     * extends to the character at index <code>end - 1</code>. An
     * exception is thrown if
     *
     * @param      start    The beginning index, inclusive.
     * @param      end      The ending index, exclusive.
     * @return     The new string.
     * @exception  StringIndexOutOfBoundsException  if <code>start</code>
     *             or <code>end</code> are negative or greater than
     *		   <code>length()</code>, or <code>start</code> is
     *		   greater than <code>end</code>.
     * @since      1.2
     */
public synchronized String substring(int start, int end) {
    if (start < 0) throw new StringIndexOutOfBoundsException(start);
    if (end > count) throw new StringIndexOutOfBoundsException(end);
    if (start > end) throw new StringIndexOutOfBoundsException(end - start);
    return new String(value, start, end - start);
}public synchronized int length() {
    return count;
}