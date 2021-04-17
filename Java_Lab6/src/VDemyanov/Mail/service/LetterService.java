package VDemyanov.Mail.service;

import VDemyanov.Mail.bl.Util;
import VDemyanov.Mail.dao.LetterDAO;
import VDemyanov.Mail.entity.Letter;
import VDemyanov.Mail.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LetterService extends Util implements LetterDAO {
    Connection connection = getConnection();

    @Override
    public void sendAll(Letter letter) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = " INSERT INTO Letter (Sender, Recipient, Topic, Text, ShippingDate) " +
                     " VALUES (?, ?, ?, ?, ?); ";
        PersonService personService = new PersonService();

        try {
            List<Person> people = personService.getAll();
            connection = getConnection();
            connection.setAutoCommit(false);
            int test = 0;

            for (Person person : people) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, letter.getSender());
                preparedStatement.setInt(2, person.getId());
                preparedStatement.setString(3, letter.getTopic());
                preparedStatement.setString(4, letter.getText());
                preparedStatement.setDate(5, letter.getShippingDate());
                preparedStatement.executeUpdate();
//                if (test == 2)
//                    connection.rollback();
            }
            connection.commit();
            connection.setAutoCommit(true);

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
    }

    @Override
    public void add(Letter letter) {

    }

    @Override
    public List<Letter> getAll() {
        return null;
    }

    @Override
    public Letter getById(int id) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void remove(Person person) {

    }

}
