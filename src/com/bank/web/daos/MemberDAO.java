package com.bank.web.daos;

import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;

public interface MemberDAO {
	public void insertCustomer(CustomerBean param);
	public void insertEmplotee(EmployeeBean param);
	public CustomerBean login(CustomerBean param);
  
}
