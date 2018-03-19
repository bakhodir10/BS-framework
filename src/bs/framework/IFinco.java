package bs.framework;

public interface IFinco {

    void addInterest(double amount);

    void createCustomer(Customer customer);

    void deposit(Customer customer, double amount);

    void withdraw(Customer customer, double amount);

    void accountReport(Customer customer);
}
