package bs.framework;

import java.util.Date;

public interface ILogging {
    void log(IAccount account, double amount, TransferType type);

    IAccount getAccount();

    double getAmount();

    Date getDate();

    TransferType getType();
}
