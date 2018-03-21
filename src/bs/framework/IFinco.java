package bs.framework;

public interface IFinco {

    void addInterest();

    void create(ICustomer customer, IAccount account);

    void deposit(IAccount account, double amount);

    void withdraw(IAccount account, double amount);

    String report();
}
