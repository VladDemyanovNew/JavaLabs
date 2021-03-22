package VDemyanov.Mail;

import VDemyanov.Mail.bl.Util;
import VDemyanov.Mail.entity.Letter;
import VDemyanov.Mail.entity.Person;
import VDemyanov.Mail.service.LetterService;
import VDemyanov.Mail.service.PersonService;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        PersonService personService = new PersonService();
        LetterService letterService = new LetterService();

        Letter letter = new Letter();
        letter.setSender(5);
        letter.setTopic("Последний запрос");
        letter.setText("Направить письмо заданного человека с заданной темой всем\n" +
                "адресатам");
        Calendar calendar = Calendar.getInstance();
        letter.setShippingDate(new Date(calendar.getTime().getTime()));

        try {

            System.out.println("\nНайти пользователя у которого меньше всего писем:");
            Person person = personService.getByFewestLetters();
            System.out.println(person.toString());

            System.out.println("\nВывести информацию о пользователях, а также количестве\n" +
                    "полученных и отправленных ими письмах:");
            personService.printInfo1();

            System.out.println("\nВывести информацию о пользователях, которые получили хотя бы\n" +
                    "одно сообщение с заданной темой");
            personService.printInfo2("topic3");

            System.out.println("\nВывести информацию о пользователях, которые не получали\n" +
                    "сообщения с заданной темой");
            personService.printInfo3("topic3");

            System.out.println("\nНаправить письмо заданного человека с заданной темой всем\n" +
                    "адресатам");
            letterService.sendAll(letter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
