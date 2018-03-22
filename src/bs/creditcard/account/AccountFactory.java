package bs.creditcard.account;

import bs.framework.account.Account;
import bs.framework.customer.ICustomer;

public class AccountFactory {
	
	public static Account createAccount(String Type, String accNum, ICustomer customer, String ccNumber, String expireDate) {
		if(Type.equals("Gold"))
			return new GoldCreditCard(accNum, customer, ccNumber, expireDate);
		else if(Type.equals("Silver"))
			return new SilverCreditCard(accNum, customer, ccNumber, expireDate);
		else if(Type.equals("Bronze")) 
			return new BronzeCreditCard(accNum, customer, ccNumber, expireDate);
		return new CreditCardAccount(accNum, customer, ccNumber, expireDate);
	}
}
