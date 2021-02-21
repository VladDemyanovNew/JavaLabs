package VDemyanov.Payments.Card;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Persons.Client;

public class DebitCard extends Card {
    public DebitCard(Account account, Client client) {
        super(account, client);
    }
}
