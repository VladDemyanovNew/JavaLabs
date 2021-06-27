package by.VDemyanov.JMS_Lab14.JDBC;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectorDB connectorDB = new ConnectorDB();

        try (Connection conn = connectorDB.getConnection()) {
            System.out.println("Connection to Store DB succesfull!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
