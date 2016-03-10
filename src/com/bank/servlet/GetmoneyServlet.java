package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.action.CardAction;
import com.bank.action.MessagesAction;
import com.bank.action.UsersAction;

@SuppressWarnings("serial")
public class GetmoneyServlet extends HttpServlet {
	
	CardAction cardaction = new CardAction();
	UsersAction usersaction = new UsersAction();
	MessagesAction messagesaction = new MessagesAction();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String account = session.getAttribute("account").toString();
		String localver = session.getAttribute("code").toString();
		String verificationcode = req.getParameter("verificationcode");
		String cardnumber = req.getParameter("cardnumber");
		int Cardnumber = Integer.parseInt(cardnumber.substring(9, 17));
		String superpassword = req.getParameter("superpassword");
		String getmoney = req.getParameter("getmoney");
		Float Getmoney = Float.parseFloat(getmoney);
		System.out.println("Servlet: " + cardnumber + " " + superpassword + " " + getmoney);
		res.setCharacterEncoding("UTF-8");// 设置编码
		res.setContentType("text/html");// 服务器响应类型
		PrintWriter out;
		try {
			if(!verificationcode.equalsIgnoreCase(localver)) {
				out = res.getWriter();
				out.print("<script>" + "alert('验证码错误！');"
						+ "document.location.href='login.jsp';" + "</script>");
				out.close();
			}
			else if(usersaction.VerifySuperPassword(account, superpassword)!= 1){
				cardaction.UpdateIsonuse(Cardnumber);
				out = res.getWriter();
				out.print("<script>" + "alert('取款密码错误，请检查后再试！');"
						+ "document.location.href='getmoney.jsp';"
						+ "</script>");
				out.close();
			}
			else if(cardaction.CheckMoney(Cardnumber, Getmoney)!= 1){
				messagesaction.AddGetMessage(Cardnumber, Getmoney, 0);
				out = res.getWriter();
				out.print("<script>" + "alert('余额不足，请检查后再试！');"
						+ "document.location.href='getmoney.jsp';"
						+ "</script>");
				out.close();
			}else{
				if(cardaction.GetMoney(Cardnumber, Getmoney) == 1 ){
					messagesaction.AddGetMessage(Cardnumber, Getmoney, 1);
					out = res.getWriter();
					out.print("<script>" + "alert('取款成功！');"
							+ "document.location.href='messages.jsp';"
							+ "</script>");
					out.close();
				}else{
					messagesaction.AddGetMessage(Cardnumber, Getmoney, 0);
					out = res.getWriter();
					out.print("<script>" + "alert('系统错误，取款失败！');"
							+ "document.location.href='index.jsp';"
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
