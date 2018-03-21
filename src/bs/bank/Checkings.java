package bs.bank;

import bs.framework.Account;

public class Checkings extends Account {
    private final double interestRate = 0.01;

    public Checkings(String accNum) {
        super(accNum);
    }

    @Override
    public void addInterest() {
        double balance = this.getBalance();
        this.setBalance(balance + interestRate * balance);
    }
}
