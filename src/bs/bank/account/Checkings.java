package bs.bank.account;

import bs.framework.account.Account;
import bs.framework.customer.ICustomer;

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
    @Override
    public String getType() {
    		return "Ch";
    }
}
