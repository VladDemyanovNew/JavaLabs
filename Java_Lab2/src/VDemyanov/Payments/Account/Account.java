package VDemyanov.Payments.Account;

import VDemyanov.Payments.Person.Client;
import java.math.BigDecimal;

public class Account {
    private Client owner;
    private String accountNumber;
    private BigDecimal balance;

    public String getAccountNumber() {
        return accountNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public Account(String accountNumber, BigDecimal balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public void MakeDeposit(BigDecimal deposit) {
        this.balance = this.balance.add(deposit);
    }

    public void SendPayment(BigDecimal deposit) {
        this.balance = this.balance.subtract(deposit);
    }
}
