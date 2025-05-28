import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UsingSWING extends JFrame implements ActionListener{
	JLabel p,r,t,si;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;
	
	UsingSWING(){
		p=new JLabel("Enter Principle Amount");
		r=new JLabel("Enter Rate");
		t=new JLabel("Enter Time");
		si=new JLabel("Simple Interest");
		
		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		t4=new JTextField(15);
		
		b1=new JButton("Calculate SI");
		b2=new JButton("Reset");
		b3=new JButton("Close");
		
		add(p);
		add(t1);
		add(r);
		add(t2);
		add(t);
		add(t3);
		
		add(b1);
		add(b2);
		add(b3);
		
		add(si);
		add(t4);
		
		setSize(250, 250);
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
			p=Integer.parseInt(t1.getText());
		}
		catch(Exception i) {
			t1.setText("Invalid Input");
		}
		
		try {
			r=Integer.parseInt(t2.getText());
		}
		catch(Exception i) {
			t2.setText("Invalid Input");
		}
		
		try {
			t=Integer.parseInt(t3.getText());
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
		}
		
		if(e.getSource()==b3) {
			dispose();
		}
		
	
	}



	public static void main(String[] args) {
		UsingSWING sw=new UsingSWING();
		sw.setVisible(true);

	}

}
