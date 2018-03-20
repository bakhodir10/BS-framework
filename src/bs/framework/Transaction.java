package bs.framework;

import java.util.Date;

public class Transaction {
    private double amount;
    private Date date = new Date();
    private IAccount account;

    public Transaction(double amount, IAccount account) {
        this.amount = amount;
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public IAccount getAccount() {
        return account;
    }
}
