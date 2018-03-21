package bs.framework;

public class Message implements IMessage {

    @Override
    public void sendMessage(IAccount account) {
        System.out.println("A message has been sent to " + account.getCustomer().getName());
    }
}
