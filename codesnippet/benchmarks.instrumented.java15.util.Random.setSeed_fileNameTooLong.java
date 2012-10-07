/**
     * Sets the seed of this random number generator using a single
     * <code>long</code> seed. The general contract of <tt>setSeed</tt>
     * is that it alters the state of this random number generator
     * object so as to be in exactly the same state as if it had just
     * been created with the argument <tt>seed</tt> as a seed. The method
     * <tt>setSeed</tt> is implemented by class Random as follows:
     * <blockquote><pre>
     * synchronized public void setSeed(long seed) {
     *       this.seed = (seed ^ 0x5DEECE66DL) & ((1L << 48) - 1);
     *       haveNextNextGaussian = false;
     * }</pre></blockquote>
     * The implementation of <tt>setSeed</tt> by class <tt>Random</tt>
     * happens to use only 48 bits of the given seed. In general, however,
     * an overriding method may use all 64 bits of the long argument
     * as a seed value.
     * <p/>
     * Note: Although the seed value is an AtomicLong, this method
     * must still be synchronized to ensure correct semantics
     * of haveNextNextGaussian.
     *
     * @param seed the initial seed.
     */
public synchronized void setSeed(long seed) {
    seed = (seed ^ multiplier) & mask;
    this.seed.set(seed);
    haveNextNextGaussian = false;
}