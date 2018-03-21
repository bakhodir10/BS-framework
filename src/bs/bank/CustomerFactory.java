package bs.bank;

import java.util.Date;

import bs.framework.Customer;

public class CustomerFactory {
	
	static Customer getCompany(String clientName, String street, String city,  String state,  String zip,  String email, int numberOfEmployee) {
		return new Company(clientName, street, city, state, zip, email, numberOfEmployee);
	}
	
	static Customer getPerson(String name, String street, String city, String state, String zip, String email, Date bdate) {
		return new Person(name, street, city, state, zip, email, bdate);
	}
}
