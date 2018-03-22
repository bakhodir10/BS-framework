package bs.bank.account;

import bs.framework.account.Account;
import bs.framework.customer.ICustomer;

public class AccountFactory {
	
	public static Account getCheckings(String type, String accNum, ICustomer customer) {
		if(type.equals("S"))		
			return new Savings(accNum, customer);
		else if(type.equals("Ch"))
			return new Checkings(accNum, customer);
		return new Account(accNum, customer);
	}
}
