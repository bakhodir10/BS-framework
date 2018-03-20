package bs.framework;

import java.util.LinkedList;
import java.util.List;

public class Customer implements ICustomer {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private List<IAccount> accountList;

    public Customer() {
        this.accountList = new LinkedList<>();
    }
public Customer(String name, String street, String city, String state, String zip, String email) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.accountList = new LinkedList<>();
	}

	// Tania
	@Override
	public void addAccount(IAccount account) {
		account.setCustomer(this);
		this.accountList.add(account);
	}

	@Override
	public void removeAccount(IAccount account) {
		this.accountList.remove(account);
	}

	@Override
	public void sendEmailCustomer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
   
  
    @Override
    public List<IAccount> getAccount() {
        return this.accountList;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer)) return false;
        Customer c = (Customer) obj;
        return this.email.equals(c.getEmail());
    }

 
}
