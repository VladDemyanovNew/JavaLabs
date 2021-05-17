package VDemyanov.Java_Lab8_WEB.service;

import VDemyanov.Java_Lab8_WEB.bl.Util;
import VDemyanov.Java_Lab8_WEB.dao.RoleDAO;
import VDemyanov.Java_Lab8_WEB.entity.Person;
import VDemyanov.Java_Lab8_WEB.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleService implements RoleDAO {
    Util util = new Util();

    @Override
    public String getRoleName(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String roleName = null;

        String sql = "SELECT Name FROM Role WHERE Id = ?";

        try {
            connection = util.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roleName = resultSet.getString("Name");
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

        return roleName;
    }

    @Override
    public void add(Role person) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getById(int id) {
        return null;
    }

    @Override
    public void update(Role person) {

    }

    @Override
    public void remove(Role dragon) throws SQLException {

    }
}
