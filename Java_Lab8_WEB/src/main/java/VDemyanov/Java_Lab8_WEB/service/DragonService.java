package VDemyanov.Java_Lab8_WEB.service;

import VDemyanov.Java_Lab8_WEB.bl.Util;
import VDemyanov.Java_Lab8_WEB.dao.DragonDAO;
import VDemyanov.Java_Lab8_WEB.entity.Dragon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DragonService implements DragonDAO {
    Util util = new Util();

    @Override
    public void add(Dragon dragon) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String sql = "INSERT INTO Dragon (Name, Power, Health) VALUES (?, ?, ?)";

        try {
            connection = util.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, dragon.getName());
            preparedStatement.setInt(2, dragon.getPower());
            preparedStatement.setInt(3, dragon.getHealth());
            preparedStatement.executeUpdate();
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
    public List<Dragon> getAll() throws SQLException {
        String sql = "SELECT * FROM Dragon";
        List<Dragon> people = new ArrayList<Dragon>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = util.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Dragon person = new Dragon(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Power"),
                        resultSet.getInt("Health")
                );

                people.add(person);
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

        return people;
    }

    @Override
    public void update(Dragon dragon) {

    }

    @Override
    public void remove(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String sql = "DELETE FROM Dragon WHERE Id = ?";

        try {
            connection = util.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
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
}
