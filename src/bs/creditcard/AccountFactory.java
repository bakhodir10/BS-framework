package bs.creditcard;

import bs.framework.Account;
import bs.framework.ICustomer;

public class AccountFactory {
	
	static Account createAccount(String Type, String accNum, ICustomer customer, String ccNumber, String expireDate) {
		if(Type.equals("Gold"))
			return new GoldCreditCard(accNum, customer, ccNumber, expireDate);
		else if(Type.equals("Silver"))
			return new SilverCreditCard(accNum, customer, ccNumber, expireDate);
		else if(Type.equals("Bronze")) 
			return new BronzeCreditCard(accNum, customer, ccNumber, expireDate);
		return new CreditCardAccount(accNum, customer, ccNumber, expireDate);
	}
}
