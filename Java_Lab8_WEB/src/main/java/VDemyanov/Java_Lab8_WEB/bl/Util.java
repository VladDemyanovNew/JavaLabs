package VDemyanov.Java_Lab8_WEB.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.Properties;

public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    private String url;
    private String username;
    private String password;
    private static final String DB_PROPERTIES = "database.properties";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public Util(){
        this.url = "jdbc:mysql://localhost:3306/Lab9_database?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
        this.username = "root";
        this.password = "admin";
    }

    public Connection getConnection() {
        Connection connection = null;
        LocalDateTime dt1 = null;
        LocalDateTime dt2 =  null;
        try{
            Class.forName(DB_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, username, password);
            dt1 = LocalDateTime.now();
            dt2 = LocalDateTime.now();
            logger.info("Connection to Lab9_database succesfull!\n {} {}", dt1, dt2);
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            dt1 = LocalDateTime.now();
            dt2 = LocalDateTime.now();
            logger.info("Connection failed...\n {} \n{} {}", ex, dt1, dt2);
        }
        return connection;
    }
}
