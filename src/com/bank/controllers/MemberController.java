package com.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.domains.CustomerBean;
import com.bank.serviceImpls.MemberServiceImpl;
import com.bank.services.MemberService;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.command.Order;
import com.bank.web.command.Receiver;
import com.bank.web.command.Sender;
import com.bank.web.pool.Constants;


@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void  service(HttpServletRequest request, HttpServletResponse response){
//	protected void  doGet(HttpServletRequest request, HttpServletResponse response){
		//String action = request.getParameter("action");
		//String dest = requeset.getParameter("dest");
//		CustomerBean param =new CustomerBean();
//		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		Receiver.cmd.execute();
//		if(Receiver.cmd.getAction() == null) {
//			Receiver.cmd.setPage();
//		}
//	
//		switch(Receiver.cmd.getAction()) {
//		case"move":
////			request.getParameter("dest");
////			request.getRequestDispatcher
////			(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);
////			cmd.execute(request, response);
//			
//			
//			break;
//		case "join":
//			String id = request.getParameter("id");
//			String pw = request.getParameter("pw");
//			String name = request.getParameter("name");
//			String ssn = request.getParameter("ssn");
//			String credit = request.getParameter("credit");
//
//			param.setCredit(credit);
//			param.setId(id);
//			param.setName(name);
//			param.setPw(pw);
//			param.setSsn(ssn);
//			System.out.println("컨트롤러 조인"+param.toString());
//			service.join(param);
//			System.out.println("컨트롤러 조인gn"+param.toString());
//			//				request.getParameter("action");
////			request.getRequestDispatcher
////			(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);
//			Receiver.cmd.setPage("login");
		
//			break;

//		case "login":
			
//			break;
//		case "existId" : 
//			break;
	
//		}
		Sender.forward(request, response);
	}
	//String action = request.getParameter("action");
	//RequestDispatcher rd =null;
	//		String jspName = "";
	//		switch( request.getParameter("action")) {
	//		case "join": 
	//			jspName = "join";
	////				rd = request.getRequestDispatcher("WEB-INF/views/customer/join.jsp");
	//			break;
	//		case  "login" :  
	//			jspName="login";
	////			rd = request.getRequestDispatcher("WEB-INF/views/customer/login.jsp");
	//			break;
	//		}
	//		RequestDispatcher	rd = request.getRequestDispatcher
	//		 request.getRequestDispatcher
	//				(String.format("WEB-INF/views/customer/%s.jsp", request.getParameter("dest"))).forward(request, response);
	//		rd.forward(request, response);


	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
