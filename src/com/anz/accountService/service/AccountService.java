package com.anz.accountService.service;

import java.util.List;

import com.anz.accountService.model.Account;


public interface AccountService {
	

	public List<Account> listAccounts();
	
	public Account getAccount(int account_id);
	
}
