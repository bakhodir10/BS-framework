package bs.framework.logging;

import bs.framework.account.IAccount;
import bs.framework.transction.TransferType;

import java.util.Date;

public interface ILogging {
    void log(IAccount account, double amount, TransferType type);

    IAccount getAccount();

    double getAmount();

    Date getDate();

    TransferType getType();
}
