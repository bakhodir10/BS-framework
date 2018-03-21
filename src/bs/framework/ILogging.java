package bs.framework;

import java.util.Date;

public interface ILogging {
    void log(IAccount account, double amount);

    IAccount getAccount();

    double getAmount();

    Date getDate();
}
