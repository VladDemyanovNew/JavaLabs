package VDemyanov.Payments.Card;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Person.Client;

public class CreditCard extends Card {
    public CreditCard(String cardNumber, Account account, Client client) {
        super(cardNumber, account, client);
    }
}
