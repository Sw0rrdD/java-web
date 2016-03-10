package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginOutServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		res.setCharacterEncoding("UTF-8");// 设置编码
		res.setContentType("text/html");// 服务器响应类型
		PrintWriter out;
		try {
			out = res.getWriter();
			out.print("<script>" + "alert('成功退出！');"
					+ "document.location.href='login.jsp';"
					+ "</script>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
