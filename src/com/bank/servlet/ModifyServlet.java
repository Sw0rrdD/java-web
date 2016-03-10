package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.action.UsersAction;

@SuppressWarnings("serial")
public class ModifyServlet extends HttpServlet{
	
	UsersAction usersaction = new UsersAction();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String account = session.getAttribute("account").toString();
		String oldpassword = req.getParameter("oldpassword");
		String newpassword = req.getParameter("newpassword");
		String oldsuperpassword = req.getParameter("oldsuperpassword");
		String newsuperpassword = req.getParameter("newsuperpassword");
		System.out.println("Servlet: " + account + " " + oldpassword + " " + newpassword + " " + oldsuperpassword + " " + newsuperpassword);
		res.setCharacterEncoding("UTF-8");// 设置编码
		res.setContentType("text/html");// 服务器响应类型
		PrintWriter out;
		try {
			if(usersaction.VerifyPassword(account, oldpassword) != 1){
				out = res.getWriter();
				out.print("<script>" + "alert('原密码错误！');"
						+ "document.location.href='setting.jsp';"
						+ "</script>");
				out.close();
			}else if(usersaction.VerifySuperPassword(account, oldsuperpassword) !=1){
				out = res.getWriter();
				out.print("<script>" + "alert('转账密码错误！');"
						+ "document.location.href='setting.jsp';"
						+ "</script>");
				out.close();
			}else{
				if(usersaction.ModifyPassword(account, newpassword)== 1 && usersaction.ModifySuperPassword(account, newsuperpassword) == 1){
					out = res.getWriter();
					out.print("<script>" + "alert('修改成功，请重新登录！');"
							+ "document.location.href='login.jsp';"
							+ "</script>");
					out.close();
				}else{
					out = res.getWriter();
					out.print("<script>" + "alert('修改失败，系统错误！');"
							+ "document.location.href='setting.jsp';"
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
