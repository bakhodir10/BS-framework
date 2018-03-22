package bs.bank;

import bs.framework.Account;
import bs.framework.ICustomer;

public class AccountFactory {
	
	static Account getCheckings(String type, String accNum, ICustomer customer) {
		if(type.equals("S"))		
			return new Savings(accNum, customer);
		else if(type.equals("Ch"))
			return new Checkings(accNum, customer);
		return new Account(accNum, customer);
	}
}
