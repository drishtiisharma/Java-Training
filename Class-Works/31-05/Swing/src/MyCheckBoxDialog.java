import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MyCheckBoxDialog extends JDialog implements ActionListener,ItemListener
{
	JLabel lbl;
	JCheckBox c1,c2,c3;
	JTextArea area;
	JButton btn;
	public MyCheckBoxDialog() 
	{
		super(new Frame(),"Check BoxDemo");
		setSize(570,300);
		setLayout(new FlowLayout());
		
		lbl = new JLabel("Select Area Of Interest : ");
		c1 = new JCheckBox("Software");
		c2 = new JCheckBox("Hardware");
		c3 = new JCheckBox("Networking");
		
		area = new JTextArea(10,50);
		
		btn = new JButton("Close");
		
		add(lbl);
		add(c1);
		add(c2);
		add(c3);
		add(area);
		add(btn);
		
		btn.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		String s = "Area Of Interest : ";
		s = s+"\nSoftware = "+c1.isSelected();
		s = s+"\nHardware = "+c2.isSelected();
		s = s+"\nNetworking = "+c3.isSelected();
		area.setText(s);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		setVisible(false);
//		dispose();
		System.exit(0);
		
	}

	public static void main(String[] args) {
		MyCheckBoxDialog ch = new MyCheckBoxDialog();
		ch.setVisible(true);
		ch.setLocation(300, 300);

	}

}
