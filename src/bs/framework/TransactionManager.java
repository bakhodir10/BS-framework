package bs.framework;

public class TransactionManager {
    private Strategy strategy;

    public TransactionManager(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
