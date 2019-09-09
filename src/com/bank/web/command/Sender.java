package com.bank.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.pool.Constants;

public class Sender {//안에 내용물에 상관없이 클레스니 클레스 객체이다. 
	public static void forward( HttpServletRequest request,HttpServletResponse response) {
		try {
			request.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
