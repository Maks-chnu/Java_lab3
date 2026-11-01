package Java_lab3;

/**
 * Підклас другого рівня: підручник — це книга, яка має ще навчальну дисципліну
 * та цільову аудиторію. Ієрархія: PrintedPublication -> Book -> Textbook.
 */
public class Textbook extends Book {

    private String subject;   // навчальна дисципліна
    private String audience;  // для кого (клас, курс)

    public Textbook(String title, String publisher, int year, int pages,
                    String author, String genre, String subject, String audience) {
        super(title, publisher, year, pages, author, genre);  // конструктор Book
        this.subject = subject;
        this.audience = audience;
    }

    public String getSubject() {
        return subject;
    }

    public String getAudience() {
        return audience;
    }

    @Override
    protected String getTypeName() {
        return "Підручник";
    }

    @Override
    public void show() {
        super.show();  // виводить поля PrintedPublication + Book
        System.out.println("  Дисципліна:         " + subject);
        System.out.println("  Для кого:           " + audience);
    }
}