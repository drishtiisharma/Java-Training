package com.ips.form;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.ips.dbs.DBService;
import com.ips.pojo.Product;


public class ListOfProduct extends JDialog
{
	
	JTable os;
	DefaultTableModel model;
	
	public ListOfProduct() {
	
		super(new Frame(),"ListBox Demo");
		setSize(500,400);
		setLayout(new BorderLayout());
		
		
		
		Vector v = new Vector();
		v.addElement("S.N.");
        v.addElement("Product-Id");
        v.addElement("Product-Name");
        v.addElement("Product-Price");
        
		model = new DefaultTableModel(new Vector(),v);
		
		 os = new JTable(model);
		 
		 DBService db = new DBService();
		 ArrayList<Product>lst = db.getAllProduct();
		 
		 for(int i=0; i<lst.size(); i++)
		 {
			 Product pd = lst.get(i);
			 Vector v1 = new Vector<>();
			 v1.addElement(i+1);
			 v1.addElement(pd.getpId());
			 v1.addElement(pd.getpName());
			 v1.addElement(pd.getPrice());
			 model.addRow(v1);
		 }
		 
		 
		 
	 JPanel aPanel1=new JPanel();//new GridLayout(1,1));
     aPanel1.setBorder(BorderFactory.createTitledBorder("OS"));
     JScrollPane aScrollPane=new JScrollPane(os,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     aPanel1.add(aScrollPane);
     
    
   os.setPreferredScrollableViewportSize(new Dimension(400,300));
     
    add(aPanel1,BorderLayout.CENTER);
	 
	 
	}

}
