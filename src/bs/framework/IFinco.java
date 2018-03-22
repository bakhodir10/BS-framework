package bs.framework;

import bs.framework.account.IAccount;
import bs.framework.customer.ICustomer;

public interface IFinco {

    void addInterest();

    void create(ICustomer customer, IAccount account);

    void deposit(IAccount account, double amount);

    void withdraw(IAccount account, double amount);

    String report();
}
