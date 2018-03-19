package bs.framework;

public class TransactionManager {
    private TransactionType transactionType;

    public TransactionManager(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
