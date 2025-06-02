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

public class JMenuDemo extends JFrame implements ActionListener
{
	
	JMenuBar mbar;
	JMenu m1,m2;
	JMenuItem b1,b2,b3,b4,b5,b6;
	
	JMenuDemo()
	{
		
		mbar = new JMenuBar();
		setJMenuBar(mbar);
		
		m1 = new JMenu("Windows");
		m2 = new JMenu("Options");
		
		mbar.add(m1);
		mbar.add(m2);
		
		
		
		b1 = new JMenuItem("Calculator");
		b2 = new JMenuItem("JMenuCalculator");
		b3 = new JMenuItem("JRadioButtonDemo");
		b4 = new JMenuItem("JScrollPanelDemo");
		m1.add(b1);
		m1.add(b2);
		m1.add(b3);
		m1.add(b4);
		
		b5 = new JMenuItem("Reset");
		b6 = new JMenuItem("Close");
				
		m2.add(b5);
		m2.add(b6);
		m1.add(m2);
		
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
			Calculator cl = new Calculator();
			cl.setVisible(true);
		}
		if(e.getSource()==b2)
		{
			JMenuCalculator mclc = new JMenuCalculator();
			mclc.setVisible(true);
		}
		if(e.getSource()==b3)
		{
			JRadioButtonDemo rd = new JRadioButtonDemo();
			rd.setVisible(true);
		}
		if(e.getSource()==b4)
		{
			JScrollPanelDemo jsp = new JScrollPanelDemo();
			jsp.setVisible(true);
		}
		
		if(e.getSource()==b6)
		{
			System.exit(0);
		}
	}


	public static void main(String[] args) {
	
		JMenuDemo clc = new JMenuDemo();
		clc.setVisible(true);
		
	}
}
