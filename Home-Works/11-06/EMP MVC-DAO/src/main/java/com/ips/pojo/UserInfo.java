package com.ips.pojo;

public class UserInfo {
	private int empid;
	private String empname;
	private String password;
	private double salary;
	private String designation;
	private String department;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(int empid, String empname, String password, double salary, String designation, String department) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.password = password;
		this.salary = salary;
		this.designation = designation;
		this.department = department;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
