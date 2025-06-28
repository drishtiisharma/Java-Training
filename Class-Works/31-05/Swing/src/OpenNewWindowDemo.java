import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OpenNewWindowDemo extends JFrame implements ActionListener
{
	
	JButton b1,b2,b3,b4,b5,b6;
	
	OpenNewWindowDemo()
	{
		
		b1 = new JButton("CheckBoxDemo");
		b2 = new JButton("RadioButtonDemo");
		b3 = new JButton("ConboBoxDemo");
		b4 = new JButton("Div");
		b5 = new JButton("Reset");
		b6 = new JButton("Close");
				
				
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		setSize(220, 250);
		setTitle("Calculator");
		setLayout(new FlowLayout());//center
		//setLayout(new FlowLayout(FlowLayout.LEFT));//center
		//setLayout(new FlowLayout(FlowLayout.RIGHT));//center
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource()==b1)
		{
			MyCheckBoxDemo cb = new MyCheckBoxDemo();
			cb.setVisible(true);
			
		}
		if(e.getSource()==b2)
		{
		}
		if(e.getSource()==b3)
		{
		}
		if(e.getSource()==b4)
		{
		}
		if(e.getSource()==b5)
		{
			
		}
		if(e.getSource()==b6)
		{
			System.exit(0);
		}
	}


	public static void main(String[] args) {
	
		OpenNewWindowDemo clc = new OpenNewWindowDemo();
		clc.setVisible(true);
		
	}
}
