package VDemyanov.Multithreading.Task1.Person;

import VDemyanov.Multithreading.Task1.Bathroom.Bathroom;

public class Person implements Runnable {
    /**
     * Возвращает пол человека
     * @return Sex sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Возвращает имя человека
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает количество времени, которое будет принимать душ человек
     * @return int time
     */
    public int getTime() {
        return time;
    }

    private Sex sex;
    private String name;
    private Bathroom bathroom;
    private int time;

    /**
     *
     * @param name
     * @param sex
     * @param bathroom
     * @param time
     */
    public Person(String name, Sex sex, Bathroom bathroom, int time) {
        this.name = name;
        this.sex = sex;
        this.bathroom = bathroom;
        this.time = time;
    }

    public void useBathroom() {
        this.bathroom.addPerson(this);
        for (int i = 0; i < this.getTime(); i++){
            System.out.printf("%s %s \n", Thread.currentThread().getName(), "принимает душ");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }

    public void leaveBathroom() {
        this.bathroom.removePerson(this);
    }

    @Override
    public void run() {
        useBathroom();
        leaveBathroom();
    }
}
