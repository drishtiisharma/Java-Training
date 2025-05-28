import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UsingSWING extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5,b6;
	
	

	public UsingSWING() {
		l1=new JLabel("1st Number");
		l2= new JLabel("2nd Number");
		l3=new JLabel("Result");
		
		t1=new JTextField(15);
		t2= new JTextField(15);
		t3=new JTextField(15);
		
		b1=new JButton("Add");
		b2= new JButton("Subtract");
		b3=new JButton("Multiply");
		b4=new JButton("Divide");
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
		
		setSize(250, 250);
		setTitle("Calulator made using SWING");
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
		UsingSWING sw=new UsingSWING();
		sw.setVisible(true);

	}

}
