package VDemyanov.Multithreading.Task2.Aircraft;

import VDemyanov.Multithreading.Task2.Person.Person;

import java.util.ArrayList;

public class Aircraft {
    private String aircraftNumber;
    private ArrayList<Person> passengers;
    private int capacity;
    private TaskType taskType;
    private boolean isAvailable = true;

    public String getAircraftNumber() {
        return aircraftNumber;
    }
    public TaskType getTaskType() {
        return taskType;
    }
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public ArrayList<Person> getPassengers() {
        return passengers;
    }
    public void setPassengers(ArrayList<Person> passengers) {
        this.passengers = passengers;
    }

    public Aircraft(String aircraftNumber, int capacity) {
        this.aircraftNumber = aircraftNumber;
        this.passengers = new ArrayList<Person>();
        this.capacity = capacity;
        this.taskType = TaskType.NONE;
    }

    public void addPassenger(Person passenger) {
        passengers.add(passenger);
    }
}
