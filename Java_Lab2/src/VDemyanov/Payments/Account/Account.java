package VDemyanov.Payments.Account;

import VDemyanov.Payments.Persons.Client;
import java.math.BigDecimal;

public class Account {
    private Client owner;
    private String accountNumber;
    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }
}
