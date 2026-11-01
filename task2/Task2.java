package Java_lab3.task2;

/**
 * Завдання 2. Абстрактний клас Pair та його підкласи Complex і Rational.
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Лабораторна робота №3, завдання 2: абстрактний клас Pair\n");

        // Pair p = new Pair();  // ПОМИЛКА компіляції: не можна створити об'єкт абстрактного класу

        // Масив типу абстрактного класу, у ньому об'єкти різних підкласів
        Pair[] pairs = {
                new Complex(3, 2),
                new Complex(1, -4),
                new Rational(1, 2),
                new Rational(3, 4),
                new Rational(6, -8)   // скоротиться до -3/4
        };

        System.out.println("=== Масив об'єктів (toString викликається поліморфно) ===");
        for (int i = 0; i < pairs.length; i++) {
            System.out.println("  pairs[" + i + "] = " + pairs[i]
                    + "   (клас " + pairs[i].getClass().getSimpleName() + ")");
        }

        System.out.println("\n=== Операції з комплексними числами ===");
        pairs[0].printOperations(pairs[1]);

        System.out.println("\n=== Операції з дробами ===");
        pairs[2].printOperations(pairs[3]);
        pairs[3].printOperations(pairs[4]);

        System.out.println("\n=== Додаткові методи підкласів ===");
        Complex z = new Complex(3, 4);
        System.out.println("  |" + z + "| = " + z.modulus());
        Rational r = new Rational(3, 8);
        System.out.println("  " + r + " = " + r.toDouble());

        // Коваріантний тип повернення: add() у Complex повертає Complex, тож приведення не потрібне
        Complex sum = z.add(new Complex(1, 1));
        System.out.println("  Complex sum = " + sum + "  (без приведення типу)");

        System.out.println("\n=== Порівняння (equals) ===");
        System.out.println("  1/2 equals 2/4?          " + new Rational(1, 2).equals(new Rational(2, 4)));
        System.out.println("  3+2i equals pairs[0]?    " + new Complex(3, 2).equals(pairs[0]));
        System.out.println("  pairs[0] equals pairs[2]? " + pairs[0].equals(pairs[2]));
        System.out.println("  pairs[0] == new Complex(3, 2)? " + (pairs[0] == new Complex(3, 2)));

        System.out.println("\nУсього створено об'єктів Pair: " + Pair.getCreatedCount());

        System.out.println("\n=== Обробка помилок ===");
        try {
            pairs[0].add(pairs[2]);  // комплексне число + дріб
        } catch (IllegalArgumentException e) {
            System.out.println("  Помилка: " + e.getMessage());
        }
        try {
            new Rational(1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Помилка: " + e.getMessage());
        }
    }
}