package com.bank.action;

import java.text.ParseException;

import com.bank.dao.CardDao;
import com.bank.dao.UsersDao;
import com.bank.model.Users;
import com.bank.util.MD5Util;

public class UsersAction {

UsersDao usersdao = new UsersDao();
CardDao carddao = new CardDao();
	
	public int RegistNewUser(Users user, float money){
		int flag = 0;
		user.setPassword(MD5Util.md5(user.getPassword()));
		user.setSuperpassword(MD5Util.generate(user.getSuperpassword()));
		flag = usersdao.RegistUser(user);
		if(flag == 1)
			try {
				flag = carddao.CreatCard(user.getAccount(), money);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return flag;
	}
	
	public int UpdateUser(String account, String email, String phone, String address){
		Users users = new Users();
		users.setAccount(account);
		users.setEmail(email);
		users.setPhone(phone);
		users.setAddress(address);
		if(usersdao.UpdateUser(users) == 1){
			return 1;
		}
		return 0;
	}
	
	public int GetIsonuse(String account){
		return usersdao.CheckOnuse(account);
	}
	
	public void UpdateIsonuse(String account){
		usersdao.Forbidden(account);
	}
	
	public int Login(String account, String password){
		Users user = new Users();
		user.setAccount(account);
		user.setPassword(MD5Util.md5(password));
		if(usersdao.Login(user) == 1){
			usersdao.Updatetime(account);
			return 1;
		}
		return 0;
	}
	
	public int VerifySuperPassword(String account, String superpassword){
		String MD5superpassword = usersdao.CheckSuperPassword(account);
		if(MD5Util.verify(superpassword, MD5superpassword))
			return 1;
		return 0;
	}
	
	public int VerifyPassword(String account, String password){
		String MD5password = usersdao.CheckPassword(account);
		if(MD5Util.md5(password).equalsIgnoreCase(MD5password)){
			return 1;
		}
		return 0;
	}
	
	public int ModifyPassword(String account, String password){
		String MD5password = MD5Util.md5(password);
		if(usersdao.ModifyPassword(account, MD5password) == 1)
			return 1;
		return 0;
	}
	
	public int ModifySuperPassword(String account, String superpassword){
		String MD5superpassword = MD5Util.generate(superpassword);
		if(usersdao.ModifySuperPassword(account, MD5superpassword) == 1)
			return 1;
		return 0;
		
	}
}
