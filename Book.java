package Java_lab3;

/**
 * Підклас: книга. Успадковує все від PrintedPublication і додає автора та жанр.
 */
public class Book extends PrintedPublication {

    private String author; 
    private String genre;   

    public Book(String title, String publisher, int year, int pages,
                String author, String genre) {
        super(title, publisher, year, pages);  // виклик конструктора суперкласу
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    protected String getTypeName() {
        return "Книга";
    }

    @Override
    public void show() {
        super.show();  // спочатку виводимо спільні поля
        System.out.println("  Автор:              " + author);
        System.out.println("  Жанр:               " + genre);
    }
}