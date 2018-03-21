package bs.framework;

public class Message implements IMessage {

    @Override
    public void sendMessage(IAccount account) {
//        account.getCustomer().getEmail()
        System.out.println("The message ");
        // todo send message to the account owner
    }
}
