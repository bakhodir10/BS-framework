package bs.framework;

public class Account implements IAccount {
    private int accNum;
    private double balance;
    private TransactionManager manager;

    public Account(int accNum) {
        this.accNum = accNum;
        this.manager = new TransactionManager(null);
    }

    @Override
    public void deposit(Transaction transaction) {
        manager.setTransactionType(new Deposit());
        manager.getTransactionType().transact(transaction);
    }

    @Override
    public void withdraw(Transaction transaction) {
        manager.setTransactionType(new Withdraw());
        manager.getTransactionType().transact(transaction);
    }

    @Override
    public void addInterest(double amount) {

    }
}
