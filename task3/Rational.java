package Java_lab3.task3;

import java.util.Objects;

/**
 * Раціональний дріб numerator/denominator.
 * Реалізує ДВА інтерфейси: Pair і Comparable<Rational>.
 * Успадкуватися від двох класів у Java не можна, а реалізувати кілька інтерфейсів — можна.
 */
public class Rational implements Pair, Comparable<Rational> {

    private final long numerator;    
    private final long denominator; 

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати 0");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        long g = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public Rational(long value) {
        this(value, 1);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    // a/b + c/d = (ad + cb) / bd
    @Override
    public Rational add(Pair other) {
        Rational r = toRational(other);
        return new Rational(numerator * r.denominator + r.numerator * denominator,
                denominator * r.denominator);
    }

    // a/b - c/d = (ad - cb) / bd
    @Override
    public Rational subtract(Pair other) {
        Rational r = toRational(other);
        return new Rational(numerator * r.denominator - r.numerator * denominator,
                denominator * r.denominator);
    }

    // a/b * c/d = ac / bd
    @Override
    public Rational multiply(Pair other) {
        Rational r = toRational(other);
        return new Rational(numerator * r.numerator, denominator * r.denominator);
    }

    // Порівняння дробів (інтерфейс Comparable): a/b < c/d  <=>  ad < cb (знаменники > 0)
    @Override
    public int compareTo(Rational other) {
        return Long.compare(numerator * other.denominator, other.numerator * denominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static Rational toRational(Pair other) {
        if (!(other instanceof Rational)) {
            throw new IllegalArgumentException(
                    "Операція можлива лише між двома дробами, отримано: "
                            + other.getClass().getSimpleName());
        }
        return (Rational) other;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rational)) return false;
        Rational other = (Rational) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}