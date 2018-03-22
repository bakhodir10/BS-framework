package bs.creditcard;

import bs.framework.Finco;

public class CreditCardFinco extends Finco {
	public CreditCardFinco(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new CreditCardController(new CreditCardFinco("Bank"));
	}
}
