package VDemyanov.Payments.Manager;

import VDemyanov.Payments.Person.Client;
import VDemyanov.Payments.Person.Person;
import VDemyanov.Payments.Repository.ClientRepository;
import VDemyanov.Payments.Repository.IRepository;
import com.google.gson.Gson;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonManager {
    /**
     * заполнение хранилища из XML с помощью парсера SAX
     * @param repository
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void fillPersonsFromXML(IRepository repository) throws ParserConfigurationException, SAXException, IOException {
        // Создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("files/info.xml"), (DefaultHandler) repository);
    }
}
