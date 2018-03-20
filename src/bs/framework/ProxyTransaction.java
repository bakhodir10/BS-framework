package bs.framework;

public class ProxyTransaction implements TransactionStrategy {
    private TransactionStrategy transactionStrategy;
    private ILogging logging;
    private IMessage message;

    public ProxyTransaction(TransactionStrategy transactionStrategy, ILogging logging,
                            IMessage message) {
        this.transactionStrategy = transactionStrategy;
        this.logging = logging;
        this.message = message;
    }

    @Override
    public void transact(IAccount account, double amount) {
        this.transactionStrategy.transact(account, amount);
        this.logging.log(account, amount);
        this.message.sendMessage(account);
    }
}