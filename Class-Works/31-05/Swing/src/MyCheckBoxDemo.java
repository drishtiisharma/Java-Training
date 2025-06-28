import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MyCheckBoxDemo extends JDialog implements ActionListener,ItemListener
{
	JLabel lbl;
	JCheckBox c1,c2,c3;
	JButton btn;
	JTextArea area;

	public MyCheckBoxDemo() 
	{
		setSize(570, 300);
		setTitle("Check Box Demo");
		setLayout(new FlowLayout());
		
		lbl = new JLabel("Select Area Of Iterest : ");
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
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		
		btn.addActionListener(this);
		
	}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		String s = "Area Of Interest : ";
		s = s+"\nSoftware = "+c1.isSelected();
		s = s+"\nHardware = "+c2.isSelected();
		s = s+"\nNetworing = "+c3.isSelected();
		area.setText(s);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn)
		{
//			setVisible(false);
//			dispose();
			System.exit(0);
		}
		
	}


	public static void main(String[] args) 
	{
		MyCheckBoxDemo cb = new MyCheckBoxDemo();
		cb.setVisible(true);

	}

}
