package com.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ban.web.command.Sender;
import com.ban.web.command.Command;
import com.ban.web.command.MoveCommand;
import com.ban.web.command.Order;
import com.ban.web.command.Receiver;
import com.bank.domains.CustomerBean;
import com.bank.serviceImpls.MemberServiceImpl;
import com.bank.services.MemberService;
import com.bank.web.pool.Constants;


@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		//String action = request.getParameter("action");
		//String dest = requeset.getParameter("dest");
		CustomerBean param =new CustomerBean();
		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction() == null) {
			Receiver.cmd.setPage();
		}
	
		switch(Receiver.cmd.getAction()) {
//		case"move":
////			request.getParameter("dest");
////			request.getRequestDispatcher
////			(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);
////			cmd.execute(request, response);
//			
//			
//			break;
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");

			param.setCredit(credit);
			param.setId(id);
			param.setName(name);
			param.setPw(pw);
			param.setSsn(ssn);
			System.out.println("컨트롤러 조인"+param.toString());
			service.join(param);
			System.out.println("컨트롤러 조인gn"+param.toString());
			//				request.getParameter("action");
//			request.getRequestDispatcher
//			(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);
			Receiver.cmd.setPage("login");
			break;

		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			System.out.println("login 리퀘스트"+id);
			param.setId(id);
			param.setPw(pw);
			CustomerBean cust = service.login(param);
			System.out.println("login"+cust.toString());
			if(cust == null) {
			//			if(param.getId().equals(st.getId()) && param.getPw().equals(st.getPw())) {
//				request.setAttribute("customer", st);
//				request.getRequestDispatcher(String.format
//						(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
				Receiver.cmd.setPage("login");
			}else {
//				request.getRequestDispatcher(String.format
//						(Constants.VIEW_PATH,"customer",request.getParameter("action"))).forward(request, response);
				Receiver.cmd.setPage("mypage");
			}
			request.setAttribute("customer", cust);
			break;
		case "existId" : 
			break;
	
		}
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
