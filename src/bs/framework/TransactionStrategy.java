package bs.framework;

public interface TransactionStrategy {
    void transact(IAccount account, double amount, TransferType type);
}
