package VDemyanov.Multithreading.Task1.Bathroom;

import VDemyanov.Multithreading.Task1.Person.Person;
import VDemyanov.Multithreading.Task1.Person.Sex;

import java.util.ArrayList;

public class Bathroom {

    private int capacity;
    private Sex currentSex;
    private ArrayList<Person> personArrayList;

    /**
     * Возвращает вместимость душевой
     * @return int capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Возвращает пол человека, который может находиться в душевой
     * @return Sex currentSex
     */
    public Sex getCurrentSex() {
        return currentSex;
    }

    /**
     *
     * @param capacity
     */
    public Bathroom(int capacity) {
        this.capacity = capacity;
        this.personArrayList = new ArrayList<Person>();
        this.currentSex = Sex.NONE;
    }

    /**
     * Помещает человека в душевую
     * @param person
     */
    public synchronized void addPerson(Person person) {
        if (this.personArrayList.isEmpty())
            this.currentSex = person.getSex();

        while (isFull() || !person.getSex().equals(currentSex)) {
            try {
                wait();
                if (this.currentSex.equals(Sex.NONE))
                    this.currentSex = person.getSex();
            }
            catch (InterruptedException e) {
            }
        }

        this.personArrayList.add(person);
        checkSex(person, "вошёл");

        notify();
    }

    /**
     * Убирает человека из душевой
     * @param person
     */
    public synchronized void removePerson(Person person) {
        if (!this.personArrayList.isEmpty()) {
            this.personArrayList.remove(person);
            checkSex(person, "вышел");
        }

        if (this.personArrayList.isEmpty())
            this.currentSex = Sex.NONE;

        notify();
    }

    /**
     * Проверяет переполнение душевой
     * @return boolean
     */
    public boolean isFull() {
        return this.personArrayList.size() >= this.capacity;
    }

    /**
     * Выводит сообщение в зависимости от пола
     * @param person
     * @param actionMessage
     */
    private void checkSex(Person person, String actionMessage) {
        if (person.getSex().equals(Sex.MAN)) {
            System.out.printf("Человек: %s; Действие: %s; \n", Thread.currentThread().getName() + "(м)", actionMessage);
        } else if (person.getSex().equals(Sex.WOMAN)) {
            System.out.printf("Человек: %s; Действие: %s; \n", Thread.currentThread().getName() + "(ж)", actionMessage);
        }
    }
}
