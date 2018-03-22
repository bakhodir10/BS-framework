package bs.framework;

public class Withdraw implements TransactionStrategy {

    @Override
    public void transact(IAccount account, double amount,TransferType type) {
        account.setBalance(account.getBalance() - amount);
    }
}
