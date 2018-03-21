package bs.framework_ui;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class Forum extends javax.swing.JFrame
{
 
    
    public DefaultTableModel model;
    public JTable JTable1;
    private JScrollPane JScrollPane1;
    public boolean newaccount;
    public String accountnr;
	public String clientName;
	public String street;
	public String email;
	public String city;
	public String zip;
	public String state;
	public String accountType;
	public String clientType;
	public int numberOfEmployee;
	public String amountDeposit;
	public String amountwithDraw;
	public SymAction lSymAction;
    Forum myframe;
    public Object rowdata[];
    static List<String> s = new ArrayList<String>();
    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	
    
	
	public Forum(String title)
	{
		initialzieForum(title);
		initializeStaticButtons();	
	}

	
	public void setScrollPanel(List<String> rows1)
	{
		s = rows1;
		initializeScrollPanel(rows1);
	}
	

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}
	

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Forum.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
		}
	}
    
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}
    
	public void addButton(JButton button) {
		JPanel1.add(button);
	}
	
	void initialzieForum(String title) {
		myframe = this;
		setTitle(title);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		newaccount=false;
		rowdata = new Object[s.size()+2];
	}
	
	
	void initializeScrollPanel(List<String> rows) {
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        for(String s : rows)
        		model.addColumn(s);
        
        rowdata = new Object[100];
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
	}
	
	
	void initializeStaticButtons() 
	{
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
	}
	
}
