package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.action.CardAction;

@SuppressWarnings("serial")
public class NewCardServlet extends HttpServlet{

	CardAction cardaction = new CardAction();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
	HttpSession session = req.getSession();
	String account = session.getAttribute("account").toString();
	String money1 = req.getParameter("money");
	float money = Float.valueOf(money1);
	System.out.println(account + "," + money);
	res.setCharacterEncoding("UTF-8");// 设置编码
	res.setContentType("text/html");// 服务器响应类型
	PrintWriter out;
	try {
		if (cardaction.CreatCard(account, money) == 1) {
			out = res.getWriter();
			out.print("<script>" + "alert('创建成功！');"
					+ "document.location.href='mycard.jsp';" + "</script>");
			out.close();
		} else {
			out = res.getWriter();
			out.print("<script>" + "alert('创建失败！');"
					+ "document.location.href='mycard.jsp';"
					+ "</script>");
			out.close();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
