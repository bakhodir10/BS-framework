package bs.framework;

public class CustomerFactory {
    public static ICustomer getCustomer(CustomerType type, String name, String street, String city, String state,
			String zip, String email, Date bDate) {
		switch (type) {
		case PERSON:
			return new Person(name, street, city, state, zip, email, bDate);
		case COMPANY:
			return new Company(name, street, city, state, zip, email);
		default:
			return null;
		}
	}
}
