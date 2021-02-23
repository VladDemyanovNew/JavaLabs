package VDemyanov.Payments.Repository;

import VDemyanov.Payments.Account.Account;

import java.util.ArrayList;

public class AccountRepository implements IRepository<Account> {
    private ArrayList<Account> accounts;

    public AccountRepository() {
        this.accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public int getLength() {
        return accounts.size();
    }

    public boolean addItem(Account account) {
        for (Account item : accounts) {
            if (item.getAccountNumber().equals(account.getAccountNumber()))
                return false;
        }
        accounts.add(account);
        return true;
    }
}
