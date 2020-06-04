package com.anz.accountService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anz.accountService.dao.AccountDao;
import com.anz.accountService.model.Account;


@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	
	
	public List<Account> listAccounts() {
		return accountDao.listAccounts();
	}

	public Account getAccount(int account_id) {
		return accountDao.getAccount(account_id);
	}
	
	

}
