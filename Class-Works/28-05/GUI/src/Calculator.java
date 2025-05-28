import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends Frame implements ActionListener
{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3,b4,b5,b6;
	
	Calculator()
	{
		l1 = new Label("Number1");
		l2 = new Label("Number2");
		l3 = new Label("Result");
	
		t1 = new TextField(15);
		t2 = new TextField(15);
		t3 = new TextField(15);
		
		b1 = new Button("Add");
		b2 = new Button("Sub");
		b3 = new Button("Multi");
		b4 = new Button("Div");
		b5 = new Button("Reset");
		b6 = new Button("Close");
				
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
	
		Calculator clc = new Calculator();
		clc.setVisible(true);
		
	}
}
