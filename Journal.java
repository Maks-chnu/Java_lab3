package Java_lab3;

/**
 * Підклас: журнал. Додає номер випуску та періодичність.
 */
public class Journal extends PrintedPublication {

    private int issueNumber;    // номер випуску
    private String periodicity; // періодичність (щомісячний, щотижневий...)

    public Journal(String title, String publisher, int year, int pages,
                   int issueNumber, String periodicity) {
        super(title, publisher, year, pages);
        this.issueNumber = issueNumber;
        this.periodicity = periodicity;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    @Override
    protected String getTypeName() {
        return "Журнал";
    }

    @Override
    public void show() {
        super.show();
        System.out.println("  Номер випуску:      " + issueNumber);
        System.out.println("  Періодичність:      " + periodicity);
    }
}