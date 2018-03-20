package bs.framework;

import java.util.List;

public class History {
    private static History instance = new History();
    private List<Logging> histories;

    private History() {
    }

    public static History getInstance() {
        return instance;
    }

    public void save(Logging logging) {
        this.histories.add(logging);
    }
}
