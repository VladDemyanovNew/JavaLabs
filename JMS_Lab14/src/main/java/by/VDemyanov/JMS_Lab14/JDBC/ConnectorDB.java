package by.VDemyanov.JMS_Lab14.JDBC;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ResourceBundle;

public class ConnectorDB {
    private String url;
    private String user;
    private String pass;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public ConnectorDB() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        this.url = resourceBundle.getString("db.url");
        this.pass = resourceBundle.getString("db.password");
        this.user = resourceBundle.getString("db.user");
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return connection;
    }
}
