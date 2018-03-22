package bs.framework.storage;

import bs.framework.logging.ILogging;

import java.util.LinkedList;
import java.util.List;

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
}
