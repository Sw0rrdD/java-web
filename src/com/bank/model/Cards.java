package com.bank.model;

import java.util.Date;



public class Cards {

	private int cardnumber;
	private float money;
	private String belongid;
	private Date creattime;
	private int isonuse;

	public int getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getBelongid() {
		return belongid;
	}

	public void setBelongid(String belongid) {
		this.belongid = belongid;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public int getIsonuse() {
		return isonuse;
	}

	public void setIsonuse(int isonuse) {
		this.isonuse = isonuse;
	}
}
