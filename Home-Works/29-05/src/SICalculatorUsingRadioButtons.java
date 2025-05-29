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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SICalculatorUsingRadioButtons extends JFrame implements ActionListener, ItemListener{
	ButtonGroup bg;
	JLabel p,r,t,si;
	JTextField t1,t2,t3,t4;
	JRadioButton b1,b2,b3;
	
	SICalculatorUsingRadioButtons(){
		p=new JLabel("Enter Principle Amount");
		r=new JLabel("Enter Rate");
		t=new JLabel("Enter Time");
		si=new JLabel("Simple Interest");
		
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		t4=new JTextField(5);
		t4.setEditable(false);
		
		b1=new JRadioButton("Calculate SI");
		b2=new JRadioButton("Reset");
		b3=new JRadioButton("Close");
		
		bg=new ButtonGroup();
		
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		
		add(p);
		add(t1);
		add(r);
		add(t2);
		add(t);
		add(t3);
		
		add(si);
		add(t4);
		
		add(b1);
		add(b2);
		add(b3);
				
		
		
		setSize(400, 400);
		setTitle("Simple Interest using SWING");
		setLayout(new FlowLayout()); //for center alignment
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		double p=0.0,r=0.0,t=0.0,si=0.0;
		try {
			p=Double.parseDouble(t1.getText());
		}
		catch(Exception i) {
			t1.setText("Invalid Input");
		}
		
		try {
			r=Double.parseDouble(t2.getText());
		}
		catch(Exception i) {
			t2.setText("Invalid Input");
		}
		
		try {
			t=Double.parseDouble(t3.getText());
		}
		catch(Exception i) {
			t3.setText("Invalid Input");
		}
		
		if(e.getSource()==b1) {
			si=(p*r*t)/100;
			t4.setText(String.valueOf(si));
		}
		
		if(e.getSource()==b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}
		
		if(e.getSource()==b3) {
			dispose();
		}
		
	
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		SICalculatorUsingRadioButtons sw=new SICalculatorUsingRadioButtons();
		sw.setVisible(true);
		sw.setLocation(700, 300);
		

	}
}
