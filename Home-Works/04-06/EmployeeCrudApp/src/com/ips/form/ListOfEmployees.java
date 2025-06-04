package com.ips.form;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.ips.dbs.DBService;
import com.ips.pojo.Employee;


public class ListOfEmployees extends JDialog
{
	
	JTable os;
	DefaultTableModel model;
	
	public ListOfEmployees() {
	
		super(new Frame(),"ListBox Demo");
		setSize(500,400);
		setLayout(new BorderLayout());
		
		
		
		Vector v = new Vector();
		v.addElement("S.No.");
        v.addElement("Employee-Id");
        v.addElement("Employee-Name");
        v.addElement("Employee-Salary");
        
		model = new DefaultTableModel(new Vector(),v);
		
		 os = new JTable(model);
		 
		 DBService db = new DBService();
		 ArrayList<Employee>lst = db.getAllEmployee();
		 
		 for(int i=0; i<lst.size(); i++)
		 {
			 Employee pd = lst.get(i);
			 Vector v1 = new Vector<>();
			 v1.addElement(i+1);
			 v1.addElement(pd.getEmpid());
			 v1.addElement(pd.getEmpname());
			 v1.addElement(pd.getSalary());
			 model.addRow(v1);
		 }
		 
		 
		 
	 JPanel aPanel1=new JPanel();//new GridLayout(1,1));
     aPanel1.setBorder(BorderFactory.createTitledBorder("Employee Records"));
     JScrollPane aScrollPane=new JScrollPane(os,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     aPanel1.add(aScrollPane);
     
    
   os.setPreferredScrollableViewportSize(new Dimension(400,300));
     
    add(aPanel1,BorderLayout.CENTER);
	 
	 
	}

}
