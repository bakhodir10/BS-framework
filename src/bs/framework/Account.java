package bs.framework;


public class Account implements IAccount {
    private int accNum;
    private double balance;
    private IManager manager;
    private ICustomer customer;

    public Account(int accNum, IManager manager, ICustomer customer) {
        this.accNum = accNum;
        this.manager = manager;
        this.customer = customer;
    }

    @Override
    public void deposit(ICustomer customer, double amount) {
        this.manager.submit(customer, this, amount);
    }

    @Override
    public void withdraw(ICustomer customer, double amount) {
        this.manager.submit(customer, this, amount);
    }

    @Override
    public void addInterest(double amount) {

    }
}
