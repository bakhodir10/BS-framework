package bs.framework;

import java.util.Date;

public class Logging implements ILogging {
    private IAccount account;
    private double amount;
    private Date date;
    private TransferType type;

    public Logging(IAccount account, double amount, TransferType type) {
        this.account = account;
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }

    @Override
    public void log(IAccount account, double amount, TransferType type) {
        History.getInstance().save(new Logging(account, amount, type));
    }

    @Override
    public IAccount getAccount() {
        return this.account;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public Date getDate() {
        return this.date;
    }
}
