package VDemyanov.Mail.bl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Util {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private static final String DB_PROPERTIES = "data/database.properties";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public Util() {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get(DB_PROPERTIES))){
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.dbUrl = props.getProperty("url");
        this.dbUsername = props.getProperty("username");
        this.dbPassword = props.getProperty("password");
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connection to DB succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return connection;
    }
}
