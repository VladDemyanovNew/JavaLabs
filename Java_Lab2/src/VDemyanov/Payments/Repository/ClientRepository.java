package VDemyanov.Payments.Repository;

import VDemyanov.Payments.Person.Client;
import VDemyanov.Payments.Person.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.naming.Context;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClientRepository extends DefaultHandler implements IRepository<Client>, Serializable {
    private ArrayList<Client> clients;
    private String filePathJSON = "files/clients.json";

    public ClientRepository() throws ParserConfigurationException, SAXException {
        this.clients = new ArrayList<Client>();
    }

    public ArrayList<Client> getItems() {
        return clients;
    }

    public boolean addItem(Client client) {
        for (Client item : clients) {
            if (item.getPassportData().equals(client.getPassportData()))
                return false;
        }
        clients.add(client);
        return true;
    }

    /**
     * сериализаци коллекции клиентов в json с помощью GSON
     * @throws FileNotFoundException
     */
    public void writeClientsInJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(clients);
        try(FileWriter fileWriter = new FileWriter("files/clients.json", false)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * десериализация json в коллекцию клиентов с помощью GSON
     * @throws FileNotFoundException
     */
    public void fillClientsFromJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Client>>() {}.getType();
        try(FileReader fileReader = new FileReader("files/clients.json")) {
            File file = new File("files/clients.json");
            if (file.length() != 0) {
                clients.addAll(gson.fromJson(fileReader, type));
            } else {
                System.out.println("Файл пуст!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Client")) {
            String name = attributes.getValue("name");
            String lastName = attributes.getValue("lastName");
            String middleName = attributes.getValue("middleName");
            String passportData = attributes.getValue("passportData");
            clients.add(new Client(name, lastName, middleName, passportData));
        }
    }

}
