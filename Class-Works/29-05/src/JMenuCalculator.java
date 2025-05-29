import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class JMenuCalculator extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JMenuBar mbar;
	JMenu m1,m2;
	JMenuItem b1,b2,b3,b4,b5,b6;
	
	JMenuCalculator()
	{
		l1 = new JLabel("Number1");
		l2 = new JLabel("Number2");
		l3 = new JLabel("Result");
	
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		
		mbar = new JMenuBar();
		setJMenuBar(mbar);
		
		m1 = new JMenu("Operations");
		m2 = new JMenu("Options");
		
		mbar.add(m1);
		mbar.add(m2);
		
		
		
		b1 = new JMenuItem("Add");
		b2 = new JMenuItem("Sub");
		b3 = new JMenuItem("Multi");
		b4 = new JMenuItem("Div");
		m1.add(b1);
		m1.add(b2);
		m1.add(b3);
		m1.add(b4);
		
		b5 = new JMenuItem("Reset");
		b6 = new JMenuItem("Close");
				
		m2.add(b5);
		m2.add(b6);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		
		
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
		System.out.println("Hello Students...!");
		int a=0,b=0,c=0;
		try 
		{
			a = Integer.parseInt(t1.getText());	
		}
		catch (NumberFormatException e2) 
		{
			t1.setText("Invalid Input");
		}
		
		try 
		{
			b = Integer.parseInt(t2.getText());	
		}
		catch (NumberFormatException e2) 
		{
			t2.setText("Invalid Input");
		}
		
		if(e.getSource()==b1)
		{
			c = a+b;
			t3.setText(String.valueOf(c));
		}
		if(e.getSource()==b2)
		{
			c = a-b;
			t3.setText(String.valueOf(c));
		}
		if(e.getSource()==b3)
		{
			c = a*b;
			t3.setText(String.valueOf(c));
		}
		if(e.getSource()==b4)
		{
			c = a/b;
			t3.setText(String.valueOf(c));
		}
		if(e.getSource()==b5)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(e.getSource()==b6)
		{
			System.exit(0);
		}
	}


	public static void main(String[] args) {
	
		JMenuCalculator clc = new JMenuCalculator();
		clc.setVisible(true);
		
	}
}
