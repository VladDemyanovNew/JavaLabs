package VDemyanov.Multithreading.Task2.Airport;

import VDemyanov.Multithreading.Task2.Aircraft.Aircraft;

public class Ladder implements Runnable{
    private Aiport aiport;

    public Ladder(Aiport aiport) {
        this.aiport = aiport;
    }

    @Override
    public void run() {
        while (!aiport.getAircrafts().isEmpty()) {
            Aircraft aircraft = aiport.findAircraftForDisembarking();
            aircraft.getPassengers().stream()
                    .forEach(passenger -> {
                        System.out.printf(
                                "Номер трапа: %s; Самолёт: %s; Имя пассажира: %s; \n",
                                Thread.currentThread().getName(),
                                aircraft.getAircraftNumber(),
                                passenger.getName()
                        );
                        aiport.addPerson(passenger);
                        try{
                            Thread.sleep(100);
                        }
                        catch(InterruptedException e){}
                    });
        }
    }
}
