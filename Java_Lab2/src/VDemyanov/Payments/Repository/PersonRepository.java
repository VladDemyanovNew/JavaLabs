package VDemyanov.Payments.Repository;

import VDemyanov.Payments.Person.Person;

import java.util.ArrayList;

public class PersonRepository implements IRepository<Person> {
    private ArrayList<Person> persons;

    public PersonRepository() {
        this.persons = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public boolean addItem(Person person) {
        for (Person item : persons) {
            if (item.getPassportData().equals(person.getPassportData()))
                return false;
        }
        persons.add(person);
        return true;
    }

}
