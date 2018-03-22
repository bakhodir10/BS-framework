package bs.framework;

public class Account implements IAccount {
    private String accNum;
    private double balance;
    private TransactionManager manager;
    private ICustomer customer; // Tania

    public Account(String accNum, ICustomer customer) {
        this.accNum = accNum;
        this.customer = customer;
        this.manager = new TransactionManager(null);
    }

    @Override
    public void deposit(IAccount account, double amount) {
        manager.setTransactionStrategy(
                new ProxyTransaction(new Deposit(), new Logging(account, amount, TransferType.DEPOSIT),
                        new Message()));
        manager.getTransactionStrategy().transact(account, amount, TransferType.DEPOSIT);
    }

    @Override
    public void withdraw(IAccount account, double amount) {
        manager.setTransactionStrategy(
                new ProxyTransaction(new Withdraw(), new Logging(account, amount, TransferType.WITHDRAW),
                        new Message()));
        manager.getTransactionStrategy().transact(account, amount, TransferType.WITHDRAW);
    }

    @Override
    public void addInterest() {
        setBalance(balance + balance * 0.01);
    }

    public String getAccNum() {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "DEFAULT";
    }


}
