package bs.framework.ui;
import bs.framework.ui.Forum;

import javax.swing.*;



public class JDialog_Custom extends javax.swing.JDialog
{
	public Forum parentframe;
	
	
	public JDialog_Custom(Forum parent, String title)
	{
		this.parentframe = parent;
		setTitle(title);
		setModal(true);
		getContentPane().setLayout(null);
		setSize(300,800);		
		setVisible(false);
	}
	public void addLabel(JLabel label) {
		this.getContentPane().add(label);
	}
	public void addTextField(JTextField textField) {
		this.getContentPane().add(textField);
	}
	public void addButton(JButton button) {
		this.getContentPane().add(button);
	}
	public void addRadioButton(JRadioButton jButton) {
		this.getContentPane().add(jButton);
	}
	public void addScrollPanel(JScrollPane scroll) {
		this.getContentPane().add(scroll);
	}
	
}
