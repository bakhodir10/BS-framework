package bs.bank;

import bs.framework.Account;
import bs.framework.ICustomer;

public class Checkings extends Account {
    private final double interestRate = 0.01;

    public Checkings(String accNum, ICustomer customer) {
        super(accNum, customer);
    }

    @Override
    public void addInterest() {
        double balance = this.getBalance();
        this.setBalance(balance + interestRate * balance);
    }
}
