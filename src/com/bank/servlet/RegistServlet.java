package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.model.Users;
import com.bank.action.UsersAction;

@SuppressWarnings("serial")
public class RegistServlet extends HttpServlet {

	UsersAction usersaction = new UsersAction();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = req.getParameter("name");
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String superpassword = req.getParameter("superpassword");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String money1 = req.getParameter("money");
		float money = Float.valueOf(money1);
		System.out.println(name + "," + account + "," + password + "," + superpassword + ","
				+ money + "," + email + "," + phone + "," + address);
		Users user = new Users();
		user.setAccount(account);
		user.setRealname(name);
		user.setPassword(password);
		user.setSuperpassword(superpassword);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);
		res.setCharacterEncoding("UTF-8");// 设置编码
		res.setContentType("text/html");// 服务器响应类型
		PrintWriter out;
		try {
			if (usersaction.RegistNewUser(user, money) == 1) {
				out = res.getWriter();
				out.print("<script>" + "alert('注册成功！');"
						+ "document.location.href='login.jsp';" + "</script>");
				out.close();
			} else {
				out = res.getWriter();
				out.print("<script>" + "alert('注册失败！');"
						+ "document.location.href='register.jsp';"
						+ "</script>");
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
