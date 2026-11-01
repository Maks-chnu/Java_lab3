package Java_lab3.task2;

/**
 * Абстрактний базовий клас "пара чисел".
 * Оголошує абстрактні арифметичні операції, які мають реалізувати підкласи.
 * Створити об'єкт Pair напряму неможливо: new Pair() — помилка компіляції.
 */
public abstract class Pair {

    // Поле базового класу: лічильник створених об'єктів усіх підкласів
    private static int createdCount = 0;

    // Конструктор абстрактного класу викликається з конструкторів підкласів
    protected Pair() {
        createdCount++;
    }

    public static int getCreatedCount() {
        return createdCount;
    }

    //Абстрактні методи (без тіла) — "контракт" для підкласів 

    public abstract Pair add(Pair other);

    public abstract Pair subtract(Pair other);

    public abstract Pair multiply(Pair other);

    //Звичайний (не абстрактний) метод — спільний для всіх підкласів
    // Він викликає абстрактні методи, а яка саме реалізація спрацює,
    // визначається під час виконання (поліморфізм).
    public void printOperations(Pair other) {
        System.out.println("  (" + this + ") + (" + other + ") = " + add(other));
        System.out.println("  (" + this + ") - (" + other + ") = " + subtract(other));
        System.out.println("  (" + this + ") * (" + other + ") = " + multiply(other));
    }
}