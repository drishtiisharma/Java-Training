
import java.awt.*;

import javax.swing.*;

class JScrollPanelDemo extends JFrame
{
	JScrollPanelDemo()
	{
	setLayout(new BorderLayout());
//setLayout(new BorderLayout(BorderLayout.NORTH));
	JPanel jp=new JPanel();
	jp.setLayout(new GridLayout(20,20));
	//jp.setLayout(new GridLayout(20,20,50,50));
	
	for(int i=0;i<20;i++)
	{
		for(int j=0;j<20;j++)
		{
			jp.add(new JTextField(15));
	
		}
	}
	
// 	int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; 
//	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	//System.out.println(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	
	JScrollPane jsp=new JScrollPane(jp,v,h);
//JScrollPane jsp=new JScrollPane(jp,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	add(jsp);
}
public static void main(String args[])
{
	JScrollPanelDemo spl=new JScrollPanelDemo();
	spl.setVisible(true);
	//spl.setLayout(new FlowLayout());
	spl.setSize(300,300);
	spl.setLocation(200,200);
}

} 
