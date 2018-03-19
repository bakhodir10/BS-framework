package bs.framework;

public interface IAccount {
    void deposit(ICustomer customer, double amount);

    void withdraw(ICustomer customer, double amount);

    void addInterest(double amount);
}
