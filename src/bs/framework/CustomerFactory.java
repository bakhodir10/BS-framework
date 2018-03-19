package bs.framework;

public class CustomerFactory {
    public static ICustomer getCustomer(CustomerType type) {
        switch (type) {
            case PERSON:
                return new Person();
            case COMPANY:
                return new Company();
            default:
                return null;
        }
    }
}
