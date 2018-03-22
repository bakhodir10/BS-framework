package bs.creditcard;

import bs.creditcard.account.CreditCardAccount;
import bs.creditcard.ui.CreditCardController;
import bs.framework.Finco;

public class CreditCardFinco extends Finco {

    public CreditCardFinco(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        new CreditCardController(new CreditCardFinco("Credit Card"));
    }

    public String report(CreditCardAccount cardAccount) {
        return cardAccount.report();
    }
}
