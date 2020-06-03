package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.java.exception.AccountNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.AccountBean;
import com.java.model.Account;
import com.java.service.AccountService;


@RestController
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
	public ModelAndView listAccount() {
		System.out.println("ener into  list");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accounts",  prepareListofBean(accountService.listAccounts()));
		return new ModelAndView("accountList", model);
	}

	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
	
	
	private Account prepareModel(AccountBean accountBean){
		System.out.println("prepare");
		Account account=new Account();
		account.setAccount_number(accountBean.getAccount_number());
		account.setAccount_name(accountBean.getAccount_name());
		account.setAccount_type(accountBean.getAccount_type());
		account.setBalance_date(accountBean.getBalance_date());
		account.setCurrency(accountBean.getCurrency());
		account.setOpening_available_balance(accountBean.getOpening_available_balance());
		account.setAccount_id(accountBean.getId());
		return account;
	}
	
	private List<AccountBean> prepareListofBean(List<Account> accounts){
		System.out.println("enter into bean");
		List<AccountBean> beans = null;
		if(accounts != null && !accounts.isEmpty()){
			System.out.println("if loop");
			beans = new ArrayList<AccountBean>();
			AccountBean bean = null;
			for(Account account : accounts){
				bean = new AccountBean();
				bean.setAccount_number(account.getAccount_number());
				bean.setAccount_name(account.getAccount_name());
				bean.setAccount_type(account.getAccount_type());
				bean.setBalance_date(account.getBalance_date());
				bean.setCurrency(account.getCurrency());
				bean.setOpening_available_balance(account.getOpening_available_balance());
				bean.setId(account.getAccount_id());
					beans.add(bean);
			}
		}
		return beans;
	}
	
	private AccountBean prepareAccountBean(Account account){
		System.out.println("enter into account");
		AccountBean bean = new AccountBean();
		bean.setAccount_number(account.getAccount_number());
		bean.setAccount_name(account.getAccount_name());
		bean.setAccount_type(account.getAccount_type());
		bean.setBalance_date(account.getBalance_date());
		bean.setCurrency(account.getCurrency());
		bean.setOpening_available_balance(account.getOpening_available_balance());
		
		bean.setId(account.getAccount_id());
		return bean;
	}
	
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
}
