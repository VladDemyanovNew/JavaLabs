package VDemyanov.Java_Lab8_WEB.dao;

import VDemyanov.Java_Lab8_WEB.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
    void add(Person person);
    List<Person> getAll();
    Person getById(int id);
    void update(Person person);
    void remove(Person person);
    Person getByLoginAndPassword(String login, String password) throws SQLException;
}
