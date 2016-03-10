package com.bank.action;

import java.text.ParseException;

import com.bank.dao.MessagesDao;
import com.bank.model.Messages;

public class MessagesAction {

	MessagesDao messagesdao = new MessagesDao();
	
	public void AddGetMessage(int cardnumber, float money, int status){
		String messagetext="取款";
		Messages messages = new Messages();
		messages.setToaccount(cardnumber);
		messages.setFromaccount(cardnumber);
		messages.setMoney(money);
		messages.setMessagetext(messagetext);
		messages.setStatus(status);
		try {
			messagesdao.AddMessages(messages);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddTurnMessage(int fromcardnumber, int tocardnumber, float money, int status){
		String messagetext="转账";
		Messages messages = new Messages();
		messages.setToaccount(tocardnumber);
		messages.setFromaccount(fromcardnumber);
		messages.setMoney(money);
		messages.setMessagetext(messagetext);
		messages.setStatus(status);
		try {
			messagesdao.AddMessages(messages);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
