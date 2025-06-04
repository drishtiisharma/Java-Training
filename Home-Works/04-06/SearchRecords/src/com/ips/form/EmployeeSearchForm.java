package com.ips.form;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ips.dbs.DBService;
import com.ips.pojo.Employee;

public class EmployeeSearchForm extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;

	public EmployeeSearchForm() {
		l1=new JLabel("Employee ID			");
		l2=new JLabel("Employee Name			");
		l3=new JLabel("Employee Salary			");
		
		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		
		b1=new JButton("Search");
		b2=new JButton("Reset");
		b3=new JButton("Close");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		
		add(b1);
		add(b2);
		add(b3);
		
		setSize(330, 350);
		setTitle("Insert Records");
//		setLayout(new FlowLayout());
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15)); // (alignment, hgap, vgap)

		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Employee emp =new Employee();
		try {
			emp.setEmpid(Integer.parseInt(t1.getText()));
		}
		catch(NumberFormatException x) {
			t1.setText("Invalid input");
		}
		try {
			emp.setEmpname(t2.getText());
		}
		catch(NumberFormatException x) {
			t2.setText("");
		}
		try {
			emp.setSalary(Double.parseDouble(t3.getText()));
		}
		catch(NumberFormatException x) {
			t3.setText("");
		}
		
		DBService db=new DBService();
		if(e.getSource()==b1) {
			Employee em=db.SearchEmployee(emp);
			if(em!=null) {
				t1.setText(String.valueOf(em.getEmpid()));
				t2.setText(em.getEmpname());
				t3.setText(String.valueOf(em.getSalary()));
			}
			else {
				t2.setText("Record not found");
			}
		}
		if(e.getSource()==b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(e.getSource()==b3) {
			System.exit(0);
		}
		
		
	}


public static void main(String[] args) {
	EmployeeSearchForm eif= new EmployeeSearchForm();
	eif.setVisible(true);
	eif.setLocation(750, 400);
}


}
