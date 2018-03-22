package bs.framework;

public class Deposit implements TransactionStrategy {

    @Override
    public void transact(IAccount account, double amount, TransferType type) {
        account.setBalance(account.getBalance() + amount);
    }
}