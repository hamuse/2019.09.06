package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.web.enums.Action;
public class Receiver {
	public static Command cmd = new Command();

	
	public static void init(HttpServletRequest request) {
	  cmd = Commander.order(request);
	  	}

}
