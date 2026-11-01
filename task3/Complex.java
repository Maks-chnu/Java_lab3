package Java_lab3.task3;

import java.util.Objects;

/**
 * Комплексне число re + im·i. Реалізує інтерфейс Pair.
 */
public class Complex implements Pair {

    private final double re;  // дійсна частина
    private final double im;  // уявна частина

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    // (a + bi) + (c + di) = (a + c) + (b + d)i
    @Override
    public Complex add(Pair other) {
        Complex c = toComplex(other);
        return new Complex(re + c.re, im + c.im);
    }

    // (a + bi) - (c + di) = (a - c) + (b - d)i
    @Override
    public Complex subtract(Pair other) {
        Complex c = toComplex(other);
        return new Complex(re - c.re, im - c.im);
    }

    // (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
    @Override
    public Complex multiply(Pair other) {
        Complex c = toComplex(other);
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    // Модуль комплексного числа |z| = sqrt(re² + im²)
    public double modulus() {
        return Math.hypot(re, im);
    }

    private static Complex toComplex(Pair other) {
        if (!(other instanceof Complex)) {
            throw new IllegalArgumentException(
                    "Операція можлива лише між двома комплексними числами, отримано: "
                            + other.getClass().getSimpleName());
        }
        return (Complex) other;
    }

    @Override
    public String toString() {
        if (im >= 0) {
            return String.format("%.2f + %.2fi", re + 0.0, im + 0.0);
        }
        return String.format("%.2f - %.2fi", re + 0.0, -im);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Complex)) return false;
        Complex other = (Complex) obj;
        return Double.compare(re, other.re) == 0 && Double.compare(im, other.im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}