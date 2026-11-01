package Java_lab3;


 // Суперклас (базовий клас) ієрархії — друковане видання.
 //Містить поля, спільні для всіх видань: назва, видавництво, рік, кількість сторінок.

public class PrintedPublication {

    private String title;      
    private String publisher;  
    private int year;          
    private int pages;         

    public PrintedPublication(String title, String publisher, int year, int pages) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
    }


    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    protected String getTypeName() {
        return "Друковане видання";
    }

    public void show() {
        System.out.println("[" + getTypeName() + "]");
        System.out.println("  Назва:              " + title);
        System.out.println("  Видавництво:        " + publisher);
        System.out.println("  Рік видання:        " + year);
        System.out.println("  Кількість сторінок: " + pages);
    }
}