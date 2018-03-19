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
}
