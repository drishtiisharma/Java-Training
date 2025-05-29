
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyComboBoxDialog extends JDialog implements ItemListener,ActionListener
{	
	JComboBox os,browser;
	JTextArea result;
	JButton b1;
	public MyComboBoxDialog() {
	
		super(new Frame(),"ComboBox Demo");
		setSize(500,300);
		
		setLayout(new FlowLayout());
	
	
		os = new JComboBox();
		browser = new JComboBox();
		result = new JTextArea(10,50);
		b1 = new JButton("Close");
		
		os.addItem("Windows 98");
		os.addItem("Windows 2000");
		os.addItem("Windows XP");
		os.addItem("Windows NT");
		os.addItem("Linux");
		os.addItem("Solaris");
		
		browser.addItem("Internet Explorer");
		browser.addItem("Netscape Navigator");
		browser.addItem("Mozila Firefox");
		browser.addItem("Safari");
		browser.addItem("Lynx");
		
		add(os);
		add(browser);
		add(result);
		add(b1);
		os.addItemListener(this);
		browser.addItemListener(this);
		b1.addActionListener(this);
		

	}

	public void itemStateChanged(ItemEvent ie) {
		
		
		
		String x = (String)os.getSelectedItem();
		
		
		String y = (String)browser.getSelectedItem();
		
		String z = "Selected os = " + x ;
		 z = z +  "\nSelected browser = " + y;
		
		
		result.setText(z);
					
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			setVisible(false);
			dispose();

		}
		
	}
	public static void main(String args[])
	{
		MyComboBoxDialog dlg = new MyComboBoxDialog();
		
		dlg.setVisible(true);
		dlg.setLocation(200,200);
	}

}
