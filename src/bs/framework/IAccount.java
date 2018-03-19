package bs.framework;

public interface IAccount {
    void deposit(Transaction transaction);

    void withdraw(Transaction transaction);

    void addInterest(double amount);
}
