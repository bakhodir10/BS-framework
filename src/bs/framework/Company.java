package bs.framework;

public class Company extends Customer {
	private int numOfEmployees;

	public Company() {
		super();

	}

	public Company(String name, String street, String city, String state, String zip, String email) {
		super(name, street, city, state, zip, email);
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}
}
