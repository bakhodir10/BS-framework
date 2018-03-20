package bs.framework;

import java.util.LinkedList;
import java.util.List;

public class Finco implements IFinco {
    private String name;
    private List<ICustomer> customerList;
    private List<IAccount> accountList;

    public Finco() {
        this.customerList = new LinkedList<>();
        this.accountList = new LinkedList<>();
    }

    @Override
    public void addInterest(double amount) {

    }

    @Override
    public void create(ICustomer customer, IAccount account) {
        this.accountList.add(account);
        this.customerList.add(customer);
    }

    @Override
    public void deposit(IAccount account, double amount) {
        account.deposit(account, amount);
    }

    @Override
    public void withdraw(IAccount account, double amount) {
    }

    @Override
    public void accountReport() {

    }
}
