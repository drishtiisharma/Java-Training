
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

class CitiesPanel extends JPanel implements ActionListener
{
	JLabel l1;
	JButton b1, b2, b3,b4;

	public CitiesPanel()
	{
		b1 = new JButton("New York");
		b2 = new JButton("London");
		b3 = new JButton("Hong Kong");
		b4 = new JButton("Bareli");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		l1 = new JLabel(new ImageIcon());

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(l1);
	}

	public void actionPerformed(ActionEvent e) 
	{
		ImageIcon ny= new ImageIcon("newyork.jpg");
		ImageIcon ln=new ImageIcon("london.png");
		ImageIcon hk= new ImageIcon("hongkong.png");
		ImageIcon br= new ImageIcon("bareli.gif");

		String s = e.getActionCommand();

		if(s.equals("New York"))
		{
			l1.setIcon(ny);
		}
		if(s.equals("London"))
		{
			l1.setIcon(ln);
		}
		if(s.equals("Hong Kong"))
		{
			l1.setIcon(hk);
		}
		if(s.equals("Bareli"))
		{
			l1.setIcon(br);
		}
	}
}






class ColorsPanel extends JPanel implements ItemListener {
	JRadioButton rb1, rb2, rb3,rb4;
	ButtonGroup bg;

	public ColorsPanel() {
		rb1 = new JRadioButton("Red");
		rb2 = new JRadioButton("Green");
		rb3 = new JRadioButton("Blue");
		rb4 = new JRadioButton("None");


		bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);


		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);


		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		rb4.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JRadioButton selected = (JRadioButton) e.getItem();

			switch (selected.getText()) {
			case "Red":
				setBackground(Color.RED);
				break;
			case "Green":
				setBackground(Color.GREEN);
				break;
			case "Blue":
				setBackground(Color.BLUE);
				break;
			case "None":
				setBackground(null);
				break;
			}
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
		jcb.addItem("----");
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
		ImageIcon van=new ImageIcon("vanilla.gif");
		ImageIcon choco=new ImageIcon("chocolate.gif");
		ImageIcon straw=new ImageIcon("strawberry.gif");
		String s = (String)jcb.getSelectedItem();
		if(s.equals("----"))
		{
			l1.setIcon(null);
		}
		if(s.equals("Vanilla"))
		{
			l1.setIcon(van );
		}
		if(s.equals("Chocolate"))
		{
			l1.setIcon(choco );
		}
		if(s.equals("strawberry"))
		{
			l1.setIcon(straw );

		}

	}
}


