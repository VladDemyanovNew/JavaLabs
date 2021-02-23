package VDemyanov.Payments.Card;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Person.Client;

import java.math.BigDecimal;

public class Card {
    private Account account;
    private Client client;
    private String cardNumber;
    private boolean cardBlock;

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardBlock(boolean cardBlock) {
        this.cardBlock = cardBlock;
    }
    public boolean isCardBlock() {
        return cardBlock;
    }
    public Client getClient() {
        return client;
    }

    public Card(String cardNumber, Account account, Client client) {
        this.account = account;
        this.client = client;
        this.cardNumber = cardNumber;
        this.cardBlock = false;
    }

    public void makeDeposit(BigDecimal deposit) {
        account.MakeDeposit(deposit);
    }

    public void sendPayment(BigDecimal payment) {
        account.SendPayment(payment);
    }

    public BigDecimal getBalance() {
        return account.getBalance();
    }
}
