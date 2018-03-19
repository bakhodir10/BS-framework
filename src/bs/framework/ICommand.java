package bs.framework;

public interface ICommand {
    void execute(ICustomer customer, IAccount account, double amount);
}
