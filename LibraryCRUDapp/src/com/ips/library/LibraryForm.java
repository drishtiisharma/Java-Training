package com.ips.library;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

import com.ips.dbs.DBService;
import com.ips.pojo.Book;

public class LibraryForm extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4, b5, b6;

    public LibraryForm() {
        setLayout(new FlowLayout());

        l1 = new JLabel("Book-Id");
        l2 = new JLabel("Student-Id");
        l3 = new JLabel("Student Name");
        l4 = new JLabel("Issue Date (yyyy-mm-dd)");
        l5 = new JLabel("Fine to be paid");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);

        b1 = new JButton("Issue Book");
        b2 = new JButton("Re-Issue Book");
        b3 = new JButton("Return Book");
        b4 = new JButton("Search Record");
        b5 = new JButton("Calculate Fine");
        b6 = new JButton("Clear");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        t5.setEditable(false); // Fine is calculated, not user input

        setSize(300, 550);
		setTitle("Library Management");
		setLayout(new FlowLayout((FlowLayout.CENTER),30,15));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(750, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBService db = new DBService();

        try {
            String bookId = t1.getText().trim();
            String studentIdStr = t2.getText().trim();
            String studentName = t3.getText().trim();
            String issueDateStr = t4.getText().trim();

            if (bookId.isEmpty() || studentIdStr.isEmpty() || studentName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Book ID, Student ID, and Student Name are mandatory!");
                return;
            }

            int studentId = Integer.parseInt(studentIdStr);

            Book b = new Book();
            b.setBookid(bookId);
            b.setStudentid(studentId);
            b.setSname(studentName);

            // issueDate is optional - if empty, current date used in DBService
            if (!issueDateStr.isEmpty()) {
                b.setIssueDate(java.time.LocalDate.parse(issueDateStr));
            }

            if (e.getSource() == b1) {
                boolean issued = db.issueBook(b);
                JOptionPane.showMessageDialog(this, issued ? "Book issued successfully" : "Failed to issue book");
            } 
            else if (e.getSource() == b2) {
                boolean reissued = db.reIssueBook(b);
                JOptionPane.showMessageDialog(this, reissued ? "Book re-issued successfully" : "Failed to re-issue book");
            } 
            else if (e.getSource() == b3) {
                boolean returned = db.returnBook(b);
                JOptionPane.showMessageDialog(this, returned ? "Book returned successfully" : "Failed to return book");
            } 
            
            
            
            
            if (e.getSource() == b4) {  // assuming b4 is Search Record button
                b.setBookid(t1.getText().trim());
                try {
                    b.setStudentid(Integer.parseInt(t2.getText().trim()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Enter valid Student ID");
                    return;
                }

                boolean found = db.searchRecord(b);

                if (found) {
               
                    // Print details on console separately
                    System.out.println("bookid: " + b.getBookid());
                    System.out.println("studentid: " + b.getStudentid());
                    System.out.println("studentname: " + b.getSname());
                    System.out.println("issuedate: " + b.getIssueDate());

                    // Calculate fine and print it
                    if (db.calFine(b)) {
                        System.out.println("fine applicable: " + b.getFine());
                    } else {
                        System.out.println("fine applicable: 0");
                    }

                    // Optional: also fill text fields in UI
                    t3.setText(b.getSname());
                    t4.setText(b.getIssueDate() != null ? b.getIssueDate().toString() : "");
                    t5.setText(String.valueOf(b.getFine()));

                    JOptionPane.showMessageDialog(this, "Record found and displayed in console.");
                } else {
                    JOptionPane.showMessageDialog(this, "Record not found!");
                }
            }

            else if (e.getSource() == b5) {
                boolean fineCalculated = db.calFine(b);
                if (fineCalculated) {
                    t5.setText(String.valueOf(b.getFine()));
                } else {
                    t5.setText("0");
                    JOptionPane.showMessageDialog(this, "No fine to pay");
                }
            } 
            else if (e.getSource() == b6) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Student ID must be a number");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LibraryForm();
    }
}
