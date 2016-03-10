package com.bank.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		String pageValue = "Hello This is page";  
		req.setAttribute("pageV", pageValue);  
	}
}
