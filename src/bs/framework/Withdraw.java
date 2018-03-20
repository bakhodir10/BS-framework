package bs.framework;

public class Withdraw implements TransactionStrategy {

    @Override
    public void transact(IAccount account, double amount) {
        TransactionStrategy strategy = new ProxyTransaction(this,
                new Logging(account, amount),
                new Message());
        strategy.transact(account, amount);
    }
}
