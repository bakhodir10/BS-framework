package bs.framework;

import java.util.Date;

public class Transaction {
    private double amount;
    private Date date;
    private IAccount from;
    private IAccount to;

    public Transaction(double amount, Date date, IAccount from, IAccount to) {
        this.amount = amount;
        this.date = date;
        this.from = from;
        this.to = to;
    }
}
