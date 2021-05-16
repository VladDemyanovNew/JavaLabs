package VDemyanov.Java_Lab8_WEB.service;

import VDemyanov.Java_Lab8_WEB.bl.Util;
import VDemyanov.Java_Lab8_WEB.dao.PersonDAO;
import VDemyanov.Java_Lab8_WEB.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonService implements PersonDAO {
    Util util = new Util();

    @Override
    public Person getByLoginAndPassword(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Person person = null;

        String sql = "SELECT * FROM Person WHERE Login = ? AND Password = ?";

        try {
            connection = util.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("Id"));
                person.setPassword(resultSet.getString("Password"));
                person.setLogin(resultSet.getString("Login"));
                person.setRole(resultSet.getInt("Role"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return person;
    }

    @Override
    public void add(Person person) {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getById(int id) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void remove(Person person) {

    }
}
