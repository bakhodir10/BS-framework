package bs.framework;

import bs.framework_ui.Forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finco implements IFinco {
    private String name;
    private List<ICustomer> customerList;
    private List<IAccount> accountList;

    public Finco(String name) {
        this.name = name;
        this.customerList = new ArrayList<>();
        this.accountList = new ArrayList<>();
    }

    @Override
    public void addInterest() {
        this.accountList.forEach(IAccount::addInterest);
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
    public String report() {
        StringBuilder report = new StringBuilder("Customers' reports");
        report.append(System.getProperty("line.separator"));

        List<ILogging> loggings = History.getInstance().getHistories();
        Map<ICustomer, List<ILogging>> map = new HashMap<>();

        for (ICustomer customer : this.customerList) {
            List<ILogging> logForACus = new ArrayList<>();
            for (ILogging logging : loggings) {
                if (logging.getAccount().getCustomer().getEmail().equals(customer.getEmail()))
                    logForACus.add(logging);
            }
            map.put(customer, logForACus);

            for (Map.Entry<ICustomer, List<ILogging>> m : map.entrySet()) {
                report.append("Name: ").append(m.getKey().getName());
                report.append(System.getProperty("line.separator"));
                List<ILogging> list = m.getValue();
                for (ILogging l : list) {
                    report.append("Amount: ").append(l.getAmount())
                            .append(", ").append(l.getDate());
                }
            }
        }
        return report.toString();
    }

    static List<String> s = new ArrayList<>();

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

    public List<ICustomer> getCustomerList() {
		return customerList;
	}

	public List<IAccount> getAccountList() {
		return accountList;
	}

}
