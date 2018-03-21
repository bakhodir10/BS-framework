package bs.bank;

import bs.framework.Account;

public class Savings extends Account {
    private final double interestRate = 0.0325;

    public Savings(String accNum) {
        super(accNum);
    }

    @Override
    public void addInterest() {
        double balance = this.getBalance();
        this.setBalance(balance + balance * interestRate);
    }
}
