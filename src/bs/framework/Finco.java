package bs.framework;

import bs.framework_ui.Forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Finco implements IFinco {
    private String name;
    private List<ICustomer> customerList;
    private List<IAccount> accountList;

    public Finco(String name) {
        this.name = name;
        this.customerList = new LinkedList<>();
        this.accountList = new LinkedList<>();
    }

    @Override
    public void addInterest() {
        this.accountList.forEach(e -> e.addInterest());
    }

    @Override
    public void create(ICustomer customer, IAccount account) {
        this.accountList.add(account);
        this.customerList.add(customer);
    }

    @Override
    public void deposit(IAccount account, double amount) {
        account.deposit(account, amount);
    }

    @Override
    public void withdraw(IAccount account, double amount) {
        account.withdraw(account, amount);
    }

    @Override
    public String accountReport() {
        String report = "Sample report\n";
        for (IAccount acc : accountList)
            report += acc.getBalance() + "\n";
        return report;
    }


    static List<String> s = new ArrayList<String>();

    public static void main(String[] args) {
        s.add("name");
        s.add("accNum");
        s.add("street");

        Forum base = new Forum("FrameWork Test");
        base.setScrollPanel(s);
        base.setVisible(true);
    }

    public String getName() {
        return name;
    }
}
