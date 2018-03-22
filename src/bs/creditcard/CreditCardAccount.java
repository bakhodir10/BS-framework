package bs.creditcard;

import bs.framework.Account;
import bs.framework.ICustomer;

import java.util.Date;

public class CreditCardAccount extends Account {
    private String ccNumber;

    private String expireDate;

    public CreditCardAccount(String accNum, ICustomer customer, String ccNumber, String expireDate) {
        super(accNum, customer);
        this.ccNumber = ccNumber;
        this.expireDate = expireDate;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public double getCurrentBalance() {
        return this.getBalance();
    }

    public double getLastMonthBalance() {
        return 0d;
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
}
