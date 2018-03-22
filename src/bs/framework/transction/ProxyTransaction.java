package bs.framework.transction;

import bs.framework.logging.ILogging;
import bs.framework.message.IMessage;
import bs.framework.account.IAccount;

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
    public void transact(IAccount account, double amount, TransferType type) {
        this.transactionStrategy.transact(account, amount, type);
        if (amount > 500 || account.getBalance() < 0) this.message.sendMessage(account);
        this.logging.log(account, amount, type);
    }
}