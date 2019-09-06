package com.bank.serviceImpls;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bank.domains.AccountBean;
import com.bank.services.AccountService;

public class AccountServiceImpl implements AccountService{
	private List<AccountBean> beans;	
	
	public AccountServiceImpl() {
		beans = new ArrayList<>();
	}
	
	@Override
	public void createAccount(int money) {
		AccountBean bean = new AccountBean();
		bean.setMoney(String.valueOf(money));
		bean.setAccountNum(createAccountNum());
		bean.setRegDate( findDate());
		System.out.println(bean.toString());
		beans.add(bean);
		
		 
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		Random ran = new Random();
		for(int i = 0; i < 9 ; i++) {
			accountNum += (i == 4) ? "-" : ran.nextInt(10);
		}
		return accountNum;
	}

	@Override
	public List<AccountBean> findAll() {
	
		return beans;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean bean = new AccountBean();
		for(AccountBean ab : beans) {
			if(accountNum.equals(ab.getAccountNum())) {
				bean = ab;
				break;
			}
			
		}
		return bean;
	}

	@Override
	public int countAccounts() {
		return beans.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		return beans.contains(findByAccountNum(accountNum));
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(0));
	}

	@Override
	public void depositMoney(AccountBean param) {
		AccountBean bn = new AccountBean();
		int money =0;
		for(AccountBean b : beans) {
			if(param.getAccountNum().equals(b.getAccountNum())) {
			money = Integer.parseInt(b.getMoney()) + Integer.parseInt(param.getMoney()); 
			 bn.setMoney(String.valueOf(money));
			 bn.setRegDate( findDate());
			 beans.add(bn);
			}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		AccountBean bn = new AccountBean();
		int money =0;
		for(AccountBean b : beans) {
			if(param.getAccountNum().equals(b.getAccountNum())) {
			money = Integer.parseInt(b.getMoney()) - Integer.parseInt(param.getMoney());
			 bn.setMoney(String.valueOf(money));
			 bn.setRegDate( findDate());
			beans.add(bn);
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		beans.remove(findByAccountNum(accountNum));
		return ;
	}

}
