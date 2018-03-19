package bs.framework;

public interface IFinco {

    void addInterest(double amount);

    void createCustomer(ICustomer customer);

    void deposit(ICustomer customer, double amount);

    void withdraw(ICustomer customer, double amount);

    void accountReport(ICustomer customer);
}
