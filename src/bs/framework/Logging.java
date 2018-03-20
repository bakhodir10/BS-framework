package bs.framework;

import java.util.LinkedList;
import java.util.List;

public class Logging implements ILogging {
    private IAccount account;
    private double amount;
    private List<ILogging> loggings;

    public Logging(IAccount account, double amount) {
        this.account = account;
        this.amount = amount;
        this.loggings = new LinkedList<>();
    }

    @Override
    public void log(IAccount account, double amount) {
        this.loggings.add(new Logging(account, amount));
    }
}
