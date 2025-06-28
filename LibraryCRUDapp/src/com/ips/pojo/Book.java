package com.ips.pojo;

import java.time.LocalDate;

public class Book {
	private String Bookid;
	private int Studentid;
	private LocalDate issueDate;
	private double Fine;
	private String sname;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookid, int studentid, LocalDate issueDate, double fine, String sname) {
		super();
		Bookid = bookid;
		Studentid = studentid;
		this.issueDate = issueDate;
		Fine = fine;
		this.sname = sname;
	}
	public String getBookid() {
		return Bookid;
	}
	public void setBookid(String bookid) {
		Bookid = bookid;
	}
	public int getStudentid() {
		return Studentid;
	}
	public void setStudentid(int studentid) {
		Studentid = studentid;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public double getFine() {
		return Fine;
	}
	public void setFine(double fine) {
		Fine = fine;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	

}
