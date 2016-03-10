package com.bank.action;

import java.text.ParseException;

import com.bank.dao.CardDao;


public class CardAction {

	CardDao carddao = new CardDao();
	
	public int CreatCard(String account, float money){
		int flag = 0;
		try {
			flag = carddao.CreatCard(account, money);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public int DelCard(int cardnumber){
		int flag = 0;
		flag = carddao.DelCard(cardnumber);
		return flag;
	}
	
	public float CheckMoney(int cardnumber,float money){
		float Inmoney = carddao.CheckMoney(cardnumber);
		if(Inmoney >= money)
			return 1;
		return 0;
	}
	
	public int GetMoney(int cardnumber, float money){
		int flag = 0;
		flag = carddao.getMoney(cardnumber, money);
		return flag;
	}
	
	public int InMoney(int cardnumber, float money){
		int flag = 0;
		flag = carddao.inMoney(cardnumber, money);
		return flag;
	}
	
	public int TurnMoney(int fromcardnumber, int tocardnumber , float money ){
		int flag = 0;
		flag = carddao.getMoney(fromcardnumber, money);
		if(flag == 1){
			flag = carddao.inMoney(tocardnumber, money);
		}
		return flag;
	}
	
	public void UpdateIsonuse(int cardnumber){
		carddao.CheckOnuse(cardnumber);
	}
	
}
