package bs.framework;

import java.util.Date;

public interface ILogging {
    void log(IAccount account, double amount);

    Date getDate();

    IAccount getAccount();

    double getAmount();
}
