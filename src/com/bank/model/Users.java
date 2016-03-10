package com.bank.model;

import java.sql.Date;

public class Users {

	private String account;
	private String password;
	private String superpassword;
	private String realname;
	private Date lastlogintime;
	private int isonuse;
	private String email;
	private String phone;
	private String address;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuperpassword() {
		return superpassword;
	}

	public void setSuperpassword(String superpassword) {
		this.superpassword = superpassword;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public int getIsonuse() {
		return isonuse;
	}

	public void setIsonuse(int isonuse) {
		this.isonuse = isonuse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
