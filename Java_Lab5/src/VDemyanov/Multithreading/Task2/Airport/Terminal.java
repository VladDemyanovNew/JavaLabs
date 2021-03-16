package VDemyanov.Multithreading.Task2.Airport;

public class Terminal implements Runnable{
    private Aiport aiport;
    private String aircraftNumber;

    public Terminal(Aiport aiport, String aircraftNumber) {
        this.aiport = aiport;
        this.aircraftNumber = aircraftNumber;
    }
    @Override
    public void run() {

    }
}
