import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CalculatorUsingRadioButtons extends JFrame implements ItemListener, ActionListener {
	ButtonGroup bg;
	JLabel l1,l2,l3;
	JRadioButton b1,b2,b3,b4;
	JTextField t1,t2,t3;
	JButton b5,b6;
	

	public CalculatorUsingRadioButtons() {
		l1=new JLabel("1st Number");
		l2= new JLabel("2nd Number");
		l3=new JLabel("Result");
		
		t1=new JTextField(5);
		t2= new JTextField(5);
		t3=new JTextField(5);
		t3.setEditable(false);
		
		b1=new JRadioButton("add");
		b2=new JRadioButton("subtract");
		b3=new JRadioButton("multiply");
		b4=new JRadioButton("divide");
		
		bg=new ButtonGroup();
		
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		
		
		b5= new JButton("Reset");
		b6=new JButton("Close");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		add(b5);
		add(b6);
		
		setSize(400, 400);
		setTitle("Calulator made using Radio Buttons");
		setLayout(new FlowLayout());

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);

	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		int a=0, b=0, c=0;
		try {
			a=Integer.parseInt(t1.getText());
		}
		catch(Exception y) {
			t2.setText(t2.getText());
		}
		try {
			b=Integer.parseInt(t2.getText());
		}
		catch(Exception x) {
			t2.setText(t2.getText());
		}
			
		
		if(e.getSource()==b1) {
			c=a+b;
			t3.setText(String.valueOf(c));
		}
		if(e.getSource()==b2) {
			c=a-b;
			t3.setText(String.valueOf(c));
		}
		
		if(e.getSource()==b3) {
			c=a*b;
			t3.setText(String.valueOf(c));
		}
		
		if(e.getSource()==b4) {
			c=a/b;
			t3.setText(String.valueOf(c));
		}
		
		if(e.getSource()==b5) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		
		if(e.getSource()==b6) {
			System.exit(0);
		}
		
	}
	


	public static void main(String[] args) {
		CalculatorUsingRadioButtons sw=new CalculatorUsingRadioButtons();
		sw.setVisible(true);
		sw.setLocation(800, 200);

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
