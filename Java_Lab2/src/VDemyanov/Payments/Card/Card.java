package VDemyanov.Payments.Card;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Persons.Client;

public class Card {
    private Account account;
    private Client client;

    public Card(Account account, Client client) {
        this.account = account;
        this.client = client;
    }
}
