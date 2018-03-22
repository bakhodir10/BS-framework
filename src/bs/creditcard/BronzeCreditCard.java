package bs.creditcard;

import bs.framework.ICustomer;

public class BronzeCreditCard extends CreditCardAccount {
	public static double mi = 0.1;
	public static double mp = 0.14;

	public BronzeCreditCard(String accNum, ICustomer customer, String ccNumber, String expireDate) {
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
		return "Bronze";
	}
}
