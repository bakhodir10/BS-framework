package bs.creditcard;

import bs.framework.Account;
import bs.framework.ICustomer;

public class CreditCardAccount extends Account {
    private String ccNumber;

    private String expireDate;
    private double lastMonthBalance;

    public CreditCardAccount(String accNum, ICustomer customer, String ccNumber, String expireDate) {
        super(accNum, customer);
        this.ccNumber = ccNumber;
        this.expireDate = expireDate;
    }

    public double getLastMonthBalance() {
        return lastMonthBalance;
    }

    public double getTotalMonthlyCredits() {
        return 0;
    }

    public double getTotalMonthlyCharges() {

        return 0;
    }

    public double getNewMonthlyBalance() {
        return 0;
    }

    public double getMonthlyAmountDue() {
        return 0;
    }

    public String getCcNumber() {
        return ccNumber;
    }
}
