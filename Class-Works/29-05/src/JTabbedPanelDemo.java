
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

class JTabbedPanel extends JFrame
{
	JTabbedPanel()
	{
	JTabbedPane jtp=new JTabbedPane();
	jtp.addTab("cities",new CitiesPanel());
	jtp.addTab("colors",new ColorsPanel());
	jtp.addTab("Flavors",new FlavorsPanel());
	add(jtp);
	}
}

class  JTabbedPanelDemo
{
public static void main(String args[])
{
	JTabbedPanel tpd=new JTabbedPanel();
	tpd.setVisible(true);
	tpd.setLayout(new FlowLayout());	
	tpd.setSize(400,300);
	tpd.setLocation(200,200);
}

}

class CitiesPanel extends JPanel 
{
	
	JButton b1,b2,b3,b4;
	public CitiesPanel()
	{
	b1=new JButton("New York");
	add(b1);
	b2=new JButton("London");
	add(b2);
	b3=new JButton("Hong Kong");
	add(b3);
	b4=new JButton("Bareli");
	add(b4);
	}
	
}

class ColorsPanel extends JPanel implements ItemListener
{
	public ColorsPanel()
	{
	JCheckBox cb1=new JCheckBox("Red");
	add(cb1);
	JCheckBox cb2=new JCheckBox("Green");
	add(cb2);
	JCheckBox cb3=new JCheckBox("Blue");
	add(cb3); 
	cb1.addItemListener(this);
	cb2.addItemListener(this);
	cb3.addItemListener(this);
	}
//JLabel l1 = new JLabel(new ImageIcon("Cut.gif"));	
	public void itemStateChanged(ItemEvent e) 
	{	
		JCheckBox c =(JCheckBox) e.getItem();
		String cc = c.getText();
		if(cc.equals("Red"))
		{
			setBackground(Color.red);
		}
		if(cc.equals("Green"))
		{
			setBackground(Color.green);
		}
		if(cc.equals("Blue"))
		{
			setBackground(Color.blue);
		}
		
	}
}

class FlavorsPanel extends JPanel implements ItemListener
{
	JLabel l1;
	JComboBox jcb;
	public FlavorsPanel()
	{
	jcb=new JComboBox();
	jcb.addItem("Vanilla");
  	jcb.addItem("Chocolate");
	jcb.addItem("strawberry");
	l1 = new JLabel(new ImageIcon());
	jcb.addItemListener(this);
	add(jcb);
	add(l1);
	}

	public void itemStateChanged(ItemEvent e) 
	{
		ImageIcon normal=new ImageIcon("download.jpg");
		ImageIcon roll=new ImageIcon("Cut.gif");
		ImageIcon selected=new ImageIcon("Paste.gif");
		String s = (String)jcb.getSelectedItem();
		if(s.equals("Vanilla"))
		{
			l1.setIcon(normal );
		}
		if(s.equals("Chocolate"))
		{
			l1.setIcon(roll );
		}
		if(s.equals("strawberry"))
		{
			l1.setIcon(selected );
			
		}
		
	}
}

	
	