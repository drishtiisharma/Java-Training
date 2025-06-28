package com.ips.pojo;

public class UserInfo {

	private String username;
	private String password;
	private String fname;
	private String lname;
	private String contact;
	private String role;
	private String dp;
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String username, String password, String fname, String lname, String contact,String role,String dp) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.contact = contact;
		this.role = role;
		this.dp =dp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", contact=" + contact + ", role=" + role + ", dp=" + dp + "]";
	}
	
	
	
		
}
