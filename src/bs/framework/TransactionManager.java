package bs.framework;

import java.util.LinkedList;
import java.util.List;

public class TransactionManager implements IManager {
    private ICommand command;
    private List<ITransaction> transactionList;

    public TransactionManager(ICommand command) {
        this.command = command;
        this.transactionList = new LinkedList<>();
    }

    @Override
    public void submit(ICustomer customer, IAccount account, double amount) {
        this.command.execute(customer, account, amount);
    }
}
