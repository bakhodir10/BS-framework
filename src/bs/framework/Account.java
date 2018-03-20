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
        manager.setTransactionStrategy(
                new ProxyTransaction(new Deposit(), new Logging(account, amount), new Message()));
        manager.getTransactionStrategy().transact(account, amount);
    }

    @Override
    public void withdraw(IAccount account, double amount) {
        manager.setTransactionStrategy(
                new ProxyTransaction(new Withdraw(), new Logging(account, amount), new Message()));
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

    @Override
    public String getEmail() {
        return this.customer.getEmail();
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

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
