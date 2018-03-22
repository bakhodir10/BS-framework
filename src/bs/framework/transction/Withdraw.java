package bs.framework.transction;

import bs.framework.account.IAccount;

public class Withdraw implements TransactionStrategy {

    @Override
    public void transact(IAccount account, double amount, TransferType type) {
        account.setBalance(account.getBalance() - amount);
    }
}
