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

    @Override
    public void addAccount(IAccount account) {
        this.accountList.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        this.accountList.remove(account);
    }

    @Override
    public void sendEmailCustomer() {

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

    public String getEmail() {
        return email;
    }
}
