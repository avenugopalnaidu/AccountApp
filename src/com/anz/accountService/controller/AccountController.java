package com.anz.accountService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anz.accountService.bean.AccountBean;
import com.anz.accountService.exception.AccountNotFoundException;
import com.anz.accountService.model.Account;
import com.anz.accountService.service.AccountService;

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


@RestController
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
 AccountService accountService;
	
	@Test
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
	public ModelAndView listAccount() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accounts",  prepareListofBean(accountService.listAccounts()));
		return new ModelAndView("accountList", model);
	}

	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
	
	@Test
	public Account prepareModel(AccountBean accountBean){
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
	
	@Test
	public List<AccountBean> prepareListofBean(List<Account> accounts){
		List<AccountBean> beans = null;
		if(accounts != null && !accounts.isEmpty()){
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
	
	@Test
	public AccountBean prepareAccountBean(Account account){
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
	public ModelAndView handleAccountNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
}
