package bs.framework.customer;

import bs.framework.account.IAccount;

import java.util.List;

public interface ICustomer {
	
    void addAccount(IAccount account);
    void removeAccount(IAccount account);
    void sendEmailCustomer();
    List<IAccount> getAccount();
    String getEmail();
    String getType();
    
}
