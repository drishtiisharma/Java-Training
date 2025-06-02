
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


 class JRadioButtonDemo2 extends JFrame implements ItemListener,ActionListener
{
	JRadioButton c1,c2,c3;
	JTextArea result;
	JLabel lbl;
	
	JButton b1;
	ButtonGroup bg;
	JRadioButtonDemo2() {
		
		setTitle("SUPER SELECTOR");
		setSize(400,300);
		
		setLayout(new FlowLayout());
		
 	       

		bg = new ButtonGroup();	
        lbl = new JLabel("Select Category  : ");	
		c1=new JRadioButton("Software",true);
		c2=new JRadioButton("Hardware",false);
		c3=new JRadioButton("Networking",false);
	
	bg.add(c1);	
	bg.add(c2);
	bg.add(c3);
		result = new JTextArea(10,50);
		b1 = new JButton("    Close     ");
		
		add(lbl);
		add(c1);
		add(c2);
		add(c3);
		add(result);
		
		
		add(b1);
	
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
        b1.addActionListener(this);
	

	}

	public void itemStateChanged(ItemEvent ie) {
		
		
		String s = "Area of interest " ;
		if(c1.isSelected()==true)
		{
		s =s + "\nSoftware = " + c1.isSelected();
		}
		if(c2.isSelected()==true)
		{
		s =s + "\nHardware = " + c2.isSelected();
		}
		if(c3.isSelected()==true)
		{
		s =s + "\nNetworking = " + c3.isSelected();
		}
		
		result.setText(s);
		
						
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == b1) 
		{
			setVisible(false);
			dispose();

		}

	}

	public static void main(String args[])
	{
		JRadioButtonDemo2 dlg = new JRadioButtonDemo2();
		
		dlg.setVisible(true);
		dlg.setLocation(200,200);
	}

}
