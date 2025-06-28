import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxExample extends JDialog implements ItemListener, ActionListener {
    
    JComboBox<String> fruits, colors;
    JTextArea result;
    JButton b1, b2;

    public ComboBoxExample() {
        super(new Frame(), "ComboBox Demo");
        setSize(500, 300);
        setLayout(new FlowLayout());

        fruits = new JComboBox<>();
        colors = new JComboBox<>();
        result = new JTextArea(5, 20);  
        result.setEditable(false);       
        b1 = new JButton("Reset");
        b2 = new JButton("Close");

        fruits.addItem("Apple");
        fruits.addItem("Banana");
        fruits.addItem("Mango");
        fruits.addItem("Orange");
        fruits.addItem("Grapes");

        colors.addItem("Red");
        colors.addItem("Green");
        colors.addItem("Yellow");
        colors.addItem("Blue");
        colors.addItem("Purple");

        add(fruits);
        add(colors);
        add(new JScrollPane(result));  
        add(b1);
        add(b2);

        fruits.addItemListener(this);
        colors.addItemListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            String x = (String) fruits.getSelectedItem();
            String y = (String) colors.getSelectedItem();

            String z = "Selected Fruit = " + x + "\nSelected Color = " + y;
            result.setText(z);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            result.setText("");
            fruits.setSelectedIndex(0);
            colors.setSelectedIndex(0);
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            dispose();
        }
    }

    public static void main(String args[]) {
        ComboBoxExample dlg = new ComboBoxExample();
        dlg.setVisible(true);
        dlg.setLocation(200, 200);
    }
}
