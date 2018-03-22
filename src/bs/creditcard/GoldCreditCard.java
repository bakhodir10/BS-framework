package bs.creditcard;

import bs.framework.ICustomer;

public class GoldCreditCard extends CreditCardAccount{
	
	public static double mi = 0.06;
	public static double mp = 0.1;
	
	public GoldCreditCard(String accNum, ICustomer customer, String ccNumber, String expireDate) {
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
		return "Gold";
	}

}
