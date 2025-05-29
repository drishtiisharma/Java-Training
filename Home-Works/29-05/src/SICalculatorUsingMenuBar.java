import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SICalculatorUsingMenuBar extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JMenuBar mbar;
    JMenu m1, m2;
    JMenuItem b1, b5, b6;

    double p = 0.0, r = 0.0, t = 0.0, si = 0.0;

    public SICalculatorUsingMenuBar()
    {
        l1 = new JLabel("Enter Principal Amount");
        l2 = new JLabel("Enter Rate");
        l3 = new JLabel("Enter Time");
        l4 = new JLabel("Result (SI)");

        t1 = new JTextField(5);
        t2 = new JTextField(5);
        t3 = new JTextField(5);
        t4 = new JTextField(10);
        t4.setEditable(false);

        mbar = new JMenuBar();
        setJMenuBar(mbar);

        m1 = new JMenu("Operations");
        m2 = new JMenu("Options");

        mbar.add(m1);
        mbar.add(m2);

        b1 = new JMenuItem("Calculate SI");
        b5 = new JMenuItem("Reset");
        b6 = new JMenuItem("Close");

        m1.add(b1);
        m2.add(b5);
        m2.add(b6);

        setLayout(new FlowLayout());

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);

        setSize(250, 300);
        setTitle("SI Calculator");

        b1.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            try {
                p = Double.parseDouble(t1.getText());
                r = Double.parseDouble(t2.getText());
                t = Double.parseDouble(t3.getText());
                si = (p * r * t) / 100;
                t4.setText(String.valueOf(si));
            }
            catch(NumberFormatException ex) {
                t4.setText("Invalid Input!");
            }
        }
        if(e.getSource() == b5)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        if(e.getSource() == b6)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        SICalculatorUsingMenuBar calc = new SICalculatorUsingMenuBar();
        calc.setVisible(true);
        
    }
}
