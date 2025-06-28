
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class JRadioButtonDemo extends JFrame implements ItemListener
{
  ButtonGroup bg;
  JTextField jtf;
  JRadioButtonDemo ()
  {
 	setTitle("JRadioButton");
	setLayout(new FlowLayout());

	setSize(200,100);
	
	bg= new ButtonGroup();
	ImageIcon normal=new ImageIcon("download.jpg");
	ImageIcon roll=new ImageIcon("Cut.gif");
	ImageIcon selected=new ImageIcon("Paste.gif");
	
	JRadioButton cb=new JRadioButton("c",normal);
	cb.setRolloverIcon(roll);	
	cb.setSelectedIcon(selected);
	cb.addItemListener(this);
	add(cb);
	
	JRadioButton cb1=new JRadioButton("c++",normal);
	cb1.setRolloverIcon(roll);	
	cb1.setSelectedIcon(selected);
	cb1.addItemListener(this);
	add(cb1);
	
	JRadioButton cb2=new JRadioButton("java",normal);
	cb2.setRolloverIcon(roll);	
	cb2.setSelectedIcon(selected);
	cb2.addItemListener(this);
	add(cb2);
	
	JRadioButton cb3=new JRadioButton("perl",normal);
	cb3.setRolloverIcon(roll);	
	cb3.setSelectedIcon(selected);
	cb3.addItemListener(this);
	add(cb3);
	bg.add(cb);
	bg.add(cb1);
	bg.add(cb2);
	bg.add(cb3);
	jtf=new JTextField(15);
	add(jtf);
	}

	public void itemStateChanged(ItemEvent ie)
	{
		JRadioButton aa=(JRadioButton)ie.getItem();
		
		jtf.setText(aa.getText());
		
	}
	public static void main(String args[])
	{
	JRadioButtonDemo jcb= new JRadioButtonDemo();
	jcb.setVisible(true);
	jcb.setTitle("Check Box demo");
	jcb.setLocation(200,200);
	}

}	
	
		