/**
 * A class representing a noise level.
 * @author Alexander Bartolomey 369407
 * @author Alexander Luepges 368999
 * @version 1
 */
public class NoiseLevel {
    /**
     * The noise level is an integer, defaulting to 0.
     * For more information refer to the {@link #toString() toString} method.
     */
    private int noise; //Default nach JVM Spezifikation auf 0

    /* Der default no-argument constructor (welcher automatisch generiert wird) wird verwendet. (https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.8.9)
        Dadurch wird noise auf den default Wert fuer ints gesetzt, welcher (nach https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.12.5) 0 ist.
     */

    /**
     * Returns the current noise level
     * The noise level is an integer, defaulting to 0.
     * For more information refer to the {@link #toString() toString} method.
     *
     * @return the current noise level (immutable)
     */
    public int getNoise() {
        return this.noise;
    }

    /**
     * Sets the current noise level to {@code newNoise}.
     * The noise level is an integer, defaulting to 0.
     * For more information refer to the {@link #toString() toString} method.
     *
     * @param newNoise the noise level to set
     */
    public void setNoise(int newNoise) {
        this.noise = newNoise;
    }

    /**
     * Sets this noise Level to the maximum of the current noise and {@code nochEinPegel}.
     * If both, the current level and {@code nochEinPegel}, are 10 or more,
     * it adds one to the current level
     *
     * @param nochEinPegel the noise to add
     */
    public final void add(int nochEinPegel) {
        int max = Math.max(this.noise, nochEinPegel);
        if (this.noise >= 10 && nochEinPegel >= 10)
            max++;
        this.noise = max;
    }

    /**
     * Returns a string representation of the object.
     * Returns "leise" for a noise level below 2,
     * "normal" for a noise level below 5,
     * "laut" for a noise level below 10,
     * "LAUT" for a noise level below 12
     * and "furchtbar laut" for a noise level of 12 or more.
     *
     * @return a {@link String} describing the noise level
     */
    @Override
    public String toString() {
        return (noise < 2 ? "leise" : (noise < 5 ? "normal" : (noise < 10 ? "laut" : (noise < 12 ? "LAUT" : "furchtbar laut"))));
    }
}