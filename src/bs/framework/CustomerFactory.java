package bs.framework;

import java.util.Date;

public class CustomerFactory {
    public static ICustomer getCustomer(CustomerType type, String name,
                                        String street, String city, String state,
                                        String zip, String email, Date bDate, int numOfEmployees) {
        switch (type) {
            case PERSON:
                return new Person(name, street, city, state, zip, email, bDate);
            case COMPANY:
                return new Company(name, street, city, state, zip, email, numOfEmployees);
            default:
                return null;
        }
    }
}
