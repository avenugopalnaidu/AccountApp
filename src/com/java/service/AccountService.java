package com.java.service;

import java.util.List;

import com.java.model.Account;


public interface AccountService {
	

	public List<Account> listAccounts();
	
	public Account getAccount(int account_id);
	
}
