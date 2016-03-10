package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.action.UsersAction;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	UsersAction usersaction = new UsersAction();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String verificationcode = req.getParameter("verificationcode");
		String ck = req.getParameter("ck");
		HttpSession session = req.getSession();
		String localver = session.getAttribute("code").toString();
		System.out.println("Servlet:" + account + "," + password + "," + verificationcode
				+ "," + ck + "," + localver);
		res.setCharacterEncoding("UTF-8");// 设置编码
		res.setContentType("text/html");// 服务器响应类型
		PrintWriter out;
		try {
			if (!verificationcode.equalsIgnoreCase(localver)) {
				out = res.getWriter();
				out.print("<script>" + "alert('验证码错误！');"
						+ "document.location.href='login.jsp';" + "</script>");
				out.close();
			} else {
				if(usersaction.GetIsonuse(account) > 3){
					out = res.getWriter();
					out.print("<script>" + "alert('此帐号已被禁止登录！');"
							+ "document.location.href='login.jsp';"
							+ "</script>");
					out.close();
				}
				else if (usersaction.Login(account, password) == 1) {
					session.setAttribute("account", account);
					out = res.getWriter();
					out.print("<script>" + "alert('登录成功！');"
							+ "document.location.href='mycard.jsp';"
							+ "</script>");
					out.close();
				} else {
					usersaction.UpdateIsonuse(account);
					out = res.getWriter();
					out.print("<script>" + "alert('用户名或密码错误，登录失败！');"
							+ "document.location.href='login.jsp';"
							+ "</script>");
					out.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}