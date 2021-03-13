package VDemyanov.Multithreading.Task1;

import VDemyanov.Multithreading.Task1.Bathroom.Bathroom;
import VDemyanov.Multithreading.Task1.Person.Person;
import VDemyanov.Multithreading.Task1.Person.Sex;

public class Task1Launcher {
    public static void launch() {
        Bathroom bathroom=new Bathroom(3);
        Person man1 = new Person("Vlad", Sex.MAN, bathroom, 10);
        Person man2 = new Person("Alex", Sex.MAN, bathroom, 3);
        Person man3 = new Person("Jhon", Sex.MAN, bathroom, 6);

        Person woman1 = new Person("Kate", Sex.WOMAN, bathroom, 9);
        Person woman2 = new Person("Liza", Sex.WOMAN, bathroom, 12);
        Person woman3 = new Person("Ksenia", Sex.WOMAN, bathroom, 2);

        Thread t1 = new Thread(man1);
        t1.setName(man1.getName());
        Thread t2 = new Thread(woman1);
        t2.setName(woman1.getName());
        Thread t3 = new Thread(man2);
        t3.setName(man2.getName());
        Thread t4 = new Thread(woman2);
        t4.setName(woman2.getName());
        Thread t5 = new Thread(man3);
        t5.setName(man3.getName());
        Thread t6 = new Thread(woman3);
        t6.setName(woman3.getName());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
