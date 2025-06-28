import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyListBoxDialog extends JDialog implements ActionListener
{
	JList os,os1;
	DefaultListModel model;
	JTextField t1;
	JButton b1,b2,b3;
	
	public MyListBoxDialog() {
	
		super(new Frame(),"ListBox Demo");
		setSize(400,320);
		setLayout(new FlowLayout());
		
		model = new DefaultListModel();
		os = new JList(model);
		os1 = new JList(model);
		
		
		t1 = new JTextField(10);
          b1 = new JButton("Add");
          b2 = new JButton("Remove");
          b3 = new JButton("Close");
          
	 model.addElement("Windows 2000");
	 model.addElement("Windows XP");
	 model.addElement("Linux");
	 
	 JPanel aPanel1=new JPanel();//new GridLayout(1,1));
     aPanel1.setBorder(BorderFactory.createTitledBorder("OS"));//createTitledBorder("OS"));
     JScrollPane aScrollPane=new JScrollPane(os,
    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     aPanel1.add(aScrollPane);
    
     aScrollPane.setPreferredSize(new Dimension(150,150));
		
	add(aPanel1);
	add(t1);
	 add(b1);
	add(b2);
	 add(b3);
	 add(os1);
		
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent ae) {
		
		
		
		if(ae.getSource()==b1)
		{
			if(t1.getText()!=null || t1.getText().length()!=0)
           model.addElement(t1.getText());
		}  	
		if(ae.getSource()==b2)
		{
		String x = (String)os.getSelectedValue();
		System.out.println(x);
		model.removeElement(x);
		
		}
		
		
		if (ae.getSource() == b3) {
			setVisible(false);
			dispose();

		}
					
	}

	
	
	public static void main(String args[])
	{
		MyListBoxDialog dlg = new MyListBoxDialog();
		
		dlg.setVisible(true);
		dlg.setLocation(200,200);
	}

}
