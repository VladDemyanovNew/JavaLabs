package VDemyanov.Payments.Person;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String lastName;
    private String middleName;
    private String passportData;

    public Person(String name, String lastName, String middleName, String passportData) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.name = name;
        this.passportData = passportData;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPassportData() {
        return passportData;
    }
}
