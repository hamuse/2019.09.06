package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.domains.CustomerBean;
import com.bank.serviceImpls.MemberServiceImpl;
import com.bank.services.MemberService;

public class CreateCommand extends MoveCommand{
	public CreateCommand( HttpServletRequest request) throws Exception {
		super(request);
		
}
	@Override
	public void execute() {
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();

//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String ssn = request.getParameter("ssn");
//		String credit = request.getParameter("credit");

		param.setCredit( request.getParameter("credit"));
		param.setId(request.getParameter("id"));
		param.setName( request.getParameter("name"));
		param.setPw( request.getParameter("pw"));
		param.setSsn(request.getParameter("ssn"));
		service.join(param);

		//				request.getParameter("action");
//		request.getRequestDispatcher
//		(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);
		Receiver.cmd.setPage("login");
	System.out.println("회원가입후 갈 페이지 "+Receiver.cmd.getView());
	}
}
