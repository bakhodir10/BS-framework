package bs.framework;

public class Deposit implements TransactionStrategy {

    @Override
    public void transact(IAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }
}