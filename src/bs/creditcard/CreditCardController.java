package bs.creditcard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bs.framework.Account;
import bs.framework.Customer;
import bs.framework.Finco;
import bs.framework.IAccount;
import bs.framework.ICustomer;

import bs.framework_ui.Forum;
import bs.framework_ui.JDialog_Custom;

public class CreditCardController {

	static Forum view;
	static CreditCardFinco finco;
	static JFrame frame;
	static List<String> cols;
	static javax.swing.JButton JButton_NewPerson;
	static javax.swing.JButton JButton_AddInterest;
	static javax.swing.JButton JButton_AccReport;
	static javax.swing.JButton JButton_Deposit;
	static javax.swing.JButton JButton_Withdraw;
	static Date now;

	public CreditCardController(CreditCardFinco f) {
		finco = f;
		view = new Forum("Credit Card Finco");
		initializeScrollPanel();
		view.setScrollPanel(cols);
		initializeButtons();
		view.setVisible(true);
	}

	void fillTable() {
		if (view.model.getRowCount() > 0)
			for (int i = view.model.getRowCount() - 1; i > -1; i--)
				view.model.removeRow(i);

		for (IAccount y : finco.getAccountList()) {
			view.rowdata[0] = ((Customer) y.getCustomer()).getName(); 
			view.rowdata[1] = ((CreditCardAccount) y).getCcNumber();
			view.rowdata[2] = ((Customer) y.getCustomer()).getCity();
			view.rowdata[3] = ((CreditCardAccount) y).getType();
			view.rowdata[4] = ((CreditCardAccount) y).getBalance();
			view.model.addRow(view.rowdata);
		}
	}

	

	void initializeScrollPanel() {
		cols = new ArrayList<String>();
		cols.add("Name");
		cols.add("CC Number");
		cols.add("Exp Date");
		cols.add("Type");
		cols.add("Balance");
	}

