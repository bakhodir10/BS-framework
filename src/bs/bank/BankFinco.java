package bs.bank;

import bs.framework.Finco;

public class BankFinco extends Finco {
	public BankFinco(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new BankFinco("");
		new BankController();

	}
}
