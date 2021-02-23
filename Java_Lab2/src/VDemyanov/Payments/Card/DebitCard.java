package VDemyanov.Payments.Card;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Person.Client;

public class DebitCard extends Card {
    public DebitCard(String cardNumber, Account account, Client client) {
        super(cardNumber, account, client);
    }
}
