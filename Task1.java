package Java_lab3;

import java.time.Year;
import java.util.Scanner;

/**
 * Завдання 1. Програма вводить інформацію про видання в масив типу суперкласу
 * PrintedPublication і друкує його за допомогою методу show().
 */
public class Task1 {

    private static final Scanner in = new Scanner(System.in);
    private static final int MAX_YEAR = Year.now().getValue();

    public static void main(String[] args) {
        System.out.println("Лабораторна робота №3, завдання 1: ієрархія друкованих видань");
        int mode = readInt("1 — ввести дані вручну, 2 — використати демо-дані: ", 1, 2);

        // Масив типу СУПЕРКЛАСУ: у ньому можуть лежати об'єкти будь-яких підкласів
        PrintedPublication[] publications = (mode == 1) ? readPublications() : createDemoData();

        System.out.println("\n----- Введений масив -------");
        for (int i = 0; i < publications.length; i++) {
            System.out.println("\n#" + (i + 1));
            publications[i].show();  // поліморфізм: викликається show() реального класу
        }

        in.close();
    }

    // Введення масиву видань з клавіатури
    private static PrintedPublication[] readPublications() {
        int n = readInt("Скільки видань ввести (1..20): ", 1, 20);
        PrintedPublication[] arr = new PrintedPublication[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Видання #" + (i + 1) + " ---");
            System.out.println("Тип: 1 — друковане видання, 2 — книга, 3 — журнал, 4 — підручник");
            int type = readInt("Ваш вибір: ", 1, 4);

            // Спільні поля для всіх типів
            String title = readLine("Назва: ");
            String publisher = readLine("Видавництво: ");
            int year = readInt("Рік видання (1450.." + MAX_YEAR + "): ", 1450, MAX_YEAR);
            int pages = readInt("Кількість сторінок (1..10000): ", 1, 10000);

            switch (type) {
                case 1 -> arr[i] = new PrintedPublication(title, publisher, year, pages);
                case 2 -> {
                    String author = readLine("Автор: ");
                    String genre = readLine("Жанр: ");
                    arr[i] = new Book(title, publisher, year, pages, author, genre);
                }
                case 3 -> {
                    int issue = readInt("Номер випуску (1..1000): ", 1, 1000);
                    String periodicity = readLine("Періодичність: ");
                    arr[i] = new Journal(title, publisher, year, pages, issue, periodicity);
                }
                case 4 -> {
                    String author = readLine("Автор: ");
                    String genre = readLine("Жанр: ");
                    String subject = readLine("Дисципліна: ");
                    String audience = readLine("Для кого (клас, курс): ");
                    arr[i] = new Textbook(title, publisher, year, pages, author, genre, subject, audience);
                }
            }
        }
        return arr;
    }

    // Демо-дані, щоб швидко перевірити роботу програми без ручного введення
    private static PrintedPublication[] createDemoData() {
        return new PrintedPublication[] {
                new PrintedPublication("Довідник абітурієнта", "Видавництво «Буковина»", 2025, 120),
                new Book("Пригоди в горах", "Видавництво «Світанок»", 2019, 256,
                        "О. Коваленко", "Пригодницький роман"),
                new Journal("Світ ІТ", "Медіагрупа «Технології»", 2026, 64, 7, "щомісячний"),
                new Textbook("Програмування мовою Java", "Видавництво «Освіта»", 2024, 350,
                        "І. Петренко", "Навчальна література", "Програмування", "студенти 2 курсу")
        };
    }

    // ------- Допоміжні методи для надійного введення -------

    // Читає непорожній рядок
    private static String readLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = in.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Помилка: значення не може бути порожнім.");
        }
    }

    // Читає ціле число в діапазоні [min; max]
    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = in.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Помилка: число має бути від " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть ціле число.");
            }
        }
    }
}