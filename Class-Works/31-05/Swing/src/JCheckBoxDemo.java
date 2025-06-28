import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JCheckBoxDemo extends JFrame implements ItemListener
{
  JTextField jtf;
  JCheckBoxDemo ()
  {
 	setTitle("JCheckBox Demo");
	setLayout(new FlowLayout());
	setSize(200,100);
	
	ImageIcon normal=new ImageIcon("COPY.GIF");
	ImageIcon roll=new ImageIcon("Cut.gif");
	ImageIcon selected=new ImageIcon("Paste.gif");
	
	JCheckBox cb=new JCheckBox("c",normal);
	cb.setRolloverIcon(roll);	
	cb.setSelectedIcon(selected);
	cb.addItemListener(this);
	add(cb);

	JCheckBox cb1=new JCheckBox("c++",normal);
	cb1.setRolloverIcon(roll);	
	cb1.setSelectedIcon(selected);
	cb1.addItemListener(this);
	add(cb1);
	
	JCheckBox cb2=new JCheckBox("java",normal);
	cb2.setRolloverIcon(roll);	
	cb2.setSelectedIcon(selected);
	cb2.addItemListener(this);
	add(cb2);
	
	JCheckBox cb3=new JCheckBox("Python",normal);
	cb3.setRolloverIcon(roll);	
	cb3.setSelectedIcon(selected);
	cb3.addItemListener(this);
	add(cb3);
	
	jtf=new JTextField(15);
	add(jtf);
	}

	public void itemStateChanged(ItemEvent ie)
	{
		JCheckBox aa=(JCheckBox)ie.getItem();
		
		jtf.setText(aa.getText());
		//setVisible(false);
		//dispose();
		
	}
	
	public static void main(String args[])
	{
	JCheckBoxDemo jcb= new JCheckBoxDemo();
	jcb.setVisible(true);
	jcb.setTitle("Check Box demo");
	jcb.setLocation(200,200);
	}

}	
	
		