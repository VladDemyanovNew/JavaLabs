package VDemyanov.Payments.Card;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Persons.Client;

public class CreditCard extends Card {
    public CreditCard(Account account, Client client) {
        super(account, client);
    }
}
