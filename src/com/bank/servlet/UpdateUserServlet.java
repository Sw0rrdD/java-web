package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.action.UsersAction;

@SuppressWarnings("serial")
public class UpdateUserServlet extends HttpServlet{
	
	UsersAction usersaction = new UsersAction();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String account = session.getAttribute("account").toString();
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		System.out.println("Servlet: " + account + " " + email + " " + phone + " " + address);
		res.setCharacterEncoding("UTF-8");// 设置编码
		res.setContentType("text/html");// 服务器响应类型
		PrintWriter out;
		try {		
				if(usersaction.UpdateUser(account, email, phone, address) == 1 ){
					out = res.getWriter();
					out.print("<script>" + "alert('更新成功！');"
							+ "document.location.href='showuser.jsp';"
							+ "</script>");
					out.close();
				}else{
					out = res.getWriter();
					out.print("<script>" + "alert('更新失败，系统错误！');"
							+ "document.location.href='updateuser.jsp';"
							+ "</script>");
					out.close();
				}					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
