import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsingAWT extends Frame implements ActionListener {
	Label p,r,t,si;
	TextField t1,t2,t3,t4;
	Button b1,b2,b3;


	UsingAWT() {
		p=new Label("Enter Principle Amount");
		r= new Label("Enter Rate");
		t=new Label("Enter Time");
		si=new Label("Simple Interest");

		t1=new TextField(15);
		t2=new TextField(15);
		t3=new TextField(15);
		t4=new TextField(15);

		b1=new Button("Calculate SI");
		b2=new Button("Reset");
		b3=new Button("Close");


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
		setTitle("Simple Interest Calculator");
		setLayout(new FlowLayout());
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		double p=0.0, r=0.0, t=0.0, si=0.0;
		try {
			p=Integer.parseInt(t1.getText());

		}
		catch(Exception s) {
			t1.setText("Invalid Input");

		}
		try {
			r=Integer.parseInt(t2.getText());

		}
		catch(Exception s) {
			t2.setText("Invalid Input");

		}
		try {
			t=Integer.parseInt(t3.getText());

		}
		catch(Exception s) {
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



	public static void main(String[] args) {
		UsingAWT awt=new UsingAWT();
		awt.setVisible(true);


	}

}
