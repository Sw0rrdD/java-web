package com.bank.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.bank.model.Messages;
import com.bank.util.DateUtil;
import com.bank.util.SqlHelper;

public class MessagesDao {

	SqlHelper sqlhelper = new SqlHelper();
	
	public int AddMessages(Messages messages) throws ParseException{
		String sql = "INSERT INTO t_messages(fromaccount,toaccount,creattime,money,messagetext,status) VALUES(?,?,?,?,?,?)";
		String fromaccount = String.valueOf(messages.getFromaccount());
		String toaccount = String.valueOf(messages.getToaccount());
		String creattime = DateUtil.formatDate(new Date());
		String money = String.valueOf(messages.getMoney());
		String messagetext = messages.getMessagetext();
		String status = String.valueOf(messages.getStatus());
		String[] parameters = { fromaccount, toaccount, creattime, money, messagetext, status  };
		return sqlhelper.executeUpdate(sql, parameters);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Messages> ShowAllFromMessages(String account) {
		String sql = "SELECT * FROM t_messages WHERE fromaccount = any(SELECT cardnumber FROM t_cards WHERE belongid = ?) AND messagetext = ?";
		String messagetext = "转账";
		String[] parameters = { account, messagetext };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		int index = ls.size();
		ArrayList<Messages> list = new ArrayList();
		for(int i = 0 ; i < index ; i++){
			Object[] result = ls.get(i);
			Messages messages = new Messages();
			messages.setMessageid(Integer.parseInt(result[0].toString()));
			messages.setFromaccount(Integer.parseInt(result[1].toString()));
			messages.setToaccount(Integer.parseInt(result[2].toString()));
			try {
				messages.setCreattime(DateUtil.parse(String.valueOf(result[3])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			messages.setMoney(Float.parseFloat(String.valueOf(result[4])));
			messages.setMessagetext(result[5].toString());
			messages.setStatus(Integer.parseInt(result[6].toString()));
			list.add(messages);
		}
		if(list.size() > 0)
			System.out.println("Dao:" + list.get(0).getMessageid()+ " " + list.get(0).getFromaccount()+ " " + list.get(0).getToaccount() + " " + list.get(0).getCreattime()+ " " + list.get(0).getMoney() + " " + list.get(0).getMessagetext() + " " + list.get(0).getStatus());
		else
			System.out.println("Dao:没有数据");
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Messages> ShowAllToMessages(String account) {
		String sql = "SELECT * FROM t_messages WHERE toaccount = any(SELECT cardnumber FROM t_cards WHERE belongid = ?) AND messagetext = ?";
		String messagetext = "转账";
		String[] parameters = { account, messagetext };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		int index = ls.size();
		ArrayList<Messages> list = new ArrayList();
		for(int i = 0 ; i < index ; i++){
			Object[] result = ls.get(i);
			Messages messages = new Messages();
			messages.setMessageid(Integer.parseInt(result[0].toString()));
			messages.setFromaccount(Integer.parseInt(result[1].toString()));
			messages.setToaccount(Integer.parseInt(result[2].toString()));
			try {
				messages.setCreattime(DateUtil.parse(String.valueOf(result[3])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			messages.setMoney(Float.parseFloat(String.valueOf(result[4])));
			messages.setMessagetext(result[5].toString());
			messages.setStatus(Integer.parseInt(result[6].toString()));
			list.add(messages);
		}
		if(list.size() > 0)
			System.out.println("Dao:" + list.get(0).getMessageid()+ " " + list.get(0).getFromaccount()+ " " + list.get(0).getToaccount() + " " + list.get(0).getCreattime()+ " " + list.get(0).getMoney() + " " + list.get(0).getMessagetext() + " " + list.get(0).getStatus());
		else
			System.out.println("Dao:没有数据");
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Messages> ShowAllGetMessages(String account) {
		String sql = "SELECT * FROM t_messages WHERE fromaccount = any(SELECT cardnumber FROM t_cards WHERE belongid = ?) AND messagetext = ?";
		String messagetext = "取款";
		String[] parameters = { account, messagetext };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		int index = ls.size();
		ArrayList<Messages> list = new ArrayList();
		for(int i = 0 ; i < index ; i++){
			Object[] result = ls.get(i);
			Messages messages = new Messages();
			messages.setMessageid(Integer.parseInt(result[0].toString()));
			messages.setFromaccount(Integer.parseInt(result[1].toString()));
			messages.setToaccount(Integer.parseInt(result[2].toString()));
			try {
				messages.setCreattime(DateUtil.parse(String.valueOf(result[3])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			messages.setMoney(Float.parseFloat(String.valueOf(result[4])));
			messages.setMessagetext(result[5].toString());
			messages.setStatus(Integer.parseInt(result[6].toString()));
			list.add(messages);
		}
		if(list.size() > 0)
			System.out.println("Dao:" + list.get(0).getMessageid()+ " " + list.get(0).getFromaccount()+ " " + list.get(0).getToaccount() + " " + list.get(0).getCreattime()+ " " + list.get(0).getMoney() + " " + list.get(0).getMessagetext() + " " + list.get(0).getStatus());
	    else
			System.out.println("Dao:没有数据");
	    return list;
	}
	
	public static void main(String[] args) {
		MessagesDao messagesdao = new MessagesDao();
		messagesdao.ShowAllGetMessages("xiaoming");
	}
}