	void initializeButtons() {

		JButton_NewPerson = new javax.swing.JButton();
		JButton_AccReport = new javax.swing.JButton();
		JButton_Deposit = new javax.swing.JButton();
		JButton_Withdraw = new javax.swing.JButton();
		JButton_AddInterest = new javax.swing.JButton();


		JButton_NewPerson.setText("Add Credit Card Account");
		JButton_NewPerson.setBounds(10, 20, 200, 33);
		JButton_NewPerson.setActionCommand("jbutton");
		view.addButton(JButton_NewPerson);

		JButton_AddInterest.setBounds(360, 20, 100, 33);
		JButton_AddInterest.setText("Add interest");
		view.addButton(JButton_AddInterest);

		JButton_AccReport.setText("Report");
		JButton_AccReport.setActionCommand("jbutton");
		JButton_AccReport.setBounds(470, 20, 80, 33);
		view.addButton(JButton_AccReport);

		JButton_Deposit.setText("Deposit");
		JButton_Deposit.setBounds(468, 104, 96, 33);
		view.addButton(JButton_Deposit);

		JButton_Withdraw.setText("Charge");
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		view.addButton(JButton_Withdraw);

		JButton_NewPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog_Custom jd = new JDialog_Custom(view, "Add new");
				preparePersonAccount(jd);
				jd.setBounds(450, 20, 300, 380);
				jd.show();
				if (!view.newaccount)
					return;		
				ICustomer person = new Customer(view.clientName, view.street, view.city, view.state, view.zip, view.email);
				IAccount account = AccountFactory.createAccount(view.accountType, view.accountnr, person, view.ccnumber, view.expdate);
				finco.create(person, account);
				fillTable();
			}
		});

		JButton_Deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get selected name
				int selection = view.JTable1.getSelectionModel().getMinSelectionIndex();
				if (selection >= 0) {
					String accnr = (String) view.model.getValueAt(selection, 1);
					JDialog_Custom jd = new JDialog_Custom(view, "Deposit");
					prepareDepositWindow(jd, accnr);
					jd.setBounds(430, 15, 275, 140);
					jd.show();
					long deposit = Long.parseLong(view.amountDeposit);
					finco.deposit(getAccountByCCID(accnr), deposit);
					fillTable();
				}
			}
		});

		JButton_Withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = view.JTable1.getSelectionModel().getMinSelectionIndex();
				if (selection >= 0) {
					String accnr = (String) view.model.getValueAt(selection, 1);
					JDialog_Custom jd = new JDialog_Custom(view, "Withdraw");
					prepareWithdrawWindow(jd, accnr);
					jd.setBounds(430, 15, 275, 140);
					jd.show();
					double withDraw = Double.parseDouble(view.amountwithDraw);
					double currentamount = getAccountByCCID(accnr).getBalance();
					if (currentamount - withDraw < 0) {
						JOptionPane.showMessageDialog(JButton_Withdraw,
								" Account " + accnr + " : balance is negative: $"
										+ String.valueOf(currentamount - withDraw) + " !",
								"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
						return;
					}
					finco.withdraw(getAccountByCCID(accnr), withDraw);
					fillTable();
				}

			}
		});

		JButton_AccReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = view.JTable1.getSelectionModel().getMinSelectionIndex();
				if (selection >= 0) {
					String accnr = (String) view.model.getValueAt(selection, 1);
					IAccount acc = getAccountByCCID(accnr);
					JDialog_Custom jd = new JDialog_Custom(view, "Account Report");
					prepareAccReportWindow(jd, acc);
					jd.setBounds(450, 20, 400, 350);
					jd.show();	
				}
			}
		});

		JButton_AddInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JButton_AddInterest, "Add interest to all accounts",
						"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
				finco.addInterest();
				fillTable();
				// TODO update the view
			}
		});
		
	}

	void prepareAccReportWindow(JDialog_Custom c, IAccount acc) {
		c.setSize(405, 367);

		javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
		javax.swing.JTextField JTextField1 = new javax.swing.JTextField();
		javax.swing.JButton JButton_OK = new javax.swing.JButton();
		c.getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24, 24, 358, 240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0, 0, 355, 237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		c.getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156, 276, 96, 24);
		JButton_OK.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				Object object = event.getSource();
				if (object == JButton_OK)
					c.dispose();
			}
		});
		String billstring = finco.report((CreditCardAccount)acc);
		JTextField1.setText(billstring);
	}

	void prepareWithdrawWindow(JDialog_Custom c, String accnr) {
		c.setSize(277, 134);

		javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_AMT = new javax.swing.JTextField();
		javax.swing.JButton JButton_OK = new javax.swing.JButton();
		javax.swing.JButton JButton_Calcel = new javax.swing.JButton();

		JLabel1.setText("Acc Nr");
		c.getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		c.getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 36, 48, 24);
		JTextField_NAME.setEditable(false);
		c.getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 156, 20);
		c.getContentPane().add(JTextField_AMT);
		JTextField_AMT.setBounds(84, 36, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		c.getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 84, 84, 24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		c.getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156, 84, 84, 24);

		JTextField_NAME.setText(accnr);

		JButton_OK.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				view.amountwithDraw = JTextField_AMT.getText();
				c.dispose();
			}
		});
		JButton_Calcel.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				c.dispose();
			}
		});

	}

	void preparePersonAccount(JDialog_Custom c) {

		javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
		javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
		javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
		javax.swing.JLabel Label7 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
		javax.swing.JButton JButton_OK = new javax.swing.JButton();
		javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
		javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
		javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_Email = new javax.swing.JTextField();
		
		
		
		JRadioButton_Gold.setText("Gold");
		c.getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36,12,84,24);
		JRadioButton_Silver.setText("Silver");
		c.getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36,36,84,24);
		JRadioButton_Bronze.setText("Bronze");
		c.getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36,60,84,24);
		
		
		
		c.getContentPane().setLayout(null);
		c.setSize(301,373);
		c.setVisible(false);
		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Checkings");
		c.getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36,12,84,24);
		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Savings");
		c.getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36,36,84,24);
		JLabel1.setText("Name");
		c.getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,108,48,24);
		JLabel2.setText("Street");
		c.getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,132,48,24);
		JLabel3.setText("City");
		c.getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12,156,48,24);
		JLabel4.setText("State");
		c.getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12,180,48,24);
		JLabel5.setText("Zip");
		c.getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12,204,48,24);
		JLabel6.setText("CC number");
		c.getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,252,96,24);
		Label7.setText("Exp. Date");
		c.getContentPane().add(Label7);
		Label7.setForeground(java.awt.Color.black);
		Label7.setBounds(12,276,72,24);
		c.getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,108,156,20);
		c.getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84,156,156,20);
		c.getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84,180,156,20);
		c.getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84,132,156,20);
		c.getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84,204,156,20);
		c.getContentPane().add(JTextField_CCNR);
		JTextField_CCNR.setBounds(84,252,156,20);
		c.getContentPane().add(JTextField_ExpDate);
		JTextField_ExpDate.setBounds(84,276,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		c.getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,312,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		c.getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,312,84,24);
		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Savings");
		c.getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36,60,84,24);
		JLabel7.setText("Email");
		c.getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12,228,48,24);
		c.getContentPane().add(JTextField_Email);
		JTextField_Email.setBounds(84,228,156,20);
		
		JButton_OK.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				view.clientName=JTextField_NAME.getText();
				view.street=JTextField_STR.getText();
				view.city=JTextField_CT.getText();
				view.zip=JTextField_ZIP.getText();
				view.state=JTextField_ST.getText();
				view.ccnumber=JTextField_CCNR.getText();
				view.expdate=JTextField_ExpDate.getText();
			       if (JRadioButton_Gold.isSelected())
			    	   view.accountType="Gold";
			           else{
			            if (JRadioButton_Silver.isSelected())
			            	view.accountType="Silver";
			                else
			                	view.accountType="Bronze";
			           }
				
				view.newaccount = true;
				c.dispose();
			}
		});
		JButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				view.newaccount = false;
				c.dispose();
			}
		});

		JRadioButton_Gold.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
			JRadioButton_Gold.setSelected(true);
			JRadioButton_Silver.setSelected(false);
			JRadioButton_Bronze.setSelected(false);
		}
		});
		JRadioButton_Silver.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
			JRadioButton_Gold.setSelected(false);
			JRadioButton_Silver.setSelected(true);
			JRadioButton_Bronze.setSelected(false);
		 
		}});
		JRadioButton_Bronze.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
			JRadioButton_Gold.setSelected(false);
			JRadioButton_Silver.setSelected(false);
			JRadioButton_Bronze.setSelected(true);
				 
		}});
	}

	void prepareDepositWindow(JDialog_Custom c, String accnr) {
		c.setSize(268, 126);

		javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
		javax.swing.JButton JButton_OK = new javax.swing.JButton();
		javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
		javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();

		JLabel1.setText("Acc Nr");
		c.getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		c.getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		JTextField_NAME.setEditable(false);
		c.getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 144, 24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		c.getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		c.getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);
		c.getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84, 48, 144, 24);
		JTextField_NAME.setText(accnr);

		JButton_OK.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				view.amountDeposit = JTextField_Deposit.getText();
				c.dispose();
			}
		});
		JButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				c.dispose();
			}
		});

	}

	IAccount getAccountByCCID(String ccID) {
		for (ICustomer x : finco.getCustomerList()) {
			for (IAccount ac : ((Customer) x).getAccount())
				if (((CreditCardAccount) ac).getCcNumber().equals(ccID))
					return ac;
		}
		return null;
	}

	void prepareCompanyAccount(JDialog_Custom c) {
		c.setSize(298, 339);
		javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
		javax.swing.JButton JButton_OK = new javax.swing.JButton();
		javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
		javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();

		javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
		javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		c.getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 12, 84, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		c.getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 36, 84, 24);

		JLabel1.setText("Name");
		c.getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 96, 48, 24);
		JLabel2.setText("Street");
		c.getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 120, 48, 24);
		JLabel3.setText("City");
		c.getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 144, 48, 24);
		JLabel4.setText("State");
		c.getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 168, 48, 24);
		JLabel5.setText("Zip");
		c.getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 192, 48, 24);
		JLabel6.setText("No of employees");
		c.getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 216, 96, 24);
		JLabel7.setText("Email");
		c.getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 240, 48, 24);
		c.getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120, 96, 156, 20);
		c.getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120, 144, 156, 20);
		c.getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120, 168, 156, 20);
		c.getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120, 120, 156, 20);
		c.getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120, 192, 156, 20);
		c.getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120, 216, 156, 20);
		c.getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120, 240, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		c.getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 276, 84, 24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		c.getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156, 276, 84, 24);
		JLabel8.setText("Acc Nr");
		c.getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 72, 48, 24);
		c.getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120, 72, 156, 20);

		JButton_OK.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				view.accountnr = JTextField_ACNR.getText();
				view.clientName = JTextField_NAME.getText();
				view.street = JTextField_STR.getText();
				view.city = JTextField_CT.getText();
				view.zip = JTextField_ZIP.getText();
				view.state = JTextField_ST.getText();
				view.numberOfEmployee = Integer.parseInt(JTextField_NoOfEmp.getText());
				if (JRadioButton_Chk.isSelected())
					view.accountType = "Ch";
				else
					view.accountType = "S";
				view.newaccount = true;
				c.dispose();
			}
		});

		JButton_Calcel.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				view.newaccount = false;
				c.dispose();

			}
		});

		JRadioButton_Chk.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				// When Checking radio is clicked make this radio on
				// and make Saving account radio off
				JRadioButton_Chk.setSelected(true);
				JRadioButton_Sav.setSelected(false);
			}
		});
		JRadioButton_Sav.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {

				// When Saving radio is clicked make this radio on
				// and make Checking account radio off
				JRadioButton_Chk.setSelected(false);
				JRadioButton_Sav.setSelected(true);

			}
		});

	}

}
