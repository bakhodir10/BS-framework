package bs.creditcard;

import java.util.Date;

import bs.framework.Account;
import bs.framework.ICustomer;

public class CreditCardAccount extends Account{
	private String ccNumber;
	
	private String expireDate;
	private double lastMonthBalance;
	
	public CreditCardAccount(String accNum, ICustomer customer, String ccNumber, String expireDate) {
		super(accNum, customer);
		this.ccNumber = ccNumber;
		this.expireDate = expireDate;
		// TODO Auto-generated constructor stub
	}
	public double getCurrentBalance() {
		return super.getBalance();
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
	public void notifyCardHolder() {
		
	}
	public String getCcNumber() {
		return ccNumber;
	}
}
