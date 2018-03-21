package bs.creditcard;

import bs.framework.Account;
import bs.framework.ICustomer;

public class AccountFactory {
	
	static Account getGold(String accNum, ICustomer customer, String ccNumber, String expireDate) {
		return new GoldCreditCard(accNum, customer, ccNumber, expireDate);
	}
	
	static Account getSilver(String accNum, ICustomer customer, String ccNumber, String expireDate) {
		return new SilverCreditCard(accNum, customer, ccNumber, expireDate);
	}
	static Account getBronze(String accNum, ICustomer customer, String ccNumber, String expireDate) {
		return new BronzeCreditCard(accNum, customer, ccNumber, expireDate);
	}
}
