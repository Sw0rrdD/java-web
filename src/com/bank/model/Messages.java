package com.bank.model;

import java.util.Date;



public class Messages {

	private int messageid;
	private int fromaccount;
	private int toaccount;
	private Date creattime;
	private Float money;
	private String messagetext;
	private int status;

	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public int getFromaccount() {
		return fromaccount;
	}

	public void setFromaccount(int fromaccount) {
		this.fromaccount = fromaccount;
	}

	public int getToaccount() {
		return toaccount;
	}

	public void setToaccount(int toaccount) {
		this.toaccount = toaccount;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}
}
