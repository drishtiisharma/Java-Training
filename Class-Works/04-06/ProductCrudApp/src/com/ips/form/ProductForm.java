package com.ips.form;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ips.dbs.DBService;
import com.ips.pojo.Product;

public class ProductForm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5,b6,b7;
	
	ProductForm()
	{
		l1 = new JLabel("Product-Id             ");
		l2 = new JLabel("Product-Name           ");
		l3 = new JLabel("Product-Price          ");
	
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		
		b1 = new JButton("Insert");
		b2 = new JButton("Update");
		b3 = new JButton("Delete");
		b4 = new JButton("Search");
		b5 = new JButton("Reset");
		b6 = new JButton("Close");
		b7 = new JButton("List Of All Product");
				
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
		add(b7);
		
		setSize(350, 350);
		setTitle("Product Form");
		setLayout(new FlowLayout());//center
		//setLayout(new FlowLayout(FlowLayout.LEFT));//center
		//setLayout(new FlowLayout(FlowLayout.RIGHT));//center
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Product p = new Product();
		try 
		{
			p.setpId(Integer.parseInt(t1.getText()));	
		}
		catch (NumberFormatException e2) 
		{
			t1.setText("Invalid Input");
		}
		p.setpName(t2.getText());
		try 
		{
			p.setPrice(Double.parseDouble(t3.getText()));	
		}
		catch (NumberFormatException e2) 
		{
			t3.setText("Invalid Input");
		}
		DBService db = new DBService();
		if(e.getSource()==b1)
		{
			if(db.addProduct(p))
			{
				t2.setText("Record Added");
			}
			else
			{
				t2.setText("Record Not Added");
			}
		}
		if(e.getSource()==b2)
		{
			if(db.updateProduct(p))
			{
				t2.setText("Record Updated");
			}
			else
			{
				t2.setText("Record Not Updated");
			}
		}
		if(e.getSource()==b3)
		{
			if(db.deleteProduct(p))
			{
				t2.setText("Record Deleted");
			}
			else
			{
				t2.setText("Record Not Deleted");
			}
		}
		if(e.getSource()==b4)
		{
			Product pd = db.searchProduct(p);
			if(pd!=null)
			{
				t1.setText(String.valueOf(pd.getpId()));
				t2.setText(pd.getpName());
				t3.setText(String.valueOf(pd.getPrice()));
			}
			else
			{
				t2.setText("Record Not Found");
			}
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
		if(e.getSource()==b7)
		{
			ListOfProduct lp = new ListOfProduct();
			lp.setVisible(true);
			lp.setLocation(300, 200);
		}
	}


	public static void main(String[] args) {
	
		ProductForm clc = new ProductForm();
		clc.setVisible(true);
		
	}
}
