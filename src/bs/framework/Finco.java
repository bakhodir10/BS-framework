package bs.framework;

import java.util.List;

public class Finco implements IFinco {
    private String name;
    private List<ICustomer> customerList;

    @Override
    public void addInterest(double amount) {

    }

    @Override
    public void createCustomer(ICustomer customer) {
        this.customerList.add(customer);
    }

    @Override
    public void deposit(ICustomer customer, double amount) {
    }

    @Override
    public void withdraw(ICustomer customer, double amount) {

    }

    @Override
    public void accountReport(ICustomer customer) {

    }
}
