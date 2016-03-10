package com.bank.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import com.bank.model.Cards;
import com.bank.util.DateUtil;
import com.bank.util.SqlHelper;

public class CardDao {

	SqlHelper sqlhelper = new SqlHelper();

	public int CreatCard(String account, float money) throws ParseException {
		String sql = "INSERT INTO t_cards(money, belongid, creattime, isonuse) VALUES(?,?,?,1)";
		String Money = String.valueOf(money);		
		String nowdate = DateUtil.formatDate(new Date());
		String[] parameters = {Money, account, nowdate };
		return sqlhelper.executeUpdate(sql, parameters);
	}
	
	public int DelCard(int cardnumber){
		String sql = "DELETE FROM t_cards WHERE cardnumber = ?";
		String Cardnumber = String.valueOf(cardnumber);
		String[] parameters = { Cardnumber };
		return sqlhelper.executeUpdate(sql, parameters);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Cards> ShowAllCard(String account) {
		String sql = "SELECT * FROM t_cards WHERE belongid = ?";
		String[] parameters = { account };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		int index = ls.size();
		ArrayList<Cards> list = new ArrayList();
		for(int i = 0 ; i < index ; i++){
			Object[] result = ls.get(i);
			Cards cards = new Cards();
			cards.setCardnumber(Integer.parseInt(result[0].toString()));
			cards.setMoney(Float.parseFloat(String.valueOf(result[1])));
			cards.setBelongid(String.valueOf(result[2]));			
			try {
				cards.setCreattime(DateUtil.parse(String.valueOf(result[3])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cards.setIsonuse(Integer.parseInt(String.valueOf(result[4])));
			list.add(cards);
		}
		if(list.size() > 0)
			System.out.println("Dao:" + list.get(0).getBelongid() + " " + list.get(0).getCardnumber()+ " " + list.get(0).getMoney()+ " " + list.get(0).getIsonuse()+ " " + list.get(0).getCreattime());
		else
			System.out.println("Dao:没有数据");
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Integer> GetCardlist(String account){
		ArrayList<Integer> list = new ArrayList();
		String sql = "SELECT cardnumber FROM t_cards WHERE belongid = ? AND isonuse < 3";
		String[] parameters = { account };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		int index = ls.size();
		for(int i = 0 ; i < index ; i++){
			Object[] result = ls.get(i);
			list.add(Integer.parseInt(result[0].toString()));
		}
		System.out.println("Dao：" + list.get(0));
		return list;
	}
	
	public float CheckMoney(int cardnumber){
		String sql = "SELECT money FROM t_cards WHERE cardnumber = ?";
		String Cardnumber = String.valueOf(cardnumber);
		String[] parameters = { Cardnumber };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		Object[] result = ls.get(0);
		float money = Float.parseFloat(result[0].toString());
		System.out.println(money);
		return money;
	}
	
	public int CheckOnuse(int cardnumber){
		String sql = "SELECT isonuse FROM t_cards WHERE cardnumber = ?";
		String Cardnumber = String.valueOf(cardnumber);
		String[] parameters = { Cardnumber };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		Object[] result = ls.get(0);
		int isonuse = Integer.parseInt((result[0].toString()));
		System.out.println(isonuse);
		return isonuse;
	}
	
	
	public int getMoney(int cardnumber , float money){
		int flag = 0;
		String sql = "UPDATE t_cards SET money = money - ? WHERE cardnumber = ?";
		String Cardnumber = String.valueOf(cardnumber);
		String Money = String.valueOf(money);
		String[] parameters = { Money, Cardnumber};
		if(sqlhelper.executeUpdate(sql, parameters) == 1)
			flag = 1;
		return flag;
	}
	
	public int inMoney(int cardnumber , float money){
		int flag = 0;
		String sql = "UPDATE t_cards SET money = money + ? WHERE cardnumber = ?";
		String Cardnumber = String.valueOf(cardnumber);
		String Money = String.valueOf(money);
		String[] parameters = { Money, Cardnumber};
		if(sqlhelper.executeUpdate(sql, parameters) == 1)
			flag = 1;
		return flag;
	}
	
	public void Forbidden(int cardnumber){
		String sql = "UPDATE t_cards SET isonuse = isonuse + 1 WHERE cardnumber = ?";
		String Cardnumber = String.valueOf(cardnumber);
		String[] parameters = { Cardnumber };
		sqlhelper.executeUpdate(sql, parameters);
	}
	
	
	public static void main(String[] args) {
		CardDao carddao = new CardDao();
			carddao.ShowAllCard("xiaoming");
//			carddao.Checkmoney(65500002);
//			carddao.CheckOnuse(65500002);
	
	}
}
