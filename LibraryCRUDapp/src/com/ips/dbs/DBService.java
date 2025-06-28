package com.ips.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

import com.ips.pojo.Book;
import com.mysql.cj.protocol.Resultset;

public class DBService {
	Connection con;

	public DBService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
		}
		catch(ClassNotFoundException e3) {
			System.err.println("ERROR IN LOADING CLASSES!");
		}
		catch(SQLException e4) {
			System.err.println("ERROR IN SQL QUERY!");
		}
	}

	// for issuing book
	public boolean issueBook(Book b) {
	    try {
	        // 🔹 Step 1: Check if the student already has this specific book
	        PreparedStatement dupCheck = con.prepareStatement(
	            "SELECT COUNT(*) FROM book WHERE studentid = ? AND bookid = ?"
	        );
	        dupCheck.setInt(1, b.getStudentid());
	        dupCheck.setString(2, b.getBookid());
	        ResultSet dupRs = dupCheck.executeQuery();
	        if (dupRs.next() && dupRs.getInt(1) > 0) {
	            JOptionPane.showMessageDialog(null, 
	                "❌ Issue failed. Student already has this book issued.");
	            return false;
	        }

	        // 🔹 Step 2: Check how many books this student already has
	        PreparedStatement countPs = con.prepareStatement(
	            "SELECT COUNT(*) FROM book WHERE studentid = ?"
	        );
	        countPs.setInt(1, b.getStudentid());
	        ResultSet countRs = countPs.executeQuery();
	        if (countRs.next()) {
	            int issuedCount = countRs.getInt(1);
	            if (issuedCount >= 3) {
	                JOptionPane.showMessageDialog(null,
	                    "❌ Issue failed. A student can only have up to 3 books issued.");
	                return false;
	            }
	        }

	        // 🔹 Step 3: Proceed with issuing
	        LocalDate issueDate = (b.getIssueDate() != null) ? b.getIssueDate() : LocalDate.now();

	        if (b.getSname() == null || b.getSname().trim().isEmpty()) {
	            System.err.println("❌ ERROR: Student name is missing.");
	            return false;
	        }

	        PreparedStatement ps1 = con.prepareStatement(
	            "INSERT INTO book(bookid, studentid, issuedate, fine) VALUES (?, ?, ?, ?)"
	        );
	        ps1.setString(1, b.getBookid());
	        ps1.setInt(2, b.getStudentid());
	        ps1.setDate(3, java.sql.Date.valueOf(issueDate));
	        ps1.setDouble(4, 0);
	        int x1 = ps1.executeUpdate();

	        // 🔹 Step 4: Add student to `student` table only if not exists
	        PreparedStatement checkStudent = con.prepareStatement(
	            "SELECT COUNT(*) FROM student WHERE studentid = ?"
	        );
	        checkStudent.setInt(1, b.getStudentid());
	        ResultSet rs = checkStudent.executeQuery();
	        boolean studentExists = rs.next() && rs.getInt(1) > 0;

	        int x2 = 0;
	        if (!studentExists) {
	            PreparedStatement ps2 = con.prepareStatement(
	                "INSERT INTO student(studentid, studentname) VALUES (?, ?)"
	            );
	            ps2.setInt(1, b.getStudentid());
	            ps2.setString(2, b.getSname());
	            x2 = ps2.executeUpdate();
	        } else {
	            x2 = 1;
	        }

	        return x1 > 0 && x2 > 0;

	    } catch (Exception ea) {
	        ea.printStackTrace();
	        return false;
	    }
	}




	//for reissuing book
	public boolean reIssueBook(Book b) {
	    try {
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT issuedate FROM book WHERE bookid = ? AND studentid = ?"
	        );
	        ps.setString(1, b.getBookid());
	        ps.setInt(2, b.getStudentid());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            java.sql.Date sqlDate = rs.getDate("issuedate");
	            if (sqlDate != null) {
	                LocalDate issueDate = sqlDate.toLocalDate();
	                LocalDate today = LocalDate.now();
	                long daysBetween = ChronoUnit.DAYS.between(issueDate, today);

	                if (daysBetween <= 30) {
	                    // Update issue date to today
	                    PreparedStatement updatePs = con.prepareStatement(
	                        "UPDATE book SET issuedate = ? WHERE bookid = ? AND studentid = ?"
	                    );
	                    updatePs.setDate(1, java.sql.Date.valueOf(today));
	                    updatePs.setString(2, b.getBookid());
	                    updatePs.setInt(3, b.getStudentid());

	                    int updated = updatePs.executeUpdate();
	                    return updated > 0;
	                } else {
	                    JOptionPane.showMessageDialog(null,
	                        "Re-issue not allowed. Book issued more than 30 days ago.\nPlease return it first.");
	                    return false;
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Book record not found.");
	        }
	    } catch (Exception e) {
	        System.err.println("❌ Error in reIssueBook: " + e);
	    }
	    return false;
	}


	//for returning book
	public boolean returnBook(Book b) {
		try {
			PreparedStatement ps=con.prepareStatement("delete from book where bookid=? AND studentid=?");
			ps.setString(1, b.getBookid());
			ps.setInt(2, b.getStudentid());
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ea) {
			System.err.println(ea);
			return false;
		}
	}


	//for searching record
	public boolean searchRecord(Book b) {
	    try {
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT book.bookid, book.studentid, book.issuedate, student.studentname FROM book JOIN student ON book.studentid = student.studentid WHERE book.bookid = ? AND book.studentid = ?"
	        );
	        ps.setString(1, b.getBookid());
	        ps.setInt(2, b.getStudentid());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            b.setBookid(rs.getString("bookid"));
	            b.setStudentid(rs.getInt("studentid"));
	            java.sql.Date sqlDate = rs.getDate("issuedate");
	            if (sqlDate != null) {
	                b.setIssueDate(sqlDate.toLocalDate());
	            }
	            b.setSname(rs.getString("studentname"));
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception ea) {
	        System.err.println("Error in searchRecord: " + ea);
	        return false;
	    }
	}


	//for calculating fine
	public boolean calFine(Book b) {
		try {
			PreparedStatement ps=con.prepareStatement("select DATEDIFF(CURRENT_DATE,issuedate) AS daysissued from book where bookid=? AND studentid=?");
			ps.setString(1, b.getBookid());
			ps.setInt(2, b.getStudentid());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int daysissued=rs.getInt("daysissued");

				if(daysissued>30) {
					int fine=(daysissued-30)*5;
					b.setFine(fine);
					return true;
				}
				else {
					b.setFine(0);
					return false;
				}
			}
			else {
				return false;
			}
		}
		catch(Exception ea) {
			System.err.println(ea);
			return false;
		}
	}


}
