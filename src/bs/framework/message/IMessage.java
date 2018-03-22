package bs.framework.message;

import bs.framework.account.IAccount;

public interface IMessage {
    void sendMessage(IAccount account);
}
