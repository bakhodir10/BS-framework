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
        manager.setStrategy(new Deposit());
        manager.getStrategy().execute(transaction);
    }

    @Override
    public void withdraw(Transaction transaction) {
        manager.setStrategy(new Withdraw());
        manager.getStrategy().execute(transaction);
    }

    @Override
    public void addInterest(double amount) {

    }
}
