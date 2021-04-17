package test.TestPerson;

import VDemyanov.Mail.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Date;
import java.util.Calendar;

@RunWith(Parameterized.class)
public class TestPerson {

    @Parameterized.Parameters
    public static Object[][] parseLocaleData() {
        return new Object[][]{
                {"2002-02-18", 19},
                {"1999-01-20", 22},
                {"1980-08-02", 40},
                {"1967-03-06", 54},
                {"1973-03-06", 48},
                {"1986-03-06", 35},
                {"1970-03-06", 51}
        };
    }

    private String birthday;
    private int expected;

    public TestPerson(String birthday, int expected) {
        this.birthday = birthday;
        this.expected = expected;
    }

    @Test
    public void testCalcAge() throws Exception {
        Person person = new Person();
        person.setId(1);
        person.setName("userName_testCalcAge");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.valueOf(birthday));
        person.setBirthday(new Date(calendar.getTime().getTime()));
        System.out.println(person.calcAge());
        Assert.assertEquals(expected, person.calcAge());
    }
}
