package core_java.dummy;

// 1. Provide no public method that can modify the internal state of class
// 2. Ensure that class can not be extended/subclassed
// 3. Make fields final
// 4. Make fields private
// 5. Ensure class has exclusive access to internal mutable states

public final class Complex {
    private final double re;
    private final double im;

    public static final Complex ZERO = valueOf(0, 0);
    public static final Complex ONE = valueOf(1, 0);
    public static final Complex I = valueOf(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex divideBy(Complex c) {
        final var v = Math.pow(c.re, 2) + Math.pow(c.im, 2);
        return new Complex((re * c.re + im * c.im) / v,
                (im * c.re - re * c.im) / v);
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Complex))
            return false;
        Complex c = (Complex) obj;

        // NOTE: For primitive types excepts float and double, use '==' for comparing
        // For float and double, use Float/Double.compare instead.
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }

    private static class ComplexCache {
        static Complex[] cache;

        static {
            cache = new Complex[3];
            cache[0] = new Complex(0, 0);
            cache[1] = new Complex(1, 0);
            cache[2] = new Complex(0, 1);
        }

        private ComplexCache() {
        }
    }

    public static Complex valueOf(double re, double im) {
        if (Double.compare(re, 0) == 0 && Double.compare(im, 0) == 0)
            return ComplexCache.cache[0];
        if (Double.compare(re, 1) == 0 && Double.compare(im, 0) == 0)
            return ComplexCache.cache[1];
        if (Double.compare(re, 0) == 0 && Double.compare(im, 1) == 0)
            return ComplexCache.cache[2];
        return new Complex(re, im);
    }

}
