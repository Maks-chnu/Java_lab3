package Java_lab3.task2;

import java.util.Objects;

/**
 * Раціональний дріб numerator/denominator.
 * Дріб завжди зберігається скороченим, а знаменник — додатним.
 */
public class Rational extends Pair {

    private final long numerator;    // чисельник
    private final long denominator;  // знаменник (> 0)

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати 0");
        }
        // Знак переносимо в чисельник: 3/-4 -> -3/4
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        // Скорочуємо дріб на НСД: 6/8 -> 3/4
        long g = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    // Ціле число як дріб: 5 -> 5/1
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

    // Значення дробу як дійсне число
    public double toDouble() {
        return (double) numerator / denominator;
    }

    // Найбільший спільний дільник (алгоритм Евкліда)
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
        // Дроби зберігаються скороченими, тому достатньо порівняти чисельник і знаменник
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}