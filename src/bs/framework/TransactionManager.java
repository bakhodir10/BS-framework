package bs.framework;

public class TransactionManager {
    private TransactionStrategy transactionStrategy;

    public TransactionManager(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    public void setTransactionStrategy(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    public TransactionStrategy getTransactionStrategy() {
        return transactionStrategy;
    }
}
