package VDemyanov.Multithreading.Task2.Airport;

import VDemyanov.Multithreading.Task2.Aircraft.Aircraft;
import VDemyanov.Multithreading.Task2.Aircraft.TaskType;
import VDemyanov.Multithreading.Task2.Person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Aiport {
    // aircrafts предназначена для хранения самолётов, которые требуют выполнить с ними какую-то задачу
    // например посадку/выгрузку пассажиров
    private ArrayList<Aircraft> aircrafts;
    // people будет хранить клиентов аэропорта (после выгрузки или перед посадкой)
    private ArrayList<Person> people;
    ReentrantLock locker;
    Condition condition;

    public Aiport() {
        this.aircrafts = new ArrayList<>();
        this.people = new ArrayList<Person>();
        this.locker = new ReentrantLock();
        this.condition = this.locker.newCondition();
    }

    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }
    public void addAircrafts(Aircraft ...aircrafts) {
        this.aircrafts.addAll(Arrays.asList(aircrafts));
    }
    public void addPerson(Person person) {
        people.add(person);
    }

    public void findAircraftForBoardingPassengers(String aircraftNumber) {
    }

    /**
     * Производит поиск самолёта с задачей на высадку пассажиров
     * @return Aircraft
     */
    public Aircraft findAircraftForDisembarking() {
        locker.lock();
        try {
            while (aircrafts.isEmpty() || aircrafts.stream().noneMatch(item -> item.getTaskType().equals(TaskType.DISEMBARKING)))
                condition.await();

            for (Aircraft aircraft : aircrafts) {
                if (aircraft.getTaskType().equals(TaskType.DISEMBARKING) && aircraft.isAvailable()) {
                    aircraft.setAvailable(false);
                    condition.signalAll();
                    aircrafts.remove(aircraft);
                    return aircraft;
                }
            }
            condition.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock();
        }
        return null;
   }

}
