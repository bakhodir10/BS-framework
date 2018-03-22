package bs.framework.customer;

import java.util.Date;

public class CustomerFactory {
	public static Customer createCustomer(String type, String name, String street, String city, String state,
            String zip, String email, Date bDate, int numOfEmployees) {
		if(type.equals("P"))
			return new Person(name,  street,  city,  state, zip, email, bDate);
		else if(type.equals("C"))
			return new Company( name,  street,  city, state,  zip,  email, numOfEmployees);
		return new Customer( name,  street,  city,  state,  zip,  email);
	}
}
