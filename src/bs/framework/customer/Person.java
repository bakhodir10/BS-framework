package bs.framework.customer;

import bs.framework.customer.Customer;

import java.util.Date;

public class Person extends Customer {
    private Date bDate;

    public Person(String name, String street, String city, String state,
                  String zip, String email, Date bDate) {
        super(name, street, city, state, zip, email);
        this.bDate = bDate;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }
    @Override
    public String getType() {
    		return "P";
    }

}