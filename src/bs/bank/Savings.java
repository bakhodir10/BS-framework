package bs.bank;

import bs.framework.Account;
import bs.framework.ICustomer;

public class Savings extends Account {
    private final double interestRate = 0.0325;

    public Savings(String accNum, ICustomer customer) {
        super(accNum, customer);
    }

    @Override
    public void addInterest() {
        double balance = this.getBalance();
        this.setBalance(balance + balance * interestRate);
    }
}
