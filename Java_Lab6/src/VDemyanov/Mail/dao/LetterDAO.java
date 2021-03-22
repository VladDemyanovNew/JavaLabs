package VDemyanov.Mail.dao;

import VDemyanov.Mail.entity.Letter;
import VDemyanov.Mail.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface LetterDAO {
    void add(Letter letter);
    List<Letter> getAll();
    Letter getById(int id);
    void update(Person person);
    void remove(Person person);
    void sendAll(Letter letter) throws SQLException;
}
