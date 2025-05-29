import java.awt.*;
import javax.swing.*;

class ScrollBarExample extends JFrame
{
	ScrollBarExample()
    {
        setLayout(new BorderLayout());


        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 20));


        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                jp.add(new JTextField(5));
            }
        }


        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;


        JScrollPane jsp = new JScrollPane(jp, v, h);


        add(jsp, BorderLayout.CENTER);
    }

    public static void main(String args[])
    {
    	ScrollBarExample spl = new ScrollBarExample();
        spl.setVisible(true);
        spl.setSize(400, 400);
        spl.setLocation(200, 200);
        spl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
