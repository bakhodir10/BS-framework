package bs.framework.account;

import bs.framework.customer.ICustomer;

public interface IAccount {
    void deposit(IAccount account, double amount);

    void withdraw(IAccount account, double amount);

    void addInterest();

    void setCustomer(ICustomer customer); // Tania

    void setBalance(double balance);

    double getBalance();

    ICustomer getCustomer();
    
    String getType();

    String getAccNum();
}
