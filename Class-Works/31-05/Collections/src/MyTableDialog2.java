
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MyTableDialog2 extends JDialog implements ActionListener
{
	
	JTable os;
	DefaultTableModel model;
	JLabel x,y,z;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	
	public MyTableDialog2() {
	
		super(new Frame(),"ListBox Demo");
		setSize(500,400);
		setLayout(new BorderLayout());
		
		
		
		Vector v = new Vector();
        v.addElement("Rollno");
        v.addElement("Student-Name");
        v.addElement("Per-Marks");
        
		model = new DefaultTableModel(new Vector(),v);
		
		 os = new JTable(model);
		
		x = new JLabel("Rollno");
		y = new JLabel("Name");
		z = new JLabel("Marks");
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
          b1 = new JButton("Add");
          b2 = new JButton("Remove");
          b3 = new JButton("Close");
          
          
          
    
	 
	 JPanel aPanel1=new JPanel();//new GridLayout(1,1));
     aPanel1.setBorder(BorderFactory.createTitledBorder("OS"));
     JScrollPane aScrollPane=new JScrollPane(os,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     aPanel1.add(aScrollPane);
     
    
   os.setPreferredScrollableViewportSize(new Dimension(300,200));
     JPanel aPanel2=new JPanel();//new GridLayout(1,1));
     aPanel2.setLayout(new BoxLayout(aPanel2,BoxLayout.X_AXIS));
     aPanel2.setBorder(BorderFactory.createTitledBorder("Opertions"));
     aPanel2.add(x);
     aPanel2.add(t1);
     aPanel2.add(y);
     aPanel2.add(t2);
     aPanel2.add(z);
     aPanel2.add(t3);
     aPanel2.add(b1);
     aPanel2.add(b2);
     aPanel2.add(b3);
     //aPanel1.add(b3);
    add(aPanel1,BorderLayout.CENTER);
	 add(aPanel2,BorderLayout.NORTH);
	 
	
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1)
		{
			Vector v = new Vector();
			v.addElement(t1.getText());
			v.addElement(t2.getText());
			v.addElement(t3.getText());
			model.addRow(v);
		}  	
		if(ae.getSource()==b2)
		{
		int x = os.getSelectedRow();
		System.out.println(x);
		model.removeRow(x);
		
		}
		
		
		if (ae.getSource() == b3) {
			setVisible(false);
			dispose();
			

		}
					
	}

	public static void main(String args[])
	{
		MyTableDialog2 dlg = new MyTableDialog2();
		
		dlg.setVisible(true);
		dlg.setLocation(200,200);
	}

}
