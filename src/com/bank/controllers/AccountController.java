package com.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.serviceImpls.AccountServiceImpl;
import com.bank.services.AccountService;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/account.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("어카운트 테스트중");
		String money =request.getParameter("money"); 
		AccountService ac = new AccountServiceImpl();
		//ac.createAccount(Integer.parseInt(money));
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/account/account.jsp");
		rd.forward(request, response);
		System.out.println(money);
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
