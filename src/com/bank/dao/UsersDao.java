package com.bank.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bank.model.Users;
import com.bank.util.SqlHelper;

public class UsersDao {

	SqlHelper sqlhelper = new SqlHelper();

	public int RegistUser(Users user) {
		String sql = "INSERT INTO t_users VALUES(?,?,?,?,null,1,?,?,?)";
		String name = user.getRealname();
		String account = user.getAccount();
		String password = user.getPassword();
		String superpassword = user.getSuperpassword();
		String email = user.getEmail();
		String phone = user.getPhone();
		String address = user.getAddress();
		String[] parameters = { account, password, superpassword, name, email, phone, address};
		return sqlhelper.executeUpdate(sql, parameters);
	}
	
	public int UpdateUser(Users user){
		String sql = "UPDATE t_users SET email = ?,phone = ?,address = ? WHERE account = ?";
		String account = user.getAccount();
		String email = user.getEmail();
		String phone = user.getPhone();
		String address = user.getAddress();
		String[] parameters = { email, phone, address, account};
		return sqlhelper.executeUpdate(sql, parameters);
	}
	
	public Users GetUser(String account){
		String sql = "SELECT realname,email,phone,address FROM t_users WHERE account = ?";
		String[] parameters = { account };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		Users users = new Users();
		Object[] result = ls.get(0);
		users.setRealname(result[0].toString());
		users.setEmail(result[1].toString());
		users.setPhone(result[2].toString());
		users.setAddress(result[3].toString());
		System.out.println("Dao:" + users.getRealname() + " " + users.getEmail() + " " + users.getPhone() + " " + users.getAddress());
		return users;
	}

	public int Login(Users user) {
		String sql = "SELECT * FROM t_users WHERE account = ? AND password = ?";
		String account = user.getAccount();
		String password = user.getPassword();
		String[] parameters = { account, password };
		if (sqlhelper.executeQueryBo(sql, parameters))
			return 1;
		return 0;
	}
	
	public int CheckOnuse(String account){
		String sql = "SELECT isonuse FROM t_users WHERE account = ?";
		String[] parameters = { account };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		Object[] result = ls.get(0);
		int isonuse = Integer.parseInt((result[0].toString()));
		System.out.println(isonuse);
		return isonuse;
	}
		
	public void Forbidden(String account){
		String sql = "UPDATE t_users SET isonuse = isonuse + 1 WHERE account = ?";
		String[] parameters = { account};
		sqlhelper.executeUpdate(sql, parameters);
	}
	
	public void Updatetime(String account){
		String sql = "UPDATE t_users SET lastlogintime = ? WHERE account = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		String nowdate = sdf.format(new Date());
		String[] parameters = { nowdate, account };
		sqlhelper.executeUpdate(sql, parameters);
	}
	
	public String CheckPassword(String account){
		String sql = "SELECT password FROM t_users WHERE account = ?";
		String[] parameters = { account };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		Object[] result = ls.get(0);
		String password = result[0].toString();
		System.out.println("Dao：" + password);
		return password;
	}
	
	public String CheckSuperPassword(String account){
		String sql = "SELECT superpassword FROM t_users WHERE account = ?";
		String[] parameters = { account };
		ArrayList<Object[]> ls = sqlhelper.executeQuery(sql, parameters);
		Object[] result = ls.get(0);
		String superpassword = result[0].toString();
		System.out.println("Dao：" + superpassword);
		return superpassword;
	}
	
	public int ModifyPassword(String account, String password){
		int flag = 0;
		String sql = "UPDATE t_users SET password = ? WHERE account = ?";
		String[] parameters = { password, account};
		flag = sqlhelper.executeUpdate(sql, parameters);
		return flag;
	}
	
	public int ModifySuperPassword(String account, String superpassword){
		int flag = 0;
		String sql = "UPDATE t_users SET superpassword = ? WHERE account = ?";
		String[] parameters = { superpassword, account  };
		flag = sqlhelper.executeUpdate(sql, parameters);
		return flag;
	}
	
	public static void main(String[] args) {
		UsersDao usersdao = new UsersDao();
		usersdao.Forbidden("xiaoming");
	}
}
