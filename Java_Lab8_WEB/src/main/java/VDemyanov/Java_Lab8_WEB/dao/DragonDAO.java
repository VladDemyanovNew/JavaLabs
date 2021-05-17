package VDemyanov.Java_Lab8_WEB.dao;

import VDemyanov.Java_Lab8_WEB.entity.Dragon;
import VDemyanov.Java_Lab8_WEB.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface DragonDAO {
    void add(Dragon dragon) throws SQLException;
    List<Dragon> getAll() throws SQLException;
    void update(Dragon dragon);
    void remove(int id) throws SQLException;
}
