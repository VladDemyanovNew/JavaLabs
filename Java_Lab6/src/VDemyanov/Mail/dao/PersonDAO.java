package VDemyanov.Mail.dao;

import VDemyanov.Mail.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
    void add(Person person) throws SQLException;
    List<Person> getAll() throws SQLException;
    Person getById(int id) throws SQLException;
    void update(Person person) throws SQLException;
    void remove(Person person) throws SQLException;
    Person getByFewestLetters() throws SQLException;
    void printInfo1() throws SQLException;
    void printInfo2(String topic) throws SQLException;
    List<Person> printInfo3(String topic) throws SQLException;
}
