package bs.bank;

import bs.framework.Account;
import bs.framework.ICustomer;

public class AccountFactory {
	
	static Account getCheckings(String accNum, ICustomer customer) {
		return new Checkings(accNum, customer);
	}
	
	static Account getSavings(String accNum, ICustomer customer) {
		return new Savings(accNum, customer);
	}
}
