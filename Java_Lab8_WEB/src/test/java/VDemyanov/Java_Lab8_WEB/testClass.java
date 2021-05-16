package VDemyanov.Java_Lab8_WEB;

import VDemyanov.Java_Lab8_WEB.entity.Person;
import VDemyanov.Java_Lab8_WEB.service.PersonService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class testClass {
    private static final Logger logger = LoggerFactory.getLogger(testClass.class);

    @Test
    public void testMethod() {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
        logger.info("TEST {} {}", dt1, dt2);

        Util util = new Util();
        util.getConnection();
    }

    @Test
    public void testAuth() throws SQLException {
        PersonService personService = new PersonService();
        Person person = personService.getByLoginAndPassword("VDemyanov", "password");
        System.out.println(person.toString());
    }

}
