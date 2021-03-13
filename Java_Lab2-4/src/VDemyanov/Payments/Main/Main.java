package VDemyanov.Payments.Main;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Card.Enum.ECardType;
import VDemyanov.Payments.Manager.CardManager;
import VDemyanov.Payments.Manager.ClientManager;
import VDemyanov.Payments.Manager.PersonManager;
import VDemyanov.Payments.Person.Client;
import VDemyanov.Payments.Repository.AccountRepository;
import VDemyanov.Payments.Repository.CardRepository;
import VDemyanov.Payments.Repository.ClientRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

//test
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
//test

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        LOG.info("Starting program_____________________________");

        test_SAX_GSON_StreamAPI();
        //testMethod_countAllMoneyByPassportData();

    };

    /**
     * Тест для заданий на:
     * 1. инициализацию коллекции XML;
     * 2. разбор парсером SAX;
     * 3. сериализацию / десериализацию JSON с помощью GSON
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private static void test_SAX_GSON_StreamAPI() throws ParserConfigurationException, SAXException, IOException {
        System.out.println("\n-----private static void test_SAX_GSON_StreamAPI():\n");

        Client client1 = new Client("Акимов", "Арсений", "Никитич", "AO9505996");
        Client client2 = new Client("Бабушкина", "Анастасия", "Александровна", "EE6416211");

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.addItem(client1);
        clientRepository.addItem(client2);

       // PersonManager.fillPersonsFromXML(clientRepository);
        clientRepository.fillClientsFromJSON();
        //clientRepository.writeClientsInJSON();

        ArrayList<Client> sortedClients = ClientManager.sortedClientsByName(clientRepository.getItems());
        ClientManager.printClients(sortedClients);
    }

    /**
     * Тест метода подсчитывающий деньги хранящиеся на всех счетах клиента
     */
    private static void testMethod_countAllMoneyByPassportData() {
        System.out.println("\n-----private static void testMethod_countAllMoneyByPassportData():\n");

        // инициализация клиентов
        Client client1 = new Client("Акимов", "Арсений", "Никитич", "AO9505996");
        Client client2 = new Client("Бабушкина", "Анастасия", "Александровна", "EE6416211");
        // инициализация счетов
        Account acc1 = new Account("5404 3691 2498 6217/02", new BigDecimal(1500), client1);
        Account acc2 = new Account("5404 3647 4992 5674/03  ", new BigDecimal(3000), client2);
        Account acc3 = new Account("5404 3691 2497 6217/05", new BigDecimal(500), client1);
        Account acc4 = new Account("5404 3647 4990 5674/04  ", new BigDecimal(1000), client2);

        CardRepository cardRepository = new CardRepository();

        CardManager.createCard(cardRepository, acc1, client1, ECardType.DEBIT_CARD);
        CardManager.createCard(cardRepository, acc3, client1, ECardType.CREDIT_CARD);
        CardManager.createCard(cardRepository, acc1, client1, ECardType.CREDIT_CARD);
        CardManager.createCard(cardRepository, acc2, client2, ECardType.CREDIT_CARD);
        CardManager.createCard(cardRepository, acc4, client2, ECardType.CREDIT_CARD);

        double client1Money = cardRepository.countAllMoneyByPassportData("AO9505996"); // найдём сумму денег, которую имеет client1 на всех своих картах
        double client2Money = cardRepository.countAllMoneyByPassportData("EE6416211"); // найдём сумму денег, которую имеет client2 на всех своих картах

        // у client1 3 карты, 2 из которых привязаны к одному счёту
        // поэтому сумма денег acc1 + acc3 = 1500 + 500 = 2000
        System.out.println("Сумма денег на всех картах, которую имеет client1: " + client1Money);
        // у client2 2 карты, 2 из которых привязаны к разным счетам
        // поэтому сумма денег acc2 + acc4 = 3000 + 1000 = 4000
        System.out.println("Сумма денег на всех картах, которую имеет client2: " + client2Money);
    }

    /**
     * Тест лабораторной №3
     */
    private static void testLab3() {
        Client client1 = new Client("Client1_Name", "Client1_lastName", "Client1_middleName", "k12-l23-l23-o23");
        Client client2 = new Client("Client2_Name", "Client2_lastName", "Client2_middleName", "k12-l23-l23-o24");


        AccountRepository accountRepository = new AccountRepository();
        CardRepository cardRepository = new CardRepository();

        Account acc = new Account("1", new BigDecimal(2000), client1);
        Account acc2 = new Account("2", new BigDecimal(2000), client2);

        CardManager.createCard(cardRepository, acc, client1, ECardType.DEBIT_CARD);
        CardManager.createCard(cardRepository, acc2, client2, ECardType.CREDIT_CARD);

        client1.makeDeposit(new BigDecimal(3000), "c0", cardRepository);
        //client1.blockCard(true, "k1", cardRepository);
        client1.sendPayment(new BigDecimal(200), "c0", cardRepository);
        System.out.printf("client1 balance: %f", client1.getBalance("c0", cardRepository));
    }
};
