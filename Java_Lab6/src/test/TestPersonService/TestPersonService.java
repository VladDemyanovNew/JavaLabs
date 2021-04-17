package test.TestPersonService;

import VDemyanov.Mail.entity.Letter;
import VDemyanov.Mail.entity.Person;
import VDemyanov.Mail.service.LetterService;
import VDemyanov.Mail.service.PersonService;
import org.junit.*;
import org.junit.rules.Timeout;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class TestPersonService {
    private PersonService personService = new PersonService();

    /**
     * Тестирует метод получения из базы пользователя с заданным идентификатором
     * @throws Exception
     */
    @Test
    @After
    public void testGetById() throws Exception {

        int id = createPerson("UserTesting_GetById");

        Person result = personService.getById(id);
        Assert.assertEquals(id, result.getId());
    }

    /**
     * Тестирует метод обновления пользователя в БД
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        int id = createPerson("UserTesting_testUpdate");

        Person person = new Person();
        person.setId(id);
        person.setName("UserTesting_testUpdate_afterTest");
        Calendar calendar = Calendar.getInstance();
        person.setBirthday(new Date(calendar.getTime().getTime()));

        personService.update(person);
        Person result = personService.getById(id);
        Assert.assertEquals("UserTesting_testUpdate_afterTest", result.getName());
    }

    /**
     * Тестирует метод, который делает:
     * вывод информации о пользователях, которые не получали
     * сообщения с заданной темой
     * @throws Exception
     */
    @Test
    @Ignore
    public void testPrintInfo3() throws Exception {
        LetterService letterService = new LetterService();
        String topic = "testPrintInfo3";

        Letter letter = new Letter();
        letter.setSender(3);
        letter.setTopic(topic);
        letter.setText(topic);
        Calendar calendar = Calendar.getInstance();
        letter.setShippingDate(new Date(calendar.getTime().getTime()));

        letterService.sendAll(letter);

        List<Person> people = personService.printInfo3(topic);
        List<Person> people2 = personService.getAll();
        int expected = people2.size();
        Assert.assertEquals(expected, people.size());
    }

    private int createPerson(String userName) throws SQLException {
        List<Person> people = personService.getAll();
        int id = people.size() + 1;
        userName += id;

        Person person = new Person();
        person.setId(id);
        person.setName(userName);
        Calendar calendar = Calendar.getInstance();
        person.setBirthday(new Date(calendar.getTime().getTime()));

        personService.add(person);

        return id;
    }
}
