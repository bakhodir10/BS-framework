package bs.framework.transction;

import bs.framework.account.IAccount;

public interface TransactionStrategy {
    void transact(IAccount account, double amount, TransferType type);
}
