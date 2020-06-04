package com.anz.accountService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.anz.accountService.bean.TransactionBean;
import com.anz.accountService.exception.AccountNotFoundException;
import com.anz.accountService.exception.TransactionNotFoundException;
import com.anz.accountService.model.Transaction;
import com.anz.accountService.service.TransactionService;;

@RestController
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	TransactionService accountTransactionService;
	
	@Test
	@RequestMapping(value="/transaction", method = RequestMethod.GET)
	public ModelAndView listTransaction() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accounts",  prepareListofBean(accountTransactionService.listAccountTransaction()));
		return new ModelAndView("transactionList", model);
		
	}
	@Test
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@Test
	public Transaction prepareModel(TransactionBean accountBean){
		Transaction account=new Transaction();
		account.setAccount_number(accountBean.getAccount_number());
		account.setAccount_name(accountBean.getAccount_name());
		account.setValue_date(accountBean.getValue_date());
		account.setCurrency(accountBean.getCurrency());
		
		account.setCredit_ammount(accountBean.getCredit_ammount());
		account.setDebit_ammount(accountBean.getDebit_ammount());
		account.setDebitcredit(accountBean.getDebitcredit());
		account.setTransaction_narrative(accountBean.getTransaction_narrative());
		account.setId(accountBean.getId());
		return account;
	}
	
	@Test
	public List<TransactionBean> prepareListofBean(List<Transaction> accounts){
		List<TransactionBean> beans = null;
		if(accounts != null && !accounts.isEmpty()){
			System.out.println("if loop");
			beans = new ArrayList<TransactionBean>();
			TransactionBean bean = null;
			for(Transaction account : accounts){
				bean = new TransactionBean();
				bean.setAccount_number(account.getAccount_number());
				bean.setAccount_name(account.getAccount_name());
				bean.setValue_date(account.getValue_date());
				bean.setCurrency(account.getCurrency());
				bean.setCredit_ammount(account.getCredit_ammount());
				bean.setDebit_ammount(account.getDebit_ammount());
				bean.setDebitcredit(account.getDebitcredit());
				bean.setTransaction_narrative(account.getTransaction_narrative());
				bean.setId(account.getId());
					beans.add(bean);
			}
		}
		return beans;
	}
	
	@Test
	public TransactionBean prepareAccountBean(Transaction account){
		TransactionBean bean = new TransactionBean();
		bean.setAccount_number(account.getAccount_number());
		bean.setAccount_name(account.getAccount_name());
		bean.setValue_date(account.getValue_date());
		bean.setCurrency(account.getCurrency());
		bean.setCredit_ammount(account.getCredit_ammount());
		bean.setDebit_ammount(account.getDebit_ammount());
		bean.setDebitcredit(account.getDebitcredit());
		bean.setTransaction_narrative(account.getTransaction_narrative());
		bean.setId(account.getId());
		return bean;
	}
	
	@ExceptionHandler(TransactionNotFoundException.class)
	public ModelAndView handleTransactionNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
}

