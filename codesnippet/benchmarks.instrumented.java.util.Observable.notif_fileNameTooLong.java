/**
     * If this object has changed, as indicated by the 
     * <code>hasChanged</code> method, then notify all of its observers 
     * and then call the <code>clearChanged</code> method to 
     * indicate that this object has no longer changed. 
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and <code>null</code>. In other 
     * words, this method is equivalent to:
     * <blockquote><tt>
     * notifyObservers(null)</tt></blockquote>
     *
     * @see     benchmarks.instrumented.java.util.Observable#clearChanged()
     * @see     benchmarks.instrumented.java.util.Observable#hasChanged()
     * @see     benchmarks.instrumented.java.util.Observer#update(benchmarks.instrumented.java.util.Observable, java.lang.Object)
     */
public void notifyObservers() {
    notifyObservers(null);
}/**
     * If this object has changed, as indicated by the 
     * <code>hasChanged</code> method, then notify all of its observers 
     * and then call the <code>clearChanged</code> method to indicate 
     * that this object has no longer changed. 
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and the <code>arg</code> argument.
     *
     * @param   arg   any object.
     * @see     benchmarks.instrumented.java.util.Observable#clearChanged()
     * @see     benchmarks.instrumented.java.util.Observable#hasChanged()
     * @see     benchmarks.instrumented.java.util.Observer#update(benchmarks.instrumented.java.util.Observable, java.lang.Object)
     */
public void notifyObservers(Object arg) {
    Object[] arrLocal;
    synchronized (this) {
        if (!changed) return;
        arrLocal = obs.toArray();
        clearChanged();
    }
    for (int i = arrLocal.length - 1; i >= 0; i--) ((Observer) arrLocal[i]).update(this, arg);
}