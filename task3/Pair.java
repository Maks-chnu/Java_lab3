package Java_lab3.task3;

/**
 * Інтерфейс "пара чисел" — заміна абстрактного класу з завдання 2.
 * Інтерфейс описує лише ЩО вміє об'єкт (контракт), а не як він влаштований:
 * у ньому немає полів об'єкта і конструкторів.
 */
public interface Pair {

    // Методи інтерфейсу за замовчуванням public abstract
    Pair add(Pair other);

    Pair subtract(Pair other);

    Pair multiply(Pair other);

    default void printOperations(Pair other) {
        System.out.println("  (" + this + ") + (" + other + ") = " + add(other));
        System.out.println("  (" + this + ") - (" + other + ") = " + subtract(other));
        System.out.println("  (" + this + ") * (" + other + ") = " + multiply(other));
    }
}