package bs.framework;

import java.util.*;

public class History {
    private static History instance = new History();
    private List<ILogging> histories;

    private History() {
        this.histories = new LinkedList<>();
    }

    public static History getInstance() {
        return instance;
    }

    public void save(ILogging logging) {
        this.histories.add(logging);
    }

    public List<ILogging> getHistories() {
        return this.histories;
    }

    public String getReport(List<ICustomer> customerList) {
        StringBuilder report = new StringBuilder("Customers' reports");
        report.append(System.getProperty("line.separator"));

        List<ILogging> loggings = History.getInstance().getHistories();
        Map<ICustomer, List<ILogging>> map = new HashMap<>();

        for (ICustomer customer : customerList) {
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
}
