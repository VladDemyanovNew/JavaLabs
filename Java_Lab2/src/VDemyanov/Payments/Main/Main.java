package VDemyanov.Payments.Main;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Card.DebitCard;
import VDemyanov.Payments.Enum.ECardType;
import VDemyanov.Payments.Manager.CardManager;
import VDemyanov.Payments.Person.Client;
import VDemyanov.Payments.Repository.AccountRepository;
import VDemyanov.Payments.Repository.CardRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.math.BigDecimal;

public class Main {

    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Starting program_____________________________");

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
    };

};
