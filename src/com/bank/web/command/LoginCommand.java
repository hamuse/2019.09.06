package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.domains.CustomerBean;
import com.bank.serviceImpls.MemberServiceImpl;
import com.bank.services.MemberService;

public class LoginCommand extends MoveCommand{

		public LoginCommand(HttpServletRequest request)throws Exception {
			super(request);
		
			
			
		}
		@Override
		public void execute() {
		super.execute();
		CustomerBean param =new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id= request.getParameter("id");
		String 	pw = request.getParameter("pw");
		System.out.println("login ¸®Äù½ºÆ®"+id);
		param.setId(id);
		param.setPw(pw);
		CustomerBean cust = service.login(param);
		System.out.println("login"+cust.toString());
		String page = "";
	
			 if(cust == null) {
		//			if(param.getId().equals(st.getId()) && param.getPw().equals(st.getPw())) {
//			request.setAttribute("customer", st);
//			request.getRequestDispatcher(String.format
//					(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
//		Receiver.cmd.setPage("login");
				 page ="login";
//			Receiver.cmd.setPage("mypage");
		}else {
//			request.getRequestDispatcher(String.format
//					(Constants.VIEW_PATH,"customer",request.getParameter("action"))).forward(request, response);
//			Receiver.cmd.setPage("mypage");
//			Receiver.cmd.setPage("login");
			page = "mypage";
		}
		request.setAttribute("customer", cust);
		Receiver.cmd.setPage(page);
		}
}
