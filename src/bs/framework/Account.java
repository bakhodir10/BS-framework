package bs.framework;

public class Account implements IAccount {
    private int accNum;
    private double balance;
    private TransactionManager manager;
    private ICustomer customer; // Tania

    public Account(int accNum) {
        this.accNum = accNum;
        this.manager = new TransactionManager(null);
    }

    @Override
    public void deposit(IAccount account, double amount) {
        manager.setTransactionStrategy(new Deposit());
        manager.getTransactionStrategy().transact(account, amount);
    }

    @Override
    public void withdraw(IAccount account, double amount) {
        manager.setTransactionStrategy(new Withdraw());
        manager.getTransactionStrategy().transact(account, amount);
    }

    @Override
    public void addInterest(double amount) {

    }

    public int getAccNum() {
        return accNum;
    }

    public double getBalance() {
        return balance;
    }

    public TransactionManager getManager() {
        return manager;
    }

    // Tania
    public ICustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }
}
