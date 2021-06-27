package by.VDemyanov.JMS_Lab14.repository;

import by.VDemyanov.JMS_Lab14.JDBC.ConnectorDB;
import by.VDemyanov.JMS_Lab14.models.Dragon;
import by.VDemyanov.JMS_Lab14.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJSON {
    public static void main(String[] args) throws SQLException {
        /*UserRepository userRepository = new UserRepository();
        User user1 = new User(1, "user1", 10);
        User user2 = new User(2, "user2", 13);
        User user3 = new User(3, "user3", 18);
        User user4 = new User(4, "user4", 7);
        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);
        userRepository.add(user4);
        userRepository.writeInJson();*/

        String query = "SELECT * FROM Dragon;";
        Statement statement = null;
        Connection connection = null;

        try {
            ConnectorDB connectorDB = new ConnectorDB();
            connection = connectorDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Dragon dragon = new Dragon(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Power"),
                        resultSet.getInt("Health")
                );
                System.out.println(dragon.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
