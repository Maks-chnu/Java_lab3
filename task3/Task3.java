package Java_lab3.task3;

import java.util.Arrays;

/**
 * Завдання 3. Те саме, що завдання 2, але замість абстрактного класу — інтерфейс Pair.
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println("Лабораторна робота №3, завдання 3: інтерфейс Pair\n");

        // Pair p = new Pair();  // ПОМИЛКА компіляції: не можна створити об'єкт інтерфейсу

        // Масив типу ІНТЕРФЕЙСУ: у ньому об'єкти будь-яких класів, що його реалізують
        Pair[] pairs = {
                new Complex(3, 2),
                new Complex(1, -4),
                new Rational(1, 2),
                new Rational(3, 4),
                new Rational(6, -8)
        };

        System.out.println("---- Масив об'єктів ----");
        for (int i = 0; i < pairs.length; i++) {
            System.out.println("  pairs[" + i + "] = " + pairs[i]
                    + "   (клас " + pairs[i].getClass().getSimpleName() + ")");
        }

        System.out.println("\n---- Операції з комплексними числами (default-метод інтерфейсу) ----");
        pairs[0].printOperations(pairs[1]);

        System.out.println("\n---- Операції з дробами ----");
        pairs[2].printOperations(pairs[3]);
        pairs[3].printOperations(pairs[4]);

        System.out.println("\n---- Додаткові методи класів ----");
        Complex z = new Complex(3, 4);
        System.out.println("  |" + z + "| = " + z.modulus());
        Rational r = new Rational(3, 8);
        System.out.println("  " + r + " = " + r.toDouble());

        System.out.println("\n---- Порівняння (equals) ----");
        System.out.println("  1/2 equals 2/4?           " + new Rational(1, 2).equals(new Rational(2, 4)));
        System.out.println("  3+2i equals pairs[0]?     " + new Complex(3, 2).equals(pairs[0]));
        System.out.println("  pairs[0] equals pairs[2]? " + pairs[0].equals(pairs[2]));

        System.out.println("\n---- Кілька інтерфейсів: Rational реалізує ще й Comparable ----");
        Rational[] fractions = {
                new Rational(3, 4), new Rational(-1, 2), new Rational(5, 6), new Rational(1, 3)
        };
        System.out.println("  До сортування:    " + Arrays.toString(fractions));
        Arrays.sort(fractions);  // працює завдяки compareTo()
        System.out.println("  Після сортування: " + Arrays.toString(fractions));

        System.out.println("\n---- Перевірка типів через instanceof ----");
        Object obj = new Rational(2, 3);
        System.out.println("  " + obj + " instanceof Pair?       " + (obj instanceof Pair));
        System.out.println("  " + obj + " instanceof Comparable? " + (obj instanceof Comparable));
        System.out.println("  " + obj + " instanceof Complex?    " + (obj instanceof Complex));

        System.out.println("\n---- Обробка помилок ----");
        try {
            pairs[0].add(pairs[2]);
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