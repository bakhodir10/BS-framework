package bs.framework;

public interface IAccount {
    void deposit(IAccount account, double amount);

    void withdraw(IAccount account, double amount);

    void addInterest(double amount);
}
