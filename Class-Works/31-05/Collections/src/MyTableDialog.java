
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MyTableDialog extends JDialog implements ActionListener
{
	
	JTable os;
	DefaultTableModel model;
	JLabel x,y;
	JTextField t1,t2;
	JButton b1,b2,b3;
	
	public MyTableDialog() {
	
		super(new Frame(),"ListBox Demo");
		setSize(500,400);
		setLayout(new BorderLayout());
		
		
		
		Vector v = new Vector();
        v.addElement("Operating System");
        v.addElement("Company");
        
		model = new DefaultTableModel(new Vector(),v);
		
		 os = new JTable(model);
		
		x = new JLabel("Operating System");
		y = new JLabel("Company");
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);
          b1 = new JButton("Add");
          b2 = new JButton("Remove");
          b3 = new JButton("Close");
          
          
          Vector v1 = new Vector();
          v1.addElement("Windows 2000");
          v1.addElement("Microsoft");
          
          Vector v2 = new Vector();
          v2.addElement("Windows XP");
          v2.addElement("Microsoft");
    
	 model.addRow(v1);
	 model.addRow(v2);
	 
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
		MyTableDialog dlg = new MyTableDialog();
		
		dlg.setVisible(true);
		dlg.setLocation(200,200);
	}

}
