package VDemyanov.Multithreading.Task2.Person;

public class Person {
    private String ticketNumber;
    private String name;

    public String getTicketNumber() {
        return ticketNumber;
    }
    public String getName() {
        return name;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Person(String name, String ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }
}
