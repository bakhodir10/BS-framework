package bs.creditcard;

import bs.framework.ICustomer;

public class SilverCreditCard extends CreditCardAccount {
	public static double mi = 0.08;
	public static double mp = 0.12;
	public SilverCreditCard(String accNum, ICustomer customer, String ccNumber, String expireDate) {
		super(accNum, customer, ccNumber, expireDate);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getNewMonthlyBalance() {
		return 0;
	}
	@Override
	public double getMonthlyAmountDue() {
		return 0;
	}
	@Override
	public void addInterest() {
		super.setBalance(super.getBalance()+super.getBalance()*mi);
	}
	@Override
	public String getType() {
		return "Silver";
	}
}
