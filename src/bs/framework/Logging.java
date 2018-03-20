package bs.framework;

import java.util.Date;

public class Logging implements ILogging {
    private IAccount account;
    private double amount;
    private Date date;

    public Logging(IAccount account, double amount) {
        this.account = account;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public void log(IAccount account, double amount) {
        History.getInstance().save(new Logging(account, amount));
    }
}
