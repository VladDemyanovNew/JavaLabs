package VDemyanov.Multithreading.Task2;

import VDemyanov.Multithreading.Task2.Aircraft.Aircraft;
import VDemyanov.Multithreading.Task2.Aircraft.TaskType;
import VDemyanov.Multithreading.Task2.Airport.Aiport;
import VDemyanov.Multithreading.Task2.Airport.Ladder;
import VDemyanov.Multithreading.Task2.Person.Person;

import java.util.ArrayList;

public class Task2Launcher {
    public static void Launch() {
        Aiport aiport = new Aiport();

        testDisembarking(aiport);
    }

    private static void testDisembarking(Aiport aiport) {
        Aircraft aircraft1 = new Aircraft("aircraft1", 7);
        Aircraft aircraft2 = new Aircraft("aircraft2", 10);
        Aircraft aircraft3 = new Aircraft("aircraft3", 5);
        Aircraft aircraft4 = new Aircraft("aircraft4", 6);
        Aircraft aircraft5 = new Aircraft("aircraft5", 8);

        aircraft1.setPassengers(generatePeople(7, "aircraft1"));
        aircraft2.setPassengers(generatePeople(10, "aircraft2"));
        aircraft3.setPassengers(generatePeople(5, "aircraft3"));
        aircraft4.setPassengers(generatePeople(6, "aircraft4"));
        aircraft5.setPassengers(generatePeople(8, "aircraft5"));

        aircraft1.setTaskType(TaskType.DISEMBARKING);
        aircraft2.setTaskType(TaskType.DISEMBARKING);
        aircraft3.setTaskType(TaskType.DISEMBARKING);
        aircraft4.setTaskType(TaskType.DISEMBARKING);
        aircraft5.setTaskType(TaskType.DISEMBARKING);

        aiport.addAircrafts(aircraft1, aircraft2, aircraft3, aircraft4, aircraft5);
        Ladder ladder1 = new Ladder(aiport);
        Ladder ladder2 = new Ladder(aiport);
        Ladder ladder3 = new Ladder(aiport);

        new Thread(ladder1).start();
        new Thread(ladder2).start();
        new Thread(ladder3).start();
    }

    private static ArrayList<Person> generatePeople(int count, String ticketNumber) {
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        for (int i = 0; i < count; i++) {
            personArrayList.add(new Person("Person" + i, ticketNumber));
        }
        return  personArrayList;
    }
}
