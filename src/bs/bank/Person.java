package bs.bank;

import java.util.Date;

import bs.framework.Customer;

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
