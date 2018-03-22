package bs.bank.account;

import bs.framework.account.Account;
import bs.framework.customer.ICustomer;

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
    @Override
    public String getType() {
    		return "S";
    }
}